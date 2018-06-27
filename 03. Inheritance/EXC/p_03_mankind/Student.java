package L03_InheritanceEXC.p_03_mankind;

public class Student extends Human {
    private String facultyNumber;

    public Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }

    private String getFacultyNumber() {
        return this.facultyNumber;
    }

    private void setFacultyNumber(String facultyNumber) {
        if (facultyNumber.length() < 5 || facultyNumber.length() > 10){
            throw new IllegalArgumentException("Invalid faculty number!");
        }

        this.facultyNumber = facultyNumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        sb.append("First Name: ").append(super.getFirstName())
                .append(System.lineSeparator())
                .append("Last Name: ").append(super.getLastName())
                .append(System.lineSeparator())
                .append("Faculty number: ").append(this.getFacultyNumber())
                .append(System.lineSeparator());

        return sb.toString();
    }
}
