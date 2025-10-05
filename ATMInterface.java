import java.util.Scanner;

// Class representing the user's Bank Account
class BankAccount {
    private double balance;

    // Constructor to initialize balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(" Successfully deposited ₹" + amount);
        } else {
            System.out.println(" Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println(" Insufficient balance! Transaction failed.");
        } else if (amount <= 0) {
            System.out.println(" Invalid withdrawal amount.");
        } else {
            balance -= amount;
            System.out.println(" Successfully withdrawn ₹" + amount);
        }
    }

    // Check balance method
    public double getBalance() {
        return balance;
    }
}

// Class representing the ATM machine
class ATM {
    private BankAccount account;
    private Scanner sc = new Scanner(System.in);

    // Constructor to link ATM with user's bank account
    public ATM(BankAccount account) {
        this.account = account;
    }

    // Display menu options
    public void showMenu() {
        int choice;
        do {
            System.out.println("\n==========================");
            System.out.println("        ATM MENU");
            System.out.println("==========================");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("👋 Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println(" Invalid choice! Please try again.");
            }
        } while (choice != 4);
    }

    // Check balance
    private void checkBalance() {
        System.out.println(" Your current balance is: ₹" + account.getBalance());
    }

    // Deposit money
    private void deposit() {
        System.out.print("Enter the amount to deposit: ₹");
        double amount = sc.nextDouble();
        account.deposit(amount);
    }

    // Withdraw money
    private void withdraw() {
        System.out.print("Enter the amount to withdraw: ₹");
        double amount = sc.nextDouble();
        account.withdraw(amount);
    }
}
public class ATMInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("🏦 Welcome to the Java ATM System!");
        System.out.print("Enter your initial account balance: ₹");
        double initialBalance = sc.nextDouble();

        // Create a bank account and connect it to ATM
        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(userAccount);

        // Start ATM menu
        atm.showMenu();

        sc.close();
    }
}
