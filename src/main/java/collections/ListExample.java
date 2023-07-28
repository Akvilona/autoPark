package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        List<Integer> integers = new LinkedList<>();
        integers.add(12);
        integers.add(33);
        integers.add(44);
        integers.add(33);
        integers.add(3, 55);

        Integer integer = integers.get(0);
        System.out.println(integer);

        List<Integer> integers2 = new ArrayList<>();
        integers.addAll(integers2);

        int size = integers2.size();

        if (integers2.isEmpty()) {
            System.out.println("hello");
        }

        int indexOf = integers.indexOf(33);
        System.out.println(indexOf);

        integers.remove(0);
        System.out.println(integers);

        int indexOf1 = integers.lastIndexOf(33);
        System.out.println(indexOf1);

        integers.clear();

    }
}
