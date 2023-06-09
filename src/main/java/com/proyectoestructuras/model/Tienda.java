package com.proyectoestructuras.model;

import com.proyectoestructuras.controladores.Singleton;

import java.io.File;
import java.io.Serializable;
import java.util.*;

public class Tienda implements Serializable {
    /* Atributos*/
    ArrayList<Cancion> listaCanciones = new ArrayList<>();
    ArbolBinarioArtistas arbolArtistas = new ArbolBinarioArtistas();
    RepositorioCancionesFavoritas repositorio = new RepositorioCancionesFavoritas();


    //Constructor
    public Tienda() {
        //crear();
    }

    /*Método que crea las canciones y los artistas - Datos quemados*/
    public void crear() {
        ArrayList aux = new ArrayList();


        //ROCK
        Cancion ca1 = new Cancion("1", "Come as you are", "Nevermind", new File(String.valueOf(getClass().getResource("/imagenes/comeAsYouAre.jpg"))), "1991", "3:44", "Rock", "https://www.youtube.com/watch?v=vabnZ9-ex7o", "Nirvana", 0);
        Cancion ca2 = new Cancion("2", "The Unforgiven", "Metallica", new File(String.valueOf(getClass().getResource("/imagenes/theUnforgiven.jpg"))), "1991", "6:28", "Rock", "https://www.youtube.com/watch?v=Ckom3gf57Yw", "Metallica", 1);
        Cancion ca3 = new Cancion("3", "Your Love", "Play Deep", new File(String.valueOf(getClass().getResource("/imagenes/yourLove.jpg"))), "1985", "4:12", "Rock", "https://www.youtube.com/watch?v=4N1iwQxiHrs", "The Outfield", 2);
        Cancion ca4 = new Cancion("4", "I Hate Myself for Loving You", "Up Your Alley", new File(String.valueOf(getClass().getResource("/imagenes/iHateMyself.jpg"))), "1988", "4:17", "Rock", "https://www.youtube.com/watch?v=bpNw7jYkbVc", "Joan Jett & The Blackhearts", 3);
        Cancion ca5 = new Cancion("5", "Supersonic", "Definitely Maybe", new File(String.valueOf(getClass().getResource("/imagenes/supersonic.jpg"))), "1994", "4:29", "Rock", "https://www.youtube.com/watch?v=BJKpUH2kJQg", "Oasis", 4);


        //POP
        Cancion ca6 = new Cancion("6", "Thriller", "Thriller", new File(String.valueOf(getClass().getResource("/imagenes/thriller.jpg"))), "1982", "5:57", "Pop", "https://www.youtube.com/watch?v=sOnqjkJTMaA", "Michael Jackson", 5);
        Cancion ca7 = new Cancion("7", "Billie Jean", "Thriller", new File(String.valueOf(getClass().getResource("/imagenes/billieJean.jpg"))), "1982", "4:54", "Pop", "https://www.youtube.com/watch?v=Zi_XLOBDo_Y", "Michael Jackson", 6);
        Cancion ca8 = new Cancion("8", "Like a Prayer", "Like a Prayer", new File(String.valueOf(getClass().getResource("/imagenes/likeAPrayer.png"))), "1989", "5:39", "Pop", "https://www.youtube.com/watch?v=79fzeNUqQbQ", "Madonna", 7);
        Cancion ca9 = new Cancion("9", "Shape of You", " ", new File(String.valueOf(getClass().getResource("/imagenes/shapeOfYou.jpg"))), "2017", "3:53", "Pop", "https://www.youtube.com/watch?v=JGwWNGJdvx8", "Ed Sheeran", 8);
        Cancion ca10 = new Cancion("10", "Bad Romance", "The Fame Monster", new File(String.valueOf(getClass().getResource("/imagenes/badRomance.jpg"))), "2009", "4:55", "Pop", "https://www.youtube.com/watch?v=qrO4YZeyl0I", "Lady Gaga", 9);


        //REGGAETON

        Cancion ca11 = new Cancion("11", "Despacito", "Fénix", new File(String.valueOf(getClass().getResource("/imagenes/despacito.jpg"))), "2017", "4:42", "Reggaeton", "https://www.youtube.com/watch?v=kJQP7kiw5Fk", "Luis Fonsi", 10);
        Cancion ca12 = new Cancion("12", "Danza Kuduro", "Meet the Orphans", new File(String.valueOf(getClass().getResource("/imagenes/danzaKuduro.jpg"))), "2010", "3:56", "Reggaeton", "https://www.youtube.com/watch?v=7zp1TbLFPp8", "Don Omar", 11);
        Cancion ca13 = new Cancion("13", "Otra Noche en Miami", "Otra Noche en Miami", new File(String.valueOf(getClass().getResource("/imagenes/otraNocheEnMiami.png"))), "2022", "4:11", "Reggaeton", "https://www.youtube.com/watch?v=L5paI9ge4VE", "Bad Bunny", 12);
        Cancion ca14 = new Cancion("14", "Ella Quiere Beber", "Real Hasta La Muerte", new File(String.valueOf(getClass().getResource("/imagenes/EllaQuiereBeber.jpg"))), "2018", "3:37", "Reggaeton", "https://www.youtube.com/watch?v=BTtBmo5EbEk&pp=ygURZWxsYSBxdWllcmUgYmViZXI%3D", "Anuel AA", 13);
        Cancion ca15 = new Cancion("15", "Gasolina", "Barrio Fino", new File(String.valueOf(getClass().getResource("/imagenes/gasolina.jpg"))), "2004", "3:12", "Reggaeton", "https://www.youtube.com/watch?v=QGJuMBdaqIw", "Daddy Yankee", 14);


        //PUNK

        Cancion ca16 = new Cancion("16", "Anarchy in the U.K.", "Never Mind the Bollocks, Here's the Sex Pistols", new File(String.valueOf(getClass().getResource("/imagenes/anarchyInTheUK.jpg"))), "1977", "3:32", "Punk", "https://www.youtube.com/watch?v=cBojbjoMttI", "Here's the Sex Pistols - Sex Pistols", 15);
        Cancion ca17 = new Cancion("17", "Blitzkrieg Bop", "Ramones", new File(String.valueOf(getClass().getResource("/imagenes/blitzkriegBop.jpg"))), "1976", "2:12", "Punk", "https://www.youtube.com/watch?v=6Z66wVo7uNw", "Ramones", 16);
        Cancion ca18 = new Cancion("18", "Should I Stay or Should I Go", "Combat Rock", new File(String.valueOf(getClass().getResource("/imagenes/Should_I_Stay_or_Should_I_Go.png"))), "1982", "3:08", "Punk", "https://www.youtube.com/watch?v=BN1WwnEDWAM", "The Clash", 17);
        Cancion ca19 = new Cancion("19", "Holiday", "American Idiot", new File(String.valueOf(getClass().getResource("/imagenes/greenDay.png"))), "2004", "3:52", "Punk", "https://www.youtube.com/watch?v=A1OqtIqzScI", "Green Day", 18);
        Cancion ca20 = new Cancion("20", "Teenage Kicks", "Teenage Kicks (Single)", new File(String.valueOf(getClass().getResource("/imagenes/teenageKicks.jpg"))), "1978", "2:28", "Punk", "https://www.youtube.com/watch?v=Oy3RhsLN_50", "The Undertones", 19);


        //ELECTRONICA

        Cancion ca21 = new Cancion("21", "Dreams of Loving", "Synthwave Sensations", new File(String.valueOf(getClass().getResource("/imagenes/dreamsOfLoving.jpg"))), "2023", "4:30", "Electronica", "https://ejemplo.com/cancion1.mp3", "The Human League", 20);
        Cancion ca22 = new Cancion("22", "Future Pulse", "Digital Paradigm", new File(String.valueOf(getClass().getResource("/imagenes/futurePulse.jpg"))), "2022", "5:12", "Electronica", "https://ejemplo.com/cancion2.mp3", "Scandroid", 21);
        Cancion ca23 = new Cancion("23", "Neon Nights", "Retro Electro Vibes", new File(String.valueOf(getClass().getResource("/imagenes/neonNights.jpg"))), "2021", "3:58", "Electronica", "https://ejemplo.com/cancion3.mp3", "Kraftwerk", 22);
        Cancion ca24 = new Cancion("24", "Synthetic Love", "Cyber Beats", new File(String.valueOf(getClass().getResource("/imagenes/syntheticLove.jpg"))), "2023", "6:02", "Electronica", "https://ejemplo.com/cancion4.mp3", "Trevor Something", 23);
        Cancion ca25 = new Cancion("25", "Technoir", "Digital Evolution", new File(String.valueOf(getClass().getResource("/imagenes/technoir.jpg"))), "2022", "4:45", "Electronica", "https://ejemplo.com/cancion5.mp3", "Perturbator", 24);

        Artista ar1 = new Artista("1", "Michael Jackson", "Estados Unidos", false, aux);
        Artista ar2 = new Artista("2", "Bad Bunny", "Puerto Rico", false, aux);
        Artista ar3 = new Artista("3", "Don Omar", "Puerto Rico", false, aux);
        Artista ar4 = new Artista("4", "Anuel AA", "Puerto Rico", false, aux);
        Artista ar5 = new Artista("5", "Daddy Yankee", "Puerto Rico", false, aux);
        Artista ar6 = new Artista("6", "Nirvana", "Estados Unidos", true, aux);
        Artista ar7 = new Artista("7", "Metallica", "Estados Unidos", true, aux);
        Artista ar8 = new Artista("8", "The Outfield", "Estados Unidos", true, aux);
        Artista ar9 = new Artista("9", "Joan Jett & The Blackhearts", "Estados Unidos", true, aux);
        Artista ar10 = new Artista("10", "Oasis", "Estados Unidos", true, aux);
        Artista ar11 = new Artista("11", "Madonna", "Estados Unidos", true, aux);
        Artista ar12 = new Artista("12", "Ed Sheeran", "Estados Unidos", true, aux);
        Artista ar13 = new Artista("13", "LadyGaga", "Estados Unidos", true, aux);
        Artista ar14 = new Artista("14", "Luis Fonsi", "Estados Unidos", true, aux);
        Artista ar15 = new Artista("15", "Here's the Sex Pistols - Sex Pistols", "Estados Unidos", true, aux);
        Artista ar16 = new Artista("16", "The Clash", "Estados Unidos", true, aux);
        Artista ar17 = new Artista("17", "Green Day", "Estados Unidos", true, aux);
        Artista ar18 = new Artista("18", "The Undertones", "Estados Unidos", true, aux);
        Artista ar19 = new Artista("19", "The Human League", "Estados Unidos", true, aux);
        Artista ar20 = new Artista("20", "Scandroid", "Estados Unidos", true, aux);
        Artista ar21 = new Artista("21", "Kraftwerk", "Estados Unidos", true, aux);
        Artista ar22 = new Artista("22", "Trevor Something", "Estados Unidos", true, aux);
        Artista ar23 = new Artista("23", "Perturbator", "Estados Unidos", true, aux);
        Artista ar24 = new Artista("24", "Ramones", "Estados Unidos", true, aux);


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
        crearArtistas(ar8);
        crearArtistas(ar9);
        crearArtistas(ar10);
        crearArtistas(ar11);
        crearArtistas(ar12);
        crearArtistas(ar13);
        crearArtistas(ar14);
        crearArtistas(ar15);
        crearArtistas(ar16);
        crearArtistas(ar17);
        crearArtistas(ar18);
        crearArtistas(ar19);
        crearArtistas(ar20);
        crearArtistas(ar21);
        crearArtistas(ar22);
        crearArtistas(ar23);
        crearArtistas(ar24);

    }


