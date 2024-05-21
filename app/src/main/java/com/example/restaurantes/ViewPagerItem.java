package com.example.restaurantes;

// Clase que representa un elemento en el ViewPager
public class ViewPagerItem {

    // Atributos de la clase
    int imageID; // ID de la imagen
    String heading; // Encabezado
    String description; // Descripción

    // Constructor para inicializar los atributos de la clase
    public ViewPagerItem(int imageID, String heading, String description) {
        this.imageID = imageID;
        this.heading = heading;
        this.description = description;
    }
}
