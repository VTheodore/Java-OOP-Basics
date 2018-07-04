package races;

import cars.Car;

import java.util.ArrayList;
import java.util.List;

public class CircuitRace extends Race {
    private int laps;

    public CircuitRace(int length, String route, int prizePool, int laps) {
        super(length, route, prizePool);
        this.laps = laps;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        List<Car> cars = new ArrayList<>();

        super.getParticipants().forEach(c -> {
            c.decreaseDurability(super.getLength() * super.getLength() * this.laps);
        });
        super.getParticipants().stream().sorted((c1, c2) -> Integer.compare(c2.getOverallPerformance(), c1.getOverallPerformance()))
                .limit(4)
                .forEach(cars::add);

        sb.append(super.getRoute()).append(" - ").append(super.getLength() * this.laps).append(System.lineSeparator());
        int count = 1;
        for (Car car : cars) {
            //car.decreaseDurability((super.getLength() * super.getLength()) * this.laps);

            sb.append(count).append(". ").append(car.getBrand()).append(" ").append(car.getModel()).append(" ")
                    .append(car.getOverallPerformance()).append("PP - $");

            if (count == 1){
                sb.append((super.getPrizePool() * 40 )/ 100);
            }else if (count == 2){
                sb.append((super.getPrizePool() * 30) / 100);
            }else if (count == 3){
                sb.append((super.getPrizePool() * 20) / 100);
            }else {
                sb.append((super.getPrizePool() * 10)/ 100);
            }

            sb.append(System.lineSeparator());
            count++;
        }

        return sb.toString();
    }
}
