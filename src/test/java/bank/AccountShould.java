package bank;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountShould {
    @Mock
    TransactionRepository transactionRepository;
    private Account account;

    @Before
    public void setUp() throws Exception {
        account = new Account(transactionRepository);
    }

    @Test
    public void store_a_deposit_transaction() {
        account.deposit(100);
        verify(transactionRepository).addDeposit(100);
    }
}
