package com.In5bmGrupo6.controllers;

/**
 *
 * @author Luis Carlos Pérez
 * @date 3/09/2022
 * @time 10:16:24
 *
 * Código técnico: IN5BM
 *
 */

import com.In5bmGrupo6.models.dao.SuscripcionDaoImpl;
import com.In5bmGrupo6.models.dao.SuscripcionDaoJPA;
import com.In5bmGrupo6.models.domain.Suscripciones;
import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ServletSuscripcion")
public class ServletSuscripcion extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        System.out.println("la accion es:"+accion);
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarSuscripcion(request, response);
                    break;
                case "actualizar":
                    actualizarSuscripcion(request, response);
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
                    listarSuscripciones(request, response);
                    break;
                case "editar":
                    editarSuscripcion(request, response);
                    break;
                case "eliminar":
                    eliminarSuscripcion(request, response);
                    break;
            }
        }
    }
    
    private void actualizarSuscripcion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idSuscripcion = Integer.parseInt(request.getParameter("idSuscripcion"));
        
        String tipoSuscripcion = request.getParameter("tipoSuscripcion");
        
        Suscripciones suscripcion = new Suscripciones(idSuscripcion, tipoSuscripcion);
        System.out.println(suscripcion.toString());
        
        int registrosActualizados = new SuscripcionDaoJPA().update(suscripcion);
        System.out.println(registrosActualizados);
        
        listarSuscripciones(request, response);
    }
    
    private void insertarSuscripcion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tipoSuscripcion = request.getParameter("tipoSuscripcion");
        System.out.println("El dato a insertar es: "+tipoSuscripcion);
        
        Suscripciones suscripcion = new Suscripciones(tipoSuscripcion);
        System.out.println(suscripcion.toString());
        
        int registrosInsertados = new SuscripcionDaoJPA().add(suscripcion);
        System.out.println("El número de registros insertados es de: "+registrosInsertados);
        
        listarSuscripciones(request, response);
    }

    private void listarSuscripciones(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /* 
        --- Utilizando jdbc ---
        List<Suscripciones> listaSuscripciones = new SuscripcionDaoImpl().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("data", listaSuscripciones);
        response.sendRedirect("suscripciones/suscripciones.jsp");
        */
        
        List<Suscripciones> listaSuscripciones = new SuscripcionDaoJPA().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("data", listaSuscripciones);
        response.sendRedirect("suscripciones/suscripciones.jsp");
    }
    
    private void editarSuscripcion (HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idSuscripcion = Integer.parseInt(request.getParameter("idSuscripcion"));
        System.out.println("el parametro es: " + idSuscripcion);
        
        Suscripciones suscripcion = new SuscripcionDaoImpl().get(new Suscripciones(idSuscripcion));
        System.out.println("Método editar, si");
        System.out.println(suscripcion.toString());
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("suscripcion", suscripcion);
        response.sendRedirect(request.getContextPath() + "/" + "suscripciones/editar-suscripciones.jsp");
    }
    
    private void eliminarSuscripcion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*
        --- Utilizando jdbc
        int idSuscripcion = Integer.parseInt(request.getParameter("id"));
        Suscripciones suscripcion = new Suscripciones(idSuscripcion);
        int registrosEliminados = new SuscripcionDaoImpl().delete(suscripcion);
        if (registrosEliminados >= 1) {
            System.out.println("El registro fue eliminado con exito");
        } else {
            System.err.println("Se produjo un error al intentar eliminar el registro = " + suscripcion.toString());
        }
        listarSuscripciones(request, response);
        */
        int idSuscripcion = Integer.parseInt(request.getParameter("id"));
        Suscripciones suscripcion = new SuscripcionDaoJPA().get(new Suscripciones(idSuscripcion));
        int registrosEliminados = new SuscripcionDaoJPA().delete(suscripcion);
        if (registrosEliminados >= 1) {
            System.out.println("El registro fue eliminado con exito");
        } else {
            System.err.println("Se produjo un error al intentar eliminar el registro = " + suscripcion.toString());
        }
        listarSuscripciones(request, response);
    }
}
