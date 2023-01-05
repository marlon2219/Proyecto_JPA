/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.data;

import com.dominio.Compraventas;
import java.util.List;

/**
 *
 * @author Pc
 */
public interface CompraventasDao {
    public void insertCompraventas(Compraventas compraventas);
    public List<Compraventas> listarCompraVentas();
    public List<Compraventas> listarBusquedaCompraVentasPorUsuarios(String busqueda);
    
}
