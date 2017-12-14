/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import com.google.gson.Gson;
import conector.Usuario;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import pilotadores.GestionarUsuarios;

/**
 *
 * @author Beta
 */
@Path("usuario")
public class ServiciosUsuario {
    @Context
    private UriInfo context;
    
    public ServiciosUsuario(){
    }
    
    @POST
    @Path("registro")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String buscar(String json) {
        try{
            Usuario usuario = new Gson().fromJson(json, Usuario.class);
            GestionarUsuarios.nuevoUsuario("02/02/2222", usuario.getContrasena(), usuario.getNombre());
            
            return "HA";
        }catch(Exception e){
            return "JA";
        }
    }
}
