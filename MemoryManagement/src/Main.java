import java.io.IOException;

public class Main extends ClassLoader implements Cloneable{
    public static void main(String[] args) throws IOException {
        Runtime runTimeObj = Runtime.getRuntime();
        System.out.println("Total Memory: " + runTimeObj.totalMemory());
        System.out.println("Total Free Memory Before Garbage Collector Is Called: " + runTimeObj.freeMemory());
        runTimeObj.gc();
        System.out.println("Total Memory: " + runTimeObj.totalMemory());
        System.out.println("Total Free Memory After Garbage Collector Is Called: " + runTimeObj.freeMemory());

        //Running a program using Process process = Runtime.exec("String Command");
        Process process = null;
        process = runTimeObj.exec("vlc");
        System.out.println(Runtime.version());
        System.out.println(Runtime.version().feature());
        System.out.println(Runtime.version().interim());
        System.out.println(Runtime.version().update());
        System.out.println(Runtime.version().patch());

        ProcessBuilder processBuilder = new ProcessBuilder("notepad", "New File");
        processBuilder.start();

        System.out.println(System.currentTimeMillis());
        System.getenv().forEach((key, value) ->
        {
            System.out.println(key + " = " + value);

        });
        //calls the garbage collector too like Runtime.getRuntime().gc();
        System.gc();
        //Runtime.getRuntime().gc();

        System.out.println(System.getProperty("user.dir"));

    }

    @Override
    public Main clone() {
        try {
            return (Main) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
