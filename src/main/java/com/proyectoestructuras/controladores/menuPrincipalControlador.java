package com.proyectoestructuras.controladores;

import com.proyectoestructuras.main.Aplicacion;
import com.proyectoestructuras.model.ArbolBinarioArtistas;
import com.proyectoestructuras.model.Cancion;
import com.proyectoestructuras.model.RepositorioCancionesFavoritas;
import com.proyectoestructuras.model.Tienda;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.awt.*;
import java.net.URI;
import java.net.URL;
import java.util.*;


public class menuPrincipalControlador implements Initializable {

    Aplicacion aplicacion;
    Tienda tienda;
    Singleton singleton = Singleton.getInstance();

    ArrayList<ImageView> imagenes = new ArrayList<>();
    ArrayList<Button> botones = new ArrayList<>();
    ArrayList<Cancion> canciones = new ArrayList<>();
    ArrayList<Image> imagenesIniciales = new ArrayList<>();

    ArrayList<Cancion> listaCanciones = singleton.getTienda().getListaCanciones();

    ArrayList<Cancion> listaCancionesFavoritas = new ArrayList<>();
    static boolean bandera = false;

    static String linkYoutube = "";

    Cancion cancion = null;


    boolean auxO = false;
    boolean auxY = false;

    @FXML
    private Button btnAgregarArtista;

    @FXML
    private Button btnAgregarCancion;

    @FXML
    private Button btnAgregarFavs;

    @FXML
    private Button btnAplicarFiltrosY;
    @FXML
    private Button btnAplicarFiltrosO;

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
    private Button btnBusquedaO;

    @FXML
    private Button btnBusquedaY;

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

