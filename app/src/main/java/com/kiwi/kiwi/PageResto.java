package com.kiwi.kiwi;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kiwi.kiwi.model.Ami;
import com.kiwi.kiwi.model.Avis;
import com.kiwi.kiwi.model.AvisAdapter;
import com.kiwi.kiwi.model.Resto;

import java.util.Locale;

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


            Button boutonAller = (Button) findViewById(R.id.aller);
            boutonAller.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // saddr : coordonees du departement IF
                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                            Uri.parse("http://maps.google.com/maps?saddr=45.781942, 4.872553&daddr="
                                    +resto.getPositionGPS().latitude+","+resto.getPositionGPS().longitude));
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Allons y !", Toast.LENGTH_LONG).show();
                }
            });

            Button boutonAllerPartager = (Button) findViewById(R.id.allerPartager);
            boutonAllerPartager.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // saddr : coordonees du departement IF
                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                            Uri.parse("http://maps.google.com/maps?saddr=45.781942, 4.872553&daddr="
                                    +resto.getPositionGPS().latitude+","+resto.getPositionGPS().longitude));
                    startActivity(intent);

                    Toast.makeText(getApplicationContext(), "Destination partagée !", Toast.LENGTH_LONG).show();
                }
            });


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
            switch (resto.getNiveauTarif()){
                case "€":
                    prix.setText("Prix : Moins de 5€");
                    break;

                case "€€":
                    prix.setText("Prix : De 5 à 10€");
                    break;

                case "€€€":
                    prix.setText("Prix : Plus de 10€");
                    break;
                default:
                    break;
            }
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
            RelativeLayout.LayoutParams paramsSeparateurDescription = (RelativeLayout.LayoutParams) separateur.getLayoutParams();

            if (resto.getMesAmisQuiSontDansCeResto().size() == 0){
                TextView pasDamis = new TextView(this);
                pasDamis.setText("Personne");
                pasDamis.setId(R.id.amis + 1);
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                params.addRule(RelativeLayout.BELOW, R.id.amis);
                pasDamis.setLayoutParams(params);
                restoLayout.addView(pasDamis);
            }
            else{
                HorizontalScrollView amisScrollView = new HorizontalScrollView(this);
                RelativeLayout.LayoutParams paramsAmisScrollView = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                paramsAmisScrollView.addRule(RelativeLayout.BELOW, R.id.amis);
                amisScrollView.setLayoutParams(paramsAmisScrollView);
                RelativeLayout amisLayout = new RelativeLayout(this);
                amisScrollView.setId(R.id.amis + 1);
                for (int i=1;i< resto.getMesAmisQuiSontDansCeResto().size()+1; i++) {
                    ImageView amisPhoto = new ImageView(this);
                    amisPhoto.setImageResource(this.getResources().getIdentifier("drawable/" + resto.getMesAmisQuiSontDansCeResto().get(i - 1).getPhoto(), null, this.getPackageName()));
                    amisPhoto.setId(i + R.id.amis + 1);

                    TextView amisNom = new TextView(this);
                    amisNom.setId(i + R.id.amis + 1001);
                    amisNom.setText(resto.getMesAmisQuiSontDansCeResto().get(i - 1).getPrenom() + " " + resto.getMesAmisQuiSontDansCeResto().get(i - 1).getNom());
                    RelativeLayout.LayoutParams paramsAmisNom = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                    paramsAmisNom.setMargins(0,220, 0, 0);
                    if (i>1) {
                        paramsAmisNom.addRule(RelativeLayout.RIGHT_OF, i + R.id.amis + 1000);
                        paramsAmisNom.setMargins(30,220,0,0);
                        RelativeLayout.LayoutParams paramsAmisPhoto = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                        paramsAmisPhoto.addRule(RelativeLayout.ALIGN_START, i + R.id.amis + 1001);
                        paramsAmisPhoto.addRule(RelativeLayout.ALIGN_TOP, i + R.id.amis);
                        amisPhoto.setLayoutParams(paramsAmisPhoto);
                    }
                    amisNom.setLayoutParams(paramsAmisNom);

                    amisLayout.addView(amisPhoto);
                    amisLayout.addView(amisNom);
                    amisPhoto.getLayoutParams().height = 200;
                    amisPhoto.getLayoutParams().width = 150;

                }
                amisScrollView.addView(amisLayout);
                restoLayout.addView(amisScrollView);
            }
            paramsSeparateurDescription.removeRule(RelativeLayout.BELOW);
            paramsSeparateurDescription.addRule(RelativeLayout.BELOW, R.id.amis + 1);
            separateur.setLayoutParams(paramsSeparateurDescription);



            //Partie de la description du restaurant

            ExpandableTextView description = (ExpandableTextView) findViewById(R.id.description);
            description.setText(resto.getDescription());


            //Partie des avis du restaurant
            RelativeLayout avisLayout = (RelativeLayout) findViewById(R.id.avisLayout);
            NonScrollListView listeAvis = (NonScrollListView) findViewById(R.id.listAvis);
            ListAdapter adapter = new AvisAdapter(this, resto.getAvis(), clickListenerSupprimer);
            listeAvis.setAdapter(adapter);

            RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

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

            View barre = new View(this);
            barre.setBackgroundColor(Color.GRAY);
            barreParams.setMargins(0, 15, 0, 0);
            barreParams.height = 5;
            barre.setId(R.id.listAvis+2);
            barre.setLayoutParams(barreParams);
            donnerAvisLayout.addView(barre);

            posNote.addRule(RelativeLayout.BELOW, R.id.listAvis + 2);
            note.setId(R.id.listAvis+3);
            note.setLayoutParams(posNote);


            avisUtilisateur.setHint("Donnez votre avis!");
            avisUtilisateur.setSingleLine(false);
            avisUtilisateur.setHorizontalScrollBarEnabled(false);
            avisUtilisateur.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
            avisUtilisateur.setLines(3);
            avisUtilisateur.setMaxLines(5);
            avisUtilisateur.setId(R.id.listAvis+4);
            posAvisUtilisateur.addRule(RelativeLayout.BELOW, R.id.listAvis+3);
            posAvisUtilisateur.setMargins(0, 50, 0, 0);
            avisUtilisateur.setLayoutParams(posAvisUtilisateur);

            Button valid = new Button(this);
            valid.setText("OK");
            valid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Avis nouvelAvis = new Avis((int) note.getRating(), avisUtilisateur.getText().toString(), new Ami("Dog", "Snoop", "photoutilisateur"));
                    resto.addAvis(nouvelAvis);
                    Intent intent = getIntent();
                    intent.putExtra(EXTRA_RESTO, resto.getNom());
                    finish();
                    startActivity(intent);
                }
            });
            posValid.addRule(RelativeLayout.BELOW, R.id.listAvis+4);
            valid.setLayoutParams(posValid);

            donnerAvisLayout.addView(note);
            donnerAvisLayout.addView(valid);
            donnerAvisLayout.addView(avisUtilisateur);

            RelativeLayout.LayoutParams posAvisText = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            posAvisText.removeRule(RelativeLayout.BELOW);
            posAvisText.addRule(RelativeLayout.BELOW, R.id.listAvis);
            TextView donnerAvis = new TextView(this);
            donnerAvis.setClickable(true);
            donnerAvis.setId(R.id.listAvis+1);
            donnerAvis.setText("Donnez le votre!");
            donnerAvis.setLayoutParams(posAvisText);
            donnerAvis.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    donnerAvisLayout.setVisibility(View.VISIBLE);
                    v.setVisibility(View.INVISIBLE);
                }
            });

            posDonnerAvisLayout.addRule(RelativeLayout.BELOW, R.id.listAvis+1);
            donnerAvisLayout.setLayoutParams(posDonnerAvisLayout);

            avisLayout.addView(donnerAvis);
            avisLayout.addView(donnerAvisLayout);
            params1.addRule(RelativeLayout.BELOW, R.id.textView5);
            avisLayout.setLayoutParams(params1);
        }
    }

    public View.OnClickListener clickListenerSupprimer = new View.OnClickListener() {

        @Override

        public void onClick(View v) {
            resto.getAvis().remove(position);
            Intent intent = getIntent();
            intent.putExtra(EXTRA_RESTO, resto.getNom());
            finish();
            startActivity(intent);
        }

    };
}

//TODO ajouter supprimer et signaler un avis
//TODO bouton favoris