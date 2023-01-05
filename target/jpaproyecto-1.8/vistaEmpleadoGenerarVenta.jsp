<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_Es"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">


        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <title>VISTA EMPLEADO</title>
        <style>
            .nav{

                display: flex;
                justify-content:space-around;
                width: 100%;


            }
            .nav a:hover{
                background: rgba(255, 255, 255, 0.96);

            }
            .nav a{
                padding: 15px ;
                width: 33.2%;
                text-align : center;
                font-size : 20px;


            }
            .nav-link{
                color: white;
            }
            .formulario{
                padding: 50px;
                margin: auto;
                border-radius: 30px;
                background-image: linear-gradient(to top, #f43b47 0%, #453a94 100%);
                width: 500px;
                box-shadow: 2px 2px 20px 8px rgba(0, 0, 0, 0.2);
            }

        </style>
    </head>
    <body>
        <!-- <jsp;include page="/WEB-INF/paginas/comunes/botonesNavegacionLibros.jsp"/> -->

        <!-- ESTE CODIGO SE PUEDE QUITAR SI FUNCIONA EN ELACE DE LOS BOTES DE ARRIBA -->
        <nav  class="nav bg-dark mb-5 ">
            <a href="EmpleadoServlet?accion=listar" class="nav-link " >
                <i class="fas fa-plus"></i> Libros
            </a>
            <a href="#" class="nav-link " data-target="#agregarlibro" data-toggle="modal" >
                <i class="fas fa-plus"></i> Agregar Libro
            </a>
            <a href="EmpleadoServlet?accion=listarPorIdEmpleado" class="nav-link " >
                <i class="fas fa-plus"></i> Tus libros
            </a>
            <a href="EmpleadoServlet?accion=listar" class="nav-link " >
                <i class="fas fa-plus"></i> Generar venta
            </a>
            <a href="EmpleadoServlet?accion=cerrarSesion" class="nav-link " >
                <i class="fas fa-plus"></i> Cerrar Sesión
            </a>

        </nav>


        <!-- MOADAL AGREGAR LIBRO -->

        <div class="modal fade" id="agregarlibro">
            <div class="modal-dialog modal-md">
                <div class="modal-content">
                    <div  style="background-image: linear-gradient(-20deg, #fc6076 0%, #ff9a44 100%); border: none;"  class="modal-header text-white">
                        <h5 class="modal-title">AGREGAR LIBRO</h5>
                        <button class="close" data-dismiss="modal">
                            <span>&times;</span>
                        </button>
                    </div>
                    <form style="padding: 30px; width: 500px" action="LibroServlet" method="POST">          
                        <div class="modal-body">
                            <div class="form-group">
                                <label for="nombre">Titulo</label>
                                <input class="form-control" type="text" name="titulo" required/>
                            </div>
                            <div class="form-group">
                                <label for="dni">Autor</label>
                                <input class="form-control" type="text" name="autor" required/>
                            </div>
                            <div class="form-group">
                                <label for="dni">Categoria</label>
                                <input class="form-control" type="text" name="genero" required/>
                            </div>
                            <div class="form-group">
                                <label for="telefono">N°Paginas</label>
                                <input class="form-control" type="text" name="paginas"/>
                            </div>
                            <div class="form-group">
                                <label for="saldo">Precio</label>
                                <input class="form-control" type="text" name="precio" required/>
                            </div>

                        </div>
                        <div class="modal-footer">
                            <button class="btn btn-primary" name="accion" value="ingresarLibroDesdeEmpleado" type="submit">Guardar</button>
                        </div>
                    </form>
                </div>     
            </div>
        </div>

        <!-- ****************************************HASTA AKI******************************************* -->

        <section id="clientes">
            <div class="container">
                <div class="row">
                    <div class="card-header">
                        <h4>GENERAR VENTA</h4>
                    </div>
                    <div style="margin-top:150px" class="col-md-6">

                        <button style="border:none ;background-color: white">
                            <a href="#" class="nav-link " data-target="#agregarventa" data-toggle="modal" >
                                <i class="fas fa-plus"></i> 

                                <div style="background-image: linear-gradient(-20deg, #fc6076 0%, #ff9a44 100%); border: none;" class="card text-center  text-white mb-3">
                                    <div class="card-body">
                                        <h2>EL CLIENTE YA TIENE CUENTA</h2>
                                        <h4 class="display-4"> <ion-icon name="person"></ion-icon>
                                            <i class="fas fa-users"></i> 

                                        </h4>
                                    </div>
                                </div>
                            </a>
                        </button>

                    </div>
                    <div style="margin-top:150px" class="col-md-6">

                        <!--AKI LOS CARDS -->
                        <button style="border:none ;background-color: white">
                            <a href="#" class="nav-link " data-target="#registrarUsuario" data-toggle="modal" >
                                <div style="background-image: linear-gradient(-20deg, #fc6076 0%, #ff9a44 100%); border: none;" class="card text-center  text-white mb-3">
                                    <div class="card-body">
                                        <h2>REGISTRATE GRATIS EN 1MIN</h2>
                                        <h4 class="display-4"> <ion-icon name="push"></ion-icon>
                                            <i class="fas fa-users"></i> 

                                        </h4>
                                    </div>
                                </div>
                            </a>
                        </button>
                    </div>

                </div>
            </div>
        </section>


        <!-- MODAL PARA USUARIO YA TIENE CUENTA -->



        <div class="modal fade" id="agregarventa">
            <div class="modal-dialog modal-md">
                <div class="modal-content">
                    <div  style="background-image: linear-gradient(-20deg, #fc6076 0%, #ff9a44 100%); border: none;"  class="modal-header text-white">
                        <h5 class="modal-title">VENTA</h5>
                        <button class="close" data-dismiss="modal">
                            <span>&times;</span>
                        </button>
                    </div>
                    <form style="padding: 30px; width: 500px" action="EmpleadoServlet?accion=generarVenta" method="POST">          
                        <div class="modal-body">
                            <div class="form-group">
                                <label for="nombre">CÓDIGO USUARIO</label>
                                <input class="form-control" type="text" name="codUsuario" required/>
                            </div>
                            <div class="form-group">
                                <label for="dni">CÓDIGO LIBRO</label>
                                <input class="form-control" type="text" name="codLibro" required/>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button class="btn btn-primary" name="accion" value="generarVenta" type="submit">Generar</button>
                        </div>
                    </form>
                </div>     
            </div>
        </div>


        <!-- ************************************* -->


        <!-- MODAL PARA REGISTRAR USUARIO -->

        <div class="modal fade" id="registrarUsuario">
            <div class="modal-dialog modal-md">
                <div class="modal-content">
                    <div  style="background-image: linear-gradient(-20deg, #fc6076 0%, #ff9a44 100%); border: none;"  class="modal-header text-white">
                        <h5 class="modal-title">REGISTRO</h5>
                        <button class="close" data-dismiss="modal">
                            <span>&times;</span>
                        </button>
                    </div>
                    <form style="padding: 30px; width: 500px" action="EmpleadoServlet?accion=registrarUsuarioDesdeEmpleado" method="POST">          
                        <div class="modal-body">
                            <div class="form-group">
                                <label for="exampleInputEmail1" class="form-label">Tu nombre</label>
                                <input type="text" name="txtnombre" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1" class="form-label">N°Documento</label>
                      <input type="text" name="txtdocumento" class="form-control" id="exampleInputPassword1">
                            </div>
                             <div class="form-group">
                                <label for="exampleInputPassword1" class="form-label">Correo</label>
                        <input type="text" name="txtcorreo" class="form-control" id="exampleInputPassword1">
                            </div>
                             <div class="form-group">
                                 <label for="exampleInputPassword1" class="form-label">Direccion</label>
                        <input type="text" name="txtdireccion" class="form-control" id="exampleInputPassword1">
                            </div>
                             <div class="form-group">
                               <label for="exampleInputPassword1" class="form-label">Teléfono</label>
                        <input type="text" name="txttelefono" class="form-control" id="exampleInputPassword1">
                            </div>
                             <div class="form-group">
                                <label for="exampleInputPassword1" class="form-label">Contraseña</label>
                        <input type="password"  name="txtpass" class="form-control" id="exampleInputPassword1">
                            </div>
                             <div class="form-group">
                                 <label for="exampleInputPassword1" class="form-label">Saldo inicial (50$ POR REGISTRARTE!)</label>
                                 <input type=»text» readonly=»readonly»  name="txtsaldo" value="50" class="form-control" id="exampleInputPassword1">
                            </div>
                            
                        </div>
                        <div class="modal-footer">
                            <button class="btn btn-primary" name="accion"  type="submit">Registrar</button>
                        </div>
                    </form>
                </div>     
            </div>
        </div>




        <!-- ************************************* -->









        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </body>
</html>


