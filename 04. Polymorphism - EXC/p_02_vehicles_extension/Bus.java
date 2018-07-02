package PolymorphismEXC.p_02_vehicles_extension;

import java.text.DecimalFormat;

public class Bus extends Vehicle {


    public Bus(double tankCapacity, double fuelQuantity, double fuelConsumption) {
        super(tankCapacity, fuelQuantity, fuelConsumption);
    }

    @Override
    public String drive(double distance) {
        double fuelConsumed = (super.getFuelConsumption() + 1.4) * distance;

        if (fuelConsumed > super.getFuelQuantity()) {
            return "Bus needs refueling";
        }


        if (fuelConsumed >= super.getFuelQuantity()) {
            throw new IllegalArgumentException(NO_FUEL_ERR);
        }

        DecimalFormat df = new DecimalFormat("#.##");
        super.setFuelQuantity(super.getFuelQuantity() - fuelConsumed);
        return String.format("Bus travelled %s km", df.format(distance));
    }

    public String driveEmpty(double distance) {
        double fuelConsumed = super.getFuelConsumption() * distance;

        if (super.getFuelConsumption() * distance > super.getFuelQuantity()) {
            return "Bus needs refueling";
        }


        if (fuelConsumed >= super.getFuelQuantity()) {
            throw new IllegalArgumentException(NO_FUEL_ERR);
        }

        DecimalFormat df = new DecimalFormat("#.##");
        super.setFuelQuantity(super.getFuelQuantity() - fuelConsumed);
        return String.format("Bus travelled %s km", df.format(distance));
    }

    @Override
    public void refuel(double liters) {
        if (liters <= 0){
            throw new IllegalArgumentException(NO_FUEL_ERR);
        }
        super.setFuelQuantity(super.getFuelQuantity() + liters);
    }

    @Override
    public String toString() {
        return String.format("Bus: %.2f", super.getFuelQuantity());
    }
}
