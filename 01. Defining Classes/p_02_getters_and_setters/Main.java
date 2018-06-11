package DefiningClasses.p_02_getters_and_setters;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        account.setId(10);
        account.deposit(2000.0);
        account.withdraw(10);
        account.deposit(158.76);
        account.withdraw(2100.17);

        System.out.printf("Account %s, balance %.2f", account, account.getBalance());
    }
}
