/**
 * Создал Андрей Антонов 27.07.2023 9:21
 **/
package generic.shape;

public abstract class Shape {
    protected String name;

    public abstract double getArea();

    public abstract double getPerimeter();

    public void print() {
        System.out.println("Hello");
    }
}
