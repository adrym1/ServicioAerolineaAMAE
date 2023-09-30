<%@page import="dao.DAOFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.*"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario de Cliente</title>
<link rel="icon" href="img/logo/Logo-sinfondo.png">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	
	
	crossorigin="anonymous">
<link rel="stylesheet" href="css/Formulario.css">
<link rel="stylesheet" href="css/Botones.css">

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
	<div class="formularios">
	
		<form action="cliente" method="post" >
		
			<div class="titulo">



				<h1>FORMULARIO DE CLIENTE 	</h1> 
		
			    

			</div>

			<div class="contenedor">
				<!-- CODIGO -->
				<div class="form-row">
					<div class="form-group col-md-4">
						<label for="inputEmail4">Código de cliente</label> <input
							type="text" class="form-control" id="inputEmail4"
							placeholder="ingrese código" 
							name ="txtCodigo"  value="${c.codCli}">




					</div>
					
					<div class="form-group col-md-2">
						<button type="button" class="btn btn-primary" data-toggle="modal"
							data-target="#exampleModal" data-whatever="@mdo" name="btnAccion"
							value="listar"
							style="margin-top: 25px; background: none; width: 35%; height: 65%; border: 0px;">
							<img src="img/iconos/icono buscar.svg" alt=""
								style="margin-left: -5px; width: 150%;">
						</button>



					</div>
					
					
					
					
				</div>




				<!-- NOMBRE /APELLIDO -->
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="inputEmail4">Nombre</label> <input type="text"
							class="form-control" id="inputEmail4" placeholder="ingrese nombre"
							name ="txtNombre"  value="${c.nombCli}">
					</div>
					<div class="form-group col-md-6">
						<label for="inputPassword4">Apellido</label> <input type="text"
							class="form-control" id="inputPassword4" placeholder="ingrese apellido"
								name ="txtApellido"  value="${c.apeCli}">
					</div>
				</div>
				<!-- CORREO ELECTRONICO -->
				<div class="form-group">
					<label for="inputAddress">Córreo Electronico</label> <input
						type="email" class="form-control" id="inputAddress"
						placeholder="ingrese correo"
							name ="txtCorreo"  value="${c.correoCli}">
				</div>
				<!-- NACIONALIDAD -->
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="inputState">Nacionalidad</label> <input
						type="text" class="form-control" id="inputAddress"
						placeholder="ingrese nacionalidad"
							name ="txtNacionalidad"  value="${c.nacionalCli}">
					</div>
					<!-- PAIS DE RESIDENCIA /  -->
					<div class="form-group col-md-6">
						<label for="inputState">Pais de residencia</label> 
						<select name="cboPais"
							id="inputState" class="form-control">
							<option selected>Seleccione...</option>
                  <%
                  //forma 1 de ralizar el listado del combo 
                  					DAOFactory fabrica = DAOFactory.getDaoFactory(1);
                  					ArrayList<Pais> lstPaises = fabrica.getPaisDAO().listado();
                  					request.setAttribute("lstPaises", lstPaises);
                  %>
							<c:forEach items="${lstPaises }" var="p">
								<c:if test="${p.id_Pais == c.paisCli}">
									<option value="${p.id_Pais}" selected="selected">${p.nombre}</option>
								</c:if>
								<c:if test="${p.id_Pais != c.paisCli}">
									<option value="${p.id_Pais}">${p.nombre}</option>
								</c:if>
							</c:forEach>
                  
           


						</select>
					</div>
				</div>
				<!-- DIRECCION DE RESIDENCIA -->
				<div class="form-group">
					<label for="inputAddress">Dirección de residencia</label> <input
						type="text" class="form-control" id="inputAddress"
						placeholder="1234 Main St"
						name ="txtDireccion"  value="${c.direCli}">
				</div>

				<!-- CODIGO POSTAL -->
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="inputEmail4">Código Postal</label> <input type="text"
							class="form-control" id="inputEmail4" placeholder="ingrese codigo postal"
							name ="txtCodigoPostal"  value="${c.codPostalCli}"
							>
					</div>
					<!-- NUMERO DE CONTACTO -->
					<div class="form-group col-md-6">
						<label for="inputPassword4">Número de contacto</label> <input
							type="text" class="form-control" id=""
							placeholder="ingrese Nº de celular o Teléfono"
							name ="txtNumero"  value="${c.telefCli}">
					</div>
				</div>
				<!-- TIPO DOCUMENTO  -->
				<div class="form-row">

					<div class="form-group col-md-6">
						<label for="inputState">Tipo de documento de identidad</label>
						 <select name="cboTipoDoc"
						id="inputState" class="form-control">
							<option selected>Seleccione...</option>
                  <%
                  //forma 1 de ralizar el listado del combo 
                  					fabrica = DAOFactory.getDaoFactory(1);
                  					ArrayList<TipoDocumento> lstDocumentos = fabrica.getClienteDAO().listadoTipoDocumento();
                  					request.setAttribute("lstDocumentos", lstDocumentos);
                  %>
							<c:forEach items="${lstDocumentos }" var="t">
								<c:if test="${t.idTipo == c.tipoDocCli}">
									<option value="${t.idTipo}" selected="selected">${t.descrip}</option>
								</c:if>
								<c:if test="${t.idTipo != c.tipoDocCli}">
									<option value="${t.idTipo}">${t.descrip}</option>
								</c:if>
							</c:forEach>
                  
						</select>
					</div>



					<!-- NUMERO DE DOC -->
					<div class="form-group col-md-6">
						<label for="inputPassword4">Número de documento</label> <input
							type="text" class="form-control" id="inputPassword4"
							placeholder="ingres Nº de documento"
							name ="txtNumDoc"  value="${c.numDocCli}">
					</div>
				</div>

				<!-- SEXO DEL CLIENTE -->
				<div class="form-row">
						<div class="form-group col-md-6">
						<label for="inputState">Genero de cliente</label> 
						<select
							id="inputState" class="form-control" name="cboGenero">
							<option selected>Seleccione...</option>


							<%
							//forma 1 de ralizar el listado del combo 
												 fabrica = DAOFactory.getDaoFactory(1);
												ArrayList<GeneroCliente> lstGenero = fabrica.getClienteDAO().listadoGenero();
												request.setAttribute("lstGenero", lstGenero);
							%>
							<c:forEach items="${lstGenero }" var="g">
								<c:if test="${g.idGenero == c.sexoCli}">
									<option value="${g.idGenero}" selected="selected">${g.descrip}</option>
								</c:if>
								<c:if test="${g.idGenero != c.sexoCli}">
									<option value="${g.idGenero}">${g.descrip}</option>
								</c:if>
							</c:forEach>


						</select>
					</div>
					
					<!-- TIPO DE CLIENTE -->
					<div class="form-group col-md-6">
						<label for="inputState">Tipo de cliente</label> <select
							id="inputState" class="form-control" name="cboTipoCliente">
							<option selected>Seleccione...</option>


							<%
							//forma 1 de ralizar el listado del combo 
												fabrica = DAOFactory.getDaoFactory(1);
												ArrayList<TipoCliente> lstTipoCliente = fabrica.getClienteDAO().listadoTipoCliente();
												request.setAttribute("lstTipoCliente", lstTipoCliente);
							%>
							<c:forEach items="${lstTipoCliente }" var="t">
								<c:if test="${t.idTipoCliente == c.getTipoClie()}">
									<option value="${t.idTipoCliente}" selected="selected">${t.descripcion}</option>
								</c:if>
								<c:if test="${t.idTipoCliente != c.getTipoClie()}">
									<option value="${t.idTipoCliente}">${t.descripcion}</option>
								</c:if>
							</c:forEach>


						</select>
					</div>
				</div>


				<!-- CODIGO -->
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="inputEmail4">Fecha de asociación</label> <input
							type="date" class="form-control" id="inputEmail4"
							name ="txtFecha"  value="${c.fechaAso}">
					</div>
				</div>

				<div class="botones">
					<button type="input" class="btn btn-registrar boton-formulario" name="btnAccion" value="registrar"> 
						<img src="img/iconos/icono registrar.svg" alt="">
						<p>Registrar</p>
					</button>
					<button type="input" class="btn btn-actualizar boton-formulario " name="btnAccion" value="actualizar">
						<img src="img/iconos/icono actualizar.svg" alt="">
						<p>Actualizar</p>
					</button>
					
					<div class="agregar">
    
	
	
	</div>		
		
				</div>

			</div>



		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content"
				style="width: 125vh;; background: white;">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">CLIENTES</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
				
						<table class="table table-dark">
							<thead >
								<tr>
									<th scope="col">Codigo</th>
									<th scope="col">Cliente</th>
                                     <th scope="col">Nacionalidad</th>
									<th scope="col">Télefono</th>
									  <th scope="col">Nº documento </th>
									<th scope="col">Correó electronico</th>
								
									<th scope="col">Editar</th>


								</tr>
							</thead>
							<tbody>
								<%
								

								fabrica = DAOFactory.getDaoFactory(1);
														ArrayList<Cliente> lstCliente = fabrica.getClienteDAO().listado();
														request.getAttribute("lstCliente");
														//recorre el listado
														for (Cliente cl : lstCliente) {
								%>
								<tr>
									<td><%=cl.getCodCli()%></td>
									<td><%=cl.getNombCli() + " " + cl.getApeCli()%></td>
									<td><%=cl.getNacionalCli()%></td>
									<td><%=cl.getTelefCli()%></td>
									<td><%=cl.getNumDocCli()%></td>
									<td><%=cl.getCorreoCli()%></td>
									
									<td>
									<form action="cliente" method="post">
									
									<input name="codigo" type="hidden" value="<%= cl.getCodCli()%>">
							        <button name="btnAccion" value="buscar"  type="input">
												<img alt="" src="img/edit1.png"  class="editar">
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
		</form>
	</div>
	</c:if>
	<c:if test="${usu == null }">
					<jsp:include page="errorCuenta.jsp"></jsp:include>
	</c:if>
</div>

</div>
</div>
	
<br>
${mensaje }
<br>

</body>







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