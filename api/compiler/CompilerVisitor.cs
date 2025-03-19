
using System.Globalization;
using analyzer;

public class CompilerVisitor : LanguageBaseVisitor<ValueWrapper>
{

    public ValueWrapper defaultValue = new VoidValue();
    public string output = "";
    public Environment currentEnvironment;

    // Guardar funciones embebidas
    public CompilerVisitor()
    {
        // Agregar funciones embebidas
        currentEnvironment = new Environment(null);
        Embeded.Generate(currentEnvironment);
    }

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

        if (context.expr() != null)
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
        if (!IsValidType(value, GetDefaultValue(type)))
        {
            throw new SemanticError($"Type mismatch: cannot assign value of type {value.GetType().Name} to variable {id} of type {type}", context.Start);
        }

        currentEnvironment.Declare(id, value, context.Start);
        return defaultValue;
    }

    private ValueWrapper GetDefaultValue(string type)
    {
        return type switch
        {
            "int" => new IntValue(0),
            "float64" => new FloatValue(0),
            "string" => new StringValue(""),
            "bool" => new BoolValue(false),
            "rune" => new RuneValue('x'),
            "[]int" => new SliceValue<int>(new List<int>()),
            "[]float64" => new SliceValue<double>(new List<double>()),
            "[]string" => new SliceValue<string>(new List<string>()),
            "[]bool" => new SliceValue<bool>(new List<bool>()),
            "[]rune" => new SliceValue<char>(new List<char>()),
            _ => throw new SemanticError("Invalid type", null)
        };
    }
    
    //VisitShortVarDcl
    public override ValueWrapper VisitShortVarDcl(LanguageParser.ShortVarDclContext context) {
        string id = context.ID().GetText();
        ValueWrapper value = Visit(context.expr());

        Console.WriteLine($"Asignando a {id}: {value}");

        currentEnvironment.Declare(id, value, context.Start);
        return defaultValue;
    }

    //VisitSliceDcl
    public override ValueWrapper VisitSliceDcl(LanguageParser.SliceDclContext context)
    {
        string id = context.ID().GetText();
        string type = context.Types()?.GetText(); // Obtener el tipo declarado, si existe
        ValueWrapper value;

        if (context.expr() != null && context.expr().Length > 0)
        {
            // Inicializar el slice con valores
            var values = new List<ValueWrapper>();
            foreach (var expr in context.expr())
            {
                values.Add(Visit(expr));
            }

            value = type switch
            {
                "int" => new SliceValue<int>(values.Cast<IntValue>().Select(v => v.Value).ToList()),
                "float64" => new SliceValue<double>(values.Cast<FloatValue>().Select(v => v.Value).ToList()),
                "string" => new SliceValue<string>(values.Cast<StringValue>().Select(v => v.Value).ToList()),
                "bool" => new SliceValue<bool>(values.Cast<BoolValue>().Select(v => v.Value).ToList()),
                "rune" => new SliceValue<char>(values.Cast<RuneValue>().Select(v => v.Value).ToList()),
                _ => throw new SemanticError("Invalid type", context.Start)
            };
        }
        else if (context.GetText().Contains("{") && context.GetText().Contains("}"))
        {
            // Inicializar el slice con valores sin tipo explícito
            var values = new List<ValueWrapper>();
            foreach (var expr in context.expr())
            {
                values.Add(Visit(expr));
            }

            value = new SliceValue<ValueWrapper>(values);
        }
        else
        {
            // Inicializar un slice vacío
            value = type switch
            {
                "int" => new SliceValue<int>(new List<int>()),
                "float64" => new SliceValue<double>(new List<double>()),
                "string" => new SliceValue<string>(new List<string>()),
                "bool" => new SliceValue<bool>(new List<bool>()),
                "rune" => new SliceValue<char>(new List<char>()),
                _ => throw new SemanticError("Invalid type", context.Start)
            };
        }

        currentEnvironment.Declare(id, value, context.Start);
        return defaultValue;
    }

    //VisitShortSliceDcl
    public override ValueWrapper VisitShortSliceDcl(LanguageParser.ShortSliceDclContext context)
    {
        string id = context.ID().GetText();
        string type = context.Types().GetText(); // Obtener el tipo declarado
        ValueWrapper value;

        // Inicializar el slice con valores
        var values = new List<ValueWrapper>();
        foreach (var expr in context.expr())
        {
            values.Add(Visit(expr));
        }

        value = type switch
        {
            "int" => new SliceValue<int>(values.Cast<IntValue>().Select(v => v.Value).ToList()),
            "float64" => new SliceValue<double>(values.Cast<FloatValue>().Select(v => v.Value).ToList()),
            "string" => new SliceValue<string>(values.Cast<StringValue>().Select(v => v.Value).ToList()),
            "bool" => new SliceValue<bool>(values.Cast<BoolValue>().Select(v => v.Value).ToList()),
            "rune" => new SliceValue<char>(values.Cast<RuneValue>().Select(v => v.Value).ToList()),
            _ => throw new SemanticError("Invalid type", context.Start)
        };

        currentEnvironment.Declare(id, value, context.Start);
        return defaultValue;
    }

    //VisitSliceIndex
    public override ValueWrapper VisitSliceIndex(LanguageParser.SliceIndexContext context)
    {
        // Obtener los argumentos: el slice y el valor a buscar
        ValueWrapper sliceValue = Visit(context.expr(0));
        ValueWrapper searchValue = Visit(context.expr(1));

        // Validar que el primer argumento sea un SliceValue<T>
        if (sliceValue is not ValueWrapper genericSlice || genericSlice.GetType().GetGenericTypeDefinition() != typeof(SliceValue<>))
        {
            throw new SemanticError("First argument must be a slice", context.Start);
        }

        // Obtener el tipo genérico del slice
        Type sliceType = sliceValue.GetType().GetGenericArguments()[0];

        // Buscar el índice del valor en el slice según el tipo de T
        int index = -1;
        if (sliceType == typeof(int) && sliceValue is SliceValue<int> intSlice && searchValue is IntValue intValue)
        {
            index = intSlice.Values.IndexOf(intValue.Value);
        }
        else if (sliceType == typeof(double) && sliceValue is SliceValue<double> floatSlice && searchValue is FloatValue floatValue)
        {
            index = floatSlice.Values.IndexOf(floatValue.Value);
        }
        else if (sliceType == typeof(string) && sliceValue is SliceValue<string> stringSlice && searchValue is StringValue stringValue)
        {
            index = stringSlice.Values.IndexOf(stringValue.Value);
        }
        else if (sliceType == typeof(bool) && sliceValue is SliceValue<bool> boolSlice && searchValue is BoolValue boolValue)
        {
            index = boolSlice.Values.IndexOf(boolValue.Value);
        }
        else if (sliceType == typeof(char) && sliceValue is SliceValue<char> runeSlice && searchValue is RuneValue runeValue)
        {
            index = runeSlice.Values.IndexOf(runeValue.Value);
        }
        else
        {
            throw new SemanticError("Type mismatch or invalid slice type", context.Start);
        }

        // Retornar el índice encontrado o -1 si no se encuentra
        return new IntValue(index);
    }

    // VisitStringsJoin
    public override ValueWrapper VisitStringsJoin(LanguageParser.StringsJoinContext context)
    {
        // Obtener el argumento: el slice
        ValueWrapper sliceValue = Visit(context.expr(0)); // Primer argumento: el slice

        // Validar que el argumento sea un SliceValue<string>
        if (sliceValue is not SliceValue<string> stringSlice)
        {
            throw new SemanticError("First argument must be a slice of strings ([]string)", context.Start);
        }

        // Obtener el separador
        ValueWrapper separatorValue = Visit(context.expr(1));

        // Validar que el separador sea un StringValue
        if (separatorValue is not StringValue stringSeparator)
        {
            throw new SemanticError("Second argument must be a string", context.Start);
        }

        // Usar el separador obtenido para concatenar los elementos del slice
        string result = string.Join(stringSeparator.Value, stringSlice.Values);

        // Retornar el resultado como un StringValue
        return new StringValue(result);
    }

    // VisitAppendSlice
    public override ValueWrapper VisitAppendSlice(LanguageParser.AppendSliceContext context)
    {
        // Evaluar los argumentos de `append`
        ValueWrapper target = Visit(context.expr(0)); // Primer argumento
        ValueWrapper toAppend = Visit(context.expr(1)); // Segundo argumento

        // Caso 1: Si el primer argumento es un slice unidimensional
        if (target is SliceValue<int> intSlice && toAppend is IntValue intValue)
        {
            intSlice.Values.Add(intValue.Value);
            return intSlice;
        }
        else if (target is SliceValue<double> floatSlice && toAppend is FloatValue floatValue)
        {
            floatSlice.Values.Add(floatValue.Value);
            return floatSlice;
        }
        else if (target is SliceValue<string> stringSlice && toAppend is StringValue stringValue)
        {
            stringSlice.Values.Add(stringValue.Value);
            return stringSlice;
        }
        else if (target is SliceValue<bool> boolSlice && toAppend is BoolValue boolValue)
        {
            boolSlice.Values.Add(boolValue.Value);
            return boolSlice;
        }
        else if (target is SliceValue<char> runeSlice && toAppend is RuneValue runeValue)
        {
            runeSlice.Values.Add(runeValue.Value);
            return runeSlice;
        }

        // Caso 2: Si el primer argumento es una matriz multidimensional
        if (target is MatrixValue<int> intMatrix && toAppend is SliceValue<int> intRow)
        {
            intMatrix.Values.Add(intRow.Values);
            return intMatrix;
        }
        else if (target is MatrixValue<double> floatMatrix && toAppend is SliceValue<double> floatRow)
        {
            floatMatrix.Values.Add(floatRow.Values);
            return floatMatrix;
        }
        else if (target is MatrixValue<string> stringMatrix && toAppend is SliceValue<string> stringRow)
        {
            stringMatrix.Values.Add(stringRow.Values);
            return stringMatrix;
        }
        else if (target is MatrixValue<bool> boolMatrix && toAppend is SliceValue<bool> boolRow)
        {
            boolMatrix.Values.Add(boolRow.Values);
            return boolMatrix;
        }
        else if (target is MatrixValue<char> runeMatrix && toAppend is SliceValue<char> runeRow)
        {
            runeMatrix.Values.Add(runeRow.Values);
            return runeMatrix;
        }

        // Si no coincide con ninguno de los casos anteriores, lanzar un error
        throw new SemanticError("Invalid use of append: incompatible types", context.Start);
    }

    // VisitLenSlice
    public override ValueWrapper VisitLenSlice(LanguageParser.LenSliceContext context)
    {
        // Obtener el argumento: el slice
        ValueWrapper sliceValue = Visit(context.expr());

        // Validar que el argumento sea un SliceValue<T>
        if (sliceValue is not ValueWrapper genericSlice || genericSlice.GetType().GetGenericTypeDefinition() != typeof(SliceValue<>))
        {
            throw new SemanticError("Argument must be a slice", context.Start);
        }

        // Obtener la longitud del slice
        int length = genericSlice switch
        {
            SliceValue<int> intSlice => intSlice.Values.Count,
            SliceValue<double> floatSlice => floatSlice.Values.Count,
            SliceValue<string> stringSlice => stringSlice.Values.Count,
            SliceValue<bool> boolSlice => boolSlice.Values.Count,
            SliceValue<char> runeSlice => runeSlice.Values.Count,
            _ => throw new SemanticError("Invalid slice type", context.Start)
        };

        // Retornar la longitud como un IntValue
        return new IntValue(length);
    }

    // TODO: lograr cambiar el valor de un índice del slice

    //VisitIndex
    public override ValueWrapper VisitIndex(LanguageParser.IndexContext context)
    {
        // Obtener el identificador del slice y el índice
        string id = context.ID().GetText();
        ValueWrapper sliceValue = currentEnvironment.Get(id, context.Start);
        ValueWrapper indexValue = Visit(context.expr());

        // Validar que el índice sea un IntValue
        if (indexValue is not IntValue intIndex)
        {
            throw new SemanticError("Index must be an integer", context.Start);
        }

        // Validar que el slice sea un SliceValue<T>
        if (sliceValue is not SliceValue<int> &&
            sliceValue is not SliceValue<double> &&
            sliceValue is not SliceValue<string> &&
            sliceValue is not SliceValue<bool> &&
            sliceValue is not SliceValue<char>)
        {
            throw new SemanticError($"Variable '{id}' is not a valid slice", context.Start);
        }

        // Validar que el índice esté dentro de los límites del slice
        int sliceLength = sliceValue switch
        {
            SliceValue<int> intSlice => intSlice.Values.Count,
            SliceValue<double> floatSlice => floatSlice.Values.Count,
            SliceValue<string> stringSlice => stringSlice.Values.Count,
            SliceValue<bool> boolSlice => boolSlice.Values.Count,
            SliceValue<char> runeSlice => runeSlice.Values.Count,
            _ => throw new SemanticError("Invalid slice type", context.Start)
        };

        if (intIndex.Value < 0 || intIndex.Value >= sliceLength)
        {
            throw new SemanticError("Index out of bounds", context.Start);
        }

        // Retornar el valor en el índice
        var result = Slices.GetIndexedValue(sliceValue, intIndex.Value, context);

        // Depuración: imprimir el valor devuelto
        Console.WriteLine($"VisitIndex devuelve: {result}");

        return result;
    }

    // VisitIndexAssig
    public override ValueWrapper VisitIndexAssig(LanguageParser.IndexAssigContext context)
    {
        // Obtener el identificador del slice, el índice y el valor a asignar
        string id = context.ID().GetText();
        ValueWrapper sliceValue = currentEnvironment.Get(id, context.Start);
        ValueWrapper indexValue = Visit(context.expr(0));
        ValueWrapper newValue = Visit(context.expr(1));

        // Validar que el índice sea un IntValue
        if (indexValue is not IntValue intIndex)
        {
            throw new SemanticError("Index must be an integer", context.Start);
        }

        // Validar que el slice sea un SliceValue<T>
        if (sliceValue is not SliceValue<int> &&
            sliceValue is not SliceValue<double> &&
            sliceValue is not SliceValue<string> &&
            sliceValue is not SliceValue<bool> &&
            sliceValue is not SliceValue<char>)
        {
            throw new SemanticError($"Variable '{id}' is not a valid slice", context.Start);
        }

        // Validar que el índice esté dentro de los límites del slice
        int sliceLength = sliceValue switch
        {
            SliceValue<int> intSlice => intSlice.Values.Count,
            SliceValue<double> floatSlice => floatSlice.Values.Count,
            SliceValue<string> stringSlice => stringSlice.Values.Count,
            SliceValue<bool> boolSlice => boolSlice.Values.Count,
            SliceValue<char> runeSlice => runeSlice.Values.Count,
            _ => throw new SemanticError("Invalid slice type", context.Start)
        };

        if (intIndex.Value < 0 || intIndex.Value >= sliceLength)
        {
            throw new SemanticError("Index out of bounds", context.Start);
        }

        // Asignar el nuevo valor al índice
        switch (sliceValue)
        {
            case SliceValue<int> intSlice when newValue is IntValue intValue:
                intSlice.Values[intIndex.Value] = intValue.Value;
                break;

            case SliceValue<double> floatSlice when newValue is FloatValue floatValue:
                floatSlice.Values[intIndex.Value] = floatValue.Value;
                break;

            case SliceValue<string> stringSlice when newValue is StringValue stringValue:
                stringSlice.Values[intIndex.Value] = stringValue.Value;
                break;

            case SliceValue<bool> boolSlice when newValue is BoolValue boolValue:
                boolSlice.Values[intIndex.Value] = boolValue.Value;
                break;

            case SliceValue<char> runeSlice when newValue is RuneValue runeValue:
                runeSlice.Values[intIndex.Value] = runeValue.Value;
                break;

            default:
                throw new SemanticError("Type mismatch or invalid slice type", context.Start);
        }

        // Retornar el valor por defecto después de la asignación
        return defaultValue;
    }

    // VisitSliceDclMultidimensional
    public override ValueWrapper VisitSliceDclMultidimensional(LanguageParser.SliceDclMultidimensionalContext context)
    {
        // Obtener el identificador de la matriz
        string id = context.ID().GetText();
        string type = context.Types().GetText(); // Obtener el tipo declarado (por ejemplo, int, float64, etc.)
        var rows = new List<List<ValueWrapper>>();

        // Procesar cada fila
        foreach (var rowContext in context.row())
        {
            var row = new List<ValueWrapper>();
            foreach (var exprContext in rowContext.expr())
            {
                row.Add(Visit(exprContext)); // Evaluar cada expresión en la fila
            }
            rows.Add(row);
        }

        // Validación si se quisiera que tuvieran el mismo tamaño los slices 
        /*int? rowLength = null;
        foreach (var row in rows)
        {
            if (rowLength == null)
            {
                rowLength = row.Count;
            }
            else if (row.Count != rowLength)
            {
                throw new SemanticError("All rows in the matrix must have the same number of columns", context.Start);
            }
        }*/

        // Crear un MatrixValue basado en el tipo declarado
        ValueWrapper value = type switch
        {
            "int" => new MatrixValue<int>(rows.Select(r => r.Cast<IntValue>().Select(v => v.Value).ToList()).ToList()),
            "float64" => new MatrixValue<double>(rows.Select(r => r.Cast<FloatValue>().Select(v => v.Value).ToList()).ToList()),
            "string" => new MatrixValue<string>(rows.Select(r => r.Cast<StringValue>().Select(v => v.Value).ToList()).ToList()),
            "bool" => new MatrixValue<bool>(rows.Select(r => r.Cast<BoolValue>().Select(v => v.Value).ToList()).ToList()),
            "rune" => new MatrixValue<char>(rows.Select(r => r.Cast<RuneValue>().Select(v => v.Value).ToList()).ToList()),
            _ => throw new SemanticError($"Invalid matrix type: {type}", context.Start)
        };

        // Declarar la matriz en el entorno
        currentEnvironment.Declare(id, value, context.Start);

        return defaultValue;
    }

    //VisitMultiIndexAssig
    public override ValueWrapper VisitMultiIndexAssig(LanguageParser.MultiIndexAssigContext context)
    {
        // Obtener el identificador de la matriz
        string id = context.ID().GetText();
        ValueWrapper matrixValue = currentEnvironment.Get(id, context.Start);

        // Validar que la variable sea una matriz
        if (matrixValue is not MatrixValue<int> &&
            matrixValue is not MatrixValue<double> &&
            matrixValue is not MatrixValue<string> &&
            matrixValue is not MatrixValue<bool> &&
            matrixValue is not MatrixValue<char>)
        {
            throw new SemanticError($"Variable '{id}' is not a valid matrix", context.Start);
        }

        // Obtener los índices de fila y columna
        ValueWrapper rowIndexValue = Visit(context.expr(0));
        ValueWrapper colIndexValue = Visit(context.expr(1));

        // Validar que ambos índices sean enteros
        if (rowIndexValue is not IntValue rowIndex || colIndexValue is not IntValue colIndex)
        {
            throw new SemanticError("Matrix indices must be integers", context.Start);
        }

        // Validar que los índices estén dentro de los límites de la matriz
        int rowCount = matrixValue switch
        {
            MatrixValue<int> intMatrix => intMatrix.Values.Count,
            MatrixValue<double> floatMatrix => floatMatrix.Values.Count,
            MatrixValue<string> stringMatrix => stringMatrix.Values.Count,
            MatrixValue<bool> boolMatrix => boolMatrix.Values.Count,
            MatrixValue<char> runeMatrix => runeMatrix.Values.Count,
            _ => throw new SemanticError("Invalid matrix type", context.Start)
        };

        if (rowIndex.Value < 0 || rowIndex.Value >= rowCount)
        {
            throw new SemanticError("Row index out of bounds", context.Start);
        }

        int colCount = matrixValue switch
        {
            MatrixValue<int> intMatrix => intMatrix.Values[rowIndex.Value].Count,
            MatrixValue<double> floatMatrix => floatMatrix.Values[rowIndex.Value].Count,
            MatrixValue<string> stringMatrix => stringMatrix.Values[rowIndex.Value].Count,
            MatrixValue<bool> boolMatrix => boolMatrix.Values[rowIndex.Value].Count,
            MatrixValue<char> runeMatrix => runeMatrix.Values[rowIndex.Value].Count,
            _ => throw new SemanticError("Invalid matrix type", context.Start)
        };

        if (colIndex.Value < 0 || colIndex.Value >= colCount)
        {
            throw new SemanticError("Column index out of bounds", context.Start);
        }

        // Obtener el nuevo valor a asignar
        ValueWrapper newValue = Visit(context.expr(2));

        // Asignar el nuevo valor en la posición [fila][columna] de la matriz
        switch (matrixValue)
        {
            case MatrixValue<int> intMatrix when newValue is IntValue intValue:
                intMatrix.Values[rowIndex.Value][colIndex.Value] = intValue.Value;
                break;

            case MatrixValue<double> floatMatrix when newValue is FloatValue floatValue:
                floatMatrix.Values[rowIndex.Value][colIndex.Value] = floatValue.Value;
                break;

            case MatrixValue<string> stringMatrix when newValue is StringValue stringValue:
                stringMatrix.Values[rowIndex.Value][colIndex.Value] = stringValue.Value;
                break;

            case MatrixValue<bool> boolMatrix when newValue is BoolValue boolValue:
                boolMatrix.Values[rowIndex.Value][colIndex.Value] = boolValue.Value;
                break;

            case MatrixValue<char> runeMatrix when newValue is RuneValue runeValue:
                runeMatrix.Values[rowIndex.Value][colIndex.Value] = runeValue.Value;
                break;

            default:
                throw new SemanticError("Type mismatch or invalid matrix type", context.Start);
        }

        // Retornar el valor por defecto después de la asignación
        return defaultValue;
    }

    // VisitMultiIndex
    public override ValueWrapper VisitMultiIndex(LanguageParser.MultiIndexContext context)
    {
        // Obtener el identificador de la matriz
        string id = context.ID().GetText();
        ValueWrapper matrixValue = currentEnvironment.Get(id, context.Start);

        // Validar que la variable sea una matriz
        if (matrixValue is not MatrixValue<int> &&
            matrixValue is not MatrixValue<double> &&
            matrixValue is not MatrixValue<string> &&
            matrixValue is not MatrixValue<bool> &&
            matrixValue is not MatrixValue<char>)
        {
            throw new SemanticError($"Variable '{id}' is not a valid matrix", context.Start);
        }

        // Obtener los índices de fila y columna
        ValueWrapper rowIndexValue = Visit(context.expr(0));
        ValueWrapper colIndexValue = Visit(context.expr(1));

        // Validar que ambos índices sean enteros
        if (rowIndexValue is not IntValue rowIndex || colIndexValue is not IntValue colIndex)
        {
            throw new SemanticError("Matrix indices must be integers", context.Start);
        }

        // Validar que los índices estén dentro de los límites de la matriz
        int rowCount = matrixValue switch
        {
            MatrixValue<int> intMatrix => intMatrix.Values.Count,
            MatrixValue<double> floatMatrix => floatMatrix.Values.Count,
            MatrixValue<string> stringMatrix => stringMatrix.Values.Count,
            MatrixValue<bool> boolMatrix => boolMatrix.Values.Count,
            MatrixValue<char> runeMatrix => runeMatrix.Values.Count,
            _ => throw new SemanticError("Invalid matrix type", context.Start)
        };

        if (rowIndex.Value < 0 || rowIndex.Value >= rowCount)
        {
            throw new SemanticError("Row index out of bounds", context.Start);
        }

        int colCount = matrixValue switch
        {
            MatrixValue<int> intMatrix => intMatrix.Values[rowIndex.Value].Count,
            MatrixValue<double> floatMatrix => floatMatrix.Values[rowIndex.Value].Count,
            MatrixValue<string> stringMatrix => stringMatrix.Values[rowIndex.Value].Count,
            MatrixValue<bool> boolMatrix => boolMatrix.Values[rowIndex.Value].Count,
            MatrixValue<char> runeMatrix => runeMatrix.Values[rowIndex.Value].Count,
            _ => throw new SemanticError("Invalid matrix type", context.Start)
        };

        if (colIndex.Value < 0 || colIndex.Value >= colCount)
        {
            throw new SemanticError("Column index out of bounds", context.Start);
        }

        // Retornar el valor en la posición [fila][columna] de la matriz
        return matrixValue switch
        {
            MatrixValue<int> intMatrix => new IntValue(intMatrix.Values[rowIndex.Value][colIndex.Value]),
            MatrixValue<double> floatMatrix => new FloatValue(floatMatrix.Values[rowIndex.Value][colIndex.Value]),
            MatrixValue<string> stringMatrix => new StringValue(stringMatrix.Values[rowIndex.Value][colIndex.Value]),
            MatrixValue<bool> boolMatrix => new BoolValue(boolMatrix.Values[rowIndex.Value][colIndex.Value]),
            MatrixValue<char> runeMatrix => new RuneValue(runeMatrix.Values[rowIndex.Value][colIndex.Value]),
            _ => throw new SemanticError("Invalid matrix type", context.Start)
        };
    }


    // Validar tipos de datos
    private bool IsValidType(ValueWrapper value, ValueWrapper existingValue)
    {
        return (existingValue, value) switch
        {
            // Validaciones para tipos básicos
            (IntValue, IntValue) => true,
            (FloatValue, FloatValue) => true,
            (StringValue, StringValue) => true,
            (BoolValue, BoolValue) => true,
            (RuneValue, RuneValue) => true,

            // Validaciones para slices unidimensionales
            (SliceValue<int>, SliceValue<int>) => true,
            (SliceValue<double>, SliceValue<double>) => true,
            (SliceValue<string>, SliceValue<string>) => true,
            (SliceValue<bool>, SliceValue<bool>) => true,
            (SliceValue<char>, SliceValue<char>) => true,

            // Validaciones para slices multidimensionales (matrices)
            (MatrixValue<int>, MatrixValue<int>) => true,
            (MatrixValue<double>, MatrixValue<double>) => true,
            (MatrixValue<string>, MatrixValue<string>) => true,
            (MatrixValue<bool>, MatrixValue<bool>) => true,
            (MatrixValue<char>, MatrixValue<char>) => true,

            // Si no coincide con ninguno de los casos anteriores, no es válido
            _ => false
        };
    }

    // VisitExprStmt
    public override ValueWrapper VisitExprStmt(LanguageParser.ExprStmtContext context)
    {
        return Visit(context.expr());
    }

    // VisitPrValueWrapperStmt
    // VALIDAR IMPRESIÓN DE FUNCION
    public override ValueWrapper VisitPrintStmt(LanguageParser.PrintStmtContext context)
    {
        for (int i = 0; i < context.expr().Length; i++)
        {
            ValueWrapper value = Visit(context.expr(i));

            if (value is SliceValue<int> intSlice)
            {
                output += "[" + string.Join(" ", intSlice.Values) + "]";
            }
            else if (value is SliceValue<double> floatSlice)
            {
                output += "[" + string.Join(" ", floatSlice.Values.Select(v => v.ToString(CultureInfo.InvariantCulture))) + "]";
            }
            else if (value is SliceValue<string> stringSlice)
            {
                output += "[" + string.Join(" ", stringSlice.Values) + "]";
            }
            else if (value is SliceValue<bool> boolSlice)
            {
                output += "[" + string.Join(" ", boolSlice.Values) + "]";
            }
            else if (value is SliceValue<char> runeSlice)
            {
                output += "[" + string.Join(" ", runeSlice.Values.Select(v => ((int)v).ToString())) + "]";
            } 
            else if (value is MatrixValue<int> intMatrix)
            {
                output += "[\n";
                foreach (var row in intMatrix.Values)
                {
                    output += "  [" + string.Join(" ", row) + "]\n";
                }
                output += "]";
            }
            else if (value is MatrixValue<double> floatMatrix)
            {
                output += "[\n";
                foreach (var row in floatMatrix.Values)
                {
                    output += "  [" + string.Join(" ", row.Select(v => v.ToString(CultureInfo.InvariantCulture))) + "]\n";
                }
                output += "]";
            }
            else if (value is MatrixValue<string> stringMatrix)
            {
                output += "[\n";
                foreach (var row in stringMatrix.Values)
                {
                    output += "  [" + string.Join(" ", row) + "]\n";
                }
                output += "]";
            }
            else if (value is MatrixValue<bool> boolMatrix)
            {
                output += "[\n";
                foreach (var row in boolMatrix.Values)
                {
                    output += "  [" + string.Join(" ", row) + "]\n";
                }
                output += "]";
            }
            else if (value is MatrixValue<char> runeMatrix)
            {
                output += "[\n";
                foreach (var row in runeMatrix.Values)
                {
                    output += "  [" + string.Join(" ", row.Select(v => ((int)v).ToString())) + "]\n";
                }
                output += "]";
            }
            else
            {
                output += value switch
                {
                    IntValue iVal => iVal.Value.ToString(),
                    FloatValue fVal => fVal.Value.ToString("G", CultureInfo.InvariantCulture),
                    StringValue sVal => sVal.Value,
                    BoolValue bVal => bVal.Value.ToString(),
                    RuneValue rVal => ((int)rVal.Value).ToString(),
                    VoidValue _ => "void",
                    FunctionValue fn => "< fn " + fn.name + " >",
                    _ => throw new SemanticError("Invalid operation", context.Start)
                };
            }

            // Agregar espacio entre valores excepto el último
            if (i < context.expr().Length - 1)
            {
                output += " ";
            }
        }

        output += "\n"; // Nueva línea después de imprimir todo
        return defaultValue;
    }


    // VisitAtoiStmt
    public override ValueWrapper VisitAtoiStmt(LanguageParser.AtoiStmtContext context)
    {
        ValueWrapper value = Visit(context.expr());
        if (value is not StringValue stringValue)
        {
            throw new SemanticError("Invalid operation", context.Start);
        }
        string text = stringValue.Value;

        if (!int.TryParse(text, out int result))
        {
            throw new SemanticError("Invalid operation", context.Start);
        }
        return new IntValue(result);
    }

    //VisitParseFloatStmt
    public override ValueWrapper VisitParseFloatStmt(LanguageParser.ParseFloatStmtContext context) {
        ValueWrapper value = Visit(context.expr());
        if (value is not StringValue stringValue) {
            throw new SemanticError("Invalid operation", context.Start);
        }
        string text = stringValue.Value;

        if (!float.TryParse(text, NumberStyles.Float, CultureInfo.InvariantCulture, out float result)) {
            throw new SemanticError("Invalid operation", context.Start);
        }
        return new FloatValue(result);
    }

    //VisitTypeOfStmt
    public override ValueWrapper VisitTypeOfStmt(LanguageParser.TypeOfStmtContext context)
    {
        ValueWrapper value = Visit(context.expr());
        string type = value switch
        {
            IntValue => "int",
            FloatValue => "float64",
            StringValue => "string",
            BoolValue => "bool",
            RuneValue => "rune",
            SliceValue<int> => "[]int",
            SliceValue<double> => "[]float64",
            SliceValue<string> => "[]string",
            SliceValue<bool> => "[]bool",
            SliceValue<char> => "[]rune",
            _ => "void"
        };
        
        return new StringValue(type);
    }

    // VisitIdentifier
    public override ValueWrapper VisitIdentifier(LanguageParser.IdentifierContext context)
    {
        string id = context.ID().GetText();
        return currentEnvironment.Get(id, context.Start);
    }

    // VisitParens
    public override ValueWrapper VisitParens(LanguageParser.ParensContext context)
    {
        return Visit(context.expr());
    }

    // VisitBrackets
    public override ValueWrapper VisitBrackets(LanguageParser.BracketsContext context)
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
    public override ValueWrapper VisitAssign(LanguageParser.AssignContext context)
{
    var asignee = context.expr(0); // Lado izquierdo de la asignación
    ValueWrapper value = Visit(context.expr(1)); // Lado derecho de la asignación

    if (asignee is LanguageParser.IdentifierContext idContext)
    {
        string id = idContext.ID().GetText();
        ValueWrapper existingValue = currentEnvironment.Get(id, context.Start);

        // Validar que el tipo de la variable existente y el valor asignado sean compatibles
        if (!IsValidType(value, existingValue))
        {
            throw new SemanticError($"Type mismatch: cannot assign value of type {value.GetType().Name} to variable {id} of type {existingValue.GetType().Name}", context.Start);
        }

        currentEnvironment.Assign(id, value, context.Start);
        return defaultValue;
    }
    else if (asignee is LanguageParser.MultiIndexContext multiIndexContext)
    {
        // Manejar asignaciones a elementos específicos de matrices
        string id = multiIndexContext.ID().GetText();
        ValueWrapper matrixValue = currentEnvironment.Get(id, context.Start);

        // Validar que el valor sea una matriz
        if (matrixValue is not MatrixValue<ValueWrapper> matrix)
        {
            throw new SemanticError($"Variable '{id}' is not a valid matrix", context.Start);
        }

        // Obtener los índices
        var rowIndexValue = Visit(multiIndexContext.expr(0));
        var colIndexValue = Visit(multiIndexContext.expr(1));

        if (rowIndexValue is not IntValue rowIndex || colIndexValue is not IntValue colIndex)
        {
            throw new SemanticError("Matrix indices must be integers", context.Start);
        }

        // Validar que los índices estén dentro de los límites
        if (rowIndex.Value < 0 || rowIndex.Value >= matrix.Values.Count ||
            colIndex.Value < 0 || colIndex.Value >= matrix.Values[rowIndex.Value].Count)
        {
            throw new SemanticError("Matrix index out of bounds", context.Start);
        }

        // Asignar el nuevo valor al elemento de la matriz
        matrix.Values[rowIndex.Value][colIndex.Value] = value;
        return defaultValue;
    }
    else if (asignee is LanguageParser.SliceInitContext sliceInitContext)
    {
        // Manejar la inicialización de slices o matrices
        var rows = new List<List<ValueWrapper>>();

        // Procesar cada fila
        foreach (var rowContext in sliceInitContext.row())
        {
            var row = new List<ValueWrapper>();
            foreach (var exprContext in rowContext.expr())
            {
                row.Add(Visit(exprContext));
            }
            rows.Add(row);
        }

        // Crear un MatrixValue con las filas procesadas
        value = new MatrixValue<ValueWrapper>(rows);
        string id = context.expr(0).GetText();
        currentEnvironment.Assign(id, value, context.Start);
        return defaultValue;
    }
    else if (asignee is LanguageParser.CalleContext calleContext)
    {
        ValueWrapper callee = Visit(calleContext.expr());
        // Recorrer cada llamada
        for (int i = 0; i < calleContext.call().Length; i++)
        {
            var action = calleContext.call(i);

            if (i == calleContext.call().Length - 1)
            {
                if (action is LanguageParser.GetContext propertyAccess)
                {
                    if (callee is InstanceValue instanceValue)
                    {
                        var instance = instanceValue.instance;
                        var propertyName = propertyAccess.ID().GetText();
                        instance.Set(propertyName, value);
                    }
                    else
                    {
                        throw new SemanticError("Invalid property access", context.Start);
                    }
                }
                else
                {
                    throw new SemanticError("Invalid assign", context.Start);
                }
            }

            if (action is LanguageParser.FuncCallContext funcCall)
            {
                if (callee is FunctionValue functionValue)
                {
                    callee = VisitCall(functionValue.invocable, funcCall.args());
                }
                else
                {
                    throw new SemanticError("Invalid function call", context.Start);
                }
            }
            else if (action is LanguageParser.GetContext propertyAccess)
            {
                if (callee is InstanceValue instanceValue)
                {
                    callee = instanceValue.instance.Get(propertyAccess.ID().GetText(), propertyAccess.Start);
                }
                else
                {
                    throw new SemanticError("Invalid property access", context.Start);
                }
            }
        }
        return callee;
    }
    else
    {
        throw new SemanticError("Invalid operation", context.Start);
    }
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
                condition = Visit(context.expr(0)); // Reevaluar la condición 
            }
            // TODO ---> TRABAJAR return

        }
    }

    //VisitForInit

    // VisitSwitchStmt
    public override ValueWrapper VisitSwitchStmt(LanguageParser.SwitchStmtContext context)
    {
        // Crear un nuevo entorno
        Environment previousEnvironment = currentEnvironment;
        currentEnvironment = new Environment(previousEnvironment);

        ValueWrapper switchValue = Visit(context.expr());
        bool caseMatched = false;

        foreach (var stmt in context.stmt())
        {
            if (stmt is LanguageParser.CaseStmtContext caseStmt)
            {
                caseMatched = caseMatched || VisitCaseStmt(caseStmt, switchValue);
            }
            else if (stmt is LanguageParser.DefaultStmtContext defaultStmt && !caseMatched)
            {
                VisitDefaultStmt(defaultStmt);
                break;
            }
        }

        // Restaurar el entorno anterior
        currentEnvironment = previousEnvironment;

        return defaultValue;
    }

