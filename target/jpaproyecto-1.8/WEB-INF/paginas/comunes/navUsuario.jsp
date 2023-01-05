<section>
    <div style="height:35rem" class="container-fluid portada ">
        <nav class="navbar navbar-expand-lg navbar-dark ">
            <div class="container-fluid">
                <a class="navbar-brand" href="vistaUsuario.jsp"><img class="img-fluid" style="width:70px" src="img/logo.png"></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link " aria-current="page" href="vistaUsuario.jsp">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a  class="nav-link " aria-current="page" href="LibroServlet?accion=listar">Libros</a>
                        </li>
                        <li class="nav-item">
                            <a  class="nav-link" aria-current="page" href="ControladorVentas?accion=misLibros">Mis Libros</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link " aria-current="page" href="perfilUsuario.jsp" >Perfil</a>
                        </li><!-- comment -->
                        <li class="nav-item">
                            <a href="#" class="nav-link" data-target="#agregarsaldo" data-toggle="modal" >
                                Agregar Saldo <i class="fas fa-plus"></i>
                            </a>
                        </li><!-- comment -->


                    </ul>  

                    <div class="btn-group">
                        <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            ${usuario.getNombre()}
                        </button>
                        <div class="dropdown-menu" >
                            <a class="dropdown-item" href="#"> <i class="fas fa-user" ></i></a>
                            <a class="dropdown-item" href="#">${usuario.getDni()}</a>
                            <a class="dropdown-item" href="#">${usuario.getCorreo()}</a>
                            <a class="dropdown-item" href="#">${usuario. getSaldo()}$</a>
                            <div class="dropdown-divider"></div>
                            <form class="dropdown-item" method="POST" action="Validar"> 
                                <button class="btn btn-danger center-block" type="submit" name="accion" value="cerrarSesion">Cerra sesión</button>
                            </form>
                        </div>
                    </div>
                </div>
        </nav>
        <div class="container ">
            <div class="row justify-content-center  "> 

                <div class=" form-group col-12 col-md-8   ">
                    <p class="text-center texto"><img style="width: 500px;" class="imagenLogoPortada" src="img/bookx.png" alt="booker" ><br>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s </p>  
                </div>
            </div>
        </div>
    </div>
</section>
                             <jsp:include page="/WEB-INF/paginas/agregarSaldo.jsp"/>
