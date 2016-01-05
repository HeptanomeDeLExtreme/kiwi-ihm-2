package com.kiwi.kiwi;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class PageConnexion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_connexion);
    }

    public void boutonRetourListener(View view) {
        Log.i("debug", "Appui sur le bouton Retour !");
    }

    public void boutonOkListener(View view) {
        Log.i("debug", "Appui sur le bouton OK !");
    }
}
