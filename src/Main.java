import Bank.ConcreteBank;
import Bank.IBank;
import BankAccount.BankAccount;
import Client.Client;
import Client.IClient;

import BankAccount.*;
import CustomExceptions.*;

public class Main {

    public static void main(String[] args)
    {

        System.out.println("Easy peasy, lemon squeezy");

        IBank myBank = new ConcreteBank(20);
        IClient clientRon, clientEuro, clientEuroRon, clientPoor, clientWealthy;

        BankAccount baRON1, baRON2, baRON3, baEURO1, baEURO2, baEURO3, baRON4, baRON5, baRON6, baRON7, baEURO5, baEURO4;

        baRON1 = new RonAccount(1023.45, 1);
        baRON2 = new RonAccount(999.423, 2);
        baRON3 = new RonAccount(14230.23, 5);
        baRON4 = new RonAccount(203.012, 3);
        baRON5 = new RonAccount(92823.24, 7);

        baRON6 = new RonAccount(2033.012, 9);
        baRON7 = new RonAccount(923.24, 10);


        baEURO1 = new EuroAccount(520.45, 4);
        baEURO2 = new EuroAccount(290.8, 6);
        baEURO3 = new EuroAccount(4213.4, 8);

        baEURO5 = new EuroAccount(678.89, 11);
        baEURO4 = new EuroAccount(123.5, 12);

        clientRon = new Client("Gheorghe", "19802014321", "Arad", baRON1);
        try {
            clientRon.addBankAccount(baRON2);
            clientRon.addBankAccount(baRON3);
            clientRon.addBankAccount(baRON4);
        }
     catch (AccountsLimitException e)
        {
            e.printStackTrace();
        }

        clientEuro = new Client("Andrew", "18702014321", "USA", baEURO1);
        try {
            clientEuro.addBankAccount(baEURO2);
        }
        catch (AccountsLimitException e)
        {
            e.printStackTrace();
        }

        clientEuroRon = new Client("Trump", "14702014321", "Clint", baEURO3);
        try {
            clientEuroRon.addBankAccount(baRON6);
            clientEuroRon.addBankAccount(baEURO4);
            clientEuroRon.addBankAccount(baRON7);
        }
        catch (AccountsLimitException e)
        {
            e.printStackTrace();
        }

        clientWealthy = new Client("Emil", "19708019220", "Timisoara", baRON5);
        try {
            clientWealthy.addBankAccount(baEURO5);
        }
        catch (AccountsLimitException e)
        {
            e.printStackTrace();
        }

        try {
            myBank.addClient(clientEuro);
            myBank.addClient(clientRon);
            myBank.addClient(clientEuroRon);
            myBank.addClient(clientWealthy);

        } catch (AlreadyRegisteredClient alreadyRegisteredClient) {
            alreadyRegisteredClient.printStackTrace();
        }

        System.out.println(myBank.displayClientInfo(clientEuro));
        System.out.println(myBank.displayClientInfo(clientEuroRon));
        System.out.println(myBank.displayClientInfo(clientRon));
        System.out.println(myBank.displayClientInfo(clientWealthy));

        try {
            myBank.transferMoneyBank(7, 3, 10000.0);
        } catch (NoClientsException e) {
            e.printStackTrace();
        } catch (MissingAccountException e) {
            e.printStackTrace();
        } catch (MoneyTransferFailException e) {
            e.printStackTrace();
        }

        System.out.println("\n--------------------------------------------------------------------------------------------------------\n\n");

        System.out.println(myBank.displayClientInfo(clientEuro));
        System.out.println(myBank.displayClientInfo(clientEuroRon));
        System.out.println(myBank.displayClientInfo(clientRon));
        System.out.println(myBank.displayClientInfo(clientWealthy));
    }
}
