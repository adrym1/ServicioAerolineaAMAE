<%@page import="org.apache.jasper.tagplugins.jstl.core.Out"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.DAOFactory"%>

<%@page import="model.Vuelo"%>
<%@page import="model.Destino"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ventas - Vuelo</title>
<link rel="icon" href="img/logo/Logo-sinfondo.png">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="css/navVertical.css">
<link rel="stylesheet" href="css/enzo2.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
</head>


<body>

	<div id="general-content">
		<jsp:include page="navVertical.jsp"></jsp:include>
		<div id="right-content">
			<div class="quitar buscar-flotante-0">
				<div class="buscar-vuelo-0 quitar">
					<div class="buscar-header">
						<h3>Buscar Vuelo</h3>
						<button class="btn btn-danger buscar-cerrar"
							onclick="cerrarBusqueda(0)">
							<i style="font-size: 1.5rem;" class="bi bi-x-square"></i>
						</button>
					</div>
					
					<table class="table" id="Vuelo1">
						<thead>
							<tr>
								<th scope="col">N° Vuelo</th>
								<th scope="col">Destino</th>
								<th scope="col">Pais</th>
								<th scope="col">Hora</th>
								<th scope="col">Salida</th>
								<th scope="col">Llegada</th>
								<th scope="col">Escoger</th>
							</tr>
						</thead>
						<tbody>  
							<!--Codigo JAVA-->
							<%
						int i = 0;
						%>
							<c:if test="${listado != null && lstDestinos !=null}">
							<c:forEach items="${listado }" var="vu">
							<tr>
								<td name="vu1Codigo">${vu.codVuelo }</td>
								<c:forEach items="${lstDestinos }" var="des">
									<c:if test="${vu.codDesSalida == des.codDestino }">
										<td name="vu1Descrip">${des.aeropueDes }, ${des.ciudadDes}</td>
										<td name="vu1Pais">${des.paisDes }</td>
										
									</c:if>
								</c:forEach>
										<td name="vu1Hora">${vu.horaVuelo }</td>
										<td name="vu1FechaSa">${vu.fechaSalida }</td>
										<td name="vu1FechaLle">${vu.fechaLlegada }</td>		
											
								<td>
									<input type="hidden" value="${vu.precioVuelo }"  name="vu1Precio">
									<button name="btnEscoger-0" type="button" class="btn btn-primary" value="${vu.codVuelo }" onclick="llenarVuelo1(<%=i%>)">
									Seleccionar
									</button>
								
								</td>
							</tr>
							<%
							if(i == 3){
								i = 0;
							}
							i += 1;
							%>
							</c:forEach>
							</c:if>
							<c:if test="${listado == null && lstDestinos ==null}">
								<td>Error</td>
							</c:if>
							
							
					
						</tbody>
					</table>
				</div>
			</div>
			<div class="quitar buscar-flotante-1">
				<div class="buscar-vuelo-1 quitar">
					<div class="buscar-header">
						<h3>Buscar Vuelo</h3>
						<button class="btn btn-danger buscar-cerrar"
							onclick="cerrarBusqueda(1)">
							<i style="font-size: 1.5rem;" class="bi bi-x-square"></i>
						</button>
					</div>
					
					<table class="table" id="Vuelo2">
						<thead>
							<tr>
								<th scope="col">N° Vuelo</th>
								<th scope="col">Destino</th>
								<th scope="col">Pais</th>
								<th scope="col">Hora</th>
								<th scope="col">Salida</th>
								<th scope="col">Llegada</th>
								<th scope="col">Escoger</th>
							</tr>
						</thead>
							<%
						i = 0;
						%>
						<tbody>  
							<c:if test="${listado != null && lstDestinos !=null}">
							<c:forEach items="${listado }" var="vu">
							<tr>
								<td  name="vu2Codigo">${vu.codVuelo }</td>
								<c:forEach items="${lstDestinos }" var="des">
									<c:if test="${vu.codDesSalida == des.codDestino }">
										<td name="vu2Descrip">${des.aeropueDes }, ${des.ciudadDes}</td>
										<td name="vu2Pais">${des.paisDes }</td>
										
									</c:if>
								</c:forEach>
										<td name="vu2Hora">${vu.horaVuelo }</td>
										<td name="vu2FechaSa">${vu.fechaSalida }</td>
										<td name="vu2FechaLle">${vu.fechaLlegada }</td>	
												
								<td>
								<input type="hidden" value="${vu.precioVuelo }"  name="vu2Precio">
									<button name="btnEscoger-1" type="button" class="btn btn-primary" value="${vu.codVuelo }" onclick="llenarVuelo2(<%=i%>)" >
									Seleccionar
									</button>
							
								</td>
							</tr>
							<%
							if(i == 3){
								i = 0;
							}
							i += 1;
							%>
							</c:forEach>
							</c:if>
							<c:if test="${listado == null && lstDestinos ==null}">
								<td>Error</td>
							</c:if>
							
						</tbody>
					</table>
				</div>
			</div>
			<div class="right-dentro">
				<h1 style="text-align: center;">VENTAS DE PASAJES</h1>
				<form action="ventaController" method="post">
					<div class="form-group row info-venta">
						<label for="num-venta" class="col-sm-1.5 col-form-label">N°
							Venta:</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="num-venta" readonly="readonly"
								name="txtNumVenta" placeholder="######" value="${codVenta }">
						</div>
						<label for="inputPassword" class="col-sm-1 col-form-label">Fecha:</label>
						<div class="col-sm-3">
							<input type="date" class="form-control" id="inputPassword" readonly="readonly"
								name="txtFechaVenta" placeholder="Password" value="${fechaHoy }">
						</div>
					</div>
					<div class="form-group row info-descuento" style="grid-template-columns: 27% 54% 19% !important;">
						<label for="num-venta" class="col-sm-1.5 col-form-label" style="grid-column: 1/2;">Codigo
							Promocional: </label>
							
							<%--Buscar codigo promocional --%>
							<input type="text" class="form-control" id="num-venta" name="txtPromo"
								placeholder="######" style="grid-column: 2/3; margin: 0 -1.5rem" value="${promo.clave_promocion }">
								<button class="btn btn-primary" style="grid-column: 3/4;" type="submit" name="btnSiguiente" value="promocion">Buscar</button>
						
						
					</div>
					<h4 style="margin-top: 2rem;">Ida</h4>
					<div class="form-group row info-vuelo">
						<div class="campo-1-btn">
							<label class="col-form-label lab-camp1-btn">N° Vuelo: </label> <input readonly="readonly" value="${vuelo_1.codVuelo }"
								type="text" class="form-control inp-camp1-btn"
								name="txtNumVuelo01" placeholder="######" >
							<button class="btn btn-primary btn-camp1-btn" type="button" name="btnBuscarVuelo" value="1"
                                onclick="buscarVuelo(0)" onprogress="">Buscar</button>
						</div>

						<div class="campos-2">
							<label class="col-form-label">Lugar Salida: </label>
							<c:if test="${des1 == null }">
								<input readonly="readonly"
								type="text" class="form-control" name="txtLugarSalida01" style="grid-column: 2/5;" value=""
								placeholder="######"> 
							</c:if> 
							<c:if test="${des1 != null }">
							<input readonly="readonly"
								type="text" class="form-control" name="txtLugarSalida01" style="grid-column: 2/5;" value="${des1.aeropueDes } - ${des1.ciudadDes}, ${des1.paisDes}"
								placeholder="######"> 
							</c:if>
							
						</div>
						<div class="campos-2">
						<label class="col-form-label">Fecha
								Salida: </label> <input type="date" class="form-control" readonly="readonly" value="${vuelo_1.fechaSalida }"
								name="txtFechaSalida01" placeholder="######">
						 <label class="col-form-label">Precio: </label>
							<fmt:setLocale value="en_US"/>
							<fmt:formatNumber type="currency" value="${vuelo_1.precioVuelo }" var="precio_1">
							</fmt:formatNumber>
							<input readonly="readonly"
								type="text" class="form-control" name="txtPrecio01" value="${precio_1}"
								placeholder="######">
						</div>
						
					</div>
					<h4 style="margin-top: 2rem;">Vuelta</h4>
					<div class="form-group row info-vuelo">
						<div class="campo-1-btn">
							<label class="col-form-label lab-camp1-btn">N° Vuelo: </label> <input readonly="readonly" value="${vuelo_2.codVuelo }"
								type="text" class="form-control inp-camp1-btn"
								name="txtNumVuelo02" placeholder="######" >
							<button class="btn btn-primary btn-camp1-btn" type="button" name="btnBuscarVuelo" value="2"
                                onclick="buscarVuelo(1)">Buscar</button>
						</div>

						<div class="campos-2">
							<label class="col-form-label">Lugar Salida: </label> 
							
							<c:if test="${des2 == null }">
							<input readonly="readonly"
								type="text" class="form-control" name="txtLugarSalida02" style="grid-column: 2/5;"
								placeholder="######">  
							
							</c:if>
							<c:if test="${des2 != null }">
							<input readonly="readonly"
								type="text" class="form-control" name="txtLugarSalida02" style="grid-column: 2/5;"value="${des2.aeropueDes } - ${des2.ciudadDes}, ${des2.paisDes}"
								placeholder="######">  
							</c:if>
						</div>
						<div class="campos-2">
						<label class="col-form-label">Fecha 
								Salida: </label> <input type="date" class="form-control" readonly="readonly" value="${vuelo_2.fechaSalida }"
								name="txtFechaSalida02" placeholder="######">
							
							<label class="col-form-label">Precio: </label>
							<fmt:setLocale value="en_US"/>
							<fmt:formatNumber type="currency" value="${vuelo_2.precioVuelo }" var="precio_2">
							</fmt:formatNumber>
							<input readonly="readonly"
								type="text" class="form-control" name="txtPrecio02" value="${precio_2}">
						</div>
						
					</div>

					<button type="submit" name="btnSiguiente" value="vuelos" class="btn btn-primary">Siguiente</button>
				</form>

			</div>
		</div>
	</div>
