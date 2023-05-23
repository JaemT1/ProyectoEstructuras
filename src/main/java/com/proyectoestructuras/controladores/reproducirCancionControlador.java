
package com.proyectoestructuras.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebView;

public class reproducirCancionControlador implements Initializable {

    private Singleton singleton = Singleton.getInstance();
    @FXML
    private WebView webView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String link = singleton.getLinkYoutube();
        webView.getEngine().load(link);
    }
}

