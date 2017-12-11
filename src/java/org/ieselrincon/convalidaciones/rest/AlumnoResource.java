/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ieselrincon.convalidaciones.rest;

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
/**
 * REST Web Service
 *
 * @author Tiburcio
 */
@Path("alumno")
public class AlumnoResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public AlumnoResource() {
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
    @Path("busqueda/{origen}/{destino}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String buscar(@PathParam("origen") String origen, @PathParam("destino") String destino) {
        String result = "";
        try{
            GestionarBusquedas.nuevaBusqueda(origen, destino);
            result = "fuck yeah";
        }catch(Exception e){
            result= "fuck you";
        }
        return result;
    }
}
