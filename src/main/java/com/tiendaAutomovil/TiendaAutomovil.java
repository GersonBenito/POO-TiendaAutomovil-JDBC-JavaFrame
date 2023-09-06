package com.tiendaAutomovil;

import com.tiendaAutomovil.controllers.AutomovilController;
import com.tiendaAutomovil.entities.Automovil;

import java.util.ArrayList;


/**
 *
 * @author Gerson Benito
 */
public class TiendaAutomovil {

    public static void main(String[] args) {
        // crear una instancia al controlador
        AutomovilController automovilControlador = new AutomovilController();
        
        ArrayList<Automovil> automovilList = automovilControlador.findAll();
        
        if(!automovilList.isEmpty()){
            for(Automovil automovil : automovilList){
                System.out.println("Id: " + automovil.getId());
                System.out.println("Marca: " + automovil.getMarca());
            }
        }
    }
}
