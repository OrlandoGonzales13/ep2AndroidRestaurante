package com.example.restaurantes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class FundadoresFragment extends Fragment {

    private ViewPager2 viewPager2; // Declara un ViewPager2 para desplazar las imágenes y descripciones
    private ArrayList<ViewPagerItem> viewPagerItemArrayList; // Lista de elementos para el ViewPager2

    public FundadoresFragment() {
        // Constructor público requerido por Android
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el diseño del fragmento
        View view = inflater.inflate(R.layout.fragment_fundadores, container, false);

        // Inicializar ViewPager2
        viewPager2 = view.findViewById(R.id.viewpager);

        // Configurar ViewPager2
        viewPagerItemArrayList = new ArrayList<>(); // Inicializa la lista de elementos
        int[] images = {R.drawable.a, R.drawable.b, R.drawable.c}; // Array de recursos de imágenes
        String[] heading = {"Flavio Castrelo", "Fernanda Ariategui", "Fernando Quispe"}; // Nombres de los fundadores
        String[] desc = {getString(R.string.a_desc), // Descripciones de los fundadores desde los recursos de cadenas
                getString(R.string.b_desc),
                getString(R.string.c_desc),};

        // Itera sobre los datos de los fundadores para crear ViewPagerItem y añadirlos a la lista
        for (int i = 0; i < images.length; i++) {
            ViewPagerItem viewPagerItem = new ViewPagerItem(images[i], heading[i], desc[i]);
            viewPagerItemArrayList.add(viewPagerItem);
        }

        // Crea un adaptador personalizado para ViewPager2 y lo establece
        VPAdapter vpAdapter = new VPAdapter(viewPagerItemArrayList);
        viewPager2.setAdapter(vpAdapter);

        // Configura algunas propiedades adicionales de ViewPager2
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(2);
        viewPager2.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);

        // Devuelve la vista inflada
        return view;
    }
}
