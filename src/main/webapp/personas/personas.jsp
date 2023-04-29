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
        <title>Game store personas</title>
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
                            <p>Personas</p>
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
                            <a href="#" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addModal">Agregar Persona</a>
                        </div>
                    </div>
                </div>
            </section>

            <div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Agregar Persona</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <form class="was-validated" method="POST" action="${pageContext.request.contextPath}/ServletPersona">
                            <div class="modal-body">                         
                                <div class="mb-3">
                                    <label for="nombre1" class="col-form-label">Primer nombre</label>
                                    <input type="text" class="form-control" id="nombre1" name="nombre1" required>
                                </div>
                                <div class="mb-3">
                                    <label for="nombre2" class="col-form-label">Segundo nombre</label>
                                    <input type="text" class="form-control" id="nombre2" name="nombre2" required>
                                </div>
                                <div class="mb-3">
                                    <label for="nombre3" class="col-form-label">Tercer nombre</label>
                                    <input type="text" class="form-control" id="nombre3" name="nombre3">
                                </div>
                                <div class="mb-3">
                                    <label for="apellido1" class="col-form-label">Primer apellido:</label>
                                    <input type="text" class="form-control" id="apellido1" name="apellido1" required>
                                </div>
                                <div class="mb-3">
                                    <label for="apellido2" class="col-form-label">Segundo apellidos:</label>
                                    <input type="text" class="form-control" id="apellido2" name="apellido2">
                                </div>                                
                                <div class="mb-3">
                                    <label for="email" class="col-form-label">Email:</label>
                                    <input type="email" class="form-control" id="email" name="email" required>
                                </div>
                                <div class="mb-3">
                                    <label for="fechaNacimiento" class="col-form-label">Fecha de Nacimiento:</label>
                                    <input type="date" class="form-control" id="fechaNacimiento" name="fechaNacimiento" required>
                                </div>
                                <div class="mb-3">
                                    <label for="telefono" class="col-form-label">Telefono:</label>
                                    <input type="tel" class="form-control" id="telefono" name="telefono" required>
                                </div>
                                <div class="mb-3">
                                    <label for="direccion" class="col-form-label">Direccion:</label>
                                    <input type="text" class="form-control" id="direccion" name="direccion" required>
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

            <section class="p-5" id="personas">
                <div class="card">
                    <div class="card-header text-white bg-primary">
                        <h4 class="text-center">Listado Personas</h4>
                    </div>
                </div>

                <div class="table-responsive">
                    <table class="table table-striped">
                        <thead class="table-dark">
                            <tr>
                                <th>Id</th>
                                <th>Nombre completo</th>
                                <th>Email</th>
                                <th>Fecha de nacimiento</th>
                                <th>Telefono</th>
                                <th>Direccion</th>
                                <th>Editar registros</th>
                                <th>Eliminar</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listaPersonas}" var="persona">
                                <tr>
                                    <td>${persona.id_persona}</td>
                                    <td>${persona.nombre1} ${persona.nombre2} ${persona.nombre3} ${persona.apellido1} ${persona.apellido2}</td>
                                    <td>${persona.email}</td>
                                    <td>${persona.fecha_nacimiento}</td>
                                    <td>${persona.telefono}</td>
                                    <td>${persona.direccion}</td>
                                    <td>
                                        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/ServletPersona?accion=editar&id=${persona.id_persona}">
                                            <i class="fa fa-edit"></i> Editar
                                        </a>
                                    </td>
                                    <td>
                                        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/ServletPersona?accion=eliminar&id=${persona.id_persona}">
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