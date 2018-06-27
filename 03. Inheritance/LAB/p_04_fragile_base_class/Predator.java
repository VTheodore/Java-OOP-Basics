package L03_Inheritance.p_04_fragile_base_class;

public class Predator extends Animal {
    private int health;

    public void feed(Food food){
        super.foodEaten.add(food);
    }
}
