public class Main {
    public static void main(String[] args) {
        StackDemo<Integer> stack = new StackDemo<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        System.out.println(stack.toString());
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.toString());
        System.out.println("Stack's peek content: " + stack.peek());

        QueueDemo queueDemo = new QueueDemo(5);
        queueDemo.enqeue(1);
        queueDemo.enqeue(2);
        queueDemo.enqeue(3);
        queueDemo.enqeue(4);
        queueDemo.enqeue(5);
        System.out.println(queueDemo.toString());
        queueDemo.deqeue();
        queueDemo.deqeue();
        queueDemo.deqeue();
        queueDemo.deqeue();
        System.out.println(queueDemo.toString());

        CircularQueueDemo circularQueueDemo = new CircularQueueDemo(5);
        circularQueueDemo.enqeue(1);
        circularQueueDemo.enqeue(2);
        circularQueueDemo.enqeue(3);
        circularQueueDemo.enqeue(4);
        circularQueueDemo.enqeue(5);
        System.out.println(circularQueueDemo.toString());
        circularQueueDemo.deqeue();
        circularQueueDemo.deqeue();
        System.out.println(circularQueueDemo.toString());
        circularQueueDemo.enqeue(6);
        circularQueueDemo.enqeue(7);
        System.out.println(circularQueueDemo.toString());
        circularQueueDemo.enqeue(8);


        DoubleEndedQueueDemo dq = new DoubleEndedQueueDemo(4);
        System.out.println("Insert element at rear end : 12 ");
        dq.insertrear(12);
        System.out.println("insert element at rear end : 14 ");
        dq.insertrear(14);
        System.out.println("get rear element : " + dq.getRear());
        dq.deleterear();
        System.out.println("After delete rear element new rear become : " + dq.getRear());
        System.out.println("inserting element at front end");
        dq.insertfront(13);
        System.out.println("get front element: " + dq.getFront());
        dq.deletefront();
        System.out.println("After delete front element new front become : " + +dq.getFront());


        SinglyLinkedListDemo<Integer> singlyLinkedListDemo = new SinglyLinkedListDemo<>();
        singlyLinkedListDemo.head = new SinglyLinkedListDemo.Node(1);
        SinglyLinkedListDemo.Node secondNode = new SinglyLinkedListDemo.Node(2);
        SinglyLinkedListDemo.Node thirdNode = new SinglyLinkedListDemo.Node(3);
        singlyLinkedListDemo.head.nextNode = secondNode;
        secondNode.nextNode = thirdNode;

        System.out.print("Linked list items: ");
        singlyLinkedListDemo.traverse();
        singlyLinkedListDemo.insertAtEnd(4);
        singlyLinkedListDemo.insertAtBeginning(0);
        System.out.println();
        System.out.print("Linked list items: ");
        singlyLinkedListDemo.traverse();
        System.out.println();
        System.out.println(singlyLinkedListDemo.isFound(3));
        singlyLinkedListDemo.insertAtIndex(2, 6);
        System.out.print("Linked list items: ");
        singlyLinkedListDemo.traverse();
        System.out.println();
        singlyLinkedListDemo.deleteNode(2);
        System.out.print("Linked list items: ");
        singlyLinkedListDemo.traverse();
        System.out.println();


        DoublyLinkedListDemo doublyLinkedListDemo = new DoublyLinkedListDemo();
        doublyLinkedListDemo.head = new DoublyLinkedListDemo.Node("first");
        DoublyLinkedListDemo.Node secondDNode = new DoublyLinkedListDemo.Node("second");
        DoublyLinkedListDemo.Node thirdDNode = new DoublyLinkedListDemo.Node("third");
        doublyLinkedListDemo.head.nextNode = secondDNode;
        doublyLinkedListDemo.head.prevNode = null;
        secondDNode.nextNode = thirdDNode;
        secondDNode.prevNode = doublyLinkedListDemo.head;
        thirdDNode.nextNode = null;
        thirdDNode.prevNode = secondDNode;
        System.out.print("Linked list items: ");
        doublyLinkedListDemo.traverseForward();
        System.out.println();
        System.out.print("Linked list items: ");
        doublyLinkedListDemo.traverseBackward();
        System.out.println();



    }
}
