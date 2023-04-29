package com.In5bmGrupo6.controllers;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import java.util.List;
import com.In5bmGrupo6.models.dao.EmpleadosDaoImpl;
import com.In5bmGrupo6.models.domain.Empleados;

/**
 *
 * @author informatica
 */

@WebServlet("/ServletEmpleado")
public class ServletEmpleados extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarEmpleado(request, response);
                    break;
                case "actualizar":
                    actualizarEmpleado(request, response);
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
                    listarEmpleados(request, response);
                    break;
                case "editar":
                    editarEmpleado(request, response);
                    break;
                case "eliminar":
                    eliminarEmpleado(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
    
    private void listarEmpleados(HttpServletRequest request, HttpServletResponse response) throws IOException{
        List<Empleados> listaEmpleados = new EmpleadosDaoImpl().getAll();
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaEmpleados", listaEmpleados);
        response.sendRedirect("empleados/empleados.jsp");
    }
    
    private void eliminarEmpleado(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idEmpleado = Integer.parseInt(request.getParameter("id"));
        Empleados empleado = new Empleados(idEmpleado);
        int registrosEliminados = new EmpleadosDaoImpl().delete(empleado);
        
        if (registrosEliminados >= 1) {
            System.out.println("El registro fue eliminado con exito");
        } else {
            System.err.println("Se produjo un error al intentar eliminar el siguiente empleado: " + empleado.toString());
        }

        listarEmpleados(request, response);
    }
    
    private void insertarEmpleado(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idEmpleado = Integer.parseInt(request.getParameter("empleado"));

        Empleados empleado = new Empleados(idEmpleado);
        System.out.println(empleado);
        
        int registrosInsertados = new EmpleadosDaoImpl().add(empleado);
        listarEmpleados(request, response);
    }
    
    private void editarEmpleado(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idEmpleado = Integer.parseInt(request.getParameter("id"));
        Empleados empleado = new EmpleadosDaoImpl().get(new Empleados(idEmpleado));

        System.out.println(empleado.toString());
        HttpSession sesion = request.getSession();
        sesion.setAttribute("empleado", empleado);
        response.sendRedirect(request.getContextPath() + "/" + "empleados/editar-empleado.jsp");
    }
    
    private void actualizarEmpleado(HttpServletRequest request, HttpServletResponse response) throws IOException {  
        int id = Integer.parseInt(request.getParameter("id"));
        
        System.out.println(id);
        String persona_id = request.getParameter("persona_id");       
        
        System.out.println(persona_id);
        Empleados empleado = new Empleados(id, persona_id);
        System.out.println(empleado);
        
        int registrosActualizados = new EmpleadosDaoImpl().update(empleado);
        listarEmpleados(request, response);
    }
}