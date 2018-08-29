package factories;

import contracts.ComicCharacter;

import entities.characters.heros.DCHero;
import entities.characters.heros.MarvelHero;
import io.ConsoleWriter;
import utils.Constants;

public class HeroFactory {
   private ConsoleWriter writer;

    public HeroFactory() {
        this.writer = new ConsoleWriter();
    }

    public ComicCharacter createHero(String name, String type, int energy, double health, double intelligence, double heroism) {
        ComicCharacter character = null;

        switch (type) {
            case Constants.DC_HERO_TYPE:
                try {
                    character = new DCHero(name, energy, health, intelligence, heroism);
                } catch (IllegalArgumentException iae){
                    this.writer.writeLine(iae.getMessage());
                }
                break;
            case Constants.MARVEL_HERO_TYPE:
                try {
                    character = new MarvelHero(name, energy, health, intelligence, heroism);
                }catch (IllegalArgumentException iae){
                    this.writer.writeLine(iae.getMessage());
                }
                break;
        }

        return character;
    }
}
