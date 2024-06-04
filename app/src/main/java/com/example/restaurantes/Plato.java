package com.example.restaurantes;

public class Plato {
    // Declaración de variables privadas para los atributos del plato
    private String nombre;
    private String descripcion;
    private int imagenResId;
    private double precio;

    // Constructor de la clase Plato
    public Plato(String nombre, String descripcion, int imagenResId, double precio) {
        try {
            // Verifica que el nombre no sea nulo o vacío
            if (nombre == null || nombre.isEmpty()) {
                throw new IllegalArgumentException("El nombre del plato no puede estar vacío.");
            }
            // Verifica que la descripción no sea nula o vacía
            if (descripcion == null || descripcion.isEmpty()) {
                throw new IllegalArgumentException("La descripción del plato no puede estar vacía.");
            }
            // Verifica que el ID de la imagen sea mayor que cero
            if (imagenResId <= 0) {
                throw new IllegalArgumentException("El ID de la imagen debe ser mayor que cero.");
            }
            // Verifica que el precio sea mayor que cero
            if (precio <= 0) {
                throw new IllegalArgumentException("El precio del plato debe ser mayor que cero.");
            }

            // Si todas las validaciones son correctas, asigna los valores a las variables de instancia
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.imagenResId = imagenResId;
            this.precio = precio;
        } catch (IllegalArgumentException e) {
            // Captura y muestra el mensaje de la excepción en caso de que alguna validación falle
            System.err.println("Error al crear el plato: " + e.getMessage());
        }
    }

    // Métodos getter para acceder a los atributos del plato
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
