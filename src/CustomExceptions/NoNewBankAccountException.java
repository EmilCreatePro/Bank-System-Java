package CustomExceptions;

public class NoNewBankAccountException extends Exception
{
    public NoNewBankAccountException(String msg)
    {
        super(msg);
    }
}
