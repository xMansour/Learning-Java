public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(4);
        stack.push(5);
        stack.push(65);
        stack.push(58);
        stack.push(12);
        stack.display();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.display();

    }
}
