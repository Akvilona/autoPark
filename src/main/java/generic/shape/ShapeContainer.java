/**
 * Создал Андрей Антонов 27.07.2023 9:03
 **/

package generic.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeContainer<T extends Shape> {

    private final List<T> shapeList = new ArrayList<>();

    void addShape(final T shape) {
        shapeList.add(shape);
    }

    public double getTotalPerimeter() {
        double totalPerimeter = 0.0;
        for (int i = 0; i < shapeList.size(); i++) {
            T t = shapeList.get(i);
            totalPerimeter += t.getPerimeter();
        }

        return totalPerimeter;
    }

    double getTotalArea() {
        double totalArea = 0.0;
        for (T shape : this.shapeList) {
            totalArea += shape.getArea();
        }
        return totalArea;
    }
}
