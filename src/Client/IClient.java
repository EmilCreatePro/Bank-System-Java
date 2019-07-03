package Client;

/*We need this for BankAccount and EuroAccount*/
import BankAccount.*;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class IClient{
    private String name;
    private String CNP;
    private String address;
    private ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();

    public IClient(String name, String CNP, String address, BankAccount firstBankAccount)
    {
        if(firstBankAccount == null)
        {
            /*Throw exception*/
        }

        this.name = name;
        this.CNP = CNP;
        this.address = address;
        accounts.add(firstBankAccount);
    }

    public String getCNP()
    {
        return CNP;
    }

    public String getAddress()
    {
        return  address;
    }

    public String getName()
    {
        return name;
    }

    public ArrayList<BankAccount> getAccounts()
    {
        return accounts;
    }

    public Double getTotalSum()
    {
        Double retVal = 0.0;

        for(BankAccount acc : accounts)
        {
            retVal += acc.getSumFromAccount();
        }

        return retVal;
    }

    public boolean addBankAccount(BankAccount ba)
    {
        boolean accountAddedSuccesfuly = true;

        if(accounts.size() > 5)
        {
            /*Throw exception*/
            return false;
        }

        for(BankAccount acc : accounts)
        {
            if(ba.getAccountNumber() ==  acc.getAccountNumber())
            {
                accountAddedSuccesfuly = false;
                return accountAddedSuccesfuly;
            }
        }

        accounts.add(ba);
        return accountAddedSuccesfuly;
    }

    public boolean equals(Object o)
    {
        if(o instanceof IClient)
        {
            IClient tempClient = (IClient)o;

            //Maybe would have worked with ==,  but anyways :)
            return this.CNP.equals(tempClient.CNP);
        }
        return false;
    }

    /*Ask through email. Remains to be seen.*/
    public Double getDailyInterestRate()
    {
        Double retVal = 0.0;

        for(BankAccount acc : accounts)
        {
            /*It could have been done with instanceof instead.*/
            if(!acc.isRonAccount())
            {
                /*Do a down-cast in order to get to the desired method.*/
                retVal += ((EuroAccount)acc).getInterestRate();
            }
        }

        return retVal;
    }
}
