package tasktwo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionAnalyzer {
    private final List<Transaction> transactions;
    private final DateTimeFormatter dateFormatter;

    public TransactionAnalyzer(List<Transaction> transactions) {
        this.transactions = transactions;
        this.dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    // Метод для расчета общего баланса
    public double calculateTotalBalance() {
        double balance = 0;
        for (Transaction transaction : transactions) {
            balance += transaction.getAmount();
        }
        return balance;
    }

    // Метод для подсчета количества транзакций за месяц
    public int countTransactionsByMonth(String monthYear) {
        int count = 0;
        for (Transaction transaction : transactions) {
            try {
                LocalDate date = LocalDate.parse(transaction.getDate(), dateFormatter);
                String transactionMonthYear = date.format(DateTimeFormatter.ofPattern("MM-yyyy"));
                if (transactionMonthYear.equals(monthYear)) {
                    count++;
                }
            } catch (Exception ignored) {}
        }
        return count;
    }

    // Метод для поиска 10 самых крупных расходов
    public List<Transaction> findTopExpenses() {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .sorted(Comparator.comparing(Transaction::getAmount))
                .limit(10)
                .collect(Collectors.toList());
    }
}
