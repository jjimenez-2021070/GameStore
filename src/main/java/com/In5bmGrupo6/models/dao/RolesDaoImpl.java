package com.In5bmGrupo6.models.dao;

import com.In5bmGrupo6.db.Conexion;
import com.In5bmGrupo6.models.domain.Roles;
import com.In5bmGrupo6.models.idao.IRolesDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TulioJimènez
 */
public class RolesDaoImpl implements IRolesDAO {

    private static final String SQL_SELECT = "Select id_rol,descripcion_rol from roles";
    private static final String SQL_SELECT_BY_ID = "select id_rol, descripcion_rol from roles where id_rol = ?";
    private static final String SQL_DELETE = "delete from roles where id_rol = ?";
    private static final String SQL_INSERT = "insert into roles(descripcion_rol) values(?)";
    private static final String SQL_UPDATE = "update roles set descripcion_rol=? where id_rol=?";
    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Roles roles = null;
    private List<Roles> listaRoles = new ArrayList<>();

    @Override
    public List<Roles> getAll() {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                roles = new Roles(rs.getInt(1), rs.getString(2));
                listaRoles.add(roles);
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
        return listaRoles;
    }
    
    public Roles get(Roles rol) {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setInt(1, rol.getId_rol());
            System.out.println(pstmt.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                rol = new Roles(rs.getInt("id"), rs.getString("descripcion"));
            }
            System.out.println("rol: " + rol);
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
        return rol;
    }

    @Override
    public int add(Roles roles) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_INSERT);
            pstmt.setString(1, roles.getDescripcion_rol());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Se´produjo un error al intentar insertar el siguiente registro" + roles.toString());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return rows;
    }

    @Override
    public int update(Roles roles) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE);
            pstmt.setString(1, roles.getDescripcion_rol());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Se produjo un error al intentar actualizar el siguiente registro " + roles.toString());
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
    public int delete(Roles roles) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, roles.getId_rol());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Se produjo un error al intetar eliminar el registro : " + roles + "Cuyo ID es : " + roles.getDescripcion_rol());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return rows;
    }

}
