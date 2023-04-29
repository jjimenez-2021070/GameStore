package com.In5bmGrupo6.models.domain;

/**
 *
 * @author joser
 */
public class Usuarios {

    private int user;
    private String pass;
    private String correo_electronico;
    private int persona_id;
    private int rol_id;
    private String persona;
    private String rol;

    public Usuarios() {
    }

    public Usuarios(int user) {
        this.user = user;
    }    

    public Usuarios(String pass, String correo_electronico, int persona_id, int rol_id) {
        this.user = user;
        this.pass = pass;
        this.correo_electronico = correo_electronico;
        this.persona_id = persona_id;
        this.rol_id = rol_id;
    }
    
    public Usuarios(int user,String pass, String correo_electronico, String persona, String rol) {
        this.user = user;
        this.pass = pass;
        this.correo_electronico = correo_electronico;
        this.persona = persona;
        this.rol = rol;
    }
    
    public Usuarios(String pass, String correo_electronico, String persona, String rol) {
        this.pass = pass;
        this.correo_electronico = correo_electronico;
        this.persona = persona;
        this.rol = rol;
    }

    public Usuarios(int user, String pass, String correo_electronico, int persona_id, int rol_id) {
        this.user = user;
        this.pass = pass;
        this.correo_electronico = correo_electronico;
        this.persona_id = persona_id;
        this.rol_id = rol_id;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public int getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }

    public int getRol_id() {
        return rol_id;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
