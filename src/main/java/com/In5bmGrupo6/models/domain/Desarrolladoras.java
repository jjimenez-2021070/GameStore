
package com.In5bmGrupo6.models.domain;

/**
 *
 * @author Luis Carlos Pérez
 * @date 3/09/2022
 * @time 12:42:00
 * 
 *Código técnico: IN5BM
 *
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
@Table(name = "empresas_desarrolladoras")

@NamedQueries ({
    @NamedQuery(name = "Desarrolladora.findAll", query = "from Desarrolladoras"),
    @NamedQuery(name = "Desarrolladora.find", query = "from Desarrolladoras where id = :id")
})

public class Desarrolladoras implements Serializable{
    
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column (name = "nombre_desarrolladora")
    private String nombreDesarrolladora;
    
    public Desarrolladoras() {
    }
    
    public Desarrolladoras(int id) {
        this.id = id;
    }
    
    public Desarrolladoras(String nombreDesarrolladora) {
        this.nombreDesarrolladora = nombreDesarrolladora;
    }
    
    public Desarrolladoras (int id, String nombreDesarrolladora) {
        this.id = id;
        this.nombreDesarrolladora = nombreDesarrolladora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreDesarrolladora() {
        return nombreDesarrolladora;
    }

    public void setNombreDesarrolladora(String nombreDesarrolladora) {
        this.nombreDesarrolladora = nombreDesarrolladora;
    }

    @Override
    public String toString() {
        return "Desarrolladoras{" + "id=" + id + ", nombreDesarrolladora=" + nombreDesarrolladora + '}';
    }
    
    
}
