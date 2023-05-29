package com.proyectoestructuras.model;

import java.util.ArrayList;

public class RepositorioCancionesFavoritas {
    private static ArrayList<Cancion> listaCancionesFavoritas = new ArrayList<>();

    public static ArrayList<Cancion> getListaCancionesFavoritas() {
        return listaCancionesFavoritas;
    }

    public static void setListaCancionesFavoritas(ArrayList<Cancion> listaCancionesFavoritas) {
        RepositorioCancionesFavoritas.listaCancionesFavoritas = listaCancionesFavoritas;
    }

    public static void agregarCancionFavorita(Cancion cancion) {
        listaCancionesFavoritas.add(cancion);
    }

    public static void eliminarCancionFavorita(String cod) {

        for (int i = 0; i <listaCancionesFavoritas.size() ; i++) {
            if(listaCancionesFavoritas.get(i).getCodigo().equalsIgnoreCase(cod)){
                listaCancionesFavoritas.remove(i);
            }
        }
    }

}
