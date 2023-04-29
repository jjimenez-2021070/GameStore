<%-- 
    Document   : juegos
    Created on : 3/09/2022, 12:35:06
    Author     : TulioJimènez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="es_GT"/>
<!DOCTYPE html>
<html>
    <head>
        <title>Game store</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="../assets/css/estilo-pantalla-inicio.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.css">
    </head>

    <body>
        <header>
            <jsp:include page="../WEB-INF/paginas/comunes/encabezado.jsp"/>
            <div class="img-background text-light fs-1">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-6 col-md-6">

                        </div>
                        <div class="col-12">
                            <p>Juegos</p>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <main>

            <section id="accions" class="py-4 mb-4">
                <div class="container">
                    <div class="row-12">
                        <div class="col ">
                            <a href="#" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addModal">Agregar Juego</a>
                        </div>
                    </div>
                </div>
            </section>

            <div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Agregar Juegos</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <form class="was-validated" method="POST" action="${pageContext.request.contextPath}/Servletjuego">
                            <div class="modal-body">                         
                                <div class="mb-3">
                                    <label for="nombre_juego" class="col-form-label">nombre del juego</label>
                                    <input type="text" class="form-control" id="nombre_juego" name="nombre_juego" min="1" required>
                                </div>
                                <div class="mb-3">
                                    <label for="fecha_lanzamiento" class="col-form-label">fecha lanzamiento</label>
                                    <input type="date" class="form-control" id="fecha_lanzamiento" name="fecha_lanzamiento"  required>
                                </div>
                                <div class="mb-3">
                                    <label for="precio" class="col-form-label">precio</label>
                                    <input type="number" class="form-control" id="precio" name="precio"  required>
                                </div>
                                <div class="mb-3">
                                    <label for="desarrolladora_id" class="col-form-label">desarrolladora id</label>
                                    <input type="number" class="form-control" id="desarrolladora_id" name="desarrolladora_id"  required>
                                </div>
                                <div class="mb-3">
                                    <label for="distribuidora_id" class="col-form-label">distribuidora id</label>
                                    <input type="number" class="form-control" id="distribuidora_id" name="distribuidora_id"  required>
                                </div>
                                <div class="mb-3">
                                    <label for="genero_id" class="col-form-label">genero id</label>
                                    <input type="number" class="form-control" id="genero_id" name="genero_id"  required>
                                </div>

                                <input type="hidden" value="insertar" id="accion" name="accion">

                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                                <button type="submit" class="btn btn-primary">Guardar</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <section class="p-5" id="juegos">
                <div class="card">
                    <div class="card-header text-white bg-primary">
                        <h4 class="text-center">Listado juegos</h4>
                    </div>
                </div>
                <div class="table-responsive">
                    <table class="table table-striped">
                        <thead class="table-dark">
                            <tr>
                                <th>ID Juego</th>
                                <th>Nombre del Juego</th>
                                <th></th>
                                <th>Fecha de Lanzamiento</th>
                                <th>Precio</th>
                                <th>Desarrolladora</th>
                                <th>Distribuidora</th>
                                <th>Genero</th>
                                <th>Editar Registros</th>
                                <th>Eliminar</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listaJuegos}" var="juego">
                                <tr>
                                    <td>${juego.id_juego}</td>
                                    <td>${juego.nombre_juego}</td>
                                    <td><img src="../assets/images/${juego.nombre_juego}.png" height="70" width="90" class="d-block w-100"></td>
                                    <td>${juego.fecha_lanzamiento}</td>
                                    <td>${juego.precio}</td>
                                    <td>${juego.desarrolladora_id}</td>
                                    <td>${juego.distribuidora_id}</td>
                                    <td>${juego.genero_id}</td>
                                    <td>
                                        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/Servletjuego?accion=editar&id=${juego.id_juego}">
                                            <i class="fa fa-edit"></i> Editar
                                        </a>
                                    </td>
                                    <td><a class="btn btn-secondary" href="${pageContext.request.contextPath}/Servletjuego?accion=eliminar&id=${juego.id_juego}">
                                            <i class="far fa-trash-alt"></i> Eliminar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </section>

        </main>
        <aside>

        </aside>
        <jsp:include page="../WEB-INF/paginas/comunes/pie-pagina.jsp"/>
        <script src="https://kit.fontawesome.com/04a0d4ff34.js" crossorigin="anonymous"></script>
        <script type="text/javascript" src="../assets/js/bootstrap.bundle.js"></script>
    </body>

</html>
