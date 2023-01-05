/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;


import com.data.MovimientosusuarioDao;
import com.dominio.Movimientosusuario;
import com.dominio.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Pc
 */
@Stateless
public class MovimientosusuarioServiceImpl implements MovimientosusuarioService{
    
     @Inject
    private MovimientosusuarioDao movimientosusuarioDao ;

    @Override
    public void agregarMovimiento(Movimientosusuario movimientousuarios) {
        movimientosusuarioDao.insertMovimiento(movimientousuarios);
    }

    @Override
    public List<Movimientosusuario> listarPorIdUsuario(Usuarios u) {
        return movimientosusuarioDao.movimientosPorIdUsuario(u);
    }
    
}
