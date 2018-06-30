package L04_Polymorphism.p_03_shapes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));

        double r = Double.parseDouble(in.readLine());

        Shape shape = new Circle(r);

        System.out.println(shape.getArea());
        System.out.println(shape.getPerimeter());
    }
}
