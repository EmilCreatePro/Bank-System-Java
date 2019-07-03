package BankAccount;

public class EuroAccount extends BankAccount {

    private Double interestRate;
    private final double convertFactor = 4.2000;
    private final int interestRateThreshold = 500;
    private final int ZERO = 0;

    public Double getInterestRate()
    {
        if(accountSum < ZERO)
        {
            /*Throw Exception */
        }

        if(accountSum > interestRateThreshold)
            interestRate = 0.001;
        else interestRate = 0.0;

        return interestRate;
    }

    @Override
    public Double getSumFromAccount() { return accountSum*convertFactor; }

    @Override
    public boolean isRonAccount()
    {
        return false;
    }
}
