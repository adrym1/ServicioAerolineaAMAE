<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagina Principal</title>
  <link rel="icon" href="img/logo/Logo-sinfondo.png">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="css/estilosPaginaPrincipal.css">
      <link rel="stylesheet" href="css/estilosPrincipal.css">


     <!--BANNER-->
     <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    
      <!--CARDS-->
<link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />


<!-- Demo styles -->
<style>
  
  .swiper {

    width: 100%;
    padding-top: 40px;
    padding-bottom: 60px;
    z-index:  0;
  }

  .swiper-slide {
  
    background-color: greenyellow;
    background-position: center;
    background-size: cover;
    width: 20%;
    height: 450px;
  }

  .swiper-slide img {
    display: block;
    width: 90%;
    height: 370px;
    object-fit:  fill;
  }
  .swiper-slide p {
  font-size: 28pt;
  font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
  }
  </style>





</head>

<body>

  <header>
        <nav class="nav_bar" id="navbar">
            <a class="logo_link" id="nav_logo" href="PaginaPrincipal.jsp"><img class="logo_img" id="logo_principal"
                    src="img/logo/logo_sin_fondo.png" alt=""></a>
            <div class="content_bar" id="content_bar">
					<a class="nav_enlace" href="PaginaPrincipal.jsp">Inicio</a>
                <a class="nav_enlace" href="pagina_ofertas.html">Ofertas</a>
                <a class="nav_enlace" href="PreguntasPrincipal.jsp">Reglamento y Preguntas Frecuentes</a>
                

            </div>
            <div class="ingresar" id="ingresar">
                <a href="login.jsp" class="btn btn-primary">Iniciar Sesión</a>

            </div>
            <div id="shrink_ingresar"></div>
        </nav>
    </header>

    <div id="content" >
         
        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
              <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                   <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
                       <li data-target="#carouselExampleIndicators" data-slide-to="4"></li>
            </ol>
            <div class="carousel-inner">
              <div class="carousel-item active">
                <img class="d-block  " src="img/banner1.jpg" alt="First slide">
              </div>
              <div class="carousel-item">
                <img class="d-block " src="img/banner2.jpg" alt="Second slide" >
              </div>
              <div class="carousel-item">
                <img class="d-block " src="img/banner3.jpg" alt="Third slide">
              </div>
                  <div class="carousel-item">
                <img class="d-block " src="img/banner4.jpg" alt="Third slide">
              </div>
                   <div class="carousel-item">
                <img class="d-block " src="img/banner5.jpg" alt="Third slide">
              </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="sr-only">Next</span>
            </a>
          </div>


          <br><br><br>

    <center><h2 class="subtitulo">"ULTIMAS NOTICIAS"</h2></center>

    	<!--   Tarjetas-->
<div class="title-cards">
  <h2>TOME SUS PRECAUCIONES ANTES DE VIAJAR</h2>
</div>
<div class="container-card">

<div class="card">
<figure>
  <img src="img/noticia1.jpg">
</figure>
<div class="contenido-card">
  <h3>Viruela del Mono</h3>
  <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, wmbled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic</p>
  <a href="#">Leer Màs</a>
</div>
</div>
<div class="card">
<figure>
  <img src="img/noticia4.jpg">
</figure>
<div class="contenido-card">
  <h3>Covid 19</h3>
  <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, wmbled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic</p>

  <a href="#">Leer Màs</a>
</div>
</div>
<div class="card">
<figure>
  <img src="img/noticia3.jpg">
</figure>
<div class="contenido-card">
  <h3>Guerra entre Ucrania y Rusia</h3>
  <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, wmbled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic</p>

  <a href="#">Leer Màs</a>
</div>
</div>
</div>
<br><br>
<div class="container-card">

  <div class="card">
  <figure>
    <img src="img/noticia6.jpeg">
  </figure>
  <div class="contenido-card">
    <h3>Elecciones presidenciales de Brasil</h3>
    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, wmbled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic</p>
    <a href="#">Leer Màs</a>
  </div>
  </div>
  <div class="card">
  <figure>
    <img src="img/noticia7.jpg">
  </figure>
  <div class="contenido-card">
    <h3>¿Buscas mudarte a otro pais?</h3>
    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, wmbled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic</p>
    <a href="#">Leer Màs</a>
  </div>
  </div>
  <div class="card">
  <figure>
    <img src="img/noticia8.jpg">
  </figure>
  <div class="contenido-card">
    <h3>Estampida en Seúl deja más de 150 muertos</h3>
    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, wmbled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic</p>
    <a href="#">Leer Màs</a>
  </div>
  </div>
  </div>
<!--Fin   Tarjetas-->
    
<br><br><br><br>
    <center><h2 class="subtitulo">"LUGARES PARA VIAJAR"</h2></center>
          
    <div class="swiper mySwiper "  >
    
        <div class="swiper-wrapper">
          <div class="swiper-slide">
          <center><p  >Machu Picchu   <img src="img/card1.jpg" /></p></center>
          </div>
          <div class="swiper-slide">
            <center><p  >Torre Eiffel  <img src="img/card2.jpg" /></p></center>
            <p></p>
          </div>
          <div class="swiper-slide">
            <center><p  >Venecia   <img src="img/card3.jpg" /></p></center>
          </div>
          <div class="swiper-slide">
            <center><p  >El Templo de Kukulcán   <img src="img/card4.jpg" /></p></center>
          </div>
          <div class="swiper-slide">
            <center><p  >Sidney  <img src="img/card5.jfif" /></p></center>
          </div>
          <div class="swiper-slide">
            <center><p>Punta Cana  <img src="img/card6.jpg" /></p></center>
          </div>
          <div class="swiper-slide">
            <center><p  >DisneyLand   <img src="img/card7.jpg" /></p></center>
          </div>
          <div class="swiper-slide">
            <center><p  >Qatar  <img src="img/card8.jpg" /></p></center>
          </div>
         
        </div>
        <div class="swiper-pagination"></div>
      </div>
    
              
    <!-- Swiper JS -->
    <script src="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.js"></script>
    
    <!-- Initialize Swiper -->
    <script>
      var swiper = new Swiper(".mySwiper", {
        effect: "coverflow",
        grabCursor: true,
        centeredSlides: true,
        slidesPerView: "auto",
        coverflowEffect: {
          rotate: 50,
          stretch: 0,
          depth: 100,
          modifier: 1,
          slideShadows: true,
        },
        pagination: {
          el: ".swiper-pagination",
        },
      });
    
    
    </script>
    <script src="js/js.js"></script>
</div>

   <footer>
        <div class="foot_general">
            <div class="col_izq">
                <img class="foot_logo" src="../img/logo_sin_fondo.png" alt="Logo">
            </div>
            <div class="centro">
                <div class="foot_enlaces_izq">
                    <a href="PreguntasPrincipal.jsp">Inicio</a>
                    <a href="pagina_ofertas.html">Ofertas</a>
                </div>
                <div class="foot_enlaces_dere">
                    <a href="PreguntasPrincipal.jsp">Preguntas y Respuestas</a>
                </div>


            </div>
            <div class="col_dere">
                <div class="foot_numero">
                    <h5>Numero de contacto</h5>
                    <a href="">001-4562-7895</a>
                </div>
                <div class="foot_redes">
                    <a href=""><i class="bi bi-facebook"></i></a>
                    <a href=""><i class="bi bi-twitter"></i></a>
                    <a href=""><i class="bi bi-youtube"></i></a>
                    <a href=""><i class="bi bi-line"></i></a>
                </div>
            </div>
        </div>
    </footer>
</body>

<script src="js/MenuPaginaPrincipal.js"></script>

</html>