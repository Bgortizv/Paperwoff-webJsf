/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entidades;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "bolsa_pagos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BolsaPagos.findAll", query = "SELECT b FROM BolsaPagos b")
    , @NamedQuery(name = "BolsaPagos.findByIdBolsaPagos", query = "SELECT b FROM BolsaPagos b WHERE b.idBolsaPagos = :idBolsaPagos")
    , @NamedQuery(name = "BolsaPagos.findByTotalAbonos", query = "SELECT b FROM BolsaPagos b WHERE b.totalAbonos = :totalAbonos")
    , @NamedQuery(name = "BolsaPagos.findByTotalDescuentos", query = "SELECT b FROM BolsaPagos b WHERE b.totalDescuentos = :totalDescuentos")})
public class BolsaPagos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Bolsa_Pagos", nullable = false)
    private Long idBolsaPagos;
    @Column(name = "Total_Abonos")
    private BigInteger totalAbonos;
    @Column(name = "Total_Descuentos")
    private BigInteger totalDescuentos;
    @JoinColumn(name = "Estudiantes_id_Estudiantes", referencedColumnName = "id_Estudiantes", nullable = false)
    @ManyToOne(optional = false)
    private Estudiantes estudiantes;

    public BolsaPagos() {
    }

    public BolsaPagos(Long idBolsaPagos) {
        this.idBolsaPagos = idBolsaPagos;
    }

    public Long getIdBolsaPagos() {
        return idBolsaPagos;
    }

    public void setIdBolsaPagos(Long idBolsaPagos) {
        this.idBolsaPagos = idBolsaPagos;
    }

    public BigInteger getTotalAbonos() {
        return totalAbonos;
    }

    public void setTotalAbonos(BigInteger totalAbonos) {
        this.totalAbonos = totalAbonos;
    }

    public BigInteger getTotalDescuentos() {
        return totalDescuentos;
    }

    public void setTotalDescuentos(BigInteger totalDescuentos) {
        this.totalDescuentos = totalDescuentos;
    }

    public Estudiantes getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Estudiantes estudiantes) {
        this.estudiantes = estudiantes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBolsaPagos != null ? idBolsaPagos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BolsaPagos)) {
            return false;
        }
        BolsaPagos other = (BolsaPagos) object;
        if ((this.idBolsaPagos == null && other.idBolsaPagos != null) || (this.idBolsaPagos != null && !this.idBolsaPagos.equals(other.idBolsaPagos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entidades.BolsaPagos[ idBolsaPagos=" + idBolsaPagos + " ]";
    }
    
}
