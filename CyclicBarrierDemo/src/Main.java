import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new OnFinish());
        System.out.println("Starting...");
        new Thread(new CustomThread(cyclicBarrier, "A")).start();
        new Thread(new CustomThread(cyclicBarrier, "B")).start();
        new Thread(new CustomThread(cyclicBarrier, "C")).start();
        new Thread(new CustomThread(cyclicBarrier, "D")).start();
        //new Thread(new CustomThread(cyclicBarrier, "E")).start();
        //new Thread(new CustomThread(cyclicBarrier, "F")).start();
    }
}
