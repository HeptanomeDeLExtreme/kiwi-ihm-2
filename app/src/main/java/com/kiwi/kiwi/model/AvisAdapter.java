package com.kiwi.kiwi.model;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.kiwi.kiwi.PageResto;
import com.kiwi.kiwi.R;

import java.util.List;

public class AvisAdapter extends ArrayAdapter<Avis> {

    View.OnClickListener clickListenerSupprimer;

    public AvisAdapter(Context context, List<Avis> avisList, View.OnClickListener clickListenerSupprimer) {
        super(context, 0, avisList);
        this.clickListenerSupprimer = clickListenerSupprimer;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.avis_item, parent, false);
        }

        AmiViewHolder viewHolder = (AmiViewHolder) convertView.getTag();
        if (viewHolder == null) {
            viewHolder = new AmiViewHolder();
            viewHolder.note = (RatingBar) convertView.findViewById(R.id.note);
            viewHolder.photo = (ImageView) convertView.findViewById(R.id.photo);
            viewHolder.auteur = (TextView) convertView.findViewById(R.id.auteur);
            viewHolder.avis = (TextView) convertView.findViewById(R.id.avis);
            viewHolder.signaler = (Button) convertView.findViewById(R.id.signaler);
            viewHolder.supprimer = (Button) convertView.findViewById(R.id.supprimer);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List
        Avis avis = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.auteur.setText("de " + avis.getAuteur().getPrenom() + " " + avis.getAuteur().getNom());
        viewHolder.avis.setText(avis.getTexte());
        viewHolder.note.setRating(avis.getNote());
        viewHolder.photo.setImageResource(getContext().getResources().getIdentifier("drawable/" + avis.getAuteur().getPhoto(), null, getContext().getPackageName()));
        viewHolder.signaler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "L'avis a bien été signalé.", Toast.LENGTH_SHORT).show();
            }
        });

        if(avis.getAuteur().getPrenom() == "Bruce" && avis.getAuteur().getNom() == "Wayne"){
            viewHolder.supprimer.setVisibility(View.VISIBLE);
        }
        else{
            viewHolder.supprimer.setVisibility(View.INVISIBLE);
        }
        viewHolder.supprimer.setOnClickListener(clickListenerSupprimer);

        return convertView;
    }

    private class AmiViewHolder {
        public RatingBar note;
        public ImageView photo;
        public TextView auteur;
        public TextView avis;
        public Button signaler;
        public Button supprimer;
    }

}