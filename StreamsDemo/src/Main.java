import java.io.*;

public class Main {
    public static void main(String[] args) {
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Characters, q to quit.");
        char c;
        do {
            c = (char) br.read();
            System.out.println(c);
        } while (c != 'q');*/

        /*FileInputStream fin = null;
        try {
            fin = new FileInputStream("C:\\Users\\Mansour\\Documents\\Programming\\Java\\StreamsDemo\\src\\lorem.txt");
            int i;
            do {
                i = fin.read();
                if (i != -1)
                    System.out.print((char) i);
            } while (i != -1);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert fin != null : "FileInputStream is null";
                fin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/

        //Resources created in the try statement are implicitly final
        try (FileInputStream fin = new FileInputStream("C:\\Users\\Mansour\\Documents\\Programming\\Java\\StreamsDemo\\src\\lorem.txt")) {
            int i;
            do {
                i = fin.read();
                if (i != -1)
                    System.out.print((char) i);
            } while (i != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
