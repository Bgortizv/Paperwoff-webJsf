/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entidades;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gus
 */
@Entity
@Table(name = "tipo_clase")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoClase.findAll", query = "SELECT t FROM TipoClase t")
    , @NamedQuery(name = "TipoClase.findByIdTipoClase", query = "SELECT t FROM TipoClase t WHERE t.idTipoClase = :idTipoClase")
    , @NamedQuery(name = "TipoClase.findByDescripcion", query = "SELECT t FROM TipoClase t WHERE t.descripcion = :descripcion")})
public class TipoClase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Tipo_Clase")
    private Long idTipoClase;
    @Size(max = 10)
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoClaseidTipoClase")
    private Collection<Tutorias> tutoriasCollection;

    public TipoClase() {
    }

    public TipoClase(Long idTipoClase) {
        this.idTipoClase = idTipoClase;
    }

    public Long getIdTipoClase() {
        return idTipoClase;
    }

    public void setIdTipoClase(Long idTipoClase) {
        this.idTipoClase = idTipoClase;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Tutorias> getTutoriasCollection() {
        return tutoriasCollection;
    }

    public void setTutoriasCollection(Collection<Tutorias> tutoriasCollection) {
        this.tutoriasCollection = tutoriasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoClase != null ? idTipoClase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoClase)) {
            return false;
        }
        TipoClase other = (TipoClase) object;
        if ((this.idTipoClase == null && other.idTipoClase != null) || (this.idTipoClase != null && !this.idTipoClase.equals(other.idTipoClase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entidades.TipoClase[ idTipoClase=" + idTipoClase + " ]";
    }
    
}
