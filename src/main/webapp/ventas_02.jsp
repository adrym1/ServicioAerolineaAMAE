<%@page import="java.io.Console"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Persona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ventas - Pasajeros</title>
<link rel="icon" href="img/logo/Logo-sinfondo.png">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="css/navVertical.css">
<link rel="stylesheet" href="css/enzo2.css">
</head>

<body>
	<div id="general-content">
		<jsp:include page="navVertical.jsp"></jsp:include>
		<div id="right-content">
			<div class="right-dentro">
			 <div class="indice-venta" style="width:100%">
                    <div class="indice-dato">
                        <button class="btn btn-warning"><i class="bi bi-airplane-fill"></i></button>
                        <h3>Vuelo</h3>
                    </div>
                    <div class="flecha">
                        <div class="flecha-cuerpo"></div>
                        <div class="flecha-cabeza"></div>
                    </div>
                    <div class="indice-dato">
                        <button class="btn btn-warning indice-activo" ><i class="bi bi-people-fill"></i></button>
                        <h3>Pasajeros</h3>
                    </div>
                    <div class="flecha"></div>
                    <div class="indice-dato">
                        <button class="btn btn-warning"><i class="bi bi-bag"></i></button>
                        <h3>Compra</h3>
                    </div>
                    <div class="flecha"></div>
                    <div class="indice-dato">
                        <button class="btn btn-warning "><i class="bi bi-check-square-fill"></i></button>
                        <h3>Finalizado</h3>
                    </div>
                </div>
				<form action="ventaController" method="post">
		
					<c:if test="${Personas!=null }">
						<c:forEach items="${Personas }" var="per">
							<h2 style="text-align: center; margin: 1.5rem auto;"
								name="txtPersona">Persona 1</h2>

							<div class="form-group row info-vuelo">
								<div class="campo-1-btn">
									<label class="col-form-label lab-camp1-btn">Nombre: </label> <input
										type="text" class="form-control inp-camp1-btn"
										name="txtNombre" style="grid-column: 2/4; width: 90%"
										placeholder="######" value="${per.nombre }">

								</div>
								<div class="campo-1-btn">
									<label class="col-form-label lab-camp1-btn">Apellido: </label>
									<input type="text" class="form-control inp-camp1-btn"
										name="txtApellido" style="grid-column: 2/4; width: 90%"
										placeholder="######" value="${per.apellido }">

								</div>
								<div class="campos-2">
									<label class="col-form-label">DNI </label> <input type="text"
										class="form-control" name="txtDNI" placeholder="######"
										value="${per.dni }"> <label class="col-form-label">Sexo
									</label>
									<div>
										<select class="form-control" name="cmbSexo">
											<option selected>....</option>
											<option>Masculino</option>
											<option>Femenino</option>
										</select>
									</div>
								</div>
								<div class="campos-2">
									<label class="col-form-label">Nacionaldad: </label> <input
										type="text" class="form-control" name="txtNacionalidad"
										value="${per.naciona }" placeholder="######"> <label
										class="col-form-label">Edad: </label> <input type="number"
										name="txtEdad" class="form-control" placeholder="######"
										value="${per.edad }">
								</div>

								<div class="campo-1-btn">
									<label class="col-form-label lab-camp1-btn">Domicilio:
									</label> <input type="text" class="form-control inp-camp1-btn"
										name="txtDomicilio" style="grid-column: 2/4; width: 90%"
										placeholder="######" value="${per.domici }">

								</div>
								<div class="campos-2">
									<label class="col-form-label">Estado: </label> <input
										type="text" class="form-control" name="txtEstado"
										placeholder="######" value="${per.estado }"> <label
										class="col-form-label">Codigo Postal: </label> <input
										type="text" class="form-control" name="txtCodigoPos"
										value="${per.codiPostal }" placeholder="######">
								</div>
								<div class="campos-2">
									<label class="col-form-label">Pais: </label>
									<!-- El select de pais -->
									<select name="cmbPais" class="form-control">
										<c:forEach items="${lstPais }" var="pa">
											<c:if test="${pa.id_Pais == per.pais }">
												<option value="${pa.id_Pais }" selected>${pa.nombre }
												</option>
											</c:if>
											<c:if test="${pa.id_Pais != per.pais }">
												<option value="${pa.id_Pais }">${pa.nombre }</option>
											</c:if>
										</c:forEach>
									</select> 
								</div>
							</div>
						</c:forEach>
					</c:if>
					<c:if test="${Personas == null }">
						<h2 style="text-align: center; margin: 1.5rem auto;"
							name="txtPersona">Persona 1</h2>

						<div class="form-group row info-vuelo">
							<div class="campo-1-btn">
								<label class="col-form-label lab-camp1-btn">Nombre: </label> <input
									type="text" class="form-control inp-camp1-btn" name="txtNombre"
									style="grid-column: 2/4; width: 90%" placeholder="######">

							</div>
							<div class="campo-1-btn">
								<label class="col-form-label lab-camp1-btn">Apellido: </label> <input
									type="text" class="form-control inp-camp1-btn"
									name="txtApellido" style="grid-column: 2/4; width: 90%"
									placeholder="######">

							</div>
							<div class="campos-2">
								<label class="col-form-label">DNI </label> <input type="text"
									class="form-control" name="txtDNI" placeholder="######">
								<label class="col-form-label">Sexo </label>
								<div>
									<select class="form-control" name="cmbSexo">
										<option selected>....</option>
										<option>Masculino</option>
										<option>Femenino</option>
									</select>
								</div>
							</div>
							<div class="campos-2">
								<label class="col-form-label">Nacionaldad: </label> <input
									type="text" class="form-control" name="txtNacionalidad"
									placeholder="######"> <label class="col-form-label">Edad:
								</label> <input type="number" name="txtEdad" class="form-control"
									placeholder="######">
							</div>

							<div class="campo-1-btn">
								<label class="col-form-label lab-camp1-btn">Domicilio: </label>
								<input type="text" class="form-control inp-camp1-btn"
									name="txtDomicilio" style="grid-column: 2/4; width: 90%"
									placeholder="######">

							</div>
							<div class="campos-2">
								<label class="col-form-label">Estado: </label> <input
									type="text" class="form-control" name="txtEstado"
									placeholder="######"> <label class="col-form-label">Codigo
									Postal: </label> <input type="text" class="form-control"
									name="txtCodigoPos" placeholder="######">
							</div>
							<div class="campos-2">
								<label class="col-form-label">Pais: </label> <select
									class="form-control" name="cmbPais">
									<c:forEach items="${lstPais }" var="pa">
										<option value="${pa.id_Pais }">${pa.nombre }</option>
									</c:forEach>

								</select>

							</div>
						</div>
					</c:if>
					<div name="agregarPersona"></div>

					<button type="button" onclick="agregarPersona()"
						class="btn btn-primary">Agregar otro</button>

					<button type="submit" class="btn btn-primary" name="btnSiguiente"
						value="personas">Siguiente</button>
				</form>
			</div>
		</div>
	</div>
</body>

<script src="js/intranet-2.js"></script>
<script src="js/navVertical.js"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>


<script>
	<c:forEach var="pa" items="${lstPais}" >
	idPais.push("${pa.id_Pais}");
	nombrePais.push("${pa.nombre}");
	</c:forEach>
</script>
${mensajeError }
</html>