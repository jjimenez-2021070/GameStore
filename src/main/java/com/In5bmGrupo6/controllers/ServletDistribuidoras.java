package com.In5bmGrupo6.controllers;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.util.List;
import com.In5bmGrupo6.models.dao.DistribuidorasDaoImpl;
import com.In5bmGrupo6.models.domain.Distribuidoras;
import com.In5bmGrupo6.models.dao.DistribuidorasDaoJPA;

/**
 *
 * @author sergio
 */
@WebServlet("/ServletDistribuidora")
public class ServletDistribuidoras extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarDistribuidora(request, response);
                    break;
                case "actualizar":
                    actualizarDistribuidora(request, response);
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
                    listaDistribuidoras(request, response);
                    break;
                case "eliminar":
                    eliminarDistribuidora(request, response);
                    break;
                case "editar":
                    editarDistribuidora(request, response);
                    break;

                default:
                    throw new AssertionError();
            }
        }
    }

    private void listaDistribuidoras(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Distribuidoras> listaDistribuidoras = new DistribuidorasDaoJPA().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaDistribuidoras", listaDistribuidoras);
        response.sendRedirect("distribuidoras/distribuidoras.jsp");
    }

    private void eliminarDistribuidora(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idDistribuidora = Integer.parseInt(request.getParameter("id"));
        Distribuidoras distribuidora = new DistribuidorasDaoJPA().get(new Distribuidoras(idDistribuidora));
        int registrosEliminados = new DistribuidorasDaoJPA().delete(distribuidora);
        if (registrosEliminados >= 1) {
            System.out.println("El registro fue eliminado con exito");
        } else {
            System.err.println("Se produjo un error al intentar eliminar el registro = " + distribuidora.toString());
        }
        listaDistribuidoras(request, response);
    }

    private void insertarDistribuidora(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nombreDistribuidora = request.getParameter("nombre_distribuidora");

        Distribuidoras distribuidora = new Distribuidoras(nombreDistribuidora);
        System.out.println(distribuidora);

        int registrosInsertados = new DistribuidorasDaoImpl().add(distribuidora);
        //int registrosInsertados = new DistribuidorasDaoJPA().add(distribuidora);
        listaDistribuidoras(request, response);
    }

    private void editarDistribuidora(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idDistribuidora = Integer.parseInt(request.getParameter("id"));
        Distribuidoras distribuidora = new DistribuidorasDaoImpl().get(new Distribuidoras(idDistribuidora));

        System.out.println(distribuidora.toString());
        HttpSession sesion = request.getSession();
        sesion.setAttribute("distribuidora", distribuidora);
        response.sendRedirect(request.getContextPath() + "/" + "distribuidoras/editar-distribuidora.jsp");
    }

    private void actualizarDistribuidora(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        System.out.println(id);
        String nombreDistribuidora = request.getParameter("nombre_distribuidora");

        Distribuidoras distribuidora = new Distribuidoras(id, nombreDistribuidora);
        System.out.println(distribuidora.toString());

        //int registrosActualizados = new PersonasDaoImpl().update(estudiante);
        int registrosActualizados = new DistribuidorasDaoJPA().update(distribuidora);
        listaDistribuidoras(request, response);
    }

}
