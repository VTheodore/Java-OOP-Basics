package PolymorphismEXC.p_03_wild_farm.animals;

import PolymorphismEXC.p_03_wild_farm.foods.Food;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, String animalType, String livingRegion, Double animalWeight, String breed) {
        super(animalName, animalType, livingRegion, animalWeight);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
        super.setFoodEaten(food.getQuantity());
    }

    private String getBreed() {
        return this.breed;
    }

    @Override
    public String toString() {
        return String.format("Cat[%s, %s, %s, %s, %d]", super.getAnimalName(), this.getBreed(), super.getAnimalWeight(), super.getLivingRegion(), super.getFoodEaten());
    }
}
