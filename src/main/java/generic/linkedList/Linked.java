/**
 * Создал Андрей Антонов 01.08.2023 14:21
 **/
package generic.linkedList;

public interface Linked <E>{
    void addLast(E e);
    void addFirst(E e);
    int size();
    E getElementByIndex(int counter);
}
