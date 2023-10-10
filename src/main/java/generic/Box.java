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

    public int sizeBox() {
        return box.size();
    }

    public void addAll(final T[] fruit) {
        for (int i = 0; i < fruit.length; i++) {
            this.box.add(fruit[i]);
        }
    }

    public void addAllVarArgs(final T... fruits) {
        for (int i = 0; i < fruits.length; i++) {
            this.box.add(fruits[i]);
        }
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

    public Fruit getFruit(final int i) {
        return this.box.get(i);
    }

    public boolean compare(final Box<?> anotherBox) {
        return this.getWeight() - anotherBox.getWeight() == 0;
    }

    public boolean pourOver(final ArrayList<T> box) {
        int count = box.size();
        for (int i = 0; i < count; i++) {
            this.box.add((T) getFruit(i));
        }
        return true; /* пересыпали */
    }
}
