<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="icon" href="img/logo/Logo-sinfondo.png">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/estilosLogin.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
</head>

<body class="fondo">
    <div class="cont-general">
        <div class="cont-img">
            <img src="img/login/NAPLES-jacbcn.jpg">
        </div>


        <form action="login" method="post" class="cont-login">
            <div class="cabezera-login">

                <img class="img-logo" src="img/login/logo_sin_fondo_2.png" alt="">
            </div>
            <h1>Login</h1>

            <div class="ingresar">
                <label for="">Email: </label>
                <input class="form-control" type="email" name="txtEmail" placeholder="Ejm: example@example.com">
            </div>
            <div class="ingresar">
                <label for="">Contraseña: </label>
                <input type="password" class="form-control" name="txtContra" placeholder="######">
            </div>
            <div class="boton">
                <button type="submit" class="btn btn-primary" name="btnIngresar" value="loguear">Ingresar</button>
            </div>
            <div class="invitado-login">
                <a href="IntranetPrincipal.jsp">Ingresar como invitado <i class="bi bi-arrow-right-circle-fill"></i></a>
            </div>
        </form>

    </div>


</body>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
${mensajeError }
</html>