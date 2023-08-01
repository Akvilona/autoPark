/**
 * Создал Андрей Антонов 29.07.2023 16:22
 * https://youtu.be/xf29GvWhn9E
 **/
package generic.arrayList;

import java.util.Iterator;

public class MyIterator<T> implements Iterator<T> {
    private int index = 0;
    private T[] objects;

    public MyIterator(T[] objects) {
        this.objects = objects;
    }

    @Override
    public boolean hasNext() {
        return index < objects.length;
    }

    @Override
    public T next() {
        return objects[index++];
    }
}
