package L01_DefiningClassesEXC.p_09_google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        var people = new HashMap<String, Person>();

        while (true) {
            String[] tokens = in.readLine().split(" ");
            if ("End".equals(tokens[0])) break;

            String personName = tokens[0];
            String infoType = tokens[1];

            Person person;
            if (!people.containsKey(personName)) {
                person = new Person(personName);
            }else {
                person = people.get(personName);
            }


            switch (infoType) {
                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);

                    Company company = new Company(companyName, department, salary);
                    person.setCompany(company);
                    break;
                case "car":
                    String carModel = tokens[2];
                    int carSpeed = Integer.parseInt(tokens[3]);

                    Car car = new Car(carModel, carSpeed);
                    person.setCar(car);
                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];

                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    person.addPokemon(pokemon);
                    break;
                case "parents":
                    String parentName = tokens[2];
                    String parentBirthDate = tokens[3];

                    Parent parent = new Parent(parentName, parentBirthDate);
                    person.addParent(parent);
                    break;
                case "children":
                    String childName = tokens[2];
                    String childBirthDate = tokens[3];

                    Child child = new Child(childName, childBirthDate);
                    person.addChild(child);
                    break;
            }

            people.put(personName, person);
        }

        String personToShow = in.readLine();

        System.out.println(people.get(personToShow).toString());
    }
}
