/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.data;

import com.dominio.Compraventas;
import com.dominio.LibrosHasUsuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Pc
 */
@Stateless
public class CompraventasImpl implements CompraventasDao{
    
    @PersistenceContext(unitName = "Biblio")
    EntityManager em;

    @Override
    public void insertCompraventas(Compraventas compraventas) {
        em.persist(compraventas);
    }

    @Override
    public List<Compraventas> listarCompraVentas() {
        return em.createNamedQuery("Compraventas.findAll").getResultList();
    }

    @Override
    public List<Compraventas> listarBusquedaCompraVentasPorUsuarios(String busqueda) {
       System.out.println("entramos en ya tu sabes");
        //Query query = em.createQuery("SELECT u FROM Compraventas u, Usuarios e WHERE  e.nombre LIKE :nombre");
        Query query = em.createQuery("SELECT u FROM Compraventas u WHERE  u.usuariosidUsuario.nombre LIKE :nombre ");
        
        query.setParameter("nombre", "%"+busqueda+"%");
 
        return (List) query.getResultList();




    }
    
}
