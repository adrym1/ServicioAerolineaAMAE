<%@page import="model.Promocion"%>
<%@page import="model.TipoCliente"%>
<%@page import="model.TipoDocumento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.DAOFactory"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MANTENIMIENTO PROMOCIÓN</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/Formulario.css">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="css/Botones.css">
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
				<div class="formularios">
						<form action="promocion" method="post">
							<div class="titulo">
								<h1>FORMULARIO DE PROMOCIÓN</h1>
							</div>

							<div class="contenedor">
								<!-- CODIGO -->
								<div class="form-row" style="margin-top: 50px">
									<div class="form-group col-md-4">
										<label for="tex">Código </label> <input type="text"
											class="form-control" id="tex"
											placeholder="ingrese código de promoción" name="txtCodigo"
											value="${p.cod_promocion}">

									</div>
									<div class="form-group col-md-2">
										<button type="button" class="btn btn-primary"
											data-toggle="modal" data-target="#exampleModal"
											data-whatever="@mdo" name="btnAccion" value="listar"
											style="margin-top: 25px; background: none; width: 35%; height: 65%; border: 0px;">
											<img src="img/iconos/icono buscar.svg" alt=""
												style="margin-left: -5px; width: 150%;">
										</button>


									</div>
								</div>
								<!-- NOMBRE /APELLIDO -->
								<div class="form-row">
									<div class="form-group col-md-6">
										<label for="text">Clave </label> <input type="text"
											class="form-control" id="text"
											placeholder="ingrese clave de promoción" name="txtClave"
											value="${p.clave_promocion}">
									</div>
								</div>
								<!-- CORREO ELECTRONICO -->
								<div class="form-row">
									<div class="form-group col-md-7">
										<label for="text">Titúlo </label> <input type="text"
											class="form-control" id="text" placeholder="ingrese titúlo"
											name="txtTitulo" value="${p.titulo_promocion}">
									</div>
								</div>
								<div class="form-row">
									<div class="form-group col-md-7">
										<label for="text">Descripción </label> <input
											style="height: 50px; width: 170%" type="text"
											class="form-control" id="text"
											placeholder="ingrese descripción" name="txtDescripcion"
											value="${p.descripcion}">
									</div>
								</div>
								
							<!-- FECHAS  -->
								<br>
								<div class="form-row">
									<div class="form-group col-md-6">
										<label for="text">Valido desde </label> <input type="date"
											class="form-control" id="inputEmail4" placeholder=""
											name="fechaValido" value="${p.fechaValida}">
									</div>
									<div class="form-group col-md-6">
										<label for="inputEmail4"> Valido hasta </label> <input
											type="date" class="form-control" id="inputEmail4"
											placeholder="" name="fechaCaducidad"
											value="${p.fechaCaducidad}">
									</div>
								</div>
								<!-- DESCUENTO -->
								<div class="form-row">
									<div class="form-group col-md-6">
										<label for="text">Descuento</label> <input type="text"
											class="form-control" id="text" placeholder="##%"
											name="txtDescuento" value="${p.descuento}">
									</div>
								</div>
								<div class="form-row">
									<!-- TIPO DE CLIENTE -->
									<div class="form-group col-md-6">
										<label for="inputState">Tipo de cliente</label> <select
											id="inputState" class="form-control" name="cboTipoCliente">
											<option selected>Seleccione...</option>
											<%
											//forma 1 de ralizar el listado del combo 
											DAOFactory fabrica = DAOFactory.getDaoFactory(1);
											ArrayList<TipoCliente> lstTipoCliente = fabrica.getClienteDAO().listadoTipoCliente();
											request.setAttribute("lstTipoCliente", lstTipoCliente);
											%>
											<c:forEach items="${lstTipoCliente }" var="t">
												<c:if test="${t.idTipoCliente == p.getTipoCliente()}">
													<option value="${t.idTipoCliente}" selected="selected">${t.descripcion}</option>
												</c:if>
												<c:if test="${t.idTipoCliente != p.getTipoCliente()}">
													<option value="${t.idTipoCliente}">${t.descripcion}</option>
												</c:if>
											</c:forEach>
										</select>
									</div>
								</div>

								<div class="botones" style="margin-top: 70px;">
									<button type="input" class="btn btn-registrar boton-formulario"
										name="btnAccion" value="registrar">
										<img src="img/iconos/icono registrar.svg" alt="">
										<p>Registrar</p>
									</button>
									<button type="input"
										class="btn btn-actualizar boton-formulario" name="btnAccion"
										value="actualizar">
										<img src="img/iconos/icono actualizar.svg" alt="">
										<p>Actualizar</p>
									</button>
									
								</div>
							</div>

							<div class="modal fade" id="exampleModal" tabindex="-1"
								role="dialog" aria-labelledby="exampleModalLabel"
								aria-hidden="true">
								<div class="modal-dialog" role="document">
									<div class="modal-content"
										style="width: 125vh; background: white;">
										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalLabel">CLIENTES</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body">

											<table class="table table-dark">
												<thead>
													<tr>
													<th scope="col">Codigo</th>
														<th scope="col">Clave</th>
													
														<th scope="col">Fecha Activación</th>
														<th scope="col">Fecha Caducidad</th>
														<th scope="col">Descuento</th>



													</tr>
												</thead>
												<tbody>
													<%
													fabrica = DAOFactory.getDaoFactory(1);
													ArrayList<Promocion> lstPromocion = fabrica.getPromocionDAO().listado();
													request.getAttribute("lstPromocion");
													//recorre el listado
													for (Promocion pr : lstPromocion) {
													%>
													<tr>
													<td><%=pr.getCod_promocion()%></td>
														<td><%=pr.getClave_promocion()%></td>
														

														<td><%=pr.getFechaValida()%></td>

														<td><%=pr.getFechaCaducidad()%></td>

														<td><%=pr.getDescuento()%></td>

														<td>
															<form action="promocion" method="post">

																<input name="codigo" type="hidden"
																	value="<%=pr.getCod_promocion()%>">
																<button name="btnAccion" value="buscar" type="input">
																	<img alt="" src="img/edit1.png" class="editar">
																</button>

															</form>
														</td>

													</tr>
													<%
													}
													%>

												</tbody>
											</table>

										</div>
										<div class="modal-footer" style="margin-right: 34%;">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Close</button>

										</div>
									</div>
								</div>

							</div>



						</form>
					</div>

					
				</c:if>
				
				<c:if test="${usu == null }">
					<jsp:include page="errorCuenta.jsp"></jsp:include>
				</c:if>
			</div>
		</div>
	</div>




	<div class="container">
		<input type="checkbox" id="btn-mas">
		<div class="redes">
			<a href="IntranetPrincipal.jsp" class=""> <img alt=""
				src="img/icono principal.png" style="width: 80%;">
			</a> <a href="MantenimientoCliente.jsp" class=""> <img
				src="img/iconos/icono regresar.svg" width="70px" alt="">
			</a>
		</div>
		<div class="btn-mas">
			<label for="btn-mas" class="fa fa-plus"></label>
		</div>
	</div>

</body>
<script src="../js/Tiempo.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
</html>