package entities.characters.heros;


public class DCHero extends Hero {
    public DCHero(String name, int energy, double health, double intelligence, double heroism) {
        super(name, energy, health, intelligence, heroism);
    }

    @Override
    public double attack() {
        return super.getEnergy() / 1.5 + super.getSpecial() + super.getIntelligence();
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        sb.append("#Name: ").append(super.getName())
                .append(System.lineSeparator())
                .append("##Health: ").append(String.format("%.2f",super.getHealth())).append("// ")
                .append("Energy: ").append(super.getEnergy()).append("// ")
                .append("Intelligence: ").append(String.format("%.2f", super.getIntelligence()))
                .append(System.lineSeparator())
                .append("###Heroism: ").append(String.format("%.2f", super.getSpecial()))
                .append(System.lineSeparator())
                .append("####DC Attack Power: ").append(String.format("%.2f",this.attack()));

        return sb.toString();
    }
}
