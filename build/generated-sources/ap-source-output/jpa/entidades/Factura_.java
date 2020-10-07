package jpa.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.entidades.DetalleFactura;
import jpa.entidades.Tutores;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-02T17:59:08")
@StaticMetamodel(Factura.class)
public class Factura_ { 

    public static volatile SingularAttribute<Factura, Date> fecha;
    public static volatile CollectionAttribute<Factura, DetalleFactura> detalleFacturaCollection;
    public static volatile SingularAttribute<Factura, Integer> total;
    public static volatile SingularAttribute<Factura, Tutores> tutores;
    public static volatile SingularAttribute<Factura, Long> idFactura;
    public static volatile SingularAttribute<Factura, Integer> totalhoras;
    public static volatile SingularAttribute<Factura, Date> fechaCreacion;
    public static volatile SingularAttribute<Factura, Date> incioPeriodo;
    public static volatile SingularAttribute<Factura, Date> finPeriodo;

}