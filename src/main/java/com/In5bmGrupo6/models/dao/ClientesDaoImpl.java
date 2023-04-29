package com.In5bmGrupo6.models.dao;

/**
 *
 * @author Sergio Cruz Velasquez
 * @date Sep 2, 2022
 * @time 10:14:56 PM
 *
 */
import com.In5bmGrupo6.models.domain.Clientes;
import com.In5bmGrupo6.models.idao.IClientesDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.In5bmGrupo6.db.Conexion;
import java.sql.SQLException;

public class ClientesDaoImpl implements IClientesDAO {

    private static final String SQL_SELECT = "Select id_cliente, nit, persona_id, suscripcion_id from clientes";
    private static final String SQL_SELECT_BY_ID = "Select id_cliente, nit, persona_id, suscripcion_id from clientes where id_cliente = ?";
    private static final String SQL_DELETE = "Delete from clientes where id_cliente = ?";
    private static final String SQL_INSERT = "insert into clientes(nit, persona_id, suscripcion_id) values(?, ?, ?)";
    private static final String SQL_UPDATE = "update clientes set nit=?, persona_id=?, suscripcion_id=? where id_cliente = ?";

    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Clientes clientes = null;
    private List<Clientes> listaClientes = new ArrayList<>();

    @Override
    public List<Clientes> getAll() {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                clientes = new Clientes(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                listaClientes.add(clientes);
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
        return listaClientes;
    }

    public Clientes get(Clientes cliente) {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setInt(1, cliente.getId_cliente());
            System.out.println(pstmt.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                cliente = new Clientes(rs.getInt("id_cliente"), rs.getString("nit"), rs.getInt("persona_id"), rs.getInt("suscripcion_id"));
            }
            System.out.println("cliente: " + cliente);
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
        return cliente;
    }

    @Override
    public int add(Clientes cliente) {
         int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_INSERT);
            pstmt.setString(1, cliente.getNit());
            pstmt.setInt(2, cliente.getPersona_id());
            pstmt.setInt(3, cliente.getSuscripcion_id());;
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Se´produjo un error al intentar insertar el siguiente registro" + cliente.toString());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return rows;
    }

    @Override
    public int update(Clientes cliente) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE);
            pstmt.setString(1, cliente.getNit());
            pstmt.setInt(2, cliente.getPersona_id());
            pstmt.setInt(3, cliente.getSuscripcion_id());
            pstmt.setInt(4, cliente.getId_cliente());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Se produjo un error al intentar actualizar el siguiente registro " + cliente.toString());
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
    public int delete(Clientes cliente) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, cliente.getId_cliente());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Se produjo un error al intentar eliminar el registro con el id: " + cliente.getId_cliente());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        return rows;
    }

}
