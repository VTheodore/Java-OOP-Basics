package L02_EncapsulationEXC.p_03_animal_farm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));

        String name = in.readLine();
        int age = Integer.parseInt(in.readLine());

        Chicken chicken;
        try {
            chicken = new Chicken(name, age);
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
            return;
        }

        System.out.println(chicken);
    }
}
