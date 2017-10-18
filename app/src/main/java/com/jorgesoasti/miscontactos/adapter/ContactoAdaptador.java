package com.jorgesoasti.miscontactos.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jorgesoasti.miscontactos.db.ConstructorContactos;
import com.jorgesoasti.miscontactos.poyo.Contacto;
import com.jorgesoasti.miscontactos.DetalleContacto;
import com.jorgesoasti.miscontactos.R;

import java.util.ArrayList;

/**
 * Created by jorge.soasti on 28/09/2017.
 */

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{

    ArrayList<Contacto> contactos;
    Activity activity;

    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity){
        this.contactos = contactos;
        this.activity = activity;
    }

    //Inflar el Layout y lo pasará al ViewHolder para que obtenga los views
    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto, parent, false); //Indica cual es el Layout que estará reciclando el RecyclerView
        return new ContactoViewHolder(v); //Pasar el View al constructor
    }

    //Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(final ContactoViewHolder holder, int position) {
        final Contacto contacto = contactos.get(position);
        holder.imgFotoCV.setImageResource(contacto.getFoto());
        holder.tvNombreCV.setText(contacto.getNombre());
        holder.tvTelefonoCV.setText(contacto.getTelefono());
        holder.tvLikes.setText(String.valueOf(contacto.getLikes()) + " Likes");

        holder.imgFotoCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleContacto.class);
                intent.putExtra(activity.getResources().getString(R.string.pNombre), contacto.getNombre());
                intent.putExtra(activity.getResources().getString(R.string.pTelefono), contacto.getTelefono());
                intent.putExtra(activity.getResources().getString(R.string.pEmail), contacto.getEmail());

                //Transisiones
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    //Si se encuentra en una actividad usar getWindow() directamente. En las partes
                    //que está colocado activity, si se encuentra en una actividad se puede colocar this.
                    Explode explode = new Explode();
                    explode.setDuration(1000);
                    activity.getWindow().setExitTransition(explode);
                    //El parametro "" (vacio) se usa para transiciones de imagenes como un efecto de zoom entre actividades
                    activity.startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(activity, view, "").toBundle());
                }else{
                    activity.startActivity(intent);
                }
            }
        });

        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Te gustó " + contacto.getNombre(), Toast.LENGTH_SHORT).show();

                ConstructorContactos constructorContactos = new ConstructorContactos(activity);
                constructorContactos.darLikeContacto(contacto);
                holder.tvLikes.setText(String.valueOf(constructorContactos.obtenerLikesContacto(contacto) + " Likes"));
            }
        });
    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene la lista
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFotoCV;
        private TextView tvNombreCV;
        private TextView tvTelefonoCV;
        private ImageButton btnLike;
        private TextView tvLikes;

        public ContactoViewHolder(View itemView) {
            super(itemView);
            imgFotoCV = itemView.findViewById(R.id.imgFotoContactoCV);
            tvNombreCV = itemView.findViewById(R.id.tvNombreCV);
            tvTelefonoCV = itemView.findViewById(R.id.tvTelefonoCV);
            btnLike = itemView.findViewById(R.id.btnLike);
            tvLikes = itemView.findViewById(R.id.tvLikes);
        }
    }
}
