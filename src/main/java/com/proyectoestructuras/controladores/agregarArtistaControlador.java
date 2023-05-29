package com.proyectoestructuras.controladores;

import com.proyectoestructuras.model.Tienda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class agregarArtistaControlador implements Initializable {
    Tienda tienda;
    Singleton singleton = Singleton.getInstance();

    boolean artistaRegistrado = singleton.isArtistaRegistrado();

    @FXML
    private TextField txtNombreEliminar;

    @FXML
    private Button btnActualizarInfo;

    @FXML
    private Button btnAgregarArtista;

    @FXML
    private Button btnEliminarArtista;

    @FXML
    private Button btnInformacion;

    @FXML
    private Button btnRegresarMenu;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtGrupo;

    @FXML
    private TextField txtNacionalidad;

    @FXML
    private TextField txtNombreArtista;

    /* Evento del botón actualizar la información del artista, se llama al método modificarInformacion.*/
    @FXML
    void actualizarInformacion(ActionEvent event) {
        modificarInformacion();
    }

    /* Método que modifica la información del artista.
     Se verifica que los campos estén llenos y que el artista exista -> se busca por el nombre.
     Si existe, se modifica la demás información excepto el nombre. Si no existe, se muestra un mensaje de error.
     */

    private void modificarInformacion() {
        String codigo = txtCodigo.getText();
        String nombreArtista = txtNombreArtista.getText();
        String nacionalidad = txtNacionalidad.getText();
        String grupoAux = txtGrupo.getText();
        boolean grupo;

        if (grupoAux.equalsIgnoreCase("SI") || grupoAux.equalsIgnoreCase("NO")) {
            grupo = true;
        } else {
            grupo = false;
        }

        /* Se verifica que el artista exista -> mediante el nombre. */
        boolean verificar = singleton.obtenerArtista(nombreArtista);

        /* Se verifica que los campos estén llenos. */
        if (datosValidos(codigo, nombreArtista, nacionalidad, grupo)) {
            String artista = singleton.actualizarArtista(codigo, nombreArtista, nacionalidad, grupo);

            if (verificar) {
                if (artista.equalsIgnoreCase("Artista actualizado.")) {
                    singleton.mostrarMensaje("Artista actualizado", "Artista actualizado", "El artista " + nombreArtista + " ha sido actualizado con éxito.",
                            Alert.AlertType.INFORMATION);
                    limpiar();
                } else {
                    singleton.mostrarMensaje("Artista no actualizado", "Artista no actualizado", artista,
                            Alert.AlertType.ERROR);
                    limpiar();
                }
            } else {
                singleton.mostrarMensaje("Artista no actualizado", "Artista no actualizado", "El artista " + nombreArtista + " no existe.",
                        Alert.AlertType.ERROR);
                limpiar();
            }

        }
    }

    /* Evento del botón agregar artista, se llama al método eliminarArtista.*/
    @FXML
    void agregarArtista(ActionEvent event) {
        crearArtista();
    }

    /* Método que crea un artista.
     Se verifica que los campos estén llenos y que el artista no exista -> se busca por el nombre.
     Si no existe, se crea el artista. Si existe, se muestra un mensaje de error.
     */
    private void crearArtista() {

        String codigo = txtCodigo.getText();
        String nombreArtista = txtNombreArtista.getText();
        String nacionalidad = txtNacionalidad.getText();
        String grupoAux = txtGrupo.getText();
        boolean grupo;

        if (grupoAux.equalsIgnoreCase("SI") || grupoAux.equalsIgnoreCase("NO")) {
            grupo = true;
        } else {
            grupo = false;
        }

        /* Se verifica que el artista no exista -> mediante el nombre y el codigo. */
        boolean verificar = singleton.obtenerCodigoArtista(nombreArtista, codigo);

        if (datosValidos(codigo, nombreArtista, nacionalidad, grupo)) {
            String artista = singleton.crearArtista(codigo, nombreArtista, nacionalidad, grupo);

            if (!verificar) {
                if (artista.equalsIgnoreCase("Artista creado.")) {
                    singleton.mostrarMensaje("Artista agregado", "Artista agregado", "El artista " + nombreArtista + " ha sido agregado con éxito.",
                            Alert.AlertType.INFORMATION);
                    singleton.setRegistrado(true);
                    singleton.setArtistaRegistrado(false);
                    singleton.mostrarVentana("Agregar canción", "/views/agregarCancion.fxml",80,30);
                    limpiar();
                } else {
                    singleton.mostrarMensaje("Artista no agregado", "Artista no agregado", artista,
                            Alert.AlertType.ERROR);
                    limpiar();
                }
            } else {
                singleton.mostrarMensaje("Artista no agregado", "Artista no agregado", "El artista " + nombreArtista + " ya existe.",
                        Alert.AlertType.ERROR);
                limpiar();
            }


        }
    }

    /* Método para limpiar los campos una vez se agrega, elimina o modifica el artista.*/
    private void limpiar() {

        txtCodigo.setText("");
        txtNombreArtista.setText("");
        txtNacionalidad.setText("");
        txtGrupo.setText("");
        txtNombreEliminar.setText("");

    }

    /* Método que verifica si los campos están llenos o no.*/
    private boolean datosValidos(String codigo, String nombreArtista, String nacionalidad, Boolean grupo) {

        String notificacion = "";

        if (codigo == null || codigo.equals("")) {
            notificacion += ("Debe ingresar el código del artista.\n");
        }

        if (nombreArtista == null || nombreArtista.equals("")) {
            notificacion += ("Debe ingresar el nombre del artista.\n");
        }
        if (nacionalidad == null || nacionalidad.equals("")) {
            notificacion += ("Debe ingresar la nacionalidad del artista.\n");
        }

        if (grupo == false) {
            notificacion += ("Recuerde solo ingresar SI / NO.\n");
        }

        if (notificacion.equals("")) {
            return true;
        }

        singleton.mostrarMensaje("Información de agregar invalida", "Información de agregar invalida", notificacion,
                Alert.AlertType.WARNING);

        return false;


    }

    /* Evento que elimina a un artista -> mediante el nombre.*/
    @FXML
    void eliminarArtista(ActionEvent event) {

        String nombre = txtNombreEliminar.getText();

        /* Se captura que el código del artista mediante el nombre. */
        String codigoAuxiliar = singleton.obtenerCodArtista(nombre);
        /* Se verifica que el artista exista -> mediante el nombre y el codigo. */
        boolean verificarCodigo = singleton.obtenerCodigoArtista(nombre, codigoAuxiliar);

        if (datosValidosEliminar(nombre)) {
            String mensaje = singleton.eliminarArtista(nombre);
            if (verificarCodigo) {
                if (mensaje.equalsIgnoreCase("Artista eliminado.")) {
                    singleton.mostrarMensaje("Artista eliminado", "Artista eliminado",
                            "El artista se ha eliminado correctamente", Alert.AlertType.INFORMATION);
                } else {
                    singleton.mostrarMensaje("Artista no eliminado", "Artista no eliminado",
                            mensaje, Alert.AlertType.WARNING);
                }
            } else {
                singleton.mostrarMensaje("Artista no encontrado", "Artista no encontrado",
                        "El artista no se ha encontrado", Alert.AlertType.WARNING);
            }
        }

    }


    /* Método que verifica si los campos están llenos o no.*/
    private boolean datosValidosEliminar(String nombre) {

        String notificacion = "";

        if (nombre == null || nombre.equals("")) {
            notificacion += ("Debe ingresar el nombre del artista que desea eliminar.\n");
        }

        if (notificacion.equals("")) {
            return true;
        }

        singleton.mostrarMensaje("Información de eliminar invalida", "Información de eliminar invalida", notificacion,
                Alert.AlertType.WARNING);

        return false;
    }


    /* Evento que muestra una alerta con la información de actualización de datos.*/
    @FXML
    void mostrarInformacion(ActionEvent event) {

        singleton.mostrarMensaje("Información", "Información de actualización de datos", "Para actualizar la información de un artista, ingrese el nombre del artista" +
                        " y modifique todos los datos.",
                Alert.AlertType.INFORMATION);

    }

    /* Evento que permite regresar al menú principal.*/
    @FXML
    void regresarMenu(ActionEvent event) {

        singleton.mostrarVentana("Menu Principal", "/views/menuPrincipal.fxml",80,30);

    }

    /* Método que inicializa datos una vez se abre la ventana.*/
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if(artistaRegistrado) {
            String nombre = singleton.getArtista();
            txtNombreArtista.setText(nombre);
        }else{
            limpiar();
        }
    }
}
