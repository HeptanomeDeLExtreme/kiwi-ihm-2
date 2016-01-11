package com.kiwi.kiwi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class FormulaireInscription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulaire_inscription);
    }

    // Boutons
    public void boutonRetourListener(View view) {
        Log.i("debug", "Appui sur le bouton Retour !");
        Intent menuIntent = new Intent(this, PageInscription.class);
        startActivity(menuIntent);
    }

    public void boutonOkListener(View view) {
        Log.i("debug", "Appui sur le bouton OK !");
        MainActivity.isConnected = true;
        Intent menuIntent = new Intent(this, MainActivity.class);
        startActivity(menuIntent);
    }

}
