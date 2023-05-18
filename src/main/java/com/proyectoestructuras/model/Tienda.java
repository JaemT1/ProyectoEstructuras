package com.proyectoestructuras.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.Serializable;
import java.util.*;

public class Tienda implements Serializable {
    //Atributos

    ArrayList<Cancion> listaCanciones = new ArrayList<Cancion>();
    ArbolBinarioArtistas arbolArtistas = new ArbolBinarioArtistas();
    Usuario usuarioLogeado;

    //Constructor
    public Tienda() {

        crearCanciones();

    }

    public void crearCanciones() {

        //ROCK
        System.out.println(getClass().getResource("/imagenes/comeAsYouAre.jpg"));
        Cancion ca1 = new Cancion("1", "Come as you are", "Nevermind", new Image(String.valueOf(getClass().getResource("/imagenes/supersonic.jpg"))) , "1991", "3:44", "rock", "https://www.youtube.com/watch?v=vabnZ9-ex7o");
        aniadirCanciones(ca1);
        /**Cancion ca2 = new Cancion("2", "The Unforgiven", "Metallica", new Image("/imagenes/comeAsYouAre.jpg"), "1991", "6:28", "Rock", "https://www.youtube.com/watch?v=Ckom3gf57Yw");
        Cancion ca3 = new Cancion("3", "Your Love", "Play Deep", new Image("/imagenes/yourLove.jpg"), "1985", "4:12", "Rock", "https://www.youtube.com/watch?v=4N1iwQxiHrs");
        Cancion ca4 = new Cancion("4", "I Hate Myself for Loving You", "Up Your Alley", new Image("/imagenes/iHateMyself.jpg"), "1988", "4:17", "Rock", "https://www.youtube.com/watch?v=bpNw7jYkbVc");
        Cancion ca5 = new Cancion("5", "Supersonic", "Definitely Maybe", new Image("/imagenes/supersonic.jpg"), "1994", "4:29", "Rock","https://www.youtube.com/watch?v=BJKpUH2kJQg" );


        //POP
        Cancion ca6 = new Cancion("6", "Thriller", "Thriller", new Image("/imagenes/thriller.jpg"), "1982", "5:57", "Pop", "https://www.youtube.com/watch?v=sOnqjkJTMaA");
        Cancion ca7 = new Cancion("7", "Billie Jean", "Thriller", new Image("/imagenes/billieJean.jpg"), "1982", "4:54", "Pop", "https://www.youtube.com/watch?v=Zi_XLOBDo_Y");
        Cancion ca8 = new Cancion("8", "Like a Prayer", "Like a Prayer", new Image("/imagenes/comeAsYouAre.jpg"), "1989", "5:39", "Pop", "https://www.youtube.com/watch?v=79fzeNUqQbQ");
        Cancion ca9 = new Cancion("9", "Shape of You", " ", new Image("/imagenes/shapeOfYou.jpg"), "2017", "3:53", "Pop", "https://www.youtube.com/watch?v=JGwWNGJdvx8");
        Cancion ca10 = new Cancion("10", "Bad Romance", "The Fame Monster", new Image("/imagenes/badRomance.jpg"), "2009", "4:55", "Pop", "https://www.youtube.com/watch?v=qrO4YZeyl0I");


        //REGGAETON

        Cancion ca11 = new Cancion("11","Despacito", "Fénix",new Image("/imagenes/despacito.jpg"),"2017", "4:42", "Reggaeton","https://www.youtube.com/watch?v=kJQP7kiw5Fk");
        Cancion ca12 = new Cancion("12","Danza Kuduro", "Meet the Orphans",new Image("/imagenes/danzaKuduro.jpg"),"2010", "3:56", "Reggaeton","https://www.youtube.com/watch?v=7zp1TbLFPp8");
        Cancion ca13 = new Cancion("13","Otra Noche en Miami", "Otra Noche en Miami",new Image("/imagenes/comeAsYouAre.jpg"),"2022", "4:11", "Reggaeton","https://www.youtube.com/watch?v=L5paI9ge4VE");
        Cancion ca14 = new Cancion("14","Ella Quiere Beber", "Real Hasta La Muerte",new Image("/imagenes/EllaQuiereBeber.jpg"),"2018", "3:37", "Reggaeton","https://www.youtube.com/watch?v=2DI9bMmBZcY");
        Cancion ca15 = new Cancion("15","Gasolina", "Barrio Fino",new Image("/imagenes/gasolina.jpg"),"2004", "3:12", "Reggaeton","https://www.youtube.com/watch?v=QGJuMBdaqIw");


        //PUNK

        Cancion ca16 = new Cancion("16","Anarchy in the U.K.", "Never Mind the Bollocks, Here's the Sex Pistols",new Image("/imagenes/comeAsYouAre.jpg"),"1977", "3:32", "Punk","https://www.youtube.com/watch?v=cBojbjoMttI");
        Cancion ca17 = new Cancion("17","Blitzkrieg Bop", "Ramones",new Image("/imagenes/comeAsYouAre.jpg"),"1976", "2:12", "Punk","https://www.youtube.com/watch?v=6Z66wVo7uNw");
        Cancion ca18 = new Cancion("18","Should I Stay or Should I Go", "Combat Rock",new Image("/imagenes/Should_I_Stay_or_Should_I_Go.png"),"1982", "3:08", "Punk","https://www.youtube.com/watch?v=BN1WwnEDWAM");
        Cancion ca19 = new Cancion("19","Holiday", "American Idiot",new Image("/imagenes/comeAsYouAre.jpg"),"2004", "3:52", "Punk","https://www.youtube.com/watch?v=A1OqtIqzScI");
        Cancion ca20 = new Cancion("20","Teenage Kicks", "Teenage Kicks (Single)",new Image("/imagenes/comeAsYouAre.jpg"),"1978", "2:28", "Punk","https://www.youtube.com/watch?v=Oy3RhsLN_50");


        //ELECTRONICA

        Cancion ca21 = new Cancion("21", "Electric Dreams", "Synthwave Sensations", new Image("/imagenes/comeAsYouAre.jpg"), "2023", "4:30", "Electrónica", "https://ejemplo.com/cancion1.mp3");
        Cancion ca22= new Cancion("22", "Future Pulse", "Digital Paradigm", new Image("/imagenes/comeAsYouAre.jpg"), "2022", "5:12", "Electrónica", "https://ejemplo.com/cancion2.mp3");
        Cancion ca23 = new Cancion("23", "Neon Nights", "Retro Electro Vibes",new Image("/imagenes/comeAsYouAre.jpg"), "2021", "3:58", "Electrónica", "https://ejemplo.com/cancion3.mp3");
        Cancion ca24 = new Cancion("24", "Synthetic Serenity", "Cyber Beats",new Image("/imagenes/comeAsYouAre.jpg"), "2023", "6:02", "Electrónica", "https://ejemplo.com/cancion4.mp3");
        Cancion ca25 = new Cancion("25", "Techno Fusion", "Digital Evolution",new Image("/imagenes/comeAsYouAre.jpg"), "2022", "4:45", "Electrónica", "https://ejemplo.com/cancion5.mp3");

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
        aniadirCanciones(ca25);*/
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

    public Usuario getUsuarioLogeado() {
        return usuarioLogeado;
    }

    public void setUsuarioLogeado(Usuario usuarioLogeado) {
        this.usuarioLogeado = usuarioLogeado;
    }


}
