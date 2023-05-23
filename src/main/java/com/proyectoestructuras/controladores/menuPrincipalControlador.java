package com.proyectoestructuras.controladores;

import com.proyectoestructuras.main.Aplicacion;
import com.proyectoestructuras.model.ArbolBinarioArtistas;
import com.proyectoestructuras.model.Cancion;
import com.proyectoestructuras.model.Tienda;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;



public class menuPrincipalControlador implements Initializable {

    Aplicacion aplicacion;
    Tienda tienda;
    Singleton singleton = Singleton.getInstance();

    ArrayList<ImageView> imagenes = new ArrayList<>();
    ArrayList<Button> botones = new ArrayList<>();
    ArrayList<Cancion> canciones = new ArrayList<>();
    ArrayList<Image> imagenesIniciales = new ArrayList<>();

    ArrayList<Cancion> listaCanciones = singleton.obtenerListaCanciones();


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
    private CheckBox genero3 = new CheckBox("Reggaeton");
    @FXML
    private CheckBox genero4 = new CheckBox("Electronica");
    @FXML
    private CheckBox genero5 = new CheckBox("Punk");
    @FXML
    private CheckBox anio1 = new CheckBox("1950 - 1960");
    @FXML
    private CheckBox anio2 = new CheckBox("1961 - 1971");

    @FXML
    private CheckBox anio3 = new CheckBox("1972 - 1982");


    @FXML
    private CheckBox anio4 = new CheckBox("1983 - 1993");

    @FXML
    private CheckBox anio5 = new CheckBox("1994 - 2004");

    @FXML
    private CheckBox anio6 = new CheckBox("2005 - 2015");
    @FXML
    private CheckBox anio7 = new CheckBox("2016 - 2026");



    @FXML
    void agregarAFavoritos(ActionEvent event) {

    }

    @FXML
    void agregarArtista(ActionEvent event) {

        singleton.mostrarVentana("Agregar Artista", "/views/agregarArtista.fxml");

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
        anio1.setSelected(false);
        anio2.setSelected(false);
        anio3.setSelected(false);
        anio4.setSelected(false);
        anio5.setSelected(false);
        anio6.setSelected(false);
        anio7.setSelected(false);
        genero1.setSelected(false);
        genero2.setSelected(false);
        genero3.setSelected(false);
        genero4.setSelected(false);
        genero5.setSelected(false);

    }

    @FXML
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
    @FXML
    void buscarCancion(ActionEvent event) {
        String nombre = txtBuscarCancion.getText();
        boolean bandera = false;

        for (int i = 0; i <listaCanciones.size() ; i++) {
            if(listaCanciones.get(i).getNombre().equalsIgnoreCase(nombre)){
                titulo.setText("Búsqueda de canción");
                for (int j = 1; j < imagenes.size() ; j++) {
                    imagenes.get(0).setImage(listaCanciones.get(i).getCaratula());
                    imagenes.get(j).setOpacity(0);
                    botones.get(j).setVisible(false);
                }
                bandera = true;
                break;
            }
        }

        if(!bandera){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Canción no encontrada");
            alert.setContentText("La canción que busca no se encuentra en la aplicación.");
            alert.showAndWait();
            limpiar();
            limpiarInformacion();
        }
    }

    @FXML
    void cancionesFavoritas(ActionEvent event) {

    }