</body>
<script src="js/intranet-2.js"></script>
<script>
    $(document).ready(function () {
        $('#Vuelo1').DataTable({
            "pagingType": "simple_numbers",
            "pageLength": 3,
            "language": {
                "lengthMenu": "Mostrar por: _MENU_ ",
                "zeroRecords": "No hay registros a mostrar",
                "info": "Página _PAGE_ de _PAGES_",
                "infoEmpty": "No encontrado",
                "infoFiltered": "(filtered from _MAX_ total records)",
                "search": "Buscar: ",
                "paginate": {
                    previous: "Antes",
                    next: "Despues"
                }
            },
            "sDom": '<"top"f>rt<"bottom"ip>'
        });
    });
    $(document).ready(function () {
        $('#Vuelo2').DataTable({
            "pagingType": "simple_numbers",
            "pageLength": 3,
            "language": {
                "lengthMenu": "Mostrar por: _MENU_ ",
                "zeroRecords": "No hay registros a mostrar",
                "info": "Página _PAGE_ de _PAGES_",
                "infoEmpty": "No encontrado",
                "infoFiltered": "(filtered from _MAX_ total records)",
                "search": "Buscar: ",
                "paginate": {
                    previous: "Antes",
                    next: "Despues"
                }
            },
            "sDom": '<"top"f>rt<"bottom"ip>'
        });
    });


