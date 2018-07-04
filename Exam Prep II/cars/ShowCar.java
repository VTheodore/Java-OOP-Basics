package cars;

public class ShowCar extends Car{
    private int stars;


    public ShowCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
    }

    public void addStars(int tuneIndex){
        this.stars += tuneIndex;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        sb.append(super.getBrand()).append(" ").append(super.getModel()).append(" ").append(super.getYearOfProduction())
                .append(System.lineSeparator())
                .append(super.getHorsepower()).append(" HP, 100 m/h in ").append(super.getAcceleration()).append(" s")
                .append(System.lineSeparator())
                .append(super.getSuspension()).append(" Suspension force, ").append(super.getDurability()).append(" Durability")
                .append(System.lineSeparator())
                .append(this.stars).append(" *");

        return sb.toString();
    }
}
