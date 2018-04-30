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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sergio
 */
@Entity
@Table(name = "Prioridad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prioridad.findAll", query = "SELECT p FROM Prioridad p")
    , @NamedQuery(name = "Prioridad.findByPkidPrioridad", query = "SELECT p FROM Prioridad p WHERE p.pkidPrioridad = :pkidPrioridad")
    , @NamedQuery(name = "Prioridad.findByPrioridadNivel", query = "SELECT p FROM Prioridad p WHERE p.prioridadNivel = :prioridadNivel")})
public class Prioridad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_idPrioridad")
    private Integer pkidPrioridad;
    @Basic(optional = false)
    @Column(name = "PrioridadNivel")
    private String prioridadNivel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prioridadpkidPrioridad")
    private Collection<OrdenTrabajo> ordenTrabajoCollection;

    public Prioridad() {
    }

    public Prioridad(Integer pkidPrioridad) {
        this.pkidPrioridad = pkidPrioridad;
    }

    public Prioridad(Integer pkidPrioridad, String prioridadNivel) {
        this.pkidPrioridad = pkidPrioridad;
        this.prioridadNivel = prioridadNivel;
    }

    public Integer getPkidPrioridad() {
        return pkidPrioridad;
    }

    public void setPkidPrioridad(Integer pkidPrioridad) {
        this.pkidPrioridad = pkidPrioridad;
    }

    public String getPrioridadNivel() {
        return prioridadNivel;
    }

    public void setPrioridadNivel(String prioridadNivel) {
        this.prioridadNivel = prioridadNivel;
    }

    @XmlTransient
    public Collection<OrdenTrabajo> getOrdenTrabajoCollection() {
        return ordenTrabajoCollection;
    }

    public void setOrdenTrabajoCollection(Collection<OrdenTrabajo> ordenTrabajoCollection) {
        this.ordenTrabajoCollection = ordenTrabajoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkidPrioridad != null ? pkidPrioridad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prioridad)) {
            return false;
        }
        Prioridad other = (Prioridad) object;
        if ((this.pkidPrioridad == null && other.pkidPrioridad != null) || (this.pkidPrioridad != null && !this.pkidPrioridad.equals(other.pkidPrioridad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.fmocc.ingenieria.tpi2018.Entities.Prioridad[ pkidPrioridad=" + pkidPrioridad + " ]";
    }
    
}
