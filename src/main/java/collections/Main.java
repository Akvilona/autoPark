/**
 * Создал Андрей Антонов 02.08.2023 20:11
 **/
package collections;

public class Main {
    public static void main(String[] args) {
        MyPhoneBook phoneBook = new MyPhoneBook();

        java.util.LinkedList<String> javaLinked = new java.util.LinkedList<>();
        javaLinked.add("s");

        // заполняем справочник данными
        System.out.println("Task No. 2 telephone directory");
        phoneBook.add("Petrov", "+7 (911) 322-22-23");
        phoneBook.add("Petrov", "+7 (911) 772-27-72" );

        phoneBook.add("Ivanov", "+7 (911) 444-44-44" );
        phoneBook.add("Prtrov", "+7 (911) 322-22-23" );
        phoneBook.add("Sidorov", "+7 (911) 555-55-55" );
        phoneBook.add("Antonov", "+7 (911) 666-69-69");
        phoneBook.add("Ivanov", "+7 (911) 802-08-02" );
        phoneBook.add("Petrov", "+7 (911) 999-09-90" );
        // запрашиваем результаты
        phoneBook.get("Petrov");
        phoneBook.get("Ivanov");
        phoneBook.get("Sidorov");

        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("1");
        myLinkedList.add("2");
        myLinkedList.add("3");

        myLinkedList.delete(2);

    }
}
