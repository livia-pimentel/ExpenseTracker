import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

/*
 * class Main that starts the ExpenseTracker application
 */

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Read the user input
        scanner.useLocale(Locale.US); // Sets the scanner to use US locale
        ExpenseTracker tracker = new ExpenseTracker();
        loadExpensesFromFile(tracker); // Loads expenses from the file

        // Menu choices
        int choice = 0;
        while (choice !=3) {
            System.out.println("\n --- Options --- \n");
            System.out.println("1. Add Expense");
            System.out.println("2. Generate Report"); 
            System.out.println("3. Exit \n");
            System.out.println("Choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1:
                    addExpense(scanner, tracker);
                    saveExpensesToFile(tracker); // Save expenses in the file
                    break;
            
                case 2:
                    String report = tracker.generateReport(); // Generates report
                    System.out.println(report);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Option.");
            }
        }
        scanner.close();
    }

        private static void addExpense(Scanner scanner, ExpenseTracker tracker) {
            
            // Capture the date
            LocalDate date = getDateFromUser(scanner);
        
            // Collects the user’s information
            String category;
            while (true) {
                
                System.out.print("Enter the expense category: ");
                category = scanner.nextLine().trim(); // Remove spaces

                if (category.isEmpty()) {

                    System.out.println("Category cannot be empty.");
                    continue;

                }

                if (!category.matches("[a-zA-Z\\\\s]+")) { //  Only alphanumeric and spaces

                    System.out.println("Category contains invalid characters.");
                    continue;
                }

                category = formaString(category);
                break; // Valid category


            }
            
            String description;
            while (true) {
               
                System.out.print("Enter the expense description: ");
                description = scanner.nextLine().trim(); // Remove spaces

                if (description.isEmpty()) {
                    
                    System.out.println("Description cannot be empty.");
                    continue;

                }

                if (!description.matches("[a-zA-Z\\\\s]+")) { // Only letters and spaces

                    System.out.println("Description contains invalid characters (numbers or symbols).");
                    continue;

                }

                description = formaString(description);
                break; // Valid description
                
            }


            
        
            System.out.print("Enter the amount of the expense: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Clear the buffer
        
            // Use the date collected from the user
            Expense expense = new Expense(date, description, amount, category);
        
            tracker.addExpense(expense);
        }

        private static String formaString(String str) {

            if (str == null || str.isEmpty()) { 

                return str;

            }

            return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
        }

        // This method will give the possibility to use the current date or not
        private static LocalDate getDateFromUser(Scanner scanner) {

            System.out.print("Use current date? (Y/N): ");
            String choice = scanner.nextLine().trim();

            if (choice.equalsIgnoreCase("Y")) {

                return LocalDate.now();

            } else {

                int year = 0, month = 0, day = 0;
                boolean validYear = false, validMonth = false, validDay = false;
        
                // Loop to validate the year
                while (!validYear) {

                    System.out.print("Enter year (YYYY): ");
                    String yearInput = scanner.nextLine().trim(); // Remove blank space

                    if (yearInput.isEmpty()) { // Checks if it is empty

                        System.out.println("Year cannot be empty.");
                        continue;

                    }
                    try {

                        year = Integer.parseInt(yearInput);

                        if (String.valueOf(year).length() != 4) {
                            throw new IllegalArgumentException("Year must have 4 digits.");
                        }

                        validYear = true;

                    } catch (NumberFormatException e) {

                        System.out.println("Invalid year. Please enter a number.");

                    } catch (IllegalArgumentException e) {

                        System.out.println(e.getMessage());
                    }
                }
        
                // Loop to validate the month
                while (!validMonth) {

                    System.out.print("Enter month (MM): ");
                    String monthInput = scanner.nextLine().trim(); // Remove blank spaces

                    if (monthInput.isEmpty()) { // Checks if it is empty

                        System.out.println("Month cannot be empty.");
                        continue;

                    }
                    try {

                        month = Integer.parseInt(monthInput);

                        if (String.valueOf(month).length() != 1 || month < 1 || month > 12) {

                            throw new IllegalArgumentException("Month must have 1 digits and be between 1 and 12.");

                        }

                        validMonth = true;

                    } catch (NumberFormatException e) {

                        System.out.println("Invalid month. Please enter a number.");

                    } catch (IllegalArgumentException e) {

                        System.out.println(e.getMessage());

                    }
                }
        
                // Loop to validate the day
                while (!validDay) {

                    System.out.print("Enter day (DD): ");
                    String dayInput = scanner.nextLine().trim(); // Remove blank spaces

                    if (dayInput.isEmpty()) { // Checks if it is empty

                        System.out.println("Day cannot be empty.");
                        continue;

                    }

                    try {

                        day = Integer.parseInt(dayInput);

                        if (day < 1 || day > 31) {

                            throw new IllegalArgumentException("Day must be between 1 and 31.");

                        }

                        validDay = true;

                    } catch (NumberFormatException e) {

                        System.out.println("Invalid day. Please enter a number.");

                    } catch (IllegalArgumentException e) {

                        System.out.println(e.getMessage());

                    }
                }
        
                return LocalDate.of(year, month, day);
            }
        }

         private static void saveExpensesToFile(ExpenseTracker tracker) {

            // Used to write into CSV file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("expenses.csv"))) {

                for (Expense expense : tracker.getExpenses()) {

                    writer.write(expense.getDate() + ", " + expense.getCategory() + ", " + expense.getDescription() + ", " + expense.getAmount());
                    writer.newLine();

                }
            } catch (IOException e) {

                System.out.println("Error saving expenses: " + e.getMessage());

            }
        }
    
        private static void loadExpensesFromFile(ExpenseTracker tracker) {

            // Read the saved expenses in a CSV file
            try (BufferedReader reader = new BufferedReader(new FileReader("expenses.csv"))) {
                String line;

                while ((line = reader.readLine()) != null) {

                    String[] parts = line.split(","); // Split the string into an array

                    LocalDate date = LocalDate.parse(parts[0]); // Accesses the element of array
                    String category = parts[1]; // Accesses the element of array
                    String description = parts[2]; // Accesses the element of array
                    double amount = Double.parseDouble(parts[3]); // Accesses the element of array

                    Expense expense = new Expense(date, description, amount, category); // Creates a new object

                    tracker.addExpense(expense); // Add expense

                }
            } catch (FileNotFoundException e) {

                System.out.println("Expense file not found or empty.");

            } catch (IOException e) {

                System.out.println("Error loading expenses: " + e.getMessage());

            }
        }
}




