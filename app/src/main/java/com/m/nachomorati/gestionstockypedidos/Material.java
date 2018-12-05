package com.m.nachomorati.gestionstockypedidos;

public class Material {
    private String plant, material, description, batch, storage_location, status, pallets, value, ff;
    private int stock;

    public Material() {

    }

    public Material(String plant, String material, String description, String batch, String storage_location, String status, String pallets, String value, String ff, int stock) {
        this.plant = plant;
        this.material = material;
        this.description = description;
        this.batch = batch;
        this.storage_location = storage_location;
        this.status = status;
        this.pallets = pallets;
        this.value = value;
        this.ff = ff;
        this.stock = stock;
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getStorage_location() {
        return storage_location;
    }

    public void setStorage_location(String storage_location) {
        this.storage_location = storage_location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPallets() {
        return pallets;
    }

    public void setPallets(String pallets) {
        this.pallets = pallets;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getFf() {
        return ff;
    }

    public void setFf(String ff) {
        this.ff = ff;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
