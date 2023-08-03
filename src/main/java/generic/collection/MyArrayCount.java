/**
 * Создал Андрей Антонов 02.08.2023 17:25
 **/
package generic.collection;

import java.util.HashSet;

public class MyArrayCount {
    public static void main(String[] args) {

        /**
         * 1	Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
         *      Найти и вывести список уникальных слов, из которых состоит массив
         *      (дубликаты не считаем). Посчитать, сколько раз встречается каждое слово.
         */
        String [] myString = new String [20];
        HashSet<String> stringHashSet = new HashSet<>();

        /** создаем повторяющиеся элементы в массиве */
        for (int i = 0; i < myString.length; i++) {
            myString[i] = "pole_" + (100 % (i+1));
            stringHashSet.add(myString[i]);
        }

        int j = 0;

        for (String ms: stringHashSet) {
            System.out.print(ms);
            int i = 0;
            for (String str: myString) {
                if (str.equals(ms)) i++;
            }
            System.out.println(" total identical: " + i);
            j = j + i;
        }
        System.out.println(" all of them: " + j);

    }
}

