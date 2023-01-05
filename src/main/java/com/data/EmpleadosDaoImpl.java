/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.data;

import com.dominio.Empleados;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Pc
 */
@Stateless
public class EmpleadosDaoImpl implements EmpleadoDao{
    
    @PersistenceContext(unitName = "Biblio")
    EntityManager em;

    @Override
    public void insertEmpleado(Empleados empleado) {
        em.persist(empleado);
    }

    @Override
    public Empleados findEmpleadoByNombrePass(String usu, String pas) {
        Query query = em.createQuery("SELECT u FROM Empleados u WHERE u.nombre = :nombre AND " + " u.contrasena = :pas");
        query.setParameter("nombre", usu);
        query.setParameter("pas", pas);

        return (Empleados) query.getSingleResult();
    }

    @Override
    public Empleados findEmpleadoById(int id) {
        return em.find(Empleados.class, id);
    }

    @Override
    public void updateEmpleado(Empleados empleado, Empleados objActualizado) {
        empleado = em.merge(empleado);
        System.out.println("empleado "+empleado.getNombre());
        System.out.println("empleado "+objActualizado.getNombre());
        empleado.setNombre(objActualizado.getNombre());
        empleado.setDni(objActualizado.getDni());
        empleado.setCorreo(objActualizado.getCorreo());
        empleado.setDireccion(objActualizado.getDireccion());
        empleado.setTelefono(objActualizado.getTelefono());
        empleado.setContrasena(objActualizado.getContrasena());
        
    }

    @Override
    public void deleteEmpleado(Empleados empleado) {
        em.remove(em.merge(empleado));
    }

    @Override
    public List<Empleados> listarTodosEmpleados() {
        return em.createNamedQuery("Empleados.findAll").getResultList();
    }

    @Override
    public List<Empleados> busquedaEmpleados(String busqueda) {
        Query query = em.createQuery("SELECT u FROM Empleados u WHERE u.nombre LIKE :nombre OR u.dni LIKE :nombre ");
        query.setParameter("nombre", "%"+busqueda+"%");
        return (List) query.getResultList();
    }
    
}
