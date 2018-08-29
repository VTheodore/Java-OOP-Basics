package entities.arenas;

import contracts.Arena;
import contracts.ComicCharacter;
import entities.characters.antiHeros.AntiHero;
import entities.characters.heros.Hero;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ArenaImpl implements Arena {
    private String arenaName;

    private List<Hero> heroes;

    private List<AntiHero> antiHeroes;

    private int capacity;

    public ArenaImpl(String arenaName, int capacity) {
        this.arenaName = arenaName;
        this.capacity = capacity;
        this.heroes = new ArrayList<>();
        this.antiHeroes = new ArrayList<>();
    }

    @Override
    public String getArenaName() {
        return this.arenaName;
    }

    @Override
    public boolean isArenaFull() {
        int count = 0;

        for (Hero hero : heroes) {
            count++;
        }

        for (AntiHero antiHero : antiHeroes) {
            count++;
        }

        return count == this.capacity;
    }

    @Override
    public void addHero(ComicCharacter hero) {
        this.heroes.add(((Hero) hero));
    }

    @Override
    public void addAntiHero(ComicCharacter antiHero) {
        this.antiHeroes.add((AntiHero) antiHero);
    }

    @Override
    public boolean fightHeroes() {
        String firstToAttack;
        if (this.heroes.size() >= this.antiHeroes.size()) {
            firstToAttack = "AntiHeroes";
        } else {
            firstToAttack = "Heroes";
        }

        String winner = null;


        while (this.heroes.size() > 0 || this.antiHeroes.size() > 0) {
            for (int i = 0; i < Math.min(this.heroes.size(), this.antiHeroes.size()); i++) {
                AntiHero antiHero = this.antiHeroes.get(i);
                Hero hero = this.heroes.get(i);
                if (firstToAttack.equals("AntiHeroes")) {
                    hero.setHealthForFight(antiHero.attack());
                } else {
                    antiHero.setHealthForFight(hero.attack());
                }
            }

            this.heroes.removeIf(hero -> hero.getHealth() <= 0);

            this.antiHeroes.removeIf(antiHero2 -> antiHero2.getHealth() <= 0);


            if (this.heroes.size() == 0) {
                winner = "anti";
                break;
            } else if (this.antiHeroes.size() == 0) {
                winner = "heroes";
                break;
            }

            for (int i = 0; i < Math.min(this.heroes.size(), this.antiHeroes.size()); i++) {
                AntiHero antiHero = this.antiHeroes.get(i);
                Hero hero = this.heroes.get(i);

                if (!firstToAttack.equals("AntiHeroes")) {
                    hero.setHealthForFight(antiHero.attack());
                } else {
                    antiHero.setHealthForFight(hero.attack());
                }
            }

           this.heroes.removeIf(hero2 -> hero2.getHealth() <= 0);

            this.antiHeroes.removeIf(antiHero2 -> antiHero2.getHealth() <= 0);

            if (this.heroes.size() == 0) {
                winner = "anti";
                break;
            } else if (this.antiHeroes.size() == 0) {
                winner = "heroes";
                break;
            }
        }

        for (Hero hero : heroes) {
            hero.endArena();
        }

        for (AntiHero antiHero : antiHeroes) {
            antiHero.endArena();
        }

        return !winner.equals("anti");
    }

    @Override
    public boolean isArenaEmpty() {
        return this.antiHeroes.size() + this.heroes.size() == 0;
    }
}
