package L01_DefiningClassesEXC.p_03_opinion_poll;

public class Person {
    private String name;

    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString(){
        return String.format("%s - %d", getName(), getAge());
    }
}
