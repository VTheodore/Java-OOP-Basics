package p_04_say_hello;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Bulgarian("Stamatkata"));
        people.add(new European("Gogata"));
        people.add(new Chinese("CingChong"));

        for (Person person : people) {
            printPerson(person);
        }
    }

    private static void printPerson(Person person) {
        System.out.println(person.sayHello());
    }
}
