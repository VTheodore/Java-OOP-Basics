package p_03_car_shop_extended;

import java.io.Serializable;

public class Audi implements Rentable, Serializable {
    private String model;

    private String color;

    private Integer horsePower;

    private String countryProduced;

    private Integer minRentDay;

    private Double pricePerDay;

    public Audi(String model, String color, Integer horsePower, String countryProduced, Integer minRentDays, Double pricePerDay) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
        this.minRentDay = minRentDays;
        this.pricePerDay = pricePerDay;
    }

    public String getCountryProduced() {
        return this.countryProduced;
    }

    @Override
    public Integer getMinRentDay() {
        return this.minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsePower;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires", this.getModel(), this.getCountryProduced(), this.TIRES);
    }
}
