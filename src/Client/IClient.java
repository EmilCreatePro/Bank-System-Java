package Client;

/*We need this for BankAccount and EuroAccount*/
import BankAccount.*;

import CustomExceptions.AccountsLimitException;
import CustomExceptions.IncorrectCNP;
import CustomExceptions.NegativeSum;
import CustomExceptions.NoNewBankAccountException;

/*We need this for regular expressions*/
import java.util.regex.*;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class IClient{
    private String name;
    private String CNP;
    private String address;
    private ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();

    private boolean checkCNP(String testCNP)
    {
        boolean patternCorrect = true;

        String patternLetters = "^A-Z";
        String patternNr = "^0-9";

        /*It's hardcoded ;) But we know that a CNP has 13 characters and that the last 4 are numbers.*/
        String letterParts="", nrParts = "";

        for(int i = 0; i < 9; i++)
        {
            letterParts += testCNP.charAt(i);
        }

        for(int i = 9; i < 13; i++)
        {
            nrParts += testCNP.charAt(i);
        }

        // Create a Pattern object
        Pattern letters = Pattern.compile(patternLetters);

        // Create a Pattern object
        Pattern numbers = Pattern.compile(patternNr);

        Matcher matchLetters = letters.matcher(letterParts);
        Matcher matchNumbers = numbers.matcher(nrParts);

        /*If one of them is true then we have found a pattern that is not only letters, or is not only numbers.*/
        if (matchLetters.find() || matchNumbers.find())
        {
            patternCorrect = false;
        }

        return patternCorrect;
    }

    private void setCNP(String CNP) throws IncorrectCNP
    {
        if(checkCNP(CNP) == false)
        {
            throw new IncorrectCNP("CNP must be like: SALLZZJXXXX");
        }

        this.CNP = CNP;
    }

    private void addFirstBank(BankAccount ba) throws NoNewBankAccountException
    {
        if(ba == null)
        {
            throw new NoNewBankAccountException("We need at leas one bank account to start!");
        }


    }

    public IClient(String name, String CNP, String address, BankAccount firstBankAccount)
    {
        this.name = name;

        try {
            setCNP(CNP);
            addFirstBank(firstBankAccount);
        }
        catch (IncorrectCNP incorrectCNP) {
            incorrectCNP.printStackTrace();
        }
        catch (NoNewBankAccountException e) {
            e.printStackTrace();
        }
        /*Just to be safe :).*/
        catch(Exception e)
        {
            e.printStackTrace();
        }

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

    public boolean addBankAccount(BankAccount ba) throws AccountsLimitException
    {
        boolean accountAddedSuccesfuly = true;

        if(accounts.size() > 5)
        {
            /*Throw exception*/
            throw new AccountsLimitException("You can't have more than 5 accounts!");
            //return false;
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
                try
                {
                    retVal += ((EuroAccount)acc).getInterestRate();
                }
                catch(NegativeSum e)
                {
                    System.out.println("Exception for Negative Sum Found!");
                }

                /*Put this just in case*/
                catch(Exception e)
                {
                    e.printStackTrace();
                }

            }
        }

        return retVal;
    }
}
