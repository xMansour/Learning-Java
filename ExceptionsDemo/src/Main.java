public class Main {

    public static void main(String[] args) {
        try{
            throw new ExceptionDemo();
        }
        catch (ExceptionDemo | ArrayIndexOutOfBoundsException e){ //multiCatch
            System.out.println(e.toString());
        }
    }
}
