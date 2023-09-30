<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Check-In</title>
<link rel="stylesheet" href="css/checkin.css">
<link rel="icon" href="img/logo/Logo-sinfondo.png">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body>
	<div id="general-content">
        <jsp:include page="navVertical.jsp"></jsp:include>
        <div id="right-content">
            <div id="right-adentro">
            
	<div class="contenedor">


		<div style="margin: auto auto; width: 80%; padding-top: 8vh ; padding-bottom: 10vh">
			<h2 style="text-align: center">Activa tu Vuelo - Check-In</h2>
			<h4 style="margin-top: 12vh">Ingresa los datos del viaje:</h4>
			<form action="checkIn" method="post"
				style="display: flex; flex-direction: column;">
				<div style="margin-top: 5vh">
					<label for="nombres">N° Orden / Codigo de reserva</label> <input
						type="text" name="txtOrden" id="orden" required="required"
						class="form-control">
						
						 

				</div>
				<i style="margin-top: 5vh" id="icono" onmouseover="mostrarTexto()" onmouseleave="ocultarTexto()"><b>¿Donde
							encontralo?</b></i>
				
				<div class="mostrar "  style="margin-top: 5vh">
					<div>
					<label for="nombres">Fecha de la Venta: </label> <input
						type="date" name="txtFechaVenta" id="apellido" required="required"
						class="form-control">
					</div>
					<div>
					<label for="nombres">DNI del comprador:  </label> <input
						type="text" name="txtDNI" id="apellido" required="required"
						class="form-control">
					</div>
						
				</div>

				<div class="flotante quitar " id="mostrar">
					<img src="img/ejemplo/Ejemplo-check.JPG">
					<p>Si compraste en nuestra nueva aerolinea, tendrás un Nº de
						reserva. Es un código numerico, por ejemplo, 9999999.
						Búscalo en los ticket que te enviamos al momento de la compra</p>
				</div>
		

		<div style="margin-top: 15vh" class="botones">
			
			<button type="submit" class="btn btn-primary" name="btnAccion" value="check">Check-in</button>
		</div>

		
		</form>

		${mensaje }

	</div>

	</div>
            
            
            </div>
            </div>
            </div>



	
	<script src="js/check-in.js"></script>
</body>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
${mensaje }
<style>
	label{
	font-weight: bold;
	font-size: large;
	}
	.contenedor{
	padding: 3vh auto;	
	border: 1px #BFBFBF solid;
	box-shadow: 0px 0px 8px 0px #BFBFBF;
	}

	.flotante{
	padding: 2rem;
	background-color: white;
	border: 1px #BFBFBF solid;
	box-shadow: 0px 0px 8px 0px #BFBFBF;
	position: absolute;
	width: 37%;
	left:55%;
	top: 15%;
	}
	.flotante img{
		width: 100%;
		height: 100%;
	}
	.mostrar{
	display: grid; 
	width: 100%;
	grid-template-columns: 50% 50%
}
.mostrar input{
	width: 80%;
}
	.botones{
		display: flex;
		justify-content: space-around;
	}
	.botones button{
	width: 20%;}
	</style>
</html>