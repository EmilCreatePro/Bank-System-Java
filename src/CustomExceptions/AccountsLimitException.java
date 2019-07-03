package CustomExceptions;

public class AccountsLimitException extends  Exception
{
    public AccountsLimitException(String msg)
    {
        super(msg);
    }
}
