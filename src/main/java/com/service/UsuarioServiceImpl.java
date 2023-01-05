/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.data.UsuarioDao;
import com.dominio.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Pc
 */
@Stateless
public class UsuarioServiceImpl implements UsuarioService{
    
    @Inject
    private UsuarioDao usuarioDao;

    @Override
    public void registrarUsuario(Usuarios usuario) {
         usuarioDao.insertUsuario(usuario);
    }

    @Override
    public Usuarios encontrarUsuarioPorNombrePass(String usu, String pas) {
        return usuarioDao.findPersonaByNombrePass(usu,pas);
    }

    @Override
    public Usuarios encontrarUsuarioPorId(int id) {
        return usuarioDao.findPersonaById(id);
    }

    @Override
    public void modificarUsuario(Usuarios usuario,Usuarios objActualizado) {
        usuarioDao.updateUsuario(usuario,objActualizado);
    }

    @Override
    public void eliminarUsuario(Usuarios usuario) {
        usuarioDao.deleteUsuario(usuario);
    }

    @Override
    public List<Usuarios> listarUsuarios() {
        return usuarioDao.listarUsuarios();
    }

    @Override
    public List<Usuarios> listaDeBusqueda(String busqueda) {
        return usuarioDao.busquedaUsuarios(busqueda);
    }

   
    
}
