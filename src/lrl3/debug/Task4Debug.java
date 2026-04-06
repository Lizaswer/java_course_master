package lrl3.debug;

public class Task4Debug {
    public static void main(String[] args) {
        // Самый простой список
        Node tail = new Node(5);
        Node node4 = new Node(4);
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node head = new Node(1);

        // Связываем
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = tail;

        // Вывод
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.value + " ");
            curr = curr.next;
        }
    }
}

class Node {
    int value;
    Node next;
    Node(int v) { value = v; }
}