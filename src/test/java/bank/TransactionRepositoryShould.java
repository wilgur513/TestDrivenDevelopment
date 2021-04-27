package bank;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class TransactionRepositoryShould {
    public static final String TODAY = "12/05/2015";
    @Mock
    Clock clock;

    private TransactionRepository transactionRepository;

    @Before
    public void setUp() throws Exception {
        transactionRepository = new TransactionRepository(clock);
    }

    @Test
    public void create_and_store_a_deposit_transaction() {
        given(clock.todayAsString()).willReturn(TODAY);
        transactionRepository.addDeposit(100);

        List<Transaction> transactions = transactionRepository.allTransactions();

        assertThat(transactions.size(), is(1));
        assertThat(transactions.get(0), is(transaction(TODAY, 100)));
    }

    private Transaction transaction(String date, int amount) {
        return new Transaction(date, amount);
    }
}
