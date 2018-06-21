package L01_DefiningClassesEXC.p_08_pokemon_trainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;

    private int numberOfBadges;

    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        pokemons = new ArrayList<>();
    }

    public void addPokemon(Pokemon pokemon){
        pokemons.add(pokemon);
    }

    public void executeCommandElement(String element){
        boolean isPresent = false;
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getElement().equals(element)){
                isPresent = true;
                break;
            }
        }

        if (isPresent){
            this.numberOfBadges++;
        }else{
            loseHealth();
        }
    }

    private void loseHealth(){
        for (int i = 0; i < this.pokemons.size(); i++) {
            this.pokemons.get(i).setHealth(this.pokemons.get(i).getHealth() - 10);
            if (this.pokemons.get(i).getHealth() <= 0){
                this.pokemons.remove(this.pokemons.get(i));
            }
        }
    }

    public int getNumberOfBadges() {
        return this.numberOfBadges;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.numberOfBadges, this.pokemons.size());
    }
}
