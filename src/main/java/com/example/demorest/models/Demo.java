package com.example.demorest.models;

public class Demo {
    private String nombre;
    private Double valor;

    public Demo() {
    }

    public Demo(String nombre) {
        this.nombre = nombre;
    }

    public Demo(String nombre, Double valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getValor() {
        return valor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
