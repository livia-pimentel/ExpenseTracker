import java.time.LocalDate;


/*
 * Class representing an individual expense. 
 */

public class Expense {
    private LocalDate date; // Date of expense
    private String description; // Description of expense 
    private double amount; // Amount of expense
    private String category; // Category of expense

    // Expense class constructor
    public Expense(LocalDate date, String description, double amount, String category) {

        // Checks if the value is greater than zero
        if (amount < 0) {
            throw new IllegalArgumentException("The value of the expense cannot be negative.");
        }

        this.date = date;
        this.description = description;
        this.amount = amount;
        this.category = category;
    }

    // Getters methods to access 
    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }


    // Setters methods to modify attributes
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(double amount) {
        // Checks if the value is greater than zero
        if (amount < 0) {
            throw new IllegalArgumentException("The value of the expense cannot be negative.");
        }

        this.amount = amount;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}