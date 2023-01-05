<%-- 
    Document   : index
    Created on : 12 may. 2022, 17:37:11
    Author     : Pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
       <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="estilos.css" media="screen"/>
    <title>Hello, world!</title>
   
    </head>
    <body>

          <div style="height:40rem" class="container-fluid portada ">
            <nav class="nav ">
                <a class="nav-link active" aria-current="page" href="index.jsp">INCIO</a>
                <a class="nav-link" href="loginEmpleado.jsp">EMPLEADO</a>
                <a class="nav-link" href="formularioRegistro.jsp">REGISTRATE</a>
                <a class="nav-link" href="#">CONTACT</a>
              </nav>
          <div class="container">
            <div class="row justify-content-center"> 
             
              
                <form class="formulario mt-5" method="POST" action="UsuarioServlet">
                    <h1 style="color:white;">INCIAR SESIÓN</h1>
                    <div class="mt-3">
                      <label  class="form-label">Tu nombre</label>
                      <input type="text" class="form-control"  aria-describedby="emailHelp" name="txtusuario">
                      <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                    </div>
                    <div class="mb-3">
                      <label for="exampleInputPassword1" class="form-label">Contraseña</label>
                      <input type="password" class="form-control" id="exampleInputPassword1" name="txtpassword">
                    </div>
                    <div class="mb-3 form-check">
                      <input type="checkbox" class="form-check-input" id="exampleCheck1">
                      <label class="form-check-label" for="exampleCheck1">Check me out</label>
                    </div>
                    <button type="submit" name="accion" value="ingresar" class="btn btn-primary">Submit</button>
                    <a style="float: right" class="btn btn-danger" href="formularioRegistro.jsp">Registrate</a>
                  </form>
                
                

               
                 
            </div>
          </div>
      </div>
        
     

<!--sobre nosotros-->
      
<!--NUESTAS MARCAS-->

<footer>
    <div style="background-color: #000000; border-top: 5px solid white;  " class="container-fluid  ">
      <div class="container ">
      
        <div class="row mx-auto  justify-content-center mt-3 ">
          <div class="col-12 col-md-5">
          <a href="#"><img style="width: 150px;" src="img/face.png"  alt="logo"> </a>
          <a href="#"><img style="width: 150px;" src="img/google.png"  alt="logo"> </a>
          <a href="#"><img style="width: 150px;" src="img/insta.png"  alt="logo"> </a>
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
         

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    
 

        <!-- Optional JavaScript; choose one of the two! -->

        <!-- Option 1: Bootstrap Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

        <!-- Option 2: Separate Popper and Bootstrap JS -->
        <!--
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
        -->
    </body>
</html>

