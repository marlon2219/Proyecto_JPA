/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.data;

import com.dominio.Movimientosusuario;
import com.dominio.Usuarios;
import java.util.List;

/**
 *
 * @author Pc
 */
public interface MovimientosusuarioDao {
    
    public void insertMovimiento(Movimientosusuario movimientosusuario);
    public List<Movimientosusuario> movimientosPorIdUsuario(Usuarios u);
    
}
