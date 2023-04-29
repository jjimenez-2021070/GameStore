<%-- 
    Document   : index
    Created on : 2 sep 2022, 18:53:53
    Author     : joser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <title>Games Store</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="./assets/css/estilo-pantalla-inicio.css">
        <link rel="stylesheet" type="text/css" href="./assets/css/bootstrap.css">
    </head>

    <body>
        <header>
            <jsp:include page="WEB-INF/paginas/comunes/encabezado.jsp"/>
            <div class="img-background text-light fs-1">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-2 col-md-2">

                        </div>
                        <div class="col-lg-8 col-md-8">
                            <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="false">
                                <div class="carousel-indicators">
                                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
                                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
                                </div>
                                <div class="carousel-inner">
                                    <div class="carousel-item active">
                                        <img src="./assets/images/juego-1.png" class="d-block w-100" alt="...">
                                        <div class="carousel-caption d-none d-md-block">
                                            <h5>Top 3</h5>
                                            <p>juegos mas populares</p>
                                        </div>
                                    </div>
                                    <div class="carousel-item">
                                        <img src="./assets/images/juego-2.png" class="d-block w-100" alt="...">
                                        <div class="carousel-caption d-none d-md-block">
                                            <h5>Top 3</h5>
                                            <p>juegos mas populares</p>
                                        </div>
                                    </div>
                                    <div class="carousel-item">
                                        <img src="./assets/images/juego-3.png" class="d-block w-100" alt="...">
                                        <div class="carousel-caption d-none d-md-block">
                                            <h5>Top 3</h5>
                                            <p>Juegos mas populares</p>
                                        </div>
                                    </div>
                                </div>
                                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
                                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                    <span class="visually-hidden">Previous</span>
                                </button>
                                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
                                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                    <span class="visually-hidden">Next</span>
                                </button>
                            </div>  
                        </div>
                        <div class="col-lg-2 col-md-2">

                        </div>
                    </div>
                </div>
            </div>
        </header>
        <main>

        </main>
        <aside>

        </aside>
        <jsp:include page="WEB-INF/paginas/comunes/pie-pagina.jsp"/>
        <script src="https://kit.fontawesome.com/04a0d4ff34.js" crossorigin="anonymous"></script>
        <script type="text/javascript" src="./assets/js/bootstrap.bundle.js"></script>
    </body>

</html>
