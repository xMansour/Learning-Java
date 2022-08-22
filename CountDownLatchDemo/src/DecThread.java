import java.util.concurrent.CountDownLatch;

public class DecThread implements Runnable {
    private CountDownLatch countDownLatch;

    DecThread(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            //here the DecThread must decrement the count down latch times equal to the number of events assigned
            //to the latch from the main thread. In order to go back to the main thread.
            countDownLatch.countDown();
        }
    }
}
