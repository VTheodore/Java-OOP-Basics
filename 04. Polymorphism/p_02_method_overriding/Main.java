package L04_Polymorphism.p_02_method_overriding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        List<Rectangle> rectangles = new ArrayList<>();

        while (n-- > 0){
            String[] reminder = in.readLine().split(" ");

            if (reminder.length == 1){
                rectangles.add(new Square(Double.valueOf(reminder[0])));
            }else{
                rectangles.add(new Rectangle(Double.valueOf(reminder[0]), Double.valueOf(reminder[1])));
            }
        }

        for (Rectangle rectangle : rectangles) {
            System.out.println(rectangle.area());
        }

    }
}
