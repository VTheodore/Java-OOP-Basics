package L02_EncapsulationEXC.p_05_pizza_calories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] pizzaTokens = in.readLine().split(" ");

        String pizzaName = pizzaTokens[1];
        int numberOfToppings = Integer.parseInt(pizzaTokens[2]);

        Pizza pizza;

        try {
            pizza = new Pizza(pizzaName, numberOfToppings);
        }catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
            return;
        }

        String[] doughTokens = in.readLine().split(" ");

        String flourType = doughTokens[1];
        String bakingTechnique = "";
        double doughWeight;

        if (doughTokens.length == 4){
            bakingTechnique = doughTokens[2];
            doughWeight = Double.parseDouble(doughTokens[3]);
        }else{
            doughWeight = Double.parseDouble(doughTokens[2]);
        }

        Dough dough;
        try{
            if (bakingTechnique.equals("")){
                dough = new Dough(flourType, doughWeight);
            }else {
                dough = new Dough(flourType, bakingTechnique, doughWeight);
            }

            pizza.setDough(dough);
        }catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
            return;
        }

        while (numberOfToppings-- > 0 ){
            String[] toppingTokens = in.readLine().split(" ");
            if ("END".equals(toppingTokens[0]))break;

            String type = toppingTokens[1];
            double weight = Double.parseDouble(toppingTokens[2]);

            Topping topping;
            try {
                topping = new Topping(type, weight);
                pizza.addTopping(topping);
            }catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
                return;
            }
        }

        System.out.println(pizza.toString());

    }
}
