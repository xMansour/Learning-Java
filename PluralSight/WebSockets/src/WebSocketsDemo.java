import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.CountDownLatch;

public class WebSocketsDemo {
    public static void main(String[] args) {
        int messagesCount = 5;
        CountDownLatch receiveLatch = new CountDownLatch(messagesCount);
        CompletableFuture<WebSocket> webSocketCompletableFuture = HttpClient.newHttpClient()
                .newWebSocketBuilder()
                .connectTimeout(Duration.ofSeconds(3))
                .buildAsync(URI.create("wss://ws.postman-echo.com/raw"), new WebSocket.Listener() {
                    @Override
                    public void onOpen(WebSocket webSocket) {
                        WebSocket.Listener.super.onOpen(webSocket);
                        System.out.println("WebSocket Opened!");
                    }

                    @Override
                    public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
                        System.out.println("WebSocketsDemo.onText: "+ data);
                        receiveLatch.countDown();
                        return WebSocket.Listener.super.onText(webSocket, data, last);
                    }

                    @Override
                    public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
                        System.out.println("WebSocket Closed!");
                        return WebSocket.Listener.super.onClose(webSocket, statusCode, reason);

                    }
                });

        webSocketCompletableFuture.thenAccept(webSocket -> {
            webSocket.request(messagesCount);
            for (int i = 0; i < messagesCount; i++) {
                webSocket.sendText("Message: " + i, true);
            }
        });

        try {
            receiveLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}