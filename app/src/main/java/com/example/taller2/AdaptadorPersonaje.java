package com.example.taller2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;

import java.util.List;

public class AdaptadorPersonaje extends RecyclerView.Adapter<AdaptadorPersonaje.VistaHolder> {

    private List<Personaje> listaPersonajes;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Personaje personaje);
    }

    public AdaptadorPersonaje(List<Personaje> listaPersonajes, OnItemClickListener listener) {
        this.listaPersonajes = listaPersonajes;
        this.listener = listener;
    }

    @NonNull
    @Override
    public VistaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new VistaHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull VistaHolder holder, int position) {
        Personaje personaje = listaPersonajes.get(position);
        holder.textoNombre.setText(personaje.getNombre());
        Glide.with(holder.itemView.getContext()).load(personaje.getUrlImagen()).into(holder.imagenPersonaje);

        holder.itemView.setOnClickListener(v -> listener.onItemClick(personaje));
    }

    @Override
    public int getItemCount() {
        return listaPersonajes.size();
    }

    public static class VistaHolder extends RecyclerView.ViewHolder {
        ImageView imagenPersonaje;
        TextView textoNombre;

        public VistaHolder(@NonNull View itemView) {
            super(itemView);
            imagenPersonaje = itemView.findViewById(R.id.imageView);
            textoNombre = itemView.findViewById(R.id.textView);
        }
    }
}