function esconderNav() {
    let navContent = document.getElementById("navVe-content");
    let asideContent = document.getElementById("aside-content");
    let rightContent = document.getElementById("right-content");
    if (navContent.style.width == "55px") {
        navContent.style.width = "20%";
        navContent.style.overflowX = "auto";
        asideContent.style.width = '20%';
        asideContent.style.transition = '0.5s';
        rightContent.style.width = "80%";
		
    } else {
        navContent.style.transition = "0.5s";
        navContent.style.width = "55px";
        asideContent.style.width = '4%';
        asideContent.style.transition = '0.5s';
        navContent.style.overflowX = "hidden";
        rightContent.style.width = "95%";
    }
    R_Img_User();
    R_nombre_User();
    R_button_arrow();
    R_User();
    R_superiorContent();
    R_detalle();
    //R_menus();
    R_cerrar();
    R_icons_menus();
}

function R_Img_User() {
    let foto_usu = document.getElementById("foto_usu");
    if (foto_usu.style.width == "3rem" || foto_usu.style.height == "3rem") {
        foto_usu.style.width = "8rem";
        foto_usu.style.height = "8rem";
        foto_usu.style.border = "5px solid black";
        foto_usu.style.transition = "0.5s";
    } else {
        foto_usu.style.border = "2px solid black";
        foto_usu.style.width = "3rem";
        foto_usu.style.height = "3rem";
        foto_usu.style.transition = "0.5s";
    }
}
function R_nombre_User() {
    let nombre_usu = document.getElementById("nombre_usu");
    if (nombre_usu.classList.contains("quitar")) {
        nombre_usu.classList.remove("quitar");
    } else {
        nombre_usu.classList.add("quitar");
        nombre_usu.style.transition = "0.2s";
    }
}
function R_button_arrow() {
    let chevron = document.getElementById("chevron_direction");
    let button_respon = document.getElementById("arrow-respon");

    if (button_respon.style.fontSize == "0.5rem") {
        chevron.innerHTML = '<i class="bi bi-chevron-double-left" id="arrow-respon"></i >';
        chevron.style.fontSize = '0.5rem';

    } else {
        button_respon.style.fontSize = "0.5rem";
        chevron.innerHTML = '<i class="bi bi-chevron-double-right" id="arrow-respon"></i>';
        chevron.style.fontSize = '0.5rem';
    }
}
function R_User() {
    let nav_user = document.getElementsByClassName("nav-usu-content");
    if (nav_user[0].style.height == "15%") {
        nav_user[0].style.height = "30%";
    } else {
        nav_user[0].style.height = "15%"
    }
}
function R_superiorContent() {
    let superior_content = document.getElementsByClassName("superior-content");
    if (superior_content[0].style.paddingLeft == "66px") {
        superior_content[0].style.paddingLeft = "0"
    } else {
        superior_content[0].style.paddingLeft = "66px"
    }
}

function R_detalle() {
    let nombre_link = document.getElementsByClassName("nombre-link");
    if (nombre_link[0].classList.contains("quitar")) {
        for (i = 0; i < nombre_link.length; i++) {
            nombre_link[i].classList.remove("quitar");
        }
    } else {
        for (i = 0; i < nombre_link.length; i++) {
            nombre_link[i].classList.add("quitar");
        }
    }
}

function R_menus() {
    let menus = document.getElementsByClassName("menu_link");
    for (var i = 0; i <= menus.length; i++) {
        if (menus[i].classList.contains("quitar")) {
            menus[i].classList.remove("quitar");
        } else {
            menus[i].classList.add("quitar");
        }
    }
}

function R_cerrar() {
    let btn_cerrar = document.getElementsByName("btn_cerrar");
     let cont = document.getElementsByClassName("parte-final");
    let icon = document.getElementsByClassName("ico_cerrar");
    let text = document.getElementsByClassName("text_cerrar");
    if (!text[0].classList.contains("quitar")) {
        text[0].classList.add("quitar");
         text[1].classList.add("quitar");
        cont[0].style.flexDirection = "column";
        //btn_cerrar[0].classList.padding = "9px";
        //btn_cerrar[0].classList.JustifyContent = "center";
    } else {
		cont[0].style.flexDirection = "row";
        text[0].classList.remove("quitar");
        text[1].classList.remove("quitar");
    }
}

function R_icons_menus() {

    var icons = document.getElementsByClassName("resp_icons");
    for (var i = 0; i < icons.length; i++) {

        icons[i].style.justifyContent = "center";
    }
}


/*! Parte de submenus*/
function esconderSubs(index) {
    let submenus = document.getElementsByClassName("submenus");
    if (submenus[index].classList.contains("quitar")) {
        submenus[index].classList.remove("quitar");
        submenus[index].classList.add("abrir");
        submenus[index].style.transition = "2s";
    } else {
        submenus[index].classList.add("quitar");
        submenus[index].classList.remove("abrir");
        submenus[index].style.transition = "2s";
    }
}   
