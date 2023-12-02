
/**
 * Represents a generic bank account.
 * @author Stanislav Li
 * @version Java 11 / VSCode
 * @since 2023-29-11
 */

public class BankAccount {
    private String number;
    private String owner;
    protected double balance;
    private static int numAccounts = 0;

    /**
     * Creates a new bank account with an owner and initial balance.
     * @param owner The account owner's name.
     * @param balance The initial account balance.
     */
    public BankAccount(String owner, double balance) {
        this.number = generateAccountNumber();
        this.owner = owner;
        this.balance = balance;
        numAccounts++;
    }

    /**
     * Generates a unique 10-digit account number.
     * @return The generated account number.
     */
    private String generateAccountNumber() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append((int) (Math.random() * 10));
        }
        return sb.toString();
    }

    /**
     * Gets the type of the account as "Bank Account".22222
     * @return The account type.
     */
    public String getType() {
        return "Bank Account"; 
    }
    /**
     * Gets the account number.
     * @return The account number.
     */
    public String getNumber() {
        return number;
    }

    /**
     * Gets the account owner's name.
     * @return The account owner's name.
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Gets the current balance of the account.
     * @return The current balance.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Deposits a specified amount into the account.
     * @param amount The amount to deposit.
     */
    public void deposit(double amount) {
        balance += amount;
    }

    /**
     * Attempts to withdraw a specified amount from the account.
     * @param amount The amount to withdraw.
     * @return true or false 
     */
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gets the total number of bank accounts created.
     * @return The total number of bank accounts.
     */
    public static int getNumAccounts() {
        return numAccounts;
    }
}
