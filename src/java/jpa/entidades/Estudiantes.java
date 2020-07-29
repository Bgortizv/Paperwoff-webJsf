/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gus
 */
@Entity
@Table(name = "estudiantes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiantes.findAll", query = "SELECT e FROM Estudiantes e")
    , @NamedQuery(name = "Estudiantes.findByIdEstudiantes", query = "SELECT e FROM Estudiantes e WHERE e.idEstudiantes = :idEstudiantes")
    , @NamedQuery(name = "Estudiantes.findByGrado", query = "SELECT e FROM Estudiantes e WHERE e.grado = :grado")
    , @NamedQuery(name = "Estudiantes.findByAcudiente", query = "SELECT e FROM Estudiantes e WHERE e.acudiente = :acudiente")
    , @NamedQuery(name = "Estudiantes.findByCelularAcudiente", query = "SELECT e FROM Estudiantes e WHERE e.celularAcudiente = :celularAcudiente")})
public class Estudiantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Estudiantes", nullable = false)
    private Long idEstudiantes;
    @Column(name = "Grado")
    private Integer grado;
 
    @Column(name = "Acudiente", length = 30)
    private String acudiente;
    @Column(name = "Celular_Acudiente")
    private BigInteger celularAcudiente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiantes")
    private Collection<Tutorias> tutoriasCollection;
    @JoinColumn(name = "Users_id_user", referencedColumnName = "id_User", nullable = false)
    @ManyToOne(optional = false)
    private Users users;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiantes")
    private Collection<BolsaPagos> bolsaPagosCollection;

    public Estudiantes() {
    }

    public Estudiantes(Long idEstudiantes) {
        this.idEstudiantes = idEstudiantes;
    }

    public Long getIdEstudiantes() {
        return idEstudiantes;
    }

    public void setIdEstudiantes(Long idEstudiantes) {
        this.idEstudiantes = idEstudiantes;
    }

    public Integer getGrado() {
        return grado;
    }

    public void setGrado(Integer grado) {
        this.grado = grado;
    }

    public String getAcudiente() {
        return acudiente;
    }

    public void setAcudiente(String acudiente) {
        this.acudiente = acudiente;
    }

    public BigInteger getCelularAcudiente() {
        return celularAcudiente;
    }

    public void setCelularAcudiente(BigInteger celularAcudiente) {
        this.celularAcudiente = celularAcudiente;
    }

    @XmlTransient
    public Collection<Tutorias> getTutoriasCollection() {
        return tutoriasCollection;
    }

    public void setTutoriasCollection(Collection<Tutorias> tutoriasCollection) {
        this.tutoriasCollection = tutoriasCollection;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @XmlTransient
    public Collection<BolsaPagos> getBolsaPagosCollection() {
        return bolsaPagosCollection;
    }

    public void setBolsaPagosCollection(Collection<BolsaPagos> bolsaPagosCollection) {
        this.bolsaPagosCollection = bolsaPagosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstudiantes != null ? idEstudiantes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiantes)) {
            return false;
        }
        Estudiantes other = (Estudiantes) object;
        if ((this.idEstudiantes == null && other.idEstudiantes != null) || (this.idEstudiantes != null && !this.idEstudiantes.equals(other.idEstudiantes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  + idEstudiantes + " ";
    }
    
}
