package models.heroes;

import interfaces.Hero;

public abstract class Characters implements Hero {
    private String name;

    private int magicka;

    private int fatigue;

    private int health;

    private String heroType;

    public Characters(String name, int magicka, int fatigue, int health, String heroType) {
        this.name = name;
        this.magicka = magicka;
        this.fatigue = fatigue;
        this.health = health;
        this.heroType = heroType;
    }

    protected int getMagicka() {
        return this.magicka;
    }

    protected int getFatigue() {
        return this.fatigue;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public boolean isDead() {
        return health < 1;
    }

    @Override
    public void attack(Hero hero) {
        hero.receiveDamage(Math.floor(this.getOffense()));
    }

    @Override
    public void receiveDamage(double amount) {
        this.health -= Math.floor(amount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Hero: %s, Type: [%s]", this.getName(), this.heroType)).append(System.lineSeparator());
        sb.append("#Stats: ").append(System.lineSeparator());
        sb.append(String.format("Health: %d", this.getHealth())).append(System.lineSeparator());
        sb.append(String.format("Fatigue: %d", this.fatigue)).append(System.lineSeparator());
        sb.append(String.format("Magicka: %d", this.getMagicka())).append(System.lineSeparator());

        return sb.toString();
    }
}
