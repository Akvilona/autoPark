package collections.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

//TODO:
public class Algorithms {

    /**
     * Задача 1: Поиск дубликатов
     * <p>
     * Напишите метод, который принимает на вход ArrayList целых чисел
     * и находит все дубликаты (числа, которые повторяются более одного раза).
     * Метод должен возвращать Set дубликатов слов
     *
     * @param integerList
     * @return
     */
    //TODO:
    private Set<Integer> findDuplicate(List<Integer> integerList) {
        return null;
    }

    /**
     * Напишите функцию, которая принимает на вход два ArrayList и возвращает новый список, содержащий элементы
     * из обоих списков без повторений. Воспользуйтесь HashSet для устранения дубликатов.
     * Списки должны быть одного типа (generic один для обоих списков)
     *
     * @param list1
     * @param list2
     * @param <T>
     * @return
     */
    //TODO:
    private <T> List<T> mergeLists(List<T> list1, List<T> list2) {
        return null;
    }

    /**
     * Напишите функцию, которая принимает на вход список слов и группирует их в HashMap по анаграммам
     * (словам, образованным из одних и тех же букв). Ключом в HashMap будет отсортированное по
     * алфавиту слово, а значением - список анаграмм этого слова.
     *
     * @param words
     * @return
     */
    //TODO:
    private Map<Character[], List<String>> groupAnagrams(List<String> words) {
        return null;
    }

    /**
     * Реализуйте стек (структуру данных "последний вошел, первый вышел") с использованием ArrayList. Напишите методы
     * push (добавление элемента в стек),
     * pop (удаление и возврат верхнего элемента стека)
     * isEmpty (проверка, пуст ли стек).
     *
     * @param <T>
     */
    private static class Stack<T> {
        private final List<T> list = new ArrayList<>();

        /**
         * добавление элемента в стек
         *
         * @param t
         * @return
         */
        public void push(T t) {
        }

        /**
         * удаление и возврат верхнего элемента стека
         *
         * @return
         */
        public T pop() {
            return null;
        }

        /**
         * проверка, пуст ли стек
         *
         * @return
         */
        public boolean isEmpty() {
            return false;
        }
    }
}
