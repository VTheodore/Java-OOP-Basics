package L04_Polymorphism.p_01_overload_method;

public class Main {
    public static void main(String[] args) {
        MathOperation math = new MathOperation();

        System.out.println(math.add(2, 3));
        System.out.println(math.add(3, 3, 4));
        System.out.println(math.add(2, 3, 69, 7));
    }
}
