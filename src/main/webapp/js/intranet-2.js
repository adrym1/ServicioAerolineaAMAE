var regulador = 1;
const idPais = [];
const nombrePais = [];
//! FALTA AGREGAR LOS INDENTIFICADORES COMO TXTBUTTON
function agregarPersona() {
    var contenedor = document.getElementsByName("agregarPersona");
    if (regulador == 4) {
        regulador = 4;
        Swal.fire({
            icon: 'error',
            title: 'Capacidad Maxima',
            text: 'Maximo 4 por persona',
            footer: '<a href="">Leer documentación</a>'
        });
    } else {
			var texto = ""
       			 texto +=
            '<div class="form-group row info-vuelo">' +
            '<h2 name="txtPersona" style="text-align: center; margin: 1rem auto;">Persona ' + (regulador + 1) + '</h2>' +
            '<div class="eli-per">' +
            '<button class="btn btn-danger" type="button" onclick="eliminarPer(' + regulador + ')" name="btnEliminar">' +
            ' <i style="z-index: 99; font-size: 20px;" class=" bi bi-person-dash-fill"></i>' +
            '</button>' +
            '</div>' +
            '<div class="campo-1-btn" > ' +
            '<label class="col-form-label lab-camp1-btn">Nombre: </label>' +
            '<input type="text" name="txtNombre" class="form-control inp-camp1-btn" style="grid-column: 2/4; width: 90%"' +
            'placeholder="######">' +

            '</div>' +
            '<div class="campo-1-btn">' +
            '<label class="col-form-label lab-camp1-btn">Apellido: </label>' +
            '<input type="text" name="txtApellido" class="form-control inp-camp1-btn" style="grid-column: 2/4; width: 90%"' +
            'placeholder="######">' +

            '</div>' +
            '<div class="campos-2">' +
            '<label class="col-form-label">DNI </label>' +
            '<input type="text" name="txtDNI" class="form-control" placeholder="######">' +
            '<label class="col-form-label">Sexo </label>' +
            '<div>' +
            '<select class="form-control" name="cmbSexo">' +
            '<option selected>....</option>' +
            '<option>Masculino</option>' +
            '<option>Femenino</option>' +
            '</select>' +
            '</div>' +
            '</div>' +
            '<div class="campos-2">' +
            '<label class="col-form-label">Nacionaldad: </label>' +
            '<input type="text" name="txtNacionalidad" class="form-control" placeholder="######">' +
            '<label class="col-form-label">Edad: </label>' +
            '<input type="text" name="txtEdad" class="form-control" placeholder="######">' +
            '</div>' +

            '<div class="campo-1-btn">' +
            '<label class="col-form-label lab-camp1-btn">Domicilio: </label>' +
            '<input type="text" name="txtDomicilio" class="form-control inp-camp1-btn" style="grid-column: 2/4; width: 90%"' +
            'placeholder="######">' +

            '</div>' +
            '<div class="campos-2">' +
            '<label class="col-form-label">Estado: </label>' +
            '<input type="text" name="txtEstado" class="form-control" placeholder="######">' +
            '<label class="col-form-label">Codigo Postal: </label>' +
            '<input type="text" name="txtCodigoPos" class="form-control" placeholder="######">' +
            '</div>' +
            '<div class="campos-2">' +
            '<label class="col-form-label">Pais: </label>' + 
             '<select name="cmbPais" class="form-control">';
	            for(var i = 0; i<idPais.length; i++){
					texto +=  '<option value="'+idPais[i]+'">'+nombrePais[i]+'</option>';
				}
			texto += '</select  >'+
            '</div>' +
            '</div>';
            contenedor[0].innerHTML += texto;
        regulador += 1;
    }

}

function eliminarPer(index) {
    eliminar = document.getElementsByName("btnEliminar");
    conte = document.getElementsByClassName("info-vuelo");

    actualizarNumero(index + 1);
    conte[index].remove();

    regulador -= 1;
}
function actualizarNumero(index) {
    titu_Per = document.getElementsByName("txtPersona");
    if (titu_Per == 1) {
        return;
    } else {
        titu_Per[index - 1].innerHTML = "Persona " + (index);

    }

}


//? Parte de las pestañas
function tarjetaPestania(tarjeta) {
    let pestania = document.getElementsByClassName("pestania-content");
    let botones = document.getElementsByName("btnPestania");
    for (var i = 0; i < pestania.length; i++) {
        pestania[i].style.display = "none";
        botones[i].classList.remove("activo");
        botones[i].classList.add("desactivo");
    }

    for (var i = 0; i < pestania.length; i++) {
        if (pestania[i].classList.contains(tarjeta)) {
            pestania[i].style.display = "grid";
            botones[i].classList.add("activo");
            botones[i].classList.remove("desactivo");
        }
    }

}

//? Parte de las buscar vuelo

function buscarVuelo(index) {
    if(index ==0){
		let buscar_flotante = document.getElementsByClassName("buscar-flotante-"+index);
	    let buscar_cont = document.getElementsByClassName("buscar-vuelo-"+index);
	    if (buscar_cont[0].classList.contains("quitar")) {
	        buscar_flotante[0].classList.remove("quitar");
	        buscar_cont[0].classList.remove("quitar")
	    } else {
		}
    }
    else{
		let buscar_flotante = document.getElementsByClassName("buscar-flotante-"+index);
	    let buscar_cont = document.getElementsByClassName("buscar-vuelo-"+index);
	    if (buscar_cont[0].classList.contains("quitar")) {
	        buscar_flotante[0].classList.remove("quitar");
	        buscar_cont[0].classList.remove("quitar")
	    } else {
	
	    }
}
}

function cerrarBusqueda(index) {
    if(index == 0){
	let buscar_flotante = document.getElementsByClassName("buscar-flotante-"+index);
	    let buscar_cont = document.getElementsByClassName("buscar-vuelo-"+index);
    if (buscar_flotante[0].classList.contains("quitar")) {

    } else {
        buscar_flotante[0].classList.add("quitar");
        buscar_cont[0].classList.add("quitar")
    }
	}else{
		let buscar_flotante = document.getElementsByClassName("buscar-flotante-"+index);
	    let buscar_cont = document.getElementsByClassName("buscar-vuelo-"+index);
    if (buscar_flotante[0].classList.contains("quitar")) {

    } else {
        buscar_flotante[0].classList.add("quitar");
        buscar_cont[0].classList.add("quitar")
    }
	}
}