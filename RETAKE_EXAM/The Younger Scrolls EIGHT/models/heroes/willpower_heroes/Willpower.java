package models.heroes.willpower_heroes;

import models.heroes.Characters;

public class Willpower extends Characters {
    private double spellPentration;

    public Willpower(String name, int magicka, int fatigue, int health, String heroType) {
        super(name, magicka, fatigue, health, heroType);
        this.setSpellPentration();
    }

    private void setSpellPentration() {
        this.spellPentration = super.getFatigue() * 0.2;
    }

    private double getSpellPentration() {
        return this.spellPentration;
    }

    @Override
    public double getOffense() {
        return 1.8 * super.getMagicka() + this.getSpellPentration();
    }

    @Override
    public double getDefense() {
        return super.getHealth();
    }

    @Override
    public double getTotalPoints() {
        return this.getOffense() + this.getDefense();
    }
}
