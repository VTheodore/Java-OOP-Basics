package entities.characters.heros;

import entities.characters.ComicCharacterImpl;
import utils.Constants;

public abstract class Hero extends ComicCharacterImpl {
    private double heroism;

    public Hero(String name, int energy, double health, double intelligence, double heroism) {
        super(name, energy, health, intelligence);
        this.setHeroism(heroism);
    }

    private void setHeroism(double heroism) {
        if (heroism <= 0){
            throw new IllegalArgumentException(Constants.HEROISM_EXCEPTION);
        }

        this.heroism = heroism;
    }

    @Override
    public double getSpecial() {
        return this.heroism;
    }
}
