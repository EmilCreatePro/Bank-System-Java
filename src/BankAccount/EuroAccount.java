package BankAccount;

import CustomExceptions.NegativeSum;

public class EuroAccount extends BankAccount {

    private Double interestRate;
    private final double convertFactor = 4.2000;
    private final int interestRateThreshold = 500;
    private final int ZERO = 0;

    public Double getInterestRate() throws NegativeSum
    {
        interestRate = 0.0;

        if(accountSum < ZERO)
        {
            throw new NegativeSum("You have debt my friend =))) ");
            /*Throw Exception */
        }

        if(accountSum > interestRateThreshold)
            interestRate = 0.001;

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
