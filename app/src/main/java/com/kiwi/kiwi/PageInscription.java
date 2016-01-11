package com.kiwi.kiwi;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class PageInscription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_inscription);

        // Underline "Accéder sans compte" button
        Button specialButton = (Button) findViewById(R.id.boutonAccederSansCompte);
        specialButton.setPaintFlags(specialButton.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
    }

    public void boutonCreerCompteListener(View view) {
        Log.i("debug", "Appui sur boutonCreerCompte");
        Intent menuIntent = new Intent(this, FormulaireInscription.class);
        startActivity(menuIntent);
    }

    public void boutonSeConnecterListener(View view) {
        Log.i("debug", "Appui sur boutonSeConnecter");
        Intent menuIntent = new Intent(this, PageConnexion.class);
        startActivity(menuIntent);
    }

    // TODO : Peut-être que ce n'est plus ListFragment qu'il faut appeler.
    public void boutonAccederSansCompteListener(View view) {
        Log.i("debug", "Appui sur le lien AccederSansCompte");
        Intent menuIntent = new Intent(this, MainActivity.class);
        startActivity(menuIntent);
    }
}
