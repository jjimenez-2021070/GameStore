package com.In5bmGrupo6.models.domain;

/**
 *
 * @author sergio
 */

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@Table(name = "distribuidoras")
@NamedQueries({
    @NamedQuery(name = "Distribuidora.findAll", query = "from Distribuidoras"),
    @NamedQuery(name = "Distribuidora.find", query = "from Distribuidoras WHERE id = :id")


})

public class Distribuidoras implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private String nombre_distribuidora;

    public Distribuidoras() {
    }

    public Distribuidoras(int id) {
        this.id = id;
    }

    public Distribuidoras(String nombre_distribuidora) {
        this.nombre_distribuidora = nombre_distribuidora;
    }

    public Distribuidoras(int id, String nombre_distribuidora) {
        this.id = id;
        this.nombre_distribuidora = nombre_distribuidora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_distribuidora() {
        return nombre_distribuidora;
    }

    public void setNombre_distribuidora(String nombre_distribuidora) {
        this.nombre_distribuidora = nombre_distribuidora;
    }

    @Override
    public String toString() {
        return "Distribuidoras{" + "id=" + id + ", nombre_distribuidora=" + nombre_distribuidora + '}';
    }
  
}
