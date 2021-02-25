package com.g2.musique;

import android.content.res.AssetManager;
import android.os.Handler;
import android.util.Log;


import androidx.collection.ArraySet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * Contains all the questions
 * @class FactoryQuestion
 */

public class FactoryQuestion {

    public static final String STANDARD = "standard";
    public static final String MANGA = "manga";
    public static final String DISCO = "disco";
    private Map<String, ArrayList<Question>> questionsMap = new HashMap<>();
    private ArrayList<Question> questionsListBasic = new ArrayList<Question>();
    private String theme;


    /**
     *
     * @param type is equal to the type of music choose
     * @param numberOfQuestion is equal of the numbers of desired question
     * @return ArrayList of questions and response
     */
    public ArrayList<Question> setQuestion(String type, int numberOfQuestion) throws IOException {
        Log.i("finale2", "dans Thread");
        Threadtest logine = new Threadtest();
        logine.setTheme(type);
        logine.start();
        while(logine.isAlive()){
            try {
                logine.sleep(10); // fonctionne aussi bien sans cette tempo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            questionsListBasic = logine.getQuestionsListBasic();
        }

        Collections.shuffle(questionsListBasic);

        if (numberOfQuestion < questionsListBasic.size())
        {
            int test = questionsListBasic.size() - numberOfQuestion;
            for (int i=0; i < test; ++i){
                questionsListBasic.remove(questionsListBasic.size() -1);
            }
        }
        Log.i("finale2", String.valueOf(questionsListBasic));
        return questionsListBasic;
    }

    private void loadRatesFromApi(String theme) {

    }

    /**
     *
     * @return Arraylist of all the questions
     */
    public ArrayList<Question> setAllQuestion() throws IOException {
        Threadtest logine = new Threadtest();
        logine.start();
        while(logine.isAlive()){
            try {
                logine.sleep(10); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            questionsListBasic = logine.getQuestionsListBasic();
        }
        Log.i("questionsList", String.valueOf(questionsListBasic));
        return questionsListBasic;
    }
}



