package com.In5bmGrupo6.models.domain;

import java.sql.Date;

/**
 *
 * @author joser
 */

public class ListaDeseados {
    
    private int id_lista;
    private int juego_id;
    private Date fecha_agregado;
    private int cliente_id;

    public ListaDeseados() {
    }

    public ListaDeseados(int id_lista) {
        this.id_lista = id_lista;
    }

    public ListaDeseados(int juego_id, Date fecha_agregado, int cliente_id) {
        this.juego_id = juego_id;
        this.fecha_agregado = fecha_agregado;
        this.cliente_id = cliente_id;
    }

    public ListaDeseados(int id_lista, int juego_id, Date fecha_agregado, int cliente_id) {
        this.id_lista = id_lista;
        this.juego_id = juego_id;
        this.fecha_agregado = fecha_agregado;
        this.cliente_id = cliente_id;
    }

    public int getId_lista() {
        return id_lista;
    }

    public void setId_lista(int id_lista) {
        this.id_lista = id_lista;
    }

    public int getJuego_id() {
        return juego_id;
    }

    public void setJuego_id(int juego_id) {
        this.juego_id = juego_id;
    }

    public Date getFecha_agregado() {
        return fecha_agregado;
    }

    public void setFecha_agregado(Date fecha_agregado) {
        this.fecha_agregado = fecha_agregado;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }
}
