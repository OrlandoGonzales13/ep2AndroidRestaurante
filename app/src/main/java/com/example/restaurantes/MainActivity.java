package com.example.restaurantes;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    Button btnCarta;
    Button btnInfo;
    Button btnFundadores;
    Button btnGrupo;
    Button btnUbi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtener referencias a los botones del layout
        btnInfo = findViewById(R.id.btnInfo);
        btnCarta = findViewById(R.id.btnCarta);
        btnFundadores = findViewById(R.id.btnFundadores);
        btnGrupo = findViewById(R.id.btnGrupo);
        btnUbi = findViewById(R.id.btnUbi);

        // Configurar onClickListeners para cada botón
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarFragment(new InfoFragment());
            }
        });

        btnCarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarFragment(new CartaFragment());
            }
        });

        btnFundadores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarFragment(new FundadoresFragment());
            }
        });

        btnGrupo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)   {
                agregarFragment(new GrupoFragment());
            }
        });

        btnUbi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarFragment(new UbiFragment());
            }
        });
    }

    // Método para agregar un fragmento al contenedor
    void agregarFragment(Fragment fragment) {
        try {
            // Verificar que el fragmento no sea nulo antes de agregarlo
            if (fragment != null) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainerView, fragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .addToBackStack(null)
                        .commit();
            } else {
                throw new IllegalArgumentException("El fragmento es nulo");
            }
        } catch (Exception e) {
            // Capturar cualquier excepción que ocurra al reemplazar el fragmento
            e.printStackTrace();
            // Mostrar un mensaje de error al usuario usando Toast
            Toast.makeText(MainActivity.this, "Error al reemplazar el fragmento", Toast.LENGTH_SHORT).show();
        }
    }
}
