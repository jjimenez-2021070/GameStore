<%-- 
    Document   : editar-usuario
    Created on : 2 sep 2022, 20:41:26
    Author     : joser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Editar Distribuidora</title>
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
                            <h4>Editar Distribuidora</h4>
                        </div>
                    </div>
                    <form method="POST" action="${pageContext.request.contextPath}/ServletDistribuidora">
                        <div class="container">
                            <div class="row">
                                <div class="col-4">
                                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/ServletDistribuidora?accion=listar">
                                        <i class="fas fa-undo-alt"></i>Regresar
                                    </a>
                                </div>
                                <div class="col-4">
                                    <button type="submit" class="btn btn-success">
                                        <i class="fas fa-check"></i>Guardar cambios
                                    </button>
                                </div>
                                <div class="col-4">
                                    <a class="btn btn-warning" href="${pageContext.request.contextPath}/ServletDistribuidora?accion=eliminar&id=${distribuidora.id}">
                                        <i class="fas fa-trash"></i>Eliminar
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="modal-body">              
                            <div class="mb-3">
                                <label for="id" class="col-form-label">ID:</label>
                                <input type="text" class="form-control" id="id" name="id" value="${distribuidora.getId()}" readonly>
                            </div>
                            <div class="mb-3">
                                <label for="nombre_distribuidora" class="col-form-label">nombre Distribuidora:</label>
                                <input type="text" class="form-control" id="nombre1" name="nombre_distribuidora" value="${distribuidora.getNombre_distribuidora()}" required>
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
