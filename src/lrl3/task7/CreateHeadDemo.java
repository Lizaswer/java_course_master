package lrl3.task7;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CreateHeadDemo {
    private Node head;

    // Создание списка с головы (пример 2 из раздела 2)
    public void createHead(int[] values) {
        head = null;  // ТОЧКА 1

        for (int i = values.length - 1; i >= 0; i--) {
            Node newNode = new Node(values[i]);  // ТОЧКА 2
            newNode.next = head;                 // ТОЧКА 3
            head = newNode;                      // ТОЧКА 3
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CreateHeadDemo list = new CreateHeadDemo();
        int[] values = {10, 20, 30, 40, 50};

        System.out.println("=== Создание списка С ГОЛОВЫ ===");
        list.createHead(values);
        System.out.print("Результат: ");
        list.printList();
    }
}