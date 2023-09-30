<%@page import="dao.DAOFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.*"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MANTENIMIENTO VUELO</title>


<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="css/Formulario.css">
<link rel="stylesheet" href="css/Botones.css">

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<!--Icon-Font-->
<script src="https://kit.fontawesome.com/eb496ab1a0.js"
	></script>

</head>


<body>
<div id="general-content">
	<jsp:include page="navVertical.jsp"></jsp:include>
	<div id="right-content">
            <div id="right-adentro">
<c:if test="${usu != null }">
	<div class="formularios">
	
		<form action="vuelocontrol" method="post" >
		
			<div class="titulo">

				<h1>Vuelo : 	</h1> 

			</div>

			<div class="contenedor">
				<!-- CODIGO -->
				<div class="form-row">
					<div class="form-group col-md-4">
						<label for="formGroupExampleInput">Nro de Vuelo :</label> <input
							type="text" class="form-control" id="formGroupExampleInput"
							placeholder="ingrese código" 
							name ="txtCodigo"  value="${vu.codVuelo}">

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

				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="formGroupExampleInput">Matrícula de Avión : </label> <input type="text"
							class="form-control" id="formGroupExampleInput" 
							name ="txtAvion"  value="${vu.codAvion}">
					</div>
					<div class="form-group col-md-6">
						<label for="formGroupExampleInput">Piloto :</label> <input type="text"
							class="form-control" id="formGroupExampleInput" 
								name ="txtPiloto"  value="${vu.piloto}">
					</div>
				</div>
				<div class="form-group">
					<label for="formGroupExampleInput">Copiloto :</label> <input
						type="text" class="form-control" id="formGroupExampleInput"				
							name ="txtCopiloto"  value="${vu.copiloto}">
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="inputState">De : </label> 
						<select name="cboDe"
							id="inputState" class="form-control">
							<option selected>Seleccione...</option>
                  <%
                  					DAOFactory fabrica = DAOFactory.getDaoFactory(1);
                  					ArrayList<tipoDestino> lstTipoDestino = fabrica.getDestinoDAO().listarTipoDestinos();
                  					request.setAttribute("lstTipoDestino", lstTipoDestino);
                  %>
							<c:forEach items="${lstTipoDestino }" var="d">
								<c:if test="${d.cod_destino == vu.codDesSalida}">
									<option value="${d.cod_destino}" selected="selected">${d.desc_destino}</option>
								</c:if>
								<c:if test="${d.cod_destino != vu.codDesSalida}">
									<option value="${d.cod_destino}">${d.desc_destino}</option>
								</c:if>
							</c:forEach>
					</select>
					</div>
					<div class="form-group col-md-6">
						<label for="inputState">A : </label> 
						<select name="cboA"
							id="inputState" class="form-control">
							<option selected>Seleccione...</option>
                  <%
                    fabrica = DAOFactory.getDaoFactory(1);
					lstTipoDestino = fabrica.getDestinoDAO().listarTipoDestinos();
					request.setAttribute("lstTipoDestino", lstTipoDestino);
                  %>
							<c:forEach items="${lstTipoDestino }" var="d">
								<c:if test="${d.cod_destino == vu.codDesLlegada}">
									<option value="${d.cod_destino}" selected="selected">${d.desc_destino}</option>
								</c:if>
								<c:if test="${d.cod_destino != vu.codDesLlegada}">
									<option value="${d.cod_destino}">${d.desc_destino}</option>
								</c:if>
							</c:forEach>
					</select>
					</div>
				</div>
				<div class="form-group">
					<label for="inputAddress">Precio : </label> <input
						type="text" class="form-control" id="inputAddress"						
						name ="txtPrecio"  value="${vu.precioVuelo}">
				</div>

				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="formGroupExampleInput">Hora de Vuelo : </label> <input type="time"
							class="form-control" id="formGroupExampleInput" placeholder="00:00"
							name ="txtHora"  value="${vu.horaVuelo}"
							>
					</div>
					<div class="form-group col-md-6">
						<label for="inputPassword4">Fecha de salida :</label> <input
							type="date" class="form-control" id=""
							placeholder="yyyy-mm-dd"
							name ="txtSalida"  value="${vu.fechaSalida}">
					</div>
					<div class="form-group col-md-6">
						<label for="inputPassword4">Fecha de llegada :</label> <input
							type="date" class="form-control" id=""
							placeholder="yyyy-mm-dd"
							name ="txtLLegada"  value="${vu.fechaLlegada}">
					</div>
				</div>
				<div class="botones">
					<button type="submit" class="btn btn-registrar boton-formulario" name="btnAccion" value="registrar"> 
						<img src="img/iconos/icono registrar.svg" alt="">
						<p>Registrar</p>
					</button>
					<button type="submit" class="btn btn-actualizar boton-formulario" name="btnAccion" value="actualizar">
						<img src="img/iconos/icono actualizar.svg" alt="">
						<p>Actualizar</p>
					</button>
					
				</div>
	</div>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content"
				style="width: 125vh; background: white; ">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Vuelo</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				
				<div class="modal-body">
				
						<table class="table table-dark">
							<thead >
								<tr>
									<th scope="col" style="width:10% ;">cod_vuelo</th>
								      <th scope="col" style="width:20% ;">cod_avion</th>
								      <th scope="col" style="width:20% ;">precio_vuelo</th>
								      <th scope="col" style="width:20% ;">hora_vuelo</th>
								      <th scope="col" style="width:20% ;">fechaSalida_vuelo</th>
								      <th scope="col" style="width:20% ;">fechaLlegada_vuelo</th>
									<th scope="col">Editar</th>
								</tr>
							</thead>
							<tbody>
								<%
		  						fabrica = DAOFactory.getDaoFactory(1);
		  						ArrayList<Vuelo> lstVuelos = fabrica.getVueloDAO().listadoVuelo();
		  						request.getAttribute("lstVuelos");
		  						//recorre el listado
		  						for (Vuelo v : lstVuelos) {	
								%>
								<tr>
									<th  style="text-align: center"><%=v.getCodVuelo()%></th>
										<td> <%=v.getCodAvion()%></td>									
										<td>
												<fmt:setLocale value="es_PE"/>
												<fmt:formatNumber type="currency" value="<%= v.getPrecioVuelo()%>"></fmt:formatNumber>
										</td>								
										<td><%=v.getHoraVuelo()%></td>	
										<td><%=v.getFechaSalida()%></td>	
										<td><%=v.getFechaLlegada()%></td>	
									<td>
									<form action="cliente" method="post">
									
									<input name="codigo" type="hidden" value="<%=v.getCodVuelo()%>">
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







<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
	

</html>