package L01_DefiningClassesEXC.p_05_speed_racing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        var cars = new LinkedHashMap<String, Car>();

        for (int i = 0; i < n; i++) {
            String[] tokens = in.readLine().split("\\s+");

            String model = tokens[0];
            double fuelAmount = Integer.parseInt(tokens[1]);
            double fuelPerOneKm = Double.parseDouble(tokens[2]);

            Car car = new Car(model, fuelAmount, fuelPerOneKm);

            cars.putIfAbsent(model, car);
        }

        while (true){
            String[] tokens = in.readLine().split("\\s+");
            if ("End".equals(tokens[0]))break;

            String model = tokens[1];
            int km = Integer.parseInt(tokens[2]);

            cars.get(model).driveCar(km);
        }

        cars.entrySet().forEach(c -> {
            System.out.println(c.getValue());
        });
    }
}
