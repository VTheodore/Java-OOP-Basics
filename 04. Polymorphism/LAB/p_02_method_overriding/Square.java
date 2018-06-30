package L04_Polymorphism.p_02_method_overriding;

public class Square extends Rectangle {
    public Square(Double sideA) {
        super(sideA);
    }

    @Override
    public Double area() {
        return super.getSideA() * super.getSideA();
    }
}
