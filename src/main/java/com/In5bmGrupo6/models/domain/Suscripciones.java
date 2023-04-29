
package com.In5bmGrupo6.models.domain;

/**
 *
 * @author Luis Carlos Pérez
 * @date 3/09/2022
 * @time 09:37:37
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
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;

@Entity
@Table (name = "suscripciones")

@NamedQueries({
    @NamedQuery(name = "Suscripcion.findAll", query = "from Suscripciones"),
    @NamedQuery(name = "Suscripcion.find", query = "from Suscripciones where idSuscripcion = :id")
})

public class Suscripciones implements Serializable{
    
    private static final long SERIAL_VERSION_UID = 1L;
    
    @Id
    @Column(name = "id_suscripcion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSuscripcion;
    
    @Column(name = "tipo_suscripcion")
    private String tipoSuscripcion;
    
    public Suscripciones() {    
    }
    
    public Suscripciones(int idSuscripcion) {
        this.idSuscripcion = idSuscripcion;
    }
    
    public Suscripciones(String tipoSuscripcion) {
        this.tipoSuscripcion = tipoSuscripcion;
    }
    
    public Suscripciones(int idSuscripcion, String tipoSuscripcion) {
        this.idSuscripcion = idSuscripcion;
        this.tipoSuscripcion = tipoSuscripcion;
    }

    public int getIdSuscripcion() {
        return idSuscripcion;
    }

    public void setIdSuscripcion(int idSuscripcion) {
        this.idSuscripcion = idSuscripcion;
    }

    public String getTipoSuscripcion() {
        return tipoSuscripcion;
    }

    public void setTipoSuscripcion(String tipoSuscripcion) {
        this.tipoSuscripcion = tipoSuscripcion;
    }

    @Override
    public String toString() {
        return "Suscripciones{" + "idSuscripcion=" + idSuscripcion + ", tipoSuscripcion=" + tipoSuscripcion + '}';
    }
}