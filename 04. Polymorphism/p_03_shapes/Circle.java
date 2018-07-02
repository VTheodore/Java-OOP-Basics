package L04_Polymorphism.p_03_shapes;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.setRadius(radius);
        this.calculateArea();
        this.calculatePerimeter();
    }

    private void setRadius(double radius) {
        this.radius = radius;
    }

    private double getRadius() {
        return this.radius;
    }

    @Override
    protected void calculatePerimeter() {
        super.setPerimeter(2 * Math.PI * this.getRadius());
    }

    @Override
    protected void calculateArea() {
        super.setArea(Math.PI * this.radius * this.getRadius());
    }
}
