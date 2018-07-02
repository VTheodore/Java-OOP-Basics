package p_04_mordors_cruelty_plan;

import java.util.ArrayList;
import java.util.List;

public class GandalfsMood {
    private List<Food> foods;

    private int totalPoints;

    private String mood;

    public GandalfsMood() {
        this.foods = new ArrayList<>();
    }

    public void addFood(Food food){
        this.foods.add(food);
    }

    private int getTotalPoints(){
        for (Food food : this.foods) {
            this.totalPoints += food.getPoints();
        }

        return this.totalPoints;
    }

    private String getMood(){
        if (this.totalPoints < -5){
            this.mood = "Angry";
        }else if (this.totalPoints < 0){
            this.mood = "Sad";
        }else if (this.totalPoints < 15){
            this.mood = "Happy";
        }else {
            this.mood = "JavaScript";
        }

        return this.mood;
    }

    @Override
    public String toString() {
        return String.format("%d%n%s", this.getTotalPoints(), this.getMood());
    }
}
