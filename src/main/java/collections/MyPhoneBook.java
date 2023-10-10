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

    public void add(final String surname, final String phoneNumber) {
        //addressBook.computeIfAbsent(surname, k -> new HashSet<>()).add(phoneNumber);
        Set<String> surnamePhoneNumbers = addressBook.getOrDefault(surname, new HashSet<>());
        surnamePhoneNumbers.add(phoneNumber);
        addressBook.put(surname, surnamePhoneNumbers);
    }

    public Set<String> get(final String surname) {

        return addressBook.get(surname);
    }
}
