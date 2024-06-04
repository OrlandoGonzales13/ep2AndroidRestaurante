package com.example.restaurantes;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuPrincipal extends AppCompatActivity {

    BottomNavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            // Configura el diseño de la actividad
            setContentView(R.layout.activity_menu_principal);

            // Configura el listener para ajustar los insets de la ventana
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });

            // Inicializar BottomNavigationView
            nav = findViewById(R.id.menuNavegation);

            // Cargar InfoFragment al inicio si savedInstanceState es nulo
            if (savedInstanceState == null) {
                agregarFragment(new InfoFragment());
            }

            // Configurar el listener para cambiar de fragmento cuando se selecciona un ítem en la navegación
            nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    try {
                        // Manejar la selección de ítems en la navegación
                        int itemId = menuItem.getItemId();
                        if (itemId == R.id.itemFragmentInfo) {
                            agregarFragment(new InfoFragment());
                        } else if (itemId == R.id.itemFragmentFundadores) {
                            agregarFragment(new FundadoresFragment());
                        } else if (itemId == R.id.itemFragmentCarta) {
                            agregarFragment(new CartaFragment());
                        } else if (itemId == R.id.itemFragmentUbi) {
                            agregarFragment(new UbiFragment());
                        } else if (itemId == R.id.itemFragmentGrupo) {
                            agregarFragment(new GrupoFragment());
                        }
                    } catch (Exception e) {
                        // Manejar cualquier excepción que ocurra durante la selección del ítem
                        System.err.println("Error al cambiar de fragmento: " + e.getMessage());
                    }
                    return true;
                }
            });
        } catch (Exception e) {
            // Manejar cualquier excepción que ocurra durante la creación de la actividad
            System.err.println("Error durante la creación de la actividad: " + e.getMessage());
        }
    }

    // Método para agregar y reemplazar fragmentos
    void agregarFragment(Fragment fragment) {
        try {
            // Realiza la transacción del fragmento
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fcv, fragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .addToBackStack(null)
                    .commit();
        } catch (Exception e) {
            // Manejar cualquier excepción que ocurra durante la transacción de fragmentos
            System.err.println("Error al agregar el fragmento: " + e.getMessage());
        }
    }
}
