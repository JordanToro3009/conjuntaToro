/*
 * ESPE - DCC - APLICACIONES DISTRIBUIDAS
 * Sistema: Global-web
 * 
 * Creado: 04/01/2020 - 14:30:51
 * 
 * Los contenidos de este archivo son propiedad privada y estan protegidos por la licencia BSD.
 * 
 * 
 * Se puede utilizar, reproducir o copiar el contenido de este archivo.
 */
package ec.edu.espe.distribuidas.beans;

import ec.edu.espe.distribuidas.enums.EstadoActivoInactivoEnum;
import ec.edu.espe.distribuidas.model.Funcionalidad;
import ec.edu.espe.distribuidas.model.Modulo;
import ec.edu.espe.distribuidas.services.Service;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

/**
 *
 * Implementación de todos los servicios de la clase ModuloService.
 *
 * @author Toro Jordan
 * @author Rodríguez Fernando
 */
@Named(value = "bean")
@ViewScoped
public class Bean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(Bean.class.getName());

    @Inject
    private Service service;

    private Modulo modulo;
    private List<Modulo> modulos;
    private Funcionalidad funcionalidad;
    private List<Funcionalidad> funcionalidades;

    private boolean isModuloSelected;
    private boolean isVisibleFuncionalidades;
    private boolean isFuncionalidadSelected;
    private boolean isMostrarDetalle;
    private boolean isNuevaFuncionalidad;
    private boolean isEliminarFuncionalidad;

    @PostConstruct
    public void init() {
        this.modulo = new Modulo();
        this.funcionalidad = new Funcionalidad();
        this.buscarTodos();
    }

    /**
     * Metodo que implementa el servicio para buscar todos los Modulos
     *
     */
    public void buscarTodos() {
        this.modulos = service.obtenerTodos();
    }

    public void selectModulo(SelectEvent event) {
        this.isModuloSelected = true;
    }

    public void unselectModulo(SelectEvent event) {
        this.isModuloSelected = false;
    }

    public void selectFuncionalidad(SelectEvent event) {
        this.isFuncionalidadSelected = true;
        this.isMostrarDetalle = false;
    }

    public void unselectFuncionalidad(SelectEvent event) {
        this.isFuncionalidadSelected = false;
        this.isMostrarDetalle = false;
    }

    /**
     * Metodo que implementa el servicio para obtener por PK o codigo un Modulo
     * registrado.
     */
    public void buscarFuncionalidadPorModulo() {
        funcionalidades = this.service.buscarFuncionalidadPorModulo(modulo);
        this.isVisibleFuncionalidades = true;
    }

    public void detalleFuncionalidad() {
        this.isMostrarDetalle = true;
    }

    public void cerrarDetalle() {
        this.isMostrarDetalle = false;
    }

    public void eliminarFuncionalidad() {
        this.service.eliminarFuncionalidad(funcionalidad);
    }

    public void dialogoEliminarFuncionalidad() {
        Map<String, Object> options = new HashMap<String, Object>();
        options.put("resizable", false);
        PrimeFaces.current().dialog().openDynamic("dialogoConfirmacion", options, null);
    }

    public void quitarDialogo() {

    }

    public void nuevaFuncionalidad() {
        this.isNuevaFuncionalidad = true;
    }

    public void cerrarNuevaFuncionalidad() {
        this.isNuevaFuncionalidad = false;
    }

    /**
     * Metodo que implementa el servicio para crear un Modulo
     *
     */
    public void crearFuncionalidad() {

    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public Funcionalidad getFuncionalidad() {
        return funcionalidad;
    }

    public void setFuncionalidad(Funcionalidad funcionalidad) {
        this.funcionalidad = funcionalidad;
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    public List<Funcionalidad> getFuncionalidades() {
        return funcionalidades;
    }

    public boolean isIsModuloSelected() {
        return isModuloSelected;
    }

    public boolean isIsFuncionalidadSelected() {
        return isFuncionalidadSelected;
    }

    public boolean isIsVisibleFuncionalidades() {
        return isVisibleFuncionalidades;
    }

    public boolean isIsMostrarDetalle() {
        return isMostrarDetalle;
    }

    public boolean isIsNuevaFuncionalidad() {
        return isNuevaFuncionalidad;
    }

}
