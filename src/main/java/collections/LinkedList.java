package collections;

public class LinkedList {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3); //node
        Node node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        printNodeList(node1);
        Node node = get(node1, 2);
        System.out.println(node.val);

    }

    public static void printNodeList(Node head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static Node get(Node head, int i) {
        int j = 0;
        while (head != null) {
            if (j == i) {
                return head;
            }
            j++;
            head = head.next;
        }
        return null;
    }
}

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}
