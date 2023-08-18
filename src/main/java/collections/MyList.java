package collections;

public interface MyList<T> {

    boolean add(T e);

    void delete(int index);

    T get(int index);

    int size();

    void update(int index, T e);
}
