/**
 * Создал Андрей Антонов 18.07.2023 6:35
 **/
package generic;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private final List<T> box = new ArrayList<>();

    public void add(final T fruit) {
        this.box.add(fruit);
    }

    public void printBox() {
        for (T fruit: box) {
            System.out.println(fruit);
        }
    }

    public float getWeight() {
        float result = 0.0f;
        for (T fruit: box) {
            result += fruit.getWeight();
        }
        return result;
    }

    public List<T> getBox() {
        return this.box;
    }
}
