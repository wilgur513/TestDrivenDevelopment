package bank;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;
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

    @Test
    public void store_a_withdrawal_transaction() {
        account.withdraw(100);
        verify(transactionRepository).addWithdrawal(100);
    }

    @Test
    public void print_a_statement() {
        List<Transaction> transactions = Arrays.asList(new Transaction());
        given(transactionRepository.allTransactions()).willReturn(transactions);
        verify(statementPrinter).print(transactions);
    }
}
