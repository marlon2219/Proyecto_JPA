/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.service;

import com.dominio.Compraventas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Pc
 */
@Local
public interface CompraventasService {
    
    public void registrarCompraventas(Compraventas compraventas);
    public List<Compraventas> listadoCompraVentaas();
    public List<Compraventas> BuscarPorUsuario(String busqueda);
}
