package com.In5bmGrupo6.controllers;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import java.util.List;
import com.In5bmGrupo6.models.dao.JuegosDaoImpl;
import com.In5bmGrupo6.models.domain.Juegos;
import java.sql.Date;

@WebServlet("/Servletjuego")
public class ServletJuegos extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");

        if (accion != null) {

            switch (accion) {
                case "insertar":
                    insertarJuego(request, response);
                    break;
                case "actualizar":
                    actualizarJuego(request, response);
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
                    listarJuegos(request, response);
                    break;
                case "editar":
                    editarJuego(request, response);
                    break;
                case "eliminar":
                    eliminarJuego(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    private void listarJuegos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Juegos> listaJuegos = new JuegosDaoImpl().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaJuegos", listaJuegos);
        response.sendRedirect("juegos/juegos.jsp");
    }

    private void eliminarJuego(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idJuegos = Integer.parseInt(request.getParameter("id"));
        Juegos juegos = new Juegos(idJuegos);
        int registrosEliminados = new JuegosDaoImpl().delete(juegos);

        if (registrosEliminados >= 1) {
            System.out.println("El registro fue eliminado con exito");
        } else {
            System.err.println("Se produjo un erro al intentar eliminar el registro = ");
        }
        listarJuegos(request, response);
    }

    private void insertarJuego(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String nombre_juego = (request.getParameter("nombre_juego"));
        Date fecha_lanzamiento = Date.valueOf(request.getParameter("fecha_lanzamiento"));
        int precio = Integer.parseInt(request.getParameter("precio"));
        int desarrolladora_id = Integer.parseInt(request.getParameter("desarrolladora_id"));
        int distribuidora_id = Integer.parseInt(request.getParameter("distribuidora_id"));
        int genero_id = Integer.parseInt(request.getParameter("genero_id"));
        Juegos juego = new Juegos(nombre_juego, fecha_lanzamiento, precio, desarrolladora_id, distribuidora_id, genero_id);
        System.out.println(juego);

        int registrosInsertados = new JuegosDaoImpl().add(juego);
        listarJuegos(request, response);
    }

    private void editarJuego(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idJuegos = Integer.parseInt(request.getParameter("id"));
        Juegos juegos = new JuegosDaoImpl().get(new Juegos(idJuegos));

        System.out.println(juegos.toString());
        HttpSession sesion = request.getSession();
        sesion.setAttribute("juego", juegos);
        response.sendRedirect(request.getContextPath() + "/" + "juegos/editar-juegos.jsp");
    }

    private void actualizarJuego(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);

        String nombre_juego = (request.getParameter("nombre_juego"));
        Date fecha_lanzamiento = Date.valueOf(request.getParameter("fecha_lanzamiento"));
        int precio = Integer.parseInt(request.getParameter("precio"));
        int desarrolladora_id = Integer.parseInt(request.getParameter("desarrolladora_id"));
        int distribuidora_id = Integer.parseInt(request.getParameter("distribuidora_id"));
        int genero_id = Integer.parseInt(request.getParameter("genero_id"));

        Juegos juego = new Juegos(id, nombre_juego, fecha_lanzamiento, precio, desarrolladora_id, distribuidora_id, genero_id);
        System.out.println(juego.toString());;

        int registrosActualizados = new JuegosDaoImpl().update(juego);
        listarJuegos(request, response);
    }

}
