package factories;

import contracts.Arena;
import io.ConsoleWriter;

public class ArenaFactory {
    private ConsoleWriter writer;

    public ArenaFactory() {
        this.writer = new ConsoleWriter();
    }

    public Arena createArena(String name, int capacity){
        Arena arena = null;

        try {
            arena = new entities.arenas.Arena(name, capacity);
        }catch (IllegalArgumentException iae){
            this.writer.writeLine(iae.getMessage());
        }

        return arena;
    }
}
