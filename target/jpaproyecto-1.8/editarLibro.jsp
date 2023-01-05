<%-- 
    Document   : editarLibro
    Created on : 25 feb. 2022, 02:35:03
    Author     : Pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
            <form class="was-validate" action="LibroServlet?accion=procesoEditar" method="POST">

                <input type="hidden" name="ide"  class="form-control" id="exampleInputEmail1" value="${libroEncontrado.idlibro}"  >
                <div class="mb-3">
                    <label  class="form-label">Titulo</label>
                    <input type="text" name="titulo"  class="form-control" id="exampleInputEmail1" value="${libroEncontrado.titulo}"  >

                </div>
                <div class="mb-3">
                    <label  class="form-label">Autor</label>
                    <input type="text" name="autor" class="form-control" id="exampleInputEmail1"  value="${libroEncontrado.autor}"  >

                </div>
                <div class="mb-3">
                    <label  class="form-label">Categoria</label>
                    <input type="text" name="genero" class="form-control" id="exampleInputEmail1" value="${libroEncontrado.genero}"  >

                </div>
                <div class="mb-3">
                    <label  class="form-label">Páginas</label>
                    <input type="text" name="paginas" class="form-control" id="exampleInputEmail1"  value="${libroEncontrado.pagina}"  >

                </div>
                <div class="mb-3">
                    <label  class="form-label">Precio</label>
                    <input type="text" name="precio" class="form-control" id="exampleInputEmail1"  value="${libroEncontrado.precio}"  >

                </div>

                <section id="actions" class="py-4 mb-4 ">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-6">
                                <button type="submit" class="btn btn-danger btn-block">
                                    GUARDAR
                                </button> 
                            </div>
                            <div class="col-md-6">
                                <a href="ControladorLibros" class="btn btn-danger btn-block">
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

