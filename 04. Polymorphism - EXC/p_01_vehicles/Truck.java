package PolymorphismEXC.p_01_vehicles;

import java.text.DecimalFormat;

public class Truck extends Vehicle {
    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    public String drive(double distance) {
        if (super.getFuelConsumption() * distance > super.getFuelQuantity()){
            return "Truck needs refueling";
        }

        DecimalFormat df = new DecimalFormat("#.##");
        super.setFuelQuantity(super.getFuelQuantity() - super.getFuelConsumption() * distance);
        return String.format("Truck travelled %s km", df.format(distance));
    }

    @Override
    public void refuel(double liters) {
        super.setFuelQuantity(super.getFuelQuantity() + (liters * 0.95));
    }

    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        fuelConsumption += 1.6;
        super.setFuelConsumption(fuelConsumption);
    }

    @Override
    public String toString() {
        return String.format("Truck: %.2f", super.getFuelQuantity());
    }
}
