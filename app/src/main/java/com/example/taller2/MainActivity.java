package com.example.taller2;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Personaje> listaPersonajes = new ArrayList<>();
        listaPersonajes.add(new Personaje("Rick", "https://rickandmortyapi.com/api/character/avatar/72.jpeg"));
        listaPersonajes.add(new Personaje("Summer", "https://rickandmortyapi.com/api/character/avatar/120.jpeg"));
        listaPersonajes.add(new Personaje("Kiara", "https://rickandmortyapi.com/api/character/avatar/190.jpeg"));
        listaPersonajes.add(new Personaje("Jerry", "https://rickandmortyapi.com/api/character/avatar/241.jpeg"));

        AdaptadorPersonaje adaptador = new AdaptadorPersonaje(listaPersonajes, personaje -> {
            Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
            intent.putExtra("nombre", personaje.getNombre());
            intent.putExtra("urlImagen", personaje.getUrlImagen());
            startActivity(intent);
        });

        recyclerView.setAdapter(adaptador);
    }
}


