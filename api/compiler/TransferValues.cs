public class BreakException : Exception
{
    public BreakException() : base("Break statement outside loop")
    {
    }
}

public class ContinueException : Exception
{
    public ContinueException() : base("Continue statement outside loop")
    {
    }
}

public class ReturnException : Exception
{
    public ValueWrapper value { get; }

    public ReturnException(ValueWrapper value) : base("Return statement outside function")
    {
        this.value = value;
    }
}