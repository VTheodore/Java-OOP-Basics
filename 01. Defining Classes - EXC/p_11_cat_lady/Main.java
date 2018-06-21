package L01_DefiningClassesEXC.p_11_cat_lady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        var cats = new HashMap<String, Cat>();

        while (true){
            String[] tokens = in.readLine().split(" ");
            if ("End".equals(tokens[0]))break;

            String type = tokens[0];
            String name = tokens[1];

            switch (type) {
                case "StreetExtraordinaire":
                    double decibelsOfMeows = Double.parseDouble(tokens[2]);
                    var strExtr = new StreetExtraordinaire(name, decibelsOfMeows);
                    cats.putIfAbsent(name, strExtr);

                    break;
                case "Siamese":
                    double earSize = Double.parseDouble(tokens[2]);
                    var siamese = new Siamese(name, earSize);
                    cats.putIfAbsent(name, siamese);

                    break;
                case "Cymric":
                    double furLength = Double.parseDouble(tokens[2]);
                    var cymric = new Cymric(name, furLength);
                    cats.putIfAbsent(name, cymric);
                    break;
            }
        }

        String catToPrint = in.readLine();

        System.out.println(cats.get(catToPrint).toString());
    }
}