    @FXML
    void mostrarInfoCancion1(ActionEvent event) {

        if (!bandera) {
            for (int i = 0; i < listaCanciones.size(); i++) {
                if (imagenes.get(0).getImage().equals(listaCanciones.get(i).getCaratula())) {
                    mostrarInformacion(listaCanciones.get(i).getIndice());
                    break;
                }
            }
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
            for (int i = 0; i < listaCanciones.size(); i++) {
                if (imagenes.get(9).getImage().equals(listaCanciones.get(i).getCaratula())) {
                    mostrarInformacion(listaCanciones.get(i).getIndice());
                    break;
                }
            }
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
            for (int i = 0; i < listaCanciones.size(); i++) {
                if (imagenes.get(10).getImage().equals(listaCanciones.get(i).getCaratula())) {
                    mostrarInformacion(listaCanciones.get(i).getIndice());
                    break;
                }
            }
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
            for (int i = 0; i < listaCanciones.size(); i++) {
                if (imagenes.get(11).getImage().equals(listaCanciones.get(i).getCaratula())) {
                    mostrarInformacion(listaCanciones.get(i).getIndice());
                    break;
                }
            }
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
            for (int i = 0; i < listaCanciones.size(); i++) {
                if (imagenes.get(12).getImage().equals(listaCanciones.get(i).getCaratula())) {
                    mostrarInformacion(listaCanciones.get(i).getIndice());
                    break;
                }
            }
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
            for (int i = 0; i < listaCanciones.size(); i++) {
                if (imagenes.get(13).getImage().equals(listaCanciones.get(i).getCaratula())) {
                    mostrarInformacion(listaCanciones.get(i).getIndice());
                    break;
                }
            }
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
            for (int i = 0; i < listaCanciones.size(); i++) {
                if (imagenes.get(14).getImage().equals(listaCanciones.get(i).getCaratula())) {
                    mostrarInformacion(listaCanciones.get(i).getIndice());
                    break;
                }
            }
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
            for (int i = 0; i < listaCanciones.size(); i++) {
                if (imagenes.get(15).getImage().equals(listaCanciones.get(i).getCaratula())) {
                    mostrarInformacion(listaCanciones.get(i).getIndice());
                    break;
                }
            }
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
            for (int i = 0; i < listaCanciones.size(); i++) {
                if (imagenes.get(1).getImage().equals(listaCanciones.get(i).getCaratula())) {
                    mostrarInformacion(listaCanciones.get(i).getIndice());
                    break;
                }
            }
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
            for (int i = 0; i < listaCanciones.size(); i++) {
                if (imagenes.get(2).getImage().equals(listaCanciones.get(i).getCaratula())) {
                    mostrarInformacion(listaCanciones.get(i).getIndice());
                    break;
                }
            }
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
            for (int i = 0; i < listaCanciones.size(); i++) {
                if (imagenes.get(3).getImage().equals(listaCanciones.get(i).getCaratula())) {
                    mostrarInformacion(listaCanciones.get(i).getIndice());
                    break;
                }
            }
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
            for (int i = 0; i < listaCanciones.size(); i++) {
                if (imagenes.get(4).getImage().equals(listaCanciones.get(i).getCaratula())) {
                    mostrarInformacion(listaCanciones.get(i).getIndice());
                    break;
                }
            }
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
            for (int i = 0; i < listaCanciones.size(); i++) {
                if (imagenes.get(5).getImage().equals(listaCanciones.get(i).getCaratula())) {
                    mostrarInformacion(listaCanciones.get(i).getIndice());
                    break;
                }
            }
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
            for (int i = 0; i < listaCanciones.size(); i++) {
                if (imagenes.get(6).getImage().equals(listaCanciones.get(i).getCaratula())) {
                    mostrarInformacion(listaCanciones.get(i).getIndice());
                    break;
                }
            }
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
            for (int i = 0; i < listaCanciones.size(); i++) {
                if (imagenes.get(7).getImage().equals(listaCanciones.get(i).getCaratula())) {
                    mostrarInformacion(listaCanciones.get(i).getIndice());
                    break;
                }
            }
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
            for (int i = 0; i < listaCanciones.size(); i++) {
                if (imagenes.get(8).getImage().equals(listaCanciones.get(i).getCaratula())) {
                    mostrarInformacion(listaCanciones.get(i).getIndice());
                    break;
                }
            }
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
        filtrarCanciones();
        anio1.setSelected(false);
        anio2.setSelected(false);
        anio3.setSelected(false);
        anio4.setSelected(false);
        anio5.setSelected(false);
        anio6.setSelected(false);
        anio7.setSelected(false);
        genero1.setSelected(false);
        genero2.setSelected(false);
        genero3.setSelected(false);
        genero4.setSelected(false);
        genero5.setSelected(false);
    }

    private void mostrarInformacion(int indice) {
        tienda = new Tienda();

        //Cada boton tiene asignada una cancion en especifico,
        // por lo tanto se pasa por parametro el indice de donde se encuentra dicha cancion en la lista.

        if (indice >= 0 && indice < listaCanciones.size()) {
            String infoAux = listaCanciones.get(indice).toString();
            Image imageAux = listaCanciones.get(indice).getCaratula();
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
        inicializarImagenes();

        for (int i = 0; i < listaCanciones.size(); i++) {
            listaCanciones.get(i).setIndice(i);
        }

        for (int i = 0; i < imagenes.size(); i++) {
            imagenes.get(i).setImage(listaCanciones.get(i).getCaratula());
        }

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
        TreeItem<Object> an4 = new TreeItem<>(anio4);
        TreeItem<Object> an5 = new TreeItem<>(anio5);
        TreeItem<Object> an6 = new TreeItem<>(anio6);
        TreeItem<Object> an7 = new TreeItem<>(anio7);

        generos.getChildren().addAll(gen1, gen2, gen3, gen4, gen5);
        anios.getChildren().addAll(an1, an2, an3, an4, an5, an6, an7);
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

    void filtrarCanciones() {
        String genero = obtenerGenero();
        int anio = obtenerAnio();

        if (verificarGenero()) {
            filtroGeneros(genero);
        } else if (verificarAnio()) {
            filtroAnios(anio);
        } else if(verificarAnio() && verificarGenero()){
            filtrarAnioGenero(genero, anio);
        }else {
            singleton.mostrarMensaje("Filtros incorrectos", "Filtros incorrectos",
                    "Debe seleccionar solo una opción tanto de género como años", Alert.AlertType.WARNING);
        }

    }

    private void filtrarAnioGenero(String genero, int anio) {

            int j = 0;
            int cont = 0;
            int valor;
            int limite = anio - 10;

            for (int i = 0; i < listaCanciones.size(); i++) {
                valor = anio;
                if (j < imagenes.size()) {
                    do {
                        String aux = String.valueOf(valor);
                        if (listaCanciones.get(i).getAnio().equalsIgnoreCase(aux) && listaCanciones.get(i).getGenero().equalsIgnoreCase(genero)) {
                            imagenes.get(j).setImage(listaCanciones.get(i).getCaratula());
                            imagenes.get(j).setOpacity(100);
                            botones.get(j).setVisible(true);
                            j++;
                            cont++;
                        }
                        valor = valor-1;
                    } while (valor != limite);
                }

            }

            if(cont!=0) {
                for (int i = cont; i < imagenes.size(); i++) {
                    imagenes.get(i).setImage(null);
                    imagenes.get(i).setOpacity(0);
                    botones.get(i).setVisible(false);
                }
            }else{
                singleton.mostrarMensaje("No hay canciones", "No hay canciones",
                        "No hay canciones con los filtros seleccionados", Alert.AlertType.WARNING);
            }
    }

    private void filtroAnios(int anio) {

        int j = 0;
        int cont = 0;
        int valor;
        int limite = anio - 10;

        for (int i = 0; i < listaCanciones.size(); i++) {
            valor = anio;
            if (j < imagenes.size()) {
                do {
                    String aux = String.valueOf(valor);
                    if (listaCanciones.get(i).getAnio().equalsIgnoreCase(aux)) {
                        imagenes.get(j).setImage(listaCanciones.get(i).getCaratula());
                        imagenes.get(j).setOpacity(100);
                        botones.get(j).setVisible(true);
                        j++;
                        cont++;
                    }
                    valor = valor-1;
                } while (valor != limite);
            }

        }

        if(cont!=0) {
            for (int i = cont; i < imagenes.size(); i++) {
                imagenes.get(i).setOpacity(0);
                botones.get(i).setVisible(false);
            }
        }else{
            singleton.mostrarMensaje("No hay canciones", "No hay canciones",
                    "No hay canciones con este rango de años", Alert.AlertType.WARNING);
        }

    }

    private void filtroGeneros(String genero) {
        int j = 0;
        int cont = 0;
        if (j < imagenes.size()) {
            for (int i = 0; i < listaCanciones.size(); i++) {
                if (listaCanciones.get(i).getGenero().equalsIgnoreCase(genero)) {
                    imagenes.get(j).setImage(listaCanciones.get(i).getCaratula());
                    imagenes.get(j).setOpacity(100);
                    botones.get(j).setVisible(true);
                    j++;
                    cont++;
                }
            }

        }
        for (int i = cont - 1; i < imagenes.size(); i++) {
            imagenes.get(i).setOpacity(0);
            botones.get(i).setVisible(false);
        }
    }

    private int obtenerAnio() {
        int anio = 0;

        if (anio1.isSelected()) {

            anio = 1960;

        } else if (anio2.isSelected()) {

            anio = 1971;

        }else if (anio3.isSelected()) {

            anio = 1982;

        }else if (anio4.isSelected()) {

            anio = 1993;

        }else if (anio5.isSelected()) {

            anio = 2004;

        }else if (anio6.isSelected()) {

            anio = 2015;

        }else if (anio7.isSelected()) {

            anio = 2026;
        }

        return anio;
    }

    private String obtenerGenero() {

        String genero = "";

        if (genero1.isSelected()) {

            genero = genero1.getText();

        } else if (genero2.isSelected()) {

            genero = genero2.getText();

        } else if (genero3.isSelected()) {

            genero = genero3.getText();

        } else if (genero4.isSelected()) {

            genero = genero4.getText();

        } else if (genero5.isSelected()) {

            genero = genero5.getText();
        }

        return genero;
    }

    private boolean verificarAnio() {

        int cont = 0;

        for (int i = 0; i <= 6 && cont <= 1; i++) {

            if (i == 0) {

                if (anio1.isSelected()) {
                    cont++;
                }

            } else if (i == 1) {

                if (anio2.isSelected()) {
                    cont++;
                }

            }else if(i==2){

                if (anio3.isSelected()) {
                    cont++;
                }

        }else if (i == 3) {

                if (anio4.isSelected()) {
                    cont++;
                }

            }else if (i == 4) {

                if (anio5.isSelected()) {
                    cont++;
                }

            }else if (i == 5) {

                if (anio6.isSelected()) {
                    cont++;
                }

            }else if (i == 6) {

                if (anio7.isSelected()) {
                    cont++;
                }

            }

        }

        if (cont == 1) {
            return true;
        }

        return false;
    }

    private boolean verificarGenero() {

        int cont = 0;
        for (int i = 0; i <= 4 && cont <= 1; i++) {

            if (i == 0) {
                if (genero1.isSelected()) {
                    cont++;
                }
            } else if (i == 1) {
                if (genero2.isSelected()) {
                    cont++;
                }

            } else if (i == 2) {
                if (genero3.isSelected()) {
                    cont++;
                }
            } else if (i == 3) {
                if (genero4.isSelected()) {
                    cont++;
                }

            } else if (i == 4) {

                if (genero5.isSelected()) {
                    cont++;
                }
            }

        }

        if (cont == 1) {
            return true;
        }

        return false;
    }
}



