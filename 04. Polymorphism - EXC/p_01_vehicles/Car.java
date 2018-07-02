package PolymorphismEXC.p_01_vehicles;

import java.text.DecimalFormat;

public class Car extends Vehicle {
    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    public String drive(double distance) {
        if (super.getFuelConsumption() * distance > super.getFuelQuantity()){
            return "Car needs refueling";
        }

        DecimalFormat df = new DecimalFormat("#.##");
        super.setFuelQuantity(super.getFuelQuantity() - super.getFuelConsumption() * distance);
        return String.format("Car travelled %s km", df.format(distance));
    }

    @Override
    public void refuel(double liters) {
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
