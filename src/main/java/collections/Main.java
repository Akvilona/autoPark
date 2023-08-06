/**
 * Создал Андрей Антонов 02.08.2023 20:11
 **/
package collections;

import collections.algorithms.Algorithms;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Algorithms algorithms = new Algorithms();
        List<Integer> findDublicate = new ArrayList<>();
        findDublicate.add(1);
        findDublicate.add(2);
        findDublicate.add(3);
        findDublicate.add(1);
        findDublicate.add(4);
        findDublicate.add(5);
        findDublicate.add(4);
        findDublicate.add(6);
        findDublicate.add(5);
        findDublicate.add(9);
//        Set<Integer> integerSet = algorithms.findDuplicate(findDublicate);
        List<Integer> list = algorithms.mergeLists(findDublicate, findDublicate);
        System.out.println(list);

/*
        List<String> words = new ArrayList<>();
        Map<String, List<String>> result;
        words.add("abcd");
        words.add("dbca");
        words.add("dbac");
        words.add("dbca");
        words.add("dbca");
        words.add("dsaa");
        words.add("asda");
        words.add("acdb");
        words.add("a22cdb");


        result = algorithms.groupAnagrams(words);
        System.out.println(result);
*/
/*
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
*/
    }
}
