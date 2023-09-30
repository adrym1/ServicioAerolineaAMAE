<%@page import="model.Vuelo"%>
<%@page import="dao.DAOFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <link rel="stylesheet" href="css/Mantenimiento.css">
  <!--Icon-Font-->
<script src="https://kit.fontawesome.com/eb496ab1a0.js"
	crossorigin="anonymous"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body>
<div id="general-content">
	<jsp:include page="navVertical.jsp"></jsp:include>
	<div id="right-content">
            <div id="right-adentro">

<c:if test="${usu != null }">


	
	  <div class="contenedor">
	
	
	
	
		<div class="container">
	     <div class="titulo" >  
	     <h1><strong> Mantenimiento Vuelo </strong></h1>
	    </div> 
	    <div class="agregar">
	    <button type="button" class="btn btn-success" style="font-size:17pt  ; "> <a href="FormularioVuelo.jsp" style="text-decoration: none; color: white;"> Agregar Vuelo </a><img src="img/iconos/icono agregar.svg" width="40px" alt=""></button>
		</div>
	    <div class="subtitulo">
	    <h2>Listado de Vuelos</h2>
	    </div>
	  
	    <div class="tabla">
	    <table  class="table"  >
	  <thead class="thead-dark" style="text-align: center;  ">
	    <tr >
	      <th scope="col" style="width:10% ;">Codigo</th>
	      <th scope="col" style="width:10% ;">Cod. Avion</th>
	      <th scope="col" style="width:10% ;">Precio</th>
	      <th scope="col" style="width:10% ;">Hora</th>
	      <th scope="col" style="width:10% ;">Fecha de Salida</th>
	      <th scope="col" style="width:10% ;">Fecha de Llegada</th>
	       <th scope="col" style="width:10% ;">Estado</th>
	      <th scope="col" style="width:10%  ;  ">Acciones</th>
	     
	    </tr>
	  </thead>
	  <tbody  >
	  <%
	  
	
	  						DAOFactory  fabrica = DAOFactory.getDaoFactory(1);
	  						ArrayList<Vuelo> lstVuelos = fabrica.getVueloDAO().listadoVuelo();
	  						request.getAttribute("lstVuelos");
	  						//recorre el listado
	  						for (Vuelo v : lstVuelos) {
	  %>
									<tr style="text-align: center;">
										<th  style="text-align: center"><%=v.getCodVuelo()%></th>
										<td> <%=v.getCodAvion()%></td>									
										<td>
												<fmt:setLocale value="en_US"/>
												<fmt:formatNumber type="currency" value="<%= v.getPrecioVuelo()%>"></fmt:formatNumber>
										</td>								
										<td><%=v.getHoraVuelo()%></td>	
										<td><%=v.getFechaSalida()%></td>	
										<td><%=v.getFechaLlegada()%></td>	
										<td><%=v.getEstado()%></td>						
										<td style="text-align: center;">
										<form action="vuelocontrol" method="post">										
										<input name="codigo" type="hidden" value="<%= v.getCodVuelo()%>">
								        <button name="btnAccion" value="buscar" type="submit" class="btn btn-warning"><img src="img/iconos/icono actualizar.svg" alt="" width="25px"></button>
													
										<input name="codigo" type="hidden" value="<%=v.getCodVuelo()%>">
								       <button name="btnAccion" value="eliminar"  type="submit" class="btn btn-danger"><img src="img/iconos/icono eliminar.svg" alt="" width="25px"></button>
											
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