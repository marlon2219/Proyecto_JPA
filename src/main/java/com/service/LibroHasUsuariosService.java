/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.service;

import com.dominio.Libros;
import com.dominio.LibrosHasUsuarios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Pc
 */
@Local
public interface LibroHasUsuariosService {
     public void registrarLibroHasUsuario(LibrosHasUsuarios librosHasUsuarios);
       public List<LibrosHasUsuarios> encontrarLibroPorIdUsuario(int id);
       public List<LibrosHasUsuarios> listarLibroHasUsuario();
       public void EliminarLibroHasUsu(LibrosHasUsuarios libroHasUsuarios);
}
