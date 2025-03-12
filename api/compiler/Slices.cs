using Antlr4.Runtime;

public static class Slices
{
    public static ValueWrapper GetIndexedValue(ValueWrapper value, int index, ParserRuleContext context)
    {
        return value switch
        {
            SliceValue<int> intSlice => new IntValue(intSlice.Values[index]),
            SliceValue<double> floatSlice => new FloatValue(floatSlice.Values[index]),
            SliceValue<string> stringSlice => new StringValue(stringSlice.Values[index]),
            SliceValue<bool> boolSlice => new BoolValue(boolSlice.Values[index]),
            SliceValue<char> runeSlice => new RuneValue(runeSlice.Values[index]),
            SliceValue<ValueWrapper> slice => slice.Values[index],
            _ => throw new SemanticError("Invalid slice type", context.Start)
        };
    }
}