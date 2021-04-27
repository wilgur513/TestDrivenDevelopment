package bank;

import remove.parenthesis.ParenthesisPairList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransactionRepository {
    private Clock clock;
    private List<Transaction> transactions = new ArrayList<>();

    public TransactionRepository(Clock clock) {
        this.clock = clock;
    }

    public void addDeposit(int amount) {
        Transaction deposit = new Transaction(clock.todayAsString(), amount);
        transactions.add(deposit);
    }

    public void addWithdrawal(int amount) {

    }

    public List<Transaction> allTransactions() {
        return Collections.unmodifiableList(transactions);
    }
}
