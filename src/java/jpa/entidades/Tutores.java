/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gus
 */
@Entity
@Table(name = "tutores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tutores.findAll", query = "SELECT t FROM Tutores t")
    , @NamedQuery(name = "Tutores.findByIdTutores", query = "SELECT t FROM Tutores t WHERE t.idTutores = :idTutores")
    , @NamedQuery(name = "Tutores.findByFechaIngreso", query = "SELECT t FROM Tutores t WHERE t.fechaIngreso = :fechaIngreso")
    , @NamedQuery(name = "Tutores.findByProfesion", query = "SELECT t FROM Tutores t WHERE t.profesion = :profesion")})
public class Tutores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Tutores", nullable = false)
    private Long idTutores;
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;

    @Column(name = "profesion", length = 30)
    private String profesion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tutores")
    private Collection<Asignaturaxtutor> asignaturaxtutorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tutores")
    private Collection<Tutorias> tutoriasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tutores")
    private Collection<Disponibilidad> disponibilidadCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tutores")
    private Collection<Factura> facturaCollection;
    @JoinColumn(name = "Users_id_User", referencedColumnName = "id_User", nullable = false)
    @ManyToOne(optional = false)
    private Users users;

    public Tutores() {
    }

    public Tutores(Long idTutores) {
        this.idTutores = idTutores;
    }

    public Long getIdTutores() {
        return idTutores;
    }

    public void setIdTutores(Long idTutores) {
        this.idTutores = idTutores;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
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
    public Collection<Disponibilidad> getDisponibilidadCollection() {
        return disponibilidadCollection;
    }

    public void setDisponibilidadCollection(Collection<Disponibilidad> disponibilidadCollection) {
        this.disponibilidadCollection = disponibilidadCollection;
    }

    @XmlTransient
    public Collection<Factura> getFacturaCollection() {
        return facturaCollection;
    }

    public void setFacturaCollection(Collection<Factura> facturaCollection) {
        this.facturaCollection = facturaCollection;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTutores != null ? idTutores.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tutores)) {
            return false;
        }
        Tutores other = (Tutores) object;
        if ((this.idTutores == null && other.idTutores != null) || (this.idTutores != null && !this.idTutores.equals(other.idTutores))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idTutores + " ";
    }
    
}
