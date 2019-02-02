package com.example.maciek.hangman_wordschallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class stats extends AppCompatActivity {
    Button reset,back;
    TextView wygrane,przegrane,procenty;
    DBHelper db =new DBHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        reset = (Button) findViewById(R.id.reset);
        back = (Button) findViewById(R.id.back);
        wygrane = (TextView)findViewById(R.id.wygrane);
        przegrane = (TextView)findViewById(R.id.przegrane);
        procenty = (TextView)findViewById(R.id.procent);

        int[] tab = db.wyswietldane();
        wygrane.setText("Wygrane: "+tab[0]);
        przegrane.setText("Przegrane: "+tab[1]);

            if (tab[0] >= 1) {
                Log.i("jestem w","ifie");
                int procent = ((tab[0]*100) / (tab[0] + tab[1]));
                procenty.setText("Procent wygranych: " + procent+"%");
            } else {
                Log.i("jestem w","elsie");
                procenty.setText("Procent wygranych: 0%");

            }

//Przycisk resetowania statystyk
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.resetujdane();
                int[] tab = db.wyswietldane();
                wygrane.setText("Wygrane: "+tab[0]);
                przegrane.setText("Przegrane: "+tab[1]);

                if (tab[0] >= 1) {
                    int procent = ((tab[0]*100) / (tab[0] + tab[1]));
                    procenty.setText("Procent wygranych: " + procent+"%");
                } else {

                    procenty.setText("Procent wygranych: 0%");

                }
            }

        });
        //Przycisk powrotu do menu głownego
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }

        });


    }
}
