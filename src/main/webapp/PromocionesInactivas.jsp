<%@page import="model.Promocion"%>
<%@page import="model.Cliente"%>
<%@page import="dao.DAOFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Promociones Inactivas</title>
    <link rel="icon" href="img/logo/Logo-sinfondo.png">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/Mantenimiento.css">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<!--Icon-Font-->
<script src="https://kit.fontawesome.com/eb496ab1a0.js"
	crossorigin="anonymous"></script>

</head>
<body>
	<div id="general-content">
		<jsp:include page="navVertical.jsp"></jsp:include>
		<div id="right-content">
			<div id="right-adentro">

			<c:if test="${usu != null }">
			
			
				<div class="contenedor">




					<div class="container">
						<div class="titulo">
							<h1>
								<strong> Mantenimiento Promocion </strong>
							</h1>
						</div>





						<div class="subtitulo">
							<h2>Listado de Promociones Inactivas</h2>
						</div>

						<div class="tabla">
							<table class="table">
								<thead class="thead-dark" style="text-align: center;">
									<tr>
										<th scope="col" style="width: 5%;">Nº</th>
										<th scope="col" style="width: 10%;">Clave</th>
										<th scope="col" style="width: 20%;">Titulo</th>

										<th scope="col" style="width: 15%;">Fecha Activación</th>
										<th scope="col" style="width: 15%;">Fecha Caducidad</th>
										<th scope="col" style="width: 20%;">Descuento</th>
										<th scope="col" style="width: 10%;">Acciones</th>

									</tr>
								</thead>
								<tbody>
									<%
									DAOFactory fabrica = DAOFactory.getDaoFactory(1);
									ArrayList<Promocion> lstPromocion = fabrica.getPromocionDAO().listadoPromocionInactivos();
									request.getAttribute("lstPromocion");
									//recorre el listado
									for (Promocion pr : lstPromocion) {
									%>
									<tr>
										<td style="text-align: center"><%=pr.getCod_promocion()%></td>

										<td style="text-align: center"><%=pr.getClave_promocion()%></td>
										<td><%=pr.getTitulo_promocion()%></td>

										<td style="text-align: center;"><%=pr.getFechaValida()%></td>

										<td style="text-align: center;"><%=pr.getFechaCaducidad()%></td>

										<td style="text-align: center;"><%=pr.getDescuento()%></td>
										<td style="text-align: center;">
											<form action="promocion" method="post">

												<input name="codigo" type="hidden"
													value="<%=pr.getCod_promocion()%>">
												<button name="btnAccion" value="buscarPromocionInactiva"
													type="input" class="btn btn-warning">
													<img src="img/iconos/icono actualizar.svg" alt=""
														width="30px">
												</button>

												<input name="txtCodigo" type="hidden"
													value="<%=pr.getCod_promocion()%>">

												<div class="agregar"></div>
											</form>
										</td>

									</tr>
									<%
									}
									%>

									<!-- 
<button type="button" class="btn btn-warning"><img src="img/iconos/icono actualizar.svg" alt="" width="30px"></button>
<button type="button" class="btn btn-danger"><img src="img/iconos/icono eliminar.svg" alt="" width="30px"></button>

 -->

								</tbody>
							</table>

							<div class="agregar">
								<button type="button" class="btn btn-success"
									style="font-size: 17pt;">
									<a href="MantenimientoPromocion.jsp"
										style="text-decoration: none; color: white;"> Regresar </a><img
										src="img/iconos/icono regresar.svg" width="40px" alt="">
								</button>


							</div>

						</div>


					</div>

				</div>
			
			</c:if>
			<c:if test="${usu == null }">
					<jsp:include page="errorCuenta.jsp"></jsp:include>
				</c:if>
			</div>
		</div>
	</div>


	${mensaje }
</body>
</html>