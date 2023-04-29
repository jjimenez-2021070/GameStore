
package com.In5bmGrupo6.models.dao;

/**
 *
 * @author Luis Carlos Pérez
 * @date 3/09/2022
 * @time 12:50:33
 * 
 *Código técnico: IN5BM
 *
 */

import com.In5bmGrupo6.models.domain.Desarrolladoras;
import com.In5bmGrupo6.models.idao.IDesarrolladorasDAO;
import com.In5bmGrupo6.db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class DesarrolladoraDaoImpl implements IDesarrolladorasDAO{
    
    private static final String SQL_SELECT = "select id, nombre_desarrolladora from empresas_desarrolladoras";
    private static final String SQL_SELECT_BY_ID = "select id, nombre_desarrolladora from empresas_desarrolladoras where id = ?";
    private static final String SQL_DELETE = "delete from empresas_desarrolladoras where id = ?";
    
    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Desarrolladoras desarrolladora = null;
    private List<Desarrolladoras> listaDesarrolladoras = new ArrayList<>();
    
    @Override
    public List<Desarrolladoras> getAll() {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                desarrolladora = new Desarrolladoras(rs.getInt("id"), rs.getString("nombre_desarrolladora"));
                listaDesarrolladoras.add(desarrolladora);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(con);
        }
        return listaDesarrolladoras;
    }
    
    @Override
    public int add(Desarrolladoras desarrolladora) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Desarrolladoras get(Desarrolladoras desarrolladora) {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setInt(1, desarrolladora.getId());
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                desarrolladora = new Desarrolladoras(rs.getInt("id"), rs.getString("nombre_desarrolladora"));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(con);
        }
        return desarrolladora;
    }

    @Override
    public int update(Desarrolladoras desarrolladora) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(Desarrolladoras desarrolladora) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, desarrolladora.getId());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Se produjo un error al intetar eliminar el registro : " + desarrolladora + "Cuyo ID es : " + desarrolladora.getId());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return rows;
    }
}