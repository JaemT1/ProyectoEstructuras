package com.proyectoestructuras.model;

import java.io.Serializable;

public class Administrador implements Serializable {
    //Atributos
    private String username;
    private String contrasena;

    //Constructores
    public Administrador() {
        super();
    }
    public Administrador(String username, String contrasena) {
        super();
        this.username = username;
        this.contrasena = contrasena;
    }

    //Getters y setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
