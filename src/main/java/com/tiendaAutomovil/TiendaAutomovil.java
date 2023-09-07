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

        // guardar
        /*automovilControlador.save("Lamborghini Huracán", "Lamborghini",
                "639 CV a 8000 rpm y 565 nm a 6500 rpm",
                "Verde","P 1-DBE",2, 262.042
        );*/
        
        ArrayList<Automovil> automovilList = automovilControlador.findAll();
        
        if(!automovilList.isEmpty()){
            for(Automovil automovil : automovilList){
                System.out.println("Id: " + automovil.getId());
                System.out.println("Marca: " + automovil.getMarca());
            }
        }

        // obtener un solo registro
        Automovil automovil = automovilControlador.findById(2);
        System.out.println("Registro find by id: " + automovil.getModelo());

        // eliminar un registro
        //automovilControlador.deleteById(4);

        // actualizar registro
        automovilControlador.update(5, "Lamborghini Huracán", "Lamborghini",
                "639 CV a 8000 rpm y 565 nm a 6500 rpm",
                "Verde","P 1-DBE",2, 262.042);
    }
}
