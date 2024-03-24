import java.util.*;

public class PiggyBank {
    private String userName;
    private String email;
    private String password;
    private List<SavingsGoal> savingsGoals;
    private List<Expense> expenses;
    private Map<String, Double> budget;

    // Constructor
    public PiggyBank(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.savingsGoals = new ArrayList<>();
        this.expenses = new ArrayList<>();
        this.budget = new HashMap<>();
    }

    // Method to set savings goals
    public void setSavingsGoal(String name, double targetAmount, Date deadline) {
        SavingsGoal goal = new SavingsGoal(name, targetAmount, deadline);
        savingsGoals.add(goal);
    }

    // Method to track expenses
    public void trackExpense(String category, double amount, Date date) {
        Expense expense = new Expense(category, amount, date);
        expenses.add(expense);
    }

    // Method to create monthly budget
    public void createBudget(String category, double amount) {
        budget.put(category, amount);
    }

    // Method to calculate total expenses
    public double calculateTotalExpenses() {
        double totalExpenses = 0.0;
        for (Expense expense : expenses) {
            totalExpenses += expense.getAmount();
        }
        return totalExpenses;
    }

    // Method to check if savings goal is achieved
    public boolean isGoalAchieved(SavingsGoal goal) {
        double totalSaved = 0.0;
        for (Expense expense : expenses) {
            totalSaved += expense.getAmount();
        }
        return totalSaved >= goal.getTargetAmount();
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user details
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Create PiggyBank instance
        PiggyBank user = new PiggyBank(name, email, password);

        // Set savings goals
        System.out.println("\nSetting up savings goals...");
        System.out.print("Enter goal name: ");
        String goalName = scanner.nextLine();
        System.out.print("Enter target amount: ");
        double targetAmount = scanner.nextDouble();
        System.out.print("Enter deadline (YYYY-MM-DD): ");
        String deadlineStr = scanner.next();
        Date deadline = new Date(Integer.parseInt(deadlineStr.substring(0, 4)) - 1900,
                Integer.parseInt(deadlineStr.substring(5, 7)) - 1,
                Integer.parseInt(deadlineStr.substring(8)));
        user.setSavingsGoal(goalName, targetAmount, deadline);

        // Track expenses
        System.out.println("\nTracking expenses...");
        System.out.print("Enter expense category: ");
        scanner.nextLine(); // Consume newline character
        String category = scanner.nextLine();
        System.out.print("Enter expense amount: ");
        double amount = scanner.nextDouble();
        System.out.print("Enter expense date (YYYY-MM-DD): ");
        deadlineStr = scanner.next();
        Date expenseDate = new Date(Integer.parseInt(deadlineStr.substring(0, 4)) - 1900,
                Integer.parseInt(deadlineStr.substring(5, 7)) - 1,
                Integer.parseInt(deadlineStr.substring(8)));
        user.trackExpense(category, amount, expenseDate);

        // Output total expenses
        double totalExpenses = user.calculateTotalExpenses();
        System.out.println("\nTotal expenses: $" + totalExpenses);

        // Check if savings goal is achieved
        SavingsGoal goal = user.savingsGoals.get(0); // Assuming there's only one goal for simplicity
        boolean isGoalAchieved = user.isGoalAchieved(goal);
        System.out.println("Is " + goal.getName() + " goal achieved? " + isGoalAchieved);

        // Close scanner
        scanner.close();
    }
}
