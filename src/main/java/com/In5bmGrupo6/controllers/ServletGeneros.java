package com.In5bmGrupo6.controllers;

import com.In5bmGrupo6.models.dao.GenerosDaoImpl;
import com.In5bmGrupo6.models.dao.GenerosDaoJPA;
import com.In5bmGrupo6.models.domain.Generos;
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
    

@WebServlet("/ServletGenero")
public class ServletGeneros extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarGenero(request, response);
                    break;
                case "actualizar":
                    actualizarGenero(request, response);
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
                    listarGeneros(request, response);
                    break;
                case "editar":
                    System.out.println("dssdasdasdd");
                    editarGenero(request, response);
                    break;
                case "eliminar":
                    eliminarGeneros(request, response);

                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
    
    private void listarGeneros(HttpServletRequest request, HttpServletResponse response) throws IOException{
       /* List<Generos> listaGeneros = new GenerosDaoImpl().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaGeneros", listaGeneros);
        response.sendRedirect("generos/generos.jsp");*/
        
        List<Generos> listaGeneros = new GenerosDaoJPA().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaGeneros", listaGeneros);
        response.sendRedirect("generos/generos.jsp");
        
    }
    
    private void eliminarGeneros(HttpServletRequest request, HttpServletResponse response) throws IOException{
        /*int idGeneros = Integer.parseInt(request.getParameter("id"));
        Generos generos = new Generos(idGeneros);
        int registrosEliminados = new GenerosDaoImpl().delete(generos);
        if (registrosEliminados >= 1) {
            System.out.println("El registro fue eliminado con exito");
        } else {
            System.out.println("Se produjo un erro al intentar eliminar el registro = " + generos.toString());
        }
        listarGeneros(request, response);*/

        int idGeneros = Integer.parseInt(request.getParameter("id"));
        Generos generos = new GenerosDaoJPA().get (new Generos(idGeneros));
        int registrosEliminados = new GenerosDaoJPA().delete(generos);
        if (registrosEliminados >= 1) {
            System.out.println("El registro fue eliminado con exito");
        } else {
            System.out.println("Se produjo un erro al intentar eliminar el registro = " + generos.toString());
        }
        listarGeneros(request, response);
    }
    
    private void insertarGenero(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tipoGenero = request.getParameter("tipoGenero");

        Generos generos = new Generos(tipoGenero);
        System.out.println(generos);

        //int registrosInsertados = new GenerosDaoImpl().add(generos);
        int registrosInsertados = new GenerosDaoJPA().add(generos);
        listarGeneros(request, response);
    }
    
    private void editarGenero(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idGenero = Integer.parseInt(request.getParameter("id"));
        Generos genero = new GenerosDaoImpl().get(new Generos(idGenero));

        System.out.println(genero.toString());
        HttpSession sesion = request.getSession();
        sesion.setAttribute("genero", genero);
        response.sendRedirect(request.getContextPath() + "/" + "generos/editar-genero.jsp");
    }
    
    private void actualizarGenero(HttpServletRequest request, HttpServletResponse response) throws IOException {  
        int id = Integer.parseInt(request.getParameter("id"));
        
        System.out.println(id);
        String tipoGenero = request.getParameter("tipoGenero");       
        
        Generos genero = new Generos(id, tipoGenero);
        System.out.println(genero.toString());
        
        //int registrosActualizados = new GenerosDaoImpl().update(genero);
        int registrosActualizados = new GenerosDaoJPA().update(genero);
        listarGeneros(request, response);
    }
}