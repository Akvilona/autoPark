package generic.shape;

public class CircleRepository extends Shape implements CrudRepository, Printable {
    @Override
    public Circle findById(int id) {
        return null;
    }

    @Override
    public boolean delete(Circle circle) {
        return false;
    }

    @Override
    public void print() {

    }

    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public double getPerimeter() {
        return 0;
    }
}
