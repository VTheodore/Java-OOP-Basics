package p_06_animals;

import java.util.ArrayList;
import java.util.List;

public class AnimalKingdom {
    private List<Animal> animals;

    public AnimalKingdom() {
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal){
        this.animals.add(animal);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        for (Animal animal : animals) {
            sb.append(animal.getClass().getSimpleName())
            .append(System.lineSeparator())
            .append(animal.getName()).append(' ').append(animal.getAge()).append(' ').append(animal.getGender())
            .append(System.lineSeparator())
            .append(animal.produceSound())
            .append(System.lineSeparator());
        }

        return sb.toString();
    }
}
