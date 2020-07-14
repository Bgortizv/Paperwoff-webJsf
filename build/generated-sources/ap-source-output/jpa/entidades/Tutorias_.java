package jpa.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.entidades.Asignatura;
import jpa.entidades.Estudiantes;
import jpa.entidades.TipoClase;
import jpa.entidades.Tutores;
import jpa.entidades.Users;
import jpa.entidades.Virpres;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-13T19:08:40")
@StaticMetamodel(Tutorias.class)
public class Tutorias_ { 

    public static volatile SingularAttribute<Tutorias, Estudiantes> estudiantesidEstudiantes;
    public static volatile SingularAttribute<Tutorias, Integer> cantidadHoras;
    public static volatile SingularAttribute<Tutorias, Users> usersidUser;
    public static volatile SingularAttribute<Tutorias, Integer> transporte;
    public static volatile SingularAttribute<Tutorias, Date> creacion;
    public static volatile SingularAttribute<Tutorias, Date> horainicio;
    public static volatile SingularAttribute<Tutorias, Date> fecha;
    public static volatile SingularAttribute<Tutorias, Integer> total;
    public static volatile SingularAttribute<Tutorias, Date> horafin;
    public static volatile SingularAttribute<Tutorias, Tutores> tutoresidTutores;
    public static volatile SingularAttribute<Tutorias, Virpres> virPresidVirPres;
    public static volatile SingularAttribute<Tutorias, Long> idTutorias;
    public static volatile SingularAttribute<Tutorias, Asignatura> asignaturaidAsignatura;
    public static volatile SingularAttribute<Tutorias, TipoClase> tipoClaseidTipoClase;
    public static volatile SingularAttribute<Tutorias, Boolean> paga;

}