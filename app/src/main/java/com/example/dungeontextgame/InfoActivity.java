package com.example.dungeontextgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.View;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }
    public void switchToIntroScreen(View view){
        Intent titleScreen = new Intent(this, TitleScreen.class);
        startActivity(titleScreen);
    }
}