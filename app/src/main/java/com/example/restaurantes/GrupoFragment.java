package com.example.restaurantes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GrupoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GrupoFragment extends Fragment {

    // Constantes para los argumentos del fragmento
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // Variables para almacenar los parámetros del fragmento
    private String mParam1;
    private String mParam2;

    public GrupoFragment() {
        // Constructor público requerido por Android
    }

    /**
     * Método de fábrica para crear una nueva instancia del fragmento
     * utilizando los parámetros proporcionados.
     *
     * @param param1 Parámetro 1.
     * @param param2 Parámetro 2.
     * @return Una nueva instancia del fragmento GrupoFragment.
     */
    public static GrupoFragment newInstance(String param1, String param2) {
        GrupoFragment fragment = new GrupoFragment();
        try {
            // Crear un Bundle y agregar los parámetros
            Bundle args = new Bundle();
            args.putString(ARG_PARAM1, param1);
            args.putString(ARG_PARAM2, param2);
            fragment.setArguments(args);
        } catch (Exception e) {
            // Manejar cualquier excepción que ocurra durante la creación de la instancia
            System.err.println("Error creando la instancia de GrupoFragment: " + e.getMessage());
        }
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            // Verificar si hay argumentos y asignar a las variables correspondientes
            if (getArguments() != null) {
                mParam1 = getArguments().getString(ARG_PARAM1);
                mParam2 = getArguments().getString(ARG_PARAM2);
            }
        } catch (Exception e) {
            // Manejar cualquier excepción que ocurra durante la obtención de argumentos
            System.err.println("Error obteniendo argumentos en onCreate: " + e.getMessage());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = null;
        try {
            // Inflar el diseño del fragmento
            view = inflater.inflate(R.layout.fragment_grupo, container, false);
        } catch (Exception e) {
            // Manejar cualquier excepción que ocurra durante el inflado de la vista
            System.err.println("Error inflando la vista en onCreateView: " + e.getMessage());
        }
        return view;
    }
}
