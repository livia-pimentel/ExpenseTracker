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
        this.date = date;
          
        // Checks if the description is empty
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("The description cannot be empty.");
        }
        // Controls the blanks
        description = description.trim().replaceAll("\\s+", " ");
        // Removal of special characters
        description = description.replaceAll("[^a-zA-Z0-9\\s]", "");
        // Capitalizes the first letter 
        if (!Character.isUpperCase(description.charAt(0))) {
            description = Character.toUpperCase(description.charAt(0)) + description.substring(1);
        }
        this.description = description;
        
               
        // Checks if the value is greater than zero
        if (amount < 0) {
            throw new IllegalArgumentException("The value of the expense cannot be negative.");
        }    
        this.amount = amount;

        // Checks if the category is empty
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("The category cannot be empty.");
        }
        // Controls the blanks
        category = category.trim().replaceAll("\\s+", " ");
        // Removal of special characters
        category = category.replaceAll("[^a-zA-Z0-9\\s]", "");
        // Capitalizes the first letter 
        if (!Character.isUpperCase(category.charAt(0))) {
            category = Character.toUpperCase(category.charAt(0)) + category.substring(1);
        }
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
        // Checks if the description is empty
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("The description cannot be empty.");
        }
        // Controls the blanks
        description = description.trim().replaceAll("\\s+", " ");
        // Removal of special characters
        description = description.replaceAll("[^a-zA-Z0-9\\s]", "");
        // Capitalizes the first letter 
        if (!Character.isUpperCase(description.charAt(0))) {
            description = Character.toUpperCase(description.charAt(0)) + description.substring(1);
        }
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
        // Checks if the category is empty
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("The category cannot be empty.");
        }
        // Controls the blanks
        category = category.trim().replaceAll("\\s+", " ");
        // Removal of special characters
        category = category.replaceAll("[^a-zA-Z0-9\\s]", "");
        // Capitalizes the first letter 
        if (!Character.isUpperCase(category.charAt(0))) {
            category = Character.toUpperCase(category.charAt(0)) + category.substring(1);
        }
        this.category = category;
    }
}