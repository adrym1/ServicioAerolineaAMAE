fecha();
reloj();





function fecha() {
    let fecha = new Date();
    let d = fecha.getDate();
    let m = fecha.getMonth() + 1;
    let y = fecha.getFullYear();

    document.getElementById("pf").innerText = "Fecha actual : " + d + "/" + m + "/" + y;

}

function reloj() {
    let fecha = new Date();

    let h = fecha.getHours();
    let m = fecha.getMinutes();
    let s = fecha.getSeconds();


    document.getElementById("ph").innerHTML = "Hora actual : " + h + ":" + m + ":" + s;
    setTimeout("reloj()", 1000);
}