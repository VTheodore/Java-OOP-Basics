package factories;

import contracts.ComicCharacter;
import entities.characters.antiHeros.Titan;
import entities.characters.antiHeros.Villain;
import io.ConsoleWriter;
import utils.Constants;

public class AntiHeroFactory {
    private ConsoleWriter writer;

    public AntiHeroFactory() {
        this.writer = new ConsoleWriter();
    }

    public ComicCharacter createAntiHero(String name, String type, int energy, double health, double intelligence, double evilness){
        ComicCharacter character = null;

        switch (type){
            case Constants.TITAN_TYPE:
                try {
                    character = new Titan(name, energy, health, intelligence, evilness);
                }catch (IllegalArgumentException iae){
                    this.writer.writeLine(iae.getMessage());
                }
                break;
            case Constants.VILLAIN_TYPE:
                try {
                    character = new Villain(name, energy, health, intelligence, evilness);
                }catch (IllegalArgumentException iae){
                    this.writer.writeLine(iae.getMessage());
                }
        }

        return character;
    }
}
