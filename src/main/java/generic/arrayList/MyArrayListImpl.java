/**
 * Создал Андрей Антонов 29.07.2023 16:55
 * https://youtu.be/R4AxRoCtTns
 **/
package generic.arrayList;

import java.util.Iterator;

/**
 * Мой ArrayList
 *
 * @param <T>
 */
public class MyArrayListImpl<T> implements MyArrayList<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private T[] values;

    public MyArrayListImpl() {
        this.values = (T[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public boolean add(T e) {
        try {
            T[] temp = values;
            values = (T[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, values, 0, temp.length);
            values[values.length - 1] = e;
            return true;
        } catch (ClassCastException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public void delete(int index) {
        try {
            T[] temp = values;
            values = (T[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, values, 0, index);
            System.arraycopy(temp, index + 1, values, index, temp.length - index - 1);
        } catch (ClassCastException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public T get(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public void update(int index, T e) {
        values[index] = e;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>(values);
    }
}
