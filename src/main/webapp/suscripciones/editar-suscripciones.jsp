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
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="../assets/css/estilo-pantalla-inicio.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.css">
        <title>Editar suscripción</title>
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
                            <p>Editar suscripción</p>
                        </div>
                    </div>
                </div>
            </div>
        </header>

        <main class="pb-5 pt-3">

            <div class="container pb-5 pt-5">
                <div class="row">
                    <div class="col">

                        <form method="POST" action="${pageContext.request.contextPath}/ServletSuscripcion" class="was-validated"> 

                            <div class="container pt-4 pb-4">   
                                <div class="row">
                                    <div class="col-4 text-center">
                                        <a class="btn btn-secondary text-center" href="${pageContext.request.contextPath}/ServletSuscripcion?accion=listar">
                                            <i class="fa fa-arrow-left"></i> Regresar | Cancelar
                                        </a>
                                    </div>
                                    <div class="col-4 text-center">
                                        <button type="submit" class="btn btn-success">
                                            <i class="fas fa-check"></i> Guardar cambios
                                        </button>
                                    </div>
                                    <div class="col-4 text-center">
                                        <a class="btn btn-danger" href="${pageContext.request.contextPath}/ServletSuscripcion?accion=eliminar&id=${suscripcion.idSuscripcion}">
                                            <i class="fa fa-trash-alt"></i> Eliminar suscripción
                                        </a>
                                    </div>
                                </div>
                            </div>

                            <div class="modal-body">

                                <div class="mb-3">
                                    <label for="idSuscripcion" class="col-form-label">Id:</label>
                                    <input type="text" class="form-control" id="idSuscripcion" name="idSuscripcion" value="${suscripcion.idSuscripcion}" readonly="true"> 
                                </div>

                                <div class="mb-3">
                                    <label for="tipoSuscripcion" class="col-form-label">Tipo de suscripción:</label>
                                    <input type="text" class="form-control" id="tipoSuscripcion" name="tipoSuscripcion" value="${suscripcion.tipoSuscripcion}" required> 
                                </div>

                                <input type="hidden" value="actualizar" id="accion" name="accion">

                            </div>
                            <br>
                        </form>

                    </div>
                </div>
            </div>

        </main>

        <jsp:include page="../WEB-INF/paginas/comunes/pie-pagina.jsp"/>

        <script type="text/javascript" src="../assets/js/bootstrap.bundle.js"></script>
        <script src="https://kit.fontawesome.com/04a0d4ff34.js" crossorigin="anonymous"></script>
    </body>
</html>
