package com.proyectoestructuras.model;

import java.io.Serializable;
import java.util.ArrayList;

public class RepositorioCancionesFavoritas implements Serializable {
    private  ArrayList<Cancion> listaCancionesFavoritas = new ArrayList<>();

    public  ArrayList<Cancion> getListaCancionesFavoritas() {
        return listaCancionesFavoritas;
    }

    public RepositorioCancionesFavoritas(){
    }
    public void setListaCancionesFavoritas(ArrayList<Cancion> listaCancionesFavoritas) {
        listaCancionesFavoritas = listaCancionesFavoritas;
    }

    public  void agregarCancionFavorita(Cancion cancion) {
        listaCancionesFavoritas.add(cancion);
    }

    public  void eliminarCancionFavorita(String cod) {

        for (int i = 0; i <listaCancionesFavoritas.size() ; i++) {
            if(listaCancionesFavoritas.get(i).getCodigo().equalsIgnoreCase(cod)){
                listaCancionesFavoritas.remove(i);
            }
        }
    }



}
