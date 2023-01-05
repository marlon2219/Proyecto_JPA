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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pc
 */
@Entity
@Table(name = "movimientosusuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimientosusuario.findAll", query = "SELECT m FROM Movimientosusuario m"),
    @NamedQuery(name = "Movimientosusuario.findById", query = "SELECT m FROM Movimientosusuario m WHERE m.id = :id"),
    @NamedQuery(name = "Movimientosusuario.findByCantidad", query = "SELECT m FROM Movimientosusuario m WHERE m.cantidad = :cantidad"),
    @NamedQuery(name = "Movimientosusuario.findByAccion", query = "SELECT m FROM Movimientosusuario m WHERE m.accion = :accion"),
    @NamedQuery(name = "Movimientosusuario.findByFecha", query = "SELECT m FROM Movimientosusuario m WHERE m.fecha = :fecha")})
public class Movimientosusuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "cantidad")
    private String cantidad;
    @Size(max = 45)
    @Column(name = "accion")
    private String accion;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "usuarios_idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuarios usuariosidUsuario;

    public Movimientosusuario() {
    }

    public Movimientosusuario(String cantidad, String accion, Date fecha, Usuarios usuariosidUsuario) {
        this.cantidad = cantidad;
        this.accion = accion;
        this.fecha = fecha;
        this.usuariosidUsuario = usuariosidUsuario;
    }

    public Movimientosusuario(String cantidad, String accion, Usuarios usuariosidUsuario) {
        this.cantidad = cantidad;
        this.accion = accion;
        this.usuariosidUsuario = usuariosidUsuario;
    }
    
    

    public Movimientosusuario(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuarios getUsuariosidUsuario() {
        return usuariosidUsuario;
    }

    public void setUsuariosidUsuario(Usuarios usuariosidUsuario) {
        this.usuariosidUsuario = usuariosidUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimientosusuario)) {
            return false;
        }
        Movimientosusuario other = (Movimientosusuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dominio.Movimientosusuario[ id=" + id + " ]";
    }
    
}
