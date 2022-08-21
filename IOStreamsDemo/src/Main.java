import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/AWS");
        System.out.println(file.exists());
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.canRead());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.lastModified());
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        //file.renameTo(new File("src/AWS"));
        //file.delete();

        //Directories
        File dir = new File("src");
        System.out.println(dir.getPath());
        System.out.println(dir.getAbsolutePath());
        System.out.println(dir.isDirectory());
        System.out.println(dir.isFile());
        System.out.println(dir.getParent());
        //System.out.println(Arrays.toString(dir.list()));
        if (dir.exists())
            for (String fileName : dir.list(new filter("java"))) {
                //if (fileName.endsWith(".java"))
                System.out.println(fileName);

            }


        if (dir.exists())
            for (File fil : dir.listFiles(new filter("java"))) {
                //if (fileName.endsWith(".java"))
                System.out.println(fil.isFile());
                System.out.println(fil.getName());
                try (FileInputStream fileInputStream = new FileInputStream(fil)) {
                    System.out.println(fileInputStream.available());
                    System.out.println(fileInputStream.read());
                    for (int i = 0; i < fileInputStream.available(); i++) {
                        System.out.print((char) fileInputStream.read());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        String str = "bla bla bla";
        byte[] strBytes = str.getBytes();

        try (FileOutputStream fos1 = new FileOutputStream("file1.txt")) {
            for (int i = 0; i < strBytes.length; i++) {
                fos1.write(strBytes[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (FileReader fileReader = new FileReader("src/AWS")) {
            int c;
            while ((c = fileReader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader fileReader = new FileReader("src/AWS");
             FileWriter fileWriter = new FileWriter("src/AWS-Copied")) {
            int c;
            while ((c = fileReader.read()) != -1) {
                fileWriter.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter fileWriter = new FileWriter("NewFile")) {
            String source = "This is the source data to be written into the NewFile";
            char[] buffer = new char[source.length()];
            source.getChars(0, source.length(), buffer, 0);
            for (char c : buffer) {
                fileWriter.write(c);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        /*Console console = System.console();
        if (console == null) return;
        else {
            String string = console.readLine("Enter a String: ");
            System.out.println("You entered: " + string);

            char[] passwordInput = console.readPassword();
            System.out.println(Arrays.toString(passwordInput));

        }*/

        //Serialization
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("serial"))) {
            Person person = new Person("Mahmoud", 26, "Male");
            objectOutputStream.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Deserialization
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("serial"))) {
            Person person = (Person) objectInputStream.readObject();
            System.out.println(person.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static class filter implements FilenameFilter {
        private String ext;

        filter(String ext) {
            this.ext = "." + ext;
        }

        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith(ext);
        }
    }
}
