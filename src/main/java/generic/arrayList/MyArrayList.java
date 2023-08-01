/**
 * Создал Андрей Антонов 29.07.2023 16:56
 * https://youtu.be/R4AxRoCtTns
 **/
package generic.arrayList;

public interface MyArrayList<T> extends Iterable<T> {

    boolean add (T e);

    void delete (int index);

    T get (int index);

    int size();

    void update(int index, T e);
}
