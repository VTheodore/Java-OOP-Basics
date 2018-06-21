package L01_DefiningClassesEXC.p_08_pokemon_trainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        var trainers = new LinkedHashMap<String, Trainer>();

        while (true){
            String[] tokens = in.readLine().split(" ");
            if ("Tournament".equals(tokens[0]))break;

            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            if (!trainers.containsKey(trainerName)){
                Trainer trainer = new Trainer(trainerName);
                trainer.addPokemon(pokemon);
                trainers.put(trainerName, trainer);
            }else {
                trainers.get(trainerName).addPokemon(pokemon);
            }

        }

        while (true){
            String element = in.readLine();
            if ("End".equals(element))break;

            for (Trainer trainer : trainers.values()) {
                trainer.executeCommandElement(element);
            }
        }

        trainers.values().stream()
                .sorted((t1, t2) -> t2.getNumberOfBadges() - t1.getNumberOfBadges())
                .forEach(System.out::println);
    }
}
