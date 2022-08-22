import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        System.out.println("Starting...");
        new Thread(new DecThread(countDownLatch)).start();
        try {
            //calling await() from the main thread causes the main thread to wait until the count down latch
            //reaches zero.
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }
}
