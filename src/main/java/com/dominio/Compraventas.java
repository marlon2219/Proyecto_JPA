/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "compraventas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compraventas.findAll", query = "SELECT c FROM Compraventas c"),
    @NamedQuery(name = "Compraventas.findByIdVenta", query = "SELECT c FROM Compraventas c WHERE c.idVenta = :idVenta"),
    @NamedQuery(name = "Compraventas.findByFecha", query = "SELECT c FROM Compraventas c WHERE c.fecha = :fecha")})
public class Compraventas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVenta")
    private Integer idVenta;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "libros_idlibro", referencedColumnName = "idlibro")
    @ManyToOne(optional = false)
    private Libros librosIdlibro;
    @JoinColumn(name = "usuarios_idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuarios usuariosidUsuario;
    @JoinColumn(name = "empleados_idEmpleado", referencedColumnName = "idEmpleado")
    @ManyToOne(optional = false)
    private Empleados empleadosidEmpleado;

    public Compraventas() {
    }

    public Compraventas( Empleados empleadosidEmpleado,Libros librosIdlibro, Usuarios usuariosidUsuario) {
        this.librosIdlibro = librosIdlibro;
        this.usuariosidUsuario = usuariosidUsuario;
        this.empleadosidEmpleado = empleadosidEmpleado;
    }
    
    

    public Compraventas(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Libros getLibrosIdlibro() {
        return librosIdlibro;
    }

    public void setLibrosIdlibro(Libros librosIdlibro) {
        this.librosIdlibro = librosIdlibro;
    }

    public Usuarios getUsuariosidUsuario() {
        return usuariosidUsuario;
    }

    public void setUsuariosidUsuario(Usuarios usuariosidUsuario) {
        this.usuariosidUsuario = usuariosidUsuario;
    }

    public Empleados getEmpleadosidEmpleado() {
        return empleadosidEmpleado;
    }

    public void setEmpleadosidEmpleado(Empleados empleadosidEmpleado) {
        this.empleadosidEmpleado = empleadosidEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVenta != null ? idVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compraventas)) {
            return false;
        }
        Compraventas other = (Compraventas) object;
        if ((this.idVenta == null && other.idVenta != null) || (this.idVenta != null && !this.idVenta.equals(other.idVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dominio.Compraventas[ idVenta=" + idVenta + " ]";
    }
    
}
