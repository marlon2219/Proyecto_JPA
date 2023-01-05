/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pc
 */
@Entity
@Table(name = "libros_has_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LibrosHasUsuarios.findAll", query = "SELECT l FROM LibrosHasUsuarios l"),
    @NamedQuery(name = "LibrosHasUsuarios.findByIdUsuario", query = "SELECT l FROM LibrosHasUsuarios l WHERE l.librosHasUsuariosPK.idUsuario = :idUsuario"),
    @NamedQuery(name = "LibrosHasUsuarios.findByIdLibro", query = "SELECT l FROM LibrosHasUsuarios l WHERE l.librosHasUsuariosPK.idLibro = :idLibro"),
    @NamedQuery(name = "LibrosHasUsuarios.findByFecha", query = "SELECT l FROM LibrosHasUsuarios l WHERE l.fecha = :fecha")})
public class LibrosHasUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LibrosHasUsuariosPK librosHasUsuariosPK;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "IdLibro", referencedColumnName = "idlibro", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Libros libros;
    @JoinColumn(name = "IdUsuario", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuarios usuarios;

    public LibrosHasUsuarios() {
    }

    public LibrosHasUsuarios(Date fecha, Libros libros, Usuarios usuarios) {
        this.fecha = fecha;
        this.libros = libros;
        this.usuarios = usuarios;
    }

    
    public LibrosHasUsuarios(Usuarios usuarios,Libros libros) {
        this.libros = libros;
        this.usuarios = usuarios;
    }
    

    public LibrosHasUsuarios(LibrosHasUsuariosPK librosHasUsuariosPK) {
        this.librosHasUsuariosPK = librosHasUsuariosPK;
    }

    public LibrosHasUsuarios(int idUsuario, int idLibro) {
        this.librosHasUsuariosPK = new LibrosHasUsuariosPK(idUsuario, idLibro);
    }

    public LibrosHasUsuariosPK getLibrosHasUsuariosPK() {
        return librosHasUsuariosPK;
    }

    public void setLibrosHasUsuariosPK(LibrosHasUsuariosPK librosHasUsuariosPK) {
        this.librosHasUsuariosPK = librosHasUsuariosPK;
    }

    public Date getFecha() {
        return fecha;
    }

    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Libros getLibros() {
        return libros;
    }

    public void setLibros(Libros libros) {
        this.libros = libros;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (librosHasUsuariosPK != null ? librosHasUsuariosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LibrosHasUsuarios)) {
            return false;
        }
        LibrosHasUsuarios other = (LibrosHasUsuarios) object;
        if ((this.librosHasUsuariosPK == null && other.librosHasUsuariosPK != null) || (this.librosHasUsuariosPK != null && !this.librosHasUsuariosPK.equals(other.librosHasUsuariosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dominio.LibrosHasUsuarios[ librosHasUsuariosPK=" + librosHasUsuariosPK + " ]";
    }
    
}
