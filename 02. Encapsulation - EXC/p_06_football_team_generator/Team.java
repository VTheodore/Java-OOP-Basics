package L02_EncapsulationEXC.p_06_football_team_generator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private static final String NAME_ERR_MSG = "A name should not be empty.";

    private String name;

    private List<Player> players;

    public Team(String name) {
        this.setName(name);
    }

    private void setName(String name) {
        if (name.equals("") || name.equals(" ") || name == null) {
            throw new IllegalArgumentException(NAME_ERR_MSG);
        }

        this.name = name;
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String player) {

        boolean isPresent = false;
        for (Player pl : this.players) {
            if (pl.getName().equals(player)) {
                this.players.remove(pl);
                isPresent = true;
                break;
            }

        }

        if (!isPresent) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", player, this.name));
        }
    }

    private int getTotalRating() {
        int totalScore = 0;

        for (Player player : players) {
            totalScore += player.getTotalRating();
        }

        return (int) Math.round(totalScore * 1.0 / players.size());
    }

    @Override
    public String toString() {
        return String.format("%s - %d", this.name, this.getTotalRating());
    }
}
