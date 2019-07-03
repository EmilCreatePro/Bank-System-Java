package CustomExceptions;

public class MissingAccountException extends Exception
{
    public MissingAccountException(String msg)
    {
        super(msg);
    }
}
