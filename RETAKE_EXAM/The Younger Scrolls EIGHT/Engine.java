import interfaces.Runnable;
import io.InputReader;
import io.OutputWriter;
import manager.Manager;

import java.io.IOException;

public class Engine implements Runnable {
    private static final String CREATE_PROVINCE_COMMAND = "CREATE_PROVINCE:";

    private static final String SELECT_COMMAND = "SELECT:";

    private static final String ADD_HERO_COMMAND = "ADD_HERO:";

    private static final String ADD_GUILD_COMMAND = "ADD_GUILD:";

    private static final String DETAILS_COMMAND = "DETAILS:";

    private static final String REMOVE_COMMAND = "REMOVE:";

    private static final String FIGHT_COMMAND = "FIGHT:";

    private static final String END_COMMAND = "END";


    private InputReader reader;

    private OutputWriter writer;

    private Manager manager;

    public Engine(InputReader reader, OutputWriter writer, Manager manager) {
        this.reader = reader;
        this.writer = writer;
        this.manager = manager;
    }

    @Override
    public void run() throws IOException {
        String line;

        while (true){
            String[] cmdArgs = reader.readLine().split("\\s+");

            this.executeCommands(cmdArgs);

            if ("END".equals(cmdArgs[0])){
                break;
            }
        }
    }

    private void executeCommands(String[] cmdArgs) {
        switch (cmdArgs[0]){
            case CREATE_PROVINCE_COMMAND:
                writer.println(this.manager.createProvince(cmdArgs[1]));
                writer.println("---");
                break;
            case SELECT_COMMAND:
                writer.println(this.manager.select(cmdArgs[1]));
                writer.println("---");
                break;
            case ADD_HERO_COMMAND:
                writer.println(this.manager.addHero(cmdArgs[1], cmdArgs[2], cmdArgs[3], Integer.parseInt(cmdArgs[4]),Integer.parseInt(cmdArgs[5]), Integer.parseInt(cmdArgs[6])));
                writer.println("---");
                break;
            case ADD_GUILD_COMMAND:
                writer.println(this.manager.addGuild(cmdArgs[1]));
                writer.println("---");
                break;
            case DETAILS_COMMAND:
                if (cmdArgs.length == 2){
                    writer.print(this.manager.details(cmdArgs[1]));
                    writer.println("---");
                }else {
                    writer.print(this.manager.details(cmdArgs[1], cmdArgs[2]));
                    writer.println("---");
                }
                break;
            case REMOVE_COMMAND:
                if (cmdArgs.length == 2){
                    writer.println(this.manager.remove(cmdArgs[1]));
                    writer.println("---");
                }else{
                    writer.println(this.manager.remove(cmdArgs[1], cmdArgs[2]));
                    writer.println("---");
                }
                break;
            case FIGHT_COMMAND:
                writer.println(this.manager.fight(cmdArgs[1], cmdArgs[2], cmdArgs[3], cmdArgs[4]));
                writer.println("---");
                break;
            case END_COMMAND:
                writer.print(this.manager.end());
                break;
        }


    }
}
