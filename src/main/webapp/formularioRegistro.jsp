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
    

      
        <div  class="container-fluid portada  ">
           <nav class="nav ">
                <a class="nav-link active" aria-current="page" href="index.jsp">INCIO</a>
                <a class="nav-link" href="loginEmpleado.jsp">EMPLEADO</a>
                <a class="nav-link" href="formularioRegistro.jsp">REGISTRATE</a>
                <a class="nav-link" href="#">CONTACT</a>
              </nav>
          <div class="container ">
            <div class="row justify-content-center  "> 
             
              
                <form class="formulario mt-5" method="POST" action="UsuarioServlet">
                    <h1 style="color:white;">REGISTRATE</h1>
                    <div class="mt-3">
                      <label for="exampleInputEmail1" class="form-label">Tu nombre</label>
                      <input type="text" name="txtnombre" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                      <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                    </div>
                    <div class="mb-3">
                      <label for="exampleInputPassword1" class="form-label">N°Documento</label>
                      <input type="text" name="txtdocumento" class="form-control" id="exampleInputPassword1">
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputPassword1" class="form-label">Correo</label>
                        <input type="text" name="txtcorreo" class="form-control" id="exampleInputPassword1">
                      </div>
                     <div class="mb-3">
                        <label for="exampleInputPassword1" class="form-label">Direccion</label>
                        <input type="text" name="txtdireccion" class="form-control" id="exampleInputPassword1">
                      </div>
                     <div class="mb-3">
                        <label for="exampleInputPassword1" class="form-label">Teléfono</label>
                        <input type="text" name="txttelefono" class="form-control" id="exampleInputPassword1">
                     </div>
                      <div class="mb-3">
                        <label for="exampleInputPassword1" class="form-label">Contraseña</label>
                        <input type="password"  name="txtpass" class="form-control" id="exampleInputPassword1">
                      </div>
                      <div class="mb-3">
                        <label for="exampleInputPassword1" class="form-label">Saldo inicial</label>
                        <input type="text"  name="txtsaldo" class="form-control" id="exampleInputPassword1">
                      </div>
                    <button type="submit" name="accion" value="agregar" class="btn btn-primary">Submit</button>
                  </form>

               

               
                
            </div>
          </div>
      </div>
     

<!--sobre nosotros-->
      
<!--NUESTAS MARCAS-->

<footer>
        <div style="background-color: #000000; border-top: 5px solid white;  " class="container-fluid   ">
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
         

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    
  </body>
</html>