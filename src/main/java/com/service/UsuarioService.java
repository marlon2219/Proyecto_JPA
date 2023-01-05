/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.service;


import com.dominio.Usuarios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Pc
 */
@Local
public interface UsuarioService {
    
    public void registrarUsuario(Usuarios usuario);
    public Usuarios encontrarUsuarioPorNombrePass(String usu, String pas);
    public Usuarios encontrarUsuarioPorId(int id);
    public void modificarUsuario(Usuarios usuario,Usuarios objActualizado);
    public void eliminarUsuario(Usuarios usuario);
    public List<Usuarios> listarUsuarios();
    public List<Usuarios> listaDeBusqueda(String busqueda);
}
