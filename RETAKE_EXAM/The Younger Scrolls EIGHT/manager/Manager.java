package manager;

import interfaces.Hero;
import models.guilds.Guild;
import models.heroes.endurance_heroes.Nord;
import models.heroes.endurance_heroes.Orc;
import models.heroes.strength_characters.Khajiit;
import models.heroes.strength_characters.Redguard;
import models.heroes.willpower_heroes.Breton;
import models.heroes.willpower_heroes.Dunmer;
import models.provinces.Province;

import java.util.*;
import java.util.stream.Collectors;

public class Manager {
    private static final String CREATED_PROVINCE_MESSAGE = "Created province ";

    private static final String PROVINCE_NOT_SELECTED_ERROR = "No province selected!";

    private static final String NO_SUCH_HERO_TYPE = "No such hero type!";

    private static final String INVALID_STATS = "Invalid character stats!";

    private static final String GUILD_ALREADY_EXISTS = "Guild already exists.";

    private static final String NO_SUCH_HERO = "No such hero in this guild!";

    private Map<String, Province> provinces;

    private Province selectedProvince;

    public Manager() {
        this.provinces = new LinkedHashMap<>();
    }

    public String createProvince(String provinceName) {
        if (this.provinces.containsKey(provinceName)) {
            return String.format("Province with name %s already exists!", provinceName);

        }

        Province province = new Province(provinceName);
        this.provinces.put(provinceName, province);

        this.select(provinceName);
        return CREATED_PROVINCE_MESSAGE + provinceName;
    }

    public String select(String provinceName){
        if (!this.provinces.containsKey(provinceName)){
            return String.format("Province %s does not exist", provinceName);
        }

        if (this.selectedProvince != null && this.selectedProvince.getName().equals(provinceName)){
            return String.format("Province %s has already been selected!", provinceName);
        }

        this.selectedProvince = this.provinces.get(provinceName);

        return String.format("Province %s selected!", provinceName);
    }

    public String addHero(String guildName, String heroType, String heroName, int health, int fatigue, int magicka){
        if (this.selectedProvince == null){
            return PROVINCE_NOT_SELECTED_ERROR;
        }

        if (!this.selectedProvince.contains(guildName)){
            this.selectedProvince.addGuild(new Guild(guildName));
        }

        if (health < 1 || fatigue < 1 || magicka < 1){
            return INVALID_STATS;
        }

        Hero hero;
        switch (heroType){
            case "Nord":
                hero = new Nord(heroName, magicka, fatigue, health);
                break;
            case "Orc":
                hero = new Orc(heroName, magicka, fatigue, health);
                break;
            case "Khajiit":
                hero = new Khajiit(heroName, magicka, fatigue, health);
                break;
            case "Redguard":
                hero = new Redguard(heroName, magicka, fatigue, health);
                break;
            case "Breton":
                hero = new Breton(heroName, magicka, fatigue, health);
                break;
            case "Dunmer":
                hero = new Dunmer(heroName, magicka, fatigue, health);
                break;
                default:
                    return NO_SUCH_HERO_TYPE;
        }

        return this.selectedProvince.getGuildByName(guildName).addHero(hero);
    }

    public String addGuild(String guildName){
        if (this.selectedProvince == null){
            return PROVINCE_NOT_SELECTED_ERROR;
        }

        if (!this.selectedProvince.contains(guildName)){
            this.selectedProvince.addGuild(new Guild(guildName));

            return String.format("Added Guild: %s", guildName);
        }

        return GUILD_ALREADY_EXISTS;
    }

    public String details(String guildName){
        if (this.selectedProvince == null){
            return PROVINCE_NOT_SELECTED_ERROR + System.lineSeparator();
        }

        if (!this.selectedProvince.contains(guildName)){
            return String.format("Guild [%s] does not exist.%n", guildName);
        }

        //print
        return this.selectedProvince.getGuildByName(guildName).toString();
    }

    public String details(String guildName, String heroName){
        if (this.selectedProvince == null){
            return PROVINCE_NOT_SELECTED_ERROR + System.lineSeparator();
        }

        if (!this.selectedProvince.contains(guildName)){
            return String.format("Guild [%s] does not exist.%n", guildName);
        }

        if (!this.selectedProvince.getGuildByName(guildName).contains(heroName)){
            return NO_SUCH_HERO + System.lineSeparator();
        }

        return this.selectedProvince.getGuildByName(guildName).getHeroByName(heroName).toString();
    }

