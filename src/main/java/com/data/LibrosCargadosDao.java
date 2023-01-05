/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.data;

import com.dominio.Libroscargados;
import java.util.List;

/**
 *
 * @author Pc
 */
public interface LibrosCargadosDao {
    
    public void insertarLibroCargado(Libroscargados librocargados);
    public List<Libroscargados> librosCargadosByIdEmpleado(int id);
    
}
