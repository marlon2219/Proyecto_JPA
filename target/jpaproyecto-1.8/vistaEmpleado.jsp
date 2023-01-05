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
            <a href="vistaEmpleadoGenerarVenta.jsp" class="nav-link " >
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
                    <div class="col-md-9">
                        <div class="card-header">
                            <h4>LISTA DE TODOS LOS LIBROS</h4>
                        </div>

                        <table class="table table-striped">
                            <thead class="thead-dark">
                                <tr>
                                    <th>REF</th>
                                    <th>Titulo</th>
                                    <th>Autor</th>
                                    <th>Categoria</th>
                                    <th>Paginas</th>
                                    <th>Precio</th>

                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach var="libro" items="${libros}" varStatus="status">
                                    <tr>
                                        <td>${libro.idlibro}</td> <!-- libro.count -> ceunta el numero de filas, otra forma de poner el id -->
                                        <td>${libro.titulo}</td>
                                        <td>${libro.autor}</td>
                                        <td>${libro.genero}</td>
                                        <td>${libro.pagina}</td>
                                        <td>${libro.precio}</td>
                                       
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>
                    <div class="col-md-3 ">
                        
                        <div style="background-image: linear-gradient(-20deg, #fc6076 0%, #ff9a44 100%); border: none;" class="card text-center bg-success text-white mb-3">
                            <div class="card-body">
                                <h1>Numero de Libros</h1>
                                <h4 class="display-4">
                                    <i class="fas fa-users"></i> 

                                </h4>
                            </div>
                        </div>
                                    <div style="background-color: #164956;" class="card text-center  text-white mb-3">
                            <div class="card-body">
                                
                                <h1 class="display-4">
                                   ${totLibros}
                                </h1>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>













        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </body>
</html>

