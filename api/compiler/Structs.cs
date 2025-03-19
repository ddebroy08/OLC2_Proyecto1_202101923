using System;
using System.Collections.Generic;
using Antlr4.Runtime;

public static class Structs
{
    private static readonly Dictionary<string, StructDefinition> StructRegistry = new();

    public static void SetStruct(string name, StructDefinition structDefinition, IToken token)
    {
        if (StructRegistry.ContainsKey(name))
        {
            throw new SemanticError($"Struct '{name}' is already declared", token);
        }

        StructRegistry[name] = structDefinition;
    }

    public static StructDefinition GetStruct(string name, IToken token)
    {
        if (!StructRegistry.ContainsKey(name))
        {
            throw new SemanticError($"Struct '{name}' is not declared", token);
        }

        return StructRegistry[name];
    }

    public static StructInstance CreateStructInstance(string name, IToken token)
    {
        var structDefinition = GetStruct(name, token);
        return new StructInstance(structDefinition, token);
    }
}

public class StructDefinition
{
    public string StructName { get; }
    public Dictionary<string, Type> Attributes { get; }

    public StructDefinition(string name, Dictionary<string, Type> attributes)
    {
        StructName = name;
        Attributes = attributes;
    }
}

public class StructInstance
{
    private readonly StructDefinition _structDefinition;
    private readonly Dictionary<string, ValueWrapper> _attributes = new();

    public StructInstance(StructDefinition structDefinition, IToken token)
    {
        _structDefinition = structDefinition;

        foreach (var attribute in structDefinition.Attributes)
        {
            _attributes[attribute.Key] = GetDefaultValue(attribute.Value, token);
        }
    }

    public bool HasAttribute(string name) => _attributes.ContainsKey(name);

    public ValueWrapper GetStructAttribute(string name, IToken token)
    {
        if (!HasAttribute(name))
        {
            throw new SemanticError($"Attribute '{name}' does not exist in struct '{_structDefinition.StructName}'", token);
        }

        return _attributes[name];
    }

    public void SetStructAttribute(string name, ValueWrapper value, IToken token)
    {
        if (!HasAttribute(name))
        {
            throw new SemanticError($"Attribute '{name}' does not exist in struct '{_structDefinition.StructName}'", token);
        }

        var expectedType = _structDefinition.Attributes[name];
        if (!IsValidType(value, expectedType))
        {
            throw new SemanticError($"Type mismatch for attribute '{name}' in struct '{_structDefinition.StructName}'", token);
        }

        _attributes[name] = value;
    }

    private static ValueWrapper GetDefaultValue(Type type, IToken token)
    {
        return type switch
        {
            Type t when t == typeof(int) => new IntValue(0),
            Type t when t == typeof(double) => new FloatValue(0.0),
            Type t when t == typeof(string) => new StringValue(""),
            Type t when t == typeof(bool) => new BoolValue(false),
            Type t when t == typeof(char) => new RuneValue('\0'),
            _ => throw new SemanticError($"Unsupported attribute type: {type}", token)
        };
    }

    private static bool IsValidType(ValueWrapper value, Type expectedType)
    {
        return value switch
        {
            IntValue when expectedType == typeof(int) => true,
            FloatValue when expectedType == typeof(double) => true,
            StringValue when expectedType == typeof(string) => true,
            BoolValue when expectedType == typeof(bool) => true,
            RuneValue when expectedType == typeof(char) => true,
            _ => false
        };
    }
}