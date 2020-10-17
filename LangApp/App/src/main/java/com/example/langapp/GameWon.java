package com.example.langapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GameWon extends AppCompatActivity {

    Intent prev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_won);
        prev = getIntent();
    }

    //This is onclick listener for button
    //it will navigate from this activity to MainGameActivity
    public void PlayAgain(View view) {
        Intent intent = new Intent(GameWon.this, MainActivity.class);
        String activity = prev.getStringExtra("activity");
        intent.putExtra("activity",activity);
        intent.putExtra("won","won");
        startActivity(intent);
        finish();
    }
}