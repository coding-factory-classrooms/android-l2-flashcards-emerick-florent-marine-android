package com.g2.musique;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ChoiceActivity extends AppCompatActivity {
    private FactoryQuestion factoryQuestion = new FactoryQuestion();
    private String level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        Intent srcIntent = getIntent();
        this.level = srcIntent.getStringExtra("level");
        View view = new View();

        Button classiqueButton = findViewById(R.id.classiqueButton);
        classiqueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChoiceActivity.this, QuestionActivity.class);
                intent.putExtra("questions",setQuestion("standard",15, this.level));
                startActivity(intent);
            }
        });

        Button mangaButton = findViewById(R.id.mangaButton);
        mangaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChoiceActivity.this, QuestionActivity.class);
                intent.putExtra("questions",setQuestion("manga",10, level));
                startActivity(intent);
            }
        });

        Button discoButton = findViewById(R.id.discoButton);
        discoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChoiceActivity.this, QuestionActivity.class);
                intent.putExtra("questions",setQuestion("disco",10, level));
                startActivity(intent);
            }
        });
        
    }

    public ArrayList<Question> setQuestion(String type, int number){
        return factoryQuestion.setQuestion(type,number);
    }
}