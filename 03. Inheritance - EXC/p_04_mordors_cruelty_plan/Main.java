package p_04_mordors_cruelty_plan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));

        String[] foodTokens = in.readLine().split("\\s+");

        GandalfsMood gandalfsMood = new GandalfsMood();

        for (String foodToken : foodTokens) {
            Food food = new Food(foodToken);

            gandalfsMood.addFood(food);
        }

        System.out.println(gandalfsMood.toString());
    }
}
