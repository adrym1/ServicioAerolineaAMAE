<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<link rel="icon" href="img/logo/Logo-sinfondo.png">
	<link rel="stylesheet" href="css/navVertical.css">
	<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<aside id="aside-content">
            <div id="navVe-content">
                <div class="superior-content">
                    <button type="button" class="btn btn-warning" id="chevron_direction" onclick="esconderNav()"><i
                            class="bi bi-chevron-double-left" id="arrow-respon"></i></button>
                </div>
                <div class="nav-usu-content">
                    <div class="foto-usu">
                    <!-- Arreglar para que sea a nivel de base de datos -->
                    	<c:if test="${usu == null }">
                    	<a><img id="foto_usu" src="img/perfiles/200001.jpg" alt="Imagen no encontrada"></a>
                    	</c:if>
                    	<c:if test="${usu != null }">
                    	<a href="confiCuenta.jsp"><img id="foto_usu" src="perfiles/${usu.codigo }.${usu.extension}" alt="Imagen no encontrada"></a>
                    	</c:if>
                        
                    </div>
                    <c:if test="${usu == null }">
                    <div class="nombre-usu" id="nombre_usu">Invitado</div>
                    </c:if>
                      <c:if test="${usu != null }">
                    <div class="nombre-usu" id="nombre_usu">${tipo} </div>
                    </c:if>
                    
                </div>

                <form class="link-content" method="get" action="obtenerEnlace">
                <%--Empieza las restricciones --%>
                <c:if test="${usu == null || codTipo ==3 }">
                <ul>
                        <li>
                            <div class="menu_link" onclick="esconderSubs(0)">
                                <span class="icon-link"><i class="bi bi-wallet2"></i></span>
                                <span class="nombre-link">Compra</span>
                            </div>
                            <div class="submenus quitar">
                                <ul>
                                    <li><button class="resp_icons" name="btnLink" value="Reserva" type="submit">
                                            <span class="icon-link"><i class="bi bi-building"></i></span>
                                            <span class="nombre-link">Reserva de Hoteles</span>
                                        </button></li>
                                </ul>
                            </div>
                        </li>
                        <li>
                            <div class="menu_link" onclick="esconderSubs(1)">
                                <span class="icon-link"><i class="bi bi-cart3"></i></span>
                                <span class="nombre-link">Venta</span>
                            </div>
                            <div class="submenus quitar">
                                <ul>
                                <li>
                                    	<button class="resp_icons" type="submit" name="btnLink" value="check-in">
                                            <span class="icon-link"><i class="bi bi-check2-circle"></i></span>
                                            <span class="nombre-link">Check-in</span>
                                        </button>
                                    </li>
                                    <li>
                                    	<button class="resp_icons" type="submit" name="btnLink" value="Pasajes">
                                            <span class="icon-link"><i class="bi bi-box-fill"></i></span>
                                            <span class="nombre-link">Pasajes</span>
                                        </button>
                                    </li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                </c:if>
                <c:if test="${usu!= null && codTipo == 1}">
                <ul>
                    
                        <li>
                        
                            <div class="menu_link" onclick="esconderSubs(0)">
                                <span class="icon-link"><i class="bi bi-clipboard-data"></i></span>
                                <span class="nombre-link">Mantenimiento</span>
                            </div>
                            <div class="submenus quitar">
                                <ul>
                                    <li class="li-display"><button class="resp_icons" name="btnLink" value="ManVuelos" type="submit">
                                            <span class="icon-link"><i class="bi bi-airplane-engines"></i></span>
                                            <span class="nombre-link">Vuelos</span>
                                        </button></li>
                                    <li><button class="resp_icons" name="btnLink" value="ManPromo" type="submit">
                                            <span class="icon-link"><i class="bi bi-pen"></i></span>
                                            <span class="nombre-link">Promociones</span>
                                        </button></li>
                                    <li><button class="resp_icons" name="btnLink" value="ManCliente" type="submit">
                                            <span class="icon-link"><i class="bi bi-people"></i></span>
                                            <span class="nombre-link">Clientes</span>
                                        </button></li>
                                    <li class="li-display"><button class="resp_icons" name="btnLink" value="ManUsuario" type="submit">
                                            <span class="icon-link"><i class="bi bi-person-lines-fill"></i></span>
                                            <span class="nombre-link">Usuario</span>
                                        </button></li>
                                    
                                </ul>
                            </div>
                              
                        </li>
                       
                        <li>
                            <div class="menu_link" onclick="esconderSubs(1)">
                                <span class="icon-link"><i class="bi bi-table"></i></span>
                                <span class="nombre-link">Reportes</span>
                            </div>
                            <div class="submenus quitar">
                                <ul>
                                    <li class="li-display"><button class="resp_icons" name="btnLink" value="RepVuelos" type="submit">
                                            <span class="icon-link" name="icons"><i class="bi bi-airplane-fill"></i></span>
                                            <span class="nombre-link">Vuelos</span>
                                        </button></li>
                                    <li class="li-display"><button class="resp_icons"  name="btnLink" value="RepCliente" type="submit">
                                            <span class="icon-link" name="icons"><i class="bi bi-person-badge"></i></span>
                                            <span class="nombre-link" >Clientes</span>
                                        </button></li>
                                    <li class="li-display"><button class="resp_icons" name="btnLink" value="RepDestino" type="submit">
                                            <span class="icon-link" name="icons"><i class="bi bi-file-ppt"></i></span>
                                            <span class="nombre-link">Destinos Deseados</span>
                                        </button></li>
                                </ul>
                            </div>
                        </li>
                        <li>
                            <div class="menu_link" onclick="esconderSubs(2)">
                                <span class="icon-link"><i class="bi bi-wallet2"></i></span>
                                <span class="nombre-link">Compra</span>
                            </div>
                            <div class="submenus quitar">
                                <ul>
                                    
                                    <li><button class="resp_icons" name="btnLink" value="Reserva" type="submit">
                                            <span class="icon-link"><i class="bi bi-building"></i></span>
                                            <span class="nombre-link">Reserva de Hoteles</span>
                                        </button></li>
                                </ul>
                            </div>
                        </li>
                        <li>
                            <div class="menu_link" onclick="esconderSubs(3)">
                                <span class="icon-link"><i class="bi bi-cart3"></i></span>
                                <span class="nombre-link">Venta</span>
                            </div>
                            <div class="submenus quitar">
                                <ul>
                                <li>
                                    	<button class="resp_icons" type="submit" name="btnLink" value="check-in">
                                            <span class="icon-link"><i class="bi bi-check2-circle"></i></span>
                                            <span class="nombre-link">Check-in</span>
                                        </button>
                                    </li>
                                    <li>
                                    	<button class="resp_icons" type="submit" name="btnLink" value="Pasajes">
                                            <span class="icon-link"><i class="bi bi-box-fill"></i></span>
                                            <span class="nombre-link">Pasajes</span>
                                        </button>
                                    </li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                </c:if>
                  <c:if test="${usu != null && codTipo == 2 }">
                  <ul>
                  
                  <li>
                            <div class="menu_link" onclick="esconderSubs(0)">
                                <span class="icon-link"><i class="bi bi-table"></i></span>
                                <span class="nombre-link">Reportes</span>
                            </div>
                            <div class="submenus quitar">
                                <ul>
                                    <li class="li-display"><button class="resp_icons" name="btnLink" value="RepVuelos" type="submit">
                                            <span class="icon-link" name="icons"><i class="bi bi-airplane-fill"></i></span>
                                            <span class="nombre-link">Vuelos</span>
                                        </button></li>
                                    <li class="li-display"><button class="resp_icons"  name="btnLink" value="RepCliente" type="submit">
                                            <span class="icon-link" name="icons"><i class="bi bi-person-badge"></i></span>
                                            <span class="nombre-link" >Clientes</span>
                                        </button></li>
                                    <li class="li-display"><button class="resp_icons" name="btnLink" value="RepDestino" type="submit">
                                            <span class="icon-link" name="icons"><i class="bi bi-file-ppt"></i></span>
                                            <span class="nombre-link">Destinos Deseados</span>
                                        </button></li>
                                </ul>
                            </div>
                        </li>
                  
                  
                  </ul>
                  
                  
                  
                  
                  
                  </c:if>
                </form>
                <c:if test="${usu == null }">
                <div class="parte-final">
                 <a class="bottom-content" href="cerrarSesion">
                    <button class="btn btn-danger btn_cerrar" name="" type="button">
                        <i class="bi bi-x-square ico_cerrar"></i>
                        <div class="text_cerrar">Cerrar sesión</div>
                    </button>
                </a>
                <a class="bottom-content" href="IntranetPrincipal.jsp">
                    <button class="btn btn-info btn_cerrar" name="" type="button">
                       <i class="bi bi-arrow-left-square"></i>
                        <div class="text_cerrar">Volver</div>
                    </button>
                </a>
                 </div>
                </c:if>
                 <c:if test="${usu != null}">
                 <div class="parte-final">
                 <a class="bottom-content" href="cerrarSesion">
                    <button class="btn btn-danger btn_cerrar" name="" type="button">
                        <i class="bi bi-x-square ico_cerrar"></i>
                        <div class="text_cerrar">Cerrar sesión</div>
                    </button>
                </a>
                <a class="bottom-content" href="IntranetPrincipal.jsp">
                    <button class="btn btn-info btn_cerrar" name="" type="button">
                       <i class="bi bi-arrow-left-square"></i>
                        <div class="text_cerrar">Volver</div>
                    </button>
                </a>
                 </div>
                 
                </c:if>
               
            </div>
        </aside>
        <style>
        .parte-final{
        	display: flex;
        	
        }
        </style>
<script src="js/navVertical.js"></script>
