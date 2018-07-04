import cars.Car;
import cars.PerformanceCar;
import cars.ShowCar;
import races.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class CarManager {
    private Map<Integer, Car> cars;
    private Map<Integer, Race> races;
    private Garage garage;

    public CarManager() {
        this.cars = new LinkedHashMap<>();
        this.races = new LinkedHashMap<>();
        this.garage = new Garage();
    }

    public void register(int id, String type, String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability){
        Car car = null;

        switch (type){
            case "Performance":
                car = new PerformanceCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
                break;
            case "Show":
                car = new ShowCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
                break;
        }

        this.cars.putIfAbsent(id, car);
    }

    public String check(int id){
        return this.cars.get(id).toString();
    }

    public void open(int id, String type, int length, String route, int prizePool){
        Race race = null;

        switch (type){
            case "Casual":
                race = new CasualRace(length, route, prizePool);
                break;
            case "Drag":
                race = new DragRace(length, route, prizePool);
                break;
            case "Drift":
                race = new DriftRace(length, route, prizePool);
                break;
        }

        this.races.putIfAbsent(id, race);
    }

    public void open(int id, String type, int length, String route, int prizePool, int additionalParameter){
        Race race = null;

        switch (type){
            case "TimeLimit":
                race = new TimeLimitRace(length, route, prizePool, additionalParameter);
                break;
            case "Circuit":
                race = new CircuitRace(length, route, prizePool, additionalParameter);
                break;
        }

        this.races.putIfAbsent(id, race);
    }

    public void participate(int carId, int raceId){
        Car car = this.cars.get(carId);
        Race race = this.races.get(raceId);

        if (!this.garage.getParkedCars().contains(car)){
            if (race.getType().equals("OPENED")){
                if (race.getClass().getSimpleName().equals("TimeLimitRace")){
                    if (race.getParticipants().size() == 0){
                       race.addParticipant(car);
                    }
                }else {
                    car.participateInRace();
                    race.addParticipant(car);
                }
            }
        }
    }

    public String start(int id){
        Race race = this.races.get(id);

        if (race.getParticipants().size() == 0) {
            return "Cannot start the race with zero participants.\n";
        }

        if (race.getType().equals("CLOSED"))return "";

        String res = race.toString();

        for (Car car : race.getParticipants()) {
            car.endRace();
        }

        race.getParticipants().clear();
        race.closeRace();
        return res;
    }

    public void park(int id){
        Car car = this.cars.get(id);

        if (!car.isInRace()){
            this.garage.addCar(car);
        }
    }

    public void unpark(int id){
        Car car = this.cars.get(id);

        if (this.garage.getParkedCars().contains(car)){
            this.garage.removeCar(car);
        }
    }

    public void tune(int tuneIndex, String addOn){
        for (Car car : this.garage.getParkedCars()) {
            car.increaseHorsepower(tuneIndex);
            car.increaseSuspension(tuneIndex);

            if (car.getClass().getSimpleName().equals("PerformanceCar")){
                ((PerformanceCar) car).addAddOn(addOn   );
            }else {
                ((ShowCar) car).addStars(tuneIndex);
            }
        }
    }
}
