/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.data;

import com.dominio.Movimientosusuario;
import com.dominio.Usuarios;
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
public class MovimientosusuarioDaoImpl implements MovimientosusuarioDao{
    @PersistenceContext(unitName="Biblio")
    EntityManager em;

    @Override
    public void insertMovimiento(Movimientosusuario movimientosusuario) {
        em.persist(movimientosusuario);
    }

    @Override
    public List<Movimientosusuario> movimientosPorIdUsuario(Usuarios u) {
       
         //Query query = em.createQuery("SELECT u FROM Movimientosusuario u WHERE u.usuariosidUsuario = :usuariosidUsuario");
         Query query = em.createQuery("SELECT m FROM Movimientosusuario m WHERE m.usuariosidUsuario = :id");
        query.setParameter("id", u);
        return (List) query.getResultList();
    }
    
}
