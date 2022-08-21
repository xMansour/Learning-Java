import java.util.concurrent.Semaphore;

public class IncThread implements Runnable {
    Semaphore semaphore;
    String name;

    IncThread(Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Starting: " + name);
        try {
            System.out.println(name + " is waiting for a permit");
            semaphore.acquire();
            System.out.println(name + " acquired a permit");
            for (int i = 0; i < 5; i++) {
                Shared.count++;
                System.out.println(name + " count " + Shared.count);
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " releasing a permit");
        semaphore.release();
    }
}
