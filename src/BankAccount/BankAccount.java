package BankAccount;

public abstract class BankAccount implements TotalSum {
    protected Integer accountNumber;
    protected Double accountSum;


    public Double getAccountSum()
    {
        return accountSum;
    }
    public abstract boolean isRonAccount();

    protected boolean subtractSum(Double sumToSubtract)
    {
        boolean retVal = true;

        /*If you don't have enough money you can't withdraw.*/
        if(sumToSubtract > accountSum)
        {
            /*Throw Exception*/
            retVal = false;
            return  retVal;
        }

        else accountSum -= sumToSubtract;

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
