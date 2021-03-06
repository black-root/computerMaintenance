/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmoocc.ingenieria.tpi2018.Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yisusdebian
 */
@Entity
@Table(name = "fabricantes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fabricantes.findAll", query = "SELECT f FROM Fabricantes f")
    , @NamedQuery(name = "Fabricantes.findByIdFabricante", query = "SELECT f FROM Fabricantes f WHERE f.idFabricante = :idFabricante")
    , @NamedQuery(name = "Fabricantes.findByNombre", query = "SELECT f FROM Fabricantes f WHERE f.nombre = :nombre")
    , @NamedQuery(name = "Fabricantes.findByCorreoFabricante", query = "SELECT f FROM Fabricantes f WHERE f.correoFabricante = :correoFabricante")
    , @NamedQuery(name = "Fabricantes.findByTelefono", query = "SELECT f FROM Fabricantes f WHERE f.telefono = :telefono")})
public class Fabricantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idFabricante")
    private Integer idFabricante;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Lob
    @Column(name = "descripcion_Fabricante")
    private String descripcionFabricante;
    @Column(name = "correo_Fabricante")
    private String correoFabricante;
    @Column(name = "telefono")
    private String telefono;
    @Lob
    @Column(name = "direccion")
    private String direccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fabricantesidFabricante")
    private Collection<Equipodetalle> equipodetalleCollection;

    public Fabricantes() {
    }

    public Fabricantes(Integer idFabricante) {
        this.idFabricante = idFabricante;
    }

    public Fabricantes(Integer idFabricante, String nombre) {
        this.idFabricante = idFabricante;
        this.nombre = nombre;
    }

    public Integer getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(Integer idFabricante) {
        this.idFabricante = idFabricante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcionFabricante() {
        return descripcionFabricante;
    }

    public void setDescripcionFabricante(String descripcionFabricante) {
        this.descripcionFabricante = descripcionFabricante;
    }

    public String getCorreoFabricante() {
        return correoFabricante;
    }

    public void setCorreoFabricante(String correoFabricante) {
        this.correoFabricante = correoFabricante;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @XmlTransient
    public Collection<Equipodetalle> getEquipodetalleCollection() {
        return equipodetalleCollection;
    }

    public void setEquipodetalleCollection(Collection<Equipodetalle> equipodetalleCollection) {
        this.equipodetalleCollection = equipodetalleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFabricante != null ? idFabricante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fabricantes)) {
            return false;
        }
        Fabricantes other = (Fabricantes) object;
        if ((this.idFabricante == null && other.idFabricante != null) || (this.idFabricante != null && !this.idFabricante.equals(other.idFabricante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.fmoocc.ingenieria.tpi2018.Entities.Fabricantes[ idFabricante=" + idFabricante + " ]";
    }
    
}
