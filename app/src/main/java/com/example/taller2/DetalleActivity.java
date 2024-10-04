package com.example.taller2;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class DetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        ImageView imagenDetalle = findViewById(R.id.imageViewDetail);
        TextView textoDetalle = findViewById(R.id.textViewDetail);

        String nombre = getIntent().getStringExtra("nombre");
        String urlImagen = getIntent().getStringExtra("urlImagen");

        textoDetalle.setText(nombre);
        Glide.with(this).load(urlImagen).into(imagenDetalle);
    }
}



