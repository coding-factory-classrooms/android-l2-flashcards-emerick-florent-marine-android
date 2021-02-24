package com.g2.musique;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private FactoryQuestion factoryQuestion = new FactoryQuestion();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  getActionBar().setTitle("Spotify blind test");

        Button startButton = findViewById(R.id.startMusicButton);
        startButton.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
                intent.putExtra("questions",setQuestion());
                startActivity(intent);
            }
        });

        Button aboutButton = findViewById(R.id.aboutButton);
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });
    }

    public ArrayList<Question> setQuestion(){
        Log.i("test", "setQuestion: " + factoryQuestion.setQuestion("manga",20));
        return factoryQuestion.setQuestion("manga",20);
    }
}
