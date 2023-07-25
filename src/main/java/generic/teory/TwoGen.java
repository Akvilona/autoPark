/**
 * Создал Андрей Антонов 24.07.2023 16:46
 **/
package generic.teory;

public class TwoGen<T, V> {
    // задаем дженерик-класс с двумя типами параметров T и V
    private T obj1;
    private V obj2;

    // создаем конструктор
    public TwoGen(final T obj1, final V obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    // создаем метод выода типов параметров
    public void showTypes() {
        System.out.println("Type T: " + obj1.getClass().getName());
        System.out.println("Type V: " + obj2.getClass().getName());
    }

    public T getObj1() { // геттер для T
        return obj1;
    }

    public V getObj2() { // геттер для V
        return obj2;
    }
}

