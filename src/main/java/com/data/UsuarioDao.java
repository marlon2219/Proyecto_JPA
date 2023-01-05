/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.data;

import com.dominio.Usuarios;
import java.util.List;

/**
 *
 * @author Pc
 */
public interface UsuarioDao {
    
    public void insertUsuario(Usuarios usuario);
    public Usuarios findPersonaByNombrePass(String usu, String pas);
    public Usuarios findPersonaById(int id);
    public void updateUsuario(Usuarios usuario,Usuarios objActualizado);
    public void deleteUsuario(Usuarios usuario); 
    public List<Usuarios> listarUsuarios();
    public List<Usuarios> busquedaUsuarios(String busqueda);
}
