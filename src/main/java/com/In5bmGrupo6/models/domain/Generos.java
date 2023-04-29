package com.In5bmGrupo6.models.domain;

/**
 *
 * @author TulioJimènez
 */
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@Table(name = "generos")

@NamedQueries({
    @NamedQuery(name = "Generos.findAll", query = "from Generos"),
    @NamedQuery(name = "Generos.find", query = "from Generos where id_genero = :id")
})

public class Generos implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_genero;
    
    @Column
    private String tipo_genero;

    public Generos() {
    }

    public Generos(int id_genero) {
        this.id_genero = id_genero;
    }

    public Generos(String tipo_genero) {
        this.tipo_genero = tipo_genero;

    }

    public Generos(int id_genero, String tipo_genero) {
        this.id_genero = id_genero;
        this.tipo_genero = tipo_genero;

    }

    public int getId_genero() {
        return id_genero;
    }

    public void setId_genero(int id_genero) {
        this.id_genero = id_genero;
    }

    public String getTipo_genero() {
        return tipo_genero;
    }

    public void setTipo_genero(String tipo_genero) {
        this.tipo_genero = tipo_genero;
    }

    @Override
    public String toString() {
        return "Generos{" + "id_genero=" + id_genero + ", tipo_genero=" + tipo_genero + '}';
    }

    
}
