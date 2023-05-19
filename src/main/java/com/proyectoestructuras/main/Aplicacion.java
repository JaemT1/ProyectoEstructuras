package com.proyectoestructuras.main;

import com.proyectoestructuras.controladores.Singleton;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Aplicacion extends Application {

    private Stage primaryStage;
    Singleton singleton = Singleton.getInstance();

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;
        singleton.setAplicacion(this);
        mostrarVentana("MenuPrincipal","/views/menuPrincipal.fxml");

    }

    public void mostrarVentana(String titulo, String ruta) {

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource(ruta));
            AnchorPane anchorPane = (AnchorPane) loader.load();

            Scene scene = new Scene(anchorPane);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.setTitle(titulo);
            primaryStage.show();

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