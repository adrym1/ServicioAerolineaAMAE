<%@page import="model.Proveedor"%>
<%@page import="model.Cliente"%>
<%@page import="model.Pais"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.DAOFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Proveedor</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="css/Formulario.css">

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
		<form action="proveedor">
			<div class="titulo">
 

				<h1> Proveedor :</h1>

			</div>

			<div class="contenedor">
	
				<!-- CODIGO -->
				<div class="form-row" style="margin-top: 50px">
					<div class="form-group col-md-4">
						<label for="inputEmail4">Código de proveedor</label> 
						<input
							type="text" class="form-control" id="inputEmail4"
							placeholder="ingrese Código de proveedor" value="${p.cod_proveedor}"    name="txtCodigo">

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

					<div class="form-group col-md-9">
						<label for="text">Nombre de empresa </label> <input
							type="text" class="form-control" id="text"
							placeholder="ingrese nombre de empresa" value="${p.nombreEmpresa}" name="txtNombre">
					</div>
				</div>

				<div class="form-row">

					<div class="form-group col-md-9">
						<label for="text">Razón social</label> <input
							type="text" class="form-control" id="text"
							placeholder="ingrese razón social" value="${p.razonSocial}" name="txtRazonSocial">
					</div>
				</div>




				<!-- DIRECCION -->
				<div class="form-group">
					<label for="inputAddress">Dirección de empresa</label> 
					<input
						type="text" class="form-control" id="inputAddress"
						placeholder="1234 Main St" value="${p.direccion}" name="txtDireccion">
				</div>
				<!-- CORREO ELECTRONICO-->
				<div class="form-group">
					<label for="inputAddress">Correo electrónico </label> 
					<input
						type="email" class="form-control" id="inputAddress"
						placeholder="example xxxxx@gmail.com" value="${p.correo}" name="txtCorreo">
				</div>

				<!-- TIPO DE SERVICIO -->
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="inputState">Descripción de servicio</label> 
						<input	type="text" class="form-control" id="inputAddress"
						placeholder="ingrese descripción" value="${p.tipServicio_proveedor}" name="txtDescripcion">
						
					</div>
					
					<!-- PAIS DE RESIDENCIA /  -->
					<div class="form-group col-md-6">
						<label for="inputState">Pais de origen</label> 
						<select name="cboPais"
							id="inputState" class="form-control">
							<option selected>Seleccione...</option  >
                  <%
                  //forma 1 de ralizar el listado del combo 
                  					DAOFactory fabrica = DAOFactory.getDaoFactory(1);
                  					ArrayList<Pais> lstPaises = fabrica.getPaisDAO().listado();
                  					request.setAttribute("lstPaises", lstPaises);
                  %>
							<c:forEach items="${lstPaises }" var="pa">
								<c:if test="${pa.id_Pais == p.pais_proveedor}">
									<option value="${pa.id_Pais}" selected="selected">${pa.nombre}</option>
								</c:if>
								<c:if test="${pa.id_Pais != c.paisCli}">
									<option value="${pa.id_Pais}">${pa.nombre}</option>
								</c:if>
							</c:forEach>
                  
           


						</select>
					</div>
					
					


				</div>



				<div class="form-row">

					<!-- NUMERO DE CONTACTO -->
					<div class="form-group col-md-6">
						<label for="inputPassword4">Número de contacto</label> <input
							type="text" class="form-control" id="inputPassword4"
							placeholder="ingrese Nº de conctacto" value="${p.telefono}" name="txtTelefono">
					</div>
					<!-- FECHA -->
					<div class="form-group col-md-6">
						<label for="inputEmail4">Fecha de asociación</label> <input
							type="date" class="form-control" id="inputEmail4"
							placeholder="" value="${p.fechaAsociacion}" name="txtFecha" >
					</div>
				</div>









				<div class="botones" style="margin-top: 80px;">
					<button type="input" class="btn btn-registrar boton-formulario" name="btnAccion" value="registrar"> 
						<img src="img/iconos/icono registrar.svg" alt="">
						<p>Registrar</p>
					</button>
					<button type="input" class="btn btn-actualizar boton-formulario" name="btnAccion" value="actualizar">
						<img src="img/iconos/icono actualizar.svg" alt="">
						<p>Actualizar</p>
					</button>
					<button type="input" class="btn btn-eliminar boton-formulario" name="btnAccion" value="eliminar">
						<img src="img/iconos/icono eliminar.svg" alt="">
						<p>Desactivar</p>
					</button>
				</div>



			</div>










	


	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
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
						
							<thead >
							
								
    <tr >
      <th scope="col" style="width:10% ;">Código</th>
        <th scope="col" style="width:20% ;">Razón Social</th>
      <th scope="col" style="width:10% ;">Empresa</th>
      <th scope="col" style="width:15% ;">Télefono</th>
      <th scope="col" style="width:20% ;">Email</th>
      <th scope="col" style="width:10%  ;  ">Acciones</th>
     
    </tr>
  </thead>
  <tbody  >
  <%
  

						  fabrica = DAOFactory.getDaoFactory(1);
  						ArrayList<Proveedor> lstProveedor = fabrica.getProveedorDAO().listado();
  						request.getAttribute("lstProveedor");
  					
  						//recorre el listado
  						for (Proveedor p : lstProveedor) {
  							
  %>
  
								<tr>
									<td  style="text-align: center"><%=p.getCod_proveedor()%></td>
									<td> <%=p.getRazonSocial()%></td>
									<td style="text-align: center;"> <%=p.getNombreEmpresa()%></td>
									
									<td style="text-align: center;"><%=p.getTelefono()%></td>
							
									<td><%=p.getCorreo()%></td>
									
									<td style="text-align: center;">
									<form action="proveedor" method="post">
									<input name="codigo" type="hidden" value="<%= p.getCod_proveedor()%>">
							        <button name="btnAccion" value="buscar"  type="input">
												<img alt="" src="img/edit1.jpg"  class="editar">
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

	<div class="container">
		<input type="checkbox" id="btn-mas">
		<div class="redes">
			<a href="IntranetPrincipal.jsp" class=""> <img alt=""
				src="img/icono principal.png" style="width: 80%;">
			</a> <a href="#" class="fa fa-youtube"></a> <a href="#"
				class="fa fa-twitter"></a> <a href="#" class="fa fa-pinterest"></a>
		</div>
		<div class="btn-mas">
			<label for="btn-mas" class="fa fa-plus"></label>
		</div>
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