package com.In5bmGrupo6.models.domain;

/**
 *
 * @author Sergio Cruz Velasquez 
 * @date Sep 2, 2022
 * @time 10:21:30 PM
 *
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
@Table(name = "clientes")
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "from Clientes"),
    @NamedQuery(name = "Clientes.find", query = "from Clientes WHERE id_cliente = :id_cliente")
})

public class Clientes implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cliente;
    
    @Column
    private String nit;
    
    @Column
    private int persona_id;
    
    @Column
    private int suscripcion_id;

    public Clientes() {
    }

    public Clientes(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Clientes(String nit, int persona_id, int suscripcion_id) {
        this.nit = nit;
        this.persona_id = persona_id;
        this.suscripcion_id = suscripcion_id;
    }

    public Clientes(int id_cliente, String nit, int persona_id, int suscripcion_id) {
        this.id_cliente = id_cliente;
        this.nit = nit;
        this.persona_id = persona_id;
        this.suscripcion_id = suscripcion_id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public int getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }

    public int getSuscripcion_id() {
        return suscripcion_id;
    }

    public void setSuscripcion_id(int suscripcion_id) {
        this.suscripcion_id = suscripcion_id;
    }

    @Override
    public String toString() {
        return "Clientes{" + "id_cliente=" + id_cliente + ", nit=" + nit + ", persona_id=" + persona_id + ", suscripcion_id=" + suscripcion_id + '}';
    }
    
    
    
}
