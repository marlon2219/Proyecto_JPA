/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.data;

import com.dominio.Libros;
import com.dominio.LibrosHasUsuarios;
import java.util.List;

/**
 *
 * @author Pc
 */
public interface LibroHasUsuariosDao {
    public void insertLibro(LibrosHasUsuarios librosHasUsuarios);
     public List<LibrosHasUsuarios> findLibrosByIdUusario(int id);
     public List<LibrosHasUsuarios> listarLibrosHasUsuarios();
     public void EliminarLibrohasusuario(LibrosHasUsuarios librosHasUsuarios);
    
}
