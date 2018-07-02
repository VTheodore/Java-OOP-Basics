package PolymorphismEXC.p_03_wild_farm.animals;

import PolymorphismEXC.p_03_wild_farm.foods.Food;

import java.text.DecimalFormat;

public abstract class Animal {
    private String animalName;

    private String animalType;

    private Double animalWeight;

    private Integer foodEaten;

    public Animal(String animalName, String animalType, Double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
    }

    public abstract void makeSound();

    public abstract void eat(Food food);

    public Integer getFoodEaten() {
        if (this.foodEaten == null){
            return 0;
        }
        return this.foodEaten;
    }

    public void setFoodEaten(Integer foodEaten) {
        this.foodEaten = foodEaten;
    }

    protected String getAnimalName() {
        return this.animalName;
    }

    protected String getAnimalType() {
        return this.animalType;
    }

    protected String getAnimalWeight() {
        DecimalFormat df = new DecimalFormat("#.##########");
        return df.format(this.animalWeight);
    }
}
