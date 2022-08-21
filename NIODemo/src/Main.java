import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

public class Main {
    public static void main(String[] args) {
        //Reading a file using NIO
        Path filePath = Path.of("getMovieNames.java");
        try (SeekableByteChannel channel = Files.newByteChannel(filePath)) {
            ByteBuffer buffer = ByteBuffer.allocate(128);
            int count;
            do {
                count = channel.read(buffer);
                if (count != -1) {
                    buffer.rewind();
                    for (int i = 0; i < count; i++) {
                        System.out.print((char) buffer.get());
                    }
                }

            } while (count != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String words = "To be Written to a file";
        //Writing to a file using NIO
        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(Path.of("test.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            ByteBuffer buffer = ByteBuffer.allocate(words.length());
            for (int i = 0; i < words.length(); i++) {
                buffer.put((byte) words.charAt(i));
            }
            buffer.rewind();
            fileChannel.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*Path fileToCopy = Path.of("src/Main.java");
        Path pathToCopyTo = Path.of("src");
        try {
            Files.copy(fileToCopy, pathToCopyTo, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }*/



    }
}
