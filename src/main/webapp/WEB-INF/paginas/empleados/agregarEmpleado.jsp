<div   class="modal fade" id="agregarClienteModal">
    <div style="border: none" class="modal-dialog modal-md">
        <div class="modal-content">
            <div style="background-image: linear-gradient(-20deg, #fc6076 0%, #ff9a44 100%); border: none;" class="modal-header text-white">
                <h5 class="modal-title">AGREGAR EMPLEADO</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            <form style="padding: 30px; width: 500px" action="ControladorEmpleados?accion=insertar" method="POST">
                      
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