    public RepositorioCancionesFavoritas getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(RepositorioCancionesFavoritas repositorio) {
        this.repositorio = repositorio;
    }

    /*
     * Metodo que crea los artistas y los inserta en el arbol.
     * Le agrega a cada artista su lista de canciones.
     */
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

    /*
     * Metodo que recibe un codigo y busca la cancion en la lista de canciones.
     * Si la encuentra, la elimina de la lista de canciones y de la lista de canciones del artista.
     */
    public String eliminarCancion(String nom) {

        String mensaje = "";

        for (Cancion cancion : listaCanciones) {
            if (cancion.getNombre().equalsIgnoreCase(nom)) {
                listaCanciones.remove(cancion);
                for (int i = 0; i < arbolArtistas.buscar(cancion.getNombreArtista()).getListaCanciones().size(); i++) {
                    if (arbolArtistas.buscar(cancion.getNombreArtista()).getListaCanciones().get(i).getNombre().equalsIgnoreCase(cancion.getNombre())) {
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

    /*
     * Metodo que recibe los parametros para crear una canción.
     * Se busca en la lista de canciones mediante el código,
     * si no la encuentra, la crea y la agrega a la lista de canciones y a la lista de canciones del artista.
     */
    public String crearCancion(String codigo, String nombreCancion, String nombreAlbum, File Filen, String anio, String duracion, String genero, String url, String nombreArtista) {

        String resultado = "";
        Cancion cancionEncontrada;
        boolean encontrado = false;
        int indice = 0;

        cancionEncontrada = buscarCancion(codigo);

        if (cancionEncontrada == null) {
            for (int i = 0; i < listaCanciones.size(); i++) {
                if (!listaCanciones.get(i).getNombreArtista().equalsIgnoreCase(nombreArtista) && arbolArtistas.buscar(nombreArtista) == null) {
                    encontrado = false;
                } else {
                    encontrado = true;
                    break;
                }
            }

            if (encontrado) {
                cancionEncontrada = new Cancion(codigo, nombreCancion, nombreAlbum, Filen, anio, duracion, genero, url, nombreArtista, indice);
                listaCanciones.add(cancionEncontrada);
                cancionEncontrada.setIndice(listaCanciones.size() - 1);
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

    /*Método que busca una canción en la lista de cancionoes mediante el código*/

    private Cancion buscarCancion(String codigo) {
        for (Cancion cancion : listaCanciones) {

            if (cancion != null && cancion.getCodigo().equalsIgnoreCase(codigo)) {
                return cancion;
            }
        }

        return null;
    }

    /*
    Método que verifica si una canción existe o no mediante el codigo
     */
    public boolean obtenerCodigo(String cod) {

        for (int i = 0; i < listaCanciones.size(); i++) {

            String aux = listaCanciones.get(i).getCodigo();

            if (aux.equalsIgnoreCase(cod)) {
                return true;
            }
        }
        return false;
    }

    public boolean obtenerNom(String nom) {

        for (int i = 0; i < listaCanciones.size(); i++) {

            String aux = listaCanciones.get(i).getNombre();

            if (aux.equalsIgnoreCase(nom)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Cancion> obtenerListaCanciones() {
        return listaCanciones;
    }

    /* Método que verifica si el artista existe, y si el código de dicho artista es igual al que se pasa por parámetro.*/
    public boolean obtenerNomArtista(String nombre) {

        if (arbolArtistas.buscar(nombre) == null) {
            return false;
        } else {
            if (arbolArtistas.buscar(nombre).getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    /* Método que obtiene el código de un artista.*/
    public String obtenerCodArtista(String nombre) {

        return arbolArtistas.buscar(nombre).getCodigo();
    }

    /*Método que crea un artista.
    Recibe los parámetros para crear un artista, y verifica si el artista ya existe o no. Si no existe, lo agrega al arbol de artistas.
     */
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

    /* Método que busca a un artista en el arbol de artistas mediante el nombre y el código.
     * Si lo encuentra devuelve al artista, si no null.*/

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

    /* Método que busca a un artista en el arbol de artistas mediante el nombre.
     * Si lo encuentra devuelve al artista, si no null.
     */
    private Artista buscarArtistaNombre(String nombre) {

        if (arbolArtistas.buscar(nombre) == null) {
            return null;
        } else {
            return arbolArtistas.buscar(nombre);
        }
    }

    /* Método que verifica si existe un artista con el nombre que se pasa por parámetro.*/

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

    /*
    Método que elimina un artista de la aplicación.
    Recibe el nombre del artista que se desea eliminar.
    Verifica si el artista existe o no, y si existe, lo elimina del arbol de artistas y de la lista de canciones.
     */
    public String eliminarArtista(String nombre) {
        String mensaje = "";

        if (arbolArtistas.buscar(nombre) != null) {

            for (int i = 0; i < listaCanciones.size(); i++) {
                if (listaCanciones.get(i).getNombreArtista().equalsIgnoreCase(nombre)) {
                    listaCanciones.remove(i);
                    i--;
                }
            }
            arbolArtistas.eliminar(nombre);
            mensaje = "Artista eliminado.";

        } else {
            mensaje = "El artista no se encuentra registrado en la aplicación.";
        }

        return mensaje;
    }

    /*
    Método que actualiza los datos de un artista.
    Recibe el nombre del artista, y los datos a actualizar: el código, la nueva nacionalidad y si es grupo o no.
     */
    public String actualizarArtista(String codigo, String nombreAnterior, String nacionalidadNueva, boolean grupoNuevo) {

        Artista artista = buscarArtistaNombre(nombreAnterior);
        String mensaje = "";

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


    public boolean obtenerNomCancion(String nombreCancion) {

        for (int i = 0; i < listaCanciones.size(); i++) {
            if (listaCanciones.get(i).getNombre().equalsIgnoreCase(nombreCancion)) {
                return true;
            }
        }
        return false;
    }

    public String actualizarCancion(String codigo, String nombreCancion, String nombreAlbum, File file, String anio, String duracion, String genero, String url, String nombreArtista) {

        //Cancion cancion = buscarCancionNombre(nombreCancion);
        String mensaje = "";
        for (int i = 0; i <listaCanciones.size() ; i++) {
            if(listaCanciones.get(i).getNombre().equalsIgnoreCase(nombreCancion)){
                listaCanciones.get(i).setCodigo(codigo);
                listaCanciones.get(i).setNombreAlbum(nombreAlbum);
                listaCanciones.get(i).setCaratula(file);
                listaCanciones.get(i).setAnio(anio);
                listaCanciones.get(i).setDuracion(duracion);
                listaCanciones.get(i).setGenero(genero);
                listaCanciones.get(i).setUrl(url);
                listaCanciones.get(i).setNombreArtista(nombreArtista);
                mensaje = "Canción actualizada.";
                break;
            }
        }
        return mensaje;
    }

    private Cancion buscarCancionNombre(String nombreCancion) {

        for (int i = 0; i <listaCanciones.size() ; i++) {
            if(listaCanciones.get(i).getNombre().equalsIgnoreCase(nombreCancion)){
                return listaCanciones.get(i);
            }
        }
        return null;
    }
}
