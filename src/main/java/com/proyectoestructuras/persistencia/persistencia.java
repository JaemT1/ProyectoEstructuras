package com.proyectoestructuras.persistencia;

import com.proyectoestructuras.model.Tienda;

public class persistencia {
    public static final String RUTA_ARCHIVO_MODELO_TIENDA_BINARIO = "src/persistencia/model.dat";
    public static final String RUTA_ARCHIVO_MODELO_TIENDA_XML = "src/persistencia/model.xml";

    // ------------------------------------SERIALIZACION y XML----------------------------------------------------------
    public static Tienda cargarRecursoTiendaBinario() {
        Tienda tienda = null;
        try {
            tienda = (Tienda) ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_TIENDA_BINARIO);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return tienda;
    }

    public static void guardarRecursoTiendaBinario(Tienda tienda) {

        try {
            ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_TIENDA_BINARIO, tienda);
            // Revisar si en binario guarda el tipo Image, de lo contrario, hay que
            // buscar cómo hacerlo
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Tienda cargarRecursoTiendaXML() {
        Tienda tienda = null;
        try {
            tienda = (Tienda) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_TIENDA_XML);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tienda;
    }

    public static void guardarRecursoTiendaXML(Tienda tienda) {
        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_TIENDA_XML, tienda);
            // Revisar si en XML también guarda el tipo Image, de lo contrario, hay
            // que buscar cómo hacerlo
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
