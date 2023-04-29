<%-- 
    Document   : editar-cliente
    Created on : 1 sep 2022, 18:50:12
    Author     : joser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Editar Clientes</title>
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
                            <h4>Editar Clientes</h4>
                        </div>
                    </div>
                    <form method="POST" action="${pageContext.request.contextPath}/ServletCliente">
                        <div class="container">
                            <div class="row">
                                <div class="col-4">
                                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/ServletCliente?accion=listar">
                                        <i class="fas fa-undo-alt"></i>Regresar
                                    </a>
                                </div>
                                <div class="col-4">
                                    <button type="submit" class="btn btn-success">
                                        <i class="fas fa-check"></i>Guardar cambios
                                    </button>
                                </div>
                                <div class="col-4">
                                    <a class="btn btn-warning" href="${pageContext.request.contextPath}/ServletCliente?accion=eliminar&id_cliente=${cliente.getId_cliente()}">
                                        <i class="fas fa-trash"></i>Eliminar
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="modal-body">              
                            <div class="mb-3">
                                <label for="id_cliente" class="col-form-label">ID:</label>
                                <input type="text" class="form-control" id="id_cliente" name="id_cliente" value="${cliente.getId_cliente()}" readonly>
                            </div>
                            <div class="mb-3">
                                <label for="nit" class="col-form-label">NIT:</label>
                                <input type="text" class="form-control" id="nombre1" name="nit" value="${cliente.getNit()}" required>
                            </div>
                            
                            <div class="mb-3">
                                <label for="persona_id" class="col-form-label">Persona ID:</label>
                                <input type="number" class="form-control" id="persona_id" name="persona_id" value="${cliente.getPersona_id()}" required>
                            </div><!-- comment -->
                            
                            <div class="mb-3">
                                <label for="suscripcion_id" class="col-form-label">Sub ID:</label>
                                <input type="number" class="form-control" id="suscripcion_id" name="suscripcion_id" value="${cliente.getSuscripcion_id()}" required>
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
