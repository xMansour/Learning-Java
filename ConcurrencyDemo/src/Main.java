import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        new Thread(new IncThread(semaphore, "Thread A")).start();
        new Thread(new DecThread(semaphore, "Thread B")).start();
    }
}
