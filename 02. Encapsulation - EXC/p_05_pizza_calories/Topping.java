package L02_EncapsulationEXC.p_05_pizza_calories;

public class Topping {
    private static final int DEFAULT_CALORIES = 2;

    private String type;

    private double weight;

    private double toppingModifier;

    public Topping(String type, double weight) {
        this.setType(type);
        this.setWeight(weight);
    }

    private void setType(String type) {
        switch (type){
            case "Meat":
                this.toppingModifier = 1.2;
                break;
            case "Veggies":
                this.toppingModifier = 0.8;
                break;
            case "Cheese":
                this.toppingModifier = 1.1;
                break;
            case "Sauce":
                this.toppingModifier = 0.9;
                break;
                default:
                    String err = String.format("Cannot place %s on top of your pizza.", type);
                    throw new IllegalArgumentException(err);
        }

        this.type = type;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50){
            String err = String.format("%s weight should be in the range [1..50].", this.type);
            throw new IllegalArgumentException(err);
        }

        this.weight = weight;
    }

    public double getCalories(){
        return DEFAULT_CALORIES * this.weight * this.toppingModifier;
    }
}
