/**
 * Создал Андрей Антонов 27.07.2023 9:03
 **/
package generic.Shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeContainer<T> {

    private final List<T> shapeList = new ArrayList<>();

    Rectangle rectangle = new Rectangle();
    Circle circle = new Circle();

    /**
     * метод, который добавляет геометрическую фигуру в контейнер.
     */
    void addShape(final T Shape) {
        shapeList.add(Shape);
    }

    public double getTotalPerimeter() {
        double totalPerimeter = 0.0;
        for (T shape : this.shapeList) {
            if (shape.getClass().getName().equals("generic.Shape.Rectangle")) {
                rectangle = (Rectangle) shape;
                totalPerimeter += rectangle.getPerimeter();
            }
            if (shape.getClass().getName().equals("generic.Shape.Circle")) {
                circle = (Circle) shape;
                totalPerimeter += circle.getPerimeter();
            }
        }
        return (double) totalPerimeter;
    }

    /**
     * метод, который возвращает общую площадь всех геометрических фигур в контейнере.
     */
    double getTotalArea() {
        double totalArea = 0.0;
        for (T shape : this.shapeList) {
            if (shape.getClass().getName().equals("generic.Shape.Rectangle")) {
                rectangle = (Rectangle) shape;
                totalArea += rectangle.getArea();
            }
            if (shape.getClass().getName().equals("generic.Shape.Circle")) {
                circle = (Circle) shape;
                totalArea += circle.getArea();
            }
        }
        return (double) totalArea;
    }
}
