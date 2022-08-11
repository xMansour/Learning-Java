public class Main implements ShareableInterface{
    @Override
    public int shareableMethod1() {
        System.out.println("Main class's implementation of the ShareableInterface shareableMethod1");
        return 0;
    }

    @Override
    public void shareableMethod2() {
        ShareableInterface.super.shareableMethod2();
    }

    public static void main(String[] args) {
        System.out.println(CONSTANT1);
        System.out.println(CONSTANT3);
        ShareableInterface.shareableMethod3();
    }
}
