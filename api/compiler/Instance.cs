public class Instance 
{
    private LanguageClass languageClass;
    private Dictionary<string, ValueWrapper> Properties;

    public Instance(LanguageClass languageClass) 
    {
        this.languageClass = languageClass;
        Properties = new Dictionary<string, ValueWrapper>();
    }

    public void Set(string name, ValueWrapper value) 
    {
        Properties[name] = value;
    }

    public ValueWrapper Get(string name, Antlr4.Runtime.IToken token)
    {
        if (Properties.ContainsKey(name)) 
        {
            return Properties[name];
        }
        var method = languageClass.GetMethod(name);
        if (method != null) 
        {
            return new FunctionValue(method.Bind(this), name);
        }
        throw new SemanticError("Property " + name + " not found", token);
    }
}