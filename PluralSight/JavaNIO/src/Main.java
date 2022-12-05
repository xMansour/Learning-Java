import models.Line;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Path readPath = Path.of("files/inputFile.txt");
        try (BufferedReader bufferedReader = Files.newBufferedReader(readPath)) {
            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path writePath = Path.of("files/outputFile.txt");
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(writePath)) {
            bufferedWriter.write("Line 0\n");
            for (int i = 1; i <= 5; i++) {
                bufferedWriter.write("Line " + i + "\n");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        //CSV files

        Path csvFilePath = Path.of("files/RackData.csv");
        try (BufferedReader csvBufferedReader = Files.newBufferedReader(csvFilePath)) {
            String line = csvBufferedReader.readLine();
            while (line != null) {
                String[] elements = line.split(",");
                Line lineObj = new Line(elements[0], elements[1], elements[2], elements[3], elements[4], elements[5], elements[6],
                        elements[7], elements[8], elements[9], elements[10], elements[11]);
                line = csvBufferedReader.readLine();
                System.out.println(lineObj);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        System.out.println("-----------------");

        //Finding files that has been changed in the last 2 hours.
        Instant twoHoursAgo = Instant.now().minus(Duration.ofHours(2));
        Path dir = Path.of("files");
        try (Stream<Path> stream = Files.find(dir, 3, (path, attributes) -> attributes.lastModifiedTime().toInstant().isAfter(twoHoursAgo))) {
            stream.forEach(System.out::println);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        //Counting the number of files in the dir path above.
        long filesCount = 0;
        long dirCount = 0;
        try {
            filesCount = Files.walk(dir).filter(path -> Files.isRegularFile(path)).count();
            dirCount = Files.walk(dir).filter(Files::isDirectory).count();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Files Count: " + filesCount);
        System.out.println("Directories Count: " + dirCount);
    }
}