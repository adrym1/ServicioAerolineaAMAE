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


  <div class="contenedor">




	<div class="container">
     <div class="titulo" >  
     <h1><strong> Mantenimiento Clientes </strong></h1>
    </div> 
    
    <div class="subtitulo">
    <h2>Listado de Clientes inactivos</h2>
    </div>
  
    <div class="tabla">
    <table  class="table"  >
  <thead class="thead-dark" style="text-align: center;  ">
    <tr >
      <th scope="col" style="width:10% ;">Código</th>
      <th scope="col" style="width:20% ;">Cliente</th>
      <th scope="col" style="width:15% ;">Télefono</th>
      <th scope="col" style="width:20% ;">Email</th>
      <th scope="col" style="width:10%  ;  ">Acciones</th>
     
    </tr>
  </thead>
  <tbody  >
  <%
  

  						DAOFactory fabrica = DAOFactory.getDaoFactory(1);
  						ArrayList<Cliente> lstCliente = fabrica.getClienteDAO().listadoClientesInactivos();
  						request.getAttribute("lstCliente");
  						//recorre el listado
  						for (Cliente cl : lstCliente) {
  %>
								<tr>
									<td  style="text-align: center"><%=cl.getCodCli()%></td>
									<td> <%=cl.getNombCli() + " " + cl.getApeCli()%></td>
									
									<td style="text-align: center;"><%=cl.getTelefCli()%></td>
							
									<td><%=cl.getCorreoCli()%></td>
									
									<td style="text-align: center;">
									<form action="cliente" method="post">
									
									<input name="codigo" type="hidden" value="<%= cl.getCodCli()%>">
							        <button name="btnAccion" value="activar" type="input" class="btn btn-warning"><img src="img/iconos/icono actualizar.svg" alt="" width="30px"></button>
										
											
							
										
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
    <button type="button" class="btn btn-success" style="font-size:17pt  ; "> <a href="MantenimientoCliente.jsp" style="text-decoration: none; color: white;"> Regresar </a><img src="img/iconos/icono regresar.svg" width="40px" alt=""></button>
	
	
	</div>			
				


			

</div>


	</div>

</div>
${mensaje }

</body>
</html>