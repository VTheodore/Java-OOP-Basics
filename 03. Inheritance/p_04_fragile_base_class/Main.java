package L03_Inheritance.p_04_fragile_base_class;

public class Main {
    public static void main(String[] args) {
        Predator predator = new Predator();

        Food food = new Food();
        Food food1  = new Food();

        Food[] foods = new Food[2];
        foods[0] = food;
        foods[1] = food1;

        predator.eat(food);
        predator.feed(food);
        predator.eatAll(foods);
    }
}
