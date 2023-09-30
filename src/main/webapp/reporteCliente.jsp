<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="dao.DAOFactory"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.ReporteCliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reporte de Clientes</title>
<link rel="icon" href="img/logo/Logo-sinfondo.png">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" >
<link rel="stylesheet" href="css/reporteCliente.css">
</head>
<body>
<div id="general-content">
	<jsp:include page="navVertical.jsp"></jsp:include>
	<div id="right-content">
            <div id="right-adentro">
            <c:if test="${usu != null }">
            <div class="contenedor" >

		<br><br>
		<div class="titulo">		
			<h2 class="h2">REPORTE DE CLIENTES</h2>		
		</div>
		<br>
		<br>
		<hr>
		<br>
		
		<section style="width: 100%;margin: auto auto;"  >
		
			<form action="cliente" method="post" >
				<div class="col-md-4 mb-3">
						    <div class="col">
						      <label  for="inlineFormInputGroup">Fecha de Asociacion: </label>					      
						      <div class="input-group mb-2">
						       	<div class="input-group-prepend">
						     		 <div class="colFormLabel"><button class="btn btn-primary"  type="submit" name="btnAccion" value="buscarFecha"><img src="img/reportes/lupa.png"></button></div>
						     	 </div>
						     	 <input style="margin-left: 5px" type="date" class="form-control" id="inlineFormInputGroup" name="Fecha1" placeholder="dd/mm/yyyy">
						      </div>
						    </div>
						    <br>
						    <div class="col">
						      <label  for="inlineFormInputGroup">Nombre del Cliente: </label>
						      <div class="input-group mb-2">
						        <div class="input-group-prepend">
						          <div class="colFormLabel"><button class="btn btn-primary"  type="submit" name="btnAccion" value="buscarCliente"><img src="img/reportes/lupa.png"></button></div>
						        </div>
						        <input style="margin-left: 5px" type="text" name="txtNombre" class="form-control" id="inlineFormInputGroup" >
						      </div>
						    </div>
   				 </div>
				<br>
				<button  type="submit" class="btn btn-info" name="btnAccion" value="pdf" class="btn"><img src="img/reportes/pdf1.png"></button>									 
			</form>
			
			<br><br>
				<table nonce="modelo" class="table table-hover">
					  <thead>
					    <tr>
					      <th scope="col">Codigo</th>
					      <th scope="col">Nombre</th>
					      <th scope="col">Correo</th>
					      <th scope="col">Documento</th>
					      <th scope="col">Num. Documento</th>
					      <th scope="col">Tipo</th>
					      <th scope="col">Fecha de Asociacion</th>
					    </tr>
					  </thead>
					  <tbody>
						<c:forEach items="${lstClientes }" var="c">
								<tr>
									<th scope="row">${c.codCli }</th>
									<td>${c.nombCli }</td>
									<td>${c.correoCli }</td>
									<td>${c.tipoDocCli }</td>
									<td>${c.numDocCli }</td>
									<td>${c.tipoClie }</td>
									<td>${c.fechaAso }</td>
								</tr>
						</c:forEach>
					  </tbody>
				</table>  
			<br><br>	
	</section>			
	</div>
	</c:if>
	<c:if test="${usu == null }">
		<jsp:include page="errorCuenta.jsp"></jsp:include>
	</c:if>
            </div>
      </div>
     </div>
	
</body>
</html>