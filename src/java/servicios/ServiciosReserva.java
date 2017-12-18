/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import com.google.gson.Gson;
import conector.Busqueda;
import conector.Reserva;
import conector.Usuario;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import pilotadores.GestionarBusquedas;
import pilotadores.GestionarReservas;
import pilotadores.GestionarVuelos;

/**
 *
 * @author José Betancor Pérez
 */
@Path("reservar")
public class ServiciosReserva {
    
    @Context
    private UriInfo context;
    
    public ServiciosReserva(){
    }
    
    @GET
    @Path("encontrar/{id}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public String encontrar(@PathParam("id") int id){
        try{
            Reserva reserva = GestionarReservas.encontrarReserva(id);
            
            return reserva.generarJson();
        }catch(Exception e){
            return null;
        }
    }
    
    @POST
    @Path("reserva")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String reservar(Reserva reserva) {
        try{
  
            GestionarReservas.nuevaReserva(reserva.getUsuario(), reserva.getVuelo());            
            return "1";
        }catch(Exception e){
            return "0";
        }
    }
    
    @PUT
    @Path("modificar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String modificar(Reserva reserva) {
        try{
  
            GestionarReservas.modificarReserva(reserva, reserva.getVuelo());            
            return "1";
        }catch(Exception e){
            return "0";
        }
    }
    
    @DELETE
    @Path("borrar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String borrar(Reserva reserva) {
        try{
  
            GestionarReservas.borrarReserva(reserva.getId());            
            return "1";
        }catch(Exception e){
            return "0";
        }
    }
}
