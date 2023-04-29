<%-- 
    Document   : editar-personas
    Created on : 31 ago 2022, 15:08:13
    Author     : joser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Editar Personas</title>
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
                            <h4>Editar Persona</h4>
                        </div>
                    </div>
                    <form method="POST" action="${pageContext.request.contextPath}/ServletPersona">
                        <div class="container">
                            <div class="row">
                                <div class="col-4">
                                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/ServletPersona?accion=listar">
                                        <i class="fas fa-undo-alt"></i>Regresar
                                    </a>
                                </div>
                                <div class="col-4">
                                    <button type="submit" class="btn btn-success">
                                        <i class="fas fa-check"></i>Guardar cambios
                                    </button>
                                </div>
                                <div class="col-4">
                                    <a class="btn btn-warning" href="${pageContext.request.contextPath}/ServletPersona?accion=eliminar&id=${persona.id_persona}">
                                        <i class="fas fa-trash"></i>Eliminar
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="modal-body">              
                            <div class="mb-3">
                                <label for="id" class="col-form-label">ID:</label>
                                <input type="text" class="form-control" id="id" name="id" value="${persona.getId_persona()}" readonly>
                            </div>
                            <div class="mb-3">
                                <label for="nombre1" class="col-form-label">Primer nombre:</label>
                                <input type="text" class="form-control" id="nombre1" name="nombre1" value="${persona.getNombre1()}" required>
                            </div>
                            <div class="mb-3">
                                <label for="nombre2" class="col-form-label">Segundo nombre:</label>
                                <input type="text" class="form-control" id="nombre2" name="nombre2" value="${persona.getNombre2()}" required>
                            </div>
                            <div class="mb-3">
                                <label for="nombre3" class="col-form-label">Tercer nombre:</label>
                                <input type="text" class="form-control" id="nombre3" name="nombre3" value="${persona.getNombre3()}">
                            </div>
                            <div class="mb-3">
                                <label for="apellido1" class="col-form-label">Primer apellido:</label>
                                <input type="text" class="form-control" id="apellido1" name="apellido1" value="${persona.getApellido1()}" required>
                            </div>   
                            <div class="mb-3">
                                <label for="apellido2" class="col-form-label">Segundo apellido:</label>
                                <input type="text" class="form-control" id="apellido2" name="apellido2" value="${persona.getApellido2()}">
                            </div> 
                            <div class="mb-3">
                                <label for="email" class="col-form-label">Email:</label>
                                <input type="email" class="form-control" id="email" name="email" value="${persona.getEmail()}" required>
                            </div>
                            <div class="mb-3">
                                <label for="fechaNacimiento" class="col-form-label">Fecha de nacimiento:</label>
                                <input type="date" class="form-control" id="fechaNacimiento" name="fechaNacimiento" value="${persona.getFecha_nacimiento()}" required>
                            </div>
                            <div class="mb-3">
                                <label for="telefono" class="col-form-label">Telefono:</label>
                                <input type="tel" class="form-control" id="telefono" name="telefono" value="${persona.getTelefono()}" required>
                            </div>
                            <div class="mb-3">
                                <label for="direccion" class="col-form-label">Direccion:</label>
                                <input type="text" class="form-control" id="direccion" name="direccion" value="${persona.getDireccion()}" required step="any" min="0" max="999999.99">
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