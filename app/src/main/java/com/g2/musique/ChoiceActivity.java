package com.g2.musique;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ChoiceActivity extends AppCompatActivity {
    private FactoryQuestion factoryQuestion = new FactoryQuestion();
    public static final String LEVEL = "level";
    private String level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        Intent srcIntent = getIntent();
        this.level = srcIntent.getStringExtra("level");
        Log.i("test", "onCreate: " + level);
        View view = new View(ChoiceActivity.this);

        Button classiqueButton = findViewById(R.id.classiqueButton);
        classiqueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChoiceActivity.this, QuestionActivity.class);
                intent.putExtra("timeMediaPlayer",setLevelSec(level));
                intent.putExtra(LEVEL, level);
                intent.putExtra("questions",setQuestion("standard",15));
                startActivity(intent);
            }
        });

        Button mangaButton = findViewById(R.id.mangaButton);
        mangaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChoiceActivity.this, QuestionActivity.class);
                intent.putExtra("timeMediaPlayer",setLevelSec(level));
                intent.putExtra(LEVEL, level);
                intent.putExtra("questions",setQuestion("manga",10));
                startActivity(intent);
            }
        });

        Button discoButton = findViewById(R.id.discoButton);
        discoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChoiceActivity.this, QuestionActivity.class);
                intent.putExtra("timeMediaPlayer",setLevelSec(level));
                intent.putExtra(LEVEL, level);
                intent.putExtra("questions",setQuestion("disco",10));
                startActivity(intent);
            }
        });
    }

    public ArrayList<Question> setQuestion(String type, int number){
        return factoryQuestion.setQuestion(type,number);
    }

    public int setLevelSec(String level){
        switch(level) {
            case "facile":
                return 10000;
            case "moyen":
                return 5000;
            case "difficile":
                return 1000;
            default:
                return 10000;
        }
    }
}