/**
 * Создал Андрей Антонов 24.07.2023 15:38
 **/

package generic.teory;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class SimpleBox {

    private Object obj; // поле типа Object

    public SimpleBox(final Object obj) { //конструктор объекта
        this.obj = obj;
    }

    public void setObj(final Object obj) { //сеттер
        this.obj = obj;
    }

}
