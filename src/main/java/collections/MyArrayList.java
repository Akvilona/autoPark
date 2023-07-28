package collections;


public class MyArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private final Object[] elements;
    private final int size;

    public MyArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }
///todo методы
}