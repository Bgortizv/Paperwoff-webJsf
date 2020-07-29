/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entidades;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gus
 */
@Entity
@Table(name = "asignaturaxtutor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignaturaxtutor.findAll", query = "SELECT a FROM Asignaturaxtutor a")
    , @NamedQuery(name = "Asignaturaxtutor.findByIdAxT", query = "SELECT a FROM Asignaturaxtutor a WHERE a.idAxT = :idAxT")
    , @NamedQuery(name = "Asignaturaxtutor.findByEstado", query = "SELECT a FROM Asignaturaxtutor a WHERE a.estado = :estado")})
public class Asignaturaxtutor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_AxT", nullable = false)
    private Long idAxT;
    @Column(name = "Estado")
    private Boolean estado;
    @JoinColumn(name = "Tutores_id_Tutores", referencedColumnName = "id_Tutores", nullable = false)
    @ManyToOne(optional = false)
    private Tutores tutores;
    @JoinColumn(name = "Asignatura_id_Asignatura", referencedColumnName = "id_Asignatura", nullable = false)
    @ManyToOne(optional = false)
    private Asignatura asignatura;

    public Asignaturaxtutor() {
    }

    public Asignaturaxtutor(Long idAxT) {
        this.idAxT = idAxT;
    }

    public Long getIdAxT() {
        return idAxT;
    }

    public void setIdAxT(Long idAxT) {
        this.idAxT = idAxT;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Tutores getTutores() {
        return tutores;
    }

    public void setTutores(Tutores tutores) {
        this.tutores = tutores;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAxT != null ? idAxT.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignaturaxtutor)) {
            return false;
        }
        Asignaturaxtutor other = (Asignaturaxtutor) object;
        if ((this.idAxT == null && other.idAxT != null) || (this.idAxT != null && !this.idAxT.equals(other.idAxT))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entidades.Asignaturaxtutor[ idAxT=" + idAxT + " ]";
    }
    
}
