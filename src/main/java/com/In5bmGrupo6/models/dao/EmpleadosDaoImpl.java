package com.In5bmGrupo6.models.dao;

import com.In5bmGrupo6.models.domain.Empleados;
import com.In5bmGrupo6.models.idao.IEmpleadoDAO;
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
public class EmpleadosDaoImpl implements IEmpleadoDAO {

    private static final String SQL_SELECT = "select empleados.id_empleado, concat(personas.nombre1, \" \",personas.nombre2, \" \",personas.nombre3, \" \",personas.apellido1, \" \",personas.apellido2), personas.id_persona from empleados inner join personas on empleados.persona_id=personas.id_persona";
    private static final String SQL_SELECT_BY_ID = "Select id_empleado, persona_id from empleados where id_empleado = ?";
    private static final String SQL_DELETE = "Delete from empleados where id_empleado = ?";
    private static final String SQL_INSERT = "insert into empleados(persona_id) values(?);";
    private static final String SQL_UPDATE = "update empleados set persona_id=? where id_empleado = ?";
    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Empleados empleado = null;
    private List<Empleados> listaEmpleados = new ArrayList<>();

    @Override
    public List<Empleados> getAll() {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                empleado = new Empleados(rs.getInt(1), rs.getString(2), rs.getInt(3));
                listaEmpleados.add(empleado);
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
        return listaEmpleados;
    }
    
    public Empleados get(Empleados empleado) {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setInt(1, empleado.getId_empleado());
            System.out.println(pstmt.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                empleado = new Empleados(rs.getInt("id_empleado"), rs.getInt("persona_id"));
            }
            System.out.println("empleado: " + empleado);
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
        return empleado;
    }

    @Override
    public int add(Empleados empleado) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_INSERT);
            pstmt.setInt(1, empleado.getId_empleado());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Se´produjo un error al intentar insertar el siguiente registro" + empleado.toString());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return rows;
    }

    @Override
    public int update(Empleados empleado) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE);
            pstmt.setString(1, empleado.getNombreCompleto());
            pstmt.setInt(2, empleado.getId_empleado());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Se produjo un error al intentar actualizar el siguiente registro " + empleado.toString());
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
    public int delete(Empleados empleado) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, empleado.getId_empleado());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Se produjo un error al intentar eliminar el registro con el id: " + empleado.getId_empleado());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        return rows;
    }

}
