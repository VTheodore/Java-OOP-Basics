package PolymorphismEXC.p_02_vehicles_extension;

import java.text.DecimalFormat;

public class Truck extends Vehicle {

    public Truck(double tankCapacity, double fuelQuantity, double fuelConsumption) {
        super(tankCapacity, fuelQuantity, fuelConsumption);
    }

    @Override
    public String drive(double distance) {
        double fuelConsumed = super.getFuelConsumption() * distance;
        if (fuelConsumed > super.getFuelQuantity()){
            return "Truck needs refueling";
        }


        if (fuelConsumed >= super.getFuelQuantity()){
            throw new IllegalArgumentException(NO_FUEL_ERR);
        }

        DecimalFormat df = new DecimalFormat("#.##");
        super.setFuelQuantity(super.getFuelQuantity() - fuelConsumed);
        return String.format("Truck travelled %s km", df.format(distance));
    }

    @Override
    public void refuel(double liters) {
        if (liters <= 0){
            throw new IllegalArgumentException(NO_FUEL_ERR);
        }

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
