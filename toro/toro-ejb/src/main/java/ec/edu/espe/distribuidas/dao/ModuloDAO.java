/*
 * ESPE - DCC - APLICACIONES DISTRIBUIDAS
 * Sistema: Global-ejb
 * 
 * Creado: 17/12/2019 - 15:53:18
 * 
 * Los contenidos de este archivo son propiedad privada y estan protegidos por la licencia BSD.
 * 
 * 
 * Se puede utilizar, reproducir o copiar el contenido de este archivo.
 */
package ec.edu.espe.distribuidas.dao;

import ec.edu.espe.distribuidas.model.Modulo;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Permite manejar las operaciones de insert, update, delete y select para la
 * entidad Modulo.
 *
 * @author Toro Jordan
 * @author Rodríguez Fernando
 */
@LocalBean
@Stateless
public class ModuloDAO extends AbstractDAO<Modulo> {

    public ModuloDAO() {
        super(Modulo.class);
    }

}
