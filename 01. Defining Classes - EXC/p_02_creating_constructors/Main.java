package L01_DefiningClassesEXC.p_02_creating_constructors;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Class personClass = Person.class;

        Constructor emptyCtor = personClass.getDeclaredConstructor();
        Constructor ageCtor = personClass.getDeclaredConstructor(int.class);
        Constructor nameAgeCtor = personClass.getDeclaredConstructor(String.class, int.class);

        String name = in.readLine();
        int age = Integer.parseInt(in.readLine());

        Person basePerson = (Person) emptyCtor.newInstance();
        Person personWithAge = (Person) ageCtor.newInstance(age);
        Person personFull = (Person) nameAgeCtor.newInstance(name, age);

        System.out.printf("%s %s%n", basePerson.getName(), basePerson.getAge());
        System.out.printf("%s %s%n", personWithAge.getName(), personWithAge.getAge());
        System.out.printf("%s %s%n", personFull.getName(), personFull.getAge());
    }
}
