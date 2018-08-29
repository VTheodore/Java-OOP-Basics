package entities.characters.antiHeros;

import entities.characters.ComicCharacterImpl;
import utils.Constants;

public abstract class AntiHero extends ComicCharacterImpl {
    private double evilness;

    public AntiHero(String name, int energy, double health, double intelligence, double evilness) {
        super(name, energy, health, intelligence);
        this.setEvilness(evilness);
    }

    private void setEvilness(double evilness) {
        if (evilness < 0){
            throw new IllegalArgumentException(Constants.EVILNESS_EXCEPTION);
        }

        this.evilness = evilness;
    }

    @Override
    public double getSpecial() {
        return this.evilness;
    }
}
