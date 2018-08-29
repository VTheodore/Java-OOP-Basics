package models.heroes.endurance_heroes;

public class Nord extends Endurance {
    private static final String HERO_TYPE = "NORD";

    public Nord(String name, int magicka, int fatigue, int health) {
        super(name, magicka, fatigue, health, HERO_TYPE);
    }

}
