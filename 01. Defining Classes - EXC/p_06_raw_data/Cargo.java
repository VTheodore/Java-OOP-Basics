package L01_DefiningClassesEXC.p_06_raw_data;

public class Cargo {
    private String cargoType;

    private int cargoWeigth;

    public Cargo(String cargoType, int cargoWeight) {
        this.cargoType = cargoType;
        this.cargoWeigth = cargoWeight;
    }

    public String getCargoType() {
        return this.cargoType;
    }
}
