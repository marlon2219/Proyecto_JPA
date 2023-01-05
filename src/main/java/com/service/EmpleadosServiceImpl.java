/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.data.EmpleadoDao;
import com.dominio.Empleados;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Pc
 */
@Stateless
public class EmpleadosServiceImpl implements EmpleadoService{
    
    @Inject
    EmpleadoDao empleadoDao;

    @Override
    public void registrarEmpleado(Empleados empleado) {
        empleadoDao.insertEmpleado(empleado);
    }

    @Override
    public Empleados encontrarEmpleadoPorNombrePass(String usu, String pas) {
        return empleadoDao.findEmpleadoByNombrePass(usu, pas);
    }

    @Override
    public Empleados encontrarEmpleadoPorId(int id) {
        return empleadoDao.findEmpleadoById(id);
    }

    @Override
    public void modificarEmpleado(Empleados empleado, Empleados objActualizado) {
        empleadoDao.updateEmpleado(empleado, objActualizado);
    }

    @Override
    public void eliminarEmpleado(Empleados empleado) {
            empleadoDao.deleteEmpleado(empleado);
        }

    @Override
    public List<Empleados> listaEmpleados() {
        return empleadoDao.listarTodosEmpleados();
    }

    @Override
    public List<Empleados> busquedaEmpleados(String busqueda) {
        return empleadoDao.busquedaEmpleados(busqueda);
    }

    
    
}
