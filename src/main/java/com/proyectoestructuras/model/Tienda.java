package com.proyectoestructuras.model;

import javafx.scene.image.Image;

import java.io.Serializable;
import java.util.*;

public class Tienda implements Serializable {
    //Atributos


    ArrayList<Cancion> listaCanciones = new ArrayList<Cancion>();
    ArbolBinarioArtistas arbolArtistas = new ArbolBinarioArtistas();


    //Constructor
    public Tienda() {
        crearCanciones();
        //crearArtistas();
    }

    public void crearCanciones() {
        ArrayList aux = new ArrayList();

        //ROCK
        Cancion ca1 = new Cancion("1", "Come as you are", "Nevermind", new Image(String.valueOf(getClass().getResource("/imagenes/comeAsYouAre.jpg"))), "1991", "3:44", "Rock", "https://www.youtube.com/watch?v=vabnZ9-ex7o", "Nirvana", 0);
        Cancion ca2 = new Cancion("2", "The Unforgiven", "Metallica", new Image(String.valueOf(getClass().getResource("/imagenes/theUnforgiven.jpg"))), "1991", "6:28", "Rock", "https://www.youtube.com/watch?v=Ckom3gf57Yw", "Metallica", 1);
        Cancion ca3 = new Cancion("3", "Your Love", "Play Deep", new Image(String.valueOf(getClass().getResource("/imagenes/yourLove.jpg"))), "1985", "4:12", "Rock", "https://www.youtube.com/watch?v=4N1iwQxiHrs", "The Outfield", 2);
        Cancion ca4 = new Cancion("4", "I Hate Myself for Loving You", "Up Your Alley", new Image(String.valueOf(getClass().getResource("/imagenes/iHateMyself.jpg"))), "1988", "4:17", "Rock", "https://www.youtube.com/watch?v=bpNw7jYkbVc", "Joan Jett & The Blackhearts", 3);
        Cancion ca5 = new Cancion("5", "Supersonic", "Definitely Maybe", new Image(String.valueOf(getClass().getResource("/imagenes/supersonic.jpg"))), "1994", "4:29", "Rock", "https://www.youtube.com/watch?v=BJKpUH2kJQg", "Oasis", 4);


        //POP
        Cancion ca6 = new Cancion("6", "Thriller", "Thriller", new Image(String.valueOf(getClass().getResource("/imagenes/thriller.jpg"))), "1982", "5:57", "Pop", "https://www.youtube.com/watch?v=sOnqjkJTMaA", "Michael Jackson", 5);
        Cancion ca7 = new Cancion("7", "Billie Jean", "Thriller", new Image(String.valueOf(getClass().getResource("/imagenes/billieJean.jpg"))), "1982", "4:54", "Pop", "https://www.youtube.com/watch?v=Zi_XLOBDo_Y", "Michael Jackson", 6);
        Cancion ca8 = new Cancion("8", "Like a Prayer", "Like a Prayer", new Image(String.valueOf(getClass().getResource("/imagenes/likeAPrayer.png"))), "1989", "5:39", "Pop", "https://www.youtube.com/watch?v=79fzeNUqQbQ", "Madonna", 7);
        Cancion ca9 = new Cancion("9", "Shape of You", " ", new Image(String.valueOf(getClass().getResource("/imagenes/shapeOfYou.jpg"))), "2017", "3:53", "Pop", "https://www.youtube.com/watch?v=JGwWNGJdvx8", "Ed Sheeran", 8);
        Cancion ca10 = new Cancion("10", "Bad Romance", "The Fame Monster", new Image(String.valueOf(getClass().getResource("/imagenes/badRomance.jpg"))), "2009", "4:55", "Pop", "https://www.youtube.com/watch?v=qrO4YZeyl0I", "Lady Gaga", 9);


        //REGGAETON

        Cancion ca11 = new Cancion("11", "Despacito", "Fénix", new Image(String.valueOf(getClass().getResource("/imagenes/despacito.jpg"))), "2017", "4:42", "Reggaeton", "https://www.youtube.com/watch?v=kJQP7kiw5Fk", "Luis Fonsi", 10);
        Cancion ca12 = new Cancion("12", "Danza Kuduro", "Meet the Orphans", new Image(String.valueOf(getClass().getResource("/imagenes/danzaKuduro.jpg"))), "2010", "3:56", "Reggaeton", "https://www.youtube.com/watch?v=7zp1TbLFPp8", "Don Omar", 11);
        Cancion ca13 = new Cancion("13", "Otra Noche en Miami", "Otra Noche en Miami", new Image(String.valueOf(getClass().getResource("/imagenes/otraNocheEnMiami.png"))), "2022", "4:11", "Reggaeton", "https://www.youtube.com/watch?v=L5paI9ge4VE", "Bad Bunny", 12);
        Cancion ca14 = new Cancion("14", "Ella Quiere Beber", "Real Hasta La Muerte", new Image(String.valueOf(getClass().getResource("/imagenes/EllaQuiereBeber.jpg"))), "2018", "3:37", "Reggaeton", "https://www.youtube.com/watch?v=2DI9bMmBZcY", "Anuel AA", 13);
        Cancion ca15 = new Cancion("15", "Gasolina", "Barrio Fino", new Image(String.valueOf(getClass().getResource("/imagenes/gasolina.jpg"))), "2004", "3:12", "Reggaeton", "https://www.youtube.com/watch?v=QGJuMBdaqIw", "Daddy Yankee", 14);


        //PUNK

        Cancion ca16 = new Cancion("16", "Anarchy in the U.K.", "Never Mind the Bollocks, Here's the Sex Pistols", new Image(String.valueOf(getClass().getResource("/imagenes/anarchyInTheUK.jpg"))), "1977", "3:32", "Punk", "https://www.youtube.com/watch?v=cBojbjoMttI", "Here's the Sex Pistols - Sex Pistols", 15);
        Cancion ca17 = new Cancion("17", "Blitzkrieg Bop", "Ramones", new Image(String.valueOf(getClass().getResource("/imagenes/blitzkriegBop.jpg"))), "1976", "2:12", "Punk", "https://www.youtube.com/watch?v=6Z66wVo7uNw", "Ramones", 16);
        Cancion ca18 = new Cancion("18", "Should I Stay or Should I Go", "Combat Rock", new Image(String.valueOf(getClass().getResource("/imagenes/Should_I_Stay_or_Should_I_Go.png"))), "1982", "3:08", "Punk", "https://www.youtube.com/watch?v=BN1WwnEDWAM", "The Clash", 17);
        Cancion ca19 = new Cancion("19", "Holiday", "American Idiot", new Image(String.valueOf(getClass().getResource("/imagenes/greenDay.png"))), "2004", "3:52", "Punk", "https://www.youtube.com/watch?v=A1OqtIqzScI", "Green Day", 18);
        Cancion ca20 = new Cancion("20", "Teenage Kicks", "Teenage Kicks (Single)", new Image(String.valueOf(getClass().getResource("/imagenes/teenageKicks.jpg"))), "1978", "2:28", "Punk", "https://www.youtube.com/watch?v=Oy3RhsLN_50", "The Undertones", 19);


        //ELECTRONICA

        Cancion ca21 = new Cancion("21", "Dreams of Loving", "Synthwave Sensations", new Image(String.valueOf(getClass().getResource("/imagenes/dreamsOfLoving.jpg"))), "2023", "4:30", "Electronica", "https://ejemplo.com/cancion1.mp3", "The Human League", 20);
        Cancion ca22 = new Cancion("22", "Future Pulse", "Digital Paradigm", new Image(String.valueOf(getClass().getResource("/imagenes/futurePulse.jpg"))), "2022", "5:12", "Electronica", "https://ejemplo.com/cancion2.mp3", "Scandroid", 21);
        Cancion ca23 = new Cancion("23", "Neon Nights", "Retro Electro Vibes", new Image(String.valueOf(getClass().getResource("/imagenes/neonNights.jpg"))), "2021", "3:58", "Electronica", "https://ejemplo.com/cancion3.mp3", "Kraftwerk", 22);
        Cancion ca24 = new Cancion("24", "Synthetic Love", "Cyber Beats", new Image(String.valueOf(getClass().getResource("/imagenes/syntheticLove.jpg"))), "2023", "6:02", "Electronica", "https://ejemplo.com/cancion4.mp3", "Trevor Something", 23);
        Cancion ca25 = new Cancion("25", "Technoir", "Digital Evolution", new Image(String.valueOf(getClass().getResource("/imagenes/technoir.jpg"))), "2022", "4:45", "Electronica", "https://ejemplo.com/cancion5.mp3", "Perturbator", 24);

        Artista ar1 = new Artista("1", "Michael Jackson", "Estados Unidos", false, aux);
        Artista ar2 = new Artista("2", "Bad Bunny", "Puerto Rico", false, aux);
        Artista ar3 = new Artista("3", "Don Omar", "Puerto Rico", false, aux);
        Artista ar4 = new Artista("4", "Anuel AA", "Puerto Rico", false, aux);
        Artista ar5 = new Artista("5", "Daddy Yankee", "Puerto Rico", false, aux);
        Artista ar6 = new Artista("6", "Nirvana", "Estados Unidos", true, aux);
        Artista ar7 = new Artista("7", "Metallica", "Estados Unidos", true, aux);

        aniadirCanciones(ca1);
        aniadirCanciones(ca2);
        aniadirCanciones(ca3);
        aniadirCanciones(ca4);
        aniadirCanciones(ca5);
        aniadirCanciones(ca6);
        aniadirCanciones(ca7);
        aniadirCanciones(ca8);
        aniadirCanciones(ca9);
        aniadirCanciones(ca10);
        aniadirCanciones(ca11);
        aniadirCanciones(ca12);
        aniadirCanciones(ca13);
        aniadirCanciones(ca14);
        aniadirCanciones(ca15);
        aniadirCanciones(ca16);
        aniadirCanciones(ca17);
        aniadirCanciones(ca18);
        aniadirCanciones(ca19);
        aniadirCanciones(ca20);
        aniadirCanciones(ca21);
        aniadirCanciones(ca22);
        aniadirCanciones(ca23);
        aniadirCanciones(ca24);
        aniadirCanciones(ca25);

        crearArtistas(ar1);
        crearArtistas(ar2);
        crearArtistas(ar3);
        crearArtistas(ar4);
        crearArtistas(ar5);
        crearArtistas(ar6);
        crearArtistas(ar7);

    }

