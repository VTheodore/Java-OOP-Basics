package DefiningClasses.p_03_test_client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        var accounts = new HashMap<Integer, BankAccount>();
        while (true){
            String[] commandArgs = in.readLine().split(" ");
            if ("End".equals(commandArgs[0]))break;

            int id = Integer.parseInt(commandArgs[1]);

            switch (commandArgs[0]){
                case "Create":
                    executeCreateCommand(accounts, id);
                    break;
                case "Deposit":
                    executeDepositCommand(accounts, commandArgs, id);
                    break;
                case "Withdraw":
                    executeWithdrawCommand(accounts, commandArgs, id);
                    break;
                case "Print":
                    executePrintCommand(accounts, id);
                    break;
            }
        }
    }

    private static void executePrintCommand(HashMap<Integer, BankAccount> accounts, int id) {
        if (!accounts.containsKey(id)){
            System.out.println("Account does not exist");
        }else{
            System.out.println(accounts.get(id));
        }
    }

    private static void executeWithdrawCommand(HashMap<Integer, BankAccount> accounts, String[] commandArgs, int id) {
        if (!accounts.containsKey(id)){
            System.out.println("Account does not exist");
        }else {
            double withdrawAmount = Double.parseDouble(commandArgs[2]);

            try{
                accounts.get(id).withdraw(withdrawAmount);
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    private static void executeDepositCommand(HashMap<Integer, BankAccount> accounts, String[] commandArgs, int id) {
        if (!accounts.containsKey(id)){
            System.out.println("Account does not exist");
        }else {
            double depositAmount = Double.parseDouble(commandArgs[2]);

            accounts.get(id).deposit(depositAmount);
        }
    }

    private static void executeCreateCommand(HashMap<Integer, BankAccount> accounts, int id) {
        if (accounts.containsKey(id)){
            System.out.println("Account already exists");
        }else{
            BankAccount acc = new BankAccount();

            acc.setId(id);

            accounts.put(id, acc);
        }
    }
}
