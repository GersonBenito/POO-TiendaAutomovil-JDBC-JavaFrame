package com.tiendaAutomovil.utils;

import java.sql.*;

/**
 *
 * @author Gerson Benito
 */

/**
 * Reglas
 * 1) Debemos de tener un construtor vacio privado
 * 2) Debemos de tener un atributo estatico privado
 * 3) Debemos de tener un metodo estatico que devuelva la instancia
 */
public class DatabaseConnector {
    
    // implementar el patron de diseño Singleton
    
    private static DatabaseConnector databaseConnector;
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    private DatabaseConnector(){
    }
    
    
    // Manejar los hilos de JAVA con synchronized para que siempre se obtenga la misma instancia
    public static synchronized DatabaseConnector getInstance(){
        
        // verificar si ya existe una instancia
        if(databaseConnector == null){
            databaseConnector = new DatabaseConnector();
        }
        
        return databaseConnector;
    }
    
    public void connectDatabase(){
        String url = "jdbc:mysql://localhost:3306/tiendaautomovildb?serverTimezone=UTC";
        String username = "root";
        String password = ""; // agregar contraña en caso de ser necesario
        
        try{
            
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            

            System.out.println("Coneccion a la base de datos exitoso");
            
        }catch(SQLException e){
            System.out.println("Error al conectarse a la base de datos " + e.getMessage());
        }
    }
    
    /**
     * Funcion para ejecutar querys SQL
     * @param query
     * @return 
     */
    public ResultSet executeQuerySQL(String query){
        
        try{
            resultSet = statement.executeQuery(query);
            //resultSet.next();
        }catch(SQLException e){
            System.out.println("Error al ejecutar el script SQL " + e.getMessage());
        }
        
        return resultSet;
    }

    public PreparedStatement executeQuerySQL(String query, int type){
        try{
            preparedStatement = connection.prepareStatement(query);
            //resultSet.next();
        }catch(SQLException e){
            System.out.println("Error al ejecutar el script SQL " + e.getMessage());
        }

        return preparedStatement;
    }
    
    public void disconnectDatabase(int type){
        try{
            connection.close();
            statement.close();
            if(type == 1){
                resultSet.close();
            }else{
                preparedStatement.close();
            }
            System.out.println("Desconectandose de la base de datos ...");
        }catch(SQLException e){
            System.out.println("Error al desconectarse " + e.getMessage());
        }
    }
    
}
