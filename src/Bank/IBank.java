package Bank;

import BankAccount.*;
import Client.IClient;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class IBank {

    private Integer bankCode;
    private ArrayList<IClient> clients = new ArrayList<IClient>();

    public IBank(Integer bankCode)
    {
        this.bankCode = bankCode;
    }

    public boolean addClient(IClient client)
    {
        boolean clientAddedSuccesfuly = true;

        for(IClient cl : clients)
        {
            if(cl.equals(client))
            {
                /*Throw Exception*/
                clientAddedSuccesfuly = false;
                return clientAddedSuccesfuly;
            }
        }

        clients.add(client);

        return clientAddedSuccesfuly;
    }

    public  String displayClientInfo(IClient client)
    {
        String retString = "No such client exists!";

        for(IClient cl : clients)
        {
            /*If the requested client is found then save the info and send it to the demander. */
            if(client.equals(cl))
            {
                retString = "CNP: " + client.getCNP() + "; Name: " + client.getName() + "; Address: " + client.getAddress() + ";\n";
                ArrayList<BankAccount> accounts = client.getAccounts();
                retString += "\nAccounts:\n";

                for(BankAccount acc :  accounts)
                {
                    retString += "\tID: " +  acc.getAccountNumber() + "; Type: ";
                    retString += acc.isRonAccount() == true? "RON" : "EURO";
                    retString += "; Total_Sum: " + client.getTotalSum() + "; Daily Interest: " + client.getDailyInterestRate();
                }

                break;
            }
        }

        return retString;
    }

    public boolean transferMoneyBank(Integer accNr1,Integer accNr2, Double sumToTransfer)
    {
        boolean transferSuccessful = false;

        boolean srcAccountFound = false, dstAccountFound = false;

        BankAccount account1 = null, account2 = null;

        IClient tempClient = null;

        Iterator clientIterator = clients.iterator();

        /*While we have clients and we have not found all accounts, keep searching.*/
        while(clientIterator.hasNext() && ((srcAccountFound == false) || (dstAccountFound == false)))
        {
            /*This cast is necessary.*/
            tempClient = (IClient) clientIterator.next();
            if(tempClient == null)
            {
                /*No clients. Throw exception for no clients in the bank!*/
                break;
            }
            /*Search for the first account. The account from which we take the money.*/
            for(BankAccount acc : tempClient.getAccounts())
            {
                if(acc.getAccountNumber().equals(accNr1))
                {
                    account1 = acc;
                    srcAccountFound = true;
                    break;
                }
            }

            for(BankAccount acc : tempClient.getAccounts())
            {
                if(acc.getAccountNumber().equals(accNr2))
                {
                    account2 = acc;
                    dstAccountFound = true;
                    break;
                }
            }

        }

        /*If both are false it means that at least one of the accounts where not found, therefore we throw an exception!*/
        if((srcAccountFound == false) || (dstAccountFound == false))
        {
            /*Throw Exception*/
        }
        /*If we reached this branch it means we have found both accounts.*/
        else
        {
            /*If transfer is succesful then 'transferSuccesful'=true.*/
            transferSuccessful = ((RonAccount)account1).transferMoneyAccount(account2, sumToTransfer);
        }

        return transferSuccessful;
    }
}
