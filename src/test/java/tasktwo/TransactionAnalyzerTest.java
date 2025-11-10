package tasktwo;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class TransactionAnalyzerTest {

    @Test
    public void testCalculateTotalBalance() {
        Transaction t1 = new Transaction("01-01-2024", 100.0, "Дохід");
        Transaction t2 = new Transaction("02-01-2024", -50.0, "Витрата");
        Transaction t3 = new Transaction("03-01-2024", 150.0, "Дохід");
        List<Transaction> transactions = Arrays.asList(t1, t2, t3);

        TransactionAnalyzer analyzer = new TransactionAnalyzer(transactions);
        double result = analyzer.calculateTotalBalance();

        Assertions.assertEquals(200.0, result);
    }

    @Test
    public void testCountTransactionsByMonth() {
        Transaction t1 = new Transaction("01-02-2023", 50.0, "Дохід");
        Transaction t2 = new Transaction("15-02-2023", -20.0, "Витрата");
        Transaction t3 = new Transaction("05-03-2023", 100.0, "Дохід");
        List<Transaction> transactions = Arrays.asList(t1, t2, t3);

        TransactionAnalyzer analyzer = new TransactionAnalyzer(transactions);

        Assertions.assertEquals(2, analyzer.countTransactionsByMonth("02-2023"));
        Assertions.assertEquals(1, analyzer.countTransactionsByMonth("03-2023"));
    }
}
