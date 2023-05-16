module com.proyectoestructuras.main {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.desktop;

    opens com.proyectoestructuras.main to javafx.graphics, javafx.fxml;
    exports com.proyectoestructuras.main;
    exports com.proyectoestructuras.model;
}