package L03_InheritanceEXC.p_03_mankind;

public class Worker extends Human {
    private double weekSalary;

    private double workHoursPerDay;


    public Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    private String getWeekSalary() {
        return String.format("%.2f",this.weekSalary);
    }

    private void setWeekSalary(double weekSalary) {
        if (weekSalary <= 10){
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }

        this.weekSalary = weekSalary;
    }

    private String getWorkHoursPerDay() {
        return String.format("%.2f", this.workHoursPerDay);
    }

    private void setWorkHoursPerDay(double workHoursPerDay) {
        if (workHoursPerDay < 1 || workHoursPerDay > 12){
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    private String getSalaryPerHour(){
        double perHour = (this.weekSalary / 7) / this.workHoursPerDay;

        return String.format("%.2f", perHour);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        sb.append("First Name: ").append(super.getFirstName())
                .append(System.lineSeparator())
                .append("Last Name: ").append(super.getLastName())
                .append(System.lineSeparator())
                .append("Week Salary: ").append(this.getWeekSalary())
                .append(System.lineSeparator())
                .append("Hours per day: ").append(this.getWorkHoursPerDay())
                .append(System.lineSeparator())
                .append("Salary per hour: ").append(this.getSalaryPerHour());

        return sb.toString();
    }
}
