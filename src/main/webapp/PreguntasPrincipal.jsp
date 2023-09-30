<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="icon" href="img/logo/Logo-sinfondo.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reglamento y Preguntas Frecuentes</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="css/estilosPrincipal.css">
</head>
<script ></script>
<body>
    <header>
        <nav class="nav_bar" id="navbar">
            <a class="logo_link" id="nav_logo" href="PaginaPrincipal.jsp"><img class="logo_img" id="logo_principal"
                    src="img/logo/logo_sin_fondo.png" alt=""></a>
            <div class="content_bar" id="content_bar">
					<a class="nav_enlace" href="PaginaPrincipal.jsp">Inicio</a>
                <a class="nav_enlace" href="pagina_ofertas.html">Ofertas</a>
                <a class="nav_enlace" href="PreguntasPrincipal.jsp">Reglamento y Preguntas Frecuentes</a>
                

            </div>
            <div class="ingresar" id="ingresar">
                <a href="login.jsp" class="btn btn-primary">Iniciar Sesión</a>

            </div>
            <div id="shrink_ingresar"></div>
        </nav>
    </header>
    <div id="content">
        <h1 class="titulo">Reglamento General</h1>
        <div class="info_general">
            <p class="salto">
                Reglamento General sobre los vuelos que deben ser leidas al momento de realizar su viaje
            </p>
            <h4 class="salto">INFORMACIÓN SOBRE LA COVID-19</h4>
            <p class="salto">Por los tiempos dificiles de la COVID-19, nuestras has sido cambiadas para darle una
                seguridad correcta.
                Por lo cuál, hemos aumentado nuestra flexibidad en nuestras politicas, se recomienda su leída</p>
            <i>*Información sujeta a cambios por el reglamento de cada país*</i>
        </div>
        <div class="enlaces_docu ">
            <strong class="salto">Link de descarga sobre el reglamento general: <a href="">Link</a></strong>
            <strong class="salto">Link de descarga sobre el politicas de privacidad: <a href="">Link</a></strong>
        </div>
        <div class="flanja_separa">

        </div>
        <h1 class="salto titulo_pre ">Preguntas frecuentes</h1>
        <div class="pregunta_respues">
            <div class="box_pregunta" onclick="mostrarRepuesta(1)">
                <div class="pregunta">
                    <h3>¿Es necesario crearme una cuenta?</h3>
                    <i class="bi bi-chevron-up esconder" id="flecha1"></i>
                </div>
                <div class="linea esconder"></div>
                <div id="respuesta1" class="esconder respuestas"></div>

            </div>
            <div class="dashed_line"></div>
            <div class="box_pregunta" onclick="mostrarRepuesta(2)">
                <div class="pregunta">
                    <h3>¿Que hacer si no pude hacer el check-in a tiempo</h3>
                    <i class="bi bi-chevron-up esconder" id="flecha2"></i>
                </div>
                <div class="linea esconder"></div>
                <div id="respuesta2" class="esconder respuestas"></div>
            </div>
            <div class="dashed_line"></div>
            <div class="box_pregunta" onclick="mostrarRepuesta(3)">
                <div class="pregunta">
                    <h3>¿Cuales son los requisitos para viajar?</h3>
                    <i class="bi bi-chevron-up esconder" id="flecha3"></i>
                </div>
                <div class="linea esconder"></div>
                <div id="respuesta3" class="esconder respuestas"></div>
            </div>
            <div class="dashed_line"></div>
            
        </div>
    </div>
    <footer>
        <div class="foot_general">
            <div class="col_izq">
                <img class="foot_logo" src="../img/logo_sin_fondo.png" alt="Logo">
            </div>
            <div class="centro">
                <div class="foot_enlaces_izq">
                    <a href="PreguntasPrincipal.jsp">Inicio</a>
                    <a href="pagina_ofertas.html">Ofertas</a>
                </div>
                <div class="foot_enlaces_dere">
                    <a href="PreguntasPrincipal.jsp">Preguntas y Respuestas</a>
                </div>


            </div>
            <div class="col_dere">
                <div class="foot_numero">
                    <h5>Numero de contacto</h5>
                    <a href="">001-4562-7895</a>
                </div>
                <div class="foot_redes">
                    <a href=""><i class="bi bi-facebook"></i></a>
                    <a href=""><i class="bi bi-twitter"></i></a>
                    <a href=""><i class="bi bi-youtube"></i></a>
                    <a href=""><i class="bi bi-line"></i></a>
                </div>
            </div>
        </div>
    </footer>
</body>

<script src="js/js.js"></script>

</html>