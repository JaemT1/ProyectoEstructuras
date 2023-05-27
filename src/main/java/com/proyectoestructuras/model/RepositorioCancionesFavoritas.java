package com.proyectoestructuras.model;

import java.util.ArrayList;

public class RepositorioCancionesFavoritas {
    private static ArrayList<Cancion> listaCancionesFavoritas = new ArrayList<>();

    public static ArrayList<Cancion> getListaCancionesFavoritas() {
        return listaCancionesFavoritas;
    }

    public static void agregarCancionFavorita(Cancion cancion) {
        listaCancionesFavoritas.add(cancion);
    }
}
