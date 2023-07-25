/**
 * Создал Андрей Антонов 24.07.2023 15:38
 **/
package generic.teory;

public class SimpleBox {
    private Object obj; // поле типа Object

    public Object getObj() { //геттер
        return obj;
    }

    public void setObj(final Object obj) { //сеттер
        this.obj = obj;
    }

    public SimpleBox(final Object obj) { //конструктор объекта
        this.obj = obj;
    }

}
