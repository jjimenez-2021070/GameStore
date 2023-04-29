<%-- 
    Document   : roles
    Created on : 3/09/2022, 11:38:39
    Author     : TulioJimènez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="es_GT"/>
<!DOCTYPE html>
<html>
    <head>
        <title>Game store Roles</title>
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
                            <p>Roles</p>
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
                            <a href="#" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addModal">Agregar Rol</a>
                        </div>
                    </div>
                </div>
            </section>

            <div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Agregar Rol</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <form class="was-validated" method="POST" action="${pageContext.request.contextPath}/ServletRol">
                            <div class="modal-body">                         
                                <div class="mb-3">
                                    <label for="descripcion" class="col-form-label">Descripcion:</label>
                                    <input type="text" class="form-control" id="descripcion" name="descripcion" required>
                                </div>
                                <input type="hidden" value="insertar" id="accion" name="accion">
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <section class="p-5" id="roles">
                <div class="card">
                    <div class="card-header text-white bg-primary">
                        <h4 class="text-center">Listado Roles</h4>
                    </div>
                </div>
                <div class="table-responsive">
                    <table class="table table-striped">
                        <thead class="table-dark">
                            <tr>
                                <th>ID Rol</th>
                                <th>Descripcion Rol</th>
                                <th>Editar Registros</th>
                                <th>Eliminar</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listaRoles}" var="rol">
                                <tr>
                                    <td>${rol.id_rol}</td>
                                    <td>${rol.descripcion_rol}</td>
                                    <td>
                                        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/ServletRol?accion=editar&id=${rol.id_rol}">
                                            <i class="fa fa-edit"></i> Editar
                                        </a>
                                    </td>
                                    <td>
                                        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/ServletRol?accion=eliminar&id=${rol.id_rol}">
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