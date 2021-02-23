package com.g2.musique;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        this.mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.the_week_end);

        Button validateButton = findViewById(R.id.validatebutton);
        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup radioGroup;
                RadioButton radioButtonSelected;

                radioGroup = findViewById(R.id.radioGroup1);
                radioButtonSelected = findViewById(radioGroup.getCheckedRadioButtonId());
                TextView responseTextView = findViewById(R.id.responseTextView);

                if (radioButtonSelected == null) {
                    Toast.makeText(QuestionActivity.this,
                            "Choisir une réponse !",
                            Toast.LENGTH_SHORT).show();
                    return ;
                }
                if (radioButtonSelected.getText().toString().equals("The Weeknd")) {
                    responseTextView.setText("Vrai");
                }
                else {
                        responseTextView.setText("Faux");
                }

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
}