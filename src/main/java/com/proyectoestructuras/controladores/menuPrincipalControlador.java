package com.proyectoestructuras.controladores;

import com.proyectoestructuras.ListadDoblementeEnlazada.ListaDoblementeEnlazada;
import com.proyectoestructuras.main.Aplicacion;
import com.proyectoestructuras.model.ArbolBinarioArtistas;
import com.proyectoestructuras.model.Cancion;
import com.proyectoestructuras.model.Tienda;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Set;


public class menuPrincipalControlador implements Initializable {

    Tienda tienda;
    Singleton singleton = Singleton.getInstance();

    ArrayList<ImageView> imagenes = new ArrayList<>();
    ArrayList<Image> imagenesIniciales = new ArrayList<>();
    ArrayList<Button> botones = new ArrayList<>();
    ArrayList<Cancion> canciones = new ArrayList<>();
    ArrayList<Integer> indices = new ArrayList();

    static boolean bandera = false;
    @FXML
    private Button btnAgregarArtista;

    @FXML
    private Button btnAgregarCancion;

    @FXML
    private Button btnAgregarFavs;

    @FXML
    private Button btnAplicarFiltros;

    @FXML
    private Button btnBuscarArtista;

    @FXML
    private Button btnBuscarCancion;

    @FXML
    private Button btnCancion101;

    @FXML
    private Button btnCancion11;

    @FXML
    private Button btnCancion111;

    @FXML
    private Button btnCancion121;

    @FXML
    private Button btnCancion131;

    @FXML
    private Button btnCancion141;

    @FXML
    private Button btnCancion151;

    @FXML
    private Button btnCancion161;

    @FXML
    private Button btnCancion21;

    @FXML
    private Button btnCancion31;

    @FXML
    private Button btnCancion41;

    @FXML
    private Button btnCancion51;

    @FXML
    private Button btnCancion61;

    @FXML
    private Button btnCancion71;

    @FXML
    private Button btnCancion81;

    @FXML
    private Button btnCancion91;

    @FXML
    private Button btnFavoritos;

    @FXML
    private Button btnReproducir;

    @FXML
    private Button btnLimpiarBusqueda;

    @FXML
    private GridPane gridPaneCanciones;

    @FXML
    private ImageView imageView101;

    @FXML
    private ImageView imageView11;

    @FXML
    private ImageView imageView111;

    @FXML
    private ImageView imageView121;

    @FXML
    private ImageView imageView131;

    @FXML
    private ImageView imageView141;

    @FXML
    private ImageView imageView151;

    @FXML
    private ImageView imageView161;

    @FXML
    private ImageView imageView21;

    @FXML
    private ImageView imageView31;

    @FXML
    private ImageView imageView41;

    @FXML
    private ImageView imageView51;

    @FXML
    private ImageView imageView61;

    @FXML
    private ImageView imageView71;

    @FXML
    private ImageView imageView81;

    @FXML
    private ImageView imageView91;

    @FXML
    private ImageView imagenAgregar;

    @FXML
    private ImageView imagenInfo;

    @FXML
    private ImageView imagenReproducir;

    @FXML
    private Label info;
    @FXML
    private Label titulo;
    @FXML
    private Label infoCancion;

    @FXML
    private Separator separator;

    @FXML
    private TreeView<Object> treeViewFiltros;

    @FXML
    private TextField txtBuscarArtista;

    @FXML
    private TextField txtBuscarCancion;

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

