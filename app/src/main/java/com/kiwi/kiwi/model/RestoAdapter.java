package com.kiwi.kiwi.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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
            viewHolder.ouvert = (TextView) convertView.findViewById(R.id.ouvert);
            viewHolder.photo = (ImageView) convertView.findViewById(R.id.photo);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List
        Resto resto = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.nom.setText(resto.getNom());

        if (resto.getOuvert())
            viewHolder.ouvert.setText(R.string.resto_ouvert);
        else
            viewHolder.ouvert.setText(R.string.resto_ferme);

        //viewHolder.photo.setImageDrawable(new ColorDrawable(resto.getPhoto()));

        return convertView;
    }

    private class RestoViewHolder {
        public TextView nom;
        public TextView ouvert;
        public ImageView photo;
    }
}