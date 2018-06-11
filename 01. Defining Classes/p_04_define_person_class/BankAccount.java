package DefiningClasses.p_04_define_person_class;

public class BankAccount {
    private int id;

    private double balance;

    public BankAccount(){

    }

    public BankAccount(int id, double balance){
        this.id = id;
        this.balance = balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount){
        this.balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        if (amount > this.balance){
            throw new Exception("Insufficient balance");
        }

        this.balance -= amount;
    }

    @Override
    public String toString(){
        return String.format("Account ID%d, balance %.2f", this.id, getBalance());
    }
}
