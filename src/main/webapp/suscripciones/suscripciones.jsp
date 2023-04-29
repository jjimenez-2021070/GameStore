<%-- 
    Document   : suscripciones
    Created on : 3/09/2022, 09:36:30
    Author     : Luis Carlos Pérez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="es_GT" />

<!DOCTYPE html>
<html lang="es">

    <head>
        <title>Suscripciones</title>
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
                            <p>Suscripciones</p>
                        </div>
                    </div>
                </div>
            </div>

        </header>
        <main>
            <section id="accions" class="py-4">
                <div class="container-fluid text-center ">
                    <div class="row">
                        <div class="col">
                            <a href="#" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addModal">Agregar suscripción</a>
                        </div>
                    </div>
                </div>
            </section>

            <div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Agregar suscripción</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>

                        <form method="POST" action="${pageContext.request.contextPath}/ServletSuscripcion" class="was-validated"> 
                            <div class="modal-body">

                                <div class="mb-3">
                                    <label for="tipoSuscripcion" class="col-form-label">Tipo de suscripción:</label>
                                    <input type="text" class="form-control" id="tipoSuscripcion" name="tipoSuscripcion" required> 
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

            <section class="p-5" id="fondo" id="suscripciones">
                <div class="card">
                    <div class="card-header text-primary bg-dark">
                        <h4 class="text-center">Listado de suscripciones</h4>
                    </div>
                </div>
                <div class="table-responsive">
                    <table class="table table-striped">
                        <thead class="table-dark">
                            <tr>
                                <th>Id</th>
                                <th>Tipo de suscripción</th>
                                <th>Editar registros</th>
                                <th>Eliminar</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${data}" var="suscripcion">
                                <tr>
                                    <td>${suscripcion.idSuscripcion}</td>
                                    <td>${suscripcion.tipoSuscripcion}</td>
                                    <td>
                                        <a class="btn btn-primary" href="${pageContext.request.contextPath}/ServletSuscripcion?accion=editar&idSuscripcion=${suscripcion.idSuscripcion}">
                                            <i class="fa fa-edit"></i> Editar
                                        </a>
                                    </td>
                                    <td>
                                        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/ServletSuscripcion?accion=eliminar&id=${suscripcion.idSuscripcion}">
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

        <jsp:include page="../WEB-INF/paginas/comunes/pie-pagina.jsp"/>

        <script type="text/javascript" src="../assets/js/bootstrap.bundle.js"></script>
        <script src="https://kit.fontawesome.com/04a0d4ff34.js" crossorigin="anonymous"></script>
    </body>

</html>