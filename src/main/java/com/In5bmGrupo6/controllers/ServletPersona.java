package com.In5bmGrupo6.controllers;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import java.util.List;
import com.In5bmGrupo6.models.dao.PersonasDaoImpl;
import com.In5bmGrupo6.models.dao.PersonasDaoJPA;
import com.In5bmGrupo6.models.domain.Personas;
import java.sql.Date;

/**
 *
 * @author informatica
 */

@WebServlet("/ServletPersona")
public class ServletPersona extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarPersonas(request, response);
                    break;
                case "actualizar":
                    actualizarPersona(request, response);
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
                    listarPersonas(request, response);
                    break;
                case "editar":
                    editarPersona(request, response);
                    break;
                case "eliminar":
                    eliminarPersona(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
    
    private void listarPersonas(HttpServletRequest request, HttpServletResponse response) throws IOException{
        /*
        List<Personas> listaPersonas = new PersonasDaoImpl().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaPersonas", listaPersonas);
        response.sendRedirect("personas/personas.jsp");
        */
        
        List<Personas> listaPersonas = new PersonasDaoJPA().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaPersonas", listaPersonas);
        response.sendRedirect("personas/personas.jsp");
    }
    
    private void eliminarPersona(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*
        int idPersona = Integer.parseInt(request.getParameter("id"));
        Personas persona = new Personas(idPersona);
        int registrosEliminados = new PersonasDaoImpl().delete(persona);

        if (registrosEliminados >= 1) {
            System.out.println("El registro fue eliminado con exito");
        } else {
            System.err.println("Se produjo un erro al intentar eliminar el registro = ");
        }
        listarPersonas(request, response);
        */
        
        int idPersona = Integer.parseInt(request.getParameter("id"));
        Personas persona = new PersonasDaoJPA().get(new Personas(idPersona));
        int registrosEliminados = new PersonasDaoJPA().delete(persona);
        if (registrosEliminados >= 1) {
            System.out.println("El registro fue eliminado con exito");
        } else {
            System.err.println("Se produjo un error al intentar eliminar el registro = " + persona.toString());
        }
        listarPersonas(request, response);
    }
    
    private void insertarPersonas(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nombre1 = request.getParameter("nombre1");
        String nombre2 = request.getParameter("nombre2");
        String nombre3 = request.getParameter("nombre3");
        String apellido1 = request.getParameter("apellido1");
        String apellido2 = request.getParameter("apellido2");
        String email = request.getParameter("email");
        Date fecha_nacimiento = Date.valueOf(request.getParameter("fechaNacimiento"));
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");

        Personas persona = new Personas(nombre1, nombre2, nombre3, apellido1, apellido2, email, fecha_nacimiento, telefono, direccion);
        System.out.println(persona);

        int registrosInsertados = new PersonasDaoImpl().add(persona);
        //int registrosInsertados = new PersonasDaoJPA().add(persona);
        listarPersonas(request, response);
    }
    
    private void editarPersona(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idPersona = Integer.parseInt(request.getParameter("id"));
        Personas persona = new PersonasDaoImpl().get(new Personas(idPersona));

        System.out.println(persona.toString());
        HttpSession sesion = request.getSession();
        sesion.setAttribute("persona", persona);
        response.sendRedirect(request.getContextPath() + "/" + "personas/editar-persona.jsp");
    }
    
    private void actualizarPersona(HttpServletRequest request, HttpServletResponse response) throws IOException {  
        int id = Integer.parseInt(request.getParameter("id"));
        
        System.out.println(id);
        String nombre1 = request.getParameter("nombre1");
        String nombre2 = request.getParameter("nombre2");
        String nombre3 = request.getParameter("nombre3");
        String apellido1 = request.getParameter("apellido1");
        String apellido2 = request.getParameter("apellido2");
        String email = request.getParameter("email");
        Date fecha_nacimiento = Date.valueOf(request.getParameter("fechaNacimiento"));
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");        
        
        Personas persona = new Personas(id, nombre1, nombre2, nombre3, apellido1, apellido2, email, fecha_nacimiento, telefono, direccion);
        System.out.println(persona.toString());
        
        //int registrosActualizados = new PersonasDaoImpl().update(estudiante);
        int registrosActualizados = new PersonasDaoJPA().update(persona);
        listarPersonas(request, response);
    }
}