/**
 * Создал Андрей Антонов 02.08.2023 20:11
 **/
package collections;

import collections.algorithms.Algorithms;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
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

        List<String> words = new ArrayList<>();
        Map<String, List<String>> result;
        words.add("abcd");
        words.add("abcd");
        words.add("dbac");
        words.add("dbca");
        words.add("dbca");
        words.add("dsaa");
        words.add("asda");
        words.add("acdb");
        words.add("a22cdb");

        result = Algorithms.groupAnagrams(words);
        System.out.println(result);

        LinkedList<String> linkedList = new LinkedList<>();

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

        Stack stack = new Stack();

        stack.push(1);      // вставляем 1 в stack
        stack.push(2);      // вставляем 2 в stack

        stack.pop();        // удаление верхнего элемента (2)
        stack.pop();        // удаление верхнего элемента (1)

        stack.push(3);      // вставляем 3 в stack

        System.out.println("The top element is " + stack.peek());
        System.out.println("The stack size is " + stack.size());

        stack.pop();        // удаление верхнего элемента (3)

        // проверяем, пуст ли stack
        if (stack.isEmpty()) {
            System.out.println("The stack is empty");
        }
        else {
            System.out.println("The stack is not empty");
        }
    }
}
