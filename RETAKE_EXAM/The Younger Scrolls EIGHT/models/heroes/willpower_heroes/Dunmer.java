package models.heroes.willpower_heroes;

public class Dunmer extends Willpower {
    private static final String HERO_TYPE = "DUNMER";

    public Dunmer(String name, int magicka, int fatigue, int health) {
        super(name, magicka, fatigue, health, HERO_TYPE);
    }

}
