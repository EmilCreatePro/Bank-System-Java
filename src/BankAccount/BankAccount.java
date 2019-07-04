package BankAccount;

public abstract class BankAccount implements TotalSum {
    protected Integer accountNumber;
    protected Double accountSum;

    public abstract boolean isRonAccount();

    public BankAccount(Double accountSum, Integer accountNumber)
    {
        this.accountSum = accountSum;
        this.accountNumber = accountNumber;
    }

    public Double getAccountSum()
    {
        return accountSum;
    }

    protected boolean subtractSum(Double sumToSubtract)
    {
        boolean retVal = true;

        /*If you don't have enough money you can't withdraw.*/
        if(sumToSubtract > accountSum)
        {
            /*Throw Exception -> not necessary here because we need the false value.*/
            /*This add is necessary in order to keep the same sum in case of subtract fail.*/
            accountSum += sumToSubtract;
            retVal = false;
        }
        else accountSum -= sumToSubtract;

        return retVal;
    }

    protected boolean addSum(Double sumToAdd)
    {
        boolean retVal = true;

        accountSum += sumToAdd;

        return retVal;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public boolean equals(Object o)
    {
        if(o instanceof RonAccount)
        {
            BankAccount tempBA = (BankAccount)o;

            //Maybe would have worked with ==,  but anyways :)
            return this.accountNumber.equals(tempBA.accountNumber);
        }
        return false;
    }
}
