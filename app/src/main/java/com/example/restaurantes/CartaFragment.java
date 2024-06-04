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
        // Inflar el diseño para este fragmento
        View view = inflater.inflate(R.layout.fragment_carta, container, false);

        // Inicializar RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        try {
            // Inicializar datos
            List<Plato> platosList = new ArrayList<>();
            platosList.add(new Plato("Tiradito", "Un delicioso tiradito", R.drawable.plato1, 20.00));
            platosList.add(new Plato("Ceviche", "Ceviche fresco de pescado", R.drawable.plato2, 28.00));
            platosList.add(new Plato("Calamar Frito", "Calamar frito con ensalada y arroz", R.drawable.plato3, 30.00));
            platosList.add(new Plato("Chupe de Camarones", "Sopa cremosa de camarones con papas y choclo", R.drawable.plato4, 32.00));
            platosList.add(new Plato("Arroz con Mariscos", "Arroz sazonado con mariscos frescos", R.drawable.plato5, 25.00));
            platosList.add(new Plato("Parihuela", "Caldo de pescado y mariscos", R.drawable.plato6, 35.00));
            platosList.add(new Plato("Jalea Mixta", "Fritura de mariscos con yuca y salsa criolla", R.drawable.plato7, 33.00));
            platosList.add(new Plato("Conchas a la Parmesana", "Conchas gratinadas con queso parmesano", R.drawable.plato8, 26.00));
            platosList.add(new Plato("Tallarines Verdes", "Pasta con salsa de albahaca, espinaca y queso", R.drawable.plato9, 22.00));
            platosList.add(new Plato("Tallarines a la Huancaína", "Pasta con salsa huancaína y lomo saltado", R.drawable.plato10, 24.00));
            platosList.add(new Plato("Tallarines Rojos", "Pasta con salsa de tomate y carne de res", R.drawable.plato11, 21.00));
            platosList.add(new Plato("Lomo Saltado", "Tiras de carne salteadas con cebolla, tomate y papas fritas", R.drawable.plato12, 28.00));
            platosList.add(new Plato("Seco de Cabrito", "Carne de cabrito cocinada con chicha de jora y culantro", R.drawable.plato13, 30.00));
            platosList.add(new Plato("Ají de Gallina", "Pechuga de pollo desmenuzada en salsa de ají amarillo", R.drawable.plato14, 20.00));
            // Añadir más platos según sea necesario

            // Establecer adaptador
            platoAdapter = new PlatoAdapter(platosList);
            recyclerView.setAdapter(platoAdapter);
        } catch (Exception e) {
            // Manejar cualquier excepción que ocurra durante la inicialización de los datos
            e.printStackTrace();
            // Mostrar un mensaje de error al usuario
            System.out.println("Error al inicializar los datos");
        }

        return view;
    }
}
