public class Environment
{

    public Dictionary<string, ValueWrapper> variables = new Dictionary<string, ValueWrapper>();
    // TODO: parent environment
    private Environment? parent;

    public Environment(Environment? parent)
    {
        this.parent = parent;
    }

    public ValueWrapper Get(string id, Antlr4.Runtime.IToken token)
    {
        if (variables.ContainsKey(id))
        {
            Console.WriteLine($"Obteniendo variable '{id}' como {variables[id].GetType()}");
            return variables[id];
        }
        if (parent != null)
        {
            Console.WriteLine($"Buscando variable '{id}' en el entorno padre.");
            return parent.Get(id, token);
        }

        throw new SemanticError("Variable " + id + " not found", token);
    }

    public void Declare(string id, ValueWrapper value, Antlr4.Runtime.IToken? token){
        if (variables.ContainsKey(id)) {
            if (token != null) throw new SemanticError("Variable " + id + " already declared", token);
        } else {
            Console.WriteLine($"Declarando variable '{id}' como {value.GetType()} en el entorno actual.");
            variables[id] = value;
        }
    }

    public ValueWrapper Assign(string id, ValueWrapper value, Antlr4.Runtime.IToken token) {
        if(variables.ContainsKey(id)){
            Console.WriteLine($"Asignando a variable '{id}' el valor de tipo {value.GetType()}");
            variables[id] = value;
            return value;
        } if (parent != null) {
            Console.WriteLine($"Buscando variable '{id}' para asignar en el entorno padre.");
            return parent.Assign(id, value, token);
        }
        throw new SemanticError("Variable " + id + " not found", token);
    }

    public bool Contains(string name)
    {
        return variables.ContainsKey(name); 
    }

        public bool ExistsInCurrentScope(string id)
    {
        return variables.ContainsKey(id);
    }

}