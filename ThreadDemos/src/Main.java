public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread();
        System.out.println("Gonna Sleep for 5 seconds");
        Thread.sleep(5000);
        System.out.println(t);

        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.thread.start();

        ThreadDemo2 threadDemo2 = new ThreadDemo2();
        threadDemo2.start();
        System.out.println(threadDemo2.getPriority());
    }

}
