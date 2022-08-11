public class ExceptionDemo extends Exception{
    private String details = "This is my DemoException";

    public String toString(){
        return "ExceptionDemo:: "+details;
    }

}
