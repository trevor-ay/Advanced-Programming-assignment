package Assignment1;

import org.jetbrains.annotations.NotNull;
import java.util.Calendar;

public class DepositTransaction extends BaseTransaction {

    public DepositTransaction(int amount, @NotNull Calendar date) {
        super(amount, date);
    }

    @Override
    public void printTransactionDetails() {
        System.out.println("Deposit Transaction:");
        super.printTransactionDetails();
    }

    public void apply(BankAccount ba) {
        double currentBalance = ba.getBalance();
        double newBalance = currentBalance + getAmount();
        ba.setBalance(newBalance);
        System.out.println("Deposit applied. New Balance: " + newBalance);
    }
}
