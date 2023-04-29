package com.In5bmGrupo6.models.domain;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author joser
 */

@Entity
@Table(name = "personas")
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "from Personas"),
    @NamedQuery(name = "Persona.find", query = "from Personas where id_persona = :id")
})

public class Personas implements Serializable{
    
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_persona;
    
    @Column (name = "nombre1")
    private String nombre1;
    
    @Column (name = "nombre2")
    private String nombre2;
    
    @Column (name = "nombre3")
    private String nombre3;
    
    @Column (name = "apellido1")
    private String apellido1;
    
    @Column (name = "apellido2")
    private String apellido2;
    
    @Column (name = "email")
    private String email;
    
    @Column (name = "fecha_nacimiento")
    private Date fecha_nacimiento;
    
    @Column (name = "telefono")
    private String telefono;
    
    @Column (name = "direccion")
    private String direccion;

    public Personas() {
    }

    public Personas(int id_persona) {
        this.id_persona = id_persona;
    }

    public Personas(String nombre1, String nombre2, String nombre3, String apellido1, String apellido2, String email, Date fecha_nacimiento, String telefono, String direccion) {
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.nombre3 = nombre3;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.email = email;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Personas(int id_persona, String nombre1, String nombre2, String nombre3, String apellido1, String apellido2, String email, Date fecha_nacimiento, String telefono, String direccion) {
        this.id_persona = id_persona;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.nombre3 = nombre3;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.email = email;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getNombre3() {
        return nombre3;
    }

    public void setNombre3(String nombre3) {
        this.nombre3 = nombre3;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
