package cars;

public abstract class Car {
    private String brand;

    private String model;

    private int yearOfProduction;

    private int horsepower;

    private int acceleration;

    private int suspension;

    private int durability;

    private boolean inRace;

    private boolean inGarage;

    public Car(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        this.setBrand(brand);
        this.setModel(model);
        this.setYearOfProduction(yearOfProduction);
        this.setHorsepower( horsepower);
        this.setAcceleration(acceleration);
        this.setSuspension(suspension);
        this.setDurability(durability);
        this.inRace = false;
        this.inGarage = false;
    }

    private void setBrand(String brand) {
        this.brand = brand;
    }

    private void setModel(String model) {
        this.model = model;
    }

    private void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    protected void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    private void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    protected void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    private void setDurability(int durability) {
        this.durability = durability;
    }

    public boolean isInRace() {
        return this.inRace;
    }

    public void participateInRace(){
        this.inRace = true;
    }


    public void endRace(){
        this.inRace = false;
    }


    public int getOverallPerformance(){
        return (this.horsepower / this.acceleration) + (this.suspension + this.durability);
    }

    public int getEnginePerformance(){
        return this.horsepower / this.acceleration;
    }

    public int getSuspensionPerformance(){
        return this.suspension + this.durability;
    }

    public int getTimePerformance(){
        return (this.horsepower / 100) * this.acceleration;
    }

    public void decreaseDurability(int lenght){
        this.setDurability(this.getDurability() - lenght);
    }

    public String getModel() {
        return this.model;
    }

    public int getHorsepower() {
        return this.horsepower;
    }

    public int getSuspension() {
        return this.suspension;
    }

    public String getBrand() {
        return this.brand;
    }

    public int getYearOfProduction() {
        return this.yearOfProduction;
    }

    public int getAcceleration() {
        return this.acceleration;
    }

    public int getDurability() {
        return this.durability;
    }

    public void increaseHorsepower(int tuneIndex) {
        this.setHorsepower(this.getHorsepower() + tuneIndex);
    }

    public void increaseSuspension(int tuneIndex) {
        this.setSuspension(this.getSuspension() + tuneIndex / 2);
    }
}
