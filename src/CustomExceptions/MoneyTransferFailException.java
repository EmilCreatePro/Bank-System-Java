package CustomExceptions;

public class MoneyTransferFailException extends Exception
{
    public MoneyTransferFailException(String msg)
    {
        super(msg);
    }
}
