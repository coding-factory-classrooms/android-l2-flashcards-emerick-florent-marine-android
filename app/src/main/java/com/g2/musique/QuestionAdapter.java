package com.g2.musique;

import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {

    private ArrayList<Question> questionList;

    public QuestionAdapter(ArrayList<Question> questions) {
        this.questionList = questions;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_question, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Question question = (Question) questionList.get(position);
        holder.image.setImageResource(R.drawable.sound_image);
        String answer = "";
        Log.i("test", String.valueOf(question));
        List<String> allAnswer = question.getAllAnswer();
        Log.i("adapter", String.valueOf(allAnswer));
        for (int i = 0; i < allAnswer.size(); i++)
        {
            answer += allAnswer.get(i);
            if (i < (allAnswer.size() - 1))
                answer += " - ";
        }
        holder.answer.setText(answer);
        holder.level.setText(question.getlevel());
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView image;
        final TextView answer;
        final TextView level;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.imageView);
            answer = itemView.findViewById(R.id.answerTextView);
            level = itemView.findViewById(R.id.levelTextView);
        }
    }

}
