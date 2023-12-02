/**
 * TestAccounts class is a driver class for the CheckingAccount and SavingsAccount classes.
 * 
 * @author Stanislav Li
 * @version Java 11 / VSCode
 * @since 2023-29-11
 */
import java.util.Scanner;

public class TestAccounts {
    public static void main(String[] args) {
        // Create arrays for saving and checking accounts
        SavingsAccount[] saveAccounts = new SavingsAccount[5];
        CheckingAccount[] checkAccounts = new CheckingAccount[5];

        //Saving accounts
        saveAccounts[0] = new SavingsAccount("Isabel Truman", 89250, 10.5);
        saveAccounts[1] = new SavingsAccount("Andrew Sullivan", 12734, 12.1);
        saveAccounts[2] = new SavingsAccount("Emma Stevens", 31250, 8.89);
        saveAccounts[3] = new SavingsAccount("Lara Stevens", 75000, 9.25);
        saveAccounts[4] = new SavingsAccount("Stanislav Li", 75600, 9.35); 

        //Checking accounts
        checkAccounts[0] = new CheckingAccount("William Burst", 10000);
        checkAccounts[1] = new CheckingAccount("Nathan Steward", 24900);
        checkAccounts[2] = new CheckingAccount("George Duck", 29990);
        checkAccounts[3] = new CheckingAccount("Adil Alybaev", 26990);
        checkAccounts[4] = new CheckingAccount("Alibek Kaliev", 23490);
        Scanner keyboard = new Scanner(System.in);
        int operation;

        do {
            printMenu();
            while (true) {
                if (keyboard.hasNextInt()) {
                    operation = keyboard.nextInt();
                    if (operation >= 1 && operation <= 5) {
                        break; // Breaks the loop if input is valid
                    } else {
                        System.out.println("Invalid operation. Please enter a number between 1 and 5.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    keyboard.next(); // Consumes the invalid input
                }
            }

            switch (operation) {
                case 1:
                    printAccounts(checkAccounts);
                    break;
                case 2:
                    printAccounts(saveAccounts);
                    break;
                case 3:
                    System.out.println("Enter an account number(10-digit): ");
                    String number = keyboard.next();
                    findAccount(checkAccounts, saveAccounts, number);
                    break;
                case 4:
                    applyInterest(saveAccounts);
                    System.out.println("Interest applied to all savings accounts.");
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid operation (1 to 5). Please try again.");
            }
        } while (operation != 5);

        keyboard.close();
    }
    //Displays the main menu of operations.
    public static void printMenu() {
        System.out.println("1. View the list of checking accounts");
        System.out.println("2. View the list of savings accounts");
        System.out.println("3. Find an account by account number");
        System.out.println("4. Apply interest to savings accounts");
        System.out.println("5. Exit");
    }
    /**
     * Prints the list of checking accounts.
     * @param accounts An array of CheckingAccount objects.
     */
    public static void printAccounts(CheckingAccount[] accounts) {
        for (CheckingAccount account : accounts) {
            if (account != null) {
                System.out.printf("%-10s %-15s $%.2f%n", "Checking", account.getOwner(), account.getBalance());
            }
        }
    }
    /**
     * Prints the list of savings accounts along with their interest rates.
     * @param accounts An array of SavingsAccount objects.
     */
    public static void printAccounts(SavingsAccount[] accounts) {
        for (SavingsAccount account : accounts) {
            if (account != null) {
                System.out.printf("%-10s %-15s $%.2f (Interest Rate: %.2f%%)%n", "Savings", account.getOwner(), account.getBalance(), account.getYearlyInterestRate());
            }
        }
    }

    /**
     * Finds and displays an account by its account number.
     * @param checkAccounts An array of CheckingAccount objects.
     * @param saveAccounts An array of SavingsAccount objects.
     * @param number The account number to search for.
     */
    public static void findAccount(CheckingAccount[] checkAccounts, SavingsAccount[] saveAccounts, String number) {
        boolean found = false;

        // Search in checking accounts
        for (CheckingAccount account : checkAccounts) {
            if (account != null && account.getNumber().equals(number)) {
                System.out.println("Found Checking Account: " + account.getOwner());
                found = true;
                break;
            }
        }

        // Search in savings accounts if not found in checking
        if (!found) {
            for (SavingsAccount account : saveAccounts) {
                if (account != null && account.getNumber().equals(number)) {
                    System.out.println("Found Savings Account: " + account.getOwner());
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("Account with number " + number + " not found.");
        }
    }
    /**
     * Applies interest to all savings accounts and updates their balances.
     * @param saveAccounts An array of SavingsAccount objects.
     */
    public static void applyInterest(SavingsAccount[] saveAccounts) {
        for (SavingsAccount account : saveAccounts) {
            if (account != null) {
                double interest = account.applyInterest();
                account.deposit(interest); // Update the balance with interest
            }
        }
    }
}
