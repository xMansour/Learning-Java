import java.io.*;

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
