<%@page import="dao.DAOFactory"%>
<%@page import="model.ReporteVuelo"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reporte de Vuelos</title>
<link rel="icon" href="img/logo/Logo-sinfondo.png">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" >
<link rel="stylesheet" href="css/reporteVuelo.css">
</head>
<body>
<div id="general-content">
	<jsp:include page="navVertical.jsp"></jsp:include>
	<div id="right-content">
            <div id="right-adentro">
            <c:if test="${usu != null }">
            <div class="contenedor">
		
			<img align="left" class="logo" src="img/logo_blanco.png">
			<br><br>
			<div class="titulo">		
				<h2>REPORTE DE VUELOS</h2>		
			</div>
			<br>
			<br>
			<hr>
			<br>
					<section style="width: 90%;margin: auto auto;">
						<form action="vuelocontrol" method="post" class="nom">
							<div class="col-md-4 mb-3">
									    <div class="col-auto">
									      <label  for="inlineFormInput">Fecha de Salida: </label>
									      <input type="date" name="Fecha1" class="form-control mb-2" id="inlineFormInput" placeholder="dd/mm/yyyy">
									    </div>
									    <br><button  type="submit" name="btnAccion" value="FiltrarVuelos" style="float: right;position: relative; left: 78px;"><img src="img/reportes/lupa.png"></button>
									   <div class="col-auto">
									      <label  for="inlineFormInput">Fecha de Llegada: </label>
									      <input type="date" name="Fecha2" class="form-control mb-2" id="inlineFormInput" placeholder="dd/mm/yyyy">
				     
									    </div>					
			   				 </div>
								<br>
									<button  type="submit" name="btnAccion" value="pdf" class="btn btn-info" ><img src="img/reportes/pdf1.png"></button>
								<br><br>						 
						</form>						
						<br><br>
							<table nonce="modelo" class="table table-hover">
								  <thead>
								    <tr>
								      <th scope="col">Codigo</th>
								      <th scope="col">Piloto</th>
								      <th scope="col">Copiloto</th>
								      <th scope="col">Precio</th>
								      <th scope="col">Hora</th>
								      <th scope="col">Fecha de Salida</th>
								      <th scope="col">Fecha de Llegada</th>
								    </tr>
								  </thead>
								  <tbody>
									<fmt:setLocale value="en_US"/>
										<c:forEach items="${lstVuelos }" var="v">
											<tr>
												<th scope="row">${v.codigo }</th>
												<td>${v.piloto }</td>
												<td>${v.copiloto }</td>
												<td><fmt:formatNumber type="currency" value="${v.precio }" ></fmt:formatNumber></td>
												<td>${v.hora }</td>
												<td>${v.fecha_Salida }</td>
												<td>${v.fecha_Llegada }</td>
											</tr>
										</c:forEach>
								  </tbody>
							</table>  
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