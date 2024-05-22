package com.example.restaurantes;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class CartaFragment extends Fragment {

    private RecyclerView recyclerView;
    private PlatoAdapter platoAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_carta, container, false);

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize data
        List<Plato> platosList = new ArrayList<>();
        platosList.add(new Plato("Tiradito", "Un delicioso tiradito", R.drawable.plato1));
        platosList.add(new Plato("Ceviche", "Ceviche fresco de pescado", R.drawable.plato2));
        platosList.add(new Plato("Especialidad", "La especialidad", R.drawable.plato3));

        // Añadir más platos según sea necesario

        // Set adapter
        platoAdapter = new PlatoAdapter(platosList);
        recyclerView.setAdapter(platoAdapter);

        return view;
    }
}
