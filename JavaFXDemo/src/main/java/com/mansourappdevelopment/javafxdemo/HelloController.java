package com.mansourappdevelopment.javafxdemo;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class HelloController {
    @FXML
    private TextField movieNameTextField;
    @FXML
    private TextArea movieDataTextArea;
    @FXML
    private ImageView movePosterImageView;

    @FXML
    protected void onGetDataClick() throws IOException, URISyntaxException, InterruptedException, ExecutionException {
        //replace KEY with OMDB KEY
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://www.omdbapi.com/?apikey=KEY" + movieNameTextField.getText()))
                .GET()
                .build();

        CompletableFuture<HttpResponse<String>> response = HttpClient.newBuilder()
                .build()
                .sendAsync(request, HttpResponse.BodyHandlers.ofString());


        String res;
        res = response.get().body().replace("{", "");
        res = res.replace("}", "");
        StringBuilder stringBuilder = new StringBuilder();
        String[] arr = res.split(":");
        for (String element : arr) {
            stringBuilder.append(element.replace("\",", "\n").replace("\"", "")).append("\n");
        }
        movieDataTextArea.setText(stringBuilder.toString());
        System.out.println(stringBuilder.substring(stringBuilder.toString().indexOf("http"), stringBuilder.toString().indexOf(".jpg") + 4));
        Image image = new Image(stringBuilder.substring(stringBuilder.toString().indexOf("http"), stringBuilder.toString().indexOf(".jpg") + 4));
        movePosterImageView.setImage(image);


        /*
        URL url = new URL("http://www.omdbapi.com/?apikey=KEY" + movieNameTextField.getText());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            StringBuilder stringBuilder = new StringBuilder();
            String[] arr = response.toString().split(",");
            for (String element : arr) {
                stringBuilder.append(element).append("\n");
            }
            movieDataTextArea.setText(stringBuilder.toString());
        } else {
            movieDataTextArea.setText(String.valueOf("GET request not worked"));
        }*/
    }

}
