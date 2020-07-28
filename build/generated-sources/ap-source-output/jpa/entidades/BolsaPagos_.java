package jpa.entidades;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.entidades.Estudiantes;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-27T20:30:37")
@StaticMetamodel(BolsaPagos.class)
public class BolsaPagos_ { 

    public static volatile SingularAttribute<BolsaPagos, BigInteger> totalDescuentos;
    public static volatile SingularAttribute<BolsaPagos, BigInteger> totalAbonos;
    public static volatile SingularAttribute<BolsaPagos, Estudiantes> estudiantes;
    public static volatile SingularAttribute<BolsaPagos, Long> idBolsaPagos;

}