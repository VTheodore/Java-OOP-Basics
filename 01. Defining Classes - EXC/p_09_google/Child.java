package L01_DefiningClassesEXC.p_09_google;

public class Child {
    private String childName;

    private String childBirthDate;

    public Child(String childName, String childBirthDate) {
        this.childName = childName;
        this.childBirthDate = childBirthDate;
    }

    @Override
    public String toString() {
        return String.format("%s %s",this.childName, this.childBirthDate);
    }
}
