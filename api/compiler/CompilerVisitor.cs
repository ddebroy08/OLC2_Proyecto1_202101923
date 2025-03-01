
using System.Globalization;
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
        ValueWrapper value;

        if(context.expr() != null)
        {
            value = Visit(context.expr());
        }
        else
        {
            // Inicializar con un valor por defecto
            value = type switch
            {
                "int" => new IntValue(0),
                "float64" => new FloatValue(0),
                "string" => new StringValue(""),
                "bool" => new BoolValue(false),
                "rune" => new RuneValue('x'),
                _ => throw new SemanticError("Invalid type", context.Start)
            };
        }
        // Validar el tipo
        if (!IsValidType(value, type))
        {
            throw new SemanticError($"Type mismatch: cannot assign value of type {value.GetType().Name} to variable {id} of type {type}", context.Start);
        }

        currentEnvironment.DeclareVariable(id, value, context.Start);
        return defaultValue;
    }

    //VisitShortVarDcl
    public override ValueWrapper VisitShortVarDcl(LanguageParser.ShortVarDclContext context) {
        string id = context.ID().GetText();
        ValueWrapper value = Visit(context.expr());
        currentEnvironment.DeclareVariable(id, value, context.Start);
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
            FloatValue f => f.Value.ToString("G", CultureInfo.InvariantCulture),
            StringValue s => s.Value,
            BoolValue b => b.Value.ToString(),
            RuneValue r => ((int)r.Value).ToString(),
            VoidValue v => "void",
            _ => throw new SemanticError("Invalid operation", context.Start)
        };
        output += "\n";
        return defaultValue;
    }

    // VisitIdentifier
    public override ValueWrapper VisitIdentifier(LanguageParser.IdentifierContext context)
    {
        string id = context.ID().GetText();
        return currentEnvironment.GetVariable(id, context.Start);
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
            _ => throw new SemanticError("Invalid operation", context.Start)
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

        if (op == "/" && ((right is IntValue i && i.Value == 0) || (right is FloatValue f && f.Value == 0.0)))
    {
        Console.WriteLine("Warning: Division by zero detected. Returning default value.");
        return op == "/" ? new FloatValue(float.PositiveInfinity) : new IntValue(0); 
    }

        return (left, right, op) switch {
            // MULTIPLICACIÓN
            (IntValue l, IntValue r, "*") => new IntValue(l.Value * r.Value), // int * int = int
            (FloatValue l, FloatValue r, "*") => new FloatValue(l.Value * r.Value), // float * float = float
            (IntValue l, FloatValue r, "*") => new FloatValue((float)l.Value * r.Value), // int * float = float
            (FloatValue l, IntValue r, "*") => new FloatValue(l.Value * (float)r.Value), // float * int = float
            // DIVISIÓN
            (IntValue l, IntValue r, "/") => new IntValue(l.Value / r.Value), // int / int = int
            (FloatValue l, FloatValue r, "/") => new FloatValue(l.Value / r.Value), // float / float = float
            (IntValue l, FloatValue r, "/") => new FloatValue((float)l.Value / r.Value), // int / float = float
            (FloatValue l, IntValue r, "/") => new FloatValue(l.Value / (float)r.Value), // float / int = float
            (IntValue l, IntValue r, "%") => new IntValue(l.Value % r.Value), // int % int = int
            _ => throw new SemanticError("Invalid operation", context.Start)
        };

    }

    // VisitAddSub
    public override ValueWrapper VisitAddSub(LanguageParser.AddSubContext context)
    {
        ValueWrapper left = Visit(context.GetChild(0));
        ValueWrapper right = Visit(context.expr(1));

        var op = context.op.Text;
        return (left, right, op) switch {
            (IntValue l, IntValue r, "+") => new IntValue(l.Value + r.Value), // int + int = int
            (IntValue l, IntValue r, "-") => new IntValue(l.Value - r.Value), // int - int = int
            (FloatValue l, FloatValue r, "+") => new FloatValue(l.Value + r.Value), // float + float = float
            (FloatValue l, FloatValue r, "-") => new FloatValue(l.Value - r.Value), // float - float = float
            (FloatValue l, IntValue r, "+") => new FloatValue(l.Value + (float)r.Value), // float + int = float
            (IntValue l, FloatValue r, "+") => new FloatValue((float)l.Value + r.Value), // int + float = float
            (IntValue l, FloatValue r, "-") => new FloatValue((float)l.Value - r.Value), // int - float = float
            (FloatValue l, IntValue r, "-") => new FloatValue(l.Value - (float)r.Value), // float - int = float
            (StringValue l, StringValue r, "+") => new StringValue(l.Value + r.Value),
            //(IntValue l, StringValue r, "+") => new StringValue(l.Value.ToString() + r.Value),
            //(StringValue l, IntValue r, "+") => new StringValue(l.Value + r.Value.ToString()),
            _ => throw new SemanticError("Invalid operation", context.Start)
        };
    }

    //VisitFloat
    public override ValueWrapper VisitFloat(LanguageParser.FloatContext context) {
        return new FloatValue(float.Parse(context.FLOAT().GetText(), CultureInfo.InvariantCulture));
    }

    //VisitRelational
    public override ValueWrapper VisitRelational(LanguageParser.RelationalContext context) {
        ValueWrapper left = Visit(context.expr(0));
        ValueWrapper right = Visit(context.expr(1));
        var op = context.op.Text;

        return (left, right, op) switch {
            // int[>,<,>=,<=] int
            (IntValue l, IntValue r, "<") => new BoolValue(l.Value < r.Value), 
            (IntValue l, IntValue r, ">") => new BoolValue(l.Value > r.Value),
            (IntValue l, IntValue r, "<=") => new BoolValue(l.Value <= r.Value),
            (IntValue l, IntValue r, ">=") => new BoolValue(l.Value >= r.Value),
            // float[>,<,>=,<=] float
            (FloatValue l, FloatValue r, "<") => new BoolValue(l.Value < r.Value),
            (FloatValue l, FloatValue r, ">") => new BoolValue(l.Value > r.Value),
            (FloatValue l, FloatValue r, "<=") => new BoolValue(l.Value <= r.Value),
            (FloatValue l, FloatValue r, ">=") => new BoolValue(l.Value >= r.Value),
            // int[>,<,>=,<=] float
            (IntValue l, FloatValue r, "<") => new BoolValue(l.Value < r.Value),
            (IntValue l, FloatValue r, ">") => new BoolValue(l.Value > r.Value),
            (IntValue l, FloatValue r, "<=") => new BoolValue(l.Value <= r.Value),
            (IntValue l, FloatValue r, ">=") => new BoolValue(l.Value >= r.Value),
            // float[>,<,>=,<=] int
            (FloatValue l, IntValue r, "<") => new BoolValue(l.Value < r.Value),
            (FloatValue l, IntValue r, ">") => new BoolValue(l.Value > r.Value),
            (FloatValue l, IntValue r, "<=") => new BoolValue(l.Value <= r.Value),
            (FloatValue l, IntValue r, ">=") => new BoolValue(l.Value >= r.Value),
            // rune [>,<,>=,<=] rune
            (RuneValue l, RuneValue r, "<") => new BoolValue(l.Value < r.Value),
            (RuneValue l, RuneValue r, ">") => new BoolValue(l.Value > r.Value),
            (RuneValue l, RuneValue r, "<=") => new BoolValue(l.Value <= r.Value),
            (RuneValue l, RuneValue r, ">=") => new BoolValue(l.Value >= r.Value),
            _ => throw new SemanticError("Invalid operation", context.Start)
        };
    }

    //VisitLogical
    public override ValueWrapper VisitLogical(LanguageParser.LogicalContext context) {
        ValueWrapper left = Visit(context.expr(0));
        ValueWrapper right = Visit(context.expr(1));
        var op = context.op.Text;

        return (left, right, op) switch {
            (BoolValue l, BoolValue r, "&&") => new BoolValue(l.Value && r.Value),
            (BoolValue l, BoolValue r, "||") => new BoolValue(l.Value || r.Value),
            _ => throw new SemanticError("Invalid operation", context.Start)
        };
    }

    // VisitNot
    public override ValueWrapper VisitNot(LanguageParser.NotContext context)
    {
        ValueWrapper value = Visit(context.expr());
        if (value is not BoolValue)
        {
            throw new SemanticError("Invalid operation", context.Start);
        }
        return new BoolValue(!(value as BoolValue).Value);
    }
    
    //VisitAssign
    public override ValueWrapper VisitAssign(LanguageParser.AssignContext context) {
        string id = context.ID().GetText();
        ValueWrapper value = Visit(context.expr());
        currentEnvironment.AssignVariable(id, value, context.Start);
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
            (RuneValue l, RuneValue r, "==") => new BoolValue(l.Value == r.Value),
            (RuneValue l, RuneValue r, "!=") => new BoolValue(l.Value != r.Value),
            _ => throw new SemanticError("Invalid operation", context.Start)
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
    if (context.STRING() == null) {
        throw new SemanticError("Invalid string", context.Start);
    }

    string text = context.STRING().GetText();

    // Verificar que la cadena tenga al menos dos caracteres (para las comillas)
    if (text.Length < 2) {
        throw new SemanticError("Invalid string format", context.Start);
    }

    // Quitar las comillas dobles al inicio y al final
    text = text.Substring(1, text.Length - 2);

    // Reemplazar caracteres de escape correctamente
    text = ReplaceEscapeSequences(text);

    return new StringValue(text);
}

    private string ReplaceEscapeSequences(string text) {
        // Usamos expresiones regulares para procesar correctamente las secuencias de escape
        return System.Text.RegularExpressions.Regex.Unescape(text);
    }


    //VisitRune
