package L02_Encapsulation.p_02_salary_increase;

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
            String[] tokens = in.readLine().split("\\s+");

            String firstName = tokens[0];
            String lastName = tokens[1];
            Integer age = Integer.valueOf(tokens[2]);
            Double salary = Double.valueOf(tokens[3]);

            Person person = new Person(firstName, lastName, age, salary);

            people.add(person);
        }

        Double bonus = Double.valueOf(in.readLine());

        for (Person person : people) {
            person.increaseSalary(bonus);
            System.out.println(person.toString());
        }
    }
}
