package models.guilds;

import interfaces.Hero;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;

public class Guild {
    private static final String ADD_COMMAND_SUCCESS = "Added hero: ";

    private static final String ADD_COMMAND_UPDATE = "Updated hero: ";
    private Map<String, Hero> heroes;

    private String name;

    public Guild(String name) {
        this.name = name;
        this.heroes = new LinkedHashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public String addHero(Hero hero){
        if (!this.heroes.containsKey(hero.getName())){
            this.heroes.put(hero.getName(), hero);

            return ADD_COMMAND_SUCCESS + hero.getName();
        }

        Hero currentHero = this.heroes.get(hero.getName());

        if (hero.getTotalPoints() - currentHero.getTotalPoints() > 0){
            this.heroes.put(hero.getName(), hero);

            return ADD_COMMAND_UPDATE + hero.getName();
        }

        return String.format("Hero %s can not be replaced by a weaker one.", hero.getName());
    }

    public String removeHero(Hero hero){
        this.heroes.remove(hero.getName());

        return String.format("Successfully removed hero [%s] from guild %s", hero.getName(), this.name);
    }

    public Hero getHeroByName(String heroName){
        return this.heroes.get(heroName);
    }

    public Long getGuildSize(){
        return (long) this.heroes.size();
    }

    public double getGuildPower(){
        double totalPower = 0;

        for (Hero hero : this.heroes.values()) {
            totalPower += hero.getTotalPoints();
        }

        return Double.parseDouble(String.format("%.2f", totalPower));
    }

    public String getGuildSpecialization(){
        return null;
    }

    public boolean contains(String heroName){
        return this.heroes.containsKey(heroName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Guild: %s", this.getName())).append(System.lineSeparator());
        sb.append("###Heroes: ");

        if (this.heroes.size() == 0){
            sb.append("None").append(System.lineSeparator());
        }else{
            sb.append(System.lineSeparator());

            this.heroes.values().stream().sorted((h1, h2) -> {
                int compByPoints = Double.compare(h1.getTotalPoints(), h2.getTotalPoints());

                if (compByPoints != 0){
                    return compByPoints;
                }

                return h1.getName().compareTo(h2.getName());

            }).forEach(hero -> {
                sb.append(String.format("Hero: %s, Offense: %.2f, Defense: %.2f", hero.getName(), hero.getOffense(), hero.getDefense())).append(System.lineSeparator());
            });
        }
        return sb.toString();
    }
}
