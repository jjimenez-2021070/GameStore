package com.In5bmGrupo6.controllers;

/**
 *
 * @author Sergio Cruz Velasquez 
 * @date Sep 2, 2022
 * @time 10:11:10 PM
 *
 */

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import java.util.List;
import com.In5bmGrupo6.models.dao.ListaDeseadosDaoImpl;
import com.In5bmGrupo6.models.domain.ListaDeseados;
import java.sql.Date;

@WebServlet("/ServletListaDeseados")
public class ServletListaDeseados extends HttpServlet{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
                request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");

        if (accion != null) {

            switch (accion) {
                case "insertar":
                    insertarLista(request, response);
                    break;
                case "actualizar":
                   actualizarLista(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "listar":
                    listarDeseados(request, response);
                    break;
                case "editar":
                    editarLista(request, response);
                    break;
                case "eliminar":
                    eliminarDeseado(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
    
    private void listarDeseados(HttpServletRequest request, HttpServletResponse response) throws IOException{
        List<ListaDeseados> listaDeseados = new ListaDeseadosDaoImpl().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaDeseados", listaDeseados);
        response.sendRedirect("lista-Deseados/lista-deseados.jsp");
    }

    private void eliminarDeseado(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idDeseados = Integer.parseInt(request.getParameter("id"));
        ListaDeseados deseados = new ListaDeseados(idDeseados);
        int registrosEliminados = new ListaDeseadosDaoImpl().delete(deseados);

        if (registrosEliminados >= 1) {
            System.out.println("El registro fue eliminado con exito");
        } else {
            System.err.println("Se produjo un erro al intentar eliminar el registro = ");
        }
        listarDeseados(request, response);    
    }

    private void insertarLista(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int juego_id = Integer.parseInt(request.getParameter("juego_id"));      
        Date fecha_agregado = Date.valueOf(request.getParameter("fecha_agregado"));
        int cliente_id = Integer.parseInt(request.getParameter("cliente_id")); 
        ListaDeseados deseados = new ListaDeseados(juego_id, fecha_agregado ,cliente_id);
        System.out.println(deseados);
        
        int registrosInsertados = new ListaDeseadosDaoImpl().add(deseados);
        listarDeseados(request, response);
    }

    private void actualizarLista(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void editarLista(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
