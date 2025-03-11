using analyzer;

public class LanguageClass : Invocable 
{
    public string Name { get; set; }
    public Dictionary<string, LanguageParser.VarDclContext> Props { get; set; }
    public Dictionary<string, ForeignFunction> Methods { get; set; }



    public LanguageClass(string name
        , Dictionary<string, LanguageParser.VarDclContext> props
        , Dictionary<string, ForeignFunction> methods) {
        Name = name;
        Props = props;
        Methods = methods;
    }

    public ForeignFunction? GetMethod(string name) {
        if (Methods.ContainsKey(name)) {
            return Methods[name];
        }
        return null;
    }

    public int Arity() {
        var constructor = GetMethod("constructor");
        if (constructor != null) {
            return constructor.Arity();
        }
        return 0;
    }

    public ValueWrapper Invoke(List<ValueWrapper> args, CompilerVisitor visitor) {
        var newInstance = new Instance(this);

        //Valores por defecto
        foreach (var prop in Props) {
            var name = prop.Key;
            var value = prop.Value;

            if(value.expr() != null) {
                var varValue = visitor.Visit(value.expr());
                newInstance.Set(name, varValue);
            } else {
                newInstance.Set(name, visitor.defaultValue);
            }
        }
        var constructor = GetMethod("constructor");
        if (constructor != null) {
            constructor.Bind(newInstance).Invoke(args, visitor);
        }
        return new InstanceValue(newInstance);
    }

   


}