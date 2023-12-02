
/**
 * Represents a checking account.
 * @author Stanislav Li
 * @version Java 11 / VSCode
 * @since 2023-29-11
 */
public class CheckingAccount extends BankAccount {
    private static int numChecking = 0;

    /**
     * Creates a new CheckingAccount with an owner and initial balance.
     * @param owner The account owner's name.
     * @param balance The initial account balance.
     */
    public CheckingAccount(String owner, double balance) {
        super(owner, balance);
        numChecking++;
    }

    /**
     * Gets the account type as "Checking."
     * @return The account type.
     */
    public String getType() {
        return "Checking";
    }

    /**
     * Gets the account type as "Checking."
     * @return The account type.
     */
    public static int getNumChecking() {
        return numChecking;
    }
}
