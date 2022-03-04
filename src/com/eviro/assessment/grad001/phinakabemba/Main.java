package com.eviro.assessment.grad001.phinakabemba;

import com.eviro.assessment.grad001.phinakabemba.domains.CurrentAccount;
import com.eviro.assessment.grad001.phinakabemba.domains.SavingsAccount;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        //Initial display of data saved in our "in memory" database
        System.out.println(SystemDB.ACCOUNTS);

        //Here I am creating 4 accounts, 2 savingsAccount and 2 currentAccount
        SavingsAccount savingsAccount1 = new SavingsAccount(101, "1", new BigDecimal(2000), "Customer1");
        SavingsAccount savingsAccount2 = new SavingsAccount(102, "2", new BigDecimal(5000), "Customer2");
        CurrentAccount currentAccount1 = new CurrentAccount(103, "3", new BigDecimal(1000), new BigDecimal(10000), "Customer3");
        CurrentAccount currentAccount2 = new CurrentAccount(104, "4", new BigDecimal(-5000), new BigDecimal(20000), "Customer4");

        //Prepopulate memory in database in a map
        SystemDB.ACCOUNTS.put(savingsAccount1.getAccountNum(), savingsAccount1);
        SystemDB.ACCOUNTS.put(savingsAccount2.getAccountNum(), savingsAccount2);
        SystemDB.ACCOUNTS.put(currentAccount1.getAccountNum(), currentAccount1);
        SystemDB.ACCOUNTS.put(currentAccount2.getAccountNum(), currentAccount2);

        System.out.println(SystemDB.ACCOUNTS);

        // Scenario 1 : accountNum: 1(Savings Account) has a balance of R2000, withdraw R500 and remain with R1500
        System.out.println(savingsAccount1.getBalance());
        savingsAccount1.withdraw("1", new BigDecimal(500));
        System.out.println(savingsAccount1.getBalance());

        // Scenario 2 : accountNum: 4(Current Account) has a negative balance of -5000 and an overdraft of R20000, once we withdraw 4000, the remaining will be 11000
        System.out.println(currentAccount2.getBalance());
        currentAccount2.withdraw("4", new BigDecimal(4000));
        System.out.println(currentAccount2.getBalance());

        // Scenario 3 : trying to withdraw more than what the customer has as balance
        CurrentAccount existingCurrentAccount = new CurrentAccount(105, "5", new BigDecimal(5000), new BigDecimal(25000), "Customer5");
        existingCurrentAccount.withdraw("3", new BigDecimal(15000));


        //Scenario 4 : try to withdraw from a non existing account number
        CurrentAccount nonExistingCurrentAccount = new CurrentAccount(105, "5", new BigDecimal(5000), new BigDecimal(25000), "Customer5");
        nonExistingCurrentAccount.withdraw("5", new BigDecimal(1000));
    }
}
