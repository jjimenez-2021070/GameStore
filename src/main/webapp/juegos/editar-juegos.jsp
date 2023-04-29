<%-- 

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="es_GT" />
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Editar estudiantes</title>
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
                            <h4>Editar Juego</h4>
                        </div>
                    </div>
                    <form method="POST" action="${pageContext.request.contextPath}/Servletjuego">
                        <div class="container">
                            <div class="row">
                                <div class="col-4">
                                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/Servletjuego?accion=listar">
                                        <i class="fas fa-undo-alt"></i>Regresar
                                    </a>
                                </div>
                                <div class="col-4">
                                    <button type="submit" class="btn btn-success">
                                        <i class="fas fa-check"></i>Guardar cambios
                                    </button>
                                </div>
                                <div class="col-4">
                                    <a class="btn btn-warning" href="${pageContext.request.contextPath}/Servletjuego?accion=eliminar&id=${juego.id_juego}">
                                        <i class="fas fa-trash"></i>Eliminar
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="modal-body">              
                            <div class="mb-3">
                                <label for="id" class="col-form-label">ID:</label>
                                <input type="text" class="form-control" id="id" name="id" value="${juego.getId_juego()}" readonly>
                            </div>
                            <div class="mb-3">
                                <label for="nombre_juego" class="col-form-label">nombre del juego</label>
                                <input type="text" class="form-control" id="nombre_juego" name="nombre_juego" value="${juego.getNombre_juego()}" min="1" required>
                            </div>
                            <div class="mb-3">
                                <label for="fecha_lanzamiento" class="col-form-label">fecha lanzamiento</label>
                                <input type="date" class="form-control" id="fecha_lanzamiento" name="fecha_lanzamiento" value="${juego.getFecha_lanzamiento()}" required>
                            </div>
                            <div class="mb-3">
                                <label for="precio" class="col-form-label">precio</label>
                                <input type="number" class="form-control" id="precio" name="precio" value="${juego.getPrecio()}" required>
                            </div>
                            <div class="mb-3">
                                <label for="desarrolladora_id" class="col-form-label">desarrolladora id</label>
                                <input type="number" class="form-control" id="desarrolladora_id" name="desarrolladora_id" value="${juego.getDesarrolladora_id()}" required>
                            </div>
                            <div class="mb-3">
                                <label for="distribuidora_id" class="col-form-label">distribuidora id</label>
                                <input type="number" class="form-control" id="distribuidora_id" name="distribuidora_id" value="${juego.getDistribuidora_id()}" required>
                            </div>
                            <div class="mb-3">
                                <label for="genero_id" class="col-form-label">genero id</label>
                                <input type="number" class="form-control" id="genero_id" name="genero_id" value="${juego.getGenero_id()}" required>
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