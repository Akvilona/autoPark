/**
 * Создал Андрей Антонов 02.08.2023 18:30
 **/
package collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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
public class MyPhoneBook {

    private final HashMap<String, Set<String>> addressBook = new HashMap<>();

    //TODO:
    public void add(String surname, String phoneNumber) {
        //addressBook.computeIfAbsent(surname, k -> new HashSet<>()).add(phoneNumber);
        Set<String> surnamePhoneNumbers = addressBook.getOrDefault(surname, new HashSet<>());
        surnamePhoneNumbers.add(phoneNumber);
        addressBook.put(surname, surnamePhoneNumbers);
    }

    public Set<String> get(String surname) {

        return addressBook.get(surname);
    }

}

/*
public class PhoneBook {
    private final HashMap<String, ArrayList<String>> items = new HashMap<>();

    public void add(String surname, String phoneNumber) {
        // Новый контакт создается в том случае если номер который введен не существует
        if (items.get(surname) != null) {
            if (!items.get(surname).contains(phoneNumber)) {
                items.get(surname).add(phoneNumber);
            }
        } else {
            ArrayList<String> arr = new ArrayList<>();
            arr.add(phoneNumber);
            items.put(surname, arr);
        }
    }

    public void get(String surname) {
        String format = "|%1$-20.18s| контактный телефон(ы): ";
        System.out.format(format, surname);
        System.out.println(items.get(surname));
    }
}*/