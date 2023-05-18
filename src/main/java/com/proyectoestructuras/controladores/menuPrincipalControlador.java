package com.proyectoestructuras.controladores;


import com.proyectoestructuras.model.Cancion;
import com.proyectoestructuras.model.Tienda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class menuPrincipalControlador {
    @FXML
    private Button cancion1;

    @FXML
    private Label infoCancion;
    private Stage stage;
    private Scene scene;
    private Parent root;

    Tienda tienda;
    
    @FXML
    void actualizarInfo(ActionEvent event) throws IOException {
        mostrarInformacion(0);
    }

    /**
     * Método para mostrar la información de la canción en un label.
     * @param indice
     */
    private void mostrarInformacion(int indice) {
        tienda = new Tienda();

        //Cada boton tiene asignada una cancion en especifico,
        // por lo tanto se pasa por parametro el indice de donde se encuentra dicha cancion en la lista.

        ArrayList<Cancion> lista = tienda.getListaCanciones();
        if (indice >= 0 && indice < lista.size()) {
            String info = lista.get(indice).toString();
            infoCancion.setText(info);
            infoCancion.setAlignment(Pos.CENTER);
        }
    }
}




