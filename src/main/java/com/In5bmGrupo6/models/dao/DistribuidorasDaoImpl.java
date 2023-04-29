package com.In5bmGrupo6.models.dao;

import com.In5bmGrupo6.models.domain.Distribuidoras;
import com.In5bmGrupo6.models.idao.IDistribuidorasDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.In5bmGrupo6.db.Conexion;
import java.sql.SQLException;

/**
 *
 * @author sergio
 * @date 30-08-2022
 * @time 08:55:00 AM Código Técnico: IN5BM
 */
public class DistribuidorasDaoImpl implements IDistribuidorasDAO {

    private static final String SQL_SELECT = "select id, nombre_distribuidora from distribuidoras";
    private static final String SQL_SELECT_BY_ID = "select id, nombre_distribuidora from distribuidoras where id = ?";
    private static final String SQL_DELETE = "Delete from distribuidoras where id = ?";
    private static final String SQL_INSERT = "insert into distribuidoras(nombre_distribuidora) values(?)";
    private static final String SQL_UPDATE = "update distribuidoras set nombre_distribuidora=? where id = ?";
    
    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Distribuidoras distribuidoras = null;
    private List<Distribuidoras> listaDistribuidoras = new ArrayList<>();

    @Override
    public List<Distribuidoras> getAll() {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                distribuidoras = new Distribuidoras(rs.getInt(1), rs.getString(2));
                listaDistribuidoras.add(distribuidoras);
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
        return listaDistribuidoras;
    }

    public Distribuidoras get(Distribuidoras distribuidora) {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setInt(1, distribuidora.getId());
            System.out.println(pstmt.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                distribuidora = new Distribuidoras(rs.getInt("id"), rs.getString("nombre_distribuidora"));
            }
            System.out.println("distribuidora: " + distribuidora);
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
        return distribuidora;
    }
    
    @Override
    public int add(Distribuidoras distribuidoras) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_INSERT);
            pstmt.setString(1, distribuidoras.getNombre_distribuidora());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Se´produjo un error al intentar insertar el siguiente registro" + distribuidoras.toString());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return rows;
    }

    @Override
    public int update(Distribuidoras distribuidoras) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE);
            pstmt.setString(1, distribuidoras.getNombre_distribuidora());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Se produjo un error al intentar actualizar el siguiente registro " + distribuidoras.toString());
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
    public int delete(Distribuidoras distribuidoras) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, distribuidoras.getId());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Se produjo un error al intentar eliminar el registro con el id: " + distribuidoras.getId());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        return rows;
    }

}
