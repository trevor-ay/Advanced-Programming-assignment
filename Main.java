import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        // Deposit transaction
        DepositTransaction deposit = new DepositTransaction(200, Calendar.getInstance());
        deposit.printTransactionDetails();
        deposit.apply(account);

        // Withdrawal transaction
        WithdrawalTransaction withdrawal = new WithdrawalTransaction(300, Calendar.getInstance());
        withdrawal.printTransactionDetails();
        try {
            withdrawal.apply(account);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        // Reversing the withdrawal
        withdrawal.reverse(account);
    }
}
