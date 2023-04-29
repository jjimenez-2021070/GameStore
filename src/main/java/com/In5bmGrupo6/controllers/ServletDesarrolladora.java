package com.In5bmGrupo6.controllers;

/**
 *
 * @author Luis Carlos Pérez
 * @date 3/09/2022
 * @time 13:03:20
 *
 * Código técnico: IN5BM
 *
 */

import com.In5bmGrupo6.models.dao.DesarrolladoraDaoImpl;
import com.In5bmGrupo6.models.dao.DesarrolladoraDaoJPA;
import com.In5bmGrupo6.models.domain.Desarrolladoras;
import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ServletDesarrolladora")
public class ServletDesarrolladora extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarDesarrolladora(request, response);
                    break;
                case "actualizar":
                    actualizarDesarrolladora(request, response);
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
                    listarDesarrolladoras(request, response);
                    break;
                case "editar":
                    editarDesarrolladora(request, response);
                    break;
                case "eliminar":
                    eliminarDesarrolladora(request, response);
                    break;
            }
        }
    }
    
    private void insertarDesarrolladora (HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tipoDesarrolladora = request.getParameter("nombreDesarrolladora");
        System.out.println("El dato a insertar es: "+tipoDesarrolladora);
        
        Desarrolladoras dearrolladora = new Desarrolladoras(tipoDesarrolladora);
        System.out.println(dearrolladora.toString());
        
        int registrosInsertados = new DesarrolladoraDaoJPA().add(dearrolladora);
        System.out.println("El número de registros insertados es de: "+registrosInsertados);
        
        listarDesarrolladoras(request, response);
    }
    
    private void actualizarDesarrolladora (HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String tipoDesarrolladora = request.getParameter("nombreDesarrolladora");
        System.out.println("El dato a actualizar es el id: " + id);
        
        Desarrolladoras dearrolladora = new Desarrolladoras(id, tipoDesarrolladora);
        System.out.println(dearrolladora.toString());
        
        int registrosActualizados = new DesarrolladoraDaoJPA().update(dearrolladora);
        System.out.println("El número de registros actualizados es de: "+registrosActualizados);
        
        listarDesarrolladoras(request, response);
    }

    private void listarDesarrolladoras(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*
        --- Utilizando jdbc ---
        List<Desarrolladoras> listaDesarrolladora = new DesarrolladoraDaoImpl().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("data", listaDesarrolladora);
        response.sendRedirect("desarrolladoras/desarrolladoras.jsp");
        */
        
        List<Desarrolladoras> listaDesarrolladoras = new DesarrolladoraDaoJPA().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("data", listaDesarrolladoras);
        response.sendRedirect("desarrolladoras/desarrolladoras.jsp");
    }
    
    private void editarDesarrolladora(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("el parametro es: " + request.getParameter("id"));
        int idDesarrolladora = Integer.parseInt(request.getParameter("id"));
        
        Desarrolladoras desarrolladora = new DesarrolladoraDaoImpl().get(new Desarrolladoras(idDesarrolladora));
        System.out.println(desarrolladora.toString());
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("desarrolladora", desarrolladora); // (clave, valor)
        response.sendRedirect(request.getContextPath() + "/" + "desarrolladoras/editar-desarrolladoras.jsp");
    }

    private void eliminarDesarrolladora(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*
        --- Utilizando jdbc ---
        int idDesarrolladora = Integer.parseInt(request.getParameter("id"));
        Desarrolladoras desarrolladora = new Desarrolladoras(idDesarrolladora);
        int registrosEliminados = new DesarrolladoraDaoImpl().delete(desarrolladora);
        if (registrosEliminados >= 1) {
            System.out.println("El registro fue eliminado con exito");
        } else {
            System.out.println("Se produjo un erro al intentar eliminar el registro = " + desarrolladora.toString());
        }
        listarDesarrolladoras(request, response);
        */
        
        int idDesarrolladora = Integer.parseInt(request.getParameter("id"));
        Desarrolladoras desarrolladora = new DesarrolladoraDaoJPA().get(new Desarrolladoras(idDesarrolladora));
        int registrosEliminados = new DesarrolladoraDaoJPA().delete(desarrolladora);
        if (registrosEliminados >= 1) {
            System.out.println("El registro fue eliminado con exito");
        } else {
            System.err.println("Se produjo un erro al intentar eliminar el registro = " + desarrolladora.toString());
        }
        listarDesarrolladoras(request, response);
    }
}
