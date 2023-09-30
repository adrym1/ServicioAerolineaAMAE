<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ventas - Pasajeros</title>
<link rel="icon" href="img/logo/Logo-sinfondo.png">
<link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="css/navVertical.css">
    <link rel="stylesheet" href="css/enzo2.css">
</head>
<body>
	<div id="general-content">
	<jsp:include page="navVertical.jsp"></jsp:include>
	<div id="right-content">
		<div class="right-dentro">
		<div id="right-adentro">
               
                <fmt:setLocale value="es_PE"/>
                    	
                <div class="resumen-info">
                    <div>
                        <label for="">N° Boleta: </label>
                        <input class="form-control" type="text" name="txtnumBoleta" id="" value="${boleta.codVenta }" readonly="readonly">
                    </div>
                    <div>
                        <label for="">Pago: </label>
                        <fmt:formatNumber type="currency" value="${montoTotal }" var="mon">
                    	</fmt:formatNumber>
                        <input class="form-control" type="text" name="txtPago" id="" value="${mon }" readonly="readonly">
                    </div>
                    

                </div>
                <form class="izqui-final" action="ventaController" method="get">
                    <div>
                        <label for="">Tickets de acceso de Pasajes:  </label>
                        <button class="btn btn-primary" type="submit" name="btnSiguiente" value="pdf">Exportar PDF</button>
                    </div>
                    <div>
                        <label for="">Código de reserva: </label>
                        <input class="form-control" type="text" name="txtReserva" value="${codVenta }" readonly="readonly">
                    </div>
                </form>
                <div class="billetera-body">
                    <h3>QR</h3>
                    <img name="qr-finalizado"
                        src='https://chart.googleapis.com/chart?cht=qr&chl=https%3A%2F%2Fwww.bbva.pe&chs=180x180&choe=UTF-8&chld=L|2'
                        alt='qr code'><a href='https://www.qr-code-generator.com' border='0' style='cursor:default'
                        rel='nofollow'></a>
                </div>
                <div class="boton-final">
                	<form action="" method="get">
                	   <button type="submit" name="btnSiguiente" value="finalizado" class="btn btn-primary" >Finalizar</button>
                	</form>
                </div>
            </div>
		</div>
	</div>
	</div>
</body>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
${mensajeError }
</html>