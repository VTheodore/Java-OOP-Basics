package PolymorphismEXC.p_02_vehicles_extension;

public abstract class Vehicle {
    protected static final String NO_FUEL_ERR = "Fuel must be a positive number";

    private static final String OVERFILLED_ERR = "Cannot fit fuel in tank";

    private double fuelQuantity;

    private double fuelConsumption;

    private double tankCapacity;

    public Vehicle(double tankCapacity, double fuelQuantity, double fuelConsumption) {
        this.setTankCapacity(tankCapacity);
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
    }

    public abstract String drive(double distance);

    public abstract void refuel(double liters);

    protected double getFuelQuantity() {
        return this.fuelQuantity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity > this.tankCapacity){
            throw new IllegalArgumentException(OVERFILLED_ERR);
        }

        this.fuelQuantity = fuelQuantity;
    }

    protected double getFuelConsumption() {
        return this.fuelConsumption;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    protected double getTankCapacity() {
        return this.tankCapacity;
    }

    protected void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }
}
