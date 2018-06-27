package L03_InheritanceEXC.p_01_person;

public class Person {
    protected String name;

    protected int age;

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private String getName(){
        return this.name;
    }

    private void setName(String name){
        if (name.length() < 3){
            throw new IllegalArgumentException("Name's length should not be less than 3 symbols!");
        }
        this.name = name;
    }

    private Integer getAge(){
        return this.age;
    }

    protected void setAge(int age){
        if (age < 1){
            throw new IllegalArgumentException("Age must be positive!");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Age: %d", this.getName(), this.getAge());
    }
}
