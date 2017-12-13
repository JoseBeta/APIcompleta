/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import conector.Busqueda;
import conector.Reserva;
import conector.Usuario;
import pilotadores.GestionarReservas;
import pilotadores.GestionarUsuarios;

/**
 *
 * @author Beta
 */
public class NewClass {
    public static void main(String[] args){
            Usuario usuario = GestionarUsuarios.encontrarUsuario(1);

        System.out.println(usuario.generarJson());
        
    }
}
