package L02_EncapsulationEXC.p_06_football_team_generator;

public class Player {
    private static final String NAME_ERR_MSG = "A name should not be empty.";

    private static final String STAT_ERR_MSG = " should be between 0 and 100.";

    private String name;

    private double endurance;

    private double sprint;

    private double dribble;

    private double passing;

    private double shooting;

    public Player(String name, double endurance, double sprint, double dribble, double passing, double shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    private void setName(String name) {
        if (name.equals(" ") || name.equals("") || name == null){
            throw new IllegalArgumentException(NAME_ERR_MSG);
        }
        this.name = name;
    }

    private void setEndurance(double endurance) {
        if (endurance < 0 || endurance > 100){
            throw new IllegalArgumentException("Endurance" + STAT_ERR_MSG);
        }

        this.endurance = endurance;
    }

    private void setSprint(double sprint) {
        if (sprint < 0 || sprint > 100){
            throw new IllegalArgumentException("Sprint" + STAT_ERR_MSG);
        }

        this.sprint = sprint;
    }

    private void setDribble(double dribble) {
        if (dribble < 0 || dribble > 100){
            throw new IllegalArgumentException("Dribble" + STAT_ERR_MSG);
        }

        this.dribble = dribble;
    }

    private void setPassing(double passing) {
        if (passing < 0 || passing > 100){
            throw new IllegalArgumentException("Passing" + STAT_ERR_MSG);
        }

        this.passing = passing;
    }

    private void setShooting(double shooting) {
        if (shooting < 0 || shooting > 100){
            throw new IllegalArgumentException("Shooting" + STAT_ERR_MSG);
        }

        this.shooting = shooting;
    }


    public String getName() {
        return this.name;
    }

    public int getTotalRating() {
        return (int) Math.round((this.endurance + this.shooting + this.sprint + this.dribble + this.passing) / 5.0);
    }
}
