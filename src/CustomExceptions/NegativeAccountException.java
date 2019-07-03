package CustomExceptions;

public class NegativeAccountException extends Exception
{
    public NegativeAccountException(String msg)
    {
        super(msg);
    }
}
