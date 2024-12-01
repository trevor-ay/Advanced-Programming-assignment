package Assignment1;

import org.jetbrains.annotations.NotNull;
import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction{
    private double originalBalance;

    public WithdrawalTransaction(int amount, @NotNull Calendar date) {
        super(amount, date);
    }

    @Override
    public void printTransactionDetails() {
        System.out.println("Withdrawal Transaction:");
        super.printTransactionDetails();
    }

    public void apply(BankAccount ba) throws InsufficientFundsException {
        originalBalance = ba.getBalance();  // Store the original balance
        double newBalance = originalBalance - getAmount();

        try {
            if (newBalance < 0) {
                throw new InsufficientFundsException("Insufficient funds for withdrawal.");
            }
            ba.setBalance(newBalance);
            System.out.println("Withdrawal applied. New Balance: " + newBalance);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean reverse(BankAccount ba) {
        ba.setBalance(originalBalance);  // Restore original balance
        System.out.println("Withdrawal reversed. Balance restored to: " + originalBalance);
        return true;
    }
}
