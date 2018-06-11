package DefiningClasses.p01_define_bank_account;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        account.id = 1;
        account.balance = 500.50;

        System.out.printf("Account ID%d, balance %.2f", account.id, account.balance);
    }
}
