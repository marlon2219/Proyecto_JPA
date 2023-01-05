/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.data.LibroDao;
import com.dominio.Libros;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Pc
 */
@Stateless
public class LibroServiceImpl implements LibroService {
    
    @Inject
    private LibroDao libroDao;
    

    @Override
    public List<Libros> listarLibros() {
        return libroDao.findAllLibros();
    }

    @Override
    public void agregarLibro(Libros libro) {
        libroDao.insertLibro(libro);
    }

    @Override
    public List<Libros> busquedaInexacta(String busqueda) {
        return libroDao.busquedaLibros(busqueda);
    }

    @Override
    public Libros buscarLibroPorId(int id) {
        return libroDao.findLibroById(id);
    }

    @Override
    public void modificarLibro(Libros libro, Libros objActualizado) {
        libroDao.updateLibro(libro, objActualizado);
    }

    @Override
    public void eliminarLibro(Libros libro) {
        libroDao.deleteLibro(libro);
    }
    
}
