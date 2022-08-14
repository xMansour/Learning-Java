public class SinglyLinkedListDemo<T> {
    Node head;

    static class Node<T>{
        T data;
        Node nextNode;

        Node(T data) {
            this.data = data;
            nextNode = null;
        }

    }

    public void traverse() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.nextNode;
        }
    }

    public boolean isFound(T element) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == element)
                return true;
            temp = temp.nextNode;
        }
        return false;
    }

    public void insertAtBeginning(T element) {
        Node newNode = new Node(element);
        newNode.nextNode = head;
        head = newNode;
    }

    public void insertAtEnd(T element) {
        Node newNode = new Node(element);
        Node last = head;
        while (last.nextNode != null) {
            last = last.nextNode;
        }
        last.nextNode = newNode;
    }

    public void insertAtIndex(int index, T element) {
        Node newNode = new Node(element);
        Node next = head;
        Node prev = head;

        for (int i = 0; i < index; i++) {
            prev = next;
            next = next.nextNode;
        }
        newNode.nextNode = next;
        prev.nextNode = newNode;
    }

    public void deleteNode(int index) {
        Node next = head;
        Node prev = head;

        for (int i = 0; i < index; i++) {
            prev = next;
            next = next.nextNode;
        }
        prev.nextNode = next.nextNode;
    }
}
