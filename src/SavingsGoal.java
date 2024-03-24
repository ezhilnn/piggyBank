import java.util.Date;

public class SavingsGoal {
    private String name;
    private double targetAmount;
    private Date deadline;

    // Constructor
    public SavingsGoal(String name, double targetAmount, Date deadline) {
        this.name = name;
        this.targetAmount = targetAmount;
        this.deadline = deadline;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getTargetAmount() {
        return targetAmount;
    }

    public Date getDeadline() {
        return deadline;
    }
}
