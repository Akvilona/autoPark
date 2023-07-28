/**
 * Создал Андрей Антонов 27.07.2023 11:09
 **/
package generic.shape;

public final class Main {
    private Main() {
    }

    public static void main(final String[] args) {
        ShapeContainer<Rectangle> rectangleContainer = new ShapeContainer<>();


        final int width1 = 5;
        final int width2 = 3;
        final int height1 = 1;
        final int height2 = 7;
        rectangleContainer.addShape(new Rectangle(width1, height1));
        rectangleContainer.addShape(new Rectangle(width2, height2));

        double totalRectangleArea = rectangleContainer.getTotalArea();
        double totalRectanglePerimeter = rectangleContainer.getTotalPerimeter();

        System.out.println("Total area of rectangles: " + totalRectangleArea); // Выведет: Общая площадь прямоугольников: 71.0
        System.out.println("Common perimeter of rectangles: " + totalRectanglePerimeter); // Выведет: Общий периметр прямоугольников: 56.0

        ShapeContainer<Circle> circleContainer = new ShapeContainer<>();
        circleContainer.addShape(new Circle(width1));
        circleContainer.addShape(new Circle(width2));

        double totalCircleArea = circleContainer.getTotalArea();
        double totalCirclePerimeter = circleContainer.getTotalPerimeter();

        System.out.println("Total area of circles: " + totalCircleArea); // Выведет: Общая площадь окружностей: 68.53981633974483
        System.out.println("Total perimeter of the circles: " + totalCirclePerimeter); // Выведет: Общий периметр окружностей: 31.41592653589793
    }
}
