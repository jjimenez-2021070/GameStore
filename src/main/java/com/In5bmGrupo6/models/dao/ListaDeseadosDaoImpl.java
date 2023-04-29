package com.In5bmGrupo6.models.dao;

/**
 *
 * @author Sergio Cruz Velasquez
 * @date Sep 2, 2022
 * @time 10:14:56 PM
 *
 */
import com.In5bmGrupo6.models.domain.ListaDeseados;
import com.In5bmGrupo6.models.idao.IListaDeseadosDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.In5bmGrupo6.db.Conexion;
import java.sql.SQLException;

public class ListaDeseadosDaoImpl implements IListaDeseadosDAO {

    private static final String SQL_DELETE = "Delete from listas_deseados where id_lista = ?";
    private static final String SQL_SELECT = "Select id_lista, juego_id, fecha_agregado, cliente_id from listas_deseados";
    private static final String SQL_INSERT = " insert into listas_deseados(juego_id, fecha_agregado ,cliente_id) values(?, ?, ?)";
    private static final String SQL_UPDATE = "update set juego_id = ?, fecha_agregado = ? , cliente_id = ? where id_lista = ?";
    private static final String SQL_SELECT_BY_ID = "Select id_lista, juego_id, fecha_agregado, cliente_id from listas_deseados where id_lista = ?";
    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private ListaDeseados Deseados = null;
    private List<ListaDeseados> listaDeseados = new ArrayList<>();

    @Override
    public List<ListaDeseados> getAll() {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Deseados = new ListaDeseados(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getInt(4));
                listaDeseados.add(Deseados);
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
        return listaDeseados;
    }
    
        public ListaDeseados get(ListaDeseados deseados) {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setInt(1, deseados.getId_lista());
            System.out.println(pstmt.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                deseados = new ListaDeseados(rs.getInt("id_lista"), rs.getInt("juego_id"), rs.getDate("fecha_lanzamiento"), rs.getInt("cliente_id"));
            }
            System.out.println("deseados: " + deseados);
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
        return deseados;
    }
    
    @Override
    public int add(ListaDeseados Deseados) {
               int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_INSERT);
            pstmt.setInt(1, Deseados.getJuego_id());
            pstmt.setDate(2, Deseados.getFecha_agregado());
            pstmt.setInt(3, Deseados.getCliente_id());

            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Se´produjo un error al intentar insertar el siguiente registro" + Deseados.toString());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return rows;
    }

    @Override
    public int update(ListaDeseados Deseados) {
               int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE);
            pstmt.setInt(1, Deseados.getJuego_id());
            pstmt.setDate(2, Deseados.getFecha_agregado());
            pstmt.setInt(3, Deseados.getCliente_id());
            pstmt.setInt(4, Deseados.getId_lista());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Se produjo un error al intentar actualizar el siguiente registro " + Deseados.toString());
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
    public int delete(ListaDeseados Deseados) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, Deseados.getId_lista());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Se produjo un error al intentar eliminar el registro con el id: " + Deseados.getId_lista());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        return rows;
    }

}
