module com.mansourappdevelopment.javafxdemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.net.http;
    opens com.mansourappdevelopment.javafxdemo to javafx.fxml;
    exports com.mansourappdevelopment.javafxdemo;
}