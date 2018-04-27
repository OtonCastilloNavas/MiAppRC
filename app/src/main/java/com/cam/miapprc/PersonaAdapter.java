package com.cam.miapprc;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PersonaAdapter extends RecyclerView.Adapter<PersonaAdapter.PersonaViewHolder> {
    private List<Persona> personas;

    public PersonaAdapter(List<Persona> personas) {
        this.personas = personas;
    }

    @Override
    public PersonaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        PersonaViewHolder holder = new PersonaViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(PersonaViewHolder holder, int position) {
       holder.tvNombre.setText(personas.get(position).getNombre());
       holder.tvApellido.setText(personas.get(position).getApellido());
       holder.ivFoto.setImageResource(personas.get(position).getImagen());
    }

    @Override
    public int getItemCount() {
        return personas.size();
    }

    public static class PersonaViewHolder extends RecyclerView.ViewHolder{

        CardView cv;
        TextView tvNombre;
        TextView tvApellido;
        ImageView ivFoto;
        public PersonaViewHolder(View itemView) {
            super(itemView);
            cv= (CardView) itemView.findViewById(R.id.cvPersona);
            tvNombre= (TextView) itemView.findViewById(R.id.tvNombre);
            tvApellido= (TextView) itemView.findViewById(R.id.tvApellido);
            ivFoto= (ImageView) itemView.findViewById(R.id.ivFoto);
        }
    }
}