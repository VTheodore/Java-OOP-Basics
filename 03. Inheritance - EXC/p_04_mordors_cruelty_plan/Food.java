package p_04_mordors_cruelty_plan;

public class Food {
    private String name;

    private int points;

    public Food(String name) {
        this.name = name;
    }

    public int getPoints(){
        switch (this.name.toLowerCase()){
            case "cram":
                this.points = 2;
                break;
            case "lembas":
                this.points = 3;
                break;
            case "apple":
                this.points = 1;
                break;
            case "melon":
                this.points = 1;
                break;
            case "honeycake":
                this.points = 5;
                break;
            case "mushrooms":
                this.points = -10;
                break;
                default:
                    this.points = -1;
                    break;
        }

        return this.points;
    }
}
