public class QueueDemo<T> {
    T[] array;
    int front;
    int rear;
    int capacity;

    QueueDemo(int size) {
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
            array[++rear] = element;
        } else
            System.out.println("Queue is full");
    }

    public T deqeue() {
        if (!isEmpty()) {
            System.out.println("Removing: " + array[front]);
            array[front] = (T) Integer.valueOf(-1);
            return array[front++];
        } else {
            System.out.println("Queue is empty");
            return (T) Integer.valueOf(-1);
        }
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return front == 0 && rear == capacity - 1;
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
        return stringBuilder.toString();
    }
}
