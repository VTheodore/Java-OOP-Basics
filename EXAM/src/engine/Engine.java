package engine;

import factories.AntiHeroFactory;
import factories.ArenaFactory;
import factories.HeroFactory;
import factories.SuperPowerFactory;
import io.ConsoleReader;
import io.ConsoleWriter;
import utils.Constants;

import java.io.IOException;

public class Engine {
    private WarManager manager;

    private ConsoleWriter writer;

    private ConsoleReader reader;

    public Engine() {
        this.manager = new WarManager();
        this.writer = new ConsoleWriter();
        this.reader = new ConsoleReader();
    }

    public void start() throws IOException {
        while (true) {
            String[] tokens = this.reader.readLine().split("\\s+");
            if (Constants.END_CMD.equals(tokens[0])) {
                this.writer.writeLine(this.manager.endWar());
                break;
            }

            String cmd = tokens[0];

            switch (cmd) {
                case Constants.CHECK_CHARACTER_CMD:
                    this.writer.writeLine(manager.checkComicCharacter(tokens[1]));
                    break;
                case Constants.REGISTER_HERO_CMD:
                    String heroName = tokens[1];
                    String heroType = tokens[2];
                    int heroEnergy = Integer.parseInt(tokens[3]);
                    double heroHealth = Double.parseDouble(tokens[4]);
                    double heroIntelligence = Double.parseDouble(tokens[5]);
                    double heroHeroism = Double.parseDouble(tokens[6]);

                    this.writer.writeLine(this.manager.addHero(new HeroFactory().createHero(heroName, heroType, heroEnergy, heroHealth, heroIntelligence, heroHeroism)));
                    break;
                case Constants.REGISTER_ANTI_HERO_CMD:
                    String antiHeroName = tokens[1];
                    String antiHeroType = tokens[2];
                    int antiHeroEnergy = Integer.parseInt(tokens[3]);
                    double antiHeroHealth = Double.parseDouble(tokens[4]);
                    double antiHeroIntelligence = Double.parseDouble(tokens[5]);
                    double antiHeroEvilness = Double.parseDouble(tokens[6]);

                    this.writer.writeLine(this.manager.addAntiHero(new AntiHeroFactory().createAntiHero(antiHeroName, antiHeroType, antiHeroEnergy, antiHeroHealth, antiHeroIntelligence, antiHeroEvilness)));
                    break;
                case Constants.BUILD_ARENA_CMD:
                    String arenaNameToCreate = tokens[1];
                    int capacityToCreate = Integer.parseInt(tokens[2]);

                    this.writer.writeLine(this.manager.addArena(new ArenaFactory().createArena(arenaNameToCreate, capacityToCreate)));

                    break;
                case Constants.SEND_HERO_CMD:
                    String arenaNameToSends = tokens[1];
                    String heroToSend = tokens[2];

                    try {
                        this.writer.writeLine(this.manager.addHeroToArena(arenaNameToSends, heroToSend));
                    } catch (IllegalArgumentException iae) {
                        this.writer.writeLine(iae.getMessage());
                    }
                    break;
                case Constants.SEND_ANTI_HERO_CMD:
                    String arenaNameToSendAntiHero = tokens[1];
                    String antiHeroToSend = tokens[2];

                    try {
                        this.writer.writeLine(manager.addAntiHeroToArena(arenaNameToSendAntiHero, antiHeroToSend));
                    } catch (IllegalArgumentException iae) {
                        this.writer.writeLine(iae.getMessage());
                    }

                    break;
                case Constants.SUPER_POWER_CMD:
                    String superPowerName = tokens[1];
                    double powerPoints = Double.parseDouble(tokens[2]);

                    this.writer.writeLine(this.manager.loadSuperPowerToPool(new SuperPowerFactory().createSuperPower(superPowerName, powerPoints)));

                    break;
                case Constants.ASSIGN_POWER_CMD:
                    String comicCharacterName = tokens[1];
                    String superPowerName1 = tokens[2];

                    System.out.println(manager.assignSuperPowerToComicCharacter(comicCharacterName, superPowerName1));
                    break;
                case Constants.UNLEASH_CMD:
                    String comicCharName = tokens[1];
                    System.out.println(manager.usePowers(comicCharName));
                    break;
                case Constants.COMICS_WAR_CMD:
                    String arenaName3 = tokens[1];
                    System.out.println(manager.startBattle(arenaName3));
                    break;
            }
        }
    }
}
