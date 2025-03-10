import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Class that manages the expense list and provides tracking functionality
 */
public class ExpenseTracker {
 
    private List<Expense> expenses; // Expenses list

    // Constructor of the ExpenseTracker class
    public ExpenseTracker() {
        this.expenses = new ArrayList<>();
    }

    // Adds an expense to the list
    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    // Calculates the total expenses
    public double calculateTotalExpenses() {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        return total;
    }

    // Analyzes expenses by category
    public Map<String, Double> analyzeExpensesByCategory() {
        Map<String, Double> categoryTotals = new HashMap<>();
        for (Expense expense : expenses) {
            String category = expense.getCategory();
            double amount = expense.getAmount();
            categoryTotals.put(category, categoryTotals.getOrDefault(category, 0.00) + amount);
        }
        return categoryTotals;
    }

    // Generates an expense report
    public String generateReport()  {
        StringBuilder report = new StringBuilder();
        report.append("--- Expense Report ---\\n");
        for (Expense expense : expenses) {
            report.append("Date: ").append(expense.getDate()).append(", ");
            report.append("Category: ").append(expense.getCategory()).append(", ");
            report.append("Description: ").append(expense.getDescription()).append(", ");
            report.append("Value: ").append(expense.getAmount()).append("\n");
        }
        report.append("\n--- Spending By Category ---\\n");
        Map<String, Double> categoryTotals = analyzeExpensesByCategory();
        for (Map.Entry<String, Double> entry : categoryTotals.entrySet()) {
            report.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        report.append("\nTotal: ").append(calculateTotalExpenses());
        return report.toString();
    }
 }