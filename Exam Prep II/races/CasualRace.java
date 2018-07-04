package races;

import cars.Car;

import java.util.ArrayList;
import java.util.List;

public class CasualRace extends Race {
    public CasualRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        List<Car> cars = new ArrayList<>();

        super.getParticipants().stream().sorted((c1, c2) -> Integer.compare(c2.getOverallPerformance(), c1.getOverallPerformance()))
                .limit(3)
                .forEach(cars::add);

        sb.append(super.getRoute()).append(" - ").append(super.getLength()).append(System.lineSeparator());
        int count = 1;
        for (Car car : cars) {
            sb.append(count).append(". ").append(car.getBrand()).append(" ").append(car.getModel()).append(" ")
                    .append(car.getOverallPerformance()).append("PP - $");

            if (count == 1){
                sb.append((super.getPrizePool() * 50 )/ 100);
            }else if (count == 2){
                sb.append((super.getPrizePool() * 30) / 100);
            }else {
                sb.append((super.getPrizePool() * 20) / 100);
            }

            sb.append(System.lineSeparator());
            count++;
        }

        return sb.toString();
    }
}
