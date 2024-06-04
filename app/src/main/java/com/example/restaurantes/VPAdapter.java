package com.example.restaurantes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VPAdapter extends RecyclerView.Adapter<VPAdapter.ViewHolder> {

    // ArrayList para almacenar los elementos del ViewPager
    ArrayList<ViewPagerItem> viewPagerItemArrayList;

    // Constructor que recibe la lista de elementos del ViewPager
    public VPAdapter(ArrayList<ViewPagerItem> viewPagerItemArrayList) {
        this.viewPagerItemArrayList = viewPagerItemArrayList;
    }

    // Método llamado cuando se crea una nueva instancia del ViewHolder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        try {
            // Inflar el diseño del elemento del ViewPager
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.viewpager_item, parent, false);
        } catch (Exception e) {
            // Manejar cualquier excepción durante la inflación del diseño
            System.err.println("Error al inflar el diseño del elemento: " + e.getMessage());
        }
        // Devuelve una instancia de ViewHolder
        return new ViewHolder(view);
    }

    // Método llamado para mostrar los datos en el ViewHolder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        try {
            // Obtener el elemento ViewPagerItem en la posición actual
            ViewPagerItem viewPagerItem = viewPagerItemArrayList.get(position);
            // Establecer la imagen, encabezado y descripción en los elementos de la vista
            holder.imageView.setImageResource(viewPagerItem.imageID);
            holder.tcHeading.setText(viewPagerItem.heading);
            holder.tvDesc.setText(viewPagerItem.description);
        } catch (Exception e) {
            // Manejar cualquier excepción durante el enlace de los datos
            System.err.println("Error al enlazar los datos en el ViewHolder: " + e.getMessage());
        }
    }

    // Método que devuelve el número total de elementos en el ViewPager
    @Override
    public int getItemCount() {
        return viewPagerItemArrayList.size();
    }

    // Clase ViewHolder que representa cada elemento en el ViewPager
    public class ViewHolder extends RecyclerView.ViewHolder {

        // Elementos de la vista
        ImageView imageView;
        TextView tcHeading, tvDesc;

        // Constructor que recibe la vista del elemento
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            try {
                // Inicializar los elementos de la vista
                imageView = itemView.findViewById(R.id.ivimage);
                tcHeading = itemView.findViewById(R.id.tvHeading);
                tvDesc = itemView.findViewById(R.id.tvDesc);
            } catch (Exception e) {
                // Manejar cualquier excepción durante la inicialización de los elementos de la vista
                System.err.println("Error al inicializar los elementos de la vista: " + e.getMessage());
            }
        }
    }
}
