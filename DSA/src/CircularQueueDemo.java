public class CircularQueueDemo<T> {
    private T[] array;
    private int front;
    private int rear;
    private int capacity;

    CircularQueueDemo(int size) {
        array = (T[]) new Object[size];
        front = -1;
        rear = -1;
        capacity = size;
    }

    public void enqeue(T element) {
        if (!isFull()) {
            if (front == -1)
                front = 0;
            System.out.println("Adding: " + element);
            rear = (rear + 1) % capacity;
            array[rear] = element;
        } else
            System.out.println("Queue is full");
    }

    public T deqeue() {
        if (!isEmpty()) {
            System.out.println("Removing: " + array[front]);
            array[front] = (T) Integer.valueOf(-1);
            return array[front++ % capacity];
        } else {
            System.out.println("Queue is empty");
            return (T) Integer.valueOf(-1);
        }
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (front == 0 && rear == capacity - 1) || front == rear + 1;
    }

    public T peek() {
        return array[front];
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Queue contains: ");
        for (T element : array) {
            stringBuilder.append(" ").append(element).append(" ");
        }

        stringBuilder.append(" Front: ").append(front).append(" Rear: ").append(rear);
        return stringBuilder.toString();
    }
}
