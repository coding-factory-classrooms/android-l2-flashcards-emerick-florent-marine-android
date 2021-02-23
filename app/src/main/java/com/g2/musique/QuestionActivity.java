package com.g2.musique;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuestionActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        this.mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.the_week_end);
    }

    public void playSound(View view) {

        Button button = (Button) view;

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
                Button button = findViewById(R.id.playButton);
                button.setText(getString(R.string.play_music_btn));
            }
        });
    }
}