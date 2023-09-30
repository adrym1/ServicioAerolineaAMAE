<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buscar</title>
<!-- CSS only -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="css/listado.css">
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
	     <h1><strong> Mantenimiento Usuario </strong></h1>
	    </div> 
	    <div class="agregar">
	    <button type="button" class="btn btn-success" style="font-size:17pt  ; "> <a href="FormularioUsuario.jsp" style="text-decoration: none; color: white;"> Agregar Usuario </a><img src="img/iconos/icono agregar.svg" width="40px" alt=""></button>
		</div>
	    <div class="subtitulo">
	    <h2>Listado de Usuario</h2>
	    </div>
	  
	    <div class="tabla">
	    <table  class="table"  >
	  <thead class="thead-dark" style="text-align: center;  ">
	    <tr >
	     <th scope="col" style="width:10% ;">Código</th>
	      <th scope="col" style="width:20% ;">Usuario</th>
	      <th scope="col" style="width:15% ;">Clave</th>
	      <th scope="col" style="width:20% ;">Puesto</th>
	      <th scope="col" style="width:20% ;">Estado</th>
	      <th scope="col" style="width:10%  ;  ">Acciones</th>
	     
	    </tr>
	  </thead>
	  <tbody  >
	  <c:forEach items="${lstUsuario }" var="u">
								<tr style="text-align: center;">
									<th scope="row">${u.codigo }</th>
									<td>${u.usuario }</td>
									<td>${u.clave }</td>
									<td>${u.desc_tipo }</td>
									<td>${u.desc_estado }</td>
									<td>
										<form action="usuario" method="post" style="display: flex;">
									
										<input name="codigo" type="hidden" value="${u.codigo }">
								        <button name="btnAccion" value="formBuscar" type="input" class="btn btn-warning"><img src="img/iconos/icono actualizar.svg" alt="" width="30px"></button>
											
												
										
										<input name="txtCodigo" type="hidden" value="${u.codigo }">
								       <button name="btnAccion" value="eli" type="input" class="btn btn-danger"><img src="img/iconos/icono eliminar.svg" alt="" width="30px"></button>
										
											</form>
									</td>
									
								</tr>
						</c:forEach>
	
	
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

<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	${mensaje }
<script type="text/javascript">
	
</script>
</body>
</html>