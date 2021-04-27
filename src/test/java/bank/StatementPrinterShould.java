package bank;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.verify;

public class StatementPrinterShould {
    private static final List<Transaction> NO_TRANSACTIONS = Collections.EMPTY_LIST;
    private Console console;

    @Test
    public void always_print_the_header() {
        StatementPrinter statementPrinter = new StatementPrinter();
        statementPrinter.print(NO_TRANSACTIONS);
        verify(console).printLine("DATE | AMOUNT | BALANCE");
    }
}
