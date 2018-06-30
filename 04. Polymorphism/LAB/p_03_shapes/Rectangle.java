package L04_Polymorphism.p_03_shapes;

public class Rectangle extends Shape {
    private double height;

    private double width;

    public Rectangle(double height, double width) {
        this.setHeight(height);
        this.setWidth(width);
        this.calculatePerimeter();
        this.calculateArea();
    }

    private void setHeight(double height) {
        this.height = height;
    }

    private void setWidth(double width) {
        this.width = width;
    }

    private double getHeight() {
        return this.height;
    }

    private double getWidth() {
        return this.width;
    }

    @Override
    protected void calculatePerimeter() {
        super.setPerimeter((2 * this.getWidth()) + (2 * this.getHeight()));
    }

    @Override
    protected void calculateArea() {
        super.setArea(this.getWidth() * this.getHeight());
    }
}
