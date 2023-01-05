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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <title>VISTA ROOT</title>

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
                        <span class="link_name">Cerrar Sesión</span>
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
            <div  class="container mt-5">
                <div class="row">
                    <div class="col-12 col-md-9">
                        <nav  style="float: right" class="navbar ">
                            <div class="container-fluid">
                                <form action="AdminServlet" method="POST" class="d-flex">
                                    <input class="form-control me-2" name="busqueda" type="search" placeholder="Nombre o Dni" aria-label="Search">
                                    <button class="btn btn-outline-success" type="submit" name="accion" value="listarBusqueda">Buscar/Todos</button>
                                </form>
                            </div>
                        </nav>
                        <!--AKI LA TABLA-->
                        <div class="card-header mb-4">
                            <h4>Listado De Empleados</h4>

                        </div>

                        <table class="table table-striped">
                            <thead class="thead-dark">
                                <tr>
                                    <th>N°</th>
                                    <th>Nombre</th>
                                    <th>Dni</th>
                                    <th>Correo</th>
                                    <th>Telefono</th>
                                    <th>Dirección</th>
                                    <th>Contraseña</th>
                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach var="empleado" items="${empleados}" varStatus="status">
                                    <tr>
                                        <td>${status.count}</td> <!-- ceunta el numero de filas, otra forma de poner el id -->
                                        <td>${empleado.nombre}</td>
                                        <td>${empleado.dni}</td>
                                        <td>${empleado.correo}</td>
                                        <td>${empleado.telefono}</td>
                                        <td>${empleado.direccion}</td>
                                        <td>${empleado.contrasena}</td>
                                        <td>
                                            <a href="AdminServlet?accion=editar&idEmpleado=${empleado.idEmpleado}" class="btn btn-outline-warning">
                                                <i class="fas fa-angle-double-right"></i> Editar
                                            </a>
                                            <a href="AdminServlet?accion=eliminar&idEmpleado=${empleado.idEmpleado}" class="btn btn-danger btn-block mt-1" >
                                                <i class="fas fa-trash"></i> Eliminar
                                            </a>
                                        </td>

                                    </tr>
                                </c:forEach>
                                     <c:forEach var="empleado" items="${busquedaEmple}" varStatus="status">
                                    <tr>
                                        <td>${status.count}</td> <!-- ceunta el numero de filas, otra forma de poner el id -->
                                        <td>${empleado.nombre}</td>
                                        <td>${empleado.dni}</td>
                                        <td>${empleado.correo}</td>
                                        <td>${empleado.telefono}</td>
                                        <td>${empleado.direccion}</td>
                                        <td>${empleado.contrasena}</td>
                                        <td>
                                            <a href="AdminServlet?accion=editar&idEmpleado=${empleado.idEmpleado}" class="btn btn-outline-warning">
                                                <i class="fas fa-angle-double-right"></i> Editar
                                            </a>
                                            <a href="AdminServlet?accion=eliminar&idEmpleado=${empleado.idEmpleado}" class="btn btn-danger btn-block mt-1" >
                                                <i class="fas fa-trash"></i> Eliminar
                                            </a>
                                        </td>

                                    </tr>
                                </c:forEach>


                            </tbody>
                        </table>
                    </div>
                    <div class="col-12 col-md-3">
                        <!--AKI LOS CARDS -->
                        <div style="background-image: linear-gradient(-20deg, #fc6076 0%, #ff9a44 100%); border: none;"  class="card text-center text-white mb-3">
                            <div class="card-body">
                                <h1>Total Empleados</h1>
                                <h4 class="display-4">
                                    <i class="fas fa-users"></i> ${empleados.size()}  ${busquedaEmple.size()} 

                                </h4>
                            </div>
                        </div>
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
                                <label for="saldo">Dirección</label>
                                <input class="form-control" type="text" name="direccion" required/>
                            </div>
                            <div class="form-group">
                                <label for="saldo">Contraseña</label>
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

