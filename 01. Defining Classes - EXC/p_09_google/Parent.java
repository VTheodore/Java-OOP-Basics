package L01_DefiningClassesEXC.p_09_google;

public class Parent {
    private String parentName;

    private String birthDate;

    public Parent(String parentName, String birthDate) {
        this.parentName = parentName;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.parentName, this.birthDate);
    }
}
