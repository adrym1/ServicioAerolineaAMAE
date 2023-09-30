<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="icon" href="img/logo/Logo-sinfondo.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Venta - Compra</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/enzo2.css">
</head>
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
<body>
	
    <div id="general-content">
        <jsp:include page="navVertical.jsp"></jsp:include>
        <div id="right-content">
            <div id="right-adentro">
                <div class="indice-venta">
                    <div class="indice-dato" style="width: 100%">
                        <button class="btn btn-warning"><i class="bi bi-airplane-fill"></i></button>
                        <h3>Vuelo</h3>
                    </div>
                    <div class="flecha">
                        <div class="flecha-cuerpo"></div>
                        <div class="flecha-cabeza"></div>
                    </div>
                    <div class="indice-dato">
                        <button class="btn btn-warning"><i class="bi bi-people-fill"></i></button>
                        <h3>Pasajeros</h3>
                    </div>
                    <div class="flecha"></div>
                    <div class="indice-dato">
                        <button class="btn btn-warning indice-activo"><i class="bi bi-bag"></i></button>
                        <h3>Compra</h3>
                    </div>
                    <div class="flecha"></div>
                    <div class="indice-dato">
                        <button class="btn btn-warning"><i class="bi bi-check-square-fill"></i></button>
                        <h3>Finalizado</h3>
                    </div>
                </div>
                <div class="resumen-info">
                    <div>
                    	<fmt:setLocale value="en_US"/>
                    	
                        <label for="">Cantidad: </label>
                        <input type="text" name="txtCantidad" readonly="readonly" value="${cantidad}" id="" class="form-control">
                    </div>
                    <div>
                    <fmt:formatNumber type="currency" value="${precioTotal }" var="precioTo">
                    	</fmt:formatNumber>
                        <label for="">Total de: </label>
                        <input type="text" name="" id="" readonly="readonly" value="${precioTo}" class="form-control">
                    </div>
                    <div>
                    
                        <label for="">Descuento: </label>
                        <input type="text" name="" id="" readonly="readonly" class="form-control" value="${descuento * 100 }%">
                    </div>
                    <div>
                    <fmt:formatNumber type="currency" value="${impuesto }" var="imp">
                    	</fmt:formatNumber>
                        <label for="">Impuesto: </label>
                        <input type="text" name="" id="" readonly="readonly" value="0.18" class="form-control">
                    </div>
                    <div name="cont_monto">
                    <fmt:formatNumber type="currency" value="${montoTotal }" var="mon">
                    	</fmt:formatNumber>
                        <label for="" name="lblMontoTotal">Monto Total: </label>
                        <input type="text" name="txtMontoTotal" value="${mon}" readonly="readonly" id="" class="form-control">
                    </div>
                </div>
                <div class="tipo-pago">
                    <div class="pestanias-pago">
                        <button class="btn btn-default activo" name="btnPestania"
                            onclick="tarjetaPestania('visa')">VISA <i class='fab fa-cc-visa'></i></button>
                        <button class="btn btn-default desactivo" name="btnPestania"
                            onclick="tarjetaPestania('mastercard')">MASTERCARD <i class='fab fa-cc-mastercard'></i></button>
                       
                    </div>
                    
                    <form class="visa pestania-content" method="post" action="ventaController">
                        <label for="" class="col-form-label lab-camp1-btn">N° Tarjeta: </label>
                        <input class="form-control" type="text" name="txtNumero_visa">
                        <label for="">Tipo Tarjeta: </label>
                        <select name="cmbTipoTarje_visa" class="form-control">
                            <option selected>...</option>
                            <option>Debito</option>
                            <option>Credito</option>
                        </select>
                        <label for="" class="col-form-label lab-camp1-btn">CVV: </label><input class="form-control" type="text" name="txtCVV_visa">
                        <label for="">Autor: </label><input class="form-control" type="text" name="txtAutor_visa">
                        <label for="">DNI: </label><input class="form-control" type="text" name="txtDni_visa">
                        
                      
                        	<button class="btn btn-primary" name="btnSiguiente" value="pago_visa" style="grid-column:2/4; margin: 1rem auto">Pagar</button>
                        
                        
                    </form>
                    
                    <form class="mastercard pestania-content" style="display: none;">
                        <label for="">N° Tarjeta: </label><input class="form-control" type="text" name="txtNumero_mast">
                        <label for="">Tipo Tarjeta: </label>
                        <select name="cmbTipoTarje_mast" class="form-control">
                            <option selected>...</option>
                            <option>Debito</option>
                            <option>Credito</option>
                        </select>
                        <label for="">CVV: </label><input class="form-control" type="text" name="txtCVV_mast">
                        <label for="">Autor: </label><input class="form-control" type="text" name="txtAutor_mast">
                        <label for="">DNI: </label><input class="form-control" type="text" name="txtDni_mast">
                        
                       	<button class="btn btn-primary" name="btnSiguiente" value="pago_mast" style="grid-column:2/4; margin: 1rem auto">Pagar</button>
                    
                    </form>
                    
                </div>
               

            </div>
        </div>
    </div>
</body>
<script src="js/intranet-2.js"></script>
<script src="js/navVertical.js"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
${pagoError }
</html>