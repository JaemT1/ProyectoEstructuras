package com.proyectoestructuras.controladores;

import com.proyectoestructuras.main.Aplicacion;
import com.proyectoestructuras.model.Cancion;
import com.proyectoestructuras.model.Tienda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class menuPrincipalControlador implements Initializable {

    Tienda tienda;
    Singleton singleton = Singleton.getInstance();
    @FXML
    private Button btnAgregarArtista;

    @FXML
    private Button btnAgregarCancion;

    @FXML
    private Button btnAgregarFavs;

    @FXML
    private Button btnBuscarArtista;

    @FXML
    private Button btnBuscarCancion;

    @FXML
    private Button btnCancion1;

    @FXML
    private Button btnCancion10;

    @FXML
    private Button btnCancion11;

    @FXML
    private Button btnCancion12;

    @FXML
    private Button btnCancion13;

    @FXML
    private Button btnCancion14;

    @FXML
    private Button btnCancion15;

    @FXML
    private Button btnCancion16;

    @FXML
    private Button btnCancion2;

    @FXML
    private Button btnCancion3;

    @FXML
    private Button btnCancion4;

    @FXML
    private Button btnCancion5;

    @FXML
    private Button btnCancion6;

    @FXML
    private Button btnCancion7;

    @FXML
    private Button btnCancion8;

    @FXML
    private Button btnCancion9;

    @FXML
    private Button btnFavoritos;

    @FXML
    private Button btnReproducir;

    @FXML
    private Button btnAplicarFiltros;

    @FXML
    private ImageView imageView1;

    @FXML
    private ImageView imageView10;

    @FXML
    private ImageView imageView11;

    @FXML
    private ImageView imageView12;

    @FXML
    private ImageView imageView13;

    @FXML
    private ImageView imageView14;

    @FXML
    private ImageView imageView15;

    @FXML
    private ImageView imageView16;

    @FXML
    private ImageView imageView2;

    @FXML
    private ImageView imageView3;

    @FXML
    private ImageView imageView4;

    @FXML
    private ImageView imageView5;

    @FXML
    private ImageView imageView6;

    @FXML
    private ImageView imageView7;

    @FXML
    private ImageView imageView8;

    @FXML
    private ImageView imageView9;

    @FXML
    private ImageView imagenAgregar;

    @FXML
    private ImageView imagenInfo;

    @FXML
    private ImageView imagenReproducir;

    @FXML
    private Label info;

    @FXML
    private Label infoCancion;

    @FXML
    private TreeView<Object> treeViewFiltros;

    @FXML
    private TextField txtBuscarArtista;

    @FXML
    private TextField txtBuscarCancion;

    @FXML
    private Separator separator;

    @FXML
    private CheckBox genero1 = new CheckBox("Rock");
    @FXML
    private CheckBox genero2 = new CheckBox("Pop");
    @FXML
    private CheckBox genero3 = new CheckBox("Reggaetón");
    @FXML
    private CheckBox genero4 = new CheckBox("Electrónica");
    @FXML
    private CheckBox genero5 = new CheckBox("Punk");
    private CheckBox anio1 = new CheckBox("1900 - 1950");
    @FXML
    private CheckBox anio2 = new CheckBox("1951 - 2000");
    @FXML
    private CheckBox anio3 = new CheckBox("2001 - 2021");


    @FXML
    void agregarAFavoritos(ActionEvent event) {

    }

    @FXML
    void agregarArtista(ActionEvent event) {

    }

    @FXML
    void agregarCancion(ActionEvent event) {

        singleton.mostrarVentana("Agregar Canción","/views/agregarCancion.fxml");

    }

    @FXML
    void buscarArtista(ActionEvent event) {

    }

    @FXML
    void buscarCancion(ActionEvent event) {

    }

    @FXML
    void cancionesFavoritas(ActionEvent event) {

    }

    @FXML
    void mostrarInfoCancion1(ActionEvent event) {

    }

    @FXML
    void mostrarInfoCancion10(ActionEvent event) {

    }

    @FXML
    void mostrarInfoCancion11(ActionEvent event) {

    }

    @FXML
    void mostrarInfoCancion12(ActionEvent event) {

    }

    @FXML
    void mostrarInfoCancion13(ActionEvent event) {

    }

    @FXML
    void mostrarInfoCancion14(ActionEvent event) {

    }

    @FXML
    void mostrarInfoCancion15(ActionEvent event) {

    }

    @FXML
    void mostrarInfoCancion16(ActionEvent event) {

        mostrarInformacion(0);

    }

    @FXML
    void mostrarInfoCancion2(ActionEvent event) {

    }

    @FXML
    void mostrarInfoCancion3(ActionEvent event) {

    }

    @FXML
    void mostrarInfoCancion4(ActionEvent event) {

    }

    @FXML
    void mostrarInfoCancion5(ActionEvent event) {

    }

    @FXML
    void mostrarInfoCancion6(ActionEvent event) {

    }

    @FXML
    void mostrarInfoCancion7(ActionEvent event) {

    }

    @FXML
    void mostrarInfoCancion8(ActionEvent event) {

    }

    @FXML
    void mostrarInfoCancion9(ActionEvent event) {

    }

    @FXML
    void reproducirCancion(ActionEvent event) {

    }

    @FXML
    void aplicarFiltros(ActionEvent event) {

    }

    private void mostrarInformacion(int indice) {
        tienda = new Tienda();

        //Cada boton tiene asignada una cancion en especifico,
        // por lo tanto se pasa por parametro el indice de donde se encuentra dicha cancion en la lista.

        ArrayList<Cancion> lista = tienda.getListaCanciones();
        if (indice >= 0 && indice < lista.size()) {
            String infoAux = lista.get(indice).toString();
            Image imageAux = lista.get(indice).getCaratula();
            info.opacityProperty().setValue(100);
            infoCancion.opacityProperty().setValue(100);
            infoCancion.setText(infoAux);
            imagenInfo.opacityProperty().setValue(100);
            imagenInfo.setImage(imageAux);
            btnAgregarFavs.opacityProperty().setValue(100);
            btnReproducir.opacityProperty().setValue(100);
            imagenAgregar.opacityProperty().setValue(100);
            imagenReproducir.opacityProperty().setValue(100);
            separator.opacityProperty().setValue(100);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        treeViewFiltros.setRoot(agregarElementos());

    }

    private TreeItem<Object> agregarElementos() {

        TreeItem<Object> arbolPrincipal = new TreeItem<>("Filtros");

        TreeItem<Object> generos = new TreeItem<>("Géneros musicales");

        TreeItem<Object> anios = new TreeItem<>("Años");

        TreeItem<Object> gen1 = new TreeItem<>(genero1);
        TreeItem<Object> gen2 = new TreeItem<>(genero2);
        TreeItem<Object> gen3 = new TreeItem<>(genero3);
        TreeItem<Object> gen4 = new TreeItem<>(genero4);
        TreeItem<Object> gen5 = new TreeItem<>(genero5);

        TreeItem<Object> an1 = new TreeItem<>(anio1);
        TreeItem<Object> an2 = new TreeItem<>(anio2);
        TreeItem<Object> an3 = new TreeItem<>(anio3);

        generos.getChildren().addAll(gen1, gen2, gen3, gen4, gen5);
        anios.getChildren().addAll(an1, an2, an3);
        arbolPrincipal.getChildren().addAll(generos, anios);

        return arbolPrincipal;
    }
}
