package engine;

import contracts.Arena;
import contracts.ComicCharacter;
import contracts.Manager;
import contracts.SuperPower;

import java.util.LinkedHashMap;
import java.util.Map;

public class WarManager implements Manager {
    private Map<String, ComicCharacter> comicCharacters;

    private Map<String, Arena> arenas;

    private Map<String, SuperPower> pool;

    private int heroesVictories;

    private int antiHeroesVictories;

    public WarManager() {
        this.comicCharacters = new LinkedHashMap<>();
        this.arenas = new LinkedHashMap<>();
        this.pool = new LinkedHashMap<>();
    }

    @Override
    public String checkComicCharacter(String characterName) {
        ComicCharacter character;

        try {
            character = comicCharacters.get(characterName);
        } catch (Exception ex) {
            return String.format("Sorry, fans! %s doesn't exist in our comics!", characterName);
        }

        if (character.getHealth() <= 0) {
            return String.format("%s has fallen in battle!", characterName);
        }

        return character.toString();
    }

    @Override
    public String addHero(ComicCharacter hero) {
        String name = hero.getName();

        if (!this.comicCharacters.containsKey(name)) {
            this.comicCharacters.put(name, hero);

            return String.format("%s is ready for battle!", name);
        }

        this.comicCharacters.get(name).boostCharacter(hero.getEnergy(), hero.getHealth(), hero.getIntelligence());

        return String.format("%s evolved!", name);
    }

    @Override
    public String addAntiHero(ComicCharacter antiHero) {
        String name = antiHero.getName();

        if (!this.comicCharacters.containsKey(name)) {
            this.comicCharacters.put(name, antiHero);

            return String.format("%s is ready for destruction!", name);
        }

        this.comicCharacters.get(name).boostCharacter(antiHero.getEnergy(), antiHero.getHealth(), antiHero.getIntelligence());

        return String.format("%s is getting stronger!", name);
    }

    @Override
    public String addArena(Arena arena) {
        String name = arena.getArenaName();

        if (!this.arenas.containsKey(name)) {
            this.arenas.put(name, arena);

            return String.format("%s is becoming a fighting ground!", name);
        }

        return "A battle is about to start there!";
    }

    @Override
    public String addHeroToArena(String arena, String hero) {
        ComicCharacter character = this.comicCharacters.get(hero);
        Arena arena1 = this.arenas.get(arena);

        if (character.isInArena()){
            return String.format("%s is fighting!", hero);
        }

        if (character.getHealth() <= 0){
            return String.format("%s is dead!", hero);
        }

        if (arena1.isArenaFull()){
            return "Arena is full!";
        }

        arena1.addHero(character);
        character.startArena();

        return String.format("%s is fighting for your freedom in %s!", hero, arena);
    }

    @Override
    public String addAntiHeroToArena(String arena, String antiHeroName) {
        ComicCharacter character = this.comicCharacters.get(antiHeroName);
        Arena arena1 = this.arenas.get(arena);

        if (character.isInArena()){
            return String.format("%s is fighting!", antiHeroName);
        }

        if (character.getHealth() <= 0){
            return String.format("%s is dead!", antiHeroName);
        }

        if (arena1.isArenaFull()){
            return "Arena is full!";
        }

        arena1.addAntiHero(character);
        character.startArena();

        return String.format("%s and his colleagues are trying to take over %s!", antiHeroName, arena);
    }

    @Override
    public String loadSuperPowerToPool(SuperPower superPower) {
        String name = superPower.getName();
        if (!this.pool.containsKey(name)) {
            this.pool.put(name, superPower);

            return String.format("%s added to pool!", name);
        }


        return "This super power already exists!";
    }

    @Override
    public String assignSuperPowerToComicCharacter(String comicCharacter, String superPower) {
        SuperPower sp = this.pool.get(superPower);
        ComicCharacter character = this.comicCharacters.get(comicCharacter);

        if (character.superPowers().contains(sp)) {
            return String.format("%s already assigned!", superPower);
        }

        character.addSuperPower(sp);
        this.pool.remove(superPower);


        return String.format("%s has a new super power!", comicCharacter);
    }

    @Override
    public String usePowers(String characterName) {
        ComicCharacter character = this.comicCharacters.get(characterName);

        return character.useSuperPowers();
    }

    @Override
    public String startBattle(String arena) {
        Arena arena1 = this.arenas.get(arena);

        if (arena1.isArenaEmpty()){
            return "SAFE ZONE!";
        }

        if (arena1.fightHeroes()){
            this.heroesVictories++;
            return String.format("Heroes won the battle of %s!", arena);
        }

        this.antiHeroesVictories++;
        this.arenas.remove(arena);
        return String.format("Anti Heroes won the battle of %s!", arena);
    }

    @Override
    public String endWar() {
        if (this.heroesVictories >= this.antiHeroesVictories){
            return String.format("After %d battles our FRIENDLY HEROES WON!", this.antiHeroesVictories + this.heroesVictories);
        }

        return "WE ARE DOOMED!";
    }

}
