
public abstract record ValueWrapper;


public record IntValue (int Value) : ValueWrapper;

public record FloatValue (double Value) : ValueWrapper;
public record StringValue (string Value) : ValueWrapper;

public record BoolValue (bool Value) : ValueWrapper;
public record RuneValue (char Value) : ValueWrapper;

public record FunctionValue(Invocable invocable, string name) : ValueWrapper;

public record InstanceValue(Instance instance) : ValueWrapper;

public record ClassValue(LanguageClass languageClass) : ValueWrapper;

public record SliceValue<T>(List<T> Values) : ValueWrapper;

public record VoidValue : ValueWrapper;

