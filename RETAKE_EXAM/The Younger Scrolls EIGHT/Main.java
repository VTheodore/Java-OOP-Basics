import io.ConsoleReader;
import io.ConsoleWriter;
import io.InputReader;
import io.OutputWriter;
import manager.Manager;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        InputReader reader = new ConsoleReader();
        OutputWriter writer = new ConsoleWriter();
        Manager manager = new Manager();

        Engine engine = new Engine(reader, writer, manager);

        engine.run();
    }
}
