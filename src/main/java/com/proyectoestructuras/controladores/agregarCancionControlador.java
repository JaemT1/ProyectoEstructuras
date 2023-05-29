package com.proyectoestructuras.controladores;

import com.proyectoestructuras.model.Cancion;
import com.proyectoestructuras.model.RepositorioCancionesFavoritas;
import com.proyectoestructuras.model.Tienda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class agregarCancionControlador implements Initializable {
    Tienda tienda;
    Singleton singleton = Singleton.getInstance();

    boolean presionado = singleton.isPresionado();

    ArrayList<String> datos = singleton.getDatos();
    boolean registrado = singleton.isRegistrado();

    RepositorioCancionesFavoritas repositorioCancionesFavoritas;

    ArrayList<Cancion> listaCanciones = singleton.obtenerListaCanciones();

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

    /*
    Evento que elimina una canción
     */
    @FXML
    void eliminarCancion(ActionEvent event) {

        String nom = txtCodEliminar.getText();
        /*
        Verifica si el código de la canción ingresado existe
         */
        boolean verificarNom = singleton.obtenerNom(nom);

        /*
        Verifica si ingresó un código en el campo de texto.
         */
        if (datosValidosEliminar(nom)) {
            String msj = singleton.eliminarCancion(nom);
            if (verificarNom) {
                if (msj.equalsIgnoreCase("Canción eliminada.")) {
                    singleton.getTienda().getRepositorio().eliminarCancionFavorita(nom);
                    singleton.mostrarMensaje("Canción eliminada", "Canción eliminada",
                            "La canción se ha eliminado correctamente", Alert.AlertType.INFORMATION);
                    limpiar();
                } else {
                    singleton.mostrarMensaje("Canción no eliminada", "Canción no eliminada",
                            msj, Alert.AlertType.WARNING);
                    limpiar();
                }
            } else {
                singleton.mostrarMensaje("Canción no encontrada", "Canción no encontrada",
                        "La canción no se ha encontrado", Alert.AlertType.WARNING);
                limpiar();
            }
        }
        singleton.serializarBinario();
    }

    /*
    Método que verifica que los campos de texto estén llenos.
     */
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

    /*
    Evento que agrega una canción.
     */
    @FXML
    void agregarCancion(ActionEvent event) {
        crearCancion();
    }


    /*
    Método que crea una canción.
     */
    private void crearCancion() {

        String nombreCancion = txtNombreCancion.getText();
        String nombreArtista = txtArtista.getText();
        String nombreAlbum = txtNombreAlbum.getText();
        String anio = txtAnio.getText();
        String duracion = txtDuracion.getText();
        String genero = txtGenero.getText();
        String url = txtURL.getText();
        String codigo = txtCodigo.getText();
        /* Se verifica si el código de la canción existe.*/
        boolean verificarCodigo = singleton.obtenerCodigo(codigo);
        Image img = imageViewCancion.getImage();


        /*
        Se verifica si ya se ha subido una imagen.
         */
        if (presionado) {

            /*
            Se verifica si los datos ingresados son válidos.
             */
            if (datosValidosCancion(codigo, nombreCancion, nombreAlbum, img, anio, duracion, genero, url, nombreArtista)) {
                File file = new File(imageViewCancion.getImage().getUrl());
                String cancion = singleton.crearCancion(codigo, nombreCancion, nombreAlbum, file, anio, duracion, genero, url, nombreArtista);

                /*
                Se verifica si la canción no existe, si no existe se crea.
                 */
                if (!verificarCodigo) {

                    if (cancion.equalsIgnoreCase("Canción registrada.")) {
                        singleton.mostrarMensaje("Canción registrada", "Canción registrada",
                                "La canción se ha registrado correctamente", Alert.AlertType.INFORMATION);
                        limpiar();
                    } else if (cancion.equalsIgnoreCase("El artista no existe. Debe crearlo.")) {
                        /*
                        Se verifica si el artista existe, si no existe se abre la interfaz de crear al artista y se crea.
                         */
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Información de creación de canción");
                        alert.setHeaderText(cancion);
                        alert.setContentText("¿Desea crear al artista en este momento?");
                        Optional<ButtonType> action = alert.showAndWait();

                        /*
                        Se guardan temporalmente los datos ingresados de la canción.
                         */
                        datos.add(codigo);
                        datos.add(nombreCancion);
                        datos.add(nombreAlbum);
                        datos.add(anio);
                        datos.add(duracion);
                        datos.add(genero);
                        datos.add(url);
                        singleton.setDatos(datos);
                        singleton.setArtista(nombreArtista);
                        singleton.setImagen(imageViewCancion.getImage());
                        singleton.setPresionado(true);

                        if (action.get() == ButtonType.OK) {
                            singleton.mostrarVentana("Agregar artista", "/views/agregarArtista.fxml", 400, 100);
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

    /*
    Método que carga una imagen.
     */
    private File obtenerImagen() {

        FileChooser cargarImg = new FileChooser();
        cargarImg.setTitle("Insertar imagen");
        cargarImg.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Archivos perzonalizados", "*.jpg; *.png;*.jpeg"));
        File archivo = cargarImg.showOpenDialog(new Stage());

        if (archivo != null) {

            Image img = new Image("file:" + archivo.getPath());
            return archivo;

        }

        return null;
    }


    /*
    Método que verifica que los campos de texto estén llenos.
     */
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


    /*
    Evento que permite regresar al menú principal.
     */
    @FXML
    void regresarMenu(ActionEvent event) {
        singleton.mostrarVentana("MenuPrincipal", "/views/menuPrincipal.fxml", 80, 30);

    }

    /*
    Evento que permite subir una imagen.
     */
    @FXML
    void subirImagen(ActionEvent event) {

        presionado = true;
        Image imagen = new Image("file:" + obtenerImagen().getPath());
        imageViewCancion.setImage(imagen);

    }

    /*
        Método que limpia los campos de texto.
     */
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

    /*
     Método que al inicializar la ventana carga estos datos.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        limpiar();
        /*
        Se verifica si se presionó el botón de agregar artista, si se presionó se cargan los datos ingresados anteriormente.
         */
        if (registrado) {
            singleton.setRegistrado(false);
            txtCodigo.setText(datos.get(0));
            txtNombreCancion.setText(datos.get(1));
            txtNombreAlbum.setText(datos.get(2));
            txtAnio.setText(datos.get(3));
            txtDuracion.setText(datos.get(4));
            txtGenero.setText(datos.get(5));
            txtURL.setText(datos.get(6));
            txtArtista.setText(singleton.getArtista());
            imageViewCancion.setImage(singleton.getImagen());
        }
    }
}
