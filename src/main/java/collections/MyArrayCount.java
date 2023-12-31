package collections;

import java.util.HashMap;
import java.util.Map;

/**
 * Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
 * Найти и вывести список уникальных слов, из которых состоит массив
 * (дубликаты не считаем). Посчитать, сколько раз встречается каждое слово.
 */
public class MyArrayCount {
    public static void main(final String[] args) {
        String[] words = getWords();
        Map<String, Integer> stringIntegerMap = calcUniqueWords(words);
        System.out.println(stringIntegerMap);
    }

    private static Map<String, Integer> calcUniqueWords(final String[] words) {
        Map<String, Integer> result = new HashMap<>();
        for (String word : words) {
            result.put(word, result.getOrDefault(word, 0) + 1);
        }
        return result;
    }

    private static String[] getWords() {
        return new String[]{"1", "3", "1", "2", "6", "1"};
    }
}

