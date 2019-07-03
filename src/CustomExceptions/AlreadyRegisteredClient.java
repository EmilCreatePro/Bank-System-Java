package CustomExceptions;

public class AlreadyRegisteredClient extends Exception
{
    public AlreadyRegisteredClient(String msg)
    {
        super(msg);
    }
}
