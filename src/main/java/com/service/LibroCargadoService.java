/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.service;

import com.dominio.Libroscargados;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Pc
 */
@Local
public interface LibroCargadoService {
    
    public void insertarLibroCargado(Libroscargados libroscargados);
    public List<Libroscargados> librosPorEmpleado(int id);
    
}
