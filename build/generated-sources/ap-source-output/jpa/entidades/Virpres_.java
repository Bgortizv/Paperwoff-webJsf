package jpa.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.entidades.Tutorias;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-01T13:39:56")
@StaticMetamodel(Virpres.class)
public class Virpres_ { 

    public static volatile SingularAttribute<Virpres, String> descrip;
    public static volatile SingularAttribute<Virpres, Long> idVirPres;
    public static volatile CollectionAttribute<Virpres, Tutorias> tutoriasCollection;

}