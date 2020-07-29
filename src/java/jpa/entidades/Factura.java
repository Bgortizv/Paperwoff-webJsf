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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gus
 */
@Entity
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
    , @NamedQuery(name = "Factura.findByIdFactura", query = "SELECT f FROM Factura f WHERE f.idFactura = :idFactura")
    , @NamedQuery(name = "Factura.findByFecha", query = "SELECT f FROM Factura f WHERE f.fecha = :fecha")
    , @NamedQuery(name = "Factura.findByTotal", query = "SELECT f FROM Factura f WHERE f.total = :total")
    , @NamedQuery(name = "Factura.findByFechaCreacion", query = "SELECT f FROM Factura f WHERE f.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Factura.findByIncioPeriodo", query = "SELECT f FROM Factura f WHERE f.incioPeriodo = :incioPeriodo")
    , @NamedQuery(name = "Factura.findByFinPeriodo", query = "SELECT f FROM Factura f WHERE f.finPeriodo = :finPeriodo")
    , @NamedQuery(name = "Factura.findByTotalhoras", query = "SELECT f FROM Factura f WHERE f.totalhoras = :totalhoras")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Factura", nullable = false)
    private Long idFactura;
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "Total")
    private Integer total;
    @Column(name = "Fecha_Creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Column(name = "Incio_Periodo")
    @Temporal(TemporalType.DATE)
    private Date incioPeriodo;
    @Column(name = "Fin_Periodo")
    @Temporal(TemporalType.DATE)
    private Date finPeriodo;
    @Column(name = "Total_horas")
    private Integer totalhoras;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factura")
    private Collection<DetalleFactura> detalleFacturaCollection;
    @JoinColumn(name = "Tutores_id_Tutores", referencedColumnName = "id_Tutores", nullable = false)
    @ManyToOne(optional = false)
    private Tutores tutores;

    public Factura() {
    }

    public Factura(Long idFactura) {
        this.idFactura = idFactura;
    }

    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getIncioPeriodo() {
        return incioPeriodo;
    }

    public void setIncioPeriodo(Date incioPeriodo) {
        this.incioPeriodo = incioPeriodo;
    }

    public Date getFinPeriodo() {
        return finPeriodo;
    }

    public void setFinPeriodo(Date finPeriodo) {
        this.finPeriodo = finPeriodo;
    }

    public Integer getTotalhoras() {
        return totalhoras;
    }

    public void setTotalhoras(Integer totalhoras) {
        this.totalhoras = totalhoras;
    }

    @XmlTransient
    public Collection<DetalleFactura> getDetalleFacturaCollection() {
        return detalleFacturaCollection;
    }

    public void setDetalleFacturaCollection(Collection<DetalleFactura> detalleFacturaCollection) {
        this.detalleFacturaCollection = detalleFacturaCollection;
    }

    public Tutores getTutores() {
        return tutores;
    }

    public void setTutores(Tutores tutores) {
        this.tutores = tutores;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFactura != null ? idFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.idFactura == null && other.idFactura != null) || (this.idFactura != null && !this.idFactura.equals(other.idFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entidades.Factura[ idFactura=" + idFactura + " ]";
    }
    
}
