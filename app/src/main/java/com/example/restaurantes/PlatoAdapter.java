package com.example.restaurantes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PlatoAdapter extends RecyclerView.Adapter<PlatoAdapter.PlatoViewHolder> {

    // Lista de platos a mostrar
    private List<Plato> platos;

    // Constructor del adaptador que recibe una lista de platos
    public PlatoAdapter(List<Plato> platos) {
        this.platos = platos;
    }

    @NonNull
    @Override
    public PlatoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        try {
            // Infla la vista del elemento de la lista desde el layout XML
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plato_item, parent, false);
        } catch (Exception e) {
            // Maneja cualquier excepción que ocurra durante el inflado de la vista
            System.err.println("Error inflando la vista del elemento: " + e.getMessage());
        }
        return new PlatoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlatoViewHolder holder, int position) {
        try {
            // Obtiene el plato en la posición actual de la lista
            Plato plato = platos.get(position);

            // Establece los valores de los elementos de la vista con los datos del plato
            holder.nombreTextView.setText(plato.getNombre());
            holder.descripcionTextView.setText(plato.getDescripcion());
            holder.imagenImageView.setImageResource(plato.getImagenResId());
            holder.precioTextView.setText(String.format("$%.2f", plato.getPrecio()));
        } catch (Exception e) {
            // Maneja cualquier excepción que ocurra durante el enlace de los datos a la vista
            System.err.println("Error enlazando los datos del plato en la vista: " + e.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        // Devuelve el número de elementos en la lista de platos
        return platos.size();
    }

    static class PlatoViewHolder extends RecyclerView.ViewHolder {
        TextView nombreTextView;
        TextView descripcionTextView;
        ImageView imagenImageView;
        TextView precioTextView;

        public PlatoViewHolder(@NonNull View itemView) {
            super(itemView);
            try {
                // Inicializa los elementos de la vista desde el layout XML
                nombreTextView = itemView.findViewById(R.id.nombreTextView);
                descripcionTextView = itemView.findViewById(R.id.descripcionTextView);
                imagenImageView = itemView.findViewById(R.id.imagenImageView);
                precioTextView = itemView.findViewById(R.id.precioTextView);
            } catch (Exception e) {
                // Maneja cualquier excepción que ocurra durante la inicialización de los componentes de la vista
                System.err.println("Error inicializando los componentes de la vista: " + e.getMessage());
            }
        }
    }
}
