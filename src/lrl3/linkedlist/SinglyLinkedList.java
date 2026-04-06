package lrl3.linkedlist;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {
    private Node head;


    public void createHead(int[] values) {
        head = null;
        for (int i = values.length - 1; i >= 0; i--) {
            Node newNode = new Node(values[i]);
            newNode.next = head;
            head = newNode;
        }
    }

    public void createTail(int[] values) {
        head = null;
        Node tail = null;
        for (int val : values) {
            Node newNode = new Node(val);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
    }

    public String toString() {
        if (head == null) return "[]";
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        return sb.toString().trim();
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void insert(int index, int data) {
        if (index < 0) return;
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node current = head;
        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) return;
        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;
    }

    public void removeFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    public void removeLast() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    public void remove(int index) {
        if (index < 0 || head == null) return;
        if (index == 0) {
            removeFirst();
            return;
        }
        Node current = head;
        for (int i = 0; i < index - 1 && current.next != null; i++) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }


    public void createHeadRec(int[] values, int index) {
        if (index >= values.length) return;
        createHeadRec(values, index + 1);
        addFirst(values[index]);
    }

    public void createTailRec(int[] values, int index) {
        if (index >= values.length) return;
        addLast(values[index]);
        createTailRec(values, index + 1);
    }

    public String toStringRec() {
        return toStringRec(head);
    }

    private String toStringRec(Node node) {
        if (node == null) return "";
        return node.data + " " + toStringRec(node.next);
    }


    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        int[] values = {10, 20, 30, 40, 50};

        System.out.println("=== Тестирование односвязного списка ===");

        list.createHead(values);
        System.out.println("createHead: " + list.toString());

        list.createTail(values);
        System.out.println("createTail: " + list.toString());

        list.addFirst(5);
        System.out.println("addFirst(5): " + list.toString());

        list.addLast(55);
        System.out.println("addLast(55): " + list.toString());

        list.insert(3, 25);
        System.out.println("insert(3, 25): " + list.toString());

        list.removeFirst();
        System.out.println("removeFirst(): " + list.toString());

        list.removeLast();
        System.out.println("removeLast(): " + list.toString());

        list.remove(2);
        System.out.println("remove(2): " + list.toString());

        System.out.println("\n=== Рекурсивные методы ===");
        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.createHeadRec(values, 0);
        System.out.println("createHeadRec: " + list2.toStringRec());

        SinglyLinkedList list3 = new SinglyLinkedList();
        list3.createTailRec(values, 0);
        System.out.println("createTailRec: " + list3.toStringRec());
    }
}