</script>
<script>
var valor = 0;
var precio = document.getElementsByName("txtPrecio");
var numVuelo = document.getElementsByName("txtNumVuelo");
var lugarSalida = document.getElementsByName("txtLugarSalida");
var fechaSalida = document.getElementsByName("txtFechaSalida");

var codigo = "";
var descrip = "";
var pais = "";
var hora = "";
var fechaSa = "";
var precio = 0;
 function llenarVuelo1(index) {
       codigo = document.getElementsByName("vu1Codigo")[index].textContent;
       descrip = document.getElementsByName("vu1Descrip")[index].textContent;
       pais = document.getElementsByName("vu1Pais")[index].textContent;
       hora = document.getElementsByName("vu1Hora")[index].textContent;
       fechaSa = document.getElementsByName("vu1FechaSa")[index].textContent;
       fechaLle = document.getElementsByName("vu1FechaLle")[index].textContent;
       precio = document.getElementsByName("vu1Precio")[index].value;
       
       document.getElementsByName("txtNumVuelo01")[0].value = codigo;
       document.getElementsByName("txtLugarSalida01")[0].value = descrip + ", " + pais;
       document.getElementsByName("txtFechaSalida01")[0].value = fechaSa;
       document.getElementsByName("txtPrecio01")[0].value = "$ "+ precio;
       cerrarBusqueda(0);
   }
 function llenarVuelo2(index) {
     codigo = document.getElementsByName("vu2Codigo")[index].textContent;
     descrip = document.getElementsByName("vu2Descrip")[index].textContent;
     pais = document.getElementsByName("vu2Pais")[index].textContent;
     hora = document.getElementsByName("vu2Hora")[index].textContent;
     fechaSa = document.getElementsByName("vu2FechaSa")[index].textContent;
     fechaLle = document.getElementsByName("vu2FechaLle")[index].textContent;
     precio = document.getElementsByName("vu2Precio")[index].value;
     
     document.getElementsByName("txtNumVuelo02")[0].value = codigo;
     document.getElementsByName("txtLugarSalida02")[0].value = descrip + ", " + pais;
     document.getElementsByName("txtFechaSalida02")[0].value = fechaSa;
     document.getElementsByName("txtPrecio02")[0].value = "$ "+ precio;
     cerrarBusqueda(1);
 }

</script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
${mensajeError }
${viajeError }
</html>