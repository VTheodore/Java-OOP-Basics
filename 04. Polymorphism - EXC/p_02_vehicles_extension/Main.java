package PolymorphismEXC.p_02_vehicles_extension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final String DRIVE_COMMAND = "Drive";

    private static final String REFUEL_COMMAND = "Refuel";

    private static final String CAR_VEHICLE = "Car";

    private static final String TRUCK_VEHICLE = "Truck";

    private static final String BUS_VEHICLE = "Bus";

    private static final String DRIVEEMPTY_COMMAND = "DriveEmpty";

    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));

        String[] carTokens = in.readLine().split("\\s+");
        String[] truckTokens = in.readLine().split("\\s+");
        String[] busTokens = in.readLine().split("\\s+");

        Vehicle car = new Car(Double.parseDouble(carTokens[3]), Double.parseDouble(carTokens[1]), Double.parseDouble(carTokens[2]));
        Vehicle truck = new Truck(Double.parseDouble(truckTokens[3]), Double.parseDouble(truckTokens[1]), Double.parseDouble(carTokens[2]));
        Vehicle bus = new Bus(Double.parseDouble(busTokens[3]), Double.parseDouble(busTokens[1]), Double.parseDouble(busTokens[2]));

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
                            driveVehicle(car, distance);
                            break;
                        case TRUCK_VEHICLE:
                            driveVehicle(truck, distance);
                            break;
                        case BUS_VEHICLE:
                            driveVehicle(bus, distance);
                            break;
                    }
                    break;
                case REFUEL_COMMAND:
                    double litersToRefuel = Double.parseDouble(commandTokens[2]);
                    switch (vehicle){
                        case CAR_VEHICLE:
                            refuelVehicle(car, litersToRefuel);
                            break;
                        case TRUCK_VEHICLE:
                            refuelVehicle(truck, litersToRefuel);
                            break;
                        case BUS_VEHICLE:
                            refuelVehicle(bus, litersToRefuel);
                            break;
                    }
                    break;
                case DRIVEEMPTY_COMMAND:
                    double busDistance = Double.parseDouble(commandTokens[2]);
                    try{
                        System.out.println(((Bus) bus).driveEmpty(busDistance));
                    } catch (IllegalArgumentException iae){
                        System.out.println(iae.getMessage());
                    }
                    break;
            }
        }

        System.out.println(car.toString());
        System.out.println(truck.toString());
        System.out.println(bus.toString());
    }

    private static void refuelVehicle(Vehicle car, double litersToRefuel) {
        try {
            car.refuel(litersToRefuel);
        } catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }
    }

    private static void driveVehicle(Vehicle car, double distance) {
        try {
            System.out.println(car.drive(distance));
        } catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }
    }
}
