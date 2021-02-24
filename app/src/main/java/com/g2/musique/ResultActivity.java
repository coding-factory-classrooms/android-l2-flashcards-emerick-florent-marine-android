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
    public static final String LEVEL = "level";
    private ArrayList<Question> questionsList;
    private String level;

    /**
     *
     * Generate the result and statistics of the blind test
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent srcIntent = getIntent();
        questionsList = srcIntent.getParcelableArrayListExtra("questions");
        int score = srcIntent.getIntExtra(EXTRA_SCORE_QUESTION,0);
        level = srcIntent.getStringExtra(LEVEL);

        float percentage = (score * 100) / questionsList.size();

        TextView textScore = findViewById(R.id.realizedTextView3);
        TextView textLevel = findViewById(R.id.levelTextView);
        TextView textnbrAnswer = findViewById(R.id.nbrTextView);

        textScore.setText(percentage + "%");
        Log.i("test", "onResult: "+ level);
        textLevel.setText(level);
        textnbrAnswer.setText(score + "/" + questionsList.size());

        Button homeButton = findViewById(R.id.homeButton);

        homeButton.setOnClickListener(new View.OnClickListener() {
            /**
             *
             * Generate the return to home
             */
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
