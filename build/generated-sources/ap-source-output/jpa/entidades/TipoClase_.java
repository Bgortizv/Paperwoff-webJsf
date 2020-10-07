package jpa.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.entidades.Tutorias;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-02T17:59:08")
@StaticMetamodel(TipoClase.class)
public class TipoClase_ { 

    public static volatile SingularAttribute<TipoClase, String> descripcion;
    public static volatile SingularAttribute<TipoClase, Long> idTipoClase;
    public static volatile CollectionAttribute<TipoClase, Tutorias> tutoriasCollection;

}