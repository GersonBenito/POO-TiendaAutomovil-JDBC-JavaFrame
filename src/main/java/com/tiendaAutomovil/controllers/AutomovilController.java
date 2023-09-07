package com.tiendaAutomovil.controllers;

import com.tiendaAutomovil.repository.AutomovilRepository;
import com.tiendaAutomovil.entities.Automovil;
import java.util.ArrayList;

/**
 *
 * @author Gerson Benito
 */

// ----- A este controlador se debe de conectar la interfaz 
public class AutomovilController {
    
    private static AutomovilRepository automovilRepository = new AutomovilRepository();
    
    // obtener un registro por id
    public Automovil findById(int id){
        return automovilRepository.findById(id);
    }
    
    public ArrayList<Automovil> findAll(){
        return automovilRepository.findAll();
    }
    
    public void save(
        String modelo, String marca, String motor, String color,
        String placa, int numero_puerta, double precio
    ){
        Automovil automovil = new Automovil();
        automovil.setId(0);
        automovil.setModelo(modelo);
        automovil.setMarca(marca);
        automovil.setMotor(motor);
        automovil.setColor(color);
        automovil.setPlaca(placa);
        automovil.setNumero_puerta(numero_puerta);
        automovil.setPrecio(precio);
        automovilRepository.save(automovil);
    }
    
    public void deleteById(int id){
        automovilRepository.deleteById(id);
    }
    
    public void update(
            int id, String modelo, String marca, String motor, String color,
            String placa, int numero_puerta, double precio
    ){
        Automovil automovil = new Automovil();
        automovil.setModelo(modelo);
        automovil.setMarca(marca);
        automovil.setMotor(motor);
        automovil.setColor(color);
        automovil.setPlaca(placa);
        automovil.setNumero_puerta(numero_puerta);
        automovil.setPrecio(precio);

        automovilRepository.update(automovil, id);
    }
}
