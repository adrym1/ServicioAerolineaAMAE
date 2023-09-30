<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Configuración Cuenta</title>
<link rel="stylesheet" href="css/estilosLogin.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="icon" href="img/logo/Logo-sinfondo.png">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>


<body>

	<div id="general-content">
		<jsp:include page="navVertical.jsp"></jsp:include>
		<div id="right-content">
			<div id="right-adentro">
			
				<c:if test="${usu != null }">
				<form class="cambio-content" method="post" action="actUsuario"  enctype='multipart/form-data'>
					<div>
						<h2>Configuración de Cuenta</h2>
					</div>
					<div class="cont-linea"></div>

					<div class="form-cont">

						<div>
							<h5>Imagen de perfil</h5>
						</div>
						<div class="cont-linea"></div>
						<div class="img-cont">
								<label for="formFile" class="form-label" style="grid-column: 1/3">Actualizar Imagen</label>
								
								
								 <input class="form-control" type="file" placeholder="*.jpg, *.png"
									id="formFile"  style="grid-column: 1/2; width: 95%;" name="fileFoto">
									<button  style="grid-column: 2/3;" type="submit" class="btn btn-primary" name="btnActualizar" value="perfil">Actualizar</button>
						</div>
						
						
						<h5 style="margin-top: 4rem;">Datos de la Cuenta</h5>
						<div class="cont-linea"></div>




						<div class="labels-cambio">
							<label for="">Email Actual: </label> <label for="">Contraseña
								Actual: </label>
						</div>
						<div class="inputs-cambio">
							
							<input type="text" name="txtEmailActual" value="${usu.usuario }"
								readonly class="form-control"> <input type="password"
								name="txtContraActual" id="actual" value="${usu.clave }"
								readonly class="form-control">
							<button type="button" onclick="mostrarContra(0)"
								class="btn btn-primary" name="btnActual">Mostrar</button>
						</div>
					</div>
					<div class="form-cont" style="margin: 2rem auto -2rem auto;">
						<h5>Actualizar Datos</h5>
						<div class="cont-linea"></div>
						<div class="labels-cambio">
							<label for="">Email Nueva: </label> <label for="">Contraseña
								Nueva: </label>
						</div>
						<div class="inputs-cambio">
							<input type="text" name="txtEmailAct" value="${email }"
								class="form-control"> <input type="password"
								name="txtContraAct" id="nueva" value="${pass }" class="form-control"
								required>
							<button type="button" onclick="mostrarContra(1)"
								class="btn btn-primary" name="btnNuevo">Mostrar</button>
						</div>
						<div class="btn-cambio">
							<button type="submit" class="btn btn-primary" name="btnActualizar" value="usuario">Actualizar Datos</button>
						</div>

					</div>

				</form>
				</c:if>
				<c:if test="${usu == null }">
					<jsp:include page="errorCuenta.jsp"></jsp:include>
				</c:if>

			</div>

		</div>
	</div>


</body>
<style>
.img-cont{
	display: grid;
	grid-template-columns: 80% 20%;
	
}

</style>
<script>
	function mostrarContra(index) {
		if (index == 0) {
			var tipo = document.getElementById("actual");
			var btn = document.getElementsByName("btnActual");
			if (tipo.type == "password") {
				btn[0].innerHTML = "Esconder";
				tipo.type = "text";
			} else {
				btn[0].innerHTML = "Mostrar";
				tipo.type = "password";
			}

		} else {
			var tipo = document.getElementById("nueva");
			var btn = document.getElementsByName("btnNuevo");
			if (tipo.type == "password") {
				btn[0].innerHTML = "Esconder";
				tipo.type = "text";
			} else {
				btn[0].innerHTML = "Mostrar";
				tipo.type = "password";
			}
		}

	}
</script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
${mensajeError }
</html>