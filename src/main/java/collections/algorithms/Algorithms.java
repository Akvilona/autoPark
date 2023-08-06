package collections.algorithms;
import java.util.*;

//TODO:
public class Algorithms {
    Stack<Integer> stack = new Stack<Integer>();
    private List<Object> list1;
    private List<Object> list2;

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

    public Set<Integer> findDuplicate(final List<Integer> integerList) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> integerSet = new HashSet<Integer>();
        for (Integer each : integerList) {
            if (!set.add(each)) {
                integerSet.add(each); // добавляем только дубликаты
            }
        }
        return integerSet;
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
        public static<T> List<T> mergeLists(final List<T> ... lists) {
            List<T> result = new ArrayList<>();
            for (List<T> l: lists) {
                for (int k = 0; k < l.size(); k++) {
                    if( result.indexOf(l.get(k)) == -1) {
                        result.add(l.get(k));
                    }
                }
            }
            return result;
           /*
            List<T> result = new ArrayList<>();
            Stream.of(lists).forEach(result::addAll);
            return result;*/
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
    public Map<String, List<String>> groupAnagrams(final List<String> words) {
        for (String stringWord : words) {
            addSurName(stringWord);
        }
        return listMap;

    }

    private final Map<String, List<String>> listMap = new HashMap<>();

    private void addSurName(final String surName) {

        char[] chars = surName.toCharArray();
        Arrays.sort(chars);
        String stringСhars = new String(chars);

        if (listMap.get(stringСhars) != null) {
            if (!listMap.get(stringСhars).contains(surName)) {
                listMap.get(stringСhars).add(surName);
            }
        } else {
            List<String> arrayList = new ArrayList<>();
            arrayList.add(surName);
            listMap.put(stringСhars, arrayList);
        }

/* ниже скрипт работает неправильно
        List<String> surnameArrayList = listMap.getOrDefault(string1, new ArrayList<>());
        surnameArrayList.add(surName);
        listMap.put(surName, surnameArrayList);
 */
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
        private int top;
        private int capacity;
        private final List<T> list = new ArrayList<>();

        /***
         * Конструктор для инициализации stack
         * @param
         */
        public Stack(int top, int capacity) {
            this.top = top;
            this.capacity = capacity;
        }

        /**
         * добавление элемента в стек
         *
         * @param t
         * @return
         */
        public void push(T t) {
            if (isFull())
            {
                System.out.println("Overflow\nProgram Terminated\n");
                System.exit(-1);
            }

            System.out.println("Inserting " + t);
            list.add(t);
            ++top;
        }

        /**
         * удаление и возврат верхнего элемента стека
         *
         * @return
         */
        public T pop() {
            // проверка на опустошение stack
            if (isEmpty())
            {
                System.out.println("Underflow\nProgram Terminated");
                System.exit(-1);
            }

            System.out.println("Removing " + peek());

            // уменьшаем размер stack на 1 и (необязательно) возвращаем извлеченный элемент
            return list.get(top--);
        }


        /***
         * Вспомогательная функция для возврата верхнего элемента stack
         * @return
         */
        public T peek()
        {
            if (!isEmpty()) {
                return list.get(top);
            }
            else {
                System.exit(-1);
            }

            return list.get(top);
        }

        /**
         * проверка, пуст ли стек
         * Вспомогательная функция для проверки, пуст stack или нет
         * @return
         */
        public boolean isEmpty() {
            return top == -1;               // или return size() == 0;
        }

        /**
         * Вспомогательная функция для возврата размера stack
         * @return
         */
        public int size() {
            return top + 1;
        }

        /**
         * Вспомогательная функция для проверки, заполнен ли stack или нет
         * @return
         */
        public boolean isFull() {
            return top == capacity - 1;     // или return size() == capacity;
        }
    }
}
