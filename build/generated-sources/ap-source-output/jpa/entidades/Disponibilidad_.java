package jpa.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.entidades.Tutores;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-13T19:08:40")
@StaticMetamodel(Disponibilidad.class)
public class Disponibilidad_ { 

    public static volatile SingularAttribute<Disponibilidad, Date> fecha;
    public static volatile SingularAttribute<Disponibilidad, Date> horafin;
    public static volatile SingularAttribute<Disponibilidad, Tutores> tutoresidTutores;
    public static volatile SingularAttribute<Disponibilidad, Date> horainicio;
    public static volatile SingularAttribute<Disponibilidad, Long> idDisponibilidad;

}