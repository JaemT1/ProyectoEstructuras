module com.proyectoestructuras.main {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.desktop;


    opens com.proyectoestructuras.main to javafx.graphics, javafx.fxml;
    exports com.proyectoestructuras.main;
    exports com.proyectoestructuras.controladores;
    opens com.proyectoestructuras.controladores to javafx.fxml;

}
/**module com.example.wordsearchgame1 {

        requires javafx.controls;
        requires javafx.fxml;



        opens com.example.wordsearchgame1 to javafx.fxml;
        exports com.example.wordsearchgame1;
        exports com.example.wordsearchgame1.controller;
        opens com.example.wordsearchgame1.controller to javafx.fxml;
        }*/