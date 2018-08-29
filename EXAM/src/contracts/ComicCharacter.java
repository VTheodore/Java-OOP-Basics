package contracts;

import java.util.List;

public interface ComicCharacter {

    String getName();

    void boostCharacter(int energy, double health, double intelligence);

    int getEnergy();

    double getHealth();

    double getIntelligence();

    double attack();

    double getSpecial();

    String useSuperPowers();

    void addSuperPower(SuperPower superPower);

    List<SuperPower> superPowers();

    boolean isInArena();

    void startArena();

    void endArena();
}
