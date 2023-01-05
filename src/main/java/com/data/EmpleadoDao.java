/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.data;

import com.dominio.Empleados;
import java.util.List;

/**
 *
 * @author Pc
 */
public interface EmpleadoDao {
    public List<Empleados> listarTodosEmpleados();
    public void insertEmpleado(Empleados empleado);
    public Empleados findEmpleadoByNombrePass(String usu, String pas);
    public Empleados findEmpleadoById(int id);
    public void updateEmpleado(Empleados empleado,Empleados objActualizado);
    public void deleteEmpleado(Empleados empleado);  
    public List<Empleados> busquedaEmpleados(String busqueda);
    
}