        singleton.mostrarVentana("Agregar Canción", "/views/agregarCancion.fxml");

    }

    @FXML
    void limpiarBusqueda(ActionEvent event) {

        imagenesIniciales();
        titulo.setText("En tendencia");
        bandera = false;
    }

    @FXML
    void buscarArtista(ActionEvent event) {
        limpiarInformacion();
        ArbolBinarioArtistas arbol = singleton.retornarArbol();
        bandera = true;

        if (arbol.buscar(txtBuscarArtista.getText()) != null) {
            canciones = arbol.buscar(txtBuscarArtista.getText()).getListaCanciones();
            titulo.setText("Canciones de " + txtBuscarArtista.getText());
            actualizarImagenes(canciones);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Artista no encontrado");
            alert.setContentText("El artista que busca no se encuentra en la aplicación.");
            alert.showAndWait();
            limpiar();
            limpiarInformacion();
        }
    }

    private void actualizarImagenes(ArrayList<Cancion> canciones) {
        limpiar();
        int cantidad = canciones.size();

        for (int i = 0; i < imagenes.size(); i++) {
            if (i < cantidad) {
                imagenes.get(i).setImage(canciones.get(i).getCaratula());
                botones.get(i).setVisible(true);
                imagenes.get(i).setOpacity(100);
            } else {
                imagenes.get(i).setOpacity(0);
                botones.get(i).setVisible(false);
            }
        }

        definirIndices();
    }


    private void definirIndices() {
        int indice;

        indices = new ArrayList();
        for (int i = 0; i < imagenes.size(); i++) {
            for (int j = 0; j < canciones.size(); j++) {
                if (imagenes.get(i).getImage().equals(canciones.get(j).getCaratula())) {
                    indice = canciones.get(j).getIndice();
                    indices.add(indice);
                }
            }
        }
    }


    @FXML
    void buscarCancion(ActionEvent event) {

    }

    @FXML
    void cancionesFavoritas(ActionEvent event) {

    }

    @FXML
    void mostrarInfoCancion1(ActionEvent event) {

        if (!bandera) {
            mostrarInformacion(4);
        } else {
            Image aux = imageView11.getImage();
            for (int j = 0; j < canciones.size(); j++) {
                if (aux.equals(canciones.get(j).getCaratula())) {
                    mostrarInformacion(canciones.get(j).getIndice());
                }
            }
        }

    }

    @FXML
    void mostrarInfoCancion10(ActionEvent event) {
        if (!bandera) {
            mostrarInformacion(13);
        } else {
            Image aux = imageView101.getImage();
            for (int j = 0; j < canciones.size(); j++) {
                if (aux.equals(canciones.get(j).getCaratula())) {
                    mostrarInformacion(canciones.get(j).getIndice());
                }
            }
        }

    }

    @FXML
    void mostrarInfoCancion11(ActionEvent event) {
        if (!bandera) {
            mostrarInformacion(5);
        } else {
            Image aux = imageView111.getImage();
            for (int j = 0; j < canciones.size(); j++) {
                if (aux.equals(canciones.get(j).getCaratula())) {
                    mostrarInformacion(canciones.get(j).getIndice());
                }
            }
        }

    }

    @FXML
    void mostrarInfoCancion12(ActionEvent event) {
        if (!bandera) {
            mostrarInformacion(14);
        } else {
            Image aux = imageView121.getImage();
            for (int j = 0; j < canciones.size(); j++) {
                if (aux.equals(canciones.get(j).getCaratula())) {
                    mostrarInformacion(canciones.get(j).getIndice());
                }
            }
        }
    }

    @FXML
    void mostrarInfoCancion13(ActionEvent event) {
        if (!bandera) {
            mostrarInformacion(10);
        } else {
            Image aux = imageView131.getImage();
            for (int j = 0; j < canciones.size(); j++) {
                if (aux.equals(canciones.get(j).getCaratula())) {
                    mostrarInformacion(canciones.get(j).getIndice());
                }
            }
        }
    }

    @FXML
    void mostrarInfoCancion14(ActionEvent event) {
        if (!bandera) {
            mostrarInformacion(16);
        } else {
            Image aux = imageView141.getImage();
            for (int j = 0; j < canciones.size(); j++) {
                if (aux.equals(canciones.get(j).getCaratula())) {
                    mostrarInformacion(canciones.get(j).getIndice());
                }
            }
        }
    }

    @FXML
    void mostrarInfoCancion15(ActionEvent event) {
        if (!bandera) {
            mostrarInformacion(22);
        } else {
            Image aux = imageView151.getImage();
            for (int j = 0; j < canciones.size(); j++) {
                if (aux.equals(canciones.get(j).getCaratula())) {
                    mostrarInformacion(canciones.get(j).getIndice());
                }
            }
        }
    }

    @FXML
    void mostrarInfoCancion16(ActionEvent event) {

        if (!bandera) {
            mostrarInformacion(0);
        } else {
            Image aux = imageView161.getImage();
            for (int j = 0; j < canciones.size(); j++) {
                if (aux.equals(canciones.get(j).getCaratula())) {
                    mostrarInformacion(canciones.get(j).getIndice());
                }
            }
        }

    }

    @FXML
    void mostrarInfoCancion2(ActionEvent event) {
        if (!bandera) {
            mostrarInformacion(3);
        } else {
            Image aux = imageView21.getImage();
            for (int j = 0; j < canciones.size(); j++) {
                if (aux.equals(canciones.get(j).getCaratula())) {
                    mostrarInformacion(canciones.get(j).getIndice());
                }
            }
        }
    }

    @FXML
    void mostrarInfoCancion3(ActionEvent event) {
        if (!bandera) {
            mostrarInformacion(2);
        } else {
            Image aux = imageView31.getImage();
            for (int j = 0; j < canciones.size(); j++) {
                if (aux.equals(canciones.get(j).getCaratula())) {
                    mostrarInformacion(canciones.get(j).getIndice());
                }
            }
        }
    }

    @FXML
    void mostrarInfoCancion4(ActionEvent event) {
        if (!bandera) {
            mostrarInformacion(8);
        } else {
            Image aux = imageView41.getImage();
            for (int j = 0; j < canciones.size(); j++) {
                if (aux.equals(canciones.get(j).getCaratula())) {
                    mostrarInformacion(canciones.get(j).getIndice());
                }
            }
        }
    }

    @FXML
    void mostrarInfoCancion5(ActionEvent event) {
        if (!bandera) {
            mostrarInformacion(6);
        } else {
            Image aux = imageView51.getImage();
            for (int j = 0; j < canciones.size(); j++) {
                if (aux.equals(canciones.get(j).getCaratula())) {
                    mostrarInformacion(canciones.get(j).getIndice());
                }
            }
        }
    }

    @FXML
    void mostrarInfoCancion6(ActionEvent event) {
        if (!bandera) {
            mostrarInformacion(9);
        } else {
            Image aux = imageView61.getImage();
            for (int j = 0; j < canciones.size(); j++) {
                if (aux.equals(canciones.get(j).getCaratula())) {
                    mostrarInformacion(canciones.get(j).getIndice());
                }
            }
        }
    }

    @FXML
    void mostrarInfoCancion7(ActionEvent event) {
        if (!bandera) {
            mostrarInformacion(12);
        } else {
            Image aux = imageView71.getImage();
            for (int j = 0; j < canciones.size(); j++) {
                if (aux.equals(canciones.get(j).getCaratula())) {
                    mostrarInformacion(canciones.get(j).getIndice());
                }
            }
        }
    }

    @FXML
    void mostrarInfoCancion8(ActionEvent event) {
        if (!bandera) {
            mostrarInformacion(19);
        } else {
            Image aux = imageView81.getImage();
            for (int j = 0; j < canciones.size(); j++) {
                if (aux.equals(canciones.get(j).getCaratula())) {
                    mostrarInformacion(canciones.get(j).getIndice());
                }
            }
        }
    }

    @FXML
    void mostrarInfoCancion9(ActionEvent event) {
        if (!bandera) {
            mostrarInformacion(17);
        } else {
            Image aux = imageView91.getImage();
            for (int j = 0; j < canciones.size(); j++) {
                if (aux.equals(canciones.get(j).getCaratula())) {
                    mostrarInformacion(canciones.get(j).getIndice());
                }
            }
        }
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
        imagenesIniciales.add(imageView11.getImage());
        imagenesIniciales.add(imageView21.getImage());
        imagenesIniciales.add(imageView31.getImage());
        imagenesIniciales.add(imageView41.getImage());
        imagenesIniciales.add(imageView51.getImage());
        imagenesIniciales.add(imageView61.getImage());
        imagenesIniciales.add(imageView71.getImage());
        imagenesIniciales.add(imageView81.getImage());
        imagenesIniciales.add(imageView91.getImage());
        imagenesIniciales.add(imageView101.getImage());
        imagenesIniciales.add(imageView111.getImage());
        imagenesIniciales.add(imageView121.getImage());
        imagenesIniciales.add(imageView131.getImage());
        imagenesIniciales.add(imageView141.getImage());
        imagenesIniciales.add(imageView151.getImage());
        imagenesIniciales.add(imageView161.getImage());
        inicializarImagenes();

    }

    private void inicializarImagenes() {
        imagenes.add(imageView11);
        imagenes.add(imageView21);
        imagenes.add(imageView31);
        imagenes.add(imageView41);
        imagenes.add(imageView51);
        imagenes.add(imageView61);
        imagenes.add(imageView71);
        imagenes.add(imageView81);
        imagenes.add(imageView91);
        imagenes.add(imageView101);
        imagenes.add(imageView111);
        imagenes.add(imageView121);
        imagenes.add(imageView131);
        imagenes.add(imageView141);
        imagenes.add(imageView151);
        imagenes.add(imageView161);

        botones.add(btnCancion11);
        botones.add(btnCancion21);
        botones.add(btnCancion31);
        botones.add(btnCancion41);
        botones.add(btnCancion51);
        botones.add(btnCancion61);
        botones.add(btnCancion71);
        botones.add(btnCancion81);
        botones.add(btnCancion91);
        botones.add(btnCancion101);
        botones.add(btnCancion111);
        botones.add(btnCancion121);
        botones.add(btnCancion131);
        botones.add(btnCancion141);
        botones.add(btnCancion151);
        botones.add(btnCancion161);
    }

    private void imagenesIniciales() {

        limpiarInformacion();
        limpiar();
        for (int j = 0; j < imagenesIniciales.size(); j++) {
            Image aux = imagenesIniciales.get(j);
            imagenes.get(j).setOpacity(100);
            imagenes.get(j).setImage(aux);
            botones.get(j).setVisible(true);

        }

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

    public void limpiarInformacion() {

        info.setOpacity(0);
        infoCancion.setText("");
        imagenReproducir.setOpacity(0);
        imagenAgregar.setOpacity(0);
        imagenInfo.setImage(null);
        btnAgregarFavs.setOpacity(0);
        btnReproducir.setOpacity(0);
        separator.setOpacity(0);
    }

    public void limpiar() {
        txtBuscarArtista.setText("");
        txtBuscarCancion.setText("");
    }



}
