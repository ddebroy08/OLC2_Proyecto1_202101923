
using analyzer;

public class CompilerVisitor : LanguageBaseVisitor<ValueWrapper>
{

    private ValueWrapper defaultValue = new VoidValue();
    public string output = "";
    private Environment currentEnvironment = new Environment(null);

    // VisitProgram
    public override ValueWrapper VisitProgram(LanguageParser.ProgramContext context)
    {
        foreach (var dcl in context.dcl())
        {
            Visit(dcl);
        }
        return defaultValue;
    }

    // VisitVarDcl
    public override ValueWrapper VisitVarDcl(LanguageParser.VarDclContext context)
    {
        string id = context.ID().GetText();
        string type = context.Types().GetText(); // Obtener el tipo declarado
        ValueWrapper value = Visit(context.expr());

        // Validar el tipo
        if (!IsValidType(value, type))
        {
            throw new Exception($"Type mismatch: cannot assign value of type {value.GetType().Name} to variable {id} of type {type}");
        }

        currentEnvironment.DeclareVariable(id, value);
        return defaultValue;
    }

    // Validar tipos de datos
    private bool IsValidType(ValueWrapper value, string declaredType)
    {
        return declaredType switch
        {
            "int" => value is IntValue,
            "float64" => value is FloatValue,
            "string" => value is StringValue,
            "bool" => value is BoolValue,
            "rune" => value is RuneValue, //'rune' se maneja como un char
            _ => false // Tipo no reconocido
        };
    }

    // VisitExprStmt
    public override ValueWrapper VisitExprStmt(LanguageParser.ExprStmtContext context)
    {
        return Visit(context.expr());
    }

    // VisitPrValueWrapperStmt
    public override ValueWrapper VisitPrintStmt(LanguageParser.PrintStmtContext context)
    {
        ValueWrapper value = Visit(context.expr());
        //output += value + "\n";
        output += value switch {
            IntValue i => i.Value.ToString(),
            FloatValue f => f.Value.ToString(),
            StringValue s => s.Value,
            BoolValue b => b.Value.ToString(),
            RuneValue r => ((int)r.Value).ToString(),
            VoidValue v => "void",
            _ => throw new Exception("Invalid operation")
        };
        output += "\n";
        return defaultValue;
    }

    // VisitIdentifier
    public override ValueWrapper VisitIdentifier(LanguageParser.IdentifierContext context)
    {
        string id = context.ID().GetText();
        return currentEnvironment.GetVariable(id);
    }

    // VisitParens
    public override ValueWrapper VisitParens(LanguageParser.ParensContext context)
    {
        return Visit(context.expr());
    }

    // VisitNegate
    public override ValueWrapper VisitNegate(LanguageParser.NegateContext context)
    {
        ValueWrapper value = Visit(context.expr());
        return value switch {
            IntValue i => new IntValue(-i.Value),
            FloatValue f => new FloatValue(-f.Value),
            _ => throw new Exception("Invalid operation")
        };
    }

    // VisitNumber
    public override ValueWrapper VisitInt(LanguageParser.IntContext context)
    {
        return new IntValue(int.Parse(context.INT().GetText()));
    }

    // VisitMulDiv
    public override ValueWrapper VisitMulDiv(LanguageParser.MulDivContext context)
    {
        ValueWrapper left = Visit(context.expr(0));
        ValueWrapper right = Visit(context.expr(1));
        var op = context.op.Text;

        return (left, right, op) switch {
            (IntValue l, IntValue r, "*") => new IntValue(l.Value * r.Value),
            (IntValue l, IntValue r, "/") => new IntValue(l.Value / r.Value),
            (FloatValue l, FloatValue r, "*") => new FloatValue(l.Value * r.Value),
            (FloatValue l, FloatValue r, "/") => new FloatValue(l.Value / r.Value),
            _ => throw new Exception("Invalid operation")
        };

    }

    // VisitAddSub
    public override ValueWrapper VisitAddSub(LanguageParser.AddSubContext context)
    {
        ValueWrapper left = Visit(context.GetChild(0));
        ValueWrapper right = Visit(context.expr(1));

        var op = context.op.Text;
        return (left, right, op) switch {
            (IntValue l, IntValue r, "+") => new IntValue(l.Value + r.Value),
            (IntValue l, IntValue r, "-") => new IntValue(l.Value - r.Value),
            (FloatValue l, FloatValue r, "+") => new FloatValue(l.Value + r.Value),
            (FloatValue l, FloatValue r, "-") => new FloatValue(l.Value - r.Value),
            (StringValue l, StringValue r, "+") => new StringValue(l.Value + r.Value),
            (IntValue l, StringValue r, "+") => new StringValue(l.Value.ToString() + r.Value),
            (StringValue l, IntValue r, "+") => new StringValue(l.Value + r.Value.ToString()),
            _ => throw new Exception("Invalid operation")
        };
    }


