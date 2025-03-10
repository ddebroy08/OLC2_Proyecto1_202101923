using System.Data;

public class Embeded
{
    public static void Generate(Environment env)
    {
        env.Declare("time", new FunctionValue(new TimeEmbeded(), "time"), null);
    }
}

public class TimeEmbeded : Invocable
{
    public int Arity(){
        return 0;
    }

    public ValueWrapper Invoke(List<ValueWrapper> args, CompilerVisitor visitor)
    {
        return new StringValue(DateTime.Now.ToString());
    }
}