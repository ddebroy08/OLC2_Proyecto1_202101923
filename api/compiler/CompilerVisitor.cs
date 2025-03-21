
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
                "[]int" => new SliceValue<int>(new List<int>()),
                "[]float64" => new SliceValue<double>(new List<double>()),
                "[]string" => new SliceValue<string>(new List<string>()),
                "[]bool" => new SliceValue<bool>(new List<bool>()),
                "[]rune" => new SliceValue<char>(new List<char>()),
                _ => throw new SemanticError("Invalid type", context.Start)
            };
        }
        // Validar si la variable ya existe
        if (currentEnvironment.ExistsInCurrentScope(id))
        {
            // Obtener el valor existente
            ValueWrapper existingValue = currentEnvironment.Get(id, context.Start);

            // Validar que el tipo coincida
            if (!IsValidType(value, existingValue))
            {
                throw new SemanticError($"Type mismatch: cannot assign value of type {value.GetType().Name} to variable {id} of type {existingValue.GetType().Name}", context.Start);
            }

            // Actualizar el valor de la variable existente
            currentEnvironment.Assign(id, value, context.Start);
        }
        else
        {
            // Declarar la nueva variable
            currentEnvironment.Declare(id, value, context.Start);
        }
        // Validar el tipo
        if (!IsValidType(value, GetDefaultValue(type)))
        {
            throw new SemanticError($"Type mismatch: cannot assign value of type {value.GetType().Name} to variable {id} of type {type}", context.Start);
        }

        //currentEnvironment.Declare(id, value, context.Start);
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
        // Validar si la expresión es un acceso a un índice de matriz
        if (context.expr() is LanguageParser.MultiIndexContext multiIndexContext)
        {
            // Obtener el valor del índice de la matriz
            value = VisitMultiIndex(multiIndexContext);
        }

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
        // Obtener el argumento: el slice o matriz
        ValueWrapper value = Visit(context.expr(0));

        // Caso 1: Si es una matriz y no se especifica un índice interno
        if (value is MatrixValue<int> intMatrix)
        {
            return new IntValue(intMatrix.Values.Count); // Cantidad de filas
        }
        else if (value is MatrixValue<double> floatMatrix)
        {
            return new IntValue(floatMatrix.Values.Count);
        }
        else if (value is MatrixValue<string> stringMatrix)
        {
            return new IntValue(stringMatrix.Values.Count);
        }
        else if (value is MatrixValue<bool> boolMatrix)
        {
            return new IntValue(boolMatrix.Values.Count);
        }
        else if (value is MatrixValue<char> runeMatrix)
        {
            return new IntValue(runeMatrix.Values.Count);
        }

        // Caso 2: Si es un slice unidimensional
        if (value is SliceValue<int> intSlice)
        {
            return new IntValue(intSlice.Values.Count);
        }
        else if (value is SliceValue<double> floatSlice)
        {
            return new IntValue(floatSlice.Values.Count);
        }
        else if (value is SliceValue<string> stringSlice)
        {
            return new IntValue(stringSlice.Values.Count);
        }
        else if (value is SliceValue<bool> boolSlice)
        {
            return new IntValue(boolSlice.Values.Count);
        }
        else if (value is SliceValue<char> runeSlice)
        {
            return new IntValue(runeSlice.Values.Count);
        }

        // Caso 3: Si se especifica un índice interno (matriz 2D)
        if (value is MatrixValue<int> intMatrixWithIndex && context.expr().Length > 1)
        {
            ValueWrapper indexValue = Visit(context.expr(1));
            if (indexValue is not IntValue intIndex)
            {
                throw new SemanticError("Matrix index must be an integer", context.Start);
            }

            // Validar que el índice esté dentro de los límites
            if (intIndex.Value < 0 || intIndex.Value >= intMatrixWithIndex.Values.Count)
            {
                throw new SemanticError("Matrix index out of bounds", context.Start);
            }

            return new IntValue(intMatrixWithIndex.Values[intIndex.Value].Count); // Longitud del slice en la fila especificada
        }

        // Si no coincide con ninguno de los casos anteriores, lanzar un error
        throw new SemanticError("Invalid argument for len function", context.Start);
    }


    //VisitIndex
/*
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
*/
    // VisitIndexAssig
