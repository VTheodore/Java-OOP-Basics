package PolymorphismEXC.p_01_vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final String DRIVE_COMMAND = "Drive";

    private static final String REFUEL_COMMAND = "Refuel";

    private static final String CAR_VEHICLE = "Car";

    private static final String TRUCK_VEHICLE = "Truck";

    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));

        String[] carTokens = in.readLine().split("\\s+");
        String[] truckTokens = in.readLine().split("\\s+");

        Vehicle car = new Car(Double.parseDouble(carTokens[1]), Double.parseDouble(carTokens[2]));
        Vehicle truck = new Truck(Double.parseDouble(truckTokens[1]), Double.parseDouble(truckTokens[2]));

        int n = Integer.parseInt(in.readLine());

        while (n-- > 0){
            String[] commandTokens = in.readLine().split("\\s+");

            String command = commandTokens[0];
            String vehicle = commandTokens[1];

            switch (command){
                case DRIVE_COMMAND:
                    double distance = Double.parseDouble(commandTokens[2]);
                    switch (vehicle){
                        case CAR_VEHICLE:
                            System.out.println(car.drive(distance));
                            break;
                        case TRUCK_VEHICLE:
                            System.out.println(truck.drive(distance));
                            break;
                    }
                    break;
                case REFUEL_COMMAND:
                    double litersToRefuel = Double.parseDouble(commandTokens[2]);
                    switch (vehicle){
                        case CAR_VEHICLE:
                            car.refuel(litersToRefuel);
                            break;
                        case TRUCK_VEHICLE:
                            truck.refuel(litersToRefuel);
                            break;
                    }
                    break;
            }
        }

        System.out.println(car.toString());
        System.out.println(truck.toString());
    }
}
