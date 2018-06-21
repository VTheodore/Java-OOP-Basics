package L02_EncapsulationEXC.p_05_pizza_calories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private static final String NAME_ERR_MSG = "Pizza name should be between 1 and 15 symbols.";

    private static final String TOPPING_ERR_MSG = "Number of toppings should be in range [0..10].";

    private String name;

    private int numberOfToppings;

    private Dough dough;

    private List<Topping> toppings;

    private double calories;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setNumberOfToppings(numberOfToppings);
        this.toppings = new ArrayList<>();

    }

    private void setName(String name) {
        if (name.length() < 1 || name.length() > 15){
            throw new IllegalArgumentException(NAME_ERR_MSG);
        }

        this.name = name;
    }

    private void setNumberOfToppings(int numberOfToppings) {
        if (numberOfToppings < 0 || numberOfToppings > 10){
            throw new IllegalArgumentException(TOPPING_ERR_MSG);
        }

        this.numberOfToppings = numberOfToppings;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void addTopping(Topping topping){
        this.toppings.add(topping);
    }

    private double getTotalCalories() {
        this.calories = dough.getCalories();

        for (Topping topping : toppings) {
            this.calories += topping.getCalories();
        }

        return this.calories;
    }


    @Override
    public String toString() {
        return String.format("%s - %.2f", this.name, this.getTotalCalories());
    }
}
