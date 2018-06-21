package L02_Encapsulation.p_04_first_and_reserve_team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));

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

        Team team = new Team("Levski <3");

        for (Person person : people) {
            team.addPlayer(person);
        }

        System.out.printf("First team have %d players%n", team.getFirstTeam().size());
        System.out.printf("Reserve team have %d players%n", team.getReserveTeam().size());
    }
}
