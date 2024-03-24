package piggyBank;

import java.util.Date;

public class Savings {
    private int id;
    private String name;
    private float targetAmount;
    private Date deadline;

    public Savings(int id, String name, float targetAmount, Date deadline) {
        this.id = id;
        this.name = name;
        this.targetAmount = targetAmount;
        this.deadline = deadline;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(float targetAmount) {
        this.targetAmount = targetAmount;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
