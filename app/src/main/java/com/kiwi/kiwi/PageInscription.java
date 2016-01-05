package com.kiwi.kiwi;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class PageInscription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_inscription);
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

    public void lienAccederSansCompteListener(View view) {
        Log.i("debug", "Appui sur le lien AccederSansCompte");
        Intent menuIntent = new Intent(this, ListFragment.class);
        startActivity(menuIntent);
    }
}