/*
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

*/
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
        /*
        // Validación si se quisiera que tuvieran el mismo tamaño los slices 
        int? rowLength = null;
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

        // Mensaje de depuración para confirmar el tipo de la matriz
        Console.WriteLine($"Declarando matriz '{id}' como {value.GetType()}");

        // Declarar la matriz en el entorno
        currentEnvironment.Declare(id, value, context.Start);

        return defaultValue;
    }

    //VisitMultiIndexAssig
    public override ValueWrapper VisitMultiIndexAssig(LanguageParser.MultiIndexAssigContext context)
    {
        string id = context.ID().GetText();
        ValueWrapper value = currentEnvironment.Get(id, context.Start);
        Console.WriteLine($"Depuración: expr(1) es {(context.expr(1) == null ? "nulo" : "no nulo")}");

        // Caso: Slice (solo un índice)
        if (context.expr(1) == null)
        {
            Console.WriteLine("**********************************************");
            Console.WriteLine("**********************************************");
            Console.WriteLine("**********************************************");
            Console.WriteLine("Depuración: Procesando un slice unidimensional.");
            Console.WriteLine("**********************************************");
            Console.WriteLine("**********************************************");
            Console.WriteLine("**********************************************");
            // Obtener el índice y el nuevo valor
            ValueWrapper indexValue = Visit(context.expr(0));
            ValueWrapper newValue = Visit(context.expr(2));

            if (indexValue is not IntValue intIndex)
            {
                throw new SemanticError("Index must be an integer", context.Start);
            }

            // Validar que la variable sea un slice
            if (value is not SliceValue<int> &&
                value is not SliceValue<double> &&
                value is not SliceValue<string> &&
                value is not SliceValue<bool> &&
                value is not SliceValue<char>)
            {
                throw new SemanticError($"Variable '{id}' is not a valid slice", context.Start);
            }

            // Validar límites del slice
            int sliceLength = value switch
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

            // Asignar el nuevo valor al índice del slice
            switch (value)
            {
                case SliceValue<int> intSlice:
                    if (newValue is IntValue intVal)
                    {
                        intSlice.Values[intIndex.Value] = intVal.Value;
                    }
                    else if (newValue is FloatValue floatValForInt)
                    {
                        intSlice.Values[intIndex.Value] = (int)floatValForInt.Value; // Conversión implícita
                    }
                    else
                    {
                        throw new SemanticError("Type mismatch: cannot assign value to int slice", context.Start);
                    }
                    break;

                case SliceValue<double> floatSlice:
                    if (newValue is FloatValue floatValForDouble)
                    {
                        floatSlice.Values[intIndex.Value] = floatValForDouble.Value;
                    }
                    else if (newValue is IntValue intValForDouble)
                    {
                        floatSlice.Values[intIndex.Value] = (double)intValForDouble.Value; // Conversión implícita
                    }
                    else
                    {
                        throw new SemanticError("Type mismatch: cannot assign value to float64 slice", context.Start);
                    }
                    break;

                case SliceValue<string> stringSlice:
                    if (newValue is StringValue strVal)
                    {
                        stringSlice.Values[intIndex.Value] = strVal.Value;
                    }
                    else
                    {
                        throw new SemanticError("Type mismatch: cannot assign value to string slice", context.Start);
                    }
                    break;

                case SliceValue<bool> boolSlice:
                    if (newValue is BoolValue boolVal)
                    {
                        boolSlice.Values[intIndex.Value] = boolVal.Value;
                    }
                    else
                    {
                        throw new SemanticError("Type mismatch: cannot assign value to bool slice", context.Start);
                    }
                    break;

                case SliceValue<char> runeSlice:
                    if (newValue is RuneValue runeVal)
                    {
                        runeSlice.Values[intIndex.Value] = runeVal.Value;
                    }
                    else
                    {
                        throw new SemanticError("Type mismatch: cannot assign value to rune slice", context.Start);
                    }
                    break;

                default:
                    throw new SemanticError("Type mismatch or invalid slice type", context.Start);
            }

            return defaultValue;
        }
        // Caso: Matriz (dos índices)
        else
        {
            // Obtener los índices de fila y columna, y el nuevo valor
            ValueWrapper rowIndexValue = Visit(context.expr(0));
            ValueWrapper colIndexValue = Visit(context.expr(1));
            ValueWrapper newValue = Visit(context.expr(2));

            if (rowIndexValue is not IntValue rowIndex || colIndexValue is not IntValue colIndex)
            {
                throw new SemanticError("Matrix indices must be integers", context.Start);
            }

            // Validar que la variable sea una matriz
            if (value is not MatrixValue<int> &&
                value is not MatrixValue<double> &&
                value is not MatrixValue<string> &&
                value is not MatrixValue<bool> &&
                value is not MatrixValue<char>)
            {
                throw new SemanticError($"VisitMultiIndexAssig: Variable '{id}' is not a valid matrix ", context.Start);
            }

            // Validar límites de la matriz
            int rowCount = value switch
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

            int colCount = value switch
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

            // Asignar el nuevo valor al elemento de la matriz
            switch (value)
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
        }

        return defaultValue;
    }

    
    // VisitMultiIndex
    public override ValueWrapper VisitMultiIndex(LanguageParser.MultiIndexContext context)
    {
        string id = context.ID().GetText();
        ValueWrapper value = currentEnvironment.Get(id, context.Start);

        // Mensaje de depuración para verificar el tipo de la variable
        Console.WriteLine($"Accediendo a la variable '{id}' como {value.GetType()}");

        // Caso: Slice (solo un índice)
        if (context.expr(1) == null)
        {
            // Obtener el índice del slice
            ValueWrapper indexValue = Visit(context.expr(0));

            if (indexValue is not IntValue intIndex)
            {
                throw new SemanticError("Index must be an integer", context.Start);
            }

            // Validar si es una matriz y solo se especifica un índice
            if (value is MatrixValue<int> intMatrix)
            {
                if (intIndex.Value < 0 || intIndex.Value >= intMatrix.Values.Count)
                {
                    throw new SemanticError("Row index out of bounds", context.Start);
                }
                return new SliceValue<int>(intMatrix.Values[intIndex.Value]); // Retornar el slice correspondiente
            }
            else if (value is MatrixValue<double> floatMatrix)
            {
                if (intIndex.Value < 0 || intIndex.Value >= floatMatrix.Values.Count)
                {
                    throw new SemanticError("Row index out of bounds", context.Start);
                }
                return new SliceValue<double>(floatMatrix.Values[intIndex.Value]);
            }
            else if (value is MatrixValue<string> stringMatrix)
            {
                if (intIndex.Value < 0 || intIndex.Value >= stringMatrix.Values.Count)
                {
                    throw new SemanticError("Row index out of bounds", context.Start);
                }
                return new SliceValue<string>(stringMatrix.Values[intIndex.Value]);
            }
            else if (value is MatrixValue<bool> boolMatrix)
            {
                if (intIndex.Value < 0 || intIndex.Value >= boolMatrix.Values.Count)
                {
                    throw new SemanticError("Row index out of bounds", context.Start);
                }
                return new SliceValue<bool>(boolMatrix.Values[intIndex.Value]);
            }
            else if (value is MatrixValue<char> runeMatrix)
            {
                if (intIndex.Value < 0 || intIndex.Value >= runeMatrix.Values.Count)
                {
                    throw new SemanticError("Row index out of bounds", context.Start);
                }
                return new SliceValue<char>(runeMatrix.Values[intIndex.Value]);
            }


            // Validar que la variable sea un slice
            if (value is not SliceValue<int> &&
                value is not SliceValue<double> &&
                value is not SliceValue<string> &&
                value is not SliceValue<bool> &&
                value is not SliceValue<char>)
            {
                throw new SemanticError($"Variable '{id}' is not a valid slice", context.Start);
            }

            // Validar límites del slice
            int sliceLength = value switch
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

            // Retornar el valor del slice
            return value switch
            {
                SliceValue<int> intSlice => new IntValue(intSlice.Values[intIndex.Value]),
                SliceValue<double> floatSlice => new FloatValue(floatSlice.Values[intIndex.Value]),
                SliceValue<string> stringSlice => new StringValue(stringSlice.Values[intIndex.Value]),
                SliceValue<bool> boolSlice => new BoolValue(boolSlice.Values[intIndex.Value]),
                SliceValue<char> runeSlice => new RuneValue(runeSlice.Values[intIndex.Value]),
                _ => throw new SemanticError("Invalid slice type", context.Start)
            };

        }
        // Caso: Matriz (dos índices)
        else
        {
            // Obtener los índices de fila y columna
            ValueWrapper rowIndexValue = Visit(context.expr(0));
            ValueWrapper colIndexValue = Visit(context.expr(1));

            if (rowIndexValue is not IntValue rowIndex || colIndexValue is not IntValue colIndex)
            {
                throw new SemanticError("Matrix indices must be integers", context.Start);
            }

            // Validar que la variable sea una matriz
            if (value is not MatrixValue<int> &&
                value is not MatrixValue<double> &&
                value is not MatrixValue<string> &&
                value is not MatrixValue<bool> &&
                value is not MatrixValue<char>)
            {
                throw new SemanticError($"VisitMultiIndex:Variable '{id}' is not a valid matrix ", context.Start);
            }

            // Validar límites de la matriz
            int rowCount = value switch
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

            int colCount = value switch
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

            // Retornar el valor de la matriz
            return value switch
            {
                MatrixValue<int> intMatrix => new IntValue(intMatrix.Values[rowIndex.Value][colIndex.Value]),
                MatrixValue<double> floatMatrix => new FloatValue(floatMatrix.Values[rowIndex.Value][colIndex.Value]),
                MatrixValue<string> stringMatrix => new StringValue(stringMatrix.Values[rowIndex.Value][colIndex.Value]),
                MatrixValue<bool> boolMatrix => new BoolValue(boolMatrix.Values[rowIndex.Value][colIndex.Value]),
                MatrixValue<char> runeMatrix => new RuneValue(runeMatrix.Values[rowIndex.Value][colIndex.Value]),
                _ => throw new SemanticError("Invalid matrix type", context.Start)
            };
        }
    }


    // Validar tipos de datos
    private bool IsValidType(ValueWrapper value, ValueWrapper existingValue)
    {
        // Validar si alguno de los valores es null
        if (value == null || existingValue == null)
        {
            return false;
        }

        // Mensaje de depuración
        Console.WriteLine($"Comparando tipos: {existingValue.GetType().Name} con {value.GetType().Name}");

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

    public override ValueWrapper VisitSliceInit(LanguageParser.SliceInitContext context)
    {
        string type = context.Types().GetText(); // Obtener el tipo del slice
        var values = new List<ValueWrapper>();

        foreach (var expr in context.expr())
        {
            values.Add(Visit(expr));
        }

        return type switch
        {
            "int" => new SliceValue<int>(values.Cast<IntValue>().Select(v => v.Value).ToList()),
            "float64" => new SliceValue<double>(values.Cast<FloatValue>().Select(v => v.Value).ToList()),
            "string" => new SliceValue<string>(values.Cast<StringValue>().Select(v => v.Value).ToList()),
            "bool" => new SliceValue<bool>(values.Cast<BoolValue>().Select(v => v.Value).ToList()),
            "rune" => new SliceValue<char>(values.Cast<RuneValue>().Select(v => v.Value).ToList()),
            _ => throw new SemanticError("Invalid slice type", context.Start)
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
                output += "[";
                foreach (var row in intMatrix.Values)
                {
                    output += "  [" + string.Join(" ", row) + "]";
                }
                output += " ]";
            }
            else if (value is MatrixValue<double> floatMatrix)
            {
                output += "[";
                foreach (var row in floatMatrix.Values)
                {
                    output += "  [" + string.Join(" ", row.Select(v => v.ToString(CultureInfo.InvariantCulture))) + "]";
                }
                output += " ]";
            }
            else if (value is MatrixValue<string> stringMatrix)
            {
                output += "[";
                foreach (var row in stringMatrix.Values)
                {
                    output += "  [" + string.Join(" ", row) + "]";
                }
                output += " ]";
            }
            else if (value is MatrixValue<bool> boolMatrix)
            {
                output += "[";
                foreach (var row in boolMatrix.Values)
                {
                    output += "  [" + string.Join(" ", row) + "]";
                }
                output += " ]";
            }
            else if (value is MatrixValue<char> runeMatrix)
            {
                output += "[";
                foreach (var row in runeMatrix.Values)
                {
                    output += "  [" + string.Join(" ", row.Select(v => ((int)v).ToString())) + "]";
                }
                output += " ]";
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
        // Caso 1: Asignación a una variable simple
        string id = idContext.ID().GetText();
        ValueWrapper existingValue = currentEnvironment.Get(id, context.Start);

        // Validar que la variable ya esté declarada
        if (existingValue == null)
        {
            throw new SemanticError($"Variable '{id}' is not declared", context.Start);
        }

        // Validar que el tipo de la variable existente y el valor asignado sean compatibles
        if (!IsValidType(value, existingValue))
        {
            throw new SemanticError($"Type mismatch: cannot assign value of type {value.GetType().Name} to variable {id} of type {existingValue.GetType().Name}", context.Start);
        }

        // Asignar el nuevo valor a la variable
        currentEnvironment.Assign(id, value, context.Start);
        return defaultValue;
    }
    else if (asignee is LanguageParser.MultiIndexContext multiIndexContext)
    {
        // Obtener el identificador de la variable
        string id = multiIndexContext.ID().GetText();
        ValueWrapper variableValue = currentEnvironment.Get(id, context.Start);

        // Caso: La variable es un slice
        if (variableValue is SliceValue<int> ||
            variableValue is SliceValue<double> ||
            variableValue is SliceValue<string> ||
            variableValue is SliceValue<bool> ||
            variableValue is SliceValue<char>)
        {
            Console.WriteLine($"VisitAssign: Procesando asignación a un índice de un slice '{id}'.");

            // Obtener el índice
            ValueWrapper indexValue = Visit(multiIndexContext.expr(0));
            if (indexValue is not IntValue intIndex)
            {
                throw new SemanticError("Slice index must be an integer", context.Start);
            }

            // Validar que el índice esté dentro de los límites
            int sliceLength = variableValue switch
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
                throw new SemanticError("Slice index out of bounds", context.Start);
            }

            // Asignar el nuevo valor al índice del slice
            switch (variableValue)
            {
                case SliceValue<int> intSlice when value is IntValue intValue:
                    intSlice.Values[intIndex.Value] = intValue.Value;
                    break;

                case SliceValue<double> floatSlice when value is FloatValue floatValue:
                    floatSlice.Values[intIndex.Value] = floatValue.Value;
                    break;

                case SliceValue<string> stringSlice when value is StringValue stringValue:
                    stringSlice.Values[intIndex.Value] = stringValue.Value;
                    break;

                case SliceValue<bool> boolSlice when value is BoolValue boolValue:
                    boolSlice.Values[intIndex.Value] = boolValue.Value;
                    break;

                case SliceValue<char> runeSlice when value is RuneValue runeValue:
                    runeSlice.Values[intIndex.Value] = runeValue.Value;
                    break;

                default:
                    throw new SemanticError("Type mismatch or invalid slice type", context.Start);
            }

            return defaultValue;
        }

        // Caso: La variable es una matriz
        if (variableValue is MatrixValue<int> ||
            variableValue is MatrixValue<double> ||
            variableValue is MatrixValue<string> ||
            variableValue is MatrixValue<bool> ||
            variableValue is MatrixValue<char>)
        {
            Console.WriteLine($"VisitAssign: Procesando asignación a un índice de una matriz '{id}'.");

            // Obtener los índices de fila y columna
            ValueWrapper rowIndexValue = Visit(multiIndexContext.expr(0));
            ValueWrapper colIndexValue = Visit(multiIndexContext.expr(1));

            if (rowIndexValue is not IntValue rowIndex || colIndexValue is not IntValue colIndex)
            {
                throw new SemanticError("Matrix indices must be integers", context.Start);
            }

            // Validar que los índices estén dentro de los límites
            int rowCount = variableValue switch
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

            int colCount = variableValue switch
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

            // Asignar el nuevo valor al elemento de la matriz
            switch (variableValue)
            {
                case MatrixValue<int> intMatrix when value is IntValue intValue:
                    intMatrix.Values[rowIndex.Value][colIndex.Value] = intValue.Value;
                    break;

                case MatrixValue<double> floatMatrix when value is FloatValue floatValue:
                    floatMatrix.Values[rowIndex.Value][colIndex.Value] = floatValue.Value;
                    break;

                case MatrixValue<string> stringMatrix when value is StringValue stringValue:
                    stringMatrix.Values[rowIndex.Value][colIndex.Value] = stringValue.Value;
                    break;

                case MatrixValue<bool> boolMatrix when value is BoolValue boolValue:
                    boolMatrix.Values[rowIndex.Value][colIndex.Value] = boolValue.Value;
                    break;

                case MatrixValue<char> runeMatrix when value is RuneValue runeValue:
                    runeMatrix.Values[rowIndex.Value][colIndex.Value] = runeValue.Value;
                    break;

                default:
                    throw new SemanticError("Type mismatch or invalid matrix type", context.Start);
            }

            return defaultValue;
        }

        // Si no es ni un slice ni una matriz, lanzar un error
        throw new SemanticError($"Variable '{id}' is not a valid slice or matrix", context.Start);
    }

    // LLAMADAS A FUNCIONES
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

        //Evaluando la condición inicial
        ValueWrapper condition = Visit(context.expr());
        if (condition is not BoolValue)
        {
            throw new SemanticError("Invalid condition", context.Start);
        }

        // Ejecutar el cuerpo del bucle mientras la condición sea verdadera
        while ((condition as BoolValue).Value)
        {
            try
            {
                // Ejecutar el cuerpo del bucle
                Visit(context.stmt());

                // Reevaluar la condición
                condition = Visit(context.expr());
                if (condition is not BoolValue)
                {
                    throw new SemanticError("Invalid condition", context.Start);
                }
            }
            catch (BreakException)
            {
                // Salir del bucle si se encuentra un "break"
                break;
            }
            catch (ContinueException)
            {
                // Continuar con la siguiente iteración
                condition = Visit(context.expr());
                if (condition is not BoolValue)
                {
                    throw new SemanticError("Invalid condition", context.Start);
                }
            }
        }

        currentEnvironment = previousEnvironment;
        return defaultValue;
    }

        //VisitForStmtIni
public override ValueWrapper VisitForStmtIni(LanguageParser.ForStmtIniContext context)
{
    Console.WriteLine("Entrando al bucle for clásico");

    // Guardar el entorno actual y crear uno nuevo para el bucle
    Environment previousEnvironment = currentEnvironment;
    currentEnvironment = new Environment(previousEnvironment);

    // 1. Inicialización
    if (context.forInit().shortVarDcl() != null)
    {
        Console.WriteLine("Inicializando el bucle");
        Visit(context.forInit().shortVarDcl());
    }
    else
    {
        Visit(context.forInit().expr());
    }

    // 2. Evaluar la condición inicial
    ValueWrapper condition = Visit(context.expr(0));
    Console.WriteLine($"Condición inicial: {condition}");
    if (condition is not BoolValue)
    {
        throw new SemanticError("Invalid condition", context.Start);
    }

    // 3. Ejecutar el cuerpo del bucle mientras la condición sea verdadera
    while ((condition as BoolValue).Value)
    {
        try
        {
            Console.WriteLine("Ejecutando el cuerpo del bucle");
            Visit(context.stmt());

            Console.WriteLine("Ejecutando la actualización");
            Visit(context.expr(1));

            Console.WriteLine("Reevaluando la condición");
            condition = Visit(context.expr(0));
            if (condition is not BoolValue)
            {
                throw new SemanticError("Invalid condition", context.Start);
            }
        }
        catch (BreakException)
        {
            Console.WriteLine("Break encontrado, saliendo del bucle");
            break;
        }
        catch (ContinueException)
        {
            Console.WriteLine("Continue encontrado, reevaluando la condición");
            Visit(context.expr(1));
            condition = Visit(context.expr(0));
            if (condition is not BoolValue)
            {
                throw new SemanticError("Invalid condition", context.Start);
            }
        }
    }

    // Restaurar el entorno anterior
    currentEnvironment = previousEnvironment;
    Console.WriteLine("Saliendo del bucle for clásico");
    return defaultValue;
}
/*
    public void VisitForBody(LanguageParser.ForStmtIniContext context)
{
    ValueWrapper condition = Visit(context.expr()); // Evaluar la condición del for

    while (condition is BoolValue boolCondition && boolCondition.Value)
    {
        try
        {
            Visit(context.stmt(0)); // Ejecutar el cuerpo del for
            Visit(context.stmt(1)); // Ejecutar la actualización (stmt en lugar de expr)
            condition = Visit(context.expr()); // Reevaluar la condición
        }
        catch (BreakException)
        {
            break; // Salir del bucle si hay un "break"
        }
        catch (ContinueException)
        {
            Visit(context.stmt(1)); // Ejecutar la actualización antes de continuar
            condition = Visit(context.expr()); // Reevaluar la condición
        }
    }
}
*/
    //VisitForRangeStmt
    public override ValueWrapper VisitForRangeStmt(LanguageParser.ForRangeStmtContext context)
    {
        // Obtener los identificadores para índice y valor
        string indexVar = context.ID(0).GetText();
        string valueVar = context.ID(1).GetText();

        // Evaluar el slice o matriz
        ValueWrapper collection = Visit(context.expr());

        // Validar que sea un slice o matriz
        if (collection is not SliceValue<int> &&
            collection is not SliceValue<double> &&
            collection is not SliceValue<string> &&
            collection is not SliceValue<bool> &&
            collection is not SliceValue<char>)
        {
            throw new SemanticError("Range can only be used with slices or matrices", context.Start);
        }

        // Iterar sobre el slice o matriz
        if (collection is SliceValue<int> intSlice)
        {
            for (int i = 0; i < intSlice.Values.Count; i++)
            {
                // Crear un nuevo entorno para cada iteración
                Environment previousEnvironment = currentEnvironment;
                currentEnvironment = new Environment(previousEnvironment);

                // Declarar índice y valor en el entorno temporal
                currentEnvironment.Declare(indexVar, new IntValue(i), context.Start);
                currentEnvironment.Declare(valueVar, new IntValue(intSlice.Values[i]), context.Start);

                // Ejecutar el cuerpo del bucle
                Visit(context.stmt());

                // Restaurar el entorno anterior
                currentEnvironment = previousEnvironment;
            }
        }
        else if (collection is SliceValue<double> floatSlice)
        {
            for (int i = 0; i < floatSlice.Values.Count; i++)
            {
                Environment previousEnvironment = currentEnvironment;
                currentEnvironment = new Environment(previousEnvironment);

                currentEnvironment.Declare(indexVar, new IntValue(i), context.Start);
                currentEnvironment.Declare(valueVar, new FloatValue(floatSlice.Values[i]), context.Start);

                Visit(context.stmt());

                currentEnvironment = previousEnvironment;
            }
        }
        else if (collection is SliceValue<string> stringSlice)
        {
            for (int i = 0; i < stringSlice.Values.Count; i++)
            {
                Environment previousEnvironment = currentEnvironment;
                currentEnvironment = new Environment(previousEnvironment);

                currentEnvironment.Declare(indexVar, new IntValue(i), context.Start);
                currentEnvironment.Declare(valueVar, new StringValue(stringSlice.Values[i]), context.Start);

                Visit(context.stmt());

                currentEnvironment = previousEnvironment;
            }
        }
        else if (collection is SliceValue<bool> boolSlice)
        {
            for (int i = 0; i < boolSlice.Values.Count; i++)
            {
                Environment previousEnvironment = currentEnvironment;
                currentEnvironment = new Environment(previousEnvironment);

                currentEnvironment.Declare(indexVar, new IntValue(i), context.Start);
                currentEnvironment.Declare(valueVar, new BoolValue(boolSlice.Values[i]), context.Start);

                Visit(context.stmt());

                currentEnvironment = previousEnvironment;
            }
        }
        else if (collection is SliceValue<char> runeSlice)
        {
            for (int i = 0; i < runeSlice.Values.Count; i++)
            {
                Environment previousEnvironment = currentEnvironment;
                currentEnvironment = new Environment(previousEnvironment);

                currentEnvironment.Declare(indexVar, new IntValue(i), context.Start);
                currentEnvironment.Declare(valueVar, new RuneValue(runeSlice.Values[i]), context.Start);

                Visit(context.stmt());

                currentEnvironment = previousEnvironment;
            }
        }

        return defaultValue;
    }

    //VisitForInit



    // VisitSwitchStmt
