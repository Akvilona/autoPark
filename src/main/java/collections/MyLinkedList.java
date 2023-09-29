package collections;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyLinkedList<E> implements MyList<E> {
    private Node head;

    @Override
    public boolean add(final E e) {
        Node newNode = new Node(e);
        if (head == null) {
            head = newNode;
            return true;
        }

        Node temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }

        temp.next = newNode;
        return true;
    }

    @Override
    public void delete(final int index) {
        if (head == null) {
            return;
        }
        if (index == 0) {
            head = head.getNext();
            return;
        }

        Node temp = head;
        int cur = 1;
        while (temp.getNext() != null) {
            if (cur == index) {
                temp.next = temp.getNext().getNext();
                return;
            }
            temp = temp.getNext();
            cur++;
        }
    }

    @Override
    public E get(final int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void update(final int index, final E e) {

    }

    @Data
    @AllArgsConstructor
    private class Node {
        private E data;
        private Node next;

        Node(final E data) {
            this.data = data;
        }
    }


}
