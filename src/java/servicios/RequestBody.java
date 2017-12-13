/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import conector.Busqueda;
import conector.Usuario;

/**
 *
 * @author Beta
 */
public class RequestBody {
    public Busqueda busqueda;
    public Usuario usuario;
    
    public RequestBody(){
    }

    public Busqueda getBusqueda() {
        return busqueda;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setBusqueda(Busqueda busqueda) {
        this.busqueda = busqueda;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
