package com.proyectoestructuras.main;

import com.proyectoestructuras.controladores.Singleton;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Aplicacion extends Application {

    private Stage primaryStage;
    Singleton singleton = Singleton.getInstance();

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;
        singleton.setAplicacion(this);
        mostrarVentana("Inicio", "/views/inicio.fxml",650,200);
        PauseTransition pause = new PauseTransition(Duration.seconds(3));

        // Cuando se complete la pausa, se ejecuta el siguiente código
        pause.setOnFinished(event -> {
            // Crear una transición de desvanecimiento
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), primaryStage.getScene().getRoot());
            fadeTransition.setFromValue(1.0);
            fadeTransition.setToValue(0.0);
            fadeTransition.setOnFinished(fadeEvent -> {
                mostrarVentana("Menu Principal", "/views/menuPrincipal.fxml",80,30);
            });

            // Iniciar la transición de desvanecimiento
            fadeTransition.play();
        });
        // Iniciar la transición de pausa
        pause.play();
    }

    public void mostrarVentana(String titulo, String ruta, double ancho, double alto) {

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource(ruta));
            AnchorPane anchorPane = (AnchorPane) loader.load();

            Scene scene = new Scene(anchorPane);
            primaryStage.setScene(scene);
            primaryStage.getIcons().add(new Image(Aplicacion.class.getResource("/imagenes/icono.png").toString()));
            primaryStage.setResizable(false);
            primaryStage.setTitle(titulo);
            primaryStage.show();
            primaryStage.setX(ancho);
            primaryStage.setY(alto);

        } catch (IOException e) {

        }
    }


    public static void main(String[] args) {
        launch(args);

    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}