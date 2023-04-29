package com.In5bmGrupo6.models.dao;

import com.In5bmGrupo6.models.domain.Usuarios;
import com.In5bmGrupo6.models.idao.IUsuarioDAO;
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
public class UsuariosDaoImpl implements IUsuarioDAO {

    private static final String SQL_SELECT = "select usuarios.user, usuarios.pass, usuarios.correo_electronico, concat(personas.nombre1, \" \",personas.nombre2, \" \",personas.nombre3, \" \",personas.apellido1, \" \",personas.apellido2), roles.descripcion_rol from personas, usuarios inner join roles where roles.id_rol=usuarios.rol_id and personas.id_persona=usuarios.persona_id";
    private static final String SQL_SELECT_BY_ID = "Select user, pass, correo_electronico, persona_id, rol_id from usuarios where user = ?";
    private static final String SQL_DELETE = "Delete from usuarios where user = ?";
    private static final String SQL_INSERT = "insert into usuarios(pass,rol_id,correo_electronico,persona_id) values(?,?,?,?);";
    private static final String SQL_UPDATE = "update usuarios set pass=?, correo_electronico=?, persona_id=?, rol_id=? where user = ?";
    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Usuarios usuario = null;
    private List<Usuarios> listaUsuarios = new ArrayList<>();

    @Override
    public List<Usuarios> getAll() {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                usuario = new Usuarios(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                listaUsuarios.add(usuario);
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
        return listaUsuarios;
    }
    
    public Usuarios get(Usuarios usuario) {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setInt(1, usuario.getUser());
            System.out.println(pstmt.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                usuario = new Usuarios(rs.getInt("user"), rs.getString("pass"), rs.getString("correo_electronico"), rs.getInt("persona_id"), rs.getInt("rol_id"));
            }
            System.out.println("usuario: " + usuario);
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
        return usuario;
    }

    @Override
    public int add(Usuarios usuario) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_INSERT);
            pstmt.setString(1, usuario.getPass());
            pstmt.setInt(2, usuario.getRol_id());
            pstmt.setString(3, usuario.getCorreo_electronico());
            pstmt.setInt(4, usuario.getPersona_id());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Se produjo un error al intentar insertar el siguiente registro" + usuario.toString());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return rows;
    }

    @Override
    public int update(Usuarios usuario) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE);
            pstmt.setString(1, usuario.getPass());
            pstmt.setString(2, usuario.getCorreo_electronico());
            pstmt.setString(3, usuario.getPersona());
            pstmt.setString(4, usuario.getRol());
            pstmt.setInt(5, usuario.getUser());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Se produjo un error al intentar actualizar el siguiente registro " + usuario.toString());
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
    public int delete(Usuarios usuario) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, usuario.getUser());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Se produjo un error al intentar eliminar el registro con el id: " + usuario.getUser());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        return rows;
    }

}
