/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.data;

import com.dominio.LibrosHasUsuarios;
import com.dominio.Usuarios;
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
public class UsuarioDaoImpl implements UsuarioDao {

    @PersistenceContext(unitName = "Biblio")
    EntityManager em;

    @Override
    public void insertUsuario(Usuarios usuario) {
        em.persist(usuario);
    }

    @Override
    public Usuarios findPersonaByNombrePass(String usu, String pas) {
       
        Query query = em.createQuery("SELECT u FROM Usuarios u WHERE u.nombre = :nombre AND " + " u.contrasena = :pas");
        query.setParameter("nombre", usu);
        query.setParameter("pas", pas);

        return (Usuarios) query.getSingleResult();
    }

    @Override
    public Usuarios findPersonaById(int id) {
         return em.find(Usuarios.class, id);
    }

    @Override
    public void updateUsuario(Usuarios usuario,Usuarios objActualizado) {
        usuario = em.merge(usuario);
        System.out.println("merge: "+usuario);
        System.out.println("sadlo: "+objActualizado.getSaldo());
        usuario.setNombre(objActualizado.getNombre());
        usuario.setDni(objActualizado.getDni());
        usuario.setCorreo(objActualizado.getCorreo());
        usuario.setDireccion(objActualizado.getDireccion());
        usuario.setTelefono(objActualizado.getTelefono());
        usuario.setContrasena(objActualizado.getContrasena());
        usuario.setSaldo(objActualizado.getSaldo());
        
        
        
    }

    @Override
    public void deleteUsuario(Usuarios usuario) {
        em.remove(em.merge(usuario));
    }

    @Override
    public List<Usuarios> listarUsuarios() {
        return em.createNamedQuery("Usuarios.findAll").getResultList();
    }

    @Override
    public List<Usuarios> busquedaUsuarios(String busqueda) {
          Query query = em.createQuery("SELECT u FROM Usuarios u WHERE u.nombre LIKE :nombre OR u.dni LIKE :nombre ");
        query.setParameter("nombre", "%"+busqueda+"%");
        return (List) query.getResultList();
    }

}
