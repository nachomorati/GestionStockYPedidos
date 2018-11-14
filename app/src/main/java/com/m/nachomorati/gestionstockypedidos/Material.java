package com.m.nachomorati.gestionstockypedidos;

public class Material {
    private int id;
    private String ear;
    private String descripcion;
    private int stock;

    public Material() {
        this.id = -1;
    }

    public Material(String ear, String descripcion, int stock) {
        this.id = -1;
        this.ear = ear;
        this.descripcion = descripcion;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEar() {
        return ear;
    }

    public void setEar(String ear) {
        this.ear = ear;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
