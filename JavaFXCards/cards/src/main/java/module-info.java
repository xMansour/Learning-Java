module com.mansourappdevelopment.cards {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires org.controlsfx.controls;

    opens com.mansourappdevelopment.cards to javafx.fxml;
    exports com.mansourappdevelopment.cards;
}