package com.proyectoestructuras.model;

import com.proyectoestructuras.ListadDoblementeEnlazada.ListaDoblementeEnlazada;

import java.io.Serializable;
import java.util.ArrayList;

public class Artista implements Serializable {
    //Atributos
    private String codigo;
    private String nombre;
    private String nacionalidad;
    private boolean grupo;
    ArrayList<Cancion> listaCanciones = new ArrayList<Cancion>();

    //Constructores
    public Artista() {
    }
    public Artista(String codigo, String nombre, String nacionalidad, boolean grupo, ArrayList listaCanciones) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.grupo = grupo;
        this.listaCanciones = listaCanciones;
    }

    //Getters y Setters
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

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public boolean isGrupo() {
        return grupo;
    }

    public void setGrupo(boolean grupo) {
        this.grupo = grupo;
    }

    public ArrayList<Cancion> getListaCanciones() {
        return listaCanciones;
    }

    public void setListaCanciones(ArrayList<Cancion> listaCanciones) {
        this.listaCanciones = listaCanciones;
    }
}
