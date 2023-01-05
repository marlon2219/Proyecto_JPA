/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;


import com.data.CompraventasDao;
import com.dominio.Compraventas;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Pc
 */
@Stateless
public class CompraventasServiceImpl implements CompraventasService{
    @Inject
    private CompraventasDao compraventasDao;

    @Override
    public void registrarCompraventas(Compraventas compraventas) {
        compraventasDao.insertCompraventas(compraventas);
        
    }

    @Override
    public List<Compraventas> listadoCompraVentaas() {
        return compraventasDao.listarCompraVentas();
    }

    @Override
    public List<Compraventas> BuscarPorUsuario(String busqueda) {
        return compraventasDao.listarBusquedaCompraVentasPorUsuarios(busqueda);
    }
    
}
