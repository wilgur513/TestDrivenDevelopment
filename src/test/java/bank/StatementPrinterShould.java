package bank;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StatementPrinterShould {
    private StatementPrinter statementPrinter;
    private static final List<Transaction> NO_TRANSACTIONS = Collections.EMPTY_LIST;
    @Mock
    Console console;

    @Before
    public void setUp() throws Exception {
        statementPrinter = new StatementPrinter(console);
    }

    @Test
    public void always_print_the_header() {
        statementPrinter.print(NO_TRANSACTIONS);
        verify(console).printLine("DATE | AMOUNT | BALANCE");
    }

    @Test
    public void print_transactions_in_reverse_chronological_order() {
        statementPrinter.print(transactionContaining(
                                    deposit("01/04/2014", 1000),
                                    withdrawal("02/04/2014", 100),
                                    deposit("10/04/2014", 500)));

        InOrder inOrder = Mockito.inOrder(console);
        inOrder.verify(console).printLine("DATE | AMOUNT | BALANCE");
        inOrder.verify(console).printLine("10/04/2014 | 500.00 | 1400.00");
        inOrder.verify(console).printLine("02/04/2014 | -100.00 | 900.00");
        inOrder.verify(console).printLine("01/04/2014 | 1000.00 | 1000.00");
    }

    private List<Transaction> transactionContaining(Transaction... transactions) {
        return Arrays.asList(transactions);
    }

    private Transaction withdrawal(String date, int amount) {
        return new Transaction(date, -amount);
    }

    private Transaction deposit(String date, int amount) {
        return new Transaction(date, amount);
    }
}
