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
@Table(name = "libroscargados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libroscargados.findAll", query = "SELECT l FROM Libroscargados l"),
    @NamedQuery(name = "Libroscargados.findByLibrosIdlibro", query = "SELECT l FROM Libroscargados l WHERE l.libroscargadosPK.librosIdlibro = :librosIdlibro"),
    @NamedQuery(name = "Libroscargados.findByEmpleadosidEmpleado", query = "SELECT l FROM Libroscargados l WHERE l.libroscargadosPK.empleadosidEmpleado = :empleadosidEmpleado"),
    @NamedQuery(name = "Libroscargados.findByFecha", query = "SELECT l FROM Libroscargados l WHERE l.fecha = :fecha")})
public class Libroscargados implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LibroscargadosPK libroscargadosPK;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "empleados_idEmpleado", referencedColumnName = "idEmpleado", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empleados empleados;
    @JoinColumn(name = "libros_idlibro", referencedColumnName = "idlibro", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Libros libros;

    public Libroscargados() {
    }

    public Libroscargados(Libros libros,Empleados empleados) {
        this.empleados = empleados;
        this.libros = libros;
    }
    

    public Libroscargados(LibroscargadosPK libroscargadosPK) {
        this.libroscargadosPK = libroscargadosPK;
    }

    public Libroscargados(int librosIdlibro, int empleadosidEmpleado) {
        this.libroscargadosPK = new LibroscargadosPK(librosIdlibro, empleadosidEmpleado);
    }

    public LibroscargadosPK getLibroscargadosPK() {
        return libroscargadosPK;
    }

    public void setLibroscargadosPK(LibroscargadosPK libroscargadosPK) {
        this.libroscargadosPK = libroscargadosPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    public Libros getLibros() {
        return libros;
    }

    public void setLibros(Libros libros) {
        this.libros = libros;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (libroscargadosPK != null ? libroscargadosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libroscargados)) {
            return false;
        }
        Libroscargados other = (Libroscargados) object;
        if ((this.libroscargadosPK == null && other.libroscargadosPK != null) || (this.libroscargadosPK != null && !this.libroscargadosPK.equals(other.libroscargadosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dominio.Libroscargados[ libroscargadosPK=" + libroscargadosPK + " ]";
    }
    
}
