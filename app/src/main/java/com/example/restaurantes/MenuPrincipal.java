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
        // EdgeToEdge.enable(this); // Asegúrate de tener esta clase definida o quítala si no es necesaria
        setContentView(R.layout.activity_menu_principal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nav = findViewById(R.id.menuNavegation);

        // Cargar InfoFragment al inicio
        if (savedInstanceState == null) {
            agregarFragment(new InfoFragment());
        }

        //cada que hay un item seleccionado cambniamops de fragment
        nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
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
                return true;
            }
        });
    }

    void agregarFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fcv, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .addToBackStack(null)
                .commit();
    }
}