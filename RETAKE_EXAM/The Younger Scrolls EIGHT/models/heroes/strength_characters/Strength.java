package models.heroes.strength_characters;

import models.heroes.Characters;

public class Strength extends Characters {
    private double magicDamage;


    public Strength(String name, int magicka, int fatigue, int health, String heroType) {
        super(name, magicka, fatigue, health, heroType);
        this.setMagicDamage();
    }

    private void setMagicDamage() {
        this.magicDamage = super.getMagicka() * 0.5;
    }

    private double getMagicDamage() {
        return this.magicDamage;
    }

    @Override
    public double getOffense() {
        return 1.25 * super.getFatigue() + 0.3 * super.getHealth() + this.getMagicDamage();
    }

    @Override
    public double getDefense() {
        return super.getHealth() + 0.1 * super.getFatigue();
    }

    @Override
    public double getTotalPoints() {
        return this.getOffense() + this.getDefense();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("#Strength bonuses:").append(System.lineSeparator());
        sb.append(String.format("Magic damage: +%.1f offense.", this.getMagicDamage())).append(System.lineSeparator());

        return sb.toString();
    }
}
