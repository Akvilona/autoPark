package generic.shape;

public class CircleRepository extends Shape implements CrudRepository, Printable {
    @Override
    public Circle findById(final int id) {
        return null;
    }

    @Override
    public boolean delete(final Circle circle) {
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
