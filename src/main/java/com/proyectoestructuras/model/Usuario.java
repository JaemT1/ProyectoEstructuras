package com.proyectoestructuras.model;

import com.proyectoestructuras.ListaCircular.ListaCircularSimple;

import java.io.Serializable;

public class Usuario implements Serializable {
    //Atributos
    private String username;
    private String contrasenia;
    private String email;
    private ListaCircularSimple canciones;

    //Constructores
    public Usuario() {
    }
    public Usuario(String username, String contrasenia, String email, ListaCircularSimple canciones) {
        this.username = username;
        this.contrasenia = contrasenia;
        this.email = email;
        this.canciones = canciones;
    }

    //Getters y Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ListaCircularSimple getCanciones() {
        return canciones;
    }

    public void setCanciones(ListaCircularSimple canciones) {
        this.canciones = canciones;
    }
}
