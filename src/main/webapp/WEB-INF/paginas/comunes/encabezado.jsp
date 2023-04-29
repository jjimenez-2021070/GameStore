<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand m-0 pt-2 pb-0" href="${pageContext.request.contextPath}/index.jsp">
            <img src="${pageContext.request.contextPath}/assets/images/Screenshot 2022-09-01 172633.png" alt="logo" width="150" height="70"
                 class="d-inline-block align-text-top">
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#menu"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="menu">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link active" href="${pageContext.request.contextPath}/index.jsp">Inicio</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/ServletSuscripcion?accion=listar">Suscripción</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        Listas
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/ServletPersona?accion=listar">Personas</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/ServletDesarrolladora?accion=listar">Empresas desarrolladoras</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/Servletjuego?accion=listar">Juegos</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/ServletListaDeseados?accion=listar">Lista de deseados</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/ServletRol?accion=listar">Roles</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/ServletGenero?accion=listar">Generos</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/ServletCliente?accion=listar">Clientes</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/ServletDistribuidora?accion=listar">Distribuidoras</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/ServletEmpleado?accion=listar">Empleados</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/ServletUsuario?accion=listar">Usuarios</a></li>
                    </ul>
                </li>
            </ul>
            <hr class="text-white-50">
            <ul class="navbar-nav flex-row flex-wrap text-light">
                <li class="nav-item col-6 col-md-auto p-3">
                    <a href="#" class="text-reset txt-link d-md-none ms-2">Sing Up</a>
                </li>
                <li class="nav-item col-6 col-md-auto p-3">
                    <a href="${pageContext.request.contextPath}/login/login.jsp" class="text-reset txt-link d-md-none ms-2">Login</a>
                </li>
            </ul>
            <form class="d-flex"></form>
            <a href="${pageContext.request.contextPath}/">
                <button class="btn btn-outline-primary d-none d-md-inline-block mx-3" type="sumit">
                    Sing up
                </button>
            </a>
            <a href="${pageContext.request.contextPath}/login/login.jsp">
                <button class="btn btn-outline-primary d-none d-md-inline-block" type="sumit">
                    Login
                </button>
            </a>
        </div>
    </div>
</nav>