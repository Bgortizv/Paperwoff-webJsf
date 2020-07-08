package jpa.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.entidades.Asignatura;
import jpa.entidades.Factura;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-10T21:56:07")
@StaticMetamodel(DetalleFactura.class)
public class DetalleFactura_ { 

    public static volatile SingularAttribute<DetalleFactura, Integer> cantidadHoras;
    public static volatile SingularAttribute<DetalleFactura, Integer> valorTotal;
    public static volatile SingularAttribute<DetalleFactura, Factura> facturaidFactura;
    public static volatile SingularAttribute<DetalleFactura, Asignatura> asignaturaidAsignatura;
    public static volatile SingularAttribute<DetalleFactura, Long> idDetalleFactura;

}