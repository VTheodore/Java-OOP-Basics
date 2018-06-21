package L02_Encapsulation.p_02_salary_increase;

import java.text.DecimalFormat;

public class Person {
    private String firstName;

    private String lastName;

    private Integer age;

    private Double salary;


    public Person(String firstName, String lastName, Integer age, Double salary) {
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
        StringBuilder res = new StringBuilder();

        res.append(this.getFirstName()).append(" ");
        res.append(this.getLastName()).append(" gets ");

        DecimalFormat df = new DecimalFormat("#.0###########################");
        res.append(df.format(this.getSalary())).append(" leva");

        return res.toString();
    }
}
