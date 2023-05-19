package com.proyectoestructuras.controladores;

import com.proyectoestructuras.main.Aplicacion;
import com.proyectoestructuras.model.Tienda;

public class Singleton {

    private Tienda tienda;
    private Aplicacion aplicacion;

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;

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

}
