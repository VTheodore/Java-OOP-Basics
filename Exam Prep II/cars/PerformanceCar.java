package cars;

import java.util.ArrayList;
import java.util.List;

public class PerformanceCar extends Car {
    private List<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        super.setHorsepower(super.getHorsepower() + (super.getHorsepower() * 50) / 100);
        super.setSuspension(super.getSuspension() - (super.getSuspension() * 25) / 100);
        this.addOns = new ArrayList<>();
    }


    public void addAddOn(String addOn) {
        this.addOns.add(addOn);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        sb.append(super.getBrand()).append(" ").append(super.getModel()).append(" ").append(super.getYearOfProduction())
                .append(System.lineSeparator())
                .append(super.getHorsepower()).append(" HP, 100 m/h in ").append(super.getAcceleration()).append(" s")
                .append(System.lineSeparator())
                .append(super.getSuspension()).append(" Suspension force, ").append(super.getDurability()).append(" Durability")
                .append(System.lineSeparator());

        if (this.addOns.size() == 0) {
            sb.append("Add-ons: None");
        } else {
            sb.append("Add-ons: ").append(String.join(", ", this.addOns));
        }

        return sb.toString();
    }
}
