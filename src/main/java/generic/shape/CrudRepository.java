package generic.shape;

public interface CrudRepository {
    Circle findById(int id);

    boolean delete(Circle circle);

    default void print() {
        System.out.println("hello world");
    }
}
