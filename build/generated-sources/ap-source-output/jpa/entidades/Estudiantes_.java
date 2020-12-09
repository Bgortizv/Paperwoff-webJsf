package jpa.entidades;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.entidades.BolsaPagos;
import jpa.entidades.Tutorias;
import jpa.entidades.Users;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-04T22:13:03")
@StaticMetamodel(Estudiantes.class)
public class Estudiantes_ { 

    public static volatile SingularAttribute<Estudiantes, Long> idEstudiantes;
    public static volatile SingularAttribute<Estudiantes, Integer> grado;
    public static volatile SingularAttribute<Estudiantes, BigInteger> celularAcudiente;
    public static volatile SingularAttribute<Estudiantes, String> acudiente;
    public static volatile CollectionAttribute<Estudiantes, BolsaPagos> bolsaPagosCollection;
    public static volatile CollectionAttribute<Estudiantes, Tutorias> tutoriasCollection;
    public static volatile SingularAttribute<Estudiantes, Users> users;

}