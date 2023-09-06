package com.tiendaAutomovil.entities;

/**
 *
 * @author Gerson Benito
 */
public class Automovil {
    private int id;
    private String modelo;
    private String marca;
    private String motor;
    private String color;
    private String placa;
    private int numero_puerta;
    private double precio;

    public Automovil() {
    }

    public Automovil(int id, String modelo, String marca, String motor, String color, String placa, int numero_puerta, double precio) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.motor = motor;
        this.color = color;
        this.placa = placa;
        this.numero_puerta = numero_puerta;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getNumero_puerta() {
        return numero_puerta;
    }

    public void setNumero_puerta(int numero_puerta) {
        this.numero_puerta = numero_puerta;
    }
    
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
