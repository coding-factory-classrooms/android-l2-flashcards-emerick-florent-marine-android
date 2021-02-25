package com.g2.musique;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity
        implements SingleChoiceDialog.SingleChoiceListener {

    private FactoryQuestion factoryQuestion = new FactoryQuestion();
    private String level = "canceled";

    /**
     *
      * Start of the app
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startButton = findViewById(R.id.startMusicButton);
        startButton.setOnClickListener( new View.OnClickListener(){
            /**
             *
             * Generation of the game and go to choose the difficulty
             */
            @Override
            public void onClick(View v){
                DialogFragment singleChoiceDialog = new SingleChoiceDialog();
                singleChoiceDialog.setCancelable(false);
                singleChoiceDialog.show(getSupportFragmentManager(), "Single Choice Dialog");
            }
        });

        Button listOfQuestionsButton = findViewById(R.id.ListOfQuestionsButton);
        listOfQuestionsButton.setOnClickListener( new View.OnClickListener(){
            /**
             *
             * Generate the activity_question_list
             */
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, QuestionListActivity.class);
                intent.putExtra("questions", factoryQuestion.setAllQuestion("level"));
                startActivity(intent);
            }
        });

        Button aboutButton = findViewById(R.id.aboutButton);
        aboutButton.setOnClickListener(new View.OnClickListener() {
            /**
             *
             * Generate the activity_about
             */
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     *
     * @param type is equal to the type of music choose
     * @param number is equal of the numbers of desired question
     * @return Arraylist of questions and response
     */
    public ArrayList<Question> setQuestion(String type, int number){
        return factoryQuestion.setQuestion(type,number);
    }

    /**
     *
     * @param list of difficulties available
     * @param position of the choices
     */
    @Override
    public void onPositiveButtonClicked(String[] list, int position) {
        this.level = list[position];
        if (!this.level.equals("canceled")){
            Intent intent = new Intent(MainActivity.this, ChoiceActivity.class);
            intent.putExtra("level", this.level);
            startActivity(intent);
        }
    }

    /**
     * canceled the choice of level
     */
    @Override
    public void onNegativeButtonClicked() {
        this.level = "canceled";
    }
}