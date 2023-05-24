package com.proyectoestructuras.controladores;

import com.proyectoestructuras.model.Tienda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.Optional;

public class agregarCancionControlador {
    Tienda tienda;
    Singleton singleton = Singleton.getInstance();

    boolean presionado = false;
    @FXML
    private Button btnAgregarCancion;

    @FXML
    private Button btnRegresarMenu;

    @FXML
    private Button btnSubirImagen;

    @FXML
    private Button btnEliminarCancion;

    @FXML
    private ImageView imageViewCancion;

    @FXML
    private TextField txtAnio;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtCodEliminar;

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
    private TextField txtArtista;

    @FXML
    void eliminarCancion(ActionEvent event) {

        String cod = txtCodEliminar.getText();
        boolean verificarCodigo = singleton.obtenerCodigo(cod);
        if (datosValidosEliminar(cod)) {
            String msj = singleton.eliminarCancion(cod);
            if (verificarCodigo) {
                if(msj.equalsIgnoreCase("Canción eliminada.")) {
                    singleton.mostrarMensaje("Canción eliminada", "Canción eliminada",
                            "La canción se ha eliminado correctamente", Alert.AlertType.INFORMATION);
                    limpiar();
                }else{
                    singleton.mostrarMensaje("Canción no eliminada", "Canción no eliminada",
                            msj, Alert.AlertType.WARNING);
                    limpiar();
                }
            }else{
                singleton.mostrarMensaje("Canción no encontrada", "Canción no encontrada",
                        "La canción no se ha encontrado", Alert.AlertType.WARNING);
                limpiar();
            }
        }
    }

    private boolean datosValidosEliminar(String cod) {

        String notificacion = "";

        if (cod == null || cod.equals("")) {
            notificacion += ("Debe ingresar el código de la canción que desea eliminar.\n");
        }

        if (notificacion.equals("")) {
            return true;
        }

        singleton.mostrarMensaje("Información de eliminar invalida", "Información de eliminar invalida", notificacion,
                Alert.AlertType.WARNING);

        return false;
    }

    @FXML
    void agregarCancion(ActionEvent event) {
        crearCancion();
    }


    private void crearCancion() {

        String nombreCancion = txtNombreCancion.getText();
        String nombreArtista = txtArtista.getText();
        String nombreAlbum = txtNombreAlbum.getText();
        String anio = txtAnio.getText();
        String duracion = txtDuracion.getText();
        String genero = txtGenero.getText();
        String url = txtURL.getText();
        String codigo = txtCodigo.getText();
        boolean verificarCodigo = singleton.obtenerCodigo(codigo);

        if (presionado) {

            if (datosValidosCancion(codigo, nombreCancion, nombreAlbum, imageViewCancion.getImage(), anio, duracion, genero, url, nombreArtista)) {
                String cancion = singleton.crearCancion(codigo, nombreCancion, nombreAlbum, imageViewCancion.getImage(), anio, duracion, genero, url, nombreArtista);

                if (!verificarCodigo) {

                    if (cancion.equalsIgnoreCase("Canción registrada.")) {
                        singleton.mostrarMensaje("Canción registrada", "Canción registrada",
                                "La canción se ha registrado correctamente", Alert.AlertType.INFORMATION);
                        limpiar();
                    } else if (cancion.equalsIgnoreCase("El artista no existe. Debe crearlo.")) {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Información de creación de canción");
                        alert.setHeaderText(cancion);
                        alert.setContentText("¿Desea crear al artista en este momento?");
                        Optional<ButtonType> action = alert.showAndWait();

                        if (action.get() == ButtonType.OK) {
                            singleton.mostrarVentana("Agregar artista", "/views/agregarArtista.fxml");
                        }
                        limpiar();

                    } else {
                        singleton.mostrarMensaje("Canción inválida", "Canción no creada",
                                "La canción ya se encuentra registrada", Alert.AlertType.WARNING);
                        limpiar();
                    }
                } else {
                    singleton.mostrarMensaje("Canción inválida", "Canción no creada",
                            "La canción ya se encuentra registrada", Alert.AlertType.WARNING);
                    limpiar();
                }
            }
        } else {
            singleton.mostrarMensaje("Canción inválida", "Canción no creada",
                    "Debe subir una imagen para agregar la canción", Alert.AlertType.WARNING);
        }
        singleton.serializarBinario();

    }

    private Image obtenerImagen() {

        FileChooser cargarImg = new FileChooser();
        cargarImg.setTitle("Insertar imagen");
        cargarImg.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG", "*.jpg"));
        File archivo = cargarImg.showOpenDialog(new Stage());

        if (archivo != null) {

            Image img = new Image("file:" + archivo.getAbsolutePath());
            return img;

        }

        return null;
    }


    private boolean datosValidosCancion(String codigo, String nombreCancion, String nombreAlbum, Image imagen, String anio, String duracion, String genero, String url, String nombreArtista) {
        String notificacion = "";

        if (nombreCancion == null || nombreCancion.equals("")) {
            notificacion += ("Debe ingresar el nombre de la canción.\n");
        }

        if (nombreArtista == null || nombreArtista.equals("")) {
            notificacion += ("Debe ingresar el nombre del artista.\n");
        }
        if (nombreAlbum == null || nombreAlbum.equals("")) {
            notificacion += ("Debe ingresar el nombre del álbum.\n");
        }

        if (anio == null || anio.equals("")) {
            notificacion += ("Debe ingresar el año de la canción.\n");
        }

        if (duracion == null || duracion.equals("")) {
            notificacion += ("Debe ingresar la duración de la canción.\n");
        }

        if (genero == null || genero.equals("")) {
            notificacion += ("Debe ingresar un género.\n");
        }

        if (url == null || url.equals("")) {
            notificacion += ("Debe ingresar una url.\n");
        }

        if (codigo == null || codigo.equals("")) {
            notificacion += ("Debe ingresar un código.\n");
        }

        if (imagen == null) {
            notificacion += ("Debe ingresar una imagen.\n");
        }

        if (notificacion.equals("")) {
            return true;
        }

        singleton.mostrarMensaje("Información de agregar invalida", "Información de agregar invalida", notificacion,
                Alert.AlertType.WARNING);

        return false;


    }


    @FXML
    void regresarMenu(ActionEvent event) {
        singleton.mostrarVentana("MenuPrincipal", "/views/menuPrincipal.fxml");

    }

    @FXML
    void subirImagen(ActionEvent event) {

        presionado = true;
        Image imagen = obtenerImagen();
        imageViewCancion.setImage(imagen);


    }

    void limpiar() {
        txtAnio.setText("");
        txtArtista.setText("");
        txtCodigo.setText("");
        txtDuracion.setText("");
        txtGenero.setText("");
        txtNombreAlbum.setText("");
        txtNombreCancion.setText("");
        txtURL.setText("");
        imageViewCancion.setImage(null);
        txtCodEliminar.setText("");
    }

}
