<%@page import="dao.DAOFactory"%>
<%@page import="model.usuario"%>
<%@page import="model.tipo_usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="mantenimiento.GestionTipoUsuarioDAOMYSQL"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <title>AMAE - Mantenimiento Usuario</title>
<link rel="stylesheet" href="css/estiloUsuario.css">
<link rel="stylesheet" href="css/Formulario.css">
<link rel="stylesheet"href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>


</head>
<body>
<div id="general-content">
<jsp:include page="navVertical.jsp"></jsp:include>
	<div id="right-content">
		<div id="right-adentro">
		<c:if test="${usu != null }">
		
		<div class="formularios">
 	
        <div class="titulo">
            <h1>Usuario</h1>                 
        </div>
       
       <form action="usuario" method="post">     
          
          	<div class="contenedor">
          	
            <div class="form-row">
            <div class="form-group">
				<label for="text">Codigo : </label> <input name="txtCodigo" class="form-control"
				 type="text" value="${u.codigo }" >
			</div>
			<!--  
			<div class="form-group col-md-6">
					 <button type="submit" class="btn btn-primary" data-toggle="modal"
							data-target="#exampleModal" data-whatever="@mdo" name="btnAccion" value="list" style="margin-top: 35px;">
							<img src="img/buscar.png" alt="" style="margin-left: -5px; width: 150%;">
						</button>	
			</div>
			-->
				</div>
			<div class="form-group">
				<label for="email"> Usuario : </label> <input name="txtUsuario"
					type="email" placeholder="Ingrese su usuario "
					value="${u.usuario }" class="form-control">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Contraseña :</label> <input name="txtClave"
				 type="password"  placeholder="Ingrese Password" class="form-control"
					value="${u.clave }" >
			</div>
			<!-- CAMPO TIPO DE DOCUMENTO -->
            <div class="form-group">
                <label for="inputState">Tipo de Usuario :</label>
                <select  name="cboTipo" class="form-control">
                    <option selected>Seleccione...</option >
                   <%						
                   DAOFactory  fabrica = DAOFactory.getDaoFactory(1);							
					ArrayList<tipo_usuario> lstTipoUsuario = fabrica.getTipoUsuarioDAO().Listado();
					request.setAttribute("lstTipoUsuario", lstTipoUsuario);
				 %>
				 <c:forEach items="${lstTipoUsuario }" var="c">
									<c:if test="${c.getIdTipo() == u.tipo}">
										<option value="${c.getIdTipo()}" selected="selected" >${c.getDescripcion()}</option>
									</c:if>
									<c:if test="${c.getIdTipo() != u.tipo}">
										<option value="${c.getIdTipo()}">${c.getDescripcion()}</option>
									</c:if>
				</c:forEach>							
                </select >
            </div>
            	
            	<div class="botones" style="margin-top: 70px;">
								<button type="input" class="btn btn-registrar boton-formulario" name="btnAccion"
									value="reg">
									<img src="img/iconos/icono registrar.svg" alt="">
									<p>Registrar</p>
								</button>
								<button type="input" class="btn btn-actualizar boton-formulario"
									name="btnAccion" value="act">
									<img src="img/iconos/icono actualizar.svg" alt="">
									<p>Actualizar</p>
								</button>
								
							</div>
							<!-- 
		 <div class="botones" style=" font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; font-size: 17pt;">
		  
            <button type="submit" name="btnAccion" value="reg" class="btn btn-outline-secondary">Registrar</button>
            <button type="submit" name="btnAccion" value="act" class="btn btn-outline-success">Actualizar</button>
            <button type="submit" name="btnAccion" value="eli" class="btn btn-outline-danger">Eliminar</button>
         </div> -->
	</div>
    </form>
     <br>
	${mensaje }
	<br>
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