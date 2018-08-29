package entities.characters.antiHeros;

public class Titan extends AntiHero {
    public Titan(String name, int energy, double health, double intelligence, double evilness) {
        super(name, energy, health, intelligence, evilness);
    }

    @Override
    public double attack() {
        return (super.getEnergy() + super.getIntelligence() + super.getSpecial()) * 3;
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
                .append("###Evilness: ").append(String.format("%.2f", super.getSpecial()))
                .append(System.lineSeparator())
                .append("####Titan Attack Power: ").append(String.format("%.2f",this.attack()));

        return sb.toString();
    }
}
