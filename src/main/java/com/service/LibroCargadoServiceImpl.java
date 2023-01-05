/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.data.LibrosCargadosDao;
import com.data.UsuarioDao;
import com.dominio.Libroscargados;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Pc
 */
@Stateless
public class LibroCargadoServiceImpl implements LibroCargadoService{
    @Inject
    private LibrosCargadosDao librosCargadosDao;

    @Override
    public void insertarLibroCargado(Libroscargados libroscargados) {
        librosCargadosDao.insertarLibroCargado(libroscargados);
    }

    @Override
    public List<Libroscargados> librosPorEmpleado(int id) {
        return librosCargadosDao.librosCargadosByIdEmpleado(id);
    }
    
}
