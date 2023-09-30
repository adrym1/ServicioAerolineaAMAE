/**
 * 
 */
 //? Parte de preguntas y respuestas 
const respuestas = [
    "Segun las politicas de empresa, no es necesario la creación de una cuenta, lo puede realizar como invitado",
    "Usted mismo puede hacerlo en nuestras sucursales como también en ventanilla. Se recomienda hacerlo 2 horas antes del vuelo.",
    "Por la COVID-19, se requiere obligatoriamente el carnet de vacunación. Esta información esta sujeta a cambios",
    
];
let active;
function mostrarRepuesta(index) {
    let parafo = document.getElementById("respuesta" + index);
    let flecha = document.getElementById("flecha" + index);
    let linea = document.getElementsByClassName("linea");
    let pregunta = document.getElementsByClassName("pregunta");
    if (flecha.classList.contains("esconder")) {

        flecha.classList.remove("esconder");
        parafo.classList.remove("esconder");
        linea[index - 1].classList.remove("esconder");

        parafo.style.marginTop = "15px";
        parafo.style.margin = "2rem auto 1rem";
        parafo.style.fontSize = "1.3rem";
        parafo.style.textAlign = "center";
        parafo.innerHTML = "<p>" + respuestas[index - 1] + "</p>";
    } else {
        flecha.classList.add("esconder");
        parafo.classList.add("esconder");

        linea[index - 1].classList.add("esconder");
    }
}
/*
//? Codigo del navbar
window.onscroll = function () { navScroll() };

function navScroll() {
    let navbar = document.getElementById("navbar");
    let nav_logo = document.getElementById("nav_logo");
    let content_bar = document.getElementById("content_bar");
    let shrink_ingresar = document.getElementById("shrink_ingresar");
    let ingresar = document.getElementById("ingresar");
    let logo_cont = document.getElementById("logo_principal");
    if (document.body.scrollTop > 80 || document.documentElement.scrollTop > 80) {
        content_bar.style.marginTop = "0%";
        nav_logo.innerHTML = "<img class='logo_img' src='img/logo_blanco.png'></img> "
        nav_logo.style.width = "5%";
        nav_logo.style.height = "5%";


        ingresar.classList.add("esconder");
        shrink_ingresar.innerHTML = "<a href='login.jsp' class='btn btn-primary'>Iniciar Sesión</a>";
        shrink_ingresar.classList.add("shrink_buttons");

    } else {

        nav_logo.innerHTML = "<img class='logo_img' src='img/logo/Logo-pincipal.png'></img> ";
        nav_logo.style.width = "4rem";
        
        shrink_ingresar.innerHTML = "";
        ingresar.classList.remove("esconder");
    }
}*/