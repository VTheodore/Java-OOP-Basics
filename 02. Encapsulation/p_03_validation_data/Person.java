package L02_Encapsulation.p_03_validation_data;

import java.text.DecimalFormat;

public class Person {
    public static final Integer MIN_NAME_LENGTH = 3;

    public static final Integer MIN_AGE = 1;

    public static final Double MIN_SALARY = 460.0;

    private String firstName;

    private String lastName;

    private Integer age;

    private Double salary;

    public Person(String firstName, String lastName, Integer age, Double salary) {
        if (firstName.length() < MIN_NAME_LENGTH){
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }

        if (lastName.length() < MIN_NAME_LENGTH){
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }

        if (age <= MIN_AGE){
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }

        if (salary < MIN_SALARY){
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return this.salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void increaseSalary(Double bonus){
        if (this.getAge() < 30){
            this.setSalary(this.getSalary() + this.getSalary() * (bonus / 200));
        }else{
            this.setSalary(this.getSalary() + this.getSalary() * (bonus/100));
        }
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.0#############");
        return String.format("%s %s gets %s leva", this.getFirstName(), this.getLastName(), df.format(this.getSalary()));
    }
}
