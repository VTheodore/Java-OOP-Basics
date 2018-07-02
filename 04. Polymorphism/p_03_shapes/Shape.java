package L04_Polymorphism.p_03_shapes;

public abstract class Shape {
    private double perimeter;

    private double area;

    protected abstract void calculatePerimeter();

    protected abstract void calculateArea();

    public double getPerimeter() {
        return this.perimeter;
    }

    protected void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getArea() {
        return this.area;
    }

    protected void setArea(double area) {
        this.area = area;
    }
}
