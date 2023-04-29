package com.In5bmGrupo6.models.domain;

import java.sql.Date;

/**
 *
 * @author joser
 */
public class Juegos {

    private int id_juego;
    private String nombre_juego;
    private Date fecha_lanzamiento;
    private int precio;
    private int desarrolladora_id;
    private int distribuidora_id;
    private int genero_id;

    public Juegos() {
    }

    public Juegos(int id_juego) {
        this.id_juego = id_juego;
    }

    public Juegos(String nombre_juego, Date fecha_lanzamiento, int precio, int desarrolladora_id, int distribuidora_id, int genero_id) {
        this.nombre_juego = nombre_juego;
        this.fecha_lanzamiento = fecha_lanzamiento;
        this.precio = precio;
        this.desarrolladora_id = desarrolladora_id;
        this.distribuidora_id = distribuidora_id;
        this.genero_id = genero_id;
    }   

    public Juegos(int id_juego, String nombre_juego, Date fecha_lanzamiento, int precio, int desarrolladora_id, int distribuidora_id, int genero_id) {
        this.id_juego = id_juego;
        this.nombre_juego = nombre_juego;
        this.fecha_lanzamiento = fecha_lanzamiento;
        this.precio = precio;
        this.desarrolladora_id = desarrolladora_id;
        this.distribuidora_id = distribuidora_id;
        this.genero_id = genero_id;
    }

    public int getId_juego() {
        return id_juego;
    }

    public void setId_juego(int id_juego) {
        this.id_juego = id_juego;
    }

    public String getNombre_juego() {
        return nombre_juego;
    }

    public void setNombre_juego(String nombre_juego) {
        this.nombre_juego = nombre_juego;
    }

    public Date getFecha_lanzamiento() {
        return fecha_lanzamiento;
    }

    public void setFecha_lanzamiento(Date fecha_lanzamiento) {
        this.fecha_lanzamiento = fecha_lanzamiento;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getDesarrolladora_id() {
        return desarrolladora_id;
    }

    public void setDesarrolladora_id(int desarrolladora_id) {
        this.desarrolladora_id = desarrolladora_id;
    }

    public int getDistribuidora_id() {
        return distribuidora_id;
    }

    public void setDistribuidora_id(int distribuidora_id) {
        this.distribuidora_id = distribuidora_id;
    }

    public int getGenero_id() {
        return genero_id;
    }

    public void setGenero_id(int genero_id) {
        this.genero_id = genero_id;
    }
}
