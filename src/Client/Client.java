package Client;

import BankAccount.BankAccount;

import java.util.ArrayList;



public class Client extends IClient {

    public Client(String name, String CNP, String address, BankAccount firstBankAccount)
    {
        super(name, CNP, address, firstBankAccount);

    }

}
