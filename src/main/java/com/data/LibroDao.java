/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.data;

import com.dominio.Libros;
import java.util.List;

/**
 *
 * @author Pc
 */
public interface LibroDao {
    
    public List<Libros> findAllLibros();
    public void insertLibro(Libros libro);
    public List<Libros> busquedaLibros(String busqueda);
    public Libros findLibroById(int id);
    public void updateLibro(Libros libro,Libros objActualizado);
    public void deleteLibro(Libros libro);    
    
    
}
