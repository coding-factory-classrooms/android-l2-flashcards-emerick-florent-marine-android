package com.g2.musique;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class QuestionActivity extends AppCompatActivity {

    public static final String EXTRA_NUMBER_QUESTION = "numberQuestion";
    public static final String EXTRA_SCORE_QUESTION = "numberScore";
    public static final String TAG = "Question Activity";
    private MediaPlayer mediaPlayer;

    private ArrayList<Question> questionsList;
    private int numberQuestion;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Intent srcIntent = getIntent();

        questionsList = srcIntent.getParcelableArrayListExtra("questions");
        numberQuestion = srcIntent.getIntExtra(EXTRA_NUMBER_QUESTION,0);
        score = srcIntent.getIntExtra(EXTRA_SCORE_QUESTION,0);

        final Question currentQuestion = questionsList.get(numberQuestion);
        ArrayList<String> allAnswer = currentQuestion.getAllAnswer();

        RadioGroup radioGroup = findViewById(R.id.radioGroup1);
        for (int i = 0; i < allAnswer.size(); ++i){
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(allAnswer.get(i));
            radioGroup.addView(radioButton);
        }

        setTitle("Spotify Blind Test  Question "+String.valueOf(numberQuestion+1)+"/"+questionsList.size());
        this.mediaPlayer = MediaPlayer.create(getApplicationContext(),currentQuestion.getMusiqueId());

        Button validateButton = findViewById(R.id.validatebutton);
        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup radioGroup;
                RadioButton radioButtonSelected;

                Button validateButton = findViewById(R.id.validatebutton);
                radioGroup = findViewById(R.id.radioGroup1);
                radioButtonSelected = findViewById(radioGroup.getCheckedRadioButtonId());
                TextView responseTextView = findViewById(R.id.responseTextView);

                if (radioButtonSelected == null) {
                    Toast.makeText(QuestionActivity.this,
                            "Choisir une réponse !",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if (radioButtonSelected.getText().toString().equals(currentQuestion.getRightAnswer())) {
                    responseTextView.setText("Vrai");
                    responseTextView.setTextColor(Color.GREEN);
                    validateButton.setText("Question suivante");
                    score++;

                } else {
                    responseTextView.setText("Faux la bonne réponse était "+ currentQuestion.getRightAnswer());
                    responseTextView.setTextColor(Color.RED);
                    validateButton.setText("Question suivante");
                }
                logicEndQuizz();
            }
        });

    }

    public void playSound(View view) {

        final Button button = (Button) view;

        if (mediaPlayer.isPlaying())
        {
            mediaPlayer.pause();
            button.setText(getString(R.string.play_music_btn));
        }
        else
        {
            mediaPlayer.start();
            button.setText(getString(R.string.pause_music_btn));
        }

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                button.setText(getString(R.string.play_music_btn));
            }
        });
    }

    public void logicEndQuizz(){
        Log.i("test Array", "entrée :" + numberQuestion);
        numberQuestion++;
        if (numberQuestion >= questionsList.size()){
            Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);
            intent.putExtra("questions", questionsList);
            intent.putExtra(EXTRA_SCORE_QUESTION, score);
            intent.putExtra(EXTRA_NUMBER_QUESTION, numberQuestion);
            startActivity(intent);
        }
        else{
            //
            Intent intent = new Intent(QuestionActivity.this, QuestionActivity.class);
            intent.putExtra("questions", questionsList);
            intent.putExtra(EXTRA_SCORE_QUESTION, score);
            intent.putExtra(EXTRA_NUMBER_QUESTION, numberQuestion);
            startActivity(intent);
        }
        mediaPlayer.stop();
        finish();
    }
}