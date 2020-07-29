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
@Table(name = "virpres")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Virpres.findAll", query = "SELECT v FROM Virpres v")
    , @NamedQuery(name = "Virpres.findByIdVirPres", query = "SELECT v FROM Virpres v WHERE v.idVirPres = :idVirPres")
    , @NamedQuery(name = "Virpres.findByDescrip", query = "SELECT v FROM Virpres v WHERE v.descrip = :descrip")})
public class Virpres implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_VirPres", nullable = false)
    private Long idVirPres;
  
    @Column(name = "Descrip", length = 10)
    private String descrip;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "virpres")
    private Collection<Tutorias> tutoriasCollection;

    public Virpres() {
    }

    public Virpres(Long idVirPres) {
        this.idVirPres = idVirPres;
    }

    public Long getIdVirPres() {
        return idVirPres;
    }

    public void setIdVirPres(Long idVirPres) {
        this.idVirPres = idVirPres;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
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
        hash += (idVirPres != null ? idVirPres.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Virpres)) {
            return false;
        }
        Virpres other = (Virpres) object;
        if ((this.idVirPres == null && other.idVirPres != null) || (this.idVirPres != null && !this.idVirPres.equals(other.idVirPres))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idVirPres + " ";
    }
    
}
