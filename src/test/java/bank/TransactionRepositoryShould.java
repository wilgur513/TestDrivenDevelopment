package bank;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.BDDMockito.given;

public class TransactionRepositoryShould {
    @Mock
    Clock clock;

    private TransactionRepository transactionRepository;

    @Before
    public void setUp() throws Exception {
        transactionRepository = new TransactionRepository();
    }

    @Test
    public void create_and_store_a_deposit_transaction() {
        given(clock.todayAsString()).willReturn("12/05/2015");
        transactionRepository.addDeposit(100);

        List<Transaction> transactions = transactionRepository.allTransactions();

        assertThat(transactions.size(), is(1));
        assertThat(transactions.get(0), is(transaction("12/05/2015", 100)));
    }

    private Transaction transaction(String date, int amount) {
        return new Transaction(date, amount);
    }
}
