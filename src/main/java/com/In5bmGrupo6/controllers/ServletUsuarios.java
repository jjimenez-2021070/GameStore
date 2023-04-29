package com.In5bmGrupo6.controllers;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import java.util.List;
import com.In5bmGrupo6.models.dao.UsuariosDaoImpl;
import com.In5bmGrupo6.models.domain.Usuarios;

/**
 *
 * @author informatica
 */

@WebServlet("/ServletUsuario")
public class ServletUsuarios extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarUsuarios(request, response);
                    break;
                case "actualizar":
                    actualizarUsuario(request, response);
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
                    listarUsuarios(request, response);
                    break;
                case "editar":
                    editarUsuario(request, response);
                    break;
                case "eliminar":
                    eliminarUsuarios(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
    
    private void listarUsuarios(HttpServletRequest request, HttpServletResponse response) throws IOException{
        List<Usuarios> listaUsuarios = new UsuariosDaoImpl().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaUsuarios", listaUsuarios);
        response.sendRedirect("usuarios/usuarios.jsp");
    }
    
    private void eliminarUsuarios(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idUsuario = Integer.parseInt(request.getParameter("id"));
        Usuarios usuario = new Usuarios(idUsuario);
        int registrosEliminados = new UsuariosDaoImpl().delete(usuario);

        if (registrosEliminados >= 1) {
            System.out.println("El registro fue eliminado con exito");
        } else {
            System.err.println("Se produjo un erro al intentar eliminar el registro = ");
        }
        listarUsuarios(request, response);
    }
    
    private void insertarUsuarios(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pass = request.getParameter("pass");
        String correo_electronico = request.getParameter("correo");
        int persona = Integer.parseInt(request.getParameter("persona"));
        int rol = Integer.parseInt(request.getParameter("rol"));

        Usuarios usuario = new Usuarios(pass, correo_electronico, persona, rol);
        System.out.println(usuario);

        int registrosInsertados = new UsuariosDaoImpl().add(usuario);
        listarUsuarios(request, response);
    }
    
    private void editarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idUsuario = Integer.parseInt(request.getParameter("id"));
        Usuarios usuario = new UsuariosDaoImpl().get(new Usuarios(idUsuario));

        System.out.println(usuario.toString());
        HttpSession sesion = request.getSession();
        sesion.setAttribute("usuario", usuario);
        response.sendRedirect(request.getContextPath() + "/" + "usuarios/editar-usuario.jsp");
    }
    
    private void actualizarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {  
        int id = Integer.parseInt(request.getParameter("user"));
        
        System.out.println(id);
        String pass = request.getParameter("pass");
        String correo_electronico = request.getParameter("correo");
        String persona = request.getParameter("persona");
        String rol = request.getParameter("rol");       
        
        Usuarios usuario = new Usuarios(id, pass, correo_electronico, persona, rol);
        System.out.println(usuario.toString());
        
        //int registrosActualizados = new PersonasDaoImpl().update(estudiante);
        int registrosActualizados = new UsuariosDaoImpl().update(usuario);
        listarUsuarios(request, response);
    }
}