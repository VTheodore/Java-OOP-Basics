package entities.powers;

import contracts.SuperPower;
import utils.Constants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Power implements SuperPower {
    private String name;

    private double powerPoints;

    public Power(String name, double powerPoints) {
        this.setName(name);
        this.setPowerPoints(powerPoints);
    }

    private void setName(String name) {
        Pattern pattern = Pattern.compile("^@[A-Za-z_]{3,}@$");
        Matcher matcher = pattern.matcher(name);

        if (!matcher.find()){
            throw new IllegalArgumentException(Constants.SUPERPOWER_NAME_EXCEPTION);
        }

        this.name = name;
    }

    private void setPowerPoints(double powerPoints) {
        if (powerPoints < 0){
            throw new IllegalArgumentException(Constants.POWER_POINTS_EXCEPTION);
        }

        this.powerPoints = powerPoints;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPowerPoints() {
        return this.powerPoints + this.getName().length() / 2;
    }
}
