/**
 * Создал Андрей Антонов 29.07.2023 16:56
 * https://youtu.be/R4AxRoCtTns
 **/
package collections;

public interface MyList<T> {

    boolean add (T e);

    void delete (int index);

    T get (int index);

    int size();

    void update(int index, T e);
}
