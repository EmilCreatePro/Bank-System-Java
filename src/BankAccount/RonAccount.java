package BankAccount;

import CustomExceptions.*;

public class RonAccount extends BankAccount{

    public RonAccount(Double accountSum, Integer accountNumber)
    {
        super(accountSum, accountNumber);
    }

    @Override
    public Double getSumFromAccount() { return accountSum; }

    public boolean transferMoneyAccount(BankAccount baDest, Double sum) throws NotRONAccountException, InsufficientFundsException
    {
        boolean transferSuccessful = false;

        /*If both are RON accounts, because only with those you can transfer money.*/
        if(this.isRonAccount() == true && baDest.isRonAccount() == true)
        {
            /*If there is enough money to transfer.*/
            if(this.subtractSum(sum) && baDest.addSum(sum))
            {
                transferSuccessful = true;
            }
            else
            {
                /*Throw not enough money exception*/
                throw new InsufficientFundsException("You don't have enough money!");
            }
        }
        else
        {
            /*Throw not RON accounts exception.*/
            throw new NotRONAccountException("You can only transfer between RON accounts!");
        }

        return transferSuccessful;
    }

    @Override
    public boolean isRonAccount()
    {
        return true;
    }
}
