package L02_EncapsulationEXC.p_06_football_team_generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        var teams = new HashMap<String, Team>();

        while (true){
            String[] tokens = in.readLine().split(";");
            if ("END".equals(tokens[0]))break;

            String command = tokens[0];

            switch (command){
                case "Team":
                    String teamName = tokens[1];

                    try {
                        Team team = new Team(teamName);
                        teams.put(teamName, team);
                    }catch (IllegalArgumentException iae){
                        System.out.println(iae.getMessage());
                    }

                    break;
                case "Add":
                    String teamToAdd = tokens[1];
                    if (!teams.containsKey(teamToAdd)){
                        System.out.printf("Team %s does not exist.%n", teamToAdd);
                        break;
                    }

                    String playerNameToAdd = tokens[2];
                    double endurance = Double.parseDouble(tokens[3]);
                    double sprint = Double.parseDouble(tokens[4]);
                    double dribble = Double.parseDouble(tokens[5]);
                    double passing = Double.parseDouble(tokens[6]);
                    double shooting = Double.parseDouble(tokens[7]);

                    Player player;

                    try {
                        player = new Player(playerNameToAdd, endurance, sprint, dribble, passing, shooting);
                        teams.get(teamToAdd).addPlayer(player);
                    }catch (IllegalArgumentException iae){
                        System.out.println(iae.getMessage());
                    }

                    break;
                case "Remove":
                    String team = tokens[1];
                    String playerToRemove = tokens[2];

                    try {
                        teams.get(team).removePlayer(playerToRemove);
                    }catch (IllegalArgumentException iae){
                        System.out.println(iae.getMessage());
                    }

                    break;
                case "Rating":
                    String teamToRate = tokens[1];
                    if (!teams.containsKey(teamToRate)){
                        System.out.printf("Team %s does not exist.%n", teamToRate);
                        break;
                    }

                    System.out.println(teams.get(teamToRate).toString());
                    break;

            }
        }
    }
}
