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
            countDownLatch.countDown();
        }
    }
}
