package factories;

import contracts.SuperPower;
import entities.powers.Power;
import io.ConsoleWriter;

public class SuperPowerFactory {
    private ConsoleWriter writer;

    public SuperPowerFactory() {
        this.writer = new ConsoleWriter();
    }

    public SuperPower createSuperPower(String name, double points){
        SuperPower superPower = null;

        try {
            superPower = new Power(name, points);
        }catch (IllegalArgumentException iae){
            this.writer.writeLine(iae.getMessage());
        }

        return superPower;
    }
}
