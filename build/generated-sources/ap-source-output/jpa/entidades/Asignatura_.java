package jpa.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.entidades.Asignaturaxtutor;
import jpa.entidades.DetalleFactura;
import jpa.entidades.Tutorias;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-02T17:59:08")
@StaticMetamodel(Asignatura.class)
public class Asignatura_ { 

    public static volatile CollectionAttribute<Asignatura, DetalleFactura> detalleFacturaCollection;
    public static volatile SingularAttribute<Asignatura, Integer> código;
    public static volatile SingularAttribute<Asignatura, Long> idAsignatura;
    public static volatile CollectionAttribute<Asignatura, Asignaturaxtutor> asignaturaxtutorCollection;
    public static volatile SingularAttribute<Asignatura, String> nombreAsignatura;
    public static volatile CollectionAttribute<Asignatura, Tutorias> tutoriasCollection;

}