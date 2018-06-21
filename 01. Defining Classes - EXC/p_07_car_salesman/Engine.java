package L01_DefiningClassesEXC.p_07_car_salesman;

public class Engine {
    public static final int DEFAULT_DISPLACEMENT = 0;

    public static final String DEFAULT_EFFICIENCY = "n/a";

    private String model;

    private int power;

    private int displacement;

    private String efficiency;

    public Engine(String model, int power) {
        this(model, power, DEFAULT_DISPLACEMENT, DEFAULT_EFFICIENCY);
    }

    public Engine(String model, int power, int displacement) {
        this(model, power, displacement, DEFAULT_EFFICIENCY);
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power, DEFAULT_DISPLACEMENT, efficiency);
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

        res.append(String.format("  %s:%n", this.model));
        res.append(String.format("    Power: %d%n", this.power));

        if (this.displacement == 0){
            res.append("    Displacement: n/a").append(System.lineSeparator());
        }else {
            res.append(String.format("    Displacement: %d%n", this.displacement));
        }

        res.append(String.format("    Efficiency: %s%n", this.efficiency));

        return res.toString();
    }
}
