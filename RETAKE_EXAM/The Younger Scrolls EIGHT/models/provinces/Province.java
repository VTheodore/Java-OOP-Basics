package models.provinces;

import models.guilds.Guild;

import java.util.LinkedHashMap;
import java.util.Map;

public class Province {
    private static final String ADD_GUILD_SUCCESS = "Added Guild: ";

    private Map<String, Guild> guilds;

    private String name;

    public Province(String name) {
        this.name = name;
        this.guilds = new LinkedHashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public String addGuild(Guild guild){

        this.guilds.put(guild.getName(), guild);

        return ADD_GUILD_SUCCESS + guild.getName();
    }

    public String removeGuild(Guild guild){
        this.guilds.remove(guild.getName());

        return String.format("Removed guild [%s] with %d members.", guild.getName(), guild.getGuildSize());
    }

    public Guild getGuildByName(String guildName){
        return this.guilds.get(guildName);
    }

    public boolean contains(String guildName){
        return this.guilds.containsKey(guildName);
    }

    public Map<String, Guild> getGuilds() {
        return this.guilds;
    }
}
