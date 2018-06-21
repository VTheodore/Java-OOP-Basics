package L01_DefiningClassesEXC.p_06_raw_data;

public class Car {
    private String model;

    private Engine engine;

    private Cargo cargo;

    private Tire tires;

    public Car(String model, Engine engine, Cargo cargo, Tire tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public Tire getTires() {
        return this.tires;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public String getModel() {
        return this.model;
    }
}
