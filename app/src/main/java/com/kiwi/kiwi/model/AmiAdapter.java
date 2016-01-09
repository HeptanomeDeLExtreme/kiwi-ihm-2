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

/**
 * Created by nico on 07/01/16.
 */
public class AmiAdapter extends ArrayAdapter<Ami> {

    public AmiAdapter(Context context, List<Ami> amiList) {
        super(context, 0, amiList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.ami_item, parent, false);
        }

        AmiViewHolder viewHolder = (AmiViewHolder) convertView.getTag();
        if (viewHolder == null) {
            viewHolder = new AmiViewHolder();
            viewHolder.nomPrenom = (TextView) convertView.findViewById(R.id.nomPrenom);
            viewHolder.mangeA = (TextView) convertView.findViewById(R.id.mangeA);
            viewHolder.tempsChemin = (TextView) convertView.findViewById(R.id.tempsChemiAmi);
            viewHolder.tempsAttente = (TextView) convertView.findViewById(R.id.tempsAttenteAmi);
            viewHolder.photo = (ImageView) convertView.findViewById(R.id.photoAmi);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List
        Ami ami = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.nomPrenom.setText(ami.getNom() + " " + ami.getPrenom());
        viewHolder.mangeA.setText("Mange à " + ami.getRestaurantActuel().getNom());
        viewHolder.tempsChemin.setText(ami.getTempsChemin() + " min");
        viewHolder.tempsAttente.setText(ami.getTempsAttente() + " min");

        return convertView;
    }

    private class AmiViewHolder {
        public TextView nomPrenom;
        public TextView mangeA;
        public TextView tempsChemin;
        public TextView tempsAttente;
        public ImageView photo;
    }

}
