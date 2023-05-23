package com.proyectoestructuras.controladores;

import com.proyectoestructuras.main.Aplicacion;
import com.proyectoestructuras.model.ArbolBinarioArtistas;
import com.proyectoestructuras.model.Artista;
import com.proyectoestructuras.model.Cancion;
import com.proyectoestructuras.model.Tienda;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Singleton {

    private Tienda tienda;
    private Aplicacion aplicacion;


    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;

    }

    public String crearCancion(String codigo, String nombreCancion, String nombreAlbum, Image imagen, String anio, String duracion, String genero, String url, String nombreArtista) {

        return tienda.crearCancion(codigo, nombreCancion, nombreAlbum, imagen, anio, duracion, genero, url, nombreArtista);
    }

    public String eliminarCancion(String codigo) {
        return tienda.eliminarCancion(codigo);
    }

    public void mostrarMensaje(String titulo, String header, String mensaje, Alert.AlertType alerta) {

        Alert alert = new Alert(alerta);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public boolean obtenerCodigo(String cod) {
        return tienda.obtenerCodigo(cod);
    }

    public ArrayList<Cancion> obtenerListaCanciones() {
        return tienda.obtenerListaCanciones();
    }

    public boolean obtenerCodigoArtista(String nombre, String cod) {
        return tienda.obtenerCodigoArtista(nombre, cod);
    }

    public String crearArtista(String codigo, String nombreArtista, String nacionalidad, boolean grupo) {
        return tienda.crearArtista(codigo, nombreArtista, nacionalidad, grupo);
    }

    public String obtenerCodArtista(String nombre) {
        return tienda.obtenerCodArtista(nombre);
    }

    public String eliminarArtista(String nombre) {
        return tienda.eliminarArtista(nombre);
    }

    public String actualizarArtista(String codigo, String nombreAnterior, String nacionalidadNueva, boolean grupoNuevo) {
        return tienda.actualizarArtista(codigo, nombreAnterior, nacionalidadNueva, grupoNuevo);
    }

    boolean obtenerArtista(String nombre) {
        return tienda.obtenerArtista(nombre);
    }

    private static class SingletonHolder {
        private final static Singleton eINSTANCE = new Singleton();
    }

    public static Singleton getInstance() {

        return SingletonHolder.eINSTANCE;
    }

    public Singleton() {

        inicializarDatos();
    }

    private void inicializarDatos() {

        tienda = new Tienda();
        aplicacion = new Aplicacion();
    }

    public void mostrarVentana(String titulo, String ruta) {

        aplicacion.mostrarVentana(titulo, ruta);
    }

    public ArbolBinarioArtistas retornarArbol() {
        return tienda.retornarArbol();
    }


}
