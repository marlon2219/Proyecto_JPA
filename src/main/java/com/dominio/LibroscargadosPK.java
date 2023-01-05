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
public class LibroscargadosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "libros_idlibro")
    private int librosIdlibro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "empleados_idEmpleado")
    private int empleadosidEmpleado;

    public LibroscargadosPK() {
    }

    public LibroscargadosPK(int librosIdlibro, int empleadosidEmpleado) {
        this.librosIdlibro = librosIdlibro;
        this.empleadosidEmpleado = empleadosidEmpleado;
    }

    public int getLibrosIdlibro() {
        return librosIdlibro;
    }

    public void setLibrosIdlibro(int librosIdlibro) {
        this.librosIdlibro = librosIdlibro;
    }

    public int getEmpleadosidEmpleado() {
        return empleadosidEmpleado;
    }

    public void setEmpleadosidEmpleado(int empleadosidEmpleado) {
        this.empleadosidEmpleado = empleadosidEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) librosIdlibro;
        hash += (int) empleadosidEmpleado;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LibroscargadosPK)) {
            return false;
        }
        LibroscargadosPK other = (LibroscargadosPK) object;
        if (this.librosIdlibro != other.librosIdlibro) {
            return false;
        }
        if (this.empleadosidEmpleado != other.empleadosidEmpleado) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dominio.LibroscargadosPK[ librosIdlibro=" + librosIdlibro + ", empleadosidEmpleado=" + empleadosidEmpleado + " ]";
    }
    
}
