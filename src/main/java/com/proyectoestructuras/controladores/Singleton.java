package com.proyectoestructuras.controladores;

import com.proyectoestructuras.main.Aplicacion;
import com.proyectoestructuras.model.ArbolBinarioArtistas;
import com.proyectoestructuras.model.Cancion;
import com.proyectoestructuras.model.Tienda;
import com.proyectoestructuras.persistencia.persistencia;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;


import java.util.ArrayList;

public class Singleton {

    private Tienda tienda;
    private Aplicacion aplicacion;
    private String linkYoutube;

    ArrayList<String> datos = new ArrayList<>();

    String artista;

    boolean registrado;
    boolean presionado;

    boolean artistaRegistrado = true;

    Image imagen;


    public boolean isArtistaRegistrado() {
        return artistaRegistrado;
    }

    public void setArtistaRegistrado(boolean artistaRegistrado) {
        this.artistaRegistrado = artistaRegistrado;
    }

    ArrayList<Cancion> listaCancionesFavoritas = new ArrayList<>();

    public ArrayList<Cancion> getListaCancionesFavoritas() {
        return listaCancionesFavoritas;
    }

    public void setListaCancionesFavoritas(ArrayList<Cancion> listaCancionesFavoritas) {
        this.listaCancionesFavoritas = listaCancionesFavoritas;
    }

    public boolean isPresionado() {
        return presionado;
    }

    public void setPresionado(boolean presionado) {
        this.presionado = presionado;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public boolean isRegistrado() {
        return registrado;
    }

    public void setRegistrado(boolean registrado) {
        this.registrado = registrado;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public ArrayList<String> getDatos() {
        return datos;
    }

    public void setDatos(ArrayList<String> datos) {
        this.datos = datos;
    }

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

    public void mostrarVentana(String titulo, String ruta, double ancho, double alto) {

        aplicacion.mostrarVentana(titulo, ruta, ancho, alto);
    }

    public ArbolBinarioArtistas retornarArbol() {
        return tienda.retornarArbol();
    }

    public String getLinkYoutube() {
        return linkYoutube;
    }

    public void serializarBinario(){
        persistencia.guardarRecursoTiendaBinario(tienda);
    }

    public void setLinkYoutube(String linkYoutube) {
        this.linkYoutube = linkYoutube;
    }
}
