<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/5c465338f1.js" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>gestor clientes</title>
        <style>
            body{
                background-color: #E4E9F7;
            }
            form{
                width: 500px;
                padding: 50px;
                border: 3px solid whitesmoke;
                border-radius: 3px;
                box-shadow: 10px 15px 10px 4px rgba(0, 0, 0, 0.1);
            }
            .container{
                display: flex;
                justify-content: space-around;
            }
        </style>
    </head>
    <body>


        <div class="container mt-4">
            <form class="was-validate" action="AdminServlet?accion=modificarEmpleado" method="POST">

                <input type="hidden" name="ide"  class="form-control" id="exampleInputEmail1" value="${empleadoEncontrado.idEmpleado}"  >
                <div class="mb-3">
                    <label  class="form-label">Nombre</label>
                    <input type="text" name="nombre"  class="form-control" id="exampleInputEmail1" value="${empleadoEncontrado.nombre}"  >

                </div>
                <div class="mb-3">
                    <label  class="form-label">Dni</label>
                    <input type="text" name="dni" class="form-control" id="exampleInputEmail1"  value="${empleadoEncontrado.dni}"  >

                </div>
                <div class="mb-3">
                    <label  class="form-label">Correo</label>
                    <input type="email" name="correo" class="form-control" id="exampleInputEmail1" value="${empleadoEncontrado.correo}"  >

                </div>
                <div class="mb-3">
                    <label  class="form-label">Telefono</label>
                    <input type="text" name="telefono" class="form-control" id="exampleInputEmail1"  value="${empleadoEncontrado.telefono}"  >

                </div>
                <div class="mb-3">
                    <label  class="form-label">Direccion</label>
                    <input type="text" name="direccion" class="form-control" id="exampleInputEmail1"  value="${empleadoEncontrado.direccion}"  >

                </div>
                <div class="mb-3">
                    <label class="form-label">Contrase?a</label>
                    <input type="text" name="contrasena" class="form-control" id="exampleInputPassword1" value="${empleadoEncontrado.contrasena}"  >
                </div>


                <section  id="actions" class="py-4 mb-4">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-6">
                                <button type="submit" class="btn btn-danger btn-block">
                                    GUARDAR
                                </button> 
                            </div>
                            <div  class="col-md-6 ">
                                <a href="vistaRoot.jsp" class="btn btn-danger  btn-block">
                                    VOLVER
                                </a>

                            </div>


                        </div>
                    </div>
                </section>
            </form>
            <img class="img-fluid" style="width:500px" src="img/logo.png">
        </div>



        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </body>
</html>
