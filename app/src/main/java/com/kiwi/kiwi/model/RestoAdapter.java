package com.kiwi.kiwi.model;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kiwi.kiwi.MainActivity;
import com.kiwi.kiwi.R;

import java.util.List;

public class RestoAdapter extends ArrayAdapter<Resto> {

    public RestoAdapter(Context context, List<Resto> restoList) {
        super(context, 0, restoList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.resto_item, parent, false);
        }

        RestoViewHolder viewHolder = (RestoViewHolder) convertView.getTag();
        if (viewHolder == null) {
            viewHolder = new RestoViewHolder();
            viewHolder.nom = (TextView) convertView.findViewById(R.id.nom);
            viewHolder.photo = (ImageView) convertView.findViewById(R.id.photo);
            viewHolder.prixResto = (TextView) convertView.findViewById(R.id.prixResto);
            viewHolder.tempsChemin = (TextView) convertView.findViewById(R.id.textTempsChemin);
            viewHolder.tempsRepas = (TextView) convertView.findViewById(R.id.textTempsRepas);
            convertView.setTag(viewHolder);
        }


        //getItem(position) va récupérer l'item [position] de la List
        Resto resto = getItem(position);
        System.out.println(resto.getNom());
        Filtre filtre = MainActivity.filtre;

        //il ne reste plus qu'à remplir notre vue
        viewHolder.nom.setText(resto.getNom());

        viewHolder.photo.setImageResource(getContext().getResources().getIdentifier("drawable/" + resto.getCategorie().getIcone(), null, getContext().getPackageName()));


        viewHolder.prixResto.setText(resto.getNiveauTarif());

        viewHolder.tempsChemin.setText(resto.getTempsUtilisateurRestaurant() + " min");
        viewHolder.tempsRepas.setText(resto.getTempsAttente() + " min");

        if (!resto.getOuvert()) {
            convertView.setBackgroundColor(Color.rgb(0xFF, 0xCC, 0xCC));
        } else {
            convertView.setBackgroundColor(Color.TRANSPARENT);
        }


        return convertView;
    }

    private class RestoViewHolder {
        public TextView nom;
        public TextView prixResto;
        public ImageView photo;
        public TextView tempsChemin;
        public TextView tempsRepas;
    }
}