package L02_EncapsulationEXC.p_04_shopping_spree;

public class Product {
    private static final String NAME_ERR_MSG = "Name cannot be empty";

    private static final String COST_ERR_MSG = "Money cannot be negative";

    private String name;

    private double cost;

    public Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    private void setName(String name) {
        if (name == null || name.equals(" ")){
            throw new IllegalArgumentException(NAME_ERR_MSG);
        }

        this.name = name;
    }

    private void setCost(double cost) {
        if (cost < 0){
            throw new IllegalArgumentException(COST_ERR_MSG);
        }
        this.cost = cost;
    }

    public String getName() {
        return this.name;
    }

    public double getCost() {
        return this.cost;
    }
}
