package jpa.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.entidades.Asignaturaxtutor;
import jpa.entidades.Disponibilidad;
import jpa.entidades.Factura;
import jpa.entidades.Tutorias;
import jpa.entidades.Users;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-02T17:59:08")
@StaticMetamodel(Tutores.class)
public class Tutores_ { 

    public static volatile SingularAttribute<Tutores, Date> fechaIngreso;
    public static volatile CollectionAttribute<Tutores, Disponibilidad> disponibilidadCollection;
    public static volatile SingularAttribute<Tutores, Long> idTutores;
    public static volatile CollectionAttribute<Tutores, Asignaturaxtutor> asignaturaxtutorCollection;
    public static volatile SingularAttribute<Tutores, String> profesion;
    public static volatile CollectionAttribute<Tutores, Tutorias> tutoriasCollection;
    public static volatile SingularAttribute<Tutores, Users> users;
    public static volatile CollectionAttribute<Tutores, Factura> facturaCollection;

}