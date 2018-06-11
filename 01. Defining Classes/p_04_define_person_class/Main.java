package DefiningClasses.p_04_define_person_class;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Stamat", 21);
        BankAccount ba = new BankAccount(1, 158.72);

        person.addAccount(ba);
    }
}
