package com.g2.musique;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Adapter;

import java.util.ArrayList;

/**
 * use for the list Activity for the recycler
 * @class QuestionListActivity
 */
public class QuestionListActivity extends AppCompatActivity {
    private static final String TIME_MEDIA_PLAYER = "timeMediaPlayer";
    private QuestionAdapter adapter;
    private int timeMediaPlayer;

    /**
     * generate the list of the items in the recycler
     * @param savedInstanceState bundle instance
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_list);
        Intent srcIntent = getIntent();
        String level = srcIntent.getStringExtra("level");
        timeMediaPlayer = srcIntent.getIntExtra(TIME_MEDIA_PLAYER, 10000);
        ArrayList<Question> questions = srcIntent.getParcelableArrayListExtra("questions");
        adapter = new QuestionAdapter(questions, level, timeMediaPlayer);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}