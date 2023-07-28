package collections;


public class MyLinkedList<E> {
    private Node<E> head;
    private int size;
    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    private static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }
}
