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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.util.List;
import com.In5bmGrupo6.models.dao.ClientesDaoImpl;
import com.In5bmGrupo6.models.domain.Clientes;

@WebServlet("/ServletCliente")
public class ServletClientes extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarClientes(request, response);
                    break;
                case "actualizar":
                    actualizarClientes(request, response);
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
                    listaClientes(request, response);
                    break;
                case "editar":
                    editarClientes(request, response);
                    break;
                case "eliminar":
                    eliminarCliente(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    private void listaClientes(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Clientes> listaClientes = new ClientesDaoImpl().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaClientes", listaClientes);
        response.sendRedirect("clientes/clientes.jsp");
    }

    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idCliente = Integer.parseInt(request.getParameter("id_cliente"));
        Clientes cliente = new Clientes(idCliente);
        int registrosEliminados = new ClientesDaoImpl().delete(cliente);

        if (registrosEliminados >= 1) {
            System.out.println("El registro fue eliminado con exito");
        } else {
            System.err.println("Se produjo un erro al intentar eliminar el registro = " + cliente.toString());
        }
        listaClientes(request, response);
    }

    private void insertarClientes(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nit = request.getParameter("nit");
        int personaId = Integer.parseInt(request.getParameter("persona_id"));
        int suscripcionId = Integer.parseInt(request.getParameter("suscripcion_id"));

        Clientes cliente = new Clientes(nit, personaId, suscripcionId);
        System.out.println(cliente);

        int registrosInsertados = new ClientesDaoImpl().add(cliente);
        //int registrosInsertados = new ClientesDaoJPA().add(cliente);
        listaClientes(request, response);
    }

    private void editarClientes(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idCliente = Integer.parseInt(request.getParameter("id_cliente"));
        Clientes cliente = new ClientesDaoImpl().get(new Clientes(idCliente));

        System.out.println(cliente.toString());
        HttpSession sesion = request.getSession();
        sesion.setAttribute("cliente", cliente);
        response.sendRedirect(request.getContextPath() + "/" + "clientes/editar-cliente.jsp");
    }

    private void actualizarClientes(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id_cliente"));

        System.out.println(id);
        String nit = request.getParameter("nit");
        int persona_id = Integer.parseInt(request.getParameter("persona_id"));
        int suscripcion_id = Integer.parseInt(request.getParameter("suscripcion_id"));
                                
        Clientes cliente = new Clientes(id, nit, persona_id, suscripcion_id);
        System.out.println(cliente);

        int registrosActualizados = new ClientesDaoImpl().update(cliente);
        listaClientes(request, response);
        
    }
}
