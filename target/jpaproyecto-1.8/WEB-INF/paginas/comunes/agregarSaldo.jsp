<div style=""  class="modal fade" id="agregarsaldo">
    <div class="modal-dialog ">
        <div style="width: 450px" class="modal-content">
            <div style="background-color: #164956;" class="modal-header text-white">
                <h5 class="modal-title">AGREGAR SALDO</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            <form style="color: black" action="Controlador?menu=usuario" method="POST"  class="m-3">
                <div class="mb-3">
                    <label >Usuario</label>
                    <input type="text" name="txtusuario" class="form-control"  >
                    <div id="emailHelp" class="form-text">Introduce el nombre con el que te registraste</div>
                </div>
                <div class="mb-3">
                    <label >Catidad</label>
                    <input type="number" name="cantidad" class="form-control" id="exampleInputPassword1">
                </div>
                <div class="mb-3">
                    <label>Password</label>
                    <input type="password" name="txtpassword" class="form-control" id="exampleInputPassword1">
                </div>
                <div class="mb-3 form-check">
                    <input type="checkbox" class="form-check-input" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1">Check me out</label>
                </div>
                <button type="submit" name="accion" value="IngresarSaldo" class="btn btn-primary">Submit</button>
            </form>
        </div>     
    </div>
</div>
