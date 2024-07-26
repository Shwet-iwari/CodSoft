import java.util.Scanner;

public class ATMInterface {
    public static void main(String[] args) {
        ATM atm = new ATM();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM Interface");

        // Create some accounts
        atm.createAccount(12345, 1000);
        atm.createAccount(67890, 2000);

        // User interaction
        System.out.println("Enter account number: ");
        int accountNumber = scanner.nextInt();

        atm.validateUser(accountNumber);

        Account userAccount = atm.getAccount(accountNumber);

        if (userAccount != null) {
            boolean exit = false;
            while (!exit) {
                System.out.println("1: Check Balance");
                System.out.println("2: Deposit");
                System.out.println("3: Withdraw");
                System.out.println("4: Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        userAccount.checkBalance();
                        break;
                    case 2:
                        System.out.print("Enter deposit amount: ");
                        int depositAmount = scanner.nextInt();
                        userAccount.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter withdraw amount: ");
                        int withdrawAmount = scanner.nextInt();
                        userAccount.withdraw(withdrawAmount);
                        break;
                    case 4:
                        exit = true;
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                        break;
                }
            }
        }

        scanner.close();
    }
}


