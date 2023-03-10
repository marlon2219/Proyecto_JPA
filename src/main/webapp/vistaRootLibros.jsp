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
        <link rel="stylesheet" href="estilos2.css">
        <!-- Bootstrap CSS -->
        <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <title>VISTA ROOT</title>
        <style>
           
        </style>
    </head>
    <body>
         <!-- <jsp;include page="/WEB-INF/paginas/comunes/botonesNavegacion.jsp"/> -->
        <!-- ESTE CODIGO SE PUEDE ELIMINAR SI FUNCIONA EL ENALCE -->
        <div class="sidebar close">
            <div class="logo-details m-1">
                <img class="img-fluid" style="width:70px" src="img/logo.png">
                <span class="logo_name m-2">Adminitrador</span>
            </div>
            <ul class="nav-links">
                <li>
                    <a href="#" class="nav-link "  data-target="#agregarClienteModal" data-toggle="modal" >
                        <i class='bx bx-grid-alt'></i>
                        <span class="link_name">Agregar empleados</span>
                    </a>
                </li>
                <li>
                    <a href="AdminServlet?accion=listarEmpleados" class="nav-link">
                        <i class='bx bx-grid-alt'></i>
                        <span class="link_name">Cargar empleados</span>
                    </a>
                </li>
                <li>
                    <a href="AdminServlet?accion=listarUsuarios" class="nav-link "  >
                        <i class='bx bx-grid-alt'></i>
                        <span class="link_name">Cargar usuarios</span>
                    </a>
                </li>
                <li>
                    <a href="AdminServlet?accion=listarLibrosHasUsuarios" class="nav-link "  >
                        <i class='bx bx-grid-alt'></i>
                        <span class="link_name">Libros guardados</span>
                    </a>
                </li>
                <li>
                    <a href="AdminServlet?accion=listarCompraVentas" class="nav-link "  >
                        <i class='bx bx-grid-alt'></i>
                        <span class="link_name">Cargar ventas</span>
                    </a>
                </li>
                <li>
                    <a href="AdminServlet?accion=listarLibros" class="nav-link "  >
                        <i class='bx bx-grid-alt'></i>
                        <span class="link_name">Cargar libros</span>
                    </a>
                </li>
                <li>
                    <a href="AdminServlet?accion=cerrarSesionRoot" class="nav-link  btn-danger" >
                        <i class='bx bx-grid-alt'></i>
                        <span class="link_name">Cerrar Sesi??n</span>
                    </a>
                </li>

            </ul>
        </div>

        <!-- ***********************HASTA AKI************************************* -->


         <section class="home-section">
            <div class="home-content">
                <i class='bx bx-menu'></i>
                <span class="text">BOOKX</span>
            </div>
            <div  class="container-fluid mt-5">
                <div class="row">
                    <div class="col-12 col-md-12">
                        <!--AKI LA TABLA-->
                        <div class="card-header">
                            <h4>Libros</h4>
                        </div>

                        <table class="table table-striped">
                            <thead class="thead-dark">
                                <tr>
                                   <th>Ref</th>
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
                                <td>${libro.idlibro}</td> <!-- ceunta el numero de filas, otra forma de poner el id -->
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
                    
                </div>

            </div>

        </section>




       <!-- agregamos el modal de agregar cleinte -->
        <!-- <jsp;include page="/WEB-INF/paginas/empleados/agregarEmpleado.jsp"/>-->
        
        
        <!-- MODAL PARA AGREGAR EMPLEADO -->
        <div   class="modal fade" id="agregarClienteModal">
            <div style="border: none" class="modal-dialog modal-md">
                <div class="modal-content">
                    <div style="background-image: linear-gradient(-20deg, #fc6076 0%, #ff9a44 100%); border: none;" class="modal-header text-white">
                        <h5 class="modal-title">AGREGAR EMPLEADO</h5>
                        <button class="close" data-dismiss="modal">
                            <span>&times;</span>
                        </button>
                    </div>
                    <form style="padding: 30px; width: 500px" action="AdminServlet?accion=insertarEmpleado" method="POST">

                        <div class="modal-body">
                            <div class="form-group">
                                <label for="nombre">Nombre</label>
                                <input class="form-control" type="text" name="nombre" required/>
                            </div>
                            <div class="form-group">
                                <label for="dni">Dni</label>
                                <input class="form-control" type="text" name="dni" required/>
                            </div>
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input class="form-control" type="email" name="correo" required/>
                            </div>
                            <div class="form-group">
                                <label for="telefono">Telefono</label>
                                <input class="form-control" type="tel" name="telefono"/>
                            </div>
                            <div class="form-group">
                                <label for="saldo">Direcci??n</label>
                                <input class="form-control" type="text" name="direccion" required/>
                            </div>
                            <div class="form-group">
                                <label for="saldo">Contrase??a</label>
                                <input class="form-control" type="password" name="contrasena" required/>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button class="btn btn-primary" type="submit">Guardar</button>
                        </div>
                    </form>

                </div>     
            </div>
        </div>
        <!-- ***************************************************HASTA AKI ************************************************ -->


        <!-- SCRIPTS -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

  <script>
    let arrow = document.querySelectorAll(".arrow");
    for (var i = 0; i < arrow.length; i++) {
      arrow[i].addEventListener("click", (e) => {
        let arrowParent = e.target.parentElement.parentElement;//selecting main parent of arrow
        arrowParent.classList.toggle("showMenu");
      });
    }
    let sidebar = document.querySelector(".sidebar");
    let sidebarBtn = document.querySelector(".bx-menu");
    console.log(sidebarBtn);
    sidebarBtn.addEventListener("click", () => {
      sidebar.classList.toggle("close");
    });
  </script>

  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </body>
</html>


