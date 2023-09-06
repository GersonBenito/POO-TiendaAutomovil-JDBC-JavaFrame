package com.tiendaAutomovil.repository;
import com.tiendaAutomovil.entities.Automovil;
import com.tiendaAutomovil.utils.DatabaseConnector;

import java.sql.PreparedStatement;
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
        Automovil automovil = new Automovil();
        databaseconnector.connectDatabase();
        try{
            String query = "SELECT * FROM automovil where id = " + id;
            ResultSet resultSet = databaseconnector.executeQuerySQL(query);
            resultSet.next();
            automovil.setId(resultSet.getInt("id"));
            automovil.setModelo(resultSet.getString("modelo"));
            automovil.setMarca(resultSet.getString("marca"));
            automovil.setMotor(resultSet.getString("motor"));
            automovil.setColor(resultSet.getString("color"));
            automovil.setPlaca(resultSet.getString("placa"));
            automovil.setNumero_puerta(resultSet.getInt("numero_puerta"));
            automovil.setPrecio(resultSet.getDouble("precio"));
            databaseconnector.disconnectDatabase(1);
        }catch (SQLException e){
            System.out.println("Error al obtener el registro " + e.getMessage());
            databaseconnector.disconnectDatabase(1);
        }
        return automovil;
    }
    
    public ArrayList<Automovil> findAll(){
        
        ArrayList<Automovil> automovilList = new ArrayList<>();

        databaseconnector.connectDatabase();
        
        try{
            String query = "SELECT * FROM automovil";
            ResultSet resultSet = databaseconnector.executeQuerySQL(query);

            while(resultSet.next()){
                // crear instacia de la entidad
                Automovil automovil = new Automovil();
                
                // asignar los datos
                automovil.setId(resultSet.getInt("id"));
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
            databaseconnector.disconnectDatabase(1);
        }catch(SQLException e){
            System.out.println("Error al obtener los automoviles " + e.getMessage());
            databaseconnector.disconnectDatabase(1);
        }

        return automovilList;
    }
    
    public void save(Automovil automovil){
        databaseconnector.connectDatabase();
        try{
            String query = "INSERT INTO automovil VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = databaseconnector.executeQuerySQL(query, 1);
            preparedStatement.setInt(1,automovil.getId());
            preparedStatement.setString(2,automovil.getModelo());
            preparedStatement.setString(3,automovil.getMarca());
            preparedStatement.setString(4,automovil.getMotor());
            preparedStatement.setString(5, automovil.getColor());
            preparedStatement.setString(6, automovil.getPlaca());
            preparedStatement.setInt(7, automovil.getNumero_puerta());
            preparedStatement.setDouble(8, automovil.getPrecio());
            preparedStatement.executeUpdate();

            databaseconnector.disconnectDatabase(2);
        }catch (SQLException e){
            System.out.println("Error al crear el registro " + e.getMessage());
            databaseconnector.disconnectDatabase(2);
        }
    }
    
    public void deleteById(Long id){
        // eliminar un registro
    }
    
    public void update(Automovil automovil, Long id){
        // actualizar un registro
    }
}
