package models.heroes.endurance_heroes;

public class Orc extends Endurance {
    private static final String HERO_TYPE = "ORSIMER";

    public Orc(String name, int magicka, int fatigue, int health) {
        super(name, magicka, fatigue, health, HERO_TYPE);
    }

    @Override
    public double getDefense() {
        return super.getDefense() * 1.1;
    }

}
