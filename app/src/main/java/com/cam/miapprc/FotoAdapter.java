package com.cam.miapprc;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FotoAdapter extends RecyclerView.Adapter<FotoAdapter.FotoViewHolder> {
    private List<Foto> fotos;
    private Context context;
    public FotoAdapter(List<Foto> fotos) {
        this.fotos = fotos;
    }

    //Cuando se crea la interfaz para cada item de RecyclerView
    //Este metodo se ejecuta una vez.
    @Override
    public FotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        FotoViewHolder holder = new FotoViewHolder(v);
        context=parent.getContext();
        return holder;
    }

    //Cuando se enlazan los datos a un control de los Item del RecyclerView
    //Este metodo se repite cuantos valores se tengan para mostrar en el RecyclerView
    @Override
    public void onBindViewHolder(final FotoViewHolder holder, final int position) {
       holder.tvNombre.setText(fotos.get(position).getNombre());
       holder.tvFecha.setText(fotos.get(position).getFecha());
       holder.ivFoto.setImageResource(fotos.get(position).getImagen());

       //obtenemos las preferencias de esta app
        //lo abrimos en modo privado
        //el nombre de las preferencias va a ser pref
       final SharedPreferences pref=
                this.context.getSharedPreferences("pref",Context.MODE_PRIVATE);

       //obtenemos un valor booleando que tenga guardada la preferencia.
        //Buscamos en las preferencias un valor nombrado como el identificador de la foto
        //si no existe el valor en las preferencias, se pide que retorne false, esto es un valor por defecto por ser booleano
       final Boolean valor=
                pref.getBoolean(String.valueOf(fotos.get(position).getId()),false);

        if (valor)
            holder.ibFac.setImageResource(android.R.drawable.btn_star_big_on);
        else
            holder.ibFac.setImageResource(android.R.drawable.btn_star_big_off);

       holder.ibFac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //si se quiere guardar una preferencia, se utiliza un editor de preferencias.
                SharedPreferences.Editor editor = pref.edit();
                //vamos a guardar un Booleano y por eso se almacena con putBoolean
                //El valor a guardar se nombrara igual al id de la foto
                //se realiza un commit para actualizar las preferencias
                editor.putBoolean(String.valueOf(fotos.get(position).getId()),!valor);
                editor.commit();
                if (!valor)
                    holder.ibFac.setImageResource(android.R.drawable.btn_star_big_on);
                else
                    holder.ibFac.setImageResource(android.R.drawable.btn_star_big_off);
            }
        });
    }

    @Override
    public int getItemCount() {
        return fotos.size();
    }

    //Esta clase declarada dentro de la clase FotoAdapter sirve de contenedor de la interfaz grafica
    //Esto permite que no se necesite hacer varios findViewById, ya que esto se realizara una sola vez
    public class FotoViewHolder extends RecyclerView.ViewHolder{

        CardView cv;
        TextView tvNombre;
        TextView tvFecha;
        ImageView ivFoto;
        ImageButton ibFac;
        public FotoViewHolder(final View itemView) {
            super(itemView);
            cv= (CardView) itemView.findViewById(R.id.cvPersona);
            tvNombre= (TextView) itemView.findViewById(R.id.tvNombre);
            tvFecha= (TextView) itemView.findViewById(R.id.tvFecha);
            ivFoto= (ImageView) itemView.findViewById(R.id.ivFoto);
            ibFac= (ImageButton) itemView.findViewById(R.id.ibFav);
        }
    }
}