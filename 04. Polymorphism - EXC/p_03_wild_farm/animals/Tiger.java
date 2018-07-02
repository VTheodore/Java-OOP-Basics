package PolymorphismEXC.p_03_wild_farm.animals;

import PolymorphismEXC.p_03_wild_farm.foods.Food;

public class Tiger extends Felime {
    private String livingRegion;

    public Tiger(String animalName, String animalType, String livingRegion, Double animalWeight) {
        super(animalName, animalType, livingRegion, animalWeight);
        this.livingRegion = livingRegion;
    }


    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Vegetable")){
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
        super.setFoodEaten(food.getQuantity());
    }

    @Override
    public String toString() {
        return String.format("Tiger[%s, %s, %s, %d]", super.getAnimalName(), super.getAnimalWeight(), super.getLivingRegion(), super.getFoodEaten());
    }
}