        if (!singleton.getTienda().getRepositorio().getListaCancionesFavoritas().contains(cancion)) {
            singleton.getTienda().getRepositorio().agregarCancionFavorita(cancion);
            singleton.mostrarMensaje("Información", "Agregar a favoritos", "La canción ha sido agregada a favoritos", Alert.AlertType.INFORMATION);
        } else {
            singleton.mostrarMensaje("Información", "Agregar a favoritos", "La canción ya está en favoritos", Alert.AlertType.WARNING);
        }
        singleton.serializarBinario();
    }

    @FXML
    void agregarArtista(ActionEvent event) {

        singleton.mostrarVentana("Agregar Artista", "/views/agregarArtista.fxml",400,100);

    }

    @FXML
    void agregarCancion(ActionEvent event) {

        singleton.mostrarVentana("Agregar Canción", "/views/agregarCancion.fxml",400,100);

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
                Image imgAux = new Image(canciones.get(i).getCaratula().getPath());
                imagenes.get(i).setImage(imgAux);
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
        limpiarInformacion();

        for (int i = 0; i < listaCanciones.size(); i++) {
            if (listaCanciones.get(i).getNombre().equalsIgnoreCase(nombre)) {
                titulo.setText("Búsqueda de canción");
                for (int j = 1; j < imagenes.size(); j++) {
                    Image imgAux = new Image(listaCanciones.get(i).getCaratula().getPath());
                    imagenes.get(0).setImage(imgAux);
                    imagenes.get(j).setOpacity(0);
                    botones.get(j).setVisible(false);
                }
                bandera = true;
                break;
            }
        }

        limpiar();

        if (!bandera) {
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
        singleton.mostrarVentana("Canciones Favoritas", "/views/misFavoritos.fxml",200,40);

    }

    @FXML
    void mostrarInformacionCancion(ActionEvent event) {

        Button prueba = (Button) event.getSource();
        int id = Integer.parseInt(prueba.getText());

        if (!bandera) {
            for (int i = 0; i < listaCanciones.size(); i++) {
                Image img = new Image(listaCanciones.get(i).getCaratula().getPath());
                if (imagenes.get(id).getImage().getUrl().equals(img.getUrl())) {
                    mostrarInformacion(listaCanciones.get(i).getIndice());
                    linkYoutube = listaCanciones.get(i).getUrl();
                    cancion = listaCanciones.get(i);
                    break;
                }
            }

        } else {

            for (int i = 0; i < imagenes.size(); i++) {
                Image aux = imagenes.get(i).getImage();
                int aux2 = Integer.parseInt(imagenes.get(i).getAccessibleText());
                if (id == aux2) {
                    for (int j = 0; j < canciones.size(); j++) {
                        Image img = new Image(canciones.get(j).getCaratula().getPath());
                        if (aux.getUrl().equals(img.getUrl())) {
                            mostrarInformacion(canciones.get(j).getIndice());
                            linkYoutube = listaCanciones.get(j).getUrl();
                            cancion = listaCanciones.get(j);
                        }
                    }
                }
            }

        }
    }

    @FXML
    void reproducirCancion(ActionEvent event) {

        abrirCancion(linkYoutube);

        //singleton.setLinkYoutube(linkYoutube);
        //singleton.mostrarVentana("Video", "/views/reproducirCancion.fxml");


    }

    private void abrirCancion(String link) {
        try {
            Desktop.getDesktop().browse(new URI(link));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String retornarURL(String link) {
        return link;
    }

    @FXML
    void aplicarFiltrosY(ActionEvent event) {
        auxY = true;
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

    @FXML
    void aplicarFiltrosO(ActionEvent event) {
        auxO = true;
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
        //tienda = new Tienda();
        //Cada boton tiene asignada una cancion en especifico,
        // por lo tanto se pasa por parametro el indice de donde se encuentra dicha cancion en la lista.

        if (indice >= 0 && indice < listaCanciones.size()) {
            String infoAux = listaCanciones.get(indice).toString();
            Image imageAux = new Image(listaCanciones.get(indice).getCaratula().getPath());
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

        singleton.cargarBinario();
        listaCanciones = singleton.getTienda().getListaCanciones();
        treeViewFiltros.setRoot(agregarElementos());
        inicializarImagenes();

        for (int i = 0; i < listaCanciones.size(); i++) {
            listaCanciones.get(i).setIndice(i);
        }

        for (int i = 0; i < imagenes.size(); i++) {
            Image imgAux = new Image(listaCanciones.get(i).getCaratula().getPath());
            imagenes.get(i).setImage(imgAux);
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

        if (auxO) {
            if (verificarAnio() && verificarGenero()) {
                filtrarAnioGenero(genero, anio);
                auxO = false;
            } else if (verificarGenero()) {
                filtroGeneros(genero);
                auxO = false;
            } else if (verificarAnio()) {
                filtroAnios(anio);
                auxO = false;
            } else {
                singleton.mostrarMensaje("Error", "Error de seleccionado", "Seleccione una sola opción.", Alert.AlertType.WARNING);
            }
        }

        if (auxY) {
            if (verificarAnio() && verificarGenero()) {
                filtrarAnioGenero(genero, anio);
                auxY = false;
            } else if (verificarGenero()) {
                filtroGeneros(genero);
                auxY = false;
            } else if (verificarAnio()) {
                filtroAnios(anio);
                auxY = false;
            } else {
                singleton.mostrarMensaje("Error", "Error de seleccionado", "Seleccione una sola opción.", Alert.AlertType.WARNING);
            }
        }

    }


    private void filtrarAnioGenero(String genero, int anio) {
        int cont = 0;
        int valor;
        int limite = anio - 11;

        // Crear una lista auxiliar para almacenar las canciones filtradas
        ArrayList<Cancion> cancionesFiltradas = new ArrayList<>();


        for (int i = 0; i < listaCanciones.size(); i++) {
            valor = anio;
            do {
                String aux = String.valueOf(valor);
                Cancion cancion = listaCanciones.get(i);
                if (auxO) {
                    if (cancion.getAnio().equalsIgnoreCase(aux)) {
                        cancionesFiltradas.add(cancion);
                        cont++;
                        break;
                    }
                    if (cancion.getGenero().equalsIgnoreCase(genero) && !cancion.getAnio().equalsIgnoreCase(aux)) {
                        cancionesFiltradas.add(cancion);
                        cont++;
                        break;
                    }
                } else if (auxY) {
                    if (cancion.getAnio().equalsIgnoreCase(aux) && cancion.getGenero().equalsIgnoreCase(genero)) {
                        cancionesFiltradas.add(cancion);
                        cont++;
                    }

                }
                valor = valor - 1;
            } while (valor != limite);
        }

        if (cont != 0) {
            if (auxO) {
                titulo.setText("Canciones de " + genero + " o del año " + (limite + 1) + " al " + anio);
                organizarListaCanciones(cancionesFiltradas, cont);
            }

            if (auxY) {
                titulo.setText("Canciones de " + genero + " y del año " + (limite + 1) + " al " + anio);
                organizarListaCanciones(cancionesFiltradas, cont);

            }


        } else {
            singleton.mostrarMensaje("No hay canciones", "No hay canciones",
                    "No hay canciones con los filtros seleccionados", Alert.AlertType.WARNING);
        }
    }

    void organizarListaCanciones(ArrayList<Cancion> aux, int cont) {

        Collections.sort(aux, new Comparator<Cancion>() {
            @Override
            public int compare(Cancion cancion1, Cancion cancion2) {
                return cancion1.getNombre().compareToIgnoreCase(cancion2.getNombre());
            }
        });

        // Establecer las canciones ordenadas en las ImageView
        for (int i = 0; i < aux.size() && i < imagenes.size(); i++) {
            Image imgAux = new Image(aux.get(i).getCaratula().getPath());
            imagenes.get(i).setImage(imgAux);
            imagenes.get(i).setOpacity(100);
            botones.get(i).setVisible(true);
        }

        // Restablecer las ImageView restantes
        for (int i = cont; i < imagenes.size(); i++) {
            imagenes.get(i).setImage(null);
            imagenes.get(i).setOpacity(0);
            botones.get(i).setVisible(false);
        }
    }


    private void filtroGeneros(String genero) {
        int cont = 0;

        ArrayList<Cancion> cancionesFiltradas = new ArrayList<>();

        for (int i = 0; i < listaCanciones.size(); i++) {
            if (listaCanciones.get(i).getGenero().equalsIgnoreCase(genero)) {
                cancionesFiltradas.add(listaCanciones.get(i));
                cont++;
            }
        }

        if (cont != 0) {
            organizarListaCanciones(cancionesFiltradas, cont);
            titulo.setText("Canciones de " + genero);
        } else {
            singleton.mostrarMensaje("No hay canciones", "No hay canciones",
                    "No hay canciones de este género", Alert.AlertType.WARNING);
        }
    }

    private void filtroAnios(int anio) {

        int cont = 0;
        int valor;
        int limite = anio - 11;

        ArrayList<Cancion> cancionesFiltradas = new ArrayList<>();

        for (int i = 0; i < listaCanciones.size(); i++) {
            valor = anio;
            do {
                String aux = String.valueOf(valor);
                Cancion cancion = listaCanciones.get(i);
                if (cancion.getAnio().equalsIgnoreCase(aux)) {
                    cancionesFiltradas.add(cancion);
                    cont++;
                }
                valor = valor - 1;
            } while (valor != limite);
        }


        if (cont != 0) {
            organizarListaCanciones(cancionesFiltradas, cont);
            titulo.setText("Canciones del año " + (limite + 1) + " al " + anio);
        } else {
            singleton.mostrarMensaje("No hay canciones", "No hay canciones",
                    "No hay canciones con este rango de años", Alert.AlertType.WARNING);
        }
    }


    private int obtenerAnio() {
        int anio = 0;

        if (anio1.isSelected()) {

            anio = 1960;

        } else if (anio2.isSelected()) {

            anio = 1971;

        } else if (anio3.isSelected()) {

            anio = 1982;

        } else if (anio4.isSelected()) {

            anio = 1993;

        } else if (anio5.isSelected()) {

            anio = 2004;

        } else if (anio6.isSelected()) {

            anio = 2015;

        } else if (anio7.isSelected()) {

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

            } else if (i == 2) {

                if (anio3.isSelected()) {
                    cont++;
                }

            } else if (i == 3) {

                if (anio4.isSelected()) {
                    cont++;
                }

            } else if (i == 4) {

                if (anio5.isSelected()) {
                    cont++;
                }

            } else if (i == 5) {

                if (anio6.isSelected()) {
                    cont++;
                }

            } else if (i == 6) {

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


    public static String getLinkYoutube() {
        return linkYoutube;
    }

    public static void setLinkYoutube(String linkYoutube) {
        menuPrincipalControlador.linkYoutube = linkYoutube;
    }
}




