package com.Veterinaria.Veterinaria.model;

public class ProductoVeterinario {
    private String nombre;
    private String categoria;
    private String presentacion;
    private String especie;

    public ProductoVeterinario() {}

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getPresentacion() { return presentacion; }
    public void setPresentacion(String presentacion) { this.presentacion = presentacion; }

    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }
}