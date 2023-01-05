/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Pc
 */
@Entity
@Table(name = "libros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libros.findAll", query = "SELECT l FROM Libros l"),
    @NamedQuery(name = "Libros.findByIdlibro", query = "SELECT l FROM Libros l WHERE l.idlibro = :idlibro"),
    @NamedQuery(name = "Libros.findByTitulo", query = "SELECT l FROM Libros l WHERE l.titulo = :titulo"),
    @NamedQuery(name = "Libros.findByAutor", query = "SELECT l FROM Libros l WHERE l.autor = :autor"),
    @NamedQuery(name = "Libros.findByGenero", query = "SELECT l FROM Libros l WHERE l.genero = :genero"),
    @NamedQuery(name = "Libros.findByPagina", query = "SELECT l FROM Libros l WHERE l.pagina = :pagina"),
    @NamedQuery(name = "Libros.findByPrecio", query = "SELECT l FROM Libros l WHERE l.precio = :precio")})
public class Libros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlibro")
    private Integer idlibro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "autor")
    private String autor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "genero")
    private String genero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pagina")
    private int pagina;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "libros")
    private List<Libroscargados> libroscargadosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "librosIdlibro")
    private List<Compraventas> compraventasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "libros")
    private List<LibrosHasUsuarios> librosHasUsuariosList;

    public Libros() {
    }

    public Libros(Integer idlibro) {
        this.idlibro = idlibro;
    }

    public Libros(String titulo, String autor, String genero, int pagina, double precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.pagina = pagina;
        this.precio = precio;
    }
    

    public Libros(Integer idlibro, String titulo, String autor, String genero, int pagina, double precio) {
        this.idlibro = idlibro;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.pagina = pagina;
        this.precio = precio;
    }

    public Integer getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(Integer idlibro) {
        this.idlibro = idlibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @XmlTransient
    public List<Libroscargados> getLibroscargadosList() {
        return libroscargadosList;
    }

    public void setLibroscargadosList(List<Libroscargados> libroscargadosList) {
        this.libroscargadosList = libroscargadosList;
    }

    @XmlTransient
    public List<Compraventas> getCompraventasList() {
        return compraventasList;
    }

    public void setCompraventasList(List<Compraventas> compraventasList) {
        this.compraventasList = compraventasList;
    }

    @XmlTransient
    public List<LibrosHasUsuarios> getLibrosHasUsuariosList() {
        return librosHasUsuariosList;
    }

    public void setLibrosHasUsuariosList(List<LibrosHasUsuarios> librosHasUsuariosList) {
        this.librosHasUsuariosList = librosHasUsuariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlibro != null ? idlibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libros)) {
            return false;
        }
        Libros other = (Libros) object;
        if ((this.idlibro == null && other.idlibro != null) || (this.idlibro != null && !this.idlibro.equals(other.idlibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dominio.Libros[ idlibro=" + idlibro + " ]";
    }
    
}
