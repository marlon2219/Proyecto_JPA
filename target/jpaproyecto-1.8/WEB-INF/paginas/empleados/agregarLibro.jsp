<div class="modal fade" id="agregarlibro">
    <div class="modal-dialog modal-md">
        <div class="modal-content">
            <div  style="background-image: linear-gradient(-20deg, #fc6076 0%, #ff9a44 100%); border: none;"  class="modal-header text-white">
                <h5 class="modal-title">AGREGAR LIBRO</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            <form style="padding: 30px; width: 500px" action="ControladorLibros?accion=insertar" method="POST">          
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
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>
            </form>
        </div>     
    </div>
</div>