import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
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

    // Return the list of expenses
    public List<Expense> getExpenses() {
        return expenses;
    }

    // Adds an expense to the list
    public void addExpense(Expense expense) {

        // Check if expense is null
        if (expense == null) {
            throw new IllegalArgumentException("The expense cannot be null");
        }

        // Check if description or category is null or empty
        if (expense.getCategory() == null || expense.getCategory().trim().isEmpty() || 
        expense.getDescription() == null || expense.getDescription().trim().isEmpty()){
            throw new IllegalArgumentException("Expense category and description cannot be empty");
        }

        // Check is the expense value is valid   
        if (expense.getAmount() <= 0) {
            throw new IllegalArgumentException("The expense amount must be greater than zero");
        }

        // Remove special characters from description and category
        String category = expense.getCategory().replaceAll("[^a-zA-Z0-9\\\\s]", ""); 
        String description = expense.getDescription().replaceAll("[^a-zA-Z0-9\\\\s]", "");

        // Update the expense with the clean values
        expense.setCategory(category);
        expense.setDescription(description);

        expenses.add(expense);
    }

    // Calculates the total expenses
    public double calculateTotalExpenses() {

        // Checks if the list is null or empty
        if (expenses == null || expenses.isEmpty()) {
            return 0.00;
        }

        // Calculate expenses
        double total = 0.00;
        for (Expense expense : expenses) {
            //  Checks if the expense isn't null
            if (expense != null) {
                total += expense.getAmount();
            } 
        }

        return total;
    }

    // Analyzes expenses by category
    public Map<String, Double> analyzeExpensesByCategory() {

        // Checks if the list is null or empty
        if (expenses == null || expenses.isEmpty()) {
            return new HashMap<>();
        }

        Map<String, Double> categoryTotals = new HashMap<>();

        for (Expense expense : expenses) {
            //  Checks if the expense isn't null
            if (expense != null) {
                String category = expense.getCategory();
                double amount = expense.getAmount();
                categoryTotals.put(category, categoryTotals.getOrDefault(category, 0.00) + amount);
            }
        }

        return categoryTotals;
    }

    // Generates an expense report
    public String generateReport()  {

        // Used to create and manipulate mutable strings.
        StringBuilder report = new StringBuilder();
        report.append("--- Expense Report ---\n");

        // Use currency format
        Locale locale = Locale.of("en", "US");
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);

        for (Expense expense : expenses) {

            //  Checks if the expense isn't null
            if (expense != null) {

                // Remove special characters for display in report
                String category = expense.getCategory().replaceAll("[^a-zA-Z0-9\\\\s]", "");
                String description = expense.getDescription().replaceAll("[^a-zA-Z0-9\\\\s]", "");

                report.append("Date: ").append(expense.getDate()).append(", ");
                report.append("\nCategory: ").append(category).append(", ");
                report.append("\nDescription: ").append(description).append(", ");
                report.append("\nValue: ").append(currencyFormat.format(expense.getAmount())).append("\n");
                report.append("--- ----- ---\n");
            } 
        }

        report.append("\n--- Spending By Category ---\n");
        Map<String, Double> categoryTotals = analyzeExpensesByCategory();
        for (Map.Entry<String, Double> entry : categoryTotals.entrySet()) {
            report.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }

        report.append("-------- ----- ------\n");
        report.append("\nTotal: ").append(currencyFormat.format(calculateTotalExpenses()));
        return report.toString();
    }
 }