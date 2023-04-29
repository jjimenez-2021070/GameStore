package com.In5bmGrupo6.models.dao;

import com.In5bmGrupo6.db.Conexion;
import com.In5bmGrupo6.models.domain.Generos;
import com.In5bmGrupo6.models.idao.IGeneroDAO;
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
public class GenerosDaoImpl implements IGeneroDAO {

    private static final String SQL_SELECT = "Select id_genero, tipo_genero from generos";
    private static final String SQL_SELECT_BY_ID = "select id_genero, tipo_genero from generos where id_genero = ?";
    private static final String SQL_DELETE = "delete from generos where id_genero = ?";
    private static final String SQL_INSERT = "insert into generos(tipo_genero) values(?)";
    private static final String SQL_UPDATE = "update generos set tipo_genero=? where id_genero=?";

    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Generos genero = null;
    private List<Generos> listaGeneros = new ArrayList<>();

    @Override
    public List<Generos> getAll() {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                genero = new Generos(rs.getInt(1), rs.getString(2));
                listaGeneros.add(genero);
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
        return listaGeneros;
    }
    
    public Generos get(Generos genero) {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setInt(1, genero.getId_genero());
            System.out.println(pstmt.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                genero = new Generos(rs.getInt("id_genero"), rs.getString("tipo_genero"));
            }
            System.out.println("genero: " + genero);
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
        return genero;
    }

    @Override
    public int add(Generos genero) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_INSERT);
            pstmt.setString(1, genero.getTipo_genero());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Se produjo un error al intentar insertar el siguiente registro" + genero.toString());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return rows;
    }

    @Override
    public int update(Generos genero) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE);
            pstmt.setString(1, genero.getTipo_genero());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Se produjo un error al intentar actualizar el siguiente registro " + genero.toString());
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
    public int delete(Generos genero) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, genero.getId_genero());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Se produjo un error al intetar eliminar el registro : " + genero + "Cuyo ID es : " + genero.getTipo_genero());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return rows;
    }

}
