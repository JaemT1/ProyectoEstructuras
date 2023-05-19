package com.proyectoestructuras.model;

import javafx.scene.image.Image;

import java.io.Serializable;

public class Cancion implements Serializable {

    private String codigo;
    private String nombre;
    private String nombreAlbum;
    private Image caratula;
    private String anio;
    private String duracion;
    private String genero;
    private String url;

    public Cancion(String codigo, String nombre, String nombreAlbum, Image caratula, String anio, String duracion, String genero, String url) {
        super();
        this.codigo = codigo;
        this.nombre = nombre;
        this.nombreAlbum = nombreAlbum;
        this.caratula = caratula;
        this.anio = anio;
        this.duracion = duracion;
        this.genero = genero;
        this.url = url;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreAlbum() {
        return nombreAlbum;
    }

    public void setNombreAlbum(String nombreAlbum) {
        this.nombreAlbum = nombreAlbum;
    }

    public Image getCaratula() {
        return caratula;
    }

    public void setCaratula(Image caratula) {
        this.caratula = caratula;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String toString() {
        return "Nombre: " + nombre + "\n\n" +
                "Nombre álbum: " + nombreAlbum + "\n\n" +
                "Duración: " + duracion +" minutos" + "\n\n" +
                "Año: " + anio + "\n\n" +
                "Género: " + genero;
    }


}
