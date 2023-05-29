package com.proyectoestructuras.controladores;

import com.proyectoestructuras.main.Aplicacion;
import com.proyectoestructuras.model.Cancion;
import com.proyectoestructuras.model.RepositorioCancionesFavoritas;
import com.proyectoestructuras.model.Tienda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.awt.*;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class misFavoritosControlador implements Initializable {

    Aplicacion aplicacion;
    Tienda tienda;
    Singleton singleton = Singleton.getInstance();
    ArrayList<ImageView> imagenes = new ArrayList<>();
    ArrayList<Button> botones = new ArrayList<>();
    ArrayList<Cancion> cancionesFavoritas = singleton.getTienda().getRepositorio().getListaCancionesFavoritas();

    ArrayList<Image> imagenesIniciales = new ArrayList<>();

    boolean bandera = false;

    Cancion cancion = null;

    String linkYoutube = "";
    @FXML
    private Button btnAnterior;

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
    private Button btnLimpiar;

    @FXML
    private Button btnQuitarFavoritos;

    @FXML
    private Button btnRegresar;

    @FXML
    private Button btnReproducir;

    @FXML
    private Button btnSiguiente;

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
    private ImageView imagenInfo;

    @FXML
    private ImageView imagenQuitar;

    @FXML
    private ImageView imagenReproducir;

    @FXML
    private Label info;

    @FXML
    private Label infoCancion;

    @FXML
    private Separator separator;

    @FXML
    private Label titulo;

    @FXML
    void anteriorPagina(ActionEvent event) {

        imagenesIniciales();
    }


    @FXML
    void limpiar(ActionEvent event) {
        limpiarInfo();
    }

    private void limpiarInfo() {
        info.setOpacity(0);
        infoCancion.setText("");
        imagenReproducir.setOpacity(0);
        imagenQuitar.setOpacity(0);
        imagenInfo.setImage(null);
        btnQuitarFavoritos.setOpacity(0);
        btnReproducir.setOpacity(0);
        separator.setOpacity(0);
    }

    @FXML
    void quitarFavoritos(ActionEvent event){
        limpiarInfo();
        if (cancion != null) {
            int indiceEliminado = cancion.getIndice(); // Obtener el índice de la canción eliminada
            cancionesFavoritas.remove(cancion);

            // Actualizar los índices de las canciones restantes
            for (Cancion cancionFavorita : cancionesFavoritas) {
                if (cancionFavorita.getIndice() > indiceEliminado) {
                    cancionFavorita.setIndice(cancionFavorita.getIndice() - 1);
                }
            }

            for (int i = 0; i < imagenes.size(); i++) {
                if (i < cancionesFavoritas.size()) {
                    Image imgAux = new Image(cancionesFavoritas.get(i).getCaratula().getPath());
                    imagenes.get(i).setImage(imgAux);
                    imagenes.get(i).setAccessibleText(String.valueOf(cancionesFavoritas.get(i).getIndice()));
                    botones.get(i).setText(String.valueOf(cancionesFavoritas.get(i).getIndice()));
                } else {
                    imagenes.get(i).setImage(null);
                }
            }
        }
        singleton.serializarBinario();
    }

    @FXML
    void regresar(ActionEvent event) {

        singleton.mostrarVentana("Menu Principal", "/views/menuPrincipal.fxml",80,30);

    }

    @FXML
    void reproducirCancion(ActionEvent event) {

        abrirCancion(linkYoutube);

    }

    private void abrirCancion(String link) {
        try {
            Desktop.getDesktop().browse(new URI(link));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void siguientePagina(ActionEvent event) {
        bandera = true;
        int j = 16;
        if (cancionesFavoritas.size() > 16) {
            for (int i = 0; i < imagenes.size(); i++) {
                if (j < cancionesFavoritas.size()) {
                    Image imgAux = new Image(cancionesFavoritas.get(j).getCaratula().getPath());
                    imagenes.get(i).setImage(imgAux);
                    j++;
                }else{
                    imagenes.get(i).setImage(null);
                }
            }
        }
    }


    private void mostrarInformacion(int indice) {

        //Cada boton tiene asignada una cancion en especifico,
        // por lo tanto se pasa por parametro el indice de donde se encuentra dicha cancion en la lista.

        if (indice >= 0 && indice < cancionesFavoritas.size()) {
            String infoAux = cancionesFavoritas.get(indice).toString();
            Image imageAux = new Image(cancionesFavoritas.get(indice).getCaratula().getPath());
            info.opacityProperty().setValue(100);
            infoCancion.opacityProperty().setValue(100);
            infoCancion.setText(infoAux);
            imagenInfo.opacityProperty().setValue(100);
            imagenInfo.setImage(imageAux);

            btnQuitarFavoritos.opacityProperty().setValue(100);
            btnReproducir.opacityProperty().setValue(100);
            imagenQuitar.opacityProperty().setValue(100);
            imagenReproducir.opacityProperty().setValue(100);
            separator.opacityProperty().setValue(100);
        }

    }

    @FXML
    void mostrarInformacionCancion(ActionEvent event) {
        Button prueba = (Button) event.getSource();
        int id = Integer.parseInt(prueba.getText());

        if (!bandera) {
            for (Cancion cancionFavorita : cancionesFavoritas) {
                if (cancionFavorita.getIndice() == id) {
                    mostrarInformacion(cancionFavorita.getIndice());
                    linkYoutube = cancionFavorita.getUrl();
                    cancion = cancionFavorita;
                    break;
                }
            }
        } else {
            for (int i = 0; i < imagenes.size(); i++) {
                Image aux = imagenes.get(i).getImage();
                int aux2 = Integer.parseInt(imagenes.get(i).getAccessibleText());
                if (id == aux2) {
                    for (Cancion cancionFavorita : cancionesFavoritas) {
                        if (aux.equals(cancionFavorita.getCaratula())) {
                            // Actualizamos el índice de la canción
                            int nuevoIndice = i + 1;
                            cancionFavorita.setIndice(nuevoIndice);
                            mostrarInformacion(nuevoIndice);
                            linkYoutube = cancionFavorita.getUrl();
                            cancion = cancionFavorita;
                            break;
                        }
                    }
                    break;
                }
            }
        }
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        inicializarImagenes();
        for (int i = 0; i < cancionesFavoritas.size(); i++) {
            cancionesFavoritas.get(i).setIndice(i);
        }

        if (!cancionesFavoritas.isEmpty()) {
            int j = 0;
            for (int i = 0; i < imagenes.size() && j < cancionesFavoritas.size(); i++, j++) {
                Image imgAux = new Image(cancionesFavoritas.get(j).getCaratula().getPath());
                imagenes.get(i).setImage(imgAux);
            }
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

    private void imagenesIniciales() {

        for (int j = 0; j < imagenesIniciales.size(); j++) {
            Image aux = imagenesIniciales.get(j);
            imagenes.get(j).setOpacity(100);
            imagenes.get(j).setImage(aux);
            botones.get(j).setVisible(true);
        }

    }
}