public override ValueWrapper VisitSwitchStmt(LanguageParser.SwitchStmtContext context)
{
    // Crear un nuevo entorno para el switch
    Environment previousEnvironment = currentEnvironment;
    currentEnvironment = new Environment(previousEnvironment);

    try
    {
        // Evaluar la expresión del switch UNA SOLA VEZ
        ValueWrapper switchValue = Visit(context.expr());
        
        // Indica si algún case ha coincidido
        bool caseMatched = false;
        
        // Iterar solo sobre los nodos de tipo switchCase
        foreach (var switchCase in context.switchCase())
        {
            // Si ya encontramos una coincidencia, salimos del bucle
            if (caseMatched)
                break;
                
            if (switchCase is LanguageParser.CaseStmtContext caseStmt)
            {
                // Evaluar la expresión del case
                ValueWrapper caseValue = Visit(caseStmt.expr());
                
                // Verificar tipos y valores
                if (switchValue.GetType() != caseValue.GetType())
                {
                    throw new SemanticError("Type mismatch in switch case", caseStmt.Start);
                }
                
                // Comprobamos si el valor del switch coincide con el valor del case
                if (switchValue.Equals(caseValue))
                {
                    // IMPORTANTE: Ejecutamos SOLO las instrucciones del case que coincide
                    caseMatched = true;
                    
                    try
                    {
                        foreach (var stmt in caseStmt.stmt())
                        {
                            Visit(stmt);
                        }
                    }
                    catch (BreakException)
                    {
                        // Salir del switch al encontrar break
                        break;
                    }
                }
            }
            else if (switchCase is LanguageParser.DefaultStmtContext defaultStmt && !caseMatched)
            {
                // Ejecutar el default SOLO si no hay coincidencias
                try
                {
                    foreach (var stmt in defaultStmt.stmt())
                    {
                        Visit(stmt);
                    }
                }
                catch (BreakException)
                {
                    // Salir del switch al encontrar break
                    break;
                }
                
                // No es necesario seguir después del default
                break;
            }
        }
    }
    finally
    {
        // Restaurar el entorno anterior
        currentEnvironment = previousEnvironment;
    }
    
    return defaultValue;
}


    // VisitCaseStmt
    public override ValueWrapper VisitCaseStmt(LanguageParser.CaseStmtContext context)
    {
        // Este método se llama directamente desde el visitante, no desde VisitSwitchStmt
        // porque el árbol ya habrá sido visitado por el VisitSwitchStmt
        
        // Si se llama directamente, ejecutar todas las instrucciones del case
        foreach (var stmt in context.stmt())
        {
            Visit(stmt);
        }
        
        return defaultValue;
    }

    // VisitDefaultStmt
    public override ValueWrapper VisitDefaultStmt(LanguageParser.DefaultStmtContext context)
    {
        // Este método se llama directamente desde el visitante, no desde VisitSwitchStmt
        // porque el árbol ya habrá sido visitado por el VisitSwitchStmt
        
        // Si se llama directamente, ejecutar todas las instrucciones del default
        foreach (var stmt in context.stmt())
        {
            Visit(stmt);
        }
        
        return defaultValue;
    } 
    


    //VisitIncrementStmt
    public override ValueWrapper VisitIncrementStmt(LanguageParser.IncrementStmtContext context)
    {
        string id = context.ID().GetText();

        // Verificar si la variable existe en el entorno
        ValueWrapper variable = currentEnvironment.Get(id, context.Start);
        if (variable == null)
        {
            throw new SemanticError($"Variable '{id}' not declared", context.Start);
        }

        // Validar que la variable sea un entero o flotante
        if (variable is IntValue intValue)
        {
            currentEnvironment.Assign(id, new IntValue(intValue.Value + 1), context.Start);
        }
        else if (variable is FloatValue floatValue)
        {
            currentEnvironment.Assign(id, new FloatValue(floatValue.Value + 1), context.Start);
        }
        else
        {
            throw new SemanticError($"Operator '++' not supported for type {variable.GetType().Name}", context.Start);
        }

        return defaultValue;
    }

    //VisitDecrementStmt
    public override ValueWrapper VisitDecrementStmt(LanguageParser.DecrementStmtContext context)
    {
        string id = context.ID().GetText();

        // Verificar si la variable existe en el entorno
        ValueWrapper variable = currentEnvironment.Get(id, context.Start);
        if (variable == null)
        {
            throw new SemanticError($"Variable '{id}' not declared", context.Start);
        }

        // Validar que la variable sea un entero o flotante
        if (variable is IntValue intValue)
        {
            currentEnvironment.Assign(id, new IntValue(intValue.Value - 1), context.Start);
        }
        else if (variable is FloatValue floatValue)
        {
            currentEnvironment.Assign(id, new FloatValue(floatValue.Value - 1), context.Start);
        }
        else
        {
            throw new SemanticError($"Operator '--' not supported for type {variable.GetType().Name}", context.Start);
        }

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

