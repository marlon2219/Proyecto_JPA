/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.data;

import com.dominio.Libros;
import com.dominio.LibrosHasUsuarios;
import com.dominio.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pc
 */
@Stateless
public class LibroHasUsuariosDaoImpl implements LibroHasUsuariosDao {

    @PersistenceContext(unitName = "Biblio")
    EntityManager em;

    @Override
    public void insertLibro(LibrosHasUsuarios librosHasUsuarios) {
        em.persist(librosHasUsuarios);
    }

    @Override
    public List<LibrosHasUsuarios> findLibrosByIdUusario(int id) {
        
        TypedQuery<LibrosHasUsuarios> consultalibros = em.createNamedQuery("LibrosHasUsuarios.findByIdUsuario", LibrosHasUsuarios.class);
        consultalibros.setParameter("idUsuario", id);
        List<LibrosHasUsuarios> lista =  consultalibros.getResultList();
        //em.createNamedQuery("LibrosHasUsuarios.findByIdUsuario");
        return lista;
    }

    @Override
    public void EliminarLibrohasusuario(LibrosHasUsuarios librosHasUsuarios) {
        em.remove(em.merge(librosHasUsuarios));
    }

    @Override
    public List<LibrosHasUsuarios> listarLibrosHasUsuarios() {
        return em.createNamedQuery("LibrosHasUsuarios.findAll").getResultList();
    }

}
