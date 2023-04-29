package com.In5bmGrupo6.controllers;

import com.In5bmGrupo6.models.dao.RolesDaoImpl;
import com.In5bmGrupo6.models.dao.RolesDaoJPA;
import com.In5bmGrupo6.models.domain.Roles;
import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author TulioJimènez
 */

@WebServlet("/ServletRol")
public class ServletRoles extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarRoles(request, response);
                    break;
                case "actualizar":
                    actualizarRol(request, response);
                    break;
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "listar":
                    listarRoles(request, response);
                    break;
                case "editar":
                    editarRol(request, response);
                    break;
                case "eliminar":
                    eliminarRoles(request, response);

                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
    
    private void listarRoles(HttpServletRequest request, HttpServletResponse response) throws IOException{
        /*List<Roles> listarRoles = new RolesDaoImpl().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaRoles", listarRoles);
        response.sendRedirect("roles/roles.jsp");*/
        
        List<Roles> listarRoles = new RolesDaoJPA().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaRoles", listarRoles);
        response.sendRedirect("roles/roles.jsp");        
        
        
    }
    
    private void eliminarRoles(HttpServletRequest request, HttpServletResponse response) throws IOException{
           /* int idRoles = Integer.parseInt(request.getParameter("id"));
            Roles roles = new Roles(idRoles);
            int registrosEliminados = new RolesDaoImpl().delete(roles);
            if (registrosEliminados >= 1) {
                System.out.println("El registro fue eliminado con exito");
            } else {
                System.out.println("Se produjo un erro al intentar eliminar el registro = " + roles.toString());
            }
            listarRoles(request, response);*/
            
            int idRoles = Integer.parseInt(request.getParameter("id"));
            Roles roles = new RolesDaoJPA().get (new Roles(idRoles));
            int registrosEliminados = new RolesDaoJPA().delete(roles);
            if (registrosEliminados >= 1) {
                System.out.println("El registro fue eliminado con exito");
            } else {
                System.out.println("Se produjo un erro al intentar eliminar el registro = " + roles.toString());
            }
            listarRoles(request, response);
    }
    
    private void insertarRoles(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String descripcion = request.getParameter("descripcion");

        Roles rol = new Roles(descripcion);
        System.out.println(rol);

        //int registrosInsertados = new RolesDaoImpl().add(rol);
        int registrosInsertados = new RolesDaoJPA().add(rol);
        listarRoles(request, response);
    }
    
    private void editarRol(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idRol = Integer.parseInt(request.getParameter("id"));
        Roles rol = new RolesDaoImpl().get(new Roles(idRol));

        System.out.println(rol.toString());
        HttpSession sesion = request.getSession();
        sesion.setAttribute("rol", rol);
        response.sendRedirect(request.getContextPath() + "/" + "roles/editar-rol.jsp");
    }
    
    private void actualizarRol(HttpServletRequest request, HttpServletResponse response) throws IOException {  
        int id = Integer.parseInt(request.getParameter("id"));
        
        System.out.println(id);
        String descripcion = request.getParameter("descripcion");       
        
        Roles rol = new Roles(id, descripcion);
        System.out.println(rol.toString());
        
        //int registrosActualizados = new RolesDaoImpl().update(rol);
        int registrosActualizados = new RolesDaoJPA().update(rol);
        listarRoles(request, response);
    }
}