package com.example.restaurantes;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
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
        // EdgeToEdge.enable(this); // Asegúrate de tener esta clase definida o importada
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnInfo = findViewById(R.id.btnInfo);
        btnCarta = findViewById(R.id.btnCarta);
        btnFundadores = findViewById(R.id.btnFundadores);
        btnGrupo = findViewById(R.id.btnGrupo);
        btnUbi = findViewById(R.id.btnUbi);

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
            public void onClick(View view) {
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

    void agregarFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainerView, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .addToBackStack(null)
                .commit();
    }
}