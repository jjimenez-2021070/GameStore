<%-- 
    Document   : lista-deseados
    Created on : 3 sep 2022, 12:18:49
    Author     : joser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="es_GT"/>
<!DOCTYPE html>
<html>
    <head>
        <title>Game Store</title>
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
                            <p>Lista deseados</p>
                        </div>
                    </div>
                </div>
            </div>
        </header>

        <main>

            <section id="accions" class="py-4 ">
                <div class="container-fluid text-center ">
                    <div class="row ">
                        <div class="col ">
                            <a href="#" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addModal">Agregar deseados</a>
                        </div>
                    </div>
                </div>
            </section>

            <div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Agregar Deseados</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <form class="was-validated" method="POST" action="${pageContext.request.contextPath}/ServletListaDeseados">
                            <div class="modal-body">                         
                                <div class="mb-3">
                                    <label for="juego_id" class="col-form-label">Id del Juego</label>
                                    <input type="number" class="form-control" id="juego_id" name="juego_id" min="1" required>
                                </div>
                                <div class="mb-3">
                                    <label for="fecha_agregado" class="col-form-label">fecha lanzamiento</label>
                                    <input type="date" class="form-control" id="fecha_agregado" name="fecha_agregado"  required>
                                </div>
                                <div class="mb-3">
                                    <label for="cliente_id" class="col-form-label">Id del Cliente</label>
                                    <input type="number" class="form-control" id="cliente_id" name="cliente_id" min="1" required>
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

            <section class="p-5" id="deseados">
                <div class="card">
                    <div class="card-header text-white bg-primary">
                        <h4 class="text-center">Lista de deseados</h4>
                    </div>
                </div>
                <div class="table-responsive">
                    <table class="table table-striped">
                        <thead class="table-dark">
                            <tr>
                                <th>Id</th>
                                <th>Juego</th>
                                <th>Fecha</th>
                                <th>Cliente</th>
                                <th>Editar Registros</th>
                                <th>eliminar</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listaDeseados}" var="deseados">
                                <tr>
                                    <td>${deseados.id_lista}</td>
                                    <td>${deseados.juego_id}</td>
                                    <td>${deseados.fecha_agregado}</td>
                                    <td>${deseados.cliente_id}</td>
                                    <td>
                                        <a class="btn btn-secondary" href="#">
                                            <i class="fa fa-edit"></i> Editar
                                        </a>
                                    </td>
                                    <td>
                                        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/ServletListaDeseados?accion=eliminar&id=${deseados.id_lista}">
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
        <script type="text/javascript" src="../assets/js/"></script>
    </body>
</html>
