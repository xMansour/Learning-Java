public class DoublyLinkedListDemo<T> {
    Node head;


    static class Node<T> {
        T data;
        Node nextNode;
        Node prevNode;

        Node(T data) {
            this.data = data;
            nextNode = null;
            prevNode = null;
        }

    }

    public void traverseForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.nextNode;
        }
    }

    public void traverseBackward() {
        Node temp = head;
        while (temp.nextNode != null) {
            temp = temp.nextNode;
        }
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prevNode;
        }
    }
}
