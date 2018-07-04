package races;

import cars.Car;

public class TimeLimitRace extends Race {
    private int goldTime;

    public TimeLimitRace(int length, String route, int prizePool, int goldTime) {
        super(length, route, prizePool);
        this.goldTime = goldTime;
    }

    @Override
    public String toString() {
        Car car = super.getParticipants().get(0);

        int time = car.getTimePerformance() * super.getLength();
        int prize;
        String earnedTime;


        if (time <= this.goldTime){
            prize = super.getPrizePool();
            earnedTime = "Gold";
        } else if (time <= this.goldTime + 15) {
            prize = super.getPrizePool() / 2;
            earnedTime = "Silver";
        }else {
            prize = (super.getPrizePool() * 30) / 100;
            earnedTime = "Bronze";
        }


        final StringBuilder sb = new StringBuilder();
        sb.append(super.getRoute()).append(" - ").append(super.getLength())
                .append(System.lineSeparator())
                .append(car.getBrand()).append(" ").append(car.getModel()).append(" - ").append(time).append(" s.")
                .append(System.lineSeparator())
                .append(earnedTime).append(" Time, $").append(prize).append(".")
                .append(System.lineSeparator());

        return sb.toString();
    }
}
