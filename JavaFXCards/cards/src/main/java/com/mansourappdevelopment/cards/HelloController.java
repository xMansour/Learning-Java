package com.mansourappdevelopment.cards;

import com.mansourappdevelopment.cards.api.Utils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class HelloController implements Initializable {
    @FXML
    private GridPane gridPane;
    @FXML
    private ImageView imageView;

    @FXML
    private void onHelloButtonClick() throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(new URI("http://www.omdbapi.com/?apikey=" + Utils.API_KEY + "&t=Joker"))
                .GET()
                .build();
        HttpResponse<String> response = HttpClient
                .newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());

        String body = response.body();
        int posterIndex = body.indexOf("https");
        int posterLastIndex = body.indexOf("\"", posterIndex);
        String posterURL = body.substring(posterIndex, posterLastIndex);
        imageView.setImage(new Image(posterURL));


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            List<URI> movies = List.of(new URI("http://www.omdbapi.com/?apikey=" + Utils.API_KEY + "&t=" + "Joker"),
                    new URI("http://www.omdbapi.com/?apikey=" + Utils.API_KEY + "&t=" + "Manchester+by+the+sea"),
                    new URI("http://www.omdbapi.com/?apikey=" + Utils.API_KEY + "&t=" + "Interstellar"));
            HttpClient client = HttpClient.newHttpClient();
            List<CompletableFuture<String>> responses = movies
                    .stream()
                    .map(movie -> client
                            .sendAsync(
                                    HttpRequest.newBuilder(movie).GET().build(),
                                    HttpResponse.BodyHandlers.ofString()
                            ).thenApply(HttpResponse::body)).toList();

            System.out.println("sync code");
            ImageView imageView;
            Pane paneContainer;
            for (int i = 0; i < responses.size(); i++) {
                String body = responses.get(i).get().toString();
                System.out.println("body = " + body);
                int posterIndex = body.indexOf("https");
                int posterLastIndex = body.indexOf("\"", posterIndex);
                String posterURL = body.substring(posterIndex, posterLastIndex);
                imageView = new ImageView(new Image(posterURL));
                paneContainer = new Pane();
                //paneContainer.setStyle("-fx-background-color: aqua; -fx-border-style: solid; -fx-border-width: 1px; -fx-border-color:#000; ");
                //paneContainer.setPrefWidth(200);
                //paneContainer.setPrefHeight(100);
                paneContainer.getChildren().add(imageView);
                gridPane.add((paneContainer), i, 0);
            }
        } catch (URISyntaxException | InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        int x= 's';
        System.out.println(x);
    }
}