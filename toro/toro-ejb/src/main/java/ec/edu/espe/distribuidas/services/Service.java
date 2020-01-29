/*
 * ESPE - DCC - APLICACIONES DISTRIBUIDAS
 * Sistema: Global
 * 
 * Creado: 17/12/2019 - 18:46:24
 * 
 * Los contenidos de este archivo son propiedad privada y estan protegidos por la licencia BSD.
 * 
 * 
 * Se puede utilizar, reproducir o copiar el contenido de este archivo.
 */
package ec.edu.espe.distribuidas.services;

import ec.edu.espe.distribuidas.dao.FuncionalidadDAO;
import ec.edu.espe.distribuidas.dao.ModuloDAO;
import ec.edu.espe.distribuidas.enums.EstadoActivoInactivoEnum;
import ec.edu.espe.distribuidas.model.Funcionalidad;
import ec.edu.espe.distribuidas.model.Modulo;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * Clase que implementa los servicios para el manejo de la tabla SEG_MODULO. Los
 * servicios de esta clase estan relacionados con operaciones CRUD y busqueda.
 *
 * @author Toro Jordan
 * @author Rodriguez Fernando
 */
@Stateless
@LocalBean
public class Service {

    @EJB
    private ModuloDAO moduloDao;

    @EJB
    private FuncionalidadDAO funcionalidadDao;

    /**
     * Obtiene un listado de Modulos.
     *
     * @return Listado Modulos en base al estado.
     */
    public List<Modulo> obtenerTodos() {
        return moduloDao.findAll();
    }

    /**
     * Crea una nueva Funcionalidad.
     *
     * @param modulo el modulo por el cual se va a realziar la busqueda
     * @return Un listado de funcionalidades en base al codigo del modulo
     */
    public List<Funcionalidad> buscarFuncionalidadPorModulo(Modulo modulo) {

        return funcionalidadDao.findByCodModulo(modulo.getCodigo());
    }

    /**
     * Crea una nueva Funcionalidad.
     *
     * @param funcionalidad La funcionalidad que va a ser creada en la base de
     * datos.
     */
    public void crearFuncionalidad(Funcionalidad funcionalidad) {

        funcionalidadDao.create(funcionalidad);
    }

    /**
     * Elimina una funcionalidad.
     *
     * @param funcionalidad La funcionalidad a ser eliminada.
     */
    public void eliminarFuncionalidad(Funcionalidad funcionalidad) {
        funcionalidadDao.remove(funcionalidad);
    }
}
