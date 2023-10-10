/**
 * Создал Андрей Антонов 27.07.2023 9:21
 **/

package generic.shape;

public abstract class Shape {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public void print() {
        System.out.println("Hello");
    }
}
