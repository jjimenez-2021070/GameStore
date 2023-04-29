<%-- 
    Document   : distribuidoras
    Created on : 1 sep 2022, 18:52:23
    Author     : joser
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
                            <p>Usuarios</p>
                        </div>
                    </div>
                </div>
            </div>
        </header>

        <main>

            <section id="accions" class="py-4 mb-4">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <a href="#" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addModal">Agregar Usuario</a>
                        </div>
                    </div>
                </div>
            </section>

            <div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Agregar Usuario</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <form class="was-validated" method="POST" action="${pageContext.request.contextPath}/ServletUsuario">
                            <div class="modal-body">                         
                                <div class="mb-3">
                                    <label for="pass" class="col-form-label">Contraseña:</label>
                                    <input type="password" class="form-control" id="pass" name="pass" required>
                                </div>
                                <div class="mb-3">
                                    <label for="correo" class="col-form-label">Correo Electronico:</label>
                                    <input type="text" class="form-control" id="correo" name="correo">
                                </div>
                                <div class="mb-3">
                                    <label for="persona" class="col-form-label">Id persona:</label>
                                    <input type="number" class="form-control" id="persona" name="persona" required>
                                </div>
                                <div class="mb-3">
                                    <label for="rol" class="col-form-label">Id rol:</label>
                                    <input type="number" class="form-control" id="rol" name="rol">
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

            <section class="p-5" id="usuarios">
                <div class="card">
                    <div class="card-header text-white bg-primary">
                        <h4 class="text-center">Listado Usuarios</h4>
                    </div>
                </div>
                <div class="table-responsive">
                    <table class="table table-striped">
                        <thead class="table-dark">
                            <tr>
                                <th>Usuario</th>
                                <th>Contraseña</th>
                                <th>Correo electronico</th>
                                <th>Persona id</th>
                                <th>Rol id</th>
                                <th>Editar registro</th>
                                <th>Eliminar</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listaUsuarios}" var="usuario">
                                <tr>
                                    <td>${usuario.user}</td>
                                    <td>••••••••</td>
                                    <td>${usuario.correo_electronico}</td>
                                    <td>${usuario.persona}</td>
                                    <td>${usuario.rol}</td>
                                    <td>
                                        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/ServletUsuario?accion=editar&id=${usuario.user}">
                                            <i class="fa fa-edit"></i> Editar
                                        </a>
                                    </td>
                                    <td>
                                        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/ServletUsuario?accion=eliminar&id=${usuario.user}">
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
