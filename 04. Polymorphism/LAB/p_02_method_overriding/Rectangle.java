package L04_Polymorphism.p_02_method_overriding;

public class Rectangle {
    private Double sideA;

    private Double sideB;

    public Rectangle(Double sideA) {
        this.sideA = sideA;
    }

    public Rectangle(Double sideA, Double sideB) {
        this(sideA);
        this.sideB = sideB;
    }

    public Double area() {
        return this.sideA * this.sideB;
    }

    protected Double getSideA() {
        return this.sideA;
    }
}
