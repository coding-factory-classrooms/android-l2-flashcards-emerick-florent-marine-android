package com.g2.musique;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ChoiceActivity extends AppCompatActivity {
    private FactoryQuestion factoryQuestion = new FactoryQuestion();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        Button classiqueButton = findViewById(R.id.classiqueButton);
        classiqueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChoiceActivity.this, QuestionActivity.class);
                intent.putExtra("questions",setQuestion("standard",15));
                startActivity(intent);
            }
        });

        Button mangaButton = findViewById(R.id.mangaButton);
        mangaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChoiceActivity.this, QuestionActivity.class);
                intent.putExtra("questions",setQuestion("manga",10));
                startActivity(intent);
            }
        });

        Button discoButton = findViewById(R.id.discoButton);
        discoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChoiceActivity.this, QuestionActivity.class);
                intent.putExtra("questions",setQuestion("disco",10));
                startActivity(intent);
            }
        });
        
    }

    public ArrayList<Question> setQuestion(String type, int number){
        return factoryQuestion.setQuestion(type,number);
    }
}