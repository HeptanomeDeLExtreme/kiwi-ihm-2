package com.kiwi.kiwi.model;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kiwi.kiwi.R;

import java.util.List;

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
            viewHolder.photoAmi = (ImageView) convertView.findViewById(R.id.photoAmi);
            viewHolder.couverts = (ImageView) convertView.findViewById(R.id.couverts);
            viewHolder.hommeMarchant = (ImageView) convertView.findViewById(R.id.hommeMarchant);
            viewHolder.labelMangeA = (TextView) convertView.findViewById(R.id.labelMangeA);
            viewHolder.labelMin = (TextView) convertView.findViewById(R.id.labelMin);
            viewHolder.editNbMarche = (TextView) convertView.findViewById(R.id.editNbMarche);
            viewHolder.editNbAttenteManger = (TextView) convertView.findViewById(R.id.editNbAttenteManger);
            viewHolder.labelPseudo = (TextView) convertView.findViewById(R.id.labelPseudo);
            viewHolder.editNomResto = (TextView) convertView.findViewById(R.id.editNomResto);
            viewHolder.labelMin2 = (TextView) convertView.findViewById(R.id.labelMin2);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List
        Ami ami = getItem(position);

        // Remplir la vue
        //viewHolder.photoAmi.setImageDrawable(new ColorDrawable(ami.getPhotoProfil())); // Ne fonctionne pas
        viewHolder.editNbMarche.setText(ami.getRestaurant().getTempsMarcheVersResto());
        viewHolder.editNbAttenteManger.setText(ami.getRestaurant().getTempsAttenteAvantManger());
        viewHolder.labelPseudo.setText(ami.getPseudo());
        viewHolder.editNomResto.setText(ami.getRestaurant().getNom());

        //viewHolder.photo.setImageDrawable(new ColorDrawable(resto.getPhoto()));

        return convertView;
    }

    private class AmiViewHolder {
        public ImageView photoAmi;
        public ImageView couverts; // Utile ?
        public ImageView hommeMarchant; // Utile ?
        public TextView labelMangeA; // Utile ?
        public TextView labelMin; // Utile ?
        public TextView editNbMarche;
        public TextView editNbAttenteManger;
        public TextView labelPseudo;
        public TextView editNomResto;
        public TextView labelMin2; // Utile ?
    }
}