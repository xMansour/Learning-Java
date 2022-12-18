import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Main {
    private static HttpClient client;

    public static void main(String[] args) {
        //Link Validator
        client = HttpClient.newHttpClient();
        try {
            Files.lines(Path.of("links.txt"))
                    .map(Main::validateLink)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("================================================================================================================");
        System.out.println("THE SYNC CODE TAKES 8 SECONDS TO COMPLETE WHILE THE ASYNC CODE TAKES JUST 1 SECOND TO COMPLETE.");
        System.out.println("================================================================================================================");
        try {
            Files.lines(Path.of("links.txt"))
                    .map(Main::validateLinkAsync).toList().stream().map(CompletableFuture::join).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static CompletableFuture<String> validateLinkAsync(String link) {
        HttpRequest request = HttpRequest
                .newBuilder(URI.create(link))
                .GET()
                .build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.discarding())
                .thenApply(Main::responseToString)
                .exceptionally(e -> String.format("%s -> %s", link, false));    //If the completableFuture ended with an exception.
    }

    private static String validateLink(String link) {
        HttpRequest request = HttpRequest
                .newBuilder(URI.create(link))
                .GET()
                .build();
        try {
            HttpResponse<Void> response = client.send(request, HttpResponse.BodyHandlers.discarding());
            return responseToString(response);
        } catch (IOException | InterruptedException e) {
            return String.format("%s -> %s", link, false);
        }
    }

    private static String responseToString(HttpResponse<Void> response) {
        int status = response.statusCode();
        boolean success = status >= 200 && status <= 299;
        return String.format("%s -> %s (status =%s)", response.uri(), success, status);
    }
}