package L02_EncapsulationEXC.p_02_class_box_validation;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));

        double length = Double.parseDouble(in.readLine());
        double width = Double.parseDouble(in.readLine());
        double height = Double.parseDouble(in.readLine());

        Box box;

        try {
            box = new Box(length, width, height);
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
            return;
        }

        System.out.printf("Surface Area - %.2f%n", box.getSurfaceArea());
        System.out.printf("Lateral Surface Area - %.2f%n", box.getLateralArea());
        System.out.printf("Volume - %.2f%n", box.getVolume());
    }
}
