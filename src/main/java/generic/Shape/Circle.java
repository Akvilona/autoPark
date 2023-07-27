/**
 * Создал Андрей Антонов 27.07.2023 11:22
 **/
package generic.Shape;

public class Circle implements Shape {
    private int radius;

    public Circle() {

    }

    public Circle(final int radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    @Override
    public double getPerimeter() {
        return Math.PI * (2 * radius);
    }
}
