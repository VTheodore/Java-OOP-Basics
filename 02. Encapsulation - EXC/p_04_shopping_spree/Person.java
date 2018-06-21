package L02_EncapsulationEXC.p_04_shopping_spree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
    private static final String NAME_ERR_MSG = "Name cannot be empty";

    private static final String MONEY_ERR_MSG = "Money cannot be negative";

    private String name;

    private double money;

    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.equals(" ")){
            throw new IllegalArgumentException(NAME_ERR_MSG);
        }

        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0){
            throw new IllegalArgumentException(MONEY_ERR_MSG);
        }

        this.money = money;
    }

    private double getMoney() {
        return this.money;
    }

    private String getName() {
        return this.name;
    }

    public void addProduct(Product product){
        this.products.add(product);
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(this.products);
    }

    public void buyProduct(Product food){
        if (this.getMoney() < food.getCost()){
            String errMsg = String.format("%s can't afford %s", this.getName(), food.getName());
            throw new IllegalArgumentException(errMsg);
        }

        this.setMoney(this.getMoney() - food.getCost());
    }
}
