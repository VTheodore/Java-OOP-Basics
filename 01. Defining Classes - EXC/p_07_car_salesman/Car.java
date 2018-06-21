package L01_DefiningClassesEXC.p_07_car_salesman;

public class Car {
    public static final int DEFAULT_WEIGHT = 0;

    public static final String DEFAULT_COLOR = "n/a";

    private String model;

    private Engine engine;

    private int weight;

    private String color;

    public Car(String model, Engine engine) {
        this(model, engine, DEFAULT_WEIGHT, DEFAULT_COLOR);
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine, weight, DEFAULT_COLOR);
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine, DEFAULT_WEIGHT, color);
    }

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("%s:%n", this.model));
        res.append(this.engine.toString());

        if (this.weight == 0){
            res.append("  Weight: n/a").append(System.lineSeparator());
        }else {
            res.append(String.format("  Weight: %d%n", this.weight));
        }

        res.append(String.format("  Color: %s", this.color));

        return res.toString();
    }
}
