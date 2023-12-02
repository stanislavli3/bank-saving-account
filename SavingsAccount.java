
/**
 * A class represents a savings account.
 * @author Stanislav Li
 * @version Java 11 / VSCode
 * @since 2023-29-11
 */
public class SavingsAccount extends BankAccount {
    private double yearlyInterestRate;
    private static int numSavings = 0;

    /**
     * Creates a new SavingsAccount with an owner, initial balance, and yearly interest rate.
     * @param owner The account owner's name.
     * @param balance The initial account balance.
     * @param yearlyInterestRate The annual interest rate for the account.
     */
    public SavingsAccount(String owner, double balance, double yearlyInterestRate) {
        super(owner, balance);
        this.yearlyInterestRate = yearlyInterestRate;
        numSavings++;
    }

    /**
     * Gets the annual interest rate.
     * @return The annual interest rate as a percentage.
     */
    public double getYearlyInterestRate() {
        return yearlyInterestRate;
    }

    /**
     * Calculates and returns the monthly interest rate for the account.
     * @return The monthly interest rate as a decimal.
     */
    public double getMonthlyInterestRate() {
        return balance * (yearlyInterestRate / 12) / 100;
    }

    /**
     * Sets the annual interest rate for the account.
     * @param yearlyInterestRate The new annual interest rate as a percentage.
     */
    public void setYearlyInterestRate(double yearlyInterestRate) {
        this.yearlyInterestRate = yearlyInterestRate;
    }

    /**
     * Applies monthly interest to the account balance.
     * @return The amount of interest applied.
     */
    public double applyInterest() {
        double interest = getMonthlyInterestRate();
        balance += interest;
        return interest;
    }

    /**
     * Gets the total number of savings accounts created.
     * @return The total number of savings accounts.
     */
    public static int getNumSavings() {
        return numSavings;
    }

    /**
     * Gets the account type as "Savings."
     * @return The account type.
     */
    public String getType() {
        return "Savings";
    }
}