// VisitCaseStmt mejorado para recibir el valor del switch
    public bool VisitCaseStmt(LanguageParser.CaseStmtContext context, ValueWrapper switchValue)
    {
        ValueWrapper caseValue = Visit(context.expr());

        // Comprobar que los tipos coincidan
        if (switchValue.GetType() != caseValue.GetType())
        {
            throw new SemanticError("Type mismatch in switch case", context.Start);
        }

        // Si los valores coinciden, ejecutamos el bloque del `case`
        if (switchValue.Equals(caseValue))
        {
            try{
                Visit(context.stmt());
            } catch (BreakException) {
                return true; // Indicamos que un `case` ha sido ejecutado
            } catch (ContinueException) {
                throw new SemanticError("Continue is not valid in a switch case", context.Start);
            }
            return true; // Indicamos que un `case` ha sido ejecutado
        }

        return false; // No coincidió
    }

    // VisitDefaultStmt permanece igual
    public override ValueWrapper VisitDefaultStmt(LanguageParser.DefaultStmtContext context)
    {
        Visit(context.stmt());
        return defaultValue;
    }


    //VisitAddSubAssign
    public override ValueWrapper VisitAddSubAssign(LanguageParser.AddSubAssignContext context) {
    string id = context.ID().GetText();

    // Verificar si la variable existe en el entorno
    if (currentEnvironment.Get(id, context.Start) == null) {
        throw new SemanticError("Variable not found", context.Start);
    }

    // Obtener el valor actual de la variable
    ValueWrapper currentVariable = currentEnvironment.Get(id, context.Start);

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
        currentEnvironment.Assign(id, newValue, context.Start);
        
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
        currentEnvironment.Assign(id, newValue, context.Start);
        
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

    //VisitCalle
    public override ValueWrapper VisitCalle(LanguageParser.CalleContext context) {
        ValueWrapper callee = Visit(context.expr());
        // recorrer cada llamada
        foreach (var action in context.call()) 
        {
            if (action is LanguageParser.FuncCallContext funcCall)
            {
                if (callee is FunctionValue functionValue)
                {
                    callee = VisitCall(functionValue.invocable, funcCall.args());
                } 
                else 
                {
                    throw new SemanticError("Invalid function call", context.Start);
                }
            } else if (action is LanguageParser.GetContext propertyAccess)
            {
                if (callee is InstanceValue instanceValue)
                {
                    callee = instanceValue.instance.Get(propertyAccess.ID().GetText(), propertyAccess.Start);
                } else 
                {
                    throw new SemanticError("Invalid property access", context.Start);
                }
            }
            
        }
        return callee;
    }

    public ValueWrapper VisitCall(Invocable invocable, LanguageParser.ArgsContext context) {
        List<ValueWrapper> arguments = new List<ValueWrapper>();
        if (context != null) {
            foreach (var expr in context.expr()) 
            {
                arguments.Add(Visit(expr));
            }
        }
        if (context != null && arguments.Count != invocable.Arity()) {
            throw new SemanticError("Invalid number of arguments", context.Start);
        }
        // TODO validar cantidad de argumentos enviados y el tipo
        return invocable.Invoke(arguments, this);
    }

    //VisitFuncDcl
    public override ValueWrapper VisitFuncDcl(LanguageParser.FuncDclContext context) {
        
        var foreign = new ForeignFunction(currentEnvironment, context);
        currentEnvironment.Declare(context.ID().GetText(), new FunctionValue(foreign, context.ID().GetText()), context.Start);
        

        return defaultValue;
    }

    //VisitClassDcl
    public override ValueWrapper VisitClassDcl (LanguageParser.ClassDclContext context) 
    {
        Dictionary<string, LanguageParser.VarDclContext> props = new Dictionary<string, LanguageParser.VarDclContext>();
        Dictionary<string, ForeignFunction> methods = new Dictionary<string, ForeignFunction>();

        foreach (var prop in context.classBody()) 
        {
            if (prop.varDcl() != null) {
                var vardcl = prop.varDcl();
                props.Add(vardcl.ID().GetText(), vardcl);
            } else if (prop.funcDcl() != null) 
            {
                var funcDcl = prop.funcDcl();
                var foreignFunction = new ForeignFunction(currentEnvironment, funcDcl);
                methods.Add(funcDcl.ID().GetText(), foreignFunction);
            }
        }
        LanguageClass languageClass = new LanguageClass(context.ID().GetText(), props, methods);
        currentEnvironment.Declare(context.ID().GetText(), new ClassValue(languageClass), context.Start);
        return defaultValue;
    }

    // VisitStructDcl
    public override ValueWrapper VisitStructDcl(LanguageParser.StructDclContext context)
    {
        // Obtener el nombre del struct
        string structName = context.ID().GetText();

        // Verificar si el struct ya está declarado
        try
        {
            currentEnvironment.Get(structName, context.Start);
            throw new SemanticError($"Struct '{structName}' is already declared", context.Start);
        }
        catch (KeyNotFoundException)
        {
            // No hacer nada, el struct no está declarado
        }

        // Obtener los atributos del struct
        var attributes = new Dictionary<string, Type>();
        foreach (var attributeContext in context.structAttribute())
        {
            string attributeName = attributeContext.ID().GetText();
            string attributeType = attributeContext.Types().GetText();

            // Validar que el atributo no esté duplicado
            if (attributes.ContainsKey(attributeName))
            {
                throw new SemanticError($"Duplicate attribute '{attributeName}' in struct '{structName}'", context.Start);
            }

            // Registrar el atributo y su tipo
            attributes[attributeName] = GetTypeFromString(attributeType, context.Start);
        }

        // Validar que el struct tenga al menos un atributo
        if (attributes.Count == 0)
        {
            throw new SemanticError($"Struct '{structName}' must have at least one attribute", context.Start);
        }

        // Crear la definición del struct
        var structDefinition = new StructDefinition(structName, attributes);

        // Registrar el struct en el entorno global
        currentEnvironment.Declare(structName, new StructValue(structDefinition), context.Start);

        return defaultValue;
    }

    // Método auxiliar para convertir un tipo de string a Type
    private Type GetTypeFromString(string type, Antlr4.Runtime.IToken token)
    {
        return type switch
        {
            "int" => typeof(int),
            "float64" => typeof(double),
            "string" => typeof(string),
            "bool" => typeof(bool),
            "rune" => typeof(char),
            _ => throw new SemanticError($"Unsupported type '{type}'", token)
        };
    }

    //VisitStructInit
    


    //VisitNew
    public override ValueWrapper VisitNew (LanguageParser.NewContext context) 
    {
        ValueWrapper classValue = currentEnvironment.Get(context.ID().GetText(), context.Start);

        if (classValue is not ClassValue) 
        {
            throw new SemanticError("Invalid class instance", context.Start);
        }

        List<ValueWrapper> arguments = new List<ValueWrapper>();
        if(context.args() != null) 
        {
            foreach (var arg in context.args().expr())
            {
                arguments.Add(Visit(arg));
            }
        }

        var instance = ((ClassValue)classValue).languageClass.Invoke(arguments, this);

        return instance;
    }

}

