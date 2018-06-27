package L03_Inheritance.p_05_random_array_list;

public class Main {
    public static void main(String[] args) {
        RandomArrayList ral = new RandomArrayList();

        ral.add(5);
        ral.add(15);
        ral.add(654);
        ral.add(6);

        System.out.println(ral.getRandomElement());
    }
}
