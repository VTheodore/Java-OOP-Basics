package L02_EncapsulationEXC.p_05_pizza_calories;

public class Dough {
    private static final int DEFAULT_CALORIES = 2;

    private static final String DOUGH_ERR_MSG = "Invalid type of dough.";

    private static final String DOUGH_WEIGHT_ERR_MSG = "Dough weight should be in the range [1..200].";

    private String flourType;

    private String bakingTechnique;

    private double weight;

    private double doughModifier;

    public Dough(String flourType, double weight) {
        this.setFlourType(flourType);
        this.setWeight(weight);
    }

    public Dough(String flourType, String bakingTechnique, double weight) {
        this(flourType, weight);
        this.setBakingTechnique(bakingTechnique);
    }

    private void setFlourType(String flourType) {
        switch (flourType){
            case "White":
                this.doughModifier = 1.5;
                break;
            case "Wholegrain":
                this.doughModifier = 1.0;
                break;
                default:
                    throw new IllegalArgumentException(DOUGH_ERR_MSG);
        }

        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        switch (bakingTechnique){
            case "Crispy":
                this.doughModifier *= 0.9;
                break;
            case "Chewy":
                this.doughModifier *= 1.1;
                break;
            case "Homemade":
                this.doughModifier *= 1.0;
                break;
                default:
                    throw new IllegalArgumentException(DOUGH_ERR_MSG);
        }

        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 && weight > 200){
            throw new IllegalArgumentException(DOUGH_WEIGHT_ERR_MSG);
        }
        this.weight = weight;
    }

    public double getCalories(){
        return DEFAULT_CALORIES * this.weight * this.doughModifier;
    }
}