public override ValueWrapper VisitRune(LanguageParser.RuneContext context) {
    string text = context.RUNE().GetText();
    if (text.Length != 3) {
        throw new SemanticError("Invalid rune", context.Start);
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
            throw new SemanticError("Invalid condition", context.Start);
        }
        if ((condition as BoolValue).Value) {
            Visit(context.stmt(0));
        } else if (context.stmt().Length > 1) {
            Visit(context.stmt(1));
        }
        return defaultValue;
    }


    //VisitWhileStmt
    public override ValueWrapper VisitWhileStmt(LanguageParser.WhileStmtContext context) {
        ValueWrapper condition = Visit(context.expr());

        if (condition is not BoolValue) {
            throw new SemanticError("Invalid condition", context.Start);
        }

        while ((condition as BoolValue).Value) {
            Visit(context.stmt());
            condition = Visit(context.expr());
            if (condition is not BoolValue) {
                throw new SemanticError("Invalid condition", context.Start);
            }
        }
        return defaultValue;
    }

    // VisitForStmt
    public override ValueWrapper VisitForStmt(LanguageParser.ForStmtContext context)
    {
        Environment previousEnvironment = currentEnvironment;
        currentEnvironment = new Environment(previousEnvironment);

        ValueWrapper condition = Visit(context.expr());

        if (condition is not BoolValue)
        {
            throw new SemanticError("Invalid condition", context.Start);
        }

        while ((condition as BoolValue).Value)
        {
            Visit(context.stmt());
            condition = Visit(context.expr());
            if (condition is not BoolValue)
            {

                throw new SemanticError("Invalid condition", context.Start);
            }
        }

        currentEnvironment = previousEnvironment;
        return defaultValue;
    }

        //VisitForStmtIni
    public override ValueWrapper VisitForStmtIni(LanguageParser.ForStmtIniContext context) {
        Environment previousEnvironment = currentEnvironment;
        currentEnvironment = new Environment(previousEnvironment);

        // Manejar inicialización (puede ser shortVarDcl o expr)
        if (context.forInit().shortVarDcl() != null) {
            Visit(context.forInit().shortVarDcl());
        } else {
            Visit(context.forInit().expr());
        }

        VisitForBody(context);

        currentEnvironment = previousEnvironment; // Restaurar el entorno
        return defaultValue;
    }

    public void VisitForBody(LanguageParser.ForStmtIniContext context) {
        ValueWrapper condition = Visit(context.expr(0)); // Condición del for

        while (condition is BoolValue boolCondition && boolCondition.Value) {
            try {
                Visit(context.stmt()); // Ejecutar el cuerpo del for
                Visit(context.expr(1)); // Ejecutar la actualización
                condition = Visit(context.expr(0)); // Reevaluar la condición
            } catch (BreakException) {
                break; // Salir del bucle si hay un "break"
            } catch (ContinueException) {
                Visit(context.expr(1)); // Ejecutar la actualización antes de continuar
                condition = Visit(context.expr(0)); // Reevaluar la condición después del continue
            }
        }
    }


    //VisitForInit

    //VisitAddSubAssign
    public override ValueWrapper VisitAddSubAssign(LanguageParser.AddSubAssignContext context) {
    string id = context.ID().GetText();

    // Verificar si la variable existe en el entorno
    if (currentEnvironment.GetVariable(id, context.Start) == null) {
        throw new SemanticError("Variable not found", context.Start);
    }

    // Obtener el valor actual de la variable
    ValueWrapper currentVariable = currentEnvironment.GetVariable(id, context.Start);

    // Evaluar la expresión
    ValueWrapper valueToAdd = Visit(context.expr());
    
    // Validar tipos
    if (!(valueToAdd is IntValue || valueToAdd is FloatValue) || 
        !(currentVariable is IntValue || currentVariable is FloatValue)) {
        throw new SemanticError("Invalid operation", context.Start);
    }

    // Realizar la operación
    var op = context.op.Text;
    if (op == "+=") {
        ValueWrapper newValue;

        // Manejar la suma para IntValue
        if (currentVariable is IntValue currentInt && valueToAdd is IntValue addInt) {
            newValue = new IntValue(currentInt.Value + addInt.Value);
        }
        // Manejar la suma para FloatValue
        else if (currentVariable is FloatValue currentFloat && valueToAdd is FloatValue addFloat) {
            newValue = new FloatValue(currentFloat.Value + addFloat.Value);
        }
        // Manejar la suma entre IntValue y FloatValue
        else if (currentVariable is IntValue intVar && valueToAdd is FloatValue floatValue) {
            newValue = new FloatValue(intVar.Value + floatValue.Value);
        }
        else if (currentVariable is FloatValue floatVar && valueToAdd is IntValue intValue) {
            newValue = new FloatValue(floatVar.Value + intValue.Value);
        }
        else {
            throw new SemanticError("Invalid types for addition", context.Start);
        }

        // Actualizar la variable en el entorno
        currentEnvironment.AssignVariable(id, newValue, context.Start);
        
        // Devolver el nuevo valor
        return newValue;
    } else if (op == "-=") {
        // Lógica para -= (similar a +=)
        ValueWrapper newValue;

        // Manejar la resta para IntValue
        if (currentVariable is IntValue currentInt && valueToAdd is IntValue subtractInt) {
            newValue = new IntValue(currentInt.Value - subtractInt.Value);
        }
        // Manejar la resta para FloatValue
        else if (currentVariable is FloatValue currentFloat && valueToAdd is FloatValue subtractFloat) {
            newValue = new FloatValue(currentFloat.Value - subtractFloat.Value);
        }
        // Manejar la resta entre IntValue y FloatValue
        else if (currentVariable is IntValue intVar && valueToAdd is FloatValue floatValue) {
            newValue = new FloatValue(intVar.Value - floatValue.Value);
        }
        else if (currentVariable is FloatValue floatVar && valueToAdd is IntValue intValue) {
            newValue = new FloatValue(floatVar.Value - intValue.Value);
        }
        else {
            throw new SemanticError("Invalid types for subtraction", context.Start);
        }

        // Actualizar la variable en el entorno
        currentEnvironment.AssignVariable(id, newValue, context.Start);
        
        // Devolver el nuevo valor
        return newValue;
    }

    throw new SemanticError("Invalid operator: " + op, context.Start);
    }

    //VisitBreakStmt
    public override ValueWrapper VisitBreakStmt(LanguageParser.BreakStmtContext context) {
        throw new BreakException();

    }
    //VisitContinueStmt
    public override ValueWrapper VisitContinueStmt(LanguageParser.ContinueStmtContext context) {
        throw new ContinueException();
    }
    //VisitReturnStmt
    public override ValueWrapper VisitReturnStmt(LanguageParser.ReturnStmtContext context) {
        ValueWrapper value = defaultValue;

        if (context.expr() != null) {
            value = Visit(context.expr());
        }
        
        throw new ReturnException(value);
    }
}

