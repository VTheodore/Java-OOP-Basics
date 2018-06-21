package L01_DefiningClassesEXC.p_09_google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;

    private Car car;

    private Company company;

    private List<Parent> parents;

    private List<Child> children;

    private List<Pokemon> pokemons;

    public Person(String name) {
        this.name = name;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void addParent(Parent parent) {
        this.parents.add(parent);
    }

    public void addChild(Child child) {
        this.children.add(child);
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(this.name).append(System.lineSeparator());
        res.append("Company:").append(System.lineSeparator());

        if (this.company != null) {
            res.append(this.company.toString()).append(System.lineSeparator());
        }

        res.append("Car:").append(System.lineSeparator());

        if (this.car != null) {
            res.append(this.car.toString()).append(System.lineSeparator());
        }

        res.append("Pokemon:").append(System.lineSeparator());

        if (this.pokemons.size() != 0) {
            for (Pokemon pokemon : pokemons) {
                res.append(pokemon.toString()).append(System.lineSeparator());
            }
        }

        res.append("Parents:").append(System.lineSeparator());

        if (this.parents.size() != 0) {
            for (Parent parent : parents) {
                res.append(parent.toString()).append(System.lineSeparator());
            }
        }

        res.append("Children:").append(System.lineSeparator());

        if (this.children.size() != 0) {
            for (Child child : children) {
                res.append(child.toString());
            }
        }

        return res.toString();
    }
}
