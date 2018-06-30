package p_06_animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));

        AnimalKingdom animalKingdom = new AnimalKingdom();
        while (true) {
            String type = in.readLine();
            if ("Beast!".equals(type)) break;

            String[] tokens = in.readLine().split(" ");
            if (tokens.length != 3) {
                System.out.println("Invalid input!");
                continue;
            }

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String gender = tokens[2];

            Animal animal;

            try {
                switch (type) {
                    case "Dog":
                        animal = new Dog(name, age, gender);
                        break;
                    case "Cat":
                        animal = new Cat(name, age, gender);
                        break;
                    case "Frog":
                        animal = new Frog(name, age, gender);
                        break;
                    case "Kitten":
                        animal = new Kitten(name, age, gender);
                        break;
                    case "Tomcat":
                        animal = new Tomcat(name, age, gender);
                        break;
                    default:
                        animal = new Animal(name, age, gender);
                        break;
                }

                animalKingdom.addAnimal(animal);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }

        }

        System.out.println(animalKingdom.toString());
    }
}
