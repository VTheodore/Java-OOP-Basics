package races;

import cars.Car;

import java.util.ArrayList;
import java.util.List;

public abstract class Race {
    private int length;

    private String route;

    private int prizePool;

    private List<Car> participants;

    private String type;

    public Race(int length, String route, int prizePool) {
        this.setLength(length);
        this.setRoute(route);
        this.setPrizePool(prizePool);
        this.type = "OPENED";
        this.participants = new ArrayList<>();
    }

    private void setLength(int length) {
        this.length = length;
    }

    private void setRoute(String route) {
        this.route = route;
    }

    private void setPrizePool(int prizePool) {
        this.prizePool = prizePool;
    }

    public List<Car> getParticipants() {
        return this.participants;
    }

    protected int getPrizePool() {
        return this.prizePool;
    }

    public String getRoute() {
        return this.route;
    }

    public int getLength() {
        return this.length;
    }

    public void addParticipant(Car car){
        this.participants.add(car);
    }

    public void closeRace(){
        this.type = "CLOSED";
    }

    public String getType() {
        return this.type;
    }
}
