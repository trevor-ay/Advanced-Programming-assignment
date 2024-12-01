package Assignment1;

import org.jetbrains.annotations.NotNull;
import java.util.Calendar;

public class BaseTransaction implements TransactionInterface {
    private final int amount;
    private final Calendar date;
    private final String transactionID;

    public BaseTransaction(int amount, @NotNull Calendar date) {
        this.amount = amount;
        this.date = (Calendar) date.clone();
        int uniq = (int) (Math.random() * 10000);
        transactionID = date.toString() + uniq;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public Calendar getDate() {
        return (Calendar) date.clone();
    }

    @Override
    public String getTransactionID() {
        return transactionID;
    }

    @Override
    public void printTransactionDetails() {
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Amount: " + amount);
        System.out.println("Date: " + date.getTime());
    }

    @Override
    public void apply(BankAccount ba) {
        System.out.println("Base transaction applied (no action).");
    }
}
