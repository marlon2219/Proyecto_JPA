/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.data;

import com.dominio.Libros;
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
public class LibroDaoImpl implements LibroDao{
    
    @PersistenceContext(unitName="Biblio")
    EntityManager em;

    @Override
    public List<Libros> findAllLibros() {
        
        return em.createNamedQuery("Libros.findAll").getResultList();
        
    }
    
    @Override
    public void insertLibro(Libros libro) {
        em.persist(libro);
    }

    @Override
    public List<Libros> busquedaLibros(String busqueda) {
        Query query = em.createQuery("SELECT u FROM Libros u WHERE u.titulo LIKE :nombre OR u.genero LIKE :nombre OR u.autor LIKE :nombre ");
        query.setParameter("nombre", "%"+busqueda+"%");
        return (List) query.getResultList();
    }   

    @Override
    public Libros findLibroById(int id) {
        return em.find(Libros.class, id);
    }

    @Override
    public void updateLibro(Libros libro, Libros objActualizado) {
        libro = em.merge(libro);

        libro.setTitulo(objActualizado.getTitulo());
        libro.setAutor(objActualizado.getAutor());
        libro.setGenero(objActualizado.getGenero());
        libro.setPagina(objActualizado.getPagina());
        libro.setPrecio(objActualizado.getPrecio());
   
    }

    @Override
    public void deleteLibro(Libros libro) {
        em.remove(em.merge(libro));
    }
    
}