    public void crearArtistas(Artista artista) {
        ArrayList lista = new ArrayList();
        for (int i = 0; i < listaCanciones.size(); i++) {
            if (listaCanciones.get(i).getNombreArtista().equalsIgnoreCase(artista.getNombre())) {
                lista.add(listaCanciones.get(i));
            }
        }
        artista.setListaCanciones(lista);
        arbolArtistas.insertar(artista);
    }

    public ArbolBinarioArtistas retornarArbol() {
        return arbolArtistas;
    }

    public void aniadirCanciones(Cancion cancion) {
        listaCanciones.add(cancion);
    }

    //Getters y Setters

    public ArbolBinarioArtistas getArbolArtistas() {
        return arbolArtistas;
    }

    public void setArbolArtistas(ArbolBinarioArtistas arbolArtistas) {
        this.arbolArtistas = arbolArtistas;
    }

    public ArrayList<Cancion> getListaCanciones() {
        return listaCanciones;
    }

    public void setListaCanciones(ArrayList<Cancion> listaCanciones) {
        this.listaCanciones = listaCanciones;
    }

    public String eliminarCancion(String codigo) {

        String mensaje = "";

        for (Cancion cancion : listaCanciones) {
            if (cancion.getCodigo().equalsIgnoreCase(codigo)) {
                listaCanciones.remove(cancion);
                for (int i = 0; i < arbolArtistas.buscar(cancion.getNombreArtista()).getListaCanciones().size(); i++) {

                    if (arbolArtistas.buscar(cancion.getNombreArtista()).getListaCanciones().get(i).getCodigo().equalsIgnoreCase(cancion.getCodigo())) {
                        arbolArtistas.buscar(cancion.getNombreArtista()).getListaCanciones().remove(i);
                    }
                }
                mensaje = "Canción eliminada.";
                break;
            }
        }

        if (mensaje.equalsIgnoreCase("")) {

            mensaje = "La canción no se encuentra registrada en la aplicación.";
        }

        return mensaje;
    }

