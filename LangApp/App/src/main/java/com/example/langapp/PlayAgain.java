package com.example.langapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PlayAgain extends AppCompatActivity {

    Button playAgain,home;
    TextView wrongAnsText;
    Intent prev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_again);
        //Initialize
        playAgain = (Button) findViewById(R.id.playAgainButton);
        home = (Button) findViewById(R.id.home);
        wrongAnsText = (TextView)findViewById(R.id.wrongAns);
        prev = getIntent();
        //play again button onclick listener
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String activity = prev.getStringExtra("activity");

                Intent intent;
                switch (activity){
                    case "Family":
                        intent = new Intent(PlayAgain.this, FamilyActivity.class);
                        break;
                    case "Numbers":
                        intent = new Intent(PlayAgain.this, NumbersActivity.class);
                        break;
                    case "Colors":
                        intent = new Intent(PlayAgain.this, ColorsActivity.class);
                        break;
                    case "Phrases":
                        intent = new Intent(PlayAgain.this, PhrasesActivity.class);
                        break;
                    default:
                        intent = new Intent(PlayAgain.this, MainActivity.class);
                        break;
                }
                startActivity(intent);
                finish();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlayAgain.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}