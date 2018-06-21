package L02_EncapsulationEXC.p_04_shopping_spree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));

        String[] personTokens = in.readLine().split(";");

        var people = new LinkedHashMap<String, Person>();

        for (String token : personTokens) {
            String personName = token.split("=")[0];
            double personMoney = Double.parseDouble(token.split("=")[1]);

            try {
                Person person = new Person(personName, personMoney);
                people.put(personName, person);
            }catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
                return;
            }
        }

        String[] foodTokens = in.readLine().split(";");

        var products = new LinkedHashMap<String, Product>();

        for (String token : foodTokens) {
            String foodName = token.split("=")[0];
            double foodCost = Double.parseDouble(token.split("=")[1]);

            try {
                Product product = new Product(foodName, foodCost);
                products.put(foodName, product);
            }catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
                return;
            }
        }

        while (true){
            String[] tokens = in.readLine().split("\\s+");
            if ("END".equals(tokens[0]))break;

            String personName = tokens[0];
            String foodName = tokens[1];

            try {
                people.get(personName).buyProduct(products.get(foodName));
                people.get(personName).addProduct(products.get(foodName));

                System.out.printf("%s bought %s%n", personName, foodName);
            }catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            }
        }

        for (String person : people.keySet()) {
            StringBuilder res = new StringBuilder().append(person).append(" - ");

            if (people.get(person).getProducts().isEmpty()){
                res.append("Nothing bought");
                System.out.println(res.toString());
                continue;
            }

            for (Product product : people.get(person).getProducts()) {
                res.append(product.getName()).append(", ");
            }



            System.out.println(res.substring(0, res.length() - 2));
        }
    }
}
