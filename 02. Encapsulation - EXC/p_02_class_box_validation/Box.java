package L02_EncapsulationEXC.p_02_class_box_validation;

public class Box {
    private static final double MIN_NUM = 0;

    private double length;

    private double width;

    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        if (length <= MIN_NUM){
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }

        this.length = length;
    }

    private void setWidth(double width) {
        if (width <= MIN_NUM){
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }

        this.width = width;
    }

    private void setHeight(double height) {
        if (height <= MIN_NUM){
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }

        this.height = height;
    }

    public double getSurfaceArea(){
        return 2 * this.width * this.length + 2 * this.length * this.height + 2 * this.width * this.height;
    }

    public double getLateralArea(){
        return 2 * this.length * this.height + 2 * this.width * this.height;
    }

    public double getVolume(){
        return this.length * this.width * this.height;
    }
}
