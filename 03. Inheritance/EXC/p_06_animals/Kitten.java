package p_06_animals;

public class Kitten extends Cat {
    public Kitten(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected void setGender(String gender) {
        if (!"female".equals(gender.toLowerCase())){
            throw new IllegalArgumentException("Invalid input!");
        }

        super.setGender(gender);
    }

    @Override
    public String produceSound() {
        return "Miau";
    }
}
