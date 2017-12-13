/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import conector.Vuelo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import pilotadores.GestionarBusquedas;
import pilotadores.GestionarUsuarios;
/**
 * REST Web Service
 *
 * @author Beta
 */
@Path("buscar")
public class ServiciosBusqueda {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public ServiciosBusqueda() {
    }

    /**
     * Retrieves representation of an instance of alumnado.GenericResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("prueba")
    @Produces(MediaType.TEXT_PLAIN)
    public String getPrueba() {

        return "Funciona!!!!!";
    }

    @POST
    @Path("busqueda/{origen}/{destino}/{id}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public String buscar(@PathParam("origen") String origen, @PathParam("destino") String destino, @PathParam("id") int id) {
        try{
            if(GestionarBusquedas.encontrarBusquedaSalidaYDestino(origen, destino).getSalida() != null){
                GestionarBusquedas.addBusqueda(GestionarBusquedas.encontrarBusquedaSalidaYDestino(origen, destino), GestionarUsuarios.encontrarUsuario(id));
            }else{
                GestionarBusquedas.nuevaBusqueda(origen, destino, GestionarUsuarios.encontrarUsuario(id));
            }
            
            List<Vuelo> vuelos = GestionarBusquedas.listarVuelos(origen, destino);
            String json = vuelos.get(0).generarJson();
            return json;
        }catch(Exception e){
            return "JA";
        }
    }
    
    @GET
    @Path("listar/{origen}/{destino}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public String listarVuelos(@PathParam("origen") String origen, @PathParam("destino") String destino) {
        try{            
            List<Vuelo> vuelos = GestionarBusquedas.listarVuelos(origen, destino);
            String json = vuelos.get(0).generarJson();
            return json;
        }catch(Exception e){
            return "JA";
        }
    }
    
}
