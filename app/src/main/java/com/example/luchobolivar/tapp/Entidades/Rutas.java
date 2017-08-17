package com.example.luchobolivar.tapp.Entidades;

/**
 * Created by LuchoBolivar on 7/13/17.
 */

public class Rutas {

    private String id;

    private String nombreRuta;

    private String numeroRuta;

    public Rutas(String id, String nombreRuta, String numeroRuta) {
        this.id = id;
        this.nombreRuta = nombreRuta;
        this.numeroRuta = numeroRuta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreRuta() {
        return nombreRuta;
    }

    public void setNombreRuta(String nombreRuta) {
        this.nombreRuta = nombreRuta;
    }

    public String getNumeroRuta() {
        return numeroRuta;
    }

    public void setNumeroRuta(String numeroRuta) {
        this.numeroRuta = numeroRuta;
    }

    @Override
    public String toString() {
        return numeroRuta +" - "+ nombreRuta;
    }
}
