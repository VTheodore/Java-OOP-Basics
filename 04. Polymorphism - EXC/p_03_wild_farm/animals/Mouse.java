package PolymorphismEXC.p_03_wild_farm.animals;

import PolymorphismEXC.p_03_wild_farm.foods.Food;

public class Mouse extends Mammal {
    public Mouse(String animalName, String animalType, String livingRegion, Double animalWeight) {
        super(animalName, animalType, livingRegion, animalWeight);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Meat")){
            throw new IllegalArgumentException("Mice are not eating that type of food!");
        }

        super.setFoodEaten(food.getQuantity());
    }

    @Override
    public String toString() {
        return String.format("Mouse[%s, %s, %s, %d]", super.getAnimalName(), super.getAnimalWeight(), super.getLivingRegion(), super.getFoodEaten());
    }
}
