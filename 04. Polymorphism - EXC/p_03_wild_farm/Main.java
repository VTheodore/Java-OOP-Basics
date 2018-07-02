package PolymorphismEXC.p_03_wild_farm;

import PolymorphismEXC.p_03_wild_farm.animals.*;
import PolymorphismEXC.p_03_wild_farm.foods.Food;
import PolymorphismEXC.p_03_wild_farm.foods.Meat;
import PolymorphismEXC.p_03_wild_farm.foods.Vegetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] animalTokens = in.readLine().split("\\s+");
            if ("End".equals(animalTokens[0])) break;
            String[] foodTokens = in.readLine().split("\\s+");

            String type = foodTokens[0];
            Integer quantity = Integer.valueOf(foodTokens[1]);

            Food food = null;
            switch (type) {
                case "Vegetable":
                    food = new Vegetable(quantity);
                    break;
                case "Meat":
                    food = new Meat(quantity);
                    break;
            }

            String animalType = animalTokens[0];
            String animalName = animalTokens[1];
            Double animalWeight = Double.valueOf(animalTokens[2]);
            String livingRegion = animalTokens[3];

            Animal animal = null;

            switch (animalType) {
                case "Cat":
                    String breed = animalTokens[4];
                    animal = new Cat(animalName, "Cat", livingRegion, animalWeight, breed);
                    break;
                case "Tiger":
                    animal = new Tiger(animalName, "Tiger", livingRegion, animalWeight);
                    break;
                case "Zebra":
                    animal = new Zebra(animalName, "Zebra", livingRegion, animalWeight);
                    break;
                case "Mouse":
                    animal = new Mouse(animalName, "Mouse", livingRegion, animalWeight);
                    break;
            }

            if (animal != null) {
                animal.makeSound();
                try {
                    animal.eat(food);
                } catch (IllegalArgumentException iae) {
                    System.out.println(iae.getMessage());
                }

                System.out.println(animal.toString());
            }
        }
    }
}
