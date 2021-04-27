package bank;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StatementPrinter {
    public static final String STATEMENT_HEADER = "DATE | AMOUNT | BALANCE";
    private DecimalFormat decimalFormat = new DecimalFormat("#.00");
    private final Console console;

    public StatementPrinter(Console console) {
        this.console = console;
    }

    public void print(List<Transaction> transactions) {
        printHeaderLine();
        printStatementLines(transactions);
    }

    private void printHeaderLine() {
        console.printLine(STATEMENT_HEADER);
    }

    private void printStatementLines(List<Transaction> transactions) {
        AtomicInteger balance = new AtomicInteger(0);
        transactions.stream()
                .map(t -> statementLine(t, balance))
                .collect(Collectors.toCollection(LinkedList::new))
                .descendingIterator()
                .forEachRemaining(console::printLine);
    }

    private String statementLine(Transaction t, AtomicInteger balance) {
        return t.date()
                + " | "
                + decimalFormat.format(t.amount())
                + " | "
                + decimalFormat.format(balance.addAndGet(t.amount()));
    }
}
