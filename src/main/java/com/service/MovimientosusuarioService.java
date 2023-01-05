/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.service;

import com.dominio.Movimientosusuario;
import com.dominio.Usuarios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Pc
 */
@Local
public interface MovimientosusuarioService {
    public void agregarMovimiento(Movimientosusuario movimientosusuarios);
    public List<Movimientosusuario> listarPorIdUsuario(Usuarios u);
}
