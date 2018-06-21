package L01_DefiningClassesEXC.p_06_raw_data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        List<Car> cars = new ArrayList();
        for (int i = 0; i < n; i++) {
            String[] tokens = in.readLine().split("\\s+");

            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);

            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];

            Cargo cargo = new Cargo(cargoType, cargoWeight);

            double tire1Pressure = Double.parseDouble(tokens[5]);
            int tire1Age = Integer.parseInt(tokens[6]);
            double tire2Pressure = Double.parseDouble(tokens[7]);
            int tire2Age = Integer.parseInt(tokens[8]);
            double tire3Pressure = Double.parseDouble(tokens[9]);
            int tire3Age = Integer.parseInt(tokens[10]);
            double tire4Pressure = Double.parseDouble(tokens[11]);
            int tire4Age = Integer.parseInt(tokens[12]);

            Tire tires = new Tire(tire1Pressure, tire1Age, tire2Pressure, tire2Age, tire3Pressure, tire3Age, tire4Pressure, tire4Age);

            Car car = new Car(model, engine, cargo, tires);
            cars.add(car);
        }

        String command = in.readLine();

        if ("fragile".equals(command)){
            cars.stream()
                    .filter(c -> {
                        if ("fragile".equals(c.getCargo().getCargoType()) && (c.getTires().getTire1Pressure() < 1 || c.getTires().getTire2Pressure() < 1 || c.getTires().getTire3Pressure() < 1  || c.getTires().getTire4Pressure() < 1))return true;

                        return false;
                    }).forEach(car -> System.out.println(car.getModel()));
        }else {
            cars.stream()
                    .filter(c -> {
                        if ("flamable".equals(c.getCargo().getCargoType()) && c.getEngine().getEnginePower() > 250)return true;

                        return false;
                    }).forEach(car -> System.out.println(car.getModel()));
        }
    }
}
