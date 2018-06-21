package L02_EncapsulationEXC.p_03_animal_farm;

import java.text.DecimalFormat;

public class Chicken {

    private static final int MIN_NAME_LENGTH = 1;

    private static final int MIN_AGE = 1;

    private static final int MAX_AGE = 15;

    private static final String NAME_ERROR_MSG = "Name cannot be empty.";

    private static final String AGE_ERROR_MSG = "Age should be between 0 and 15.";

    private String name;

    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private void setName(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.equals(" ")){
            throw new IllegalArgumentException(NAME_ERROR_MSG);
        }

        this.name = name;
    }

    private void setAge(int age) {
        if (age < MIN_AGE || age > MAX_AGE){
            throw new IllegalArgumentException(AGE_ERROR_MSG);
        }

        this.age = age;
    }

    private double getEggsPerDay(){
        if (this.age < 6){
            return 2;
        }else if (this.age < 12){
            return 1;
        }else {
            return 0.75;
        }
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("Chicken %s (age %d) can produce %s eggs per day.", this.name, this.age, df.format(this.getEggsPerDay()));
    }
}
