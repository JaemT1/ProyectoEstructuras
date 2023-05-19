package com.proyectoestructuras.controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class agregarCancionControlador {

    Singleton singleton = Singleton.getInstance();
    @FXML
    private Button btnAgregarCancion;

    @FXML
    private Button btnRegresarMenu;

    @FXML
    private Button btnSubirImagen;

    @FXML
    private ImageView imageViewCancion;

    @FXML
    private TextField txtAnio;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtDuracion;

    @FXML
    private TextField txtGenero;

    @FXML
    private TextField txtNombreAlbum;

    @FXML
    private TextField txtNombreCancion;

    @FXML
    private TextField txtURL;

    @FXML
    void agregarCancion(ActionEvent event) {

    }

    @FXML
    void regresarMenu(ActionEvent event) {
        singleton.mostrarVentana("MenuPrincipal","/views/menuPrincipal.fxml");

    }

    @FXML
    void subirImagen(ActionEvent event) {

    }

}
