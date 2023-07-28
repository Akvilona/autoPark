package generic.shape;

public interface CrudRepository {
    public abstract Circle findById(int id);
    public abstract boolean delete(Circle circle);

    default void print() {
        System.out.println("hello world");
    }
}
