package p_05_say_hello_extended;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Bulgarian("Goshkata"));
        people.add(new European("Pascal"));
        people.add(new Chinese("Alfonso"));

        for (Person person : people) {
            printPerson(person);
        }
    }

    private static void printPerson(Person person) {
        System.out.println(person.sayHello());
    }
}
