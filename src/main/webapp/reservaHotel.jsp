<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Reserva de Hoteles</title>
<link rel="stylesheet" href="css/enzo2.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
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
							<h3>Hoteles Disponibles</h3>
							<button class="btn btn-danger buscar-cerrar"
								onclick="cerrarBusqueda(0)">
								<i style="font-size: 1.5rem;" class="bi bi-x-square"></i>
							</button>
						</div>

						<table class="table" id="Hotel">
							<thead>
								<tr>
									<th scope="col">Codigo</th>
									<th scope="col">Nombre</th>
									<th scope="col">Cantidad disponibles</th>
									<th scope="col">Escoger</th>
								</tr>
							</thead>
							<tbody>
								<!--Codigo JAVA-->
								<%
								int i = 0;
								%>
								<c:if test="${ lstHoteles !=null}">
									<c:forEach items="${lstHoteles }" var="ho">
										<tr>
											<td name="hotelCodigo">${ho.codHotel}</td>
											<td name="hotelNombre">${ho.nombre}</td>
											<td name="cantiCuartos">${ho.cantCuartos}</td>


											<td><input type="hidden" value="${ho.codHotel}"
												name="hotelCod">
												<button name="btnEscoger-0" type="button"
													class="btn btn-primary" value="${ho.codHotel}"
													onclick="llenarHotel(<%=i%>)">Seleccionar</button></td>
										</tr>
										<%
										if (i == 3) {
											i = 0;
										}
										i += 1;
										%>
									</c:forEach>
								</c:if>
								<c:if test="${ lstHoteles ==null}">
									<td>Error</td>
								</c:if>



							</tbody>
						</table>
					</div>
				</div>
				<div class="quitar buscar-flotante-1">
					<div class="buscar-vuelo-1 quitar">
						<div class="buscar-header">
							<h3>Lugar de Estadia</h3>
							<button class="btn btn-danger buscar-cerrar"
								onclick="cerrarBusqueda(1)">
								<i style="font-size: 1.5rem;" class="bi bi-x-square"></i>
							</button>
						</div>

						<table class="table" id="Estadia">
							<thead>
								<tr>
									<th scope="col">Codigo</th>
									<th scope="col">Ciudad</th>
									<th scope="col">Pais</th>
									<th scope="col">Escoger</th>
								</tr>
							</thead>
							<%
							i = 0;
							%>
							<tbody>
								<c:if test="${lstDestinos !=null}">
									<c:forEach items="${lstDestinos }" var="des">
										<tr>
											<td name="desCodigo">${des.codDestino}</td>

											<td name="desCiudad">${des.ciudadDes }</td>
											<td name="desPais">${des.paisDes }</td>

											<td><input type="hidden" value="${des.codDestino }"
												name="desCod">
												<button name="btnEscoger-1" type="button"
													class="btn btn-primary" value="${des.codDestino }"
													onclick="llenarDestino(<%=i%>)">Seleccionar</button></td>
										</tr>
										<%
										if (i == 3) {
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
			<div id="right-adentro">
				
				<form action="reserva" method="post" class="cont-reserva">
					<h2 style="text-align: center;">Reserva de Habitaciones</h2>
					<div class="cod-reserva">
						<label for="">Num. Solicitud: </label> <input type="text"
							name="txtNumSoli" id="" value="${codSol }" class="form-control"
							readonly="readonly"> <label for=""
							style="margin-left: 2rem;">Fecha: </label> <input type="date"
							name="txtFecha" id="" value="${fechaActual }" class="form-control"
							readonly="readonly">
					</div>
					<div class="hotel-reserva">
						<label for="">Hotel: </label> 
						<input type="hidden" value="" name="txtCodHotel">
						<input type="text" name="txtHotel"
							value="" class="form-control" readonly="readonly">
						<button type="button" class="btn btn-primary" onclick="buscarVuelo(0)">Buscar
							Hotel</button>
					</div>
					<div class="info-reserva">
						<div class="sub-info-3">
							<label for="">Lugar de Estadia: </label> 
							<input type="hidden" value="" name="txtCodDes">
							<input type="text"
								name="txtLugarEsta" id="" class="form-control"
								readonly="readonly">
							<button type="button" class="btn btn-primary" onclick="buscarVuelo(1)">Buscar</button>
						</div>

						<div class="sub-info-4" style="margin: 2rem auto;">
							<label for="">Fecha Ingreso: </label> <input type="date"
								name="txtFechaIng" class="form-control"> <label for=""
								style="margin-left: 2rem;">Fecha Salida: </label> <input
								type="date" name="txtFechaSal" id="" class="form-control">


						</div>
						<div class="sub-info-4">
							<label for="">Cantidad: </label> <input type="number" min="1"
								max="5" name="txtCantidad" class="form-control"> <label
								for="" style="margin-left: 2rem;">Tipo: </label> <select
								name="cmbTipo" id="" class="form-control">
								<option value="VIP">VIP</option>
								<option value="Presidencial">Presidencial</option>
								<option value="Economico">Economico</option>
							</select>
						</div>

					</div>
					<div class="accion-reserva">
						<button class="btn btn-primary" name="btnAccion" value="registrar"
							type="submit">Registrar</button>
						
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
<script src="js/intranet-2.js"></script>
<script>
    $(document).ready(function () {
        $('#Hotel').DataTable({
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
        $('#Estadia').DataTable({
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


var codigo = "";
var nombre = "";
var pais = "";
var cantiCuartos = "";
var codigoDes = "";
var ciudad = "";
var pais = "";

 function llenarHotel(index) {
       codigo = document.getElementsByName("hotelCodigo")[index].textContent;
       nombre = document.getElementsByName("hotelNombre")[index].textContent;
       cantiCuartos = document.getElementsByName("cantiCuartos")[index].textContent; 
       document.getElementsByName("txtHotel")[0].value = nombre;
       document.getElementsByName("txtCodHotel")[0].value = codigo;
       cerrarBusqueda(0);
   }
 function llenarDestino(index) {
     codigoDes = document.getElementsByName("desCodigo")[index].textContent;
     ciudad = document.getElementsByName("desCiudad")[index].textContent;
     pais = document.getElementsByName("desPais")[index].textContent;
     
     
     document.getElementsByName("txtLugarEsta")[0].value =  ciudad + " - "+ pais;
     document.getElementsByName("txtCodDes")[0].value = codigoDes;
     
     cerrarBusqueda(1);
 }
 
 function limpiar(){
	  document.getElementsByName("txtHotel")[0].value = "";
	  document.getElementsByName("txtLugarEsta")[0].value = "";
	  document.getElementsByName("txtFechaIng")[0].value = "";
	  document.getElementsByName("txtFechaSal")[0].value = "";
	  document.getElementsByName("txtCantidad")[0].value = "";
	  
 }

</script>

<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
${mensajeError }
</html>