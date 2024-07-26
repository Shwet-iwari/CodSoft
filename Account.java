import java.util.HashMap;
import java.util.Scanner;

class Account {
    private int balance;
    private int accountNumber;

    public Account(int accountNumber, int initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public int getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Invalid withdraw amount or insufficient funds");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: " + balance);
    }
}

class ATM {
    private HashMap<Integer, Account> accounts = new HashMap<>();

    public void createAccount(int accountNumber, int initialBalance) {
        accounts.put(accountNumber, new Account(accountNumber, initialBalance));
        System.out.println("Account created with account number: " + accountNumber);
    }

    public Account getAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }

    public void validateUser(int accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account validated");
        } else {
            System.out.println("Invalid account number");
        }
    }
}

