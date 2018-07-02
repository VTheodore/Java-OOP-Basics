package PolymorphismEXC.p_03_wild_farm.animals;

import PolymorphismEXC.p_03_wild_farm.foods.Food;

public class Zebra extends Mammal {
    public Zebra(String animalName, String animalType, String livingRegion, Double animalWeight) {
        super(animalName, animalType, livingRegion, animalWeight);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Meat")){
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }
        super.setFoodEaten(food.getQuantity());
    }

    @Override
    public String toString() {
        return String.format("Zebra[%s, %s, %s, %d]", super.getAnimalName(), super.getAnimalWeight(), super.getLivingRegion(), super.getFoodEaten());
    }
}
