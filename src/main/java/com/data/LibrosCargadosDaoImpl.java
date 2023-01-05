/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.data;

import com.dominio.LibrosHasUsuarios;
import com.dominio.Libroscargados;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Pc
 */
@Stateless
public class LibrosCargadosDaoImpl implements LibrosCargadosDao{

    @PersistenceContext(unitName = "Biblio")
    EntityManager em;
    @Override
    public void insertarLibroCargado(Libroscargados libroscargados) {
        em.persist(libroscargados);
    }

    @Override
    public List<Libroscargados> librosCargadosByIdEmpleado(int id) {
         TypedQuery<Libroscargados> consultalibros = em.createNamedQuery("Libroscargados.findByEmpleadosidEmpleado", Libroscargados.class);
        consultalibros.setParameter("empleadosidEmpleado", id);
        List<Libroscargados> lista =  consultalibros.getResultList();
        //em.createNamedQuery("LibrosHasUsuarios.findByIdUsuario");
        return lista;
    }
    
}
