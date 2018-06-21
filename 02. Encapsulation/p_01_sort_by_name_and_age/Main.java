package L02_Encapsulation.p_01_sort_by_name_and_age;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        List<Person> people = new ArrayList<>();

        while (n-- > 0){
            String[] tokens = in.readLine().split(" ");
            String firstName = tokens[0];
            String lastName = tokens[1];
            Integer age = Integer.valueOf(tokens[2]);

            Person person = new Person(firstName, lastName, age);

            people.add(person);
        }

        people.stream()
                .sorted((p1, p2) -> {
                    int nameComp = p1.getFirstName().compareTo(p2.getFirstName());

                    if (nameComp != 0){
                        return nameComp;
                    }

                    return Integer.compare(p1.getAge(), p2.getAge());
                }).forEach(System.out::println);
    }
}
