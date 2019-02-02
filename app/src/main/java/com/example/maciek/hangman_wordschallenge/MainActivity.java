package com.example.maciek.hangman_wordschallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    DBHelper db;
    private Button start,stats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start =(Button) findViewById(R.id.start);
        stats = (Button)findViewById(R.id.stats);


        db = new DBHelper(this);
        try{
            db.createDataBase();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

Intent intent = new Intent(getApplicationContext(),kategorie.class);
startActivity(intent);

            }
        });


        stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),stats.class);
                startActivity(intent);

            }
        });



    }
}
