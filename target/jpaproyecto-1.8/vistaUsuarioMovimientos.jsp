<%@page import="com.dominio.Usuarios"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

    HttpSession sesionn = request.getSession(false);
    Usuarios usu = (Usuarios) sesionn.getAttribute("usuario");


%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8" />
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="estilos.css" media="screen"/>
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
              integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf";
              crossorigin="anonymous">

        <title>Hello, world!</title>
    </head>
    <body>
          <!-- <jsp;include page="/WEB-INF/paginas/navUsuario.jsp"/> -->
        <!-- ESTE CODIGO SE PUEDE SUSTITUIR SI FUNCIONA EN ELACE DE ARRIBA -->
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
                                    <a  class="nav-link" aria-current="page" href="LibroServlet?accion=listarPorIdUsuario">Mis Libros</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link " aria-current="page" href="perfilUsuario.jsp" >Perfil</a>
                                </li><!-- comment -->
                                <li class="nav-item">
                                    <a href="#" class="nav-link" data-target="#agregarsaldo" data-toggle="modal" >
                                        Agregar Saldo <i class="fas fa-plus"></i>
                                    </a>
                                </li><!-- comment -->
                                 <li class="nav-item">
                                    <a class="nav-link " aria-current="page" href="MovimientosUsuarioServlet?accion=listarPorIdUs" >Movimientos</a>
                                </li>


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
                                    <form class="dropdown-item" method="POST" action="UsuarioServlet"> 
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

 <!-- **************************************HASTA AKI*********************************************************** -->
       <!-- MODAL PARA AGREGAR SALDO -->                         
        <div style=""  class="modal fade" id="agregarsaldo">
            <div class="modal-dialog ">
                <div style="width: 450px" class="modal-content">
                    <div style="background-color: #164956;" class="modal-header text-white">
                        <h5 class="modal-title">AGREGAR SALDO</h5>
                        <button class="close" data-dismiss="modal">
                            <span>&times;</span>
                        </button>
                    </div>
                    <form style="color: black" action="UsuarioServlet" method="POST"  class="m-3">
                       
                        <div class="mb-3">
                            <label >Catidad</label>
                            <input type="number" name="cantidad" class="form-control" id="exampleInputPassword1">
                        </div>
                      
                        <button type="submit" name="accion" value="ingresarSaldo" class="btn btn-primary">Submit</button>
                    </form>
                </div>     
            </div>
        </div>
       <!-- FINAL DEL MODAL (SE PUEDE QUITAR SI FUNCION LAS DIRECCIONES DE LAS CARPETAS) -->
    


    <!--BODY-->
    <table style="margin: auto" class="table">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Cantidad</th>
                <th scope="col">Accion</th>
                <th scope="col">Fecha</th>
               
            </tr>
        </thead>
        <tbody>
            <c:forEach var="datos" items="${datos}" varStatus="status">
             
                <tr>
                    <th>${status.count} </th>
                    <td>${datos.getCantidad()}</td>
                    <td>${datos.getAccion()}</td>
                    <td>${datos.getFecha()}</td>
                    <td>${datos.toString()}</td>
                    
                    
                    
                    
                </tr>
            </c:forEach>

        </tbody>

    </table>
    <!-- comment -->

    <!--BODY-->



    <div style="margin-bottom: 80px;" class="container">
        <div class="row">
            <div class="col-12 col-md-5">
                <div style="margin-top: 80px; width: 500px" class="portadalibro">
                    <h2 style=" color: whitesmoke">Orgullo y prejuicio</h2>
                </div>

            </div>
            <div class="col-12 col-md-7 form-group2">
                <p class="text-center"><img style="width: 550px;" src="img/ultnovedades.png"><br><br>Some quick example text to build on the card title and make up the bulk of the card's content Some quick example text to build on the card title and make up the bulk of the card's content Some quick example text to build on the card title and make up the bulk of the card's content<br> <button style="border-radius: 20px; width: 200px;" type="button" class="btn btn-danger mt-3">INFORMACÍON</button></p>  

            </div>
        </div>
    </div>

    <footer>
        <div style="background-color: #000000; border-top: 5px solid white;  " class="container-fluid  ">
            <div class="container ">

                <div class="row mx-auto  justify-content-center mt-3 ">
                    <div class="col-12 col-md-5">
                        <a href="#"><img style="width: 150px; " src="img/face.png"  alt="logo">  </a>
                        <a href="#"><img style="width: 150px; " src="img/google.png"  alt="logo">  </a>
                        <a href="#"><img style="width: 150px;  " src="img/insta.png"  alt="logo">  </a>
                        <br>
                        <div class="text-center">
                            <p>Advertise  |  About  |  Press  |  Contact</p>
                            <p>© 2020-2022 Cofalia Informática SL Todos los derechos reservados.</p>
                        </div>
                    </div>
                </div>

            </div> 
        </div>
    </footer>



</body>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-
        DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
crossorigin="anonymous"></script>


<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
        integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
crossorigin="anonymous"></script>

</body>
</html>