    public String remove(String guildName){
        if (this.selectedProvince == null){
            return PROVINCE_NOT_SELECTED_ERROR;
        }

        if (!this.selectedProvince.contains(guildName)){
            return String.format("Guild %s does not exist.", guildName);
        }

        return this.selectedProvince.removeGuild(this.selectedProvince.getGuildByName(guildName));
    }

    public String remove(String guildName, String heroName){

        if (this.selectedProvince == null){
            return PROVINCE_NOT_SELECTED_ERROR;
        }

        if (!this.selectedProvince.contains(guildName)){
            return String.format("Guild [%s] does not exist.", guildName);
        }

        if (!this.selectedProvince.getGuildByName(guildName).contains(heroName)){
            return NO_SUCH_HERO;
        }

        Hero hero = this.selectedProvince.getGuildByName(guildName).getHeroByName(heroName);

        return this.selectedProvince.getGuildByName(guildName).removeHero(hero);
    }

    public String fight(String guild1Name, String hero1Name, String guild2Name, String hero2Name){

        if (this.selectedProvince == null){
            return PROVINCE_NOT_SELECTED_ERROR;
        }

        if (!this.selectedProvince.contains(guild1Name)){
            return String.format("Guild %s does not exist.", guild1Name);
        }

        if (!this.selectedProvince.getGuildByName(guild1Name).contains(hero1Name)){
            return NO_SUCH_HERO;
        }


        if (!this.selectedProvince.contains(guild2Name)){
            return String.format("Guild %s does not exist.", guild2Name);
        }

        if (!this.selectedProvince.getGuildByName(guild2Name).contains(hero2Name)){
            return NO_SUCH_HERO;
        }

        if (guild1Name.equals(guild2Name)){
            return "Heroes from the same guild can not fight each other.";
        }

        Hero hero1 = this.selectedProvince.getGuildByName(guild1Name).getHeroByName(hero1Name);
        Hero hero2 = this.selectedProvince.getGuildByName(guild2Name).getHeroByName(hero2Name);

        while (!hero1.isDead() && !hero2.isDead()){
            this.attack(hero1, hero2);
        }

        if (hero1.isDead()){
            this.selectedProvince.getGuildByName(guild1Name).removeHero(hero1);
            return String.format("Hero %s sliced hero %s.", hero2.getName(), hero1.getName());
        }

        this.selectedProvince.getGuildByName(guild2Name).removeHero(hero2);

        return String.format("Hero %s sliced hero %s.", hero1.getName(), hero2.getName());

    }

    private void attack(Hero hero1, Hero hero2){
        List<Hero> heroes = new ArrayList<>(){{
            add(hero1);
            add(hero2);
        }};

        heroes.sort((h1, h2) -> {
            int compByHealth = Integer.compare(h1.getHealth(), h2.getHealth());

            if (compByHealth != 0) {
                return compByHealth;
            }

            return Double.compare(h1.getOffense(), h2.getOffense());
        });

        heroes.get(0).attack(heroes.get(1));
    }

    public String end(){
        StringBuilder sb = new StringBuilder();

        if (this.selectedProvince == null){
            return PROVINCE_NOT_SELECTED_ERROR;
        }

        this.provinces.values().stream().sorted(Comparator.comparing(Province::getName)).forEach(province -> {
            sb.append(String.format("Province: %s", province.getName())).append(System.lineSeparator());
            sb.append("#Guilds: ");

            if (province.getGuilds().size() == 0){
                sb.append("None").append(System.lineSeparator());
            }else {
                sb.append(System.lineSeparator());
                province.getGuilds().values().stream().sorted((g1, g2) -> {
                    int totalPointsComp = Double.compare(g2.getGuildPower(), g1.getGuildPower());

                    if (totalPointsComp != 0){
                        return totalPointsComp;
                    }

                    return g1.getName().compareTo(g2.getName());
                }).forEach(guild -> sb.append(String.format("##Guild: Name: %s, Power: %.2f, Size: %d", guild.getName(), guild.getGuildPower(), guild.getGuildSize())).append(System.lineSeparator()));
            }
        });

        return sb.toString();
    }
}
