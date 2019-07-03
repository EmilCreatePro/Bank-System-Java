package BankAccount;

public class RonAccount extends BankAccount{

    @Override
    public Double getSumFromAccount() { return accountSum; }

    public boolean transferMoneyAccount(BankAccount baDest, Double sum)
    {
        boolean transferSuccessful = false;

        /*If both are RON accounts, because only with those you can transfer money.*/
        if(this.isRonAccount() == true && baDest.isRonAccount() == true)
        {
            /*If there is enough money to transfer.*/
            if(this.subtractSum(sum))
            {
                transferSuccessful = true;
            }
            else
            {
                /*Throw not enough money exception*/
            }
        }
        else
        {
            /*Throw not RON accounts exception.*/
        }

        return transferSuccessful;
    }

    @Override
    public boolean isRonAccount()
    {
        return true;
    }
}
