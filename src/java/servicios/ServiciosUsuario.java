/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import com.google.gson.Gson;
import conector.Usuario;
import java.text.SimpleDateFormat;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    @Context
    private UriInfo context;
    
    public ServiciosUsuario(){
    }
    
    @POST
    @Path("registro")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String registro(String json) {
        try{
            Usuario usuario = new Gson().fromJson(json, Usuario.class);
            GestionarUsuarios.nuevoUsuario(sdf.format(usuario.getFNacimiento()), usuario.getContrasena(), usuario.getNombre());
            
            return "{\"registrado\": \"1\"}";
        }catch(Exception e){
            return "{\"registrado\": \"0\"}";
        }
    }
    
    @GET
    @Path("login/{nombre}/{contrasena}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public String login(@PathParam("nombre") String nombre,@PathParam("contrasena") String contrasena){
        try{
            GestionarUsuarios.login(nombre, contrasena);
            
            return "{\"registrado\": \"1\"}";
        }catch(Exception e){
            return "{\"registrado\": \"0\"}";
        }
    }
    
    @GET
    @Path("logeado/{nombre}/{contrasena}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public String usuarioLogeado(@PathParam("nombre") String nombre,@PathParam("contrasena") String contrasena){
        try{
            Usuario usuarioLogeado = GestionarUsuarios.getUsuarioNombreYPass(nombre, contrasena);
            
            return usuarioLogeado.generarJson();
        }catch(Exception e){
            return null;
        }
    }
}
