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
@Table(name = "asignatura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignatura.findAll", query = "SELECT a FROM Asignatura a")
    , @NamedQuery(name = "Asignatura.findByIdAsignatura", query = "SELECT a FROM Asignatura a WHERE a.idAsignatura = :idAsignatura")
    , @NamedQuery(name = "Asignatura.findByNombreAsignatura", query = "SELECT a FROM Asignatura a WHERE a.nombreAsignatura = :nombreAsignatura")
    , @NamedQuery(name = "Asignatura.findByC\u00f3digo", query = "SELECT a FROM Asignatura a WHERE a.c\u00f3digo = :c\u00f3digo")})
public class Asignatura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Asignatura")
    private Long idAsignatura;
    @Size(max = 30)
    @Column(name = "Nombre_Asignatura")
    private String nombreAsignatura;
    @Column(name = "C\u00f3digo")
    private Integer código;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignaturaidAsignatura")
    private Collection<Asignaturaxtutor> asignaturaxtutorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignaturaidAsignatura")
    private Collection<Tutorias> tutoriasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignaturaidAsignatura")
    private Collection<DetalleFactura> detalleFacturaCollection;

    public Asignatura() {
    }

    public Asignatura(Long idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public Long getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Long idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public Integer getCódigo() {
        return código;
    }

    public void setCódigo(Integer código) {
        this.código = código;
    }

    @XmlTransient
    public Collection<Asignaturaxtutor> getAsignaturaxtutorCollection() {
        return asignaturaxtutorCollection;
    }

    public void setAsignaturaxtutorCollection(Collection<Asignaturaxtutor> asignaturaxtutorCollection) {
        this.asignaturaxtutorCollection = asignaturaxtutorCollection;
    }

    @XmlTransient
    public Collection<Tutorias> getTutoriasCollection() {
        return tutoriasCollection;
    }

    public void setTutoriasCollection(Collection<Tutorias> tutoriasCollection) {
        this.tutoriasCollection = tutoriasCollection;
    }

    @XmlTransient
    public Collection<DetalleFactura> getDetalleFacturaCollection() {
        return detalleFacturaCollection;
    }

    public void setDetalleFacturaCollection(Collection<DetalleFactura> detalleFacturaCollection) {
        this.detalleFacturaCollection = detalleFacturaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsignatura != null ? idAsignatura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignatura)) {
            return false;
        }
        Asignatura other = (Asignatura) object;
        if ((this.idAsignatura == null && other.idAsignatura != null) || (this.idAsignatura != null && !this.idAsignatura.equals(other.idAsignatura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entidades.Asignatura[ idAsignatura=" + idAsignatura + " ]";
    }
    
}
