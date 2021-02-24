package com.g2.musique;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Question implements Parcelable {

    private int musiqueId;
    private String rightAnswer;
    private String[] badAnswer;
    private String level;
    private String genre;

    public Question(int musiqueId, String rightAnswer, String[] badAnswer, String level, String genre) {
        this.musiqueId = musiqueId;
        this.rightAnswer = rightAnswer;
        this.badAnswer = badAnswer;
        this.level = level;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Question{" +
                "musiqueId=" + musiqueId +
                ", rightAnswer='" + rightAnswer + '\'' +
                ", badAnswer=" + Arrays.toString(badAnswer) +
                ", level='" + level + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }

    public String getGenre() {
        return genre;
    }

    public int getMusiqueId() {
        return musiqueId;
    }

    public String getLevel(){
        return level;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public String[] getBadAnswer() {
        return badAnswer;
    }

    public ArrayList<String> getAllAnswer()
    {
        ArrayList<String> allAnswer = new ArrayList<String>(Arrays.asList(this.badAnswer));
        allAnswer.add(this.rightAnswer);
        Collections.shuffle(allAnswer);
        return allAnswer;
    }

    protected Question(Parcel in) {
        musiqueId = in.readInt();
        rightAnswer = in.readString();
        badAnswer = in.createStringArray();
        level = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(musiqueId);
        dest.writeString(rightAnswer);
        dest.writeStringArray(badAnswer);
        dest.writeString(level);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };


}
