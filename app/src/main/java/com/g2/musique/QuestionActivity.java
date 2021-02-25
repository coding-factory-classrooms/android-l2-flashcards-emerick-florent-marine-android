package com.g2.musique;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * the flashcard
 * @class QuestionActivity
 */
public class QuestionActivity extends AppCompatActivity {

    public static final String EXTRA_NUMBER_QUESTION = "numberQuestion";
    public static final String EXTRA_SCORE_QUESTION = "numberScore";
    public static final String TAG = "Question Activity";
    public static final String TIME_MEDIA_PLAYER = "timeMediaPlayer";
    public static final String LEVEL = "level";
    private MediaPlayer mediaPlayer;

    private ArrayList<Question> questionsList;
    private int numberQuestion;
    private int score;
    private int timeMediaPlayer;
    private String level;
    private int choice = 0;

    /**
     *
     * Generate activity_question
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Intent srcIntent = getIntent();
        questionsList = srcIntent.getParcelableArrayListExtra("questions");
        numberQuestion = srcIntent.getIntExtra(EXTRA_NUMBER_QUESTION, 0);
        score = srcIntent.getIntExtra(EXTRA_SCORE_QUESTION, 0);
        timeMediaPlayer = srcIntent.getIntExtra(TIME_MEDIA_PLAYER, 10000);
        level = srcIntent.getStringExtra(LEVEL);

        final Question currentQuestion = questionsList.get(numberQuestion);
        ArrayList<String> allAnswer = currentQuestion.getAllAnswer();

        RadioGroup radioGroup = findViewById(R.id.radioGroup1);
        for (int i = 0; i < allAnswer.size(); ++i) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(allAnswer.get(i));
            radioGroup.addView(radioButton);
        }

        setTitle("Spotify Blind Test  Question " + String.valueOf(numberQuestion + 1) + "/" + questionsList.size());

        int drawableResourceId = QuestionActivity.this.getResources().getIdentifier(currentQuestion.getMusiqueId(), "raw", QuestionActivity.this.getPackageName());
        this.mediaPlayer = MediaPlayer.create(getApplicationContext(), drawableResourceId);

        Log.i(TAG, "playSound: duration " + mediaPlayer.getDuration());

        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setText("Valider réponse");
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("testonclick", String.valueOf(choice));
                RadioGroup radioGroup;
                RadioButton radioButtonSelected;

                Button nextButton = findViewById(R.id.nextButton);
                radioGroup = findViewById(R.id.radioGroup1);
                radioButtonSelected = findViewById(radioGroup.getCheckedRadioButtonId());
                TextView responseTextView = findViewById(R.id.responseTextView);

                if (0 == choice)
                {
                    if (radioButtonSelected == null) {
                        Toast.makeText(QuestionActivity.this,
                                "Choisir une réponse !",
                                Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        choice++;
                        if (radioButtonSelected.getText().toString().equals(currentQuestion.getRightAnswer())) {
                            responseTextView.setText("Vrai " + currentQuestion.getRightAnswer());
                            responseTextView.setTextColor(Color.GREEN);
                            score++;
                          //  view.setEnabled(false);
                           // choice = true;
                        } else {
                            responseTextView.setText("Faux la bonne réponse était " + currentQuestion.getRightAnswer());
                            responseTextView.setTextColor(Color.RED);
                           // view.setEnabled(false);
                            //choice = true;

                        }
                        Log.i("testonclick", String.valueOf(choice));
                        nextButton.setText("passer à la question suivante");
                        if (numberQuestion == questionsList.size() - 1) {
                            nextButton.setText("Afficher le score");
                        }
                    }
                }
                else
                    logicEndQuizz();

            }
        });
    }

    /**
     *
     * Play the sound of BlindTest
     */
    public void playSound(View view) {

        final Button button = (Button) view;

        Intent srcIntent = getIntent();
        timeMediaPlayer = srcIntent.getIntExtra(TIME_MEDIA_PLAYER, 10000);

        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            button.setText(getString(R.string.play_music_btn));
        } else {
            mediaPlayer.start();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                /**
                 * captured position on music time
                 */
                @Override
                public void run() {
                    mediaPlayer.seekTo(mediaPlayer.getDuration());
                }
            }, timeMediaPlayer);
            button.setText(getString(R.string.pause_music_btn));
        }
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            /**
             * Restart the music from the start
             * @param mp new MediaPlayer
             */
            @Override
            public void onCompletion(MediaPlayer mp) {
                button.setText(getString(R.string.play_music_btn));
            }
        });
    }

    /**
     * Is use for decide of the next page after click on "Next Page"
     */
    public void logicEndQuizz() {
        numberQuestion++;

        if (numberQuestion >= questionsList.size()) {
            Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);
            intent.putExtra("questions", questionsList);
            intent.putExtra(EXTRA_SCORE_QUESTION, score);
            intent.putExtra(EXTRA_NUMBER_QUESTION, numberQuestion);
            intent.putExtra(TIME_MEDIA_PLAYER, timeMediaPlayer);
            intent.putExtra(TIME_MEDIA_PLAYER, timeMediaPlayer);
            intent.putExtra(LEVEL, level);
            startActivity(intent);
            startActivity(intent);
        }
        else
        {
            Intent intent = new Intent(QuestionActivity.this, QuestionActivity.class);
            intent.putExtra("questions", questionsList);
            intent.putExtra(EXTRA_SCORE_QUESTION, score);
            intent.putExtra(EXTRA_NUMBER_QUESTION, numberQuestion);
            intent.putExtra(TIME_MEDIA_PLAYER, timeMediaPlayer);
            intent.putExtra(LEVEL, level);
            startActivity(intent);
        }
        mediaPlayer.stop();
        finish();
    }
}