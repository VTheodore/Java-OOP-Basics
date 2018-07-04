import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine {
    public static final String END_COMMAND = "Cops";

    public void start() throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));

        CarManager carManager = new CarManager();
        while (true){
            String[] tokens = in.readLine().split("\\s+");
            if (tokens[0].equals(END_COMMAND))break;

            String command = tokens[0];

            switch (command){
                case "register":
                    int registerId = Integer.parseInt(tokens[1]);
                    String type = tokens[2];
                    String brand = tokens[3];
                    String model = tokens[4];
                    int yearOfProductiong = Integer.parseInt(tokens[5]);
                    int horsePower = Integer.parseInt(tokens[6]);
                    int acceleration = Integer.parseInt(tokens[7]);
                    int suspension = Integer.parseInt(tokens[8]);
                    int durability = Integer.parseInt(tokens[9]);

                    carManager.register(registerId, type, brand, model, yearOfProductiong, horsePower, acceleration, suspension, durability);
                    break;
                case "check":
                    int checkId = Integer.parseInt(tokens[1]);

                    System.out.println(carManager.check(checkId));
                    break;
                case "open":
                    int openId = Integer.parseInt(tokens[1]);
                    String raceType = tokens[2];
                    int length = Integer.parseInt(tokens[3]);
                    String route = tokens[4];
                    int prizePool = Integer.parseInt(tokens[5]);

                    if (tokens.length == 7){
                        int additionalParameter = Integer.parseInt(tokens[6]);
                        carManager.open(openId, raceType, length, route, prizePool, additionalParameter);
                    }

                    carManager.open(openId, raceType, length, route, prizePool);
                    break;
                case "participate":
                    int carId = Integer.parseInt(tokens[1]);
                    int raceId = Integer.parseInt(tokens[2]);

                    carManager.participate(carId, raceId);
                    break;
                case "start":
                    int startId = Integer.parseInt(tokens[1]);

                    System.out.print(carManager.start(startId));
                    break;
                case "park":
                    int parkId = Integer.parseInt(tokens[1]);

                    carManager.park(parkId);
                    break;
                case "unpark":
                    int unparkId = Integer.parseInt(tokens[1]);

                    carManager.unpark(unparkId);
                    break;
                case "tune":
                    int tuneIndex = Integer.parseInt(tokens[1]);
                    String addOn = tokens[2];

                    carManager.tune(tuneIndex, addOn);
                    break;
            }
        }
    }
}
