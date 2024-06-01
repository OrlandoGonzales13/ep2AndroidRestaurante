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

    private List<Plato> platos;

    public PlatoAdapter(List<Plato> platos) {
        this.platos = platos;
    }

    @NonNull
    @Override
    public PlatoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plato_item, parent, false);
        return new PlatoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlatoViewHolder holder, int position) {
        Plato plato = platos.get(position);
        holder.nombreTextView.setText(plato.getNombre());
        holder.descripcionTextView.setText(plato.getDescripcion());
        holder.imagenImageView.setImageResource(plato.getImagenResId());
        holder.precioTextView.setText(String.format("$%.2f", plato.getPrecio()));
    }

    @Override
    public int getItemCount() {
        return platos.size();
    }

    static class PlatoViewHolder extends RecyclerView.ViewHolder {
        TextView nombreTextView;
        TextView descripcionTextView;
        ImageView imagenImageView;
        TextView precioTextView;

        public PlatoViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreTextView = itemView.findViewById(R.id.nombreTextView);
            descripcionTextView = itemView.findViewById(R.id.descripcionTextView);
            imagenImageView = itemView.findViewById(R.id.imagenImageView);
            precioTextView = itemView.findViewById(R.id.precioTextView);
        }
    }
}
