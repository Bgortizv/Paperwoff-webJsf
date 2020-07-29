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
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findByIdUser", query = "SELECT u FROM Users u WHERE u.idUser = :idUser")
    , @NamedQuery(name = "Users.findByDocumento", query = "SELECT u FROM Users u WHERE u.documento = :documento")
    , @NamedQuery(name = "Users.findByNombre", query = "SELECT u FROM Users u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Users.findByApellidos", query = "SELECT u FROM Users u WHERE u.apellidos = :apellidos")
    , @NamedQuery(name = "Users.findByEMail", query = "SELECT u FROM Users u WHERE u.eMail = :eMail")
    , @NamedQuery(name = "Users.findByCelular", query = "SELECT u FROM Users u WHERE u.celular = :celular")
    , @NamedQuery(name = "Users.findByEstado", query = "SELECT u FROM Users u WHERE u.estado = :estado")
    , @NamedQuery(name = "Users.findByDireccion", query = "SELECT u FROM Users u WHERE u.direccion = :direccion")
    , @NamedQuery(name = "Users.findByCargo", query = "SELECT u FROM Users u WHERE u.cargo = :cargo")
    , @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_User", nullable = false)
    private Long idUser;
    @Column(name = "Documento")
    private BigInteger documento;
   
    @Column(name = "Nombre", length = 20)
    private String nombre;

    @Column(name = "Apellidos", length = 20)
    private String apellidos;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
 
    @Column(name = "e_mail", length = 30)
    private String eMail;
    @Column(name = "Celular")
    private BigInteger celular;
    @Column(name = "Estado")
    private Boolean estado;
   
    @Column(name = "Direccion", length = 30)
    private String direccion;

    @Column(name = "Cargo", length = 30)
    private String cargo;
 
    @Column(name = "Password", length = 512)
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private Collection<Tutorias> tutoriasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private Collection<Estudiantes> estudiantesCollection;
    @JoinColumn(name = "Role_id_role", referencedColumnName = "id_Role", nullable = false)
    @ManyToOne(optional = false)
    private Roles roles;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private Collection<Tutores> tutoresCollection;

    public Users() {
    }

    public Users(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public BigInteger getDocumento() {
        return documento;
    }

    public void setDocumento(BigInteger documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public BigInteger getCelular() {
        return celular;
    }

    public void setCelular(BigInteger celular) {
        this.celular = celular;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<Tutorias> getTutoriasCollection() {
        return tutoriasCollection;
    }

    public void setTutoriasCollection(Collection<Tutorias> tutoriasCollection) {
        this.tutoriasCollection = tutoriasCollection;
    }

    @XmlTransient
    public Collection<Estudiantes> getEstudiantesCollection() {
        return estudiantesCollection;
    }

    public void setEstudiantesCollection(Collection<Estudiantes> estudiantesCollection) {
        this.estudiantesCollection = estudiantesCollection;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    @XmlTransient
    public Collection<Tutores> getTutoresCollection() {
        return tutoresCollection;
    }

    public void setTutoresCollection(Collection<Tutores> tutoresCollection) {
        this.tutoresCollection = tutoresCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idUser + "";
    }
    
}
