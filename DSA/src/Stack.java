public class Stack<T> {
    private T[] arr;
    private int top;
    private int capacity;

    Stack(int size) {
        arr = (T[]) new Object[size];
        capacity = size;
        top = -1;
    }


    public void push(T element) {
        if (isFull())
            System.out.println("Stack Overflow");
        else {
            System.out.println("Inserting: " + element);
            arr[++top] = element;
        }
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return (T) Integer.valueOf(0);
        } else {
            System.out.println("Removing: " + arr[top]);
            arr[top] = (T) Integer.valueOf(-1);     //setting removed elements to -1
            return arr[top--];
        }
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public T peek() {
        if (!isEmpty())
            return arr[top];
        else
            return (T) Integer.valueOf(-1);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Stack contains: ");
        for (T element : arr) {
            stringBuilder.append(" ").append(element).append(" ");
        }
        return stringBuilder.toString();
    }
}
