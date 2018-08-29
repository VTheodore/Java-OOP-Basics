package entities.characters;

import contracts.ComicCharacter;
import contracts.SuperPower;
import entities.powers.Power;
import utils.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public abstract class ComicCharacterImpl implements ComicCharacter {
    private String name;

    private int energy;

    private double health;

    private double intelligence;

    private List<SuperPower> powers;

    private boolean inArena;


    public ComicCharacterImpl(String name, int energy, double health, double intelligence) {
        this.setName(name);
        this.setEnergy(energy);
        this.setHealth(health);
        this.setIntelligence(intelligence);
        this.powers = new ArrayList<>();
    }

    public void setName(String name) {
        Pattern pattern = Pattern.compile("^[A-Z-a-z_]{2,12}$");

        Matcher matcher = pattern.matcher(name);

        if (!matcher.find()){
            throw new IllegalArgumentException(Constants.NAME_EXCEPTION);
        }

        this.name = name;
    }

    private void setEnergy(int energy) {
        if (energy < 0 || energy > 300){
            throw new IllegalArgumentException(Constants.ENERGY_EXCEPTION);
        }
        this.energy = energy;
    }

    private void setHealth(double health) {
        if (health <= 0){
            throw new IllegalArgumentException(Constants.HEALTH_EXCEPTION);
        }
        this.health = health;
    }

    private void setIntelligence(double intelligence) {
        if (intelligence <= 0 || intelligence > 200){
            throw new IllegalArgumentException(Constants.INTELLIGENCE_EXCEPTION);
        }

        this.intelligence = intelligence;
    }


    @Override
    public void boostCharacter(int energy, double health, double intelligence) {
        this.setEnergy(energy);
        this.setHealth(health);
        this.setIntelligence(intelligence);
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    @Override
    public double getHealth() {
        return this.health;
    }

    @Override
    public double getIntelligence() {
        return this.intelligence;
    }

    @Override
    public String useSuperPowers() {
        if (this.powers.size() == 0){
            return String.format("%s has no super powers!", this.getName());
        }

        for (SuperPower power : powers) {
            this.energy += power.getPowerPoints();
            this.health += power.getPowerPoints() * 2;
        }
        return String.format("%s used his super powers!", this.getName());
    }

    @Override
    public void addSuperPower(SuperPower superPower) {
        this.powers.add(superPower);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<SuperPower> superPowers(){
        return this.powers;
    }

    @Override
    public boolean isInArena() {
        return this.inArena;
    }

    @Override
    public void startArena() {
        this.inArena = true;
    }

    @Override
    public void endArena() {
        this.inArena = false;
    }

    public void setHealthForFight(double damage){
        this.health -= damage;
    }
}
