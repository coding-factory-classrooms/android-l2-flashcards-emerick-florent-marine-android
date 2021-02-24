package com.g2.musique;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

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
                startActivity( intent);
            }
        });
    }

    public ArrayList<Question> setQuestion(){
        ArrayList<Question> questionsList = new ArrayList<Question>();
        questionsList.add(new Question(R.raw.the_week_end,"The Week end", new String[] {"Bad Boy","test2","test3"}));
        return questionsList;
    }
}
