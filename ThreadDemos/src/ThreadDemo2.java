public class ThreadDemo2 extends Thread{
    ThreadDemo2(){
        super("ThreadDemo2");
    }

    public void run(){
        System.out.println("ThreadDemo2 is running");
    }
}
