public class ThreadDemo implements Runnable{
    Thread thread;
    @Override
    public void run() {
        System.out.println("ThreadDemo  is running");
    }

    ThreadDemo(){
        thread = new Thread(this, "ThreadDemo");
    }

}