    public String crearCancion(String codigo, String nombreCancion, String nombreAlbum, Image imagen, String anio, String duracion, String genero, String url, String nombreArtista) {

        String resultado = "";
        Cancion cancionEncontrada;
        boolean encontrado = false;
        int indice = 0;

        cancionEncontrada = buscarCancion(codigo);

        if (cancionEncontrada == null) {
            for (int i = 0; i < listaCanciones.size(); i++) {
                if (!listaCanciones.get(i).getNombreArtista().equalsIgnoreCase(nombreArtista) && arbolArtistas.buscar(nombreArtista) == null){
                    encontrado = false;
                } else {
                    encontrado = true;
                    break;
                }
            }

            if (encontrado) {
                cancionEncontrada = new Cancion(codigo, nombreCancion, nombreAlbum, imagen, anio, duracion, genero, url, nombreArtista, indice);
                listaCanciones.add(cancionEncontrada);
                cancionEncontrada.setIndice(listaCanciones.size()-1);
                arbolArtistas.buscar(nombreArtista).getListaCanciones().add(cancionEncontrada);
                resultado = "Canción registrada.";
            } else {
                resultado = "El artista no existe. Debe crearlo.";
            }

        } else {
            resultado = "La canción ya existe.";
        }
        return resultado;

    }

