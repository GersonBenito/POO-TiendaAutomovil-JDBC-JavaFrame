package com.tiendaAutomovil.entities;

/**
 *
 * @author Gerson Benito
 */
public class Automovil {
    private Long id;
    private String modelo;
    private String marca;
    private String fabricante;
    private String motor;
    private String color;
    private String placa;
    private int numero_puerta;
    private double precio;

    public Automovil() {
    }

    public Automovil(Long id, String modelo, String fabricante, String motor, String marca, String color, String placa, int numero_puerta, double precio) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.fabricante = fabricante;
        this.motor = motor;
        this.color = color;
        this.placa = placa;
        this.numero_puerta = numero_puerta;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
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
