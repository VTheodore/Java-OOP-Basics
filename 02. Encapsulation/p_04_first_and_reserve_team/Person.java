package L02_Encapsulation.p_04_first_and_reserve_team;

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

    public Integer getAge() {
        return this.age;
    }
}
