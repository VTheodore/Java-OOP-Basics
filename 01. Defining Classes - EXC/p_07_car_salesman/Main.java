package L01_DefiningClassesEXC.p_07_car_salesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        var engines = new HashMap<String, Engine>();
        for (int i = 0; i < n; i++) {
            String[] tokens = in.readLine().split("\\s+");

            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);

            Engine engine = null;
            switch (tokens.length){
                case 2:
                    engine = new Engine(model, power);
                    break;
                case 3:
                    if (tokens[2].matches("\\d+")){
                        int displacement = Integer.parseInt(tokens[2]);
                        engine = new Engine(model, power, displacement);
                    }else {
                        String efficiency = tokens[2];
                        engine = new Engine(model, power, efficiency);
                    }
                    break;
                case 4:
                    int displacement = Integer.parseInt(tokens[2]);
                    String efficiency = tokens[3];

                    engine = new Engine(model, power, displacement, efficiency);
                    break;
            }

            engines.put(model, engine);
        }

        List<Car> cars = new ArrayList<>();

        int m = Integer.parseInt(in.readLine());

        for (int i = 0; i < m; i++) {
            String[] tokens = in.readLine().split("\\s+");

            String model = tokens[0];
            String engine = tokens[1];

            Car car = null;
            switch (tokens.length){
                case 2:
                    car = new Car(model, engines.get(engine));
                    break;
                case 3:
                    if (tokens[2].matches("\\d+")){
                        int weight = Integer.parseInt(tokens[2]);
                        car = new Car(model, engines.get(engine), weight);
                    }else {
                        String color = tokens[2];
                        car = new Car(model, engines.get(engine), color);
                    }
                    break;
                case 4:
                    int weight = Integer.parseInt(tokens[2]);
                    String color = tokens[3];

                    car = new Car(model, engines.get(engine), weight, color);
                    break;
            }

            cars.add(car);
        }

        cars.forEach(System.out::println);
    }
}
