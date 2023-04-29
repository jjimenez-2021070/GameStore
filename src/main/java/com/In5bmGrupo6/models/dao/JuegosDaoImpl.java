package com.In5bmGrupo6.models.dao;

import com.In5bmGrupo6.models.domain.Juegos;
import com.In5bmGrupo6.models.idao.IJuegosDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.In5bmGrupo6.db.Conexion;
import java.sql.SQLException;
import java.util.Date;

public class JuegosDaoImpl implements IJuegosDAO {

    private static final String SQL_SELECT = "Select id_juego, nombre_juego, fecha_lanzamiento, precio, desarrolladora_id, distribuidora_id, genero_id from juegos";
    private static final String SQL_DELETE = "Delete from juegos where id_juego = ?";
    private static final String SQL_INSERT = "insert into juegos(nombre_juego,fecha_lanzamiento, precio,desarrolladora_id,distribuidora_id ,genero_id) values(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "update juegos set nombre_juego = ?, fecha_lanzamiento= ?, precio = ?, desarrolladora_id = ?, distribuidora_id = ?, genero_id = ? where id_juego = ?";
    private static final String SQL_SELECT_BY_ID = "Select id_juego, nombre_juego, fecha_lanzamiento, precio, desarrolladora_id, distribuidora_id, genero_id from juegos where id_juego = ?";
    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Juegos juegos = null;
    private List<Juegos> listaJuegos = new ArrayList<>();

    @Override
    public List<Juegos> getAll() {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                juegos = new Juegos(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));
                listaJuegos.add(juegos);
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
        return listaJuegos;
    }

    public Juegos get(Juegos juegos) {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setInt(1, juegos.getId_juego());
            System.out.println(pstmt.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                juegos = new Juegos(rs.getInt("id_juego"), rs.getString("nombre_juego"), rs.getDate("fecha_lanzamiento"), rs.getInt("precio"), rs.getInt("desarrolladora_id"), rs.getInt("distribuidora_id"), rs.getInt("genero_id"));
            }
            System.out.println("juego: " + juegos);
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
        return juegos;
    }

    @Override
    public int add(Juegos juegos) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_INSERT);
            pstmt.setString(1, juegos.getNombre_juego());
            pstmt.setDate(2, juegos.getFecha_lanzamiento());
            pstmt.setInt(3, juegos.getPrecio());
            pstmt.setInt(4, juegos.getDesarrolladora_id());
            pstmt.setInt(5, juegos.getDistribuidora_id());
            pstmt.setInt(6, juegos.getGenero_id());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Se´produjo un error al intentar insertar el siguiente registro" + juegos.toString());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return rows;
    }

    @Override
    public int update(Juegos juegos) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE);
            pstmt.setString(1, juegos.getNombre_juego());
            pstmt.setDate(2, juegos.getFecha_lanzamiento());
            pstmt.setInt(3, juegos.getPrecio());
            pstmt.setInt(4, juegos.getDesarrolladora_id());
            pstmt.setInt(5, juegos.getDistribuidora_id());
            pstmt.setInt(6, juegos.getGenero_id());
            pstmt.setInt(7, juegos.getId_juego());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Se produjo un error al intentar actualizar el siguiente registro " + juegos.toString());
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
    public int delete(Juegos juegos) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, juegos.getId_juego());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Se produjo un error al intentar eliminar el registro con el id: " + juegos.getId_juego());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return rows;
    }

}
