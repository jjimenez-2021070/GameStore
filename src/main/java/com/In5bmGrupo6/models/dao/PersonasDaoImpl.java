package com.In5bmGrupo6.models.dao;

import com.In5bmGrupo6.models.domain.Personas;
import com.In5bmGrupo6.models.idao.IPersonaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.In5bmGrupo6.db.Conexion;
import java.sql.SQLException;

/**
 *
 * @author Roberto Saldaña
 * @date 30-08-2022
 * @time 08:55:00 AM Código Técnico: IN5BM
 */
public class PersonasDaoImpl implements IPersonaDAO {

    private static final String SQL_SELECT = "Select id_persona, nombre1, nombre2, nombre3, apellido1, apellido2, email, fecha_nacimiento, telefono, direccion from personas";
    private static final String SQL_SELECT_BY_ID = "Select id_persona, nombre1, nombre2, nombre3, apellido1, apellido2, email, fecha_nacimiento, telefono, direccion from personas where id_persona = ?";
    private static final String SQL_DELETE = "Delete from personas where id_persona = ?";
    private static final String SQL_INSERT = "insert into personas(nombre1, nombre2, nombre3, apellido1, apellido2, email, fecha_nacimiento, telefono, direccion) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "update personas set nombre1=?, nombre2=?, nombre3=?, apellido1=?, apellido2=?, email=?, fecha_nacimiento=?, telefono=?, direccion=? where id_persona = ?";
    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Personas persona = null;
    private List<Personas> listaPersonas = new ArrayList<>();

    @Override
    public List<Personas> getAll() {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                persona = new Personas(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDate(8), rs.getString(9), rs.getString(10));
                listaPersonas.add(persona);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(con);
        }
        return listaPersonas;
    }
    
    public Personas get(Personas persona) {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setInt(1, persona.getId_persona());
            System.out.println(pstmt.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                persona = new Personas(rs.getInt("id_persona"), rs.getString("nombre1"), rs.getString("nombre2"), rs.getString("nombre3"), rs.getString("apellido1"), rs.getString("apellido2"), rs.getString("email"), rs.getDate("fecha_nacimiento"), rs.getString("telefono"), rs.getString("direccion"));
            }
            System.out.println("persona: " + persona);
        } catch (SQLException e) {
            System.out.println("\nSQLException\n");
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(con);
        }
        return persona;
    }

    @Override
    public int add(Personas persona) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_INSERT);
            pstmt.setString(1, persona.getNombre1());
            pstmt.setString(2, persona.getNombre2());
            pstmt.setString(3, persona.getNombre3());
            pstmt.setString(4, persona.getApellido1());
            pstmt.setString(5, persona.getApellido2());
            pstmt.setString(6, persona.getEmail());
            pstmt.setDate(7, persona.getFecha_nacimiento());
            pstmt.setString(8, persona.getTelefono());
            pstmt.setString(9, persona.getDireccion());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Se´produjo un error al intentar insertar el siguiente registro" + persona.toString());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return rows;
    }

    @Override
    public int update(Personas persona) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE);
            pstmt.setString(1, persona.getNombre1());
            pstmt.setString(2, persona.getNombre2());
            pstmt.setString(3, persona.getNombre3());
            pstmt.setString(4, persona.getApellido1());
            pstmt.setString(5, persona.getApellido2());
            pstmt.setString(6, persona.getEmail());
            pstmt.setDate(7, persona.getFecha_nacimiento());
            pstmt.setString(8, persona.getTelefono());
            pstmt.setString(9, persona.getDireccion());
            pstmt.setInt(10, persona.getId_persona());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Se produjo un error al intentar actualizar el siguiente registro " + persona.toString());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(pstmt);
            Conexion.close(con);
        }
        return rows;
    }

    @Override
    public int delete(Personas persona) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, persona.getId_persona());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Se produjo un error al intentar eliminar el registro con el id: " + persona.getId_persona());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        return rows;
    }
}
