/**
 * Создал Андрей Антонов 29.07.2023 16:55
 * https://youtu.be/R4AxRoCtTns
 **/
package generic.arrayList;

import java.util.Iterator;

/**
 * Мой ArrayList
 * @param <T>
 */
public class MyArray<T> implements My<T> {

    // тестируем мой ArrayList
    public static void main(String[] args) {
        My<String> strings = new MyArray<>();

        // создаем массив элементов
        strings.add("first1");
        strings.add("first2");
        strings.add("first3");
        strings.add("first4");
        strings.add("first5");

        // получаем второй элемент
        System.out.println("get(2) = " + strings.get(2));
        // получаем размер массива
        System.out.println("size() = " + strings.size());
        // обновляем первый элемент массива
        strings.update(0, "update 1 element Ok");
        // получаем первый элемент массива
        System.out.println("update element = '" + strings.get(0) + "'");
        System.out.println("");
        // удаляем первый элемент массива
        strings.delete(0);
        // выводим весь массив
        for (String s : strings) {
            System.out.println(s);

        }
    }

    private T[] values;

    public MyArray() {
        this.values = (T[]) new Object[0];
    }

    @Override
    public boolean add(T e) {
        try {

            // копируем старый массив в temp
            T[] temp = values;

            // создаем новый массив равный старому ПЛЮС ОДИН элемент
            values = (T[]) new Object[temp.length + 1];

            // копируем все элементы старого массива в новый
            System.arraycopy(temp, 0, values, 0, temp.length);

            // добавляем новый элемент
            values[values.length - 1] = e;

            // возвращаем успех
            return true;

        // обрабатываем возможную ошибку создания массива
        } catch (ClassCastException exception) {

            // выводим в консоль ошибку
            exception.printStackTrace();
        }
        // возвращаем ошибку
        return false;

    }

    @Override
    public void delete(int index) {
        try {
        // копируем старый массив в temp
        T[] temp = values;

        // создаем новый массив равный старому МИНУС ОДИН элемент
        values = (T[]) new Object[temp.length - 1];

        // копируем ПЕРВУЮ часть старого массива в новый ДО индекса
        System.arraycopy(
                temp, 0,                              // что копируем, и с какого элемента
                values,                                     // куда вставляем
                0, index);                                  // промежуток -> с какого элемента, и сколько элементов вставляем

        // копируем ВТОРУЮ часть старого массива в новый ПОСЛЕ индекса
        System.arraycopy(
                temp, index + 1,                      // что будем копировать, и с какого элемента
                values,                                     // куда вставляем
                index, temp.length - index - 1);      // с какого элемента, и сколько элементов вставляем

        // обрабатываем возможную ошибку создания массива
        } catch (ClassCastException exception) {

            // выводим в консоль ошибку
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