    //VisitFloat
    public override ValueWrapper VisitFloat(LanguageParser.FloatContext context) {
        return new FloatValue(float.Parse(context.FLOAT().GetText()));
    }

    //VisitRelational
    public override ValueWrapper VisitRelational(LanguageParser.RelationalContext context) {
        ValueWrapper left = Visit(context.expr(0));
        ValueWrapper right = Visit(context.expr(1));
        var op = context.op.Text;

        return (left, right, op) switch {
            (IntValue l, IntValue r, "<") => new BoolValue(l.Value < r.Value),
            (IntValue l, IntValue r, ">") => new BoolValue(l.Value > r.Value),
            (IntValue l, IntValue r, "<=") => new BoolValue(l.Value <= r.Value),
            (IntValue l, IntValue r, ">=") => new BoolValue(l.Value >= r.Value),
            (FloatValue l, FloatValue r, "<") => new BoolValue(l.Value < r.Value),
            (FloatValue l, FloatValue r, ">") => new BoolValue(l.Value > r.Value),
            (FloatValue l, FloatValue r, "<=") => new BoolValue(l.Value <= r.Value),
            (FloatValue l, FloatValue r, ">=") => new BoolValue(l.Value >= r.Value),
            _ => throw new Exception("Invalid operation")
        };
    }
    //VisitAssign
    public override ValueWrapper VisitAssign(LanguageParser.AssignContext context) {
        string id = context.ID().GetText();
        ValueWrapper value = Visit(context.expr());
        currentEnvironment.AssignVariable(id, value);
        return defaultValue;
    }
    //VisitEqualitys

        public override ValueWrapper VisitEqualitys(LanguageParser.EqualitysContext context) {
        ValueWrapper left = Visit(context.expr(0));
        ValueWrapper right = Visit(context.expr(1));
        var op = context.op.Text;

        return (left, right, op) switch {
            (IntValue l, IntValue r, "==") => new BoolValue(l.Value == r.Value),
            (IntValue l, IntValue r, "!=") => new BoolValue(l.Value != r.Value),
            (FloatValue l, IntValue r, "==") => new BoolValue(l.Value == r.Value),
            (FloatValue l, IntValue r, "!=") => new BoolValue(l.Value != r.Value),
            (IntValue l, FloatValue r, "==") => new BoolValue(l.Value == r.Value),
            (IntValue l, FloatValue r, "!=") => new BoolValue(l.Value != r.Value),
            (FloatValue l, FloatValue r, "==") => new BoolValue(l.Value == r.Value),
            (FloatValue l, FloatValue r, "!=") => new BoolValue(l.Value != r.Value),
            (StringValue l, StringValue r, "==") => new BoolValue(l.Value == r.Value),
            (StringValue l, StringValue r, "!=") => new BoolValue(l.Value != r.Value),
            (BoolValue l, BoolValue r, "==") => new BoolValue(l.Value == r.Value),
            (BoolValue l, BoolValue r, "!=") => new BoolValue(l.Value != r.Value),
            _ => throw new Exception("Invalid operation")
        };
    }


    //VisitBoolean
    public override ValueWrapper VisitBoolean(LanguageParser.BooleanContext context) {
        // Obtiene el texto del valor booleano (true o false)
        string boolValue = context.BOOL().GetText();
        
        // Retorna un BoolValue basado en el texto
        return new BoolValue(boolValue.Equals("true", StringComparison.OrdinalIgnoreCase));
    }


    //VisitString
    public override ValueWrapper VisitString(LanguageParser.StringContext context) {
        string text = context.STRING().GetText();
        text = text.Replace("\"", "");
        return new StringValue(text);
    }

    //VisitRune
public override ValueWrapper VisitRune(LanguageParser.RuneContext context) {
    string text = context.RUNE().GetText();
    if (text.Length != 3) {
        throw new Exception("Invalid rune");
    } 
    // Acceder directamente al carácter, sabiendo que es 'x'
    char rune = text[1]; // Esto es correcto si text es de longitud 3.
    return new RuneValue(rune);
}


    //VisitBlockStmt
    public override ValueWrapper VisitBlockStmt(LanguageParser.BlockStmtContext context) {
        Environment previousEnvironment = currentEnvironment;
        currentEnvironment = new Environment(previousEnvironment);
        foreach (var stmt in context.dcl()) {
            Visit(stmt);
        }
        currentEnvironment = previousEnvironment;
        return defaultValue;
    }

    //VisitIfStmt
    public override ValueWrapper VisitIfStmt(LanguageParser.IfStmtContext context) {
        ValueWrapper condition = Visit(context.expr());
        if (condition is not BoolValue) {
            throw new Exception("Invalid condition");
        }
        if ((condition as BoolValue).Value) {
            Visit(context.stmt(0));
        } else if (context.stmt().Length > 1) {
            Visit(context.stmt(1));
        }
        return defaultValue;
    }
}

