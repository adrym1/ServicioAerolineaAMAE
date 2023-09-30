<%@page import="model.ReporteDestino"%>
<%@page import="dao.DAOFactory"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reporte de Destinos</title>
<link rel="icon" href="img/logo/Logo-sinfondo.png">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="css/reporteDestinos.css">
</head>
<body>
<div id="general-content">
	<jsp:include page="navVertical.jsp"></jsp:include>
	<div id="right-content">
            <div id="right-adentro">
            <c:if test="${usu != null }">
            <div class="contenedor" style="width: 95%; margin: auto auto;">


				<h2 style="text-align: center; margin-top: 4rem">REPORTE DE DESTINOS</h2>		
			<br>
			
			<hr>
			<br>
		<section style="width: 95%; margin: auto auto;">
			<form action="destino" method="post" class="nom">
					<div class="col-md-4 mb-3">
	
							    <div class="col">
							      <label  for="inlineFormInputGroup" style="font-weight: bold; font-size: larger">País del Destino: </label>
							      <div class="input-group mb-2">
							        <div class="input-group-prepend">
							          <div class="colFormLabel"><button  type="submit" class="btn btn-primary" name="btnAccion" value="buscarDestino"><img src="img/reportes/lupa.png"></button></div>
							        </div>
							        <input type="text" style="margin-left: 10px" name="txtNombre" class="form-control" id="inlineFormInputGroup" >
							      </div>
							    </div>
	   				 </div>	
	   					 <br>
					<button  type="submit" name="btnAccion" class="btn btn-info" value="pdf" class="btn"><img src="img/reportes/pdf1.png"></button>	
				 		<br>
				  		<br>			 
				</form>
				<br><br>
					<table nonce="modelo" class="table table-hover">
						  <thead>
						    <tr>
						      <th scope="col">Codigo</th>
						      <th scope="col">Aeropuerto</th>
						      <th scope="col">Ciudad</th>
						      <th scope="col">Pais</th>
						    </tr>
						  </thead>
						  <tbody>
							<c:forEach items="${lstDestinos }" var="d">
								<tr>
									<th scope="row">${d.codigo }</th>
									<td>${d.aeropuerto }</td>
									<td>${d.ciudad }</td>
									<td>${d.pais }</td>				
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