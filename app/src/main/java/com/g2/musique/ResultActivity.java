package com.g2.musique;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    public static final String EXTRA_SCORE_QUESTION = "numberScore";
    private ArrayList<Question> questionsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent srcIntent = getIntent();
        questionsList = srcIntent.getParcelableArrayListExtra("questions");
        int score = srcIntent.getIntExtra(EXTRA_SCORE_QUESTION,0);

        float percentage = (score * 100) / questionsList.size();

        Log.i("test", "onCreate: "+ percentage);

        TextView textScore = findViewById(R.id.realizedTextView3);


        textScore.setText(percentage + "%");

        Button homeButton = findViewById(R.id.homeButton);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
