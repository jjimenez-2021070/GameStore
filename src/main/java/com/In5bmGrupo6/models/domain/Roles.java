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
@Table(name = "roles")

@NamedQueries({
    @NamedQuery(name = "Roles.findAll", query = "from Roles"),
    @NamedQuery(name = "Roles.find", query = "from Roles where id_rol = :id")
})


public class Roles implements Serializable {
    
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id_rol;
    
    @Column
    private String descripcion_rol;



    public Roles() {
    }

    public Roles(int id_rol) {
        this.id_rol = id_rol;
    }
    

    public Roles(String descripcion_rol) {
        this.id_rol = id_rol;
        this.descripcion_rol = descripcion_rol;
    }

    public Roles(int id_rol, String descripcion_rol) {
        this.id_rol = id_rol;
        this.descripcion_rol = descripcion_rol;  
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_genero) {
        this.id_rol = id_rol;
    }
    
     public String getDescripcion_rol() {
        return descripcion_rol;
    }

    public void setDescripcion_rol(String descripcion_rol) {
        this.descripcion_rol = descripcion_rol;
    }

    @Override
    public String toString() {
        return "Roles{" + "id_rol=" + id_rol + ", descripcion_rol=" + descripcion_rol + '}';
    }
    
}
