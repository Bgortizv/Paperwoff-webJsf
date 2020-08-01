package jpa.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.entidades.Asignatura;
import jpa.entidades.Tutores;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-01T13:39:56")
@StaticMetamodel(Asignaturaxtutor.class)
public class Asignaturaxtutor_ { 

    public static volatile SingularAttribute<Asignaturaxtutor, Boolean> estado;
    public static volatile SingularAttribute<Asignaturaxtutor, Asignatura> asignatura;
    public static volatile SingularAttribute<Asignaturaxtutor, Long> idAxT;
    public static volatile SingularAttribute<Asignaturaxtutor, Tutores> tutores;

}