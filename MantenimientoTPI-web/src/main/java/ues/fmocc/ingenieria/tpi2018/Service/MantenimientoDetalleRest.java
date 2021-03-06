package ues.fmocc.ingenieria.tpi2018.Service;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import ues.fmoocc.ingenieria.tpi2018.Entities.Mantenimientodetalle;
import ues.fmoocc.ingenieria.tpi2018.Sessions.MantenimientodetalleFacadeLocal;


/**
 *
 * @author yisusdebian
 */
@Path("mantenimientodetalle")
public class MantenimientoDetalleRest implements Serializable{
    
    @EJB
    private MantenimientodetalleFacadeLocal ejbMantDetalle;

    //devuelve todo
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Mantenimientodetalle> findall() {
        List salida = null;
        try {
            if (ejbMantDetalle != null) {
                return ejbMantDetalle.findAll();
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }

        return salida;
    }

    @Path("count")
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    public Integer count() {

        try {
            if (ejbMantDetalle != null) {
                return ejbMantDetalle.count();
            }

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return 0;
    }

    //busca uno en particular
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Mantenimientodetalle findById(
            @PathParam("id") Integer id
    ) {
        try {
            if (ejbMantDetalle != null) {
                return ejbMantDetalle.find(id);
            }

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return new Mantenimientodetalle();
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        try {
            if (id != null && this.ejbMantDetalle != null) {
                ejbMantDetalle.remove(ejbMantDetalle.find(id));
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Mantenimientodetalle entity) {

        try {
            if (this.ejbMantDetalle != null) {
                ejbMantDetalle.create(entity);
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, Mantenimientodetalle entity) {

        try {
            if (this.ejbMantDetalle != null) {
                ejbMantDetalle.edit(entity);
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }

}
