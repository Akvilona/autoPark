/**
 * Создал Андрей Антонов 02.08.2023 18:30
 **/
package generic.collection;

import java.util.ArrayList;
import java.util.HashMap;

public class MyPhoneBook {
    /***
     * 2 Написать простой класс Телефонный Справочник,
     *  который хранит в себе список фамилий и телефонных номеров.
     *  В этот телефонный справочник с помощью метода add() можно добавлять записи,
     *  а с помощью метода get() искать номер телефона по фамилии.
     *  Следует учесть, что под одной фамилией может быть несколько телефонов
     *  (в случае однофамильцев), тогда при запросе такой фамилии должны
     *  выводиться все телефоны. Желательно не добавлять лишний функционал
     *  (дополнительные поля (имя, отчество, адрес), взаимодействие с пользователем
     *  через консоль и т.д). Консоль использовать только для вывода результатов
     *  проверки телефонного справочника.
     */

    private final HashMap<String, ArrayList<String>> items = new HashMap<>();

    public void add(String surname, String phoneNumber) {

        // Новый контакт создается в случае если такого не существует
        if (items.get(surname) != null) {
            if (!items.get(surname).contains(phoneNumber)) {
                items.get(surname).add(phoneNumber);
            }
        } else {
            // добавляем новый телефон к существующему списку
            ArrayList<String> arr = new ArrayList<>();
            arr.add(phoneNumber);
            items.put(surname, arr);
        }
    }

    // получаем список телефонов по фамилии
    public void get(String surname) {
        System.out.println(surname + " tel. " + items.get(surname));
    }

}

