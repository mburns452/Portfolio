import java.util.Scanner;

/**
 * BankAccount class that represents bank management software.
 * @author Mason Burns
 * @version 12-22-2023
 * Bank management class that mimics creating/ accessing an account to deposit and withdraw money, see the previous transaction,
 * check the account's balance, and view the account's details.
 */
public class BankAccount {
    //Creating a string variable for the customer name and ID.
    private String customerName, customerID;
    //Initializing a double for the account balance.
    private double accountBalance = 0;
    //Creating a double to store the previous transaction.
    private double prevTransaction;

    /**
     * Constructor for the BankAccount class that requires a name and customer ID.
     * @param customerName The name of the customer
     * @param customerID the ID of the customer
     */
    BankAccount(String customerName, String customerID) {
        this.customerName = customerName;
        this.customerID = customerID;
    }

    /**
     * Void method to deposit funds into an account.
     * @param amount the amount to be deposited into the account.
     */
    public void deposit(double amount) {
        if (amount != 0) {
            accountBalance += amount;
            prevTransaction = amount;
        } else {
            System.out.println("Amount must be greater than zero.");
        }
    }

    /**
     * Void method to withdraw money from an account.
     * @param amount the amount to be withdrawn from the account.
     */
    public void withdraw(double amount) {
        if (amount != 0 && accountBalance >= amount) {
            accountBalance -= amount;
            prevTransaction = -amount;
        }
        else if (accountBalance < amount){
            System.out.println("Insufficient funds for withdraw.");
        }
        else {
            System.out.println("Amount must be greater than zero.");
        }
    }

    /**
     * Void method to print the balance of an account to the console.
     */
    void checkBalance() {
        System.out.println("==============================================================");
        System.out.printf("Account balance is: $%.2f.%n", accountBalance);
    }

    /**
     * Void method to print the previous transaction.
     * Has a different output depending on whether the transaction was a deposit or withdraw.
     */
    void getPreviousTransaction() {
        if (prevTransaction > 0) {
            System.out.println("==============================================================");
            System.out.printf("Deposited $%.2f.%n", prevTransaction);
        } else if (prevTransaction < 0) {
            System.out.println("==============================================================");
            System.out.printf("Withdrew -$%.2f.%n", -prevTransaction);
        } else {
            System.out.println("==============================================================");
            System.out.println("No previous transaction on record.");
        }
    }

    /**
     * Void method to display an account's details.
     */
    void getAccountDetails() {
        System.out.println("==================================================================");
        System.out.println("Account Details\n" +
                "Name: " + customerName +
                "\nID: " + customerID);
        System.out.printf("Account balance is: $%.2f.%n", accountBalance);
    }

    /**
     * Void method to print the menu of options when called.
     */
    public void menu(){
        System.out.println("===================================================================");
        System.out.println("Welcome " + customerName + "\n");
        System.out.println("""
                a) Deposit
                b) Withdraw
                c) Check Account Balance
                d) Check Previous Transaction
                e) Get Account Details
                f) View Menu
                g) Exit
                """);
    }

    /**
     * Void method containing the bank logic using a switch case corresponding with the menu options.
     */
    public void run() {
        char choice;
        Scanner scanner = new Scanner(System.in);
        menu();
        do {
            System.out.println("===============================================================");
            System.out.println("Enter an option below (f to view menu)");
            System.out.println("===============================================================");
            choice = scanner.next().charAt(0);

            switch (choice) {
                case 'a': {
                    System.out.println("===============================================================");
                    System.out.println("Enter the amount to deposit ");
                    System.out.println("===============================================================");
                    double amount = scanner.nextDouble();
                    deposit(amount);
                    break;
                }
                case 'b': {
                    System.out.println("===============================================================");
                    System.out.println("Enter the amount to withdraw ");
                    System.out.println("===============================================================");
                    double amount = scanner.nextDouble();
                    withdraw(amount);
                    break;
                }
                case 'c': {
                    checkBalance();
                    break;
                }
                case 'd': {
                    getPreviousTransaction();
                    break;
                }
                case 'e': {
                    getAccountDetails();
                    break;
                }
                case 'f':{
                    menu();
                    break;
                }
                case 'g': {
                    System.out.println("================================================================");
                    System.out.println("Exiting...");
                    System.out.println("================================================================");
                    break;
                }
                default: {
                    System.out.println("Enter a valid option to proceed.");
                    break;
                }
            }
        } while (choice != 'g');

        System.out.println("Thank you for using our services.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your 'Name' below.");
        String name = scanner.nextLine();
        System.out.println("Enter your 'CustomerID' below to get started.");
        String customerID = scanner.nextLine();

        BankAccount bankAccount = new BankAccount(name, customerID);
        bankAccount.run();
    }
}
