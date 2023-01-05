/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.data.LibroHasUsuariosDao;
import com.dominio.Libros;
import com.dominio.LibrosHasUsuarios;
import com.dominio.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Pc
 */
@Stateless
public class LibroHasUsuariosServiceImpl implements LibroHasUsuariosService {
    
    @Inject
    private LibroHasUsuariosDao libroHasUsuarioDao;

    @Override
    public void registrarLibroHasUsuario(LibrosHasUsuarios librosHasUsuarios) {
        libroHasUsuarioDao.insertLibro(librosHasUsuarios);
    }

    @Override
    public List<LibrosHasUsuarios> encontrarLibroPorIdUsuario(int id) {
        return libroHasUsuarioDao.findLibrosByIdUusario(id);
    }

    @Override
    public void EliminarLibroHasUsu(LibrosHasUsuarios libroHasUsuarios) {
        libroHasUsuarioDao.EliminarLibrohasusuario(libroHasUsuarios);
    }

    @Override
    public List<LibrosHasUsuarios> listarLibroHasUsuario() {
        return libroHasUsuarioDao.listarLibrosHasUsuarios();
    }

    
    
    
    
}
