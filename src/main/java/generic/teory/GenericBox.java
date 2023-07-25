/**
 * Создал Андрей Антонов 24.07.2023 15:54
 **/
package generic.teory;

public class GenericBox<T> { //создаем класс Дженерик Коробка
    private T obj; // в нем объявляем переменную obj типа Т

    public GenericBox(final T obj) { // пишем конструктор
        this.obj = obj;
    }

    public T getObj() { // пишем геттер
        return obj;
    }

    public void showType() { // метод, который показывает тип объекта
        System.out.println("Type T: " + obj.getClass().getName());
    }
}

