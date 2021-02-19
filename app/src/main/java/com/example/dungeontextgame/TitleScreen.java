package com.example.dungeontextgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TitleScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_screen);
    }
    public void switchToGameScreen(View view)
    {
        Intent gameScreen = new Intent(this,GameScreen.class);
        startActivity(gameScreen);
    }
    public void switchToInfoScreen(View view){
        Intent infoActivity = new Intent(this,InfoActivity.class);
        startActivity(infoActivity);
    }
}