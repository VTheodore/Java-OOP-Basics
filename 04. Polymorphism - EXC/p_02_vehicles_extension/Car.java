package PolymorphismEXC.p_02_vehicles_extension;

import java.text.DecimalFormat;

public class Car extends Vehicle {


    public Car(double tankCapacity, double fuelQuantity, double fuelConsumption) {
        super(tankCapacity, fuelQuantity, fuelConsumption);
    }

    @Override
    public String drive(double distance) {
        double fuelConsumed = super.getFuelConsumption() * distance;
        if (fuelConsumed > super.getFuelQuantity()){
            return "Car needs refueling";
        }


        if (fuelConsumed >= super.getFuelQuantity()){
            throw new IllegalArgumentException(NO_FUEL_ERR);
        }

        DecimalFormat df = new DecimalFormat("#.##");
        super.setFuelQuantity(super.getFuelQuantity() - fuelConsumed);
        return String.format("Car travelled %s km", df.format(distance));
    }

    @Override
    public void refuel(double liters) {
        if (liters <= 0){
            throw new IllegalArgumentException(NO_FUEL_ERR);
        }
        super.setFuelQuantity(super.getFuelQuantity() + liters);
    }

    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        fuelConsumption += 0.9;
        super.setFuelConsumption(fuelConsumption);
    }

    @Override
    public String toString() {
        return String.format("Car: %.2f", super.getFuelQuantity());
    }
}