    private Cancion buscarCancion(String codigo) {
        for (Cancion cancion : listaCanciones) {

            if (cancion != null && cancion.getCodigo().equalsIgnoreCase(codigo)) {
                return cancion;
            }
        }

        return null;
    }

    public boolean obtenerCodigo(String cod) {

        for (int i = 0; i < listaCanciones.size(); i++) {

            String aux = listaCanciones.get(i).getCodigo();

            if (aux.equalsIgnoreCase(cod)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Cancion> obtenerListaCanciones() {
        return listaCanciones;
    }

    public boolean obtenerCodigoArtista(String nombre, String cod) {

        if (arbolArtistas.buscar(nombre) == null) {
            return false;
        } else {
            if (arbolArtistas.buscar(nombre).getCodigo().equals(cod)) {
                return true;
            }
        }
        return false;
    }

    public String obtenerCodArtista(String nombre){

        return arbolArtistas.buscar(nombre).getCodigo();
    }

    public String crearArtista(String codigo, String nombreArtista, String nacionalidad, boolean grupo) {

        ArrayList<Cancion> aux = new ArrayList();
        String resultado = "";
        Artista artistaEncontrado;
        artistaEncontrado = buscarArtista(nombreArtista, codigo);

        if (artistaEncontrado == null) {
            artistaEncontrado = new Artista(codigo, nombreArtista, nacionalidad, grupo, aux);
            arbolArtistas.insertar(artistaEncontrado);
            resultado = "Artista creado.";

        } else {
            resultado = "El artista ya existe.";
        }
        return resultado;
    }

    private Artista buscarArtista(String nombre, String codigo) {

        if (arbolArtistas.buscar(nombre) == null) {
            return null;
        } else {
            if (arbolArtistas.buscar(nombre).getCodigo().equalsIgnoreCase(codigo)) {
                return arbolArtistas.buscar(nombre);
            }
        }
        return null;
    }

    private Artista buscarArtistaNombre(String nombre) {

        if (arbolArtistas.buscar(nombre) == null) {
            return null;
        } else {
            return arbolArtistas.buscar(nombre);
        }
    }

    public boolean obtenerArtista(String nombre) {

        if (arbolArtistas.buscar(nombre) == null) {
            return false;
        } else {
            if (arbolArtistas.buscar(nombre).getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    public String eliminarArtista(String nombre) {
        String mensaje = "";

        if(arbolArtistas.buscar(nombre) != null) {

            for (int i = 0; i < listaCanciones.size() ; i++) {
                if(listaCanciones.get(i).getNombreArtista().equalsIgnoreCase(nombre)){
                    listaCanciones.remove(i);
                    i--;
                }
            }
            arbolArtistas.eliminar(nombre);
            mensaje = "Artista eliminado.";

        }else{
            mensaje = "El artista no se encuentra registrado en la aplicación.";
        }

        return mensaje;
    }

    public String actualizarArtista(String codigo, String nombreAnterior, String nacionalidadNueva, boolean grupoNuevo) {

        Artista artista = buscarArtistaNombre(nombreAnterior);
        String mensaje="";

        if (artista != null) {
            artista.setCodigo(codigo);
            artista.setNacionalidad(nacionalidadNueva);
            artista.setGrupo(grupoNuevo);
            mensaje = "Artista actualizado.";

        } else {
            mensaje = "El artista no existe.";
        }

        return mensaje;
    }
}
