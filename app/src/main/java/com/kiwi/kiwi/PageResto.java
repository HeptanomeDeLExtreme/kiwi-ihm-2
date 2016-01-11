package com.kiwi.kiwi;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kiwi.kiwi.model.Ami;
import com.kiwi.kiwi.model.Avis;
import com.kiwi.kiwi.model.Resto;

public class PageResto extends AppCompatActivity {

    final String EXTRA_RESTO = "resto";
    Resto resto = null;
    int position =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_resto);
        String restoNom = "";
        Intent intent = getIntent();

        if (intent != null) {
            restoNom= intent.getStringExtra(EXTRA_RESTO);
        }

        for (Resto restaurant : MainActivity.listeRestos) {
            if (restaurant.getNom().equals(restoNom)){
                resto = restaurant;
            }
        }
        if (resto != null) {

            RelativeLayout restoLayout = (RelativeLayout) findViewById(R.id.restoLayout);

            //Partie des informations générales du restaurant
            ImageView photo = (ImageView) findViewById(R.id.photo);
            photo.setImageResource(this.getResources().getIdentifier("drawable/" + resto.getPhoto(), null, this.getPackageName()));
            TextView nom = (TextView) findViewById(R.id.nom);
            nom.setText(resto.getNom());

            //Partie des informations détaillées du restaurant
            TextView adresse = (TextView) findViewById(R.id.adresse);
            adresse.setText("Adresse : " + resto.getAdresse());
            TextView paiement = (TextView) findViewById(R.id.paiment);
            paiement.setText("Paiment : " + resto.getMoyenPaiement());
            TextView telephone = (TextView) findViewById(R.id.telephone);
            telephone.setText("Tel : " + resto.getTelephone());
            TextView horaires = (TextView) findViewById(R.id.horaires);
            horaires.setText("Horaires : " + resto.getHoraires());
            TextView prix = (TextView) findViewById(R.id.prix);
            prix.setText("Prix : " + resto.getMoyenPaiement());
            TextView tempsAttente = (TextView) findViewById(R.id.tempsAttente);
            tempsAttente.setText("Temps d'attente : " + resto.getTempsAttente() + "min");
            TextView tempsParcours = (TextView) findViewById(R.id.tempsParcours);
            tempsParcours.setText("Temps de parcours : " + resto.getTempsUtilisateurRestaurant() + "min");
            TextView type = (TextView) findViewById(R.id.type);
            type.setText(resto.getTypeRestaurant());
            if(resto.getNbRepasRestants() != null){
                TextView nbRepasRestants = new TextView(this, null, android.R.attr.textAppearanceMedium);
                nbRepasRestants.setText("Nombre de repas restants : " + resto.getNbRepasRestants());
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                params.addRule(RelativeLayout.BELOW, R.id.tempsAttente);
                nbRepasRestants.setId(R.id.tempsParcours+6000);
                nbRepasRestants.setLayoutParams(params);
                RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                params2.addRule(RelativeLayout.BELOW, nbRepasRestants.getId());
                restoLayout.addView(nbRepasRestants);
                type.setLayoutParams(params2);
            }
            TextView categorie = (TextView) findViewById(R.id.categorie);
            categorie.setText(Html.fromHtml("<u>" + resto.getCategorie().getNom() + "</u>"));
            TextView statut = (TextView) findViewById(R.id.statut);
            if(resto.getOuvert()) {
                statut.setText(Html.fromHtml("<u>Ouvert</u>"));
            }
            else{
                statut.setText(Html.fromHtml("<u>Fermé</u>"));
            }

            //Partie du menu de restaurant
            TextView menu = (TextView) findViewById(R.id.menu);
            menu.setText(resto.getMenuDuJour());

            //Partie des amis qui mangent dans ce restaurant
            View separateur = findViewById(R.id.separateurDescription);
            RelativeLayout.LayoutParams params5 = (RelativeLayout.LayoutParams) separateur.getLayoutParams();

            if (resto.getMesAmisQuiSontDansCeResto().size() == 0){
                TextView pasDamis = new TextView(this);
                pasDamis.setText("Personne");
                pasDamis.setId(R.id.amis+1);
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                params.addRule(RelativeLayout.BELOW, R.id.amis);
                pasDamis.setLayoutParams(params);
                params5.addRule(RelativeLayout.BELOW, pasDamis.getId());
                separateur.setLayoutParams(params5);
                restoLayout.addView(pasDamis);
            }
            else{
                RelativeLayout amisLayout = new RelativeLayout(this);
                for (int i=1;i< resto.getMesAmisQuiSontDansCeResto().size()+1; i++) {
                    ImageView amisPhoto = new ImageView(this);
                    amisPhoto.setImageResource(this.getResources().getIdentifier("drawable/" + resto.getMesAmisQuiSontDansCeResto().get(i-1).getPhoto(), null, this.getPackageName()));
                    amisPhoto.setId(i + R.id.amis);
                    TextView amisNom = new TextView(this);
                    amisNom.setId(2 * i + R.id.amis);
                    amisNom.setText(resto.getMesAmisQuiSontDansCeResto().get(i).getPrenom() + " " + resto.getMesAmisQuiSontDansCeResto().get(i-1).getNom());
                    if(i>1){
                        if(i%4 == 0){
                            RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                            params1.addRule(RelativeLayout.BELOW, (i-4)+R.id.amis);
                            amisNom.setLayoutParams(params1);
                        }
                        else{
                            RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                            params1.addRule(RelativeLayout.RIGHT_OF, (i-1)+R.id.amis);
                            amisNom.setLayoutParams(params1);
                        }
                    }
                    RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                    params2.addRule(RelativeLayout.BELOW, i - 1 + R.id.amis);
                    amisPhoto.setLayoutParams(params2);
                    amisLayout.addView(amisPhoto);
                    amisPhoto.getLayoutParams().height = 200;
                    amisPhoto.getLayoutParams().width = 150;
                    amisLayout.addView(amisNom);
                }
                params5.addRule(RelativeLayout.BELOW, resto.getMesAmisQuiSontDansCeResto().size() - 1 + R.id.amis);
                separateur.setLayoutParams(params5);
                restoLayout.addView(amisLayout);
            }



            //Partie de la description du restaurant

            ExpandableTextView description = (ExpandableTextView) findViewById(R.id.description);
            description.setText(resto.getDescription());


            //Partie des avis du restaurant
            RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            RelativeLayout avisLayout = new RelativeLayout(this);

            for (int i=1;i< resto.getAvis().size()+1; i++) {
                RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                RelativeLayout.LayoutParams params4 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                RelativeLayout.LayoutParams params6 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

                ImageView avisPhoto = new ImageView(this);
                avisPhoto.setImageResource(this.getResources().getIdentifier("drawable/" + resto.getAvis().get(i - 1).getAuteur().getPhoto(), null, this.getPackageName()));
                avisPhoto.setId(i + R.id.textView5);
                if(i>1){
                    params6.addRule(RelativeLayout.BELOW, i-1 + R.id.textView5);
                    avisPhoto.setLayoutParams(params6);
                }
                avisLayout.addView(avisPhoto);
                avisPhoto.getLayoutParams().height = 200;
                avisPhoto.getLayoutParams().width = 150;
                RatingBar rating = new RatingBar(this, null, android.R.attr.ratingBarStyleSmall);
                rating.setId(2 * i + R.id.textView5);
                rating.setNumStars(5);
                rating.setRating(resto.getAvis().get(i - 1).getNote());
                params4.addRule(RelativeLayout.RIGHT_OF, i + R.id.textView5);
                rating.setLayoutParams(params4);
                avisLayout.addView(rating);

                TextView auteur = new TextView(this);
                auteur.setId(3 * i + R.id.textView5);
                auteur.setText("de " + resto.getAvis().get(i - 1).getAuteur().getPrenom() + " " + resto.getAvis().get(i - 1).getAuteur().getNom());
                params3.addRule(RelativeLayout.BELOW, 2 * i + R.id.textView5);
                params3.addRule(RelativeLayout.RIGHT_OF, i + R.id.textView5);
                auteur.setLayoutParams(params3);
                avisLayout.addView(auteur);

                TextView avis = new TextView(this);
                avis.setId(4 * i + R.id.textView5);
                avis.setText(resto.getAvis().get(i - 1).getTexte());
                params2.addRule(RelativeLayout.BELOW, 3 * i + R.id.textView5);
                params2.addRule(RelativeLayout.RIGHT_OF, i + R.id.textView5);
                avis.setLayoutParams(params2);
                avisLayout.addView(avis);

                Button signaler = new Button(this);
                signaler.setId(5 * i + R.id.textView5);
                signaler.setText("!");
                //signaler.setTextSize(10);
                RelativeLayout.LayoutParams posSignaler = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                posSignaler.addRule(RelativeLayout.RIGHT_OF, 3 * i + R.id.textView5);
                signaler.setLayoutParams(posSignaler);
                signaler.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "L'avis a bien été signalé.", Toast.LENGTH_SHORT).show();
                    }
                });
                avisLayout.addView(signaler);
                signaler.getLayoutParams().height = 120;
                signaler.getLayoutParams().width = 120;

                if(resto.getAvis().get(i-1).getAuteur().getNom() == "Dupont" && resto.getAvis().get(i-1).getAuteur().getPrenom() == "Dupont"){
                    Button supp = new Button(this);
                    supp.setText("Supprimer");
                    RelativeLayout.LayoutParams posSupp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                    posSupp.addRule(RelativeLayout.RIGHT_OF, 5 * i + R.id.textView5);
                    supp.setLayoutParams(posSupp);
                    position = i;
                    supp.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            resto.getAvis().remove(position);
                            Intent intent = getIntent();
                            intent.putExtra(EXTRA_RESTO, resto.getNom());
                            finish();
                            startActivity(intent);
                        }
                    });
                    avisLayout.addView(supp);
                    supp.getLayoutParams().height = 120;
                }
            }


            RelativeLayout.LayoutParams posAvisUtilisateur = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
            RelativeLayout.LayoutParams posValid = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            RelativeLayout.LayoutParams posDonnerAvisLayout = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
            RelativeLayout.LayoutParams barreParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            RelativeLayout.LayoutParams posNote = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);


            final EditText avisUtilisateur = new EditText(this);
            final RelativeLayout donnerAvisLayout = new RelativeLayout(this);
            final RatingBar note = new RatingBar(this, null, android.R.attr.ratingBarStyleIndicator);
            donnerAvisLayout.setVisibility(View.INVISIBLE);
            note.setNumStars(5);
            note.setIsIndicator(false);
            note.setId(5 * resto.getAvis().size() + R.id.textView5 + 1111);
            posDonnerAvisLayout.addRule(RelativeLayout.BELOW, 4 * resto.getAvis().size() + R.id.textView5);
            donnerAvisLayout.setLayoutParams(posDonnerAvisLayout);

            View barre = new View(this);
            barre.setBackgroundColor(Color.GRAY);
            barreParams.setMargins(0, 15, 0, 0);
            barreParams.height = 5;
            barre.setId(4 * resto.getAvis().size() + R.id.textView5 + 1113);
            barre.setLayoutParams(barreParams);
            donnerAvisLayout.addView(barre);

            posNote.addRule(RelativeLayout.BELOW, 4 * resto.getAvis().size() + R.id.textView5 + 1113);
            note.setLayoutParams(posNote);

            avisUtilisateur.setHint("Donnez votre avis!");
            avisUtilisateur.setSingleLine(false);
            avisUtilisateur.setHorizontalScrollBarEnabled(false);
            avisUtilisateur.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
            avisUtilisateur.setLines(3);
            avisUtilisateur.setMaxLines(5);
            avisUtilisateur.setId(4 * resto.getAvis().size() + R.id.textView5 + 1112);
            posAvisUtilisateur.addRule(RelativeLayout.BELOW, 4 * resto.getAvis().size() + R.id.textView5 + 1111);
            posAvisUtilisateur.setMargins(0, 50, 0, 0);
            avisUtilisateur.setLayoutParams(posAvisUtilisateur);

            Button valid = new Button(this);
            valid.setText("OK");
            valid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Avis nouvelAvis = new Avis((int) note.getRating(), avisUtilisateur.getText().toString(), new Ami("Jean", "Dupont", "photoutilisateur"));
                    resto.addAvis(nouvelAvis);
                    Intent intent = getIntent();
                    intent.putExtra(EXTRA_RESTO, resto.getNom());
                    finish();
                    startActivity(intent);
                }
            });
            posValid.addRule(RelativeLayout.BELOW, 4 * resto.getAvis().size() + R.id.textView5 + 1112);
            valid.setLayoutParams(posValid);

            donnerAvisLayout.addView(note);
            donnerAvisLayout.addView(valid);
            donnerAvisLayout.addView(avisUtilisateur);

            RelativeLayout.LayoutParams posAvisText = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            posAvisText.removeRule(RelativeLayout.BELOW);
            posAvisText.addRule(RelativeLayout.BELOW, 4 * resto.getAvis().size() + R.id.textView5);
            TextView donnerAvis = new TextView(this);
            donnerAvis.setClickable(true);
            donnerAvis.setText("Donnez le votre!");
            donnerAvis.setLayoutParams(posAvisText);
            donnerAvis.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    donnerAvisLayout.setVisibility(View.VISIBLE);
                    v.setVisibility(View.INVISIBLE);
                }
            });

            avisLayout.addView(donnerAvis);
            avisLayout.addView(donnerAvisLayout);
            params1.addRule(RelativeLayout.BELOW, R.id.textView5);
            avisLayout.setLayoutParams(params1);
            restoLayout.addView(avisLayout);
        }
    }
}

//TODO ajouter supprimer et signaler un avis
//TODO bouton favoris