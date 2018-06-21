package L01_DefiningClassesEXC.p_05_speed_racing;

public class Car {
    private String model;

    private double fuelAmount;

    private double fuelPerOneKm;

    private int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelPerOneKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelPerOneKm = fuelPerOneKm;
    }

    public void driveCar(int km){
        double fuelSpent = this.fuelPerOneKm * km;

        if (fuelSpent > this.fuelAmount){
            System.out.println("Insufficient fuel for the drive");
        }else{
            this.distanceTraveled += km;
            this.fuelAmount -= fuelSpent;
        }
    }

    @Override
    public String toString(){
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distanceTraveled);
    }

}
