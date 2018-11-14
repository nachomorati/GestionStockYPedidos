package com.m.nachomorati.gestionstockypedidos;

public class Inventario {
    private int id;
    private Material material;
    private int cantidad;

    public Inventario() {
        this.id = -1;
    }

    public Inventario(Material material, int cantidad) {
        this.material = material;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
