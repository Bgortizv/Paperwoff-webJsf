package jpa.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.entidades.Users;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-02T17:59:08")
@StaticMetamodel(Roles.class)
public class Roles_ { 

    public static volatile SingularAttribute<Roles, Integer> idRole;
    public static volatile SingularAttribute<Roles, String> nombreRol;
    public static volatile CollectionAttribute<Roles, Users> usersCollection;

}