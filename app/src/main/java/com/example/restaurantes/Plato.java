package com.example.restaurantes;

public class Plato {
    private String nombre;
    private String descripcion;
    private int imagenResId;
    private double precio;

    public Plato(String nombre, String descripcion, int imagenResId, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagenResId = imagenResId;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getImagenResId() {
        return imagenResId;
    }

    public double getPrecio() {
        return precio;
    }
}
