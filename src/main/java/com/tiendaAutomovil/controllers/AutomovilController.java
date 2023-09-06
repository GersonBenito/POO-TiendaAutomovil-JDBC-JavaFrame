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
    public Automovil findById(Long id){
        return automovilRepository.findById(id);
    }
    
    public ArrayList<Automovil> findAll(){
        return automovilRepository.findAll();
    }
    
    public void save(Automovil automovil){
        automovilRepository.save(automovil);
    }
    
    public void deleteById(Long id){
        automovilRepository.deleteById(id);
    }
    
    public void update(Automovil automovil, Long id){
        automovilRepository.update(automovil, id);
    }
}
