package com.g2.musique;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

class Threadtest extends Thread{
    public int responseCode = 0;
    private String theme = "";
    public String responseString = "";
    private OkHttpClient client = new OkHttpClient();
    private String url = "http://gryt.tech:8080/spotifyblindtest/";
    private String urlTheme = "http://gryt.tech:8080/spotifyblindtest/?theme=";
    private ArrayList<Question> questionsListBasic = new ArrayList<Question>();

    @Override
    public void run() {
        try {
            Request request = null;
            // Build the request
            if (theme.isEmpty()) {
                request = new Request.Builder()
                        .url(url)
                        .build();
            }
            else
            {
                request = new Request.Builder()
                        .url(urlTheme + theme)
                        .build();
            }
            Response responses = null;

            // Reset the response code
            responseCode = 0;

            // Make the request
            responses = client.newCall(request).execute();

            if ((responseCode = responses.code()) == 200) {
                String body = responses.body().string();
                try {
                    JSONArray jsonArray = new JSONArray(body);

                    for (int i=0; i < jsonArray.length(); ++i)
                    {
                        ArrayList<String> stringBadAnswer = new ArrayList<String>();
                        JSONObject data =  jsonArray.getJSONObject(i);
                        JSONArray objectBadAnswer =  data.getJSONArray("bad_Answer");
                        for (int o = 0 ; o < objectBadAnswer.length(); ++o)
                        {
                            stringBadAnswer.add(objectBadAnswer.getString(o));
                        }
                        questionsListBasic.add(new Question(data.getString("filename").split("\\.")[0],data.getString("right_Answer"), stringBadAnswer));

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            responseString = e.toString();
        }
    }

    public ArrayList<Question> getQuestionsListBasic() {
        return questionsListBasic;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
