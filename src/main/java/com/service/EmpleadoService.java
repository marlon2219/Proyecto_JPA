/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.service;

import com.dominio.Empleados;
import java.util.List;

import javax.ejb.Local;

/**
 *
 * @author Pc
 */
@Local
public interface EmpleadoService {
    public List<Empleados> listaEmpleados();
    public void registrarEmpleado(Empleados empleado);
    public Empleados encontrarEmpleadoPorNombrePass(String usu, String pas);
    public Empleados encontrarEmpleadoPorId(int id);
    public void modificarEmpleado(Empleados empleado,Empleados objActualizado);
    public void eliminarEmpleado(Empleados empleado);
    public List<Empleados> busquedaEmpleados(String busqueda);
    
}
