/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dominio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Pc
 */
@Embeddable
public class LibrosHasUsuariosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "IdUsuario")
    private int idUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdLibro")
    private int idLibro;

    public LibrosHasUsuariosPK() {
    }

    public LibrosHasUsuariosPK(int idUsuario, int idLibro) {
        this.idUsuario = idUsuario;
        this.idLibro = idLibro;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUsuario;
        hash += (int) idLibro;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LibrosHasUsuariosPK)) {
            return false;
        }
        LibrosHasUsuariosPK other = (LibrosHasUsuariosPK) object;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (this.idLibro != other.idLibro) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dominio.LibrosHasUsuariosPK[ idUsuario=" + idUsuario + ", idLibro=" + idLibro + " ]";
    }
    
}
