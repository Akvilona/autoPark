/**
 * Создал Андрей Антонов 27.07.2023 11:22
 **/

package generic.shape;

//abstract class -> extends. Только 1 наследник
//interface -> implements. Много наследников

public class Circle extends Shape {
    private final int radius;

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
