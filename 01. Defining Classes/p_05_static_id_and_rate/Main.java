package DefiningClasses.p_05_static_id_and_rate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        var accounts = new HashMap<Integer, BankAccount>();

        while (true){
            String[] commandArgs = in.readLine().split(" ");
            String command = commandArgs[0];

            if ("End".equals(command))break;

            switch (command){
                case "Create":
                    executeCommandCreate(accounts);
                    break;
                case "Deposit":
                    executeDepositCommand(accounts, commandArgs);
                    break;
                case "GetInterest":
                    executeGetInterestCommand(accounts, commandArgs);
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(commandArgs[1]);
                    BankAccount.setInterestRate(interest);
                    break;
            }
        }
    }

    private static void executeGetInterestCommand(HashMap<Integer, BankAccount> accounts, String[] commandArgs) {
        int id = Integer.parseInt(commandArgs[1]);
        int years = Integer.parseInt(commandArgs[2]);

        if (accounts.containsKey(id)){
            System.out.println(String.format("%.2f", accounts.get(id).getInterest(years)));
        }else {
            System.out.println("Account does not exist");
        }
    }

    private static void executeDepositCommand(HashMap<Integer, BankAccount> accounts, String[] commandArgs) {
        int id = Integer.parseInt(commandArgs[1]);
        double depositAmount = Double.parseDouble(commandArgs[2]);

        if (accounts.containsKey(id)){
            accounts.get(id).deposit(depositAmount);

            DecimalFormat df = new DecimalFormat("#.##");
            System.out.printf("Deposited %s to %s%n", df.format(depositAmount), accounts.get(id));
        }else {
            System.out.println("Account does not exist");
        }
    }

    private static void executeCommandCreate(HashMap<Integer, BankAccount> accounts) {
        BankAccount ba = new BankAccount();
        accounts.putIfAbsent(ba.getId(), ba);

        System.out.printf("Account %s created%n", ba);
    }
}
