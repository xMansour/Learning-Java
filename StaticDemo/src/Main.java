public class Main {
    static int a = 5;
    static int b;

    static int sum(int x){
        return x+a+b;
    }

    //static blocks are executed first for initialization.
    static {
        b = a * 4;
    }

    public static void main(String[] args) {
        System.out.println(sum(5));

    }
}
