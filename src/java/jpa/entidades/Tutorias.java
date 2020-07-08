/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gus
 */
@Entity
@Table(name = "tutorias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tutorias.findAll", query = "SELECT t FROM Tutorias t")
    , @NamedQuery(name = "Tutorias.findByIdTutorias", query = "SELECT t FROM Tutorias t WHERE t.idTutorias = :idTutorias")
    , @NamedQuery(name = "Tutorias.findByFecha", query = "SELECT t FROM Tutorias t WHERE t.fecha = :fecha")
    , @NamedQuery(name = "Tutorias.findByCreacion", query = "SELECT t FROM Tutorias t WHERE t.creacion = :creacion")
    , @NamedQuery(name = "Tutorias.findByTransporte", query = "SELECT t FROM Tutorias t WHERE t.transporte = :transporte")
    , @NamedQuery(name = "Tutorias.findByTotal", query = "SELECT t FROM Tutorias t WHERE t.total = :total")
    , @NamedQuery(name = "Tutorias.findByHorainicio", query = "SELECT t FROM Tutorias t WHERE t.horainicio = :horainicio")
    , @NamedQuery(name = "Tutorias.findByHorafin", query = "SELECT t FROM Tutorias t WHERE t.horafin = :horafin")
    , @NamedQuery(name = "Tutorias.findByCantidadHoras", query = "SELECT t FROM Tutorias t WHERE t.cantidadHoras = :cantidadHoras")
    , @NamedQuery(name = "Tutorias.findByPaga", query = "SELECT t FROM Tutorias t WHERE t.paga = :paga")})
public class Tutorias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Tutorias")
    private Long idTutorias;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "Creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creacion;
    @Column(name = "Transporte")
    private Integer transporte;
    @Column(name = "Total")
    private Integer total;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Hora_inicio")
    @Temporal(TemporalType.TIME)
    private Date horainicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Hora_fin")
    @Temporal(TemporalType.TIME)
    private Date horafin;
    @Column(name = "Cantidad_Horas")
    private Integer cantidadHoras;
    @Column(name = "Paga")
    private Boolean paga;
    @JoinColumn(name = "Users_id_User", referencedColumnName = "id_User")
    @ManyToOne(optional = false)
    private Users usersidUser;
    @JoinColumn(name = "Tutores_id_Tutores", referencedColumnName = "id_Tutores")
    @ManyToOne(optional = false)
    private Tutores tutoresidTutores;
    @JoinColumn(name = "Asignatura_id_Asignatura", referencedColumnName = "id_Asignatura")
    @ManyToOne(optional = false)
    private Asignatura asignaturaidAsignatura;
    @JoinColumn(name = "Estudiantes_id_Estudiantes", referencedColumnName = "id_Estudiantes")
    @ManyToOne(optional = false)
    private Estudiantes estudiantesidEstudiantes;
    @JoinColumn(name = "Tipo_Clase_id_Tipo_Clase", referencedColumnName = "id_Tipo_Clase")
    @ManyToOne(optional = false)
    private TipoClase tipoClaseidTipoClase;
    @JoinColumn(name = "VirPres_id_VirPres", referencedColumnName = "id_VirPres")
    @ManyToOne(optional = false)
    private Virpres virPresidVirPres;

    public Tutorias() {
    }

    public Tutorias(Long idTutorias) {
        this.idTutorias = idTutorias;
    }

    public Tutorias(Long idTutorias, Date horainicio, Date horafin) {
        this.idTutorias = idTutorias;
        this.horainicio = horainicio;
        this.horafin = horafin;
    }

    public Long getIdTutorias() {
        return idTutorias;
    }

    public void setIdTutorias(Long idTutorias) {
        this.idTutorias = idTutorias;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getCreacion() {
        return creacion;
    }

    public void setCreacion(Date creacion) {
        this.creacion = creacion;
    }

    public Integer getTransporte() {
        return transporte;
    }

    public void setTransporte(Integer transporte) {
        this.transporte = transporte;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Date getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(Date horainicio) {
        this.horainicio = horainicio;
    }

    public Date getHorafin() {
        return horafin;
    }

    public void setHorafin(Date horafin) {
        this.horafin = horafin;
    }

    public Integer getCantidadHoras() {
        return cantidadHoras;
    }

    public void setCantidadHoras(Integer cantidadHoras) {
        this.cantidadHoras = cantidadHoras;
    }

    public Boolean getPaga() {
        return paga;
    }

    public void setPaga(Boolean paga) {
        this.paga = paga;
    }

    public Users getUsersidUser() {
        return usersidUser;
    }

    public void setUsersidUser(Users usersidUser) {
        this.usersidUser = usersidUser;
    }

    public Tutores getTutoresidTutores() {
        return tutoresidTutores;
    }

    public void setTutoresidTutores(Tutores tutoresidTutores) {
        this.tutoresidTutores = tutoresidTutores;
    }

    public Asignatura getAsignaturaidAsignatura() {
        return asignaturaidAsignatura;
    }

    public void setAsignaturaidAsignatura(Asignatura asignaturaidAsignatura) {
        this.asignaturaidAsignatura = asignaturaidAsignatura;
    }

    public Estudiantes getEstudiantesidEstudiantes() {
        return estudiantesidEstudiantes;
    }

    public void setEstudiantesidEstudiantes(Estudiantes estudiantesidEstudiantes) {
        this.estudiantesidEstudiantes = estudiantesidEstudiantes;
    }

    public TipoClase getTipoClaseidTipoClase() {
        return tipoClaseidTipoClase;
    }

    public void setTipoClaseidTipoClase(TipoClase tipoClaseidTipoClase) {
        this.tipoClaseidTipoClase = tipoClaseidTipoClase;
    }

    public Virpres getVirPresidVirPres() {
        return virPresidVirPres;
    }

    public void setVirPresidVirPres(Virpres virPresidVirPres) {
        this.virPresidVirPres = virPresidVirPres;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTutorias != null ? idTutorias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tutorias)) {
            return false;
        }
        Tutorias other = (Tutorias) object;
        if ((this.idTutorias == null && other.idTutorias != null) || (this.idTutorias != null && !this.idTutorias.equals(other.idTutorias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entidades.Tutorias[ idTutorias=" + idTutorias + " ]";
    }
    
}
