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

        int choice = 0;
        
        while (choice !=3) {
            System.out.println("1. Add Expense");
            System.out.println("2. Generate Report"); 
            System.out.println("3. Exit");
            System.out.println("Choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1:
                    addExpense(scanner, tracker);
                    saveExpensesToFile(tracker); // Save expenses in the file
                    break;
            
                case 2:
                    String report = tracker.generateReport();
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
            System.out.print("Enter the expense category: ");
            String category = scanner.nextLine();
        
            System.out.print("Enter the expense description: ");
            String description = scanner.nextLine();
        
            System.out.print("Enter the amount of the expense: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Clear the buffer
        
            // Use the date collected from the user
            Expense expense = new Expense(date, description, amount, category);
        
            tracker.addExpense(expense);
        }

        // This method will give the possibility to use the current date or not
        private static LocalDate getDateFromUser(Scanner scanner ) {
            System.out.println("Use current date: (Y/N): ");
            String choice = scanner.nextLine();
            
            if (choice.equalsIgnoreCase("Y")) {
                return LocalDate.now();
            } else {
                System.out.print("Enter year: ");
                int year = scanner.nextInt();
                System.out.print("Enter month: ");
                int month = scanner.nextInt();
                System.out.print("Enter day: ");
                int day = scanner.nextInt();
                scanner.nextLine();
                return LocalDate.of(year, month, day);
            }
        }

 
        private static void saveExpensesToFile(ExpenseTracker tracker) {
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
            try (BufferedReader reader = new BufferedReader(new FileReader("expenses.csv"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    LocalDate date = LocalDate.parse(parts[0]);
                    String category = parts[1];
                    String description = parts[2];
                    double amount = Double.parseDouble(parts[3]);
                    Expense expense = new Expense(date, description, amount, category);
                    tracker.addExpense(expense);
                }
            } catch (FileNotFoundException e) {
                System.out.println("Expense file not found or empty.");
            } catch (IOException e) {
                System.out.println("Error loading expenses: " + e.getMessage());
            }
        }
}




