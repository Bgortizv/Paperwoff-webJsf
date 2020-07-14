package jpa.entidades;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.entidades.Estudiantes;
import jpa.entidades.Tutores;
import jpa.entidades.Tutorias;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-13T19:58:09")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> apellidos;
    public static volatile SingularAttribute<Users, Boolean> estado;
    public static volatile SingularAttribute<Users, String> role;
    public static volatile SingularAttribute<Users, String> direccion;
    public static volatile SingularAttribute<Users, BigInteger> documento;
    public static volatile SingularAttribute<Users, String> nombre;
    public static volatile CollectionAttribute<Users, Tutorias> tutoriasCollection;
    public static volatile CollectionAttribute<Users, Tutores> tutoresCollection;
    public static volatile SingularAttribute<Users, String> eMail;
    public static volatile SingularAttribute<Users, Long> idUser;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, BigInteger> celular;
    public static volatile CollectionAttribute<Users, Estudiantes> estudiantesCollection;
    public static volatile SingularAttribute<Users, String> cargo;

}