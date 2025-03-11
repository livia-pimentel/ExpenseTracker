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

        }

        // Collects the user’s information
        System.out.print("Enter the expense category: ");
        String category =  scanner.nextLine();

        System.out.print("Enter the expense description: ");
        String description = scanner.nextLine();

        System.out.print("Enter the amount of the expense: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Clear the buffer

        Expense expense = new Expense(LocalDate.now(), description, amount, category);

        tracker.addExpense(expense);

        String report = tracker.generateReport();
        System.out.println(report);

        scanner.close();

    }
}
