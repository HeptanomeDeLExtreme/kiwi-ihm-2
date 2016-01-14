package com.kiwi.kiwi;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
        Intent menuIntent = new Intent(this, FormulaireInscription.class);
        startActivity(menuIntent);
    }

    public void boutonSeConnecterListener(View view) {
        Intent menuIntent = new Intent(this, PageConnexion.class);
        startActivity(menuIntent);
    }

    public void boutonAccederSansCompteListener(View view) {
        Intent menuIntent = new Intent(this, MainActivity.class);
        startActivity(menuIntent);
    }
}
