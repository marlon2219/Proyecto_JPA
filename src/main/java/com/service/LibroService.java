/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.service;

import com.dominio.Libros;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Pc
 */
@Local
public interface LibroService {
    public List<Libros> listarLibros();
    public void agregarLibro(Libros libro);
    public List<Libros> busquedaInexacta(String busqueda);
    public Libros buscarLibroPorId(int id);
    public void modificarLibro(Libros libro,Libros objActualizado);
    public void eliminarLibro(Libros libro);
    
}
