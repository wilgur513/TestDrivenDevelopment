package bank;

public class BankKataApplication {
    public static void main(String[] args) {
        Account account = new Account(
                new TransactionRepository(new Clock()),
                new StatementPrinter(new Console()));

        account.deposit(1000);
        account.withdraw(400);
        account.deposit(100);

        account.printStatement();
    }
}
