<%-- 
    Document   : login
    Created on : 3 sep 2022, 9:54:41
    Author     : joser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Iniciar sesion y crear cuenta</title>
        <link rel="stylesheet" href="../assets/css/estilo-login.css">
    </head>
    <body>
        <div class="center">
            <div class="btns">
                <a class="a1" href="#">Iniciar Sesion</a>
                <a class="a2" href="#">Crear Cuenta</a>			
            </div>
            <div class="login-form">
                <div class="header">Crear Cuenta</div>
                <div class="signup_error"></div>
                <form action="home.html" name="signupForm" method="post" onsubmit="return signupValid()">
                    <input type="text" name="firstname" placeholder="primer nombre" autocomplete="off">
                    <input class="lstname" name="lastname" type="text" placeholder="ultimo nombre" autocomplete="off">	
                    <input class="email" name="email" type="text" placeholder="email" autocomplete="off">	
                    <input class="email" name="password" type="password" placeholder="contraseña" autocomplete="off">
                    <input type="submit" value="Signup">
                </form>
            </div>
            <div class="signup-form">
                <div class="header header1">Iniciar Sesion</div>
                <form action="">
                    <input class="email" type="text" placeholder="email">	
                    <input class="email" type="password" placeholder="contraseña">
                    <input type="submit" value="Login">
                </form>
            </div>
        </div>
        <script src="../assets/js/login.js"></script>
        <script src="../assets/js/validacion.js"></script>

    </body>
</html>