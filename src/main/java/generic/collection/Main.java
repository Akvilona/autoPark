/**
 * Создал Андрей Антонов 02.08.2023 20:11
 **/
package generic.collection;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MyPhoneBook pB = new MyPhoneBook();

        // заполняем справочник данными
        System.out.println("Task No. 2 telephone directory");
        pB.add("Petrov", "+7 (911) 322-22-23");
        pB.add("Ivanov", "+7 (911) 444-44-44" );
        pB.add("Prtrov", "+7 (911) 322-22-23" );
        pB.add("Sidorov", "+7 (911) 555-55-55" );
        pB.add("Antonov", "+7 (911) 666-69-69");
        pB.add("Petrov", "+7 (911) 772-27-72" );
        pB.add("Ivanov", "+7 (911) 802-08-02" );
        pB.add("Petrov", "+7 (911) 999-09-90" );
        // запрашиваем результаты
        pB.get("Petrov");
        pB.get("Ivanov");
        pB.get("Sidorov");
    }
}
