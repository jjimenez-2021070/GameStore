<%-- 
    Document   : editar-usuarios
    Created on : 31 ago 2022, 15:08:13
    Author     : joser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Editar Usuarios</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="../assets/css/estilo-pantalla-inicio.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.css">
    </head>
    <body> 
        <jsp:include page="../WEB-INF/paginas/comunes/encabezado.jsp"/>
        
        <header id="main-header" class="py-2">

        </header>

        <main>
            <div class="container">
                <div class="row">
                    <div class="col-1 col-md-1">

                    </div>
                    <div class="col-10 col-md-10"             
                         <div class="card">
                        <div class=" card-header">
                            <h4>Editar Usuario</h4>
                        </div>
                    </div>
                    <form method="POST" action="${pageContext.request.contextPath}/ServletUsuario">
                        <div class="container">
                            <div class="row">
                                <div class="col-4">
                                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/ServletUsuario?accion=listar">
                                        <i class="fas fa-undo-alt"></i>Regresar
                                    </a>
                                </div>
                                <div class="col-4">
                                    <button type="submit" class="btn btn-success">
                                        <i class="fas fa-check"></i>Guardar cambios
                                    </button>
                                </div>
                                <div class="col-4">
                                    <a class="btn btn-warning" href="${pageContext.request.contextPath}/ServletUsuario?accion=eliminar&id=${usuario.user}">
                                        <i class="fas fa-trash"></i>Eliminar
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="modal-body">              
                            <div class="mb-3">
                                <label for="user" class="col-form-label">User:</label>
                                <input type="text" class="form-control" id="user" name="user" value="${usuario.getUser()}" readonly>
                            </div>
                            <div class="mb-3">
                                <label for="pass" class="col-form-label">Contraseña:</label>
                                <input type="number" class="form-control" id="pass" name="pass" value="${usuario.getPass()}" required>
                            </div>
                            <div class="mb-3">
                                <label for="correo" class="col-form-label">Correo electronico:</label>
                                <input type="text" class="form-control" id="correo" name="correo" value="${usuario.getCorreo_electronico()}" required>
                            </div>
                            <div class="mb-3">
                                <label for="persona" class="col-form-label">Id persona:</label>
                                <input type="text" class="form-control" id="persona" name="persona" value="${usuario.getPersona_id()}">
                            </div>
                            <div class="mb-3">
                                <label for="rol" class="col-form-label">Id rol:</label>
                                <input type="text" class="form-control" id="rol" name="rol" value="${usuario.getRol_id()}" required>
                            </div>

                            <input type="hidden" name="accion" value="actualizar">
                        </div>
                    </form>
                </div>
                <div class="col-1 col-md-1">

                </div>
            </div>
        </div>
    </main>

    <jsp:include page="../WEB-INF/paginas/comunes/pie-pagina.jsp"/>
    <script src="https://kit.fontawesome.com/04a0d4ff34.js" crossorigin="anonymous"></script>
    <script type="text/javascript" src="../assets/js/bootstrap.bundle.js"></script>
</body>
</html>