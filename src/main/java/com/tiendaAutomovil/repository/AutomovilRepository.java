package com.tiendaAutomovil.repository;
import com.tiendaAutomovil.entities.Automovil;
import com.tiendaAutomovil.persistence.database.DatabaseConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gerson Benito
 */
public class AutomovilRepository {
    
    // crear instancia de conexion a la base de datos
    DatabaseConnector databaseconnector = DatabaseConnector.getInstance();
    
    // aqui es donde van a ir las consultas a la base de datos
    
    public Automovil findById(Long id){
        Automovil automovil = new Automovil(1L, "test", "test","test", "test", "test", "test", 4, 25000D);
        return automovil;
    }
    
    public ArrayList<Automovil> findAll(){
        
        ArrayList<Automovil> automovilList = new ArrayList<>();
        //Automovil automovil = null;

        databaseconnector.connectDatabase();
        
        try{
            String query = "SELECT * FROM automovil";
            ResultSet resultSet = databaseconnector.executeQuerySQL(query);

            while(resultSet.next()){
                // crear instacia de la entidad
                Automovil automovil = new Automovil();
                
                // asignar los datos
                automovil.setId(resultSet.getLong("id"));
                automovil.setModelo(resultSet.getString("modelo"));
                automovil.setMarca(resultSet.getString("marca"));
                automovil.setMotor(resultSet.getString("motor"));
                automovil.setColor(resultSet.getString("color"));
                automovil.setPlaca(resultSet.getString("placa"));
                automovil.setNumero_puerta(resultSet.getInt("numero_puerta"));
                automovil.setPrecio(resultSet.getDouble("precio"));
                
                // asignar la clae a la lista
                automovilList.add(automovil);
            }
            
            // desconectarse de la base de datos una vez finalizado el proceso
            //databaseconnector.disconnectDatabase();
        }catch(SQLException e){
            System.out.println("Error al obtener los automoviles " + e.getMessage());
            databaseconnector.disconnectDatabase();
        }

        return automovilList;
    }
    
    public void save(Automovil automovil){
        // guardar en la base de datos
    }
    
    public void deleteById(Long id){
        // eliminar un registro
    }
    
    public void update(Automovil automovil, Long id){
        // actualizar un registro
    }
}
