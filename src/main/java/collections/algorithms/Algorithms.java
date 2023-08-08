package collections.algorithms;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Algorithms {

    /**
     * Напишите функцию, которая принимает на вход два ArrayList и возвращает новый список, содержащий элементы
     * из обоих списков без повторений. Воспользуйтесь HashSet для устранения дубликатов.
     * Списки должны быть одного типа (generic один для обоих списков)
     *
     * @param lists
     * @param <T>
     * @return the name of the object
     */
    public static <T> List<T> mergeLists(final List<T>... lists) {
        List<T> result = new ArrayList<>();
        for (List<T> list : lists) {
            for (T t : list) {
                if (!result.contains(t)) {
                    result.add(t);
                }
            }
        }
        return result;
    }

    public static <T> List<T> mergeListsWithHashSet(final List<T>... lists) {
        Set<T> result = new HashSet<>();
        for (List<T> list : lists) {
            result.addAll(list);
        }
        return new ArrayList<>(result);
    }

    /**
     * Напишите функцию, которая принимает на вход список слов и группирует их в Hash`Map` по анаграммам
     * (словам, образованным из одних и тех же букв). Ключом в HashMap будет отсортированное по
     * алфавиту слово, а значением - список анаграмм этого слова.
     *
     * @param words
     * @return the name of the object
     */
    public static Map<String, List<String>> groupAnagrams(final List<String> words) {
        Map<String, List<String>> result = new HashMap<>();

        for (String stringWord : words) {
            char[] chars = stringWord.toCharArray();
            Arrays.sort(chars);
            String sortedSurName = new String(chars);

            List<String> surNamesList = result.computeIfAbsent(sortedSurName, k -> new ArrayList<>());
            surNamesList.add(stringWord);
        }
        return result;
    }

    /**
     * Задача 1: Поиск дубликатов
     * <p>
     * Напишите метод, который принимает на вход ArrayList целых чисел
     * и находит все дубликаты (числа, которые повторяются более одного раза).
     * Метод должен возвращать Set дубликатов слов
     *
     * @param integerList
     * @return the name of the object
     */
    public Set<Integer> findDuplicate(final List<Integer> integerList) {
        return new HashSet<>(integerList);
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
         * Adds an element to the top of the stack.
         *
         * @param t the element to be added
         */
        public void push(final T t) {
            list.add(t);
        }

        /**
         * Removes and returns the top element of the stack.
         * If the stack is empty, returns null.
         *
         * @return the top element of the stack, or null if the stack is empty.
         */
        public T pop() {
            if (isEmpty()) {
                return null;
            }

            return list.get(list.size() - 1);
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }
    }
}
