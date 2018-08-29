package models.heroes.endurance_heroes;

import models.heroes.Characters;

public class Endurance extends Characters {
    private double magicResist;


    public Endurance(String name, int magicka, int fatigue, int health, String heroType) {
        super(name, magicka, fatigue, health * 2, heroType);
        this.setMagicResist();
    }

    private void setMagicResist() {
        this.magicResist = super.getMagicka() * 0.4;
    }

    private double getMagicResist() {
        return this.magicResist;
    }

    @Override
    public double getOffense() {
        return super.getFatigue();
    }

    @Override
    public double getDefense() {
        return super.getHealth() + 0.6 * super.getFatigue() + this.getMagicResist();
    }

    @Override
    public double getTotalPoints() {
        return this.getOffense() + this.getDefense();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());

        sb.append("#Endurance bonuses:").append(System.lineSeparator());
        sb.append(String.format("Magic resistance: +%.2f defense.", this.getMagicResist())).append(System.lineSeparator());

        return sb.toString();
    }
}
