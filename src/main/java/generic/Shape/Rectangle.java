/**
 * Создал Андрей Антонов 27.07.2023 11:11
 **/
package generic.Shape;

public class Rectangle implements Shape {
    private int width;
    private int height;

    public Rectangle() {
    }

    public Rectangle(final int width, final int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return (double) this.width * this.height;
    }

    @Override
    public double getPerimeter() {
        return (double) (this.width + this.height) * 2;
    }
}
