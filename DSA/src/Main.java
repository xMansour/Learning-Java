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

    }
